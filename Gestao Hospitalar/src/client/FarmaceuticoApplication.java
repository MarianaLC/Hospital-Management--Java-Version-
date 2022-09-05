package client;

import config.Configurations;
import data.exceptions.*;
import health.FarmaceuticoInterfaceGLM;
import health.FarmaceuticoInterfaceGPC;

import java.io.IOException;
import java.rmi.Naming;
import java.rmi.NotBoundException;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.HashMap;

public class FarmaceuticoApplication {
    private static FarmaceuticoInterfaceGLM service = null;
    private static FarmaceuticoInterfaceGPC service1 = null;

    public static void main(String[] args) throws IOException, NotBoundException, AtoFarmaceuticoJaExiste, FarmaceuticoNaoExiste, MedicamentoNaoExiste, OutroArtigoNaoExiste, LoginGLMNaoExiste {
        service = (FarmaceuticoInterfaceGLM) Naming.lookup(Configurations.rmiServiceLocation);

        HashMap<Integer,Integer> lista_artigos8 = new HashMap<>();
        lista_artigos8.put(10,2);

        HashMap<Integer,Integer> lista_medicamentos8 = new HashMap<>();
        lista_medicamentos8.put(11,3);

        LocalDateTime d1= LocalDateTime.of(2017, Month.APRIL,9,17,30);
        service.criaAtoFarmaceutico(50, "PT411144400",d1, lista_artigos8, lista_medicamentos8, "PT411144400", "milinha71");

        HashMap<Integer,Integer> lista_artigos9 = new HashMap<>();
        lista_artigos9.put(2,2);
        HashMap<Integer,Integer> lista_medicamentos9 = new HashMap<>();
        lista_medicamentos9.put(3,1);

        LocalDateTime d2= LocalDateTime.of(2017, Month.APRIL,9,20,30);
        service.criaAtoFarmaceutico(51, "PT441035998",d2, lista_artigos9, lista_medicamentos9, "PT441035998", "gardevoir44");

        HashMap<Integer,Integer> lista_artigos10 = new HashMap<>();
        lista_artigos10.put(2,1);

        HashMap<Integer,Integer> lista_medicamentos10 = new HashMap<>();
        lista_medicamentos10.put(1,3);

        LocalDateTime d3= LocalDateTime.of(2018, Month.APRIL,9,20,30);
        service.criaAtoFarmaceutico(52, "PT475344110",d3, lista_artigos10, lista_medicamentos10, "PT475344110","quimjolas");

        HashMap<Integer,Integer> lista_artigos11 = new HashMap<>();
        lista_artigos11.put(3,1);

        HashMap<Integer,Integer> lista_medicamentos11 = new HashMap<>();
        lista_medicamentos11.put(6,2);

        LocalDateTime d4= LocalDateTime.of(2017, Month.JANUARY,9,20,30);
        service.criaAtoFarmaceutico(53, "PT987412478",d4, lista_artigos11, lista_medicamentos11, "PT987412478","pasteldenata4");

        HashMap<Integer,Integer> lista_artigos12 = new HashMap<>();
        lista_artigos12.put(4,1);

        HashMap<Integer,Integer> lista_medicamentos12 = new HashMap<>();
        LocalDateTime d5= LocalDateTime.of(2017, Month.JANUARY,9,12,30);
        service.criaAtoFarmaceutico(54, "PT411144400",d5, lista_artigos12, lista_medicamentos12, "PT411144400","milinha71");

        System.out.println("\nALERTA STOCK");
        service.AlertaArtigos("PT441857998","basta09");
        service.AlertaMedicamentos("PT475344110","quimjolas");

        System.out.println("-------------------------------------------------------------------------------------------");
        System.out.println("DADOS ESTATISTICOS");

        System.out.println("\n Medicamentos mais utilizados em atos farmacêuticos");
        System.out.println(service.medicamentosMaisUtilizadosAtosFarmaceuticos("PT475344110","quimjolas"));
        System.out.println("\n Artigos mais utilizados em atos farmacêuticos");
        System.out.println(service.artigosMaisUtilizadosAtosFarmaceuticos("PT475344110","quimjolas"));
        System.out.println("\n Atos Farmacêuticos que utilizaram mais medicamentos");
        System.out.println(service.atosFarmaceuticosMaisMedicamentos("PT475344110","quimjolas"));
        System.out.println("\n Atos Farmacêuticos que utilizaram mais artigos");
        System.out.println(service.atosFarmaceuticosMaisArtigos("PT475344110","quimjolas"));
        System.out.println("-------------------------------------------------------------------------------------------");

        service.save();
    }
}
