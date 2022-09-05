package health;

import data.entidades.AtoFarmaceutico;
import data.entidades.Farmaceutico;
import data.entidades.Medico;
import data.exceptions.*;

import java.io.IOException;
import java.io.Serializable;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public interface FarmaceuticoInterfaceGLM extends Remote {

    void save() throws IOException, NotBoundException;

    public void criaFornecedor(int id, String nome, String nifuser, String pass) throws FornecedorJaExiste, LoginGLMNaoExiste, RemoteException;

    public String getFornecedorInfo(int id, String nome, String nifuser, String pass) throws FornecedorNaoExiste, LoginGLMJaExiste, RemoteException;

    public void AlterarNomeFornecedor(int id, String nome, String nifuser, String pass) throws FornecedorNaoExiste, LoginGLMJaExiste, RemoteException;

    public void AlterarIdFornecedor(int id0, int id1, String nifuser, String pass) throws FornecedorNaoExiste, LoginGLMJaExiste, RemoteException;

    public String procuraFornecedorId(int id, String nifuser, String pass) throws FornecedorNaoExiste, LoginGLMJaExiste, RemoteException;

    public String procuraFornecedorNome(String nome, String nifuser, String pass) throws FornecedorNaoExiste, LoginGLMJaExiste, RemoteException;

    public void removeFornecedor(int id, String nifuser, String pass) throws FornecedorNaoExiste, LoginGLMJaExiste, RemoteException;

    public void criaAtoFarmaceutico(int id, String niffarmaceutico, LocalDateTime h, HashMap<Integer, Integer> lista_artigos, HashMap<Integer, Integer> lista_medicamentos, String nifuser, String pass)
            throws FarmaceuticoNaoExiste, AtoFarmaceuticoJaExiste, MedicamentoNaoExiste, OutroArtigoNaoExiste, LoginGLMNaoExiste, RemoteException;

    public void alteraIDAtoFarmaceutico(int oldID, int newID, String nifuser, String pass) throws AtoFarmaceuticoJaExiste, LoginGLMNaoExiste, RemoteException;

    public void alteraFarmaceuticoAtoFarmaceutico(int idAto, Farmaceutico f, String nifuser, String pass) throws AtoFarmaceuticoNaoExiste, LoginGLMNaoExiste, RemoteException;

    public void alteraHoraAtoFarmaceutico(int idAto, LocalDateTime newHora, String nifuser, String pass) throws AtoFarmaceuticoNaoExiste, LoginGLMNaoExiste, RemoteException;

    public void alteraIDlistaArtigosAtoFarmaceutico(int idAto, int oldID, int newID, String nifuser, String pass) throws AtoFarmaceuticoNaoExiste, LoginGLMNaoExiste, RemoteException;

    public void alteraQuantidadelistaArtigosAtoFarmaceutico(int idAto, int idArtigo, int newQuant, String nifuser, String pass) throws AtoFarmaceuticoNaoExiste, LoginGLMNaoExiste, RemoteException;

    public void alteraIDlistaMedicamentosAtoFarmaceutico(int idAto, int oldID, int newID, String nifuser, String pass) throws AtoFarmaceuticoNaoExiste, LoginGLMNaoExiste, RemoteException;

    public void alteraQuantidadelistaMedicamentosAtoFarmaceutico(int idAto, int idMedicamento, int newQuant, String nifuser, String pass) throws AtoFarmaceuticoNaoExiste, LoginGLMNaoExiste, RemoteException;

    public AtoFarmaceutico procuraAtoFarmaceuticoID(int idAto, String nifuser, String pass) throws AtoFarmaceuticoNaoExiste, LoginGLMNaoExiste, RemoteException;

    public HashMap<Integer, AtoFarmaceutico> procuraAtoFarmaceuticoFarmaceutico(String nif, String nifuser, String pass) throws FarmaceuticoNaoExiste, LoginGLMNaoExiste, RemoteException;

    public HashMap<Integer, AtoFarmaceutico> procuraAtoFarmaceuticoHora(LocalDateTime h, String nifuser, String pass) throws LoginGLMNaoExiste, RemoteException;

    public HashMap<Integer, AtoFarmaceutico> procuraAtoFarmaceuticoArtigo(int idArt, String nifuser, String pass) throws LoginGLMNaoExiste, RemoteException;

    public HashMap<Integer, AtoFarmaceutico> procuraAtoFarmaceuticoMedicamento(int idMed, String nifuser, String pass) throws LoginGLMNaoExiste, RemoteException;

    public String ConsultaArtigos(String nifuser, String pass) throws LoginGLMNaoExiste, RemoteException;

    public String ConsultaMedicamentos(String nifuser, String pass) throws LoginGLMNaoExiste, RemoteException;

    public String ConsultaAquisicoesArtigos(String nifuser, String pass) throws LoginGLMNaoExiste, RemoteException;

    public String ConsultaAquisicoesMedicamentos(String nifuser, String pass) throws LoginGLMNaoExiste, RemoteException;

    public String ConsultaConsumosArtigos(String nifuser, String pass) throws LoginGLMNaoExiste, RemoteException;

    public String ConsultaConsumosMedicamentos(String nifuser, String pass) throws LoginGLMNaoExiste, RemoteException;

    public String AlertaArtigos(String nifuser, String pass) throws LoginGLMNaoExiste, RemoteException;

    public String AlertaMedicamentos(String nifuser, String pass) throws LoginGLMNaoExiste, RemoteException;

    public void criaLoginGLM(String nif0, String pass0, String nif1, String pass1) throws LoginGLMJaExiste, LoginGLMNaoExiste, RemoteException;

    public String getLoginGLMInfo(String nif0, String nif1, String pass1) throws LoginGPCNaoExiste, RemoteException;

    public void AlterarNifLoginGLM(String nif0, String nifnovo, String nif1, String pass1) throws LoginGLMNaoExiste, RemoteException;

    public void AlterarPassLoginGLM(String nif0, String passnova, String nif1, String pass1) throws LoginGLMNaoExiste, RemoteException;

    public String procuraLoginGLMNif(String nif0, String nif1, String pass1) throws LoginGLMNaoExiste, RemoteException;

    public void removeLoginGLM(String nif0, String nif1, String pass1) throws LoginGLMNaoExiste, RemoteException;

    public String medicamentosMaisUtilizadosAtosFarmaceuticos(String nifuser, String pass) throws LoginGLMNaoExiste, RemoteException;

    public HashMap<Integer, Integer> artigosMaisUtilizadosAtosFarmaceuticos(String nifuser, String pass) throws LoginGLMNaoExiste, RemoteException;

    public HashMap<Integer, AtoFarmaceutico> listaAtoFarmaceutico(String nif, String nifuser, String pass) throws FarmaceuticoNaoExiste, LoginGLMNaoExiste, RemoteException;

    public HashMap<Integer, AtoFarmaceutico> listaAtoFarmaceuticoArtigo(int idArt, String nifuser, String pass) throws LoginGLMNaoExiste, RemoteException;

    public HashMap<Integer, AtoFarmaceutico> listaAtoFarmaceuticoMedicamento(int idMed, String nifuser, String pass) throws LoginGLMNaoExiste, RemoteException;

    public HashMap<Integer, Integer> atosFarmaceuticosMaisMedicamentos(String nifuser, String pass) throws LoginGLMNaoExiste, RemoteException;

    public HashMap<Integer, Integer> atosFarmaceuticosMaisArtigos(String nifuser, String pass) throws LoginGLMNaoExiste, RemoteException;

    public HashMap<Integer, Integer> fornecedoresMaisArtigosDif(String nifuser, String pass) throws LoginGLMNaoExiste, RemoteException;

    public HashMap<Integer, Integer> fornecedoresMaisMedicamentosDif(String nifuser, String pass) throws LoginGLMNaoExiste, RemoteException;

    public HashMap<Integer, Integer> fornecedoresMaisArtigos(String nifuser, String pass) throws LoginGLMNaoExiste, RemoteException;

    public HashMap<Integer, Integer> fornecedoresMaisMedicamentos(String nifuser, String pass) throws LoginGLMNaoExiste, RemoteException;
}