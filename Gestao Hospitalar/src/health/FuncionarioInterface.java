package health;

import data.exceptions.*;
import data.entidades.*;

import java.io.IOException;
import java.io.Serializable;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public interface FuncionarioInterface extends Remote {

    void save() throws IOException, NotBoundException;

    public void criaUtenteGPC(String nome, String bi, String nif, String morada, String codigo_postal, String nifuser, String pass) throws
            UtenteJaExiste, LoginGPCNaoExiste, RemoteException;

    public String getUtenteInfoGPC(String nif,String nifuser,String pass) throws UtenteNaoExiste, LoginGPCNaoExiste, RemoteException;

    public void AlterarNomeUtenteGPC(String nif, String nome,String nifuser,String pass) throws UtenteNaoExiste, LoginGPCNaoExiste, RemoteException;

    public void AlterarBiUtenteGPC(String nif, String bi,String nifuser,String pass) throws UtenteNaoExiste, LoginGPCNaoExiste, RemoteException;

    public void AlterarNifUtenteGPC(String nif0, String nif1, String nifuser, String pass) throws UtenteNaoExiste, LoginGPCNaoExiste, RemoteException;

    public void AlterarMoradaUtenteGPC(String nif, String morada,String nifuser, String pass) throws UtenteNaoExiste, LoginGPCNaoExiste, RemoteException;

    public void AlterarCodigoUtenteGPC(String nif, String codigo_postal, String nifuser, String pass) throws UtenteNaoExiste, LoginGPCNaoExiste, RemoteException;

    public String procuraUtenteNifGPC(String nif,String nifuser, String pass) throws UtenteNaoExiste, LoginGPCNaoExiste, RemoteException;

    public String procuraUtenteBiGPC(String bi,String nifuser, String pass) throws UtenteNaoExiste, LoginGPCNaoExiste, RemoteException;

    public String procuraUtenteNomeGPC(String nome,String nifuser, String pass) throws UtenteNaoExiste, LoginGPCNaoExiste, RemoteException;

    public String procuraUtenteMoradaGPC(String morada, String nifuser, String pass) throws UtenteNaoExiste, LoginGPCNaoExiste, RemoteException;

    public String procuraUtenteCodigoGPC(String codigo_postal, String nifuser, String pass) throws UtenteNaoExiste, LoginGPCNaoExiste, RemoteException;

    public void removeUtenteGPC(String nif, String nifuser, String pass) throws UtenteNaoExiste, LoginGPCNaoExiste, RemoteException;

    public void criaMedico(String nome, String bi, String nif, String morada, String codigo_postal, String especialidade, String cedula, String nifuser, String pass)
            throws MedicoJaExiste, LoginGPCNaoExiste, RemoteException;

    public String getMedicoInfo(String nif, String nifuser, String pass) throws MedicoNaoExiste, LoginGPCNaoExiste, RemoteException;

    public void AlterarNomeMedico(String nif, String nome, String nifuser, String pass) throws MedicoNaoExiste, LoginGPCNaoExiste, RemoteException;

    public void AlterarBiMedico(String nif, String bi, String nifuser, String pass) throws MedicoNaoExiste, LoginGPCNaoExiste, RemoteException;

    public void AlterarNifMedico(String nif0, String nif1, String nifuser, String pass) throws MedicoNaoExiste, LoginGPCNaoExiste, RemoteException;

    public void AlterarMoradaMedico(String nif, String morada, String nifuser, String pass) throws MedicoNaoExiste, LoginGPCNaoExiste, RemoteException;

    public void AlterarCodigoMedico(String nif, String codigo_postal, String nifuser, String pass) throws MedicoNaoExiste, LoginGPCNaoExiste, RemoteException;

    public void AlterarEspecialidadeMedico(String nif, String especialidade, String nifuser, String pass) throws MedicoNaoExiste, LoginGPCNaoExiste, RemoteException;

    public void AlterarCedulaMedico(String nif, String cedula, String nifuser, String pass) throws MedicoNaoExiste, LoginGPCNaoExiste, RemoteException;

    public String procuraMedicoNif(String nif,String nifuser, String pass) throws MedicoNaoExiste, LoginGPCNaoExiste, RemoteException;

    public String procuraMedicoBi(String bi, String nifuser, String pass) throws MedicoNaoExiste, LoginGPCNaoExiste, RemoteException;

    public String procuraMedicosNome(String nome, String nifuser, String pass) throws MedicoNaoExiste, LoginGPCNaoExiste, RemoteException;

    public String procuraMedicoMorada(String morada, String nifuser, String pass) throws MedicoNaoExiste, LoginGPCNaoExiste, RemoteException;

    public String procuraMedicoCodigo(String codigo_postal, String nifuser, String pass) throws MedicoNaoExiste, LoginGPCNaoExiste, RemoteException;

    public String procuraMedicoEspecialidade(String especialidade, String nifuser, String pass) throws MedicoNaoExiste, LoginGPCNaoExiste, RemoteException;

    public String procuraMedicoCedula(String cedula, String nifuser, String pass) throws MedicoNaoExiste, LoginGPCNaoExiste, RemoteException;

    public void removeMedico(String nif, String nifuser, String pass) throws MedicoNaoExiste, LoginGPCNaoExiste, RemoteException;

    public void criaEnfermeiro(String nome, String bi, String nif, String morada, String codigo_postal, String especialidade, String nifuser, String pass)
            throws EnfermeiroJaExiste, LoginGPCNaoExiste, RemoteException;

    public String getEnfermeiroInfo(String nif, String nifuser, String pass) throws EnfermeiroNaoExiste, LoginGPCNaoExiste, RemoteException;

    public void AlterarNomeEnfermeiro(String nif, String nome, String nifuser, String pass) throws EnfermeiroNaoExiste, LoginGPCNaoExiste, RemoteException;

    public void AlterarBiEnfermeiro(String nif, String bi, String nifuser, String pass) throws EnfermeiroNaoExiste, LoginGPCNaoExiste, RemoteException;

    public void AlterarNifEnfermeiro(String nif0, String nif1,String nifuser, String pass) throws EnfermeiroNaoExiste, LoginGPCNaoExiste, RemoteException;

    public void AlterarMoradaEnfermeiro(String nif, String morada, String nifuser, String pass) throws EnfermeiroNaoExiste, LoginGPCNaoExiste, RemoteException;

    public void AlterarCodigoEnfermeiro(String nif, String codigo_postal, String nifuser, String pass) throws EnfermeiroNaoExiste, LoginGPCNaoExiste, RemoteException;

    public void AlterarEspecialidadeEnfermeiro(String nif, String especialidade, String nifuser, String pass) throws EnfermeiroNaoExiste, LoginGPCNaoExiste, RemoteException;

    public String procuraEnfermeiroNif(String nif, String nifuser, String pass) throws EnfermeiroNaoExiste, LoginGPCNaoExiste, RemoteException;

    public String procuraEnfermeiroBi(String bi, String nifuser, String pass) throws EnfermeiroNaoExiste, LoginGPCNaoExiste, RemoteException;

    public String procuraEnfermeiroNome(String nome, String nifuser, String pass) throws EnfermeiroNaoExiste, LoginGPCNaoExiste, RemoteException;

    public String procuraEnfermeiroMorada(String morada, String nifuser, String pass) throws EnfermeiroNaoExiste, LoginGPCNaoExiste, RemoteException;

    public String procuraEnfermeiroCodigo(String codigo_postal, String nifuser, String pass) throws EnfermeiroNaoExiste, LoginGPCNaoExiste, RemoteException;

    public String procuraEnfermeiroEspecialidade(String especialidade, String nifuser, String pass) throws EnfermeiroNaoExiste, LoginGPCNaoExiste, RemoteException;

    public void removeEnfermeiro(String nif, String nifuser, String pass) throws EnfermeiroNaoExiste, LoginGPCNaoExiste, RemoteException;

    public void criaAtoMedico(int id, String nifmedico, String nifutente, LocalDateTime h, HashMap< Integer, Integer> lista_artigos, HashMap<Integer, Integer> lista_medicamentos, String nifuser, String pass)
            throws MedicoNaoExiste, UtenteNaoExiste, AtoMedicoJaExiste, MedicamentoNaoExiste, OutroArtigoNaoExiste, LoginGPCNaoExiste, RemoteException;

    public void alteraIDAtoMedico(int oldID, int newID, String nifuser, String pass) throws AtoMedicoJaExiste, LoginGPCNaoExiste, RemoteException;

    public void alteraUtenteAtoMedico(int idAto, Utente u, String nifuser, String pass) throws AtoMedicoNaoExiste, LoginGPCNaoExiste, RemoteException;

    public void alteraMedicoAtoMedico(int idAto, Medico m, String nifuser, String pass) throws AtoMedicoNaoExiste, LoginGPCNaoExiste, RemoteException;

    public void alteraHoraAtoMedico(int idAto, LocalDateTime newHora, String nifuser, String pass) throws AtoMedicoNaoExiste, LoginGPCNaoExiste, RemoteException;

    public void alteraIDlistaArtigosAtoMedico(int idAto, int oldID, int newID, String nifuser, String pass) throws AtoMedicoNaoExiste, LoginGPCNaoExiste, RemoteException;

    public void alteraQuantidadelistaArtigosAtoMedico(int idAto, int idArtigo, int newQuant, String nifuser, String pass) throws AtoMedicoNaoExiste, LoginGPCNaoExiste, RemoteException;

    public void alteraIDlistaMedicamentosAtoMedico(int idAto, int oldID, int newID, String nifuser, String pass) throws AtoMedicoNaoExiste, LoginGPCNaoExiste, RemoteException;

    public void alteraQuantidadelistaMedicamentosAtoMedico(int idAto, int idMedicamento, int newQuant, String nifuser, String pass) throws AtoMedicoNaoExiste, LoginGPCNaoExiste, RemoteException;

    public AtoMedico procuraAtoMedicoID(int idAto, String nifu, String nifuser, String pass) throws AtoMedicoNaoExiste, LoginGPCNaoExiste, RemoteException;

    public HashMap<Integer, AtoMedico> procuraAtoMedicoUtente(String nif, String nifuser, String pass) throws UtenteNaoExiste, LoginGPCNaoExiste, RemoteException;

    public HashMap<Integer, AtoMedico> procuraAtoMedicoMedico(String nif, String nifuser, String pass) throws MedicoNaoExiste, LoginGPCNaoExiste, RemoteException;

    public HashMap<Integer, AtoMedico> procuraAtoMedicoHora(LocalDateTime h, String nifuser, String pass) throws LoginGPCNaoExiste, RemoteException;

    public HashMap<Integer, AtoMedico> procuraAtoMedicoArtigo(int idArt, String nifuser, String pass) throws LoginGPCNaoExiste, RemoteException;

    public HashMap<Integer, AtoMedico> procuraAtoMedicoMedicamento(int idMed, String nifuser, String pass) throws LoginGPCNaoExiste, RemoteException;

    public void removeAtoMedico(int id) throws AtoMedicoNaoExiste, RemoteException;

    public void criaAtoEnfermagem(int id, String nifenfermeiro, String nifutente, LocalDateTime h, HashMap< Integer, Integer> lista_artigos, String nifuser, String pass)
            throws EnfermeiroNaoExiste, UtenteNaoExiste, AtoEnfermagemJaExiste, OutroArtigoNaoExiste, LoginGPCNaoExiste, RemoteException;

    public void alteraIDAtoEnfermagem(int oldID, int newID, String nifuser, String pass) throws AtoEnfermagemJaExiste, LoginGPCNaoExiste, RemoteException;

    public void alteraUtenteAtoEnfermagem(int idAto, Utente u, String nifuser, String pass) throws AtoEnfermagemNaoExiste, LoginGPCNaoExiste, RemoteException;

    public void alteraEnfermeiroAtoEnfermagem(int idAto, Enfermeiro e, String nifuser, String pass) throws AtoEnfermagemNaoExiste, LoginGPCNaoExiste, RemoteException;

    public void alteraHoraAtoEnfermagem(int idAto, LocalDateTime newHora, String nifuser, String pass) throws AtoEnfermagemNaoExiste, LoginGPCNaoExiste, RemoteException;

    public void alteraIDlistaArtigosAtoEnfermagem(int idAto, int oldID, int newID, String nifuser, String pass) throws AtoEnfermagemNaoExiste, LoginGPCNaoExiste, RemoteException;

    public void alteraQuantidadelistaArtigosAtoEnfermagem(int idAto, int idArtigo, int newQuant, String nifuser, String pass) throws AtoEnfermagemNaoExiste, LoginGPCNaoExiste, RemoteException;

    public AtoEnfermagem procuraAtoEnfermagemID(int idAto, String nifuser,String pass) throws AtoEnfermagemNaoExiste, LoginGPCNaoExiste, RemoteException;

    public HashMap<Integer, AtoEnfermagem> procuraAtoEnfermagemUtente(String nif, String nifuser, String pass) throws UtenteNaoExiste, LoginGPCNaoExiste, RemoteException;

    public HashMap<Integer, AtoEnfermagem> procuraAtoEnfermagemEnfermeiro(String nif, String nifuser, String pass) throws EnfermeiroNaoExiste, LoginGPCNaoExiste, RemoteException;

    public HashMap<Integer, AtoEnfermagem> procuraAtoEnfermagemHora(LocalDateTime h, String nifuser, String pass) throws LoginGPCNaoExiste, RemoteException;

    public HashMap<Integer, AtoEnfermagem> procuraAtoEnfermagemArtigo(int idArt, String nifuser, String pass) throws LoginGPCNaoExiste, RemoteException;

    public void removeAtoEnfermagem(int id, String nifuser, String pass) throws AtoEnfermagemNaoExiste, LoginGPCNaoExiste, RemoteException;

    public void criaLoginUtenteGPC(String nif0, String pass0, String nif1, String pass1) throws
            LoginGPCNaoExiste, LoginUtenteJaExiste, RemoteException;

    public String getLoginUtenteInfoGPC(String nif0, String nif1, String pass1) throws LoginGPCNaoExiste, RemoteException;

    public void AlterarNifLoginUtenteGPC(String nif0, String nifnovo, String nif1, String pass1) throws  LoginGPCNaoExiste, RemoteException;

    public void AlterarPassLoginUtenteGPC(String nif0, String passnova, String nif1, String pass1) throws LoginGPCNaoExiste, RemoteException;

    public String procuraLoginUtenteNifGPC(String nif0, String nif1, String pass1) throws LoginGPCNaoExiste, RemoteException;

    public void removeLoginUtenteGPC(String nif0, String nif1, String pass1) throws LoginGPCNaoExiste, RemoteException;

    public void criaLoginGPC(String nif0, String pass0, String nif1, String pass1) throws
            LoginGPCJaExiste, LoginGPCNaoExiste, RemoteException;

    public String getLoginGPCInfo(String nif0, String nif1, String pass1) throws LoginGPCNaoExiste, RemoteException;

    public void AlterarNifLoginGPC(String nif0, String nifnovo, String nif1, String pass1) throws LoginGPCNaoExiste, RemoteException;

    public void AlterarPassLoginGPC(String nif0, String passnova, String nif1, String pass1) throws LoginGPCNaoExiste, RemoteException;

    public String procuraLoginGPCNif(String nif0, String nif1, String pass1) throws LoginGPCNaoExiste, RemoteException;

    public void removeLoginGPC(String nif0, String nif1, String pass1) throws LoginGPCNaoExiste, RemoteException;

    //TOP 3 MEDICAMENTOS MAIS USADOS EM ATOS MÉDICOS
    public HashMap<Integer, Integer> medicamentosMaisUtilizadosAtosMedicos(String nifuser, String pass) throws LoginGPCNaoExiste, RemoteException;

    //TOP 3 ARTIGOS MAIS USADOS EM ATOS MÉDICOS
    public HashMap<Integer, Integer> artigosMaisUtilizadosAtosMedicos(String nifuser, String pass) throws LoginGPCNaoExiste, RemoteException;

    //TOP 3 ARTIGOS MAIS USADOS EM ATOS ENFERMAGEM
    public HashMap<Integer, Integer> artigosMaisUtilizadosAtosEnfermagem(String nifuser, String pass) throws LoginGPCNaoExiste, RemoteException;

    //TOP 3 ESPECIALIDADES DE MÉDICOS MAIS COMUNS
    public HashMap<String, Integer> especialidadesMedicosMaiscomuns(String nifuser, String pass) throws LoginGPCNaoExiste, RemoteException;

    //TOP 3 ESPECIALIDADES DE ENFERMEIROS MAIS COMUNS
    public HashMap<String, Integer> especialidadesEnfermeirosMaiscomuns(String nifuser, String pass) throws LoginGPCNaoExiste, RemoteException;

    //LISTAR ATOS MÉDICOS POR ESPECIALIDADE
    public HashMap<Integer, AtoMedico> listaAtoMedicoEspecialidade(String esp, String nifuser, String pass) throws LoginGPCNaoExiste, RemoteException;

    //LISTAR ATOS ENFERMAGEM POR ESPECIALIDADE
    public HashMap<Integer, AtoEnfermagem> listaAtoEnfermagemEspecialidade(String esp, String nifuser, String pass) throws LoginGPCNaoExiste, RemoteException;
    //LISTAR ATOS MÉDICOS POR UTENTE
    public HashMap<Integer, AtoMedico> listaAtoMedicoUtente(String nif, String nifuser, String pass) throws UtenteNaoExiste, LoginGPCNaoExiste, RemoteException;

    //LISTAR ATOS ENFERMAGEM POR UTENTE
    public HashMap<Integer, AtoEnfermagem> listaAtoEnfermagemUtente(String nif, String nifuser, String pass) throws UtenteNaoExiste, LoginGPCNaoExiste, RemoteException;

    //LISTAR ATOS MÉDICOS POR MÉDICO
    public HashMap<Integer, AtoMedico> listaAtoMedicoMedico(String nif, String nifuser, String pass) throws MedicoNaoExiste, LoginGPCNaoExiste, RemoteException;

    //LISTAR ATOS ENFERMAGEM POR ENFERMEIRO
    public HashMap<Integer, AtoEnfermagem> listaAtoEnfermagemEnfermeiro(String nif, String nifuser, String pass) throws EnfermeiroNaoExiste, LoginGPCNaoExiste, RemoteException;

    //LISTAR ATO MEDICO POR ID DE ARTIGO USADO
    public HashMap<Integer, AtoMedico> listaAtoMedicoArtigo(int idArt, String nifuser, String pass) throws LoginGPCNaoExiste, RemoteException;

    //LISTAR ATO ENFERMAGEM POR ID DE ARTIGO USADO
    public HashMap<Integer, AtoEnfermagem> listaAtoEnfermagemArtigo(int idArt, String nifuser, String pass) throws LoginGPCNaoExiste, RemoteException;
    //LISTAR ATO MEDICO POR ID DE MEDICAMENTO USADO
    public HashMap<Integer, AtoMedico> listaAtoMedicoMedicamento(int idMed, String nifuser, String pass) throws LoginGPCNaoExiste, RemoteException;

    //TOP 3 ATOS MEDICOS QUE USARAM MAIS MEDICAMENTOS
    public HashMap<Integer, Integer> atosMedicosMaisMedicamentos(String nifuser, String pass) throws LoginGPCNaoExiste, RemoteException;

    //TOP 3 ATOS MEDICOS QUE USARAM MAIS ARTIGOS
    public HashMap<Integer, Integer> atosMedicosMaisArtigos(String nifuser, String pass) throws LoginGPCNaoExiste, RemoteException;

    //TOP 3 ATOS ENFERMAGEM QUE USARAM MAIS ARTIGOS
    public HashMap<Integer, Integer> atosEnfermagemMaisArtigos(String nifuser, String pass) throws LoginGPCNaoExiste, RemoteException;
}
