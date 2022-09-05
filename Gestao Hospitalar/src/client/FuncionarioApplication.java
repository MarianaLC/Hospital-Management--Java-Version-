package client;

import config.Configurations;
import data.exceptions.*;
import health.FuncionarioInterface;

import java.io.IOException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.HashMap;

public class FuncionarioApplication {
    private static FuncionarioInterface service = null;

    public static void main(String[] args) throws IOException, NotBoundException, LoginGPCNaoExiste, EnfermeiroNaoExiste, UtenteNaoExiste, MedicamentoNaoExiste, OutroArtigoNaoExiste, AtoMedicoJaExiste, MedicoNaoExiste, AtoEnfermagemJaExiste {

        service = (FuncionarioInterface) Naming.lookup(Configurations.rmiServiceLocation);

        HashMap<Integer,Integer> lista_artigos1 = new HashMap<>();
        lista_artigos1.put(1,2);

        HashMap<Integer,Integer> lista_medicamentos1 = new HashMap<>();
        lista_medicamentos1.put(2,3);
        LocalDateTime d1= LocalDateTime.of(2017, Month.APRIL,9,17,30);

        System.out.printf(service.getEnfermeiroInfo("PT741474147", "PT248569789", "pokemon1"  ));
        service.criaAtoMedico(1, "PT248569789","903006570", d1, lista_artigos1, lista_medicamentos1, "PT248569789","pokemon1");

        HashMap<Integer,Integer> lista_artigos2 = new HashMap<>();
        lista_artigos1.put(2,2);

        HashMap<Integer,Integer> lista_medicamentos2 = new HashMap<>();
        lista_medicamentos1.put(3,1);
        LocalDateTime d2= LocalDateTime.of(2017, Month.APRIL,9,20,30);

        service.criaAtoMedico(2, "PT123856987","994944908", d2, lista_artigos2, lista_medicamentos2, "PT123856987","digimon3");

        HashMap<Integer,Integer> lista_artigos3 = new HashMap<>();
        lista_artigos1.put(2,1);

        HashMap<Integer,Integer> lista_medicamentos3 = new HashMap<>();
        lista_medicamentos1.put(1,3);
        LocalDateTime d3= LocalDateTime.of(2018, Month.APRIL,9,20,30);

        service.criaAtoMedico(3, "PT456410784","887782481", d3, lista_artigos3, lista_medicamentos3, "PT456410784","rdjr");

        HashMap<Integer,Integer> lista_artigos5 = new HashMap<>();
        lista_artigos1.put(3,1);

        HashMap<Integer,Integer> lista_medicamentos5 = new HashMap<>();
        lista_medicamentos1.put(6,2);
        LocalDateTime d4= LocalDateTime.of(2017, Month.JANUARY,9,20,30);

        service.criaAtoMedico(4, "PT456410784","829516735", d4, lista_artigos5, lista_medicamentos5, "PT456410784","rdjr");

        HashMap<Integer,Integer> lista_artigos4 = new HashMap<>();
        lista_artigos4.put(4,1);
        LocalDateTime d5= LocalDateTime.of(2017, Month.JANUARY,9,12,30);

        service.criaAtoEnfermagem(1, "PT741474147","887782481", d5, lista_artigos4, "PT741474147","ola");

        HashMap<Integer,Integer> lista_artigos6 = new HashMap<>();
        lista_artigos5.put(6,2);
        LocalDateTime d6= LocalDateTime.of(2017, Month.FEBRUARY,9,12,30);

        service.criaAtoEnfermagem(2, "PT111111178","122960061", d6, lista_artigos6, "PT111111178","adeus");

        HashMap<Integer,Integer> lista_artigos7 = new HashMap<>();
        lista_artigos7.put(2,1);
        LocalDateTime d7= LocalDateTime.of(2017, Month.FEBRUARY,11,12,30);

        service.criaAtoEnfermagem(3, "PT747474747","605334715", d7, lista_artigos7, "PT479510023","porcos");

        System.out.println("-------------------------------------------------------------------------------------------");
        System.out.println("DADOS ESTATISTICOS");
        System.out.println("\n Medicamentos mais utilizados em atos médicos");
        System.out.println(service.medicamentosMaisUtilizadosAtosMedicos("PT456410784","rdjr"));
        System.out.println("\n Medicamentos mais utilizados em atos médicos");
        System.out.println(service.artigosMaisUtilizadosAtosEnfermagem("PT741474147","ola"));
        System.out.println(service.procuraMedicoEspecialidade("Cardiologia", "PT741474147", "ola"));
        System.out.println("-------------------------------------------------------------------------------------------");
    }
}

