package server;

import config.Configurations;
import health.HealthService;

import progs.GestorGPC;


import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ApplicationServer {
    public static void main(String[] args) throws RemoteException {

        GestorGPC gestorGPC = new GestorGPC();

        try {
            // carregamento de dados
            gestorGPC = gestorGPC.load_from(Configurations.database1);


        } catch (IOException e) {
            System.out.println("Ficheiro de dados não encontrado!");
            System.out.println("Pode executar o initGestor para povoar os dados.");

            // inicializando os gestores sem dados
            gestorGPC = new GestorGPC();


        } catch (Exception e) {
            // inicializando os gestores sem dados
            System.out.println(e);
            e.printStackTrace();
            gestorGPC = new GestorGPC();
        }

        System.out.println("\n Iniciando o servidor com:");
        System.out.println("Medicos - " + gestorGPC.getMedicos().size());
        System.out.println("Enfermeiros - " + gestorGPC.getEnfermeiros().size());
        System.out.println("Utentes - " + gestorGPC.getUtentes().size());
        System.out.println("PassGPC - " + gestorGPC.getLoginGPC().size());
        System.out.println("PassUtentes - " + gestorGPC.getLoginUtentes().size());

        System.out.println("PassGLM - " + gestorGPC.getLoginGLM().size());

        System.out.println("Farmaceuticos - " + gestorGPC.getFarmaceuticos().size());
        System.out.println("Fornecedores - " + gestorGPC.getFornecedores().size());
        System.out.println("Medicamentos - " + gestorGPC.getMedicamentos().size());
        System.out.println("Farmaceuticos - " + gestorGPC.getFarmaceuticos().size());
        System.out.println("Outros Artigos - " + gestorGPC.getOutrosartigos().size());

        // inicializando servico
        var service1 = new HealthService(gestorGPC);

        // inicializando servidor RMI
        Registry registry = LocateRegistry.createRegistry(Configurations.rmiPort);
        registry.rebind(Configurations.rmiService, service1);
        System.out.println(" \nServidor pronto!");
    }
}


