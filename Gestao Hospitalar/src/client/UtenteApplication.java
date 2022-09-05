package client;

import config.Configurations;
import data.exceptions.LoginUtenteNaoExiste;
import data.exceptions.UtenteNaoExiste;
import health.UtenteInterface;

import java.io.IOException;
import java.rmi.Naming;
import java.rmi.NotBoundException;


public class UtenteApplication {
    private static UtenteInterface service = null;

    public static void main(String[] args) throws IOException, NotBoundException, UtenteNaoExiste, LoginUtenteNaoExiste {

        service = (UtenteInterface) Naming.lookup(Configurations.rmiServiceLocation);

        System.out.println("\nInformação do utente");
        System.out.println(service.getUtenteInfo("767537771", "767537771", "amg4ever"));

        System.out.println("\n Procurar utente pelo seu NIF: ");
        System.out.println(service.procuraUtenteNif("402876020", "402876020", "08/01/21"));

        System.out.println("\n Procurar utente pelo seu BI: ");
        System.out.println(service.procuraUtenteBi("8084120","903006570","caoderua420"));

        System.out.println("\n Procurar utente pelo seu Nome: ");
        System.out.println(service.procuraUtenteNome("Roque Loredo","903006570","caoderua420"));

        System.out.println("\n Procurar utente pela sua Morada: ");
        System.out.println(service.procuraUtenteMorada("Baltaria", "903006570","caoderua420"));

        System.out.println("\n Procurar utente pelo seu Código postal: ");
        System.out.println(service.procuraUtenteCodigo("9206-325", "887782481","gatobravo88"));

        System.out.println("\n A pass do Login do utente: ");
        System.out.println(service.getLoginUtenteInfo("903006570", "903006570","caoderua420"));

        service.save();
    }
}

