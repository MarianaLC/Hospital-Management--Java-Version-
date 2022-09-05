package config;

import java.io.File;

public class Configurations {
    //RMI configurations
    public static Integer rmiPort = 1099;
    public static String rmiService = "health";
    public static String rmiServiceLocation = "rmi://localhost:" + rmiPort + "/" + rmiService;

    //Data configurations
    public static String dataLocation = "C:\\Users\\maria\\Downloads\\Gestao Hospitalar\\src\\data\\";

    //Data configurations GPC
    public static String database1 = dataLocation + "povoamento\\database1.dat";
    public static String listaMedicos = dataLocation + "povoamento\\medicos.txt";
    public static String listaUtentes = dataLocation + "povoamento\\utentes.txt";
    public static String listaEnfermeiros = dataLocation + "povoamento\\enfermeiros.txt";
    public static String listaPassGPC = dataLocation + "povoamento\\PassGPC.txt";
    public static String listaPassUtentes = dataLocation + "povoamento\\PassUtente.txt";

    //Data configurations GLM
    //public static String database2 = dataLocation + "povoamento\\database2.dat";
    public static String listaPassGLM = dataLocation + "povoamento\\PassGLM.txt";

    //Data configurations Operacoes
    //public static String database3 = dataLocation + "povoamento\\database3.dat";
    public static String listaFornecedores = dataLocation + "povoamento\\fornecedor.txt";
    public static String listaFarmaceuticos = dataLocation + "povoamento\\farmaceuticos.txt";
    public static String listaOutrosArtigos = dataLocation + "povoamento\\outrosartigos.txt";
    public static String listaMeds = dataLocation + "povoamento\\lista_infomed.csv";

}
