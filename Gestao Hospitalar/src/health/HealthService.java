package health;

import data.entidades.*;
import data.exceptions.*;
//import progs.gestorGPC;
import progs.GestorGPC;
//import progs.Operacoes;

import java.io.IOException;
import java.io.Serializable;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.RMIClientSocketFactory;
import java.rmi.server.RMIServerSocketFactory;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalDateTime;
import java.util.HashMap;

public class HealthService extends UnicastRemoteObject implements FarmaceuticoInterfaceGLM, FuncionarioInterface,
        UtenteInterface, FarmaceuticoInterfaceGPC, Serializable {
    private static final long serialVersionUID = -7483583222589696017L;

    private GestorGPC gestorGPC = null;
    //private gestorGPC gestorGPC = null;
    //private Operacoes operacoes = null;

    public HealthService(GestorGPC gestorGPC) throws RemoteException {
        super();
        this.gestorGPC = gestorGPC;
    }

    public HealthService(int port, GestorGPC gestorGPC) throws RemoteException {
        super(port);
        this.gestorGPC = gestorGPC;
    }

    public HealthService(int port, RMIClientSocketFactory csf, RMIServerSocketFactory ssf, GestorGPC gestorGPC) throws RemoteException {
        super(port, csf, ssf);
        this.gestorGPC = gestorGPC;
    }

    @Override
    public void save() throws IOException, NotBoundException {

    }

    @Override
    public String getUtenteInfo(String nif, String nifuser, String pass) throws UtenteNaoExiste, LoginUtenteNaoExiste, RemoteException {
        return gestorGPC.getUtenteInfo(nif, nifuser, pass);
    }

    @Override
    public void AlterarNomeUtente(String nif, String nome, String nifuser, String pass) throws UtenteNaoExiste, LoginUtenteNaoExiste, RemoteException {
        gestorGPC.AlterarNomeUtente(nif, nome, nifuser, pass);
    }

    @Override
    public void AlterarBiUtente(String nif, String bi, String nifuser, String pass) throws UtenteNaoExiste, LoginUtenteNaoExiste, RemoteException {
        gestorGPC.AlterarBiUtente(nif, bi, nifuser, pass);
    }

    @Override
    public void AlterarNifUtente(String nif0, String nif1, String nifuser, String pass) throws UtenteNaoExiste, LoginUtenteNaoExiste, RemoteException {
        gestorGPC.AlterarNifUtente(nif0,nif1,nifuser,pass);
    }

    @Override
    public void AlterarMoradaUtente(String nif, String morada, String nifuser, String pass) throws UtenteNaoExiste, LoginUtenteNaoExiste, RemoteException {
        gestorGPC.AlterarMoradaUtente(nif,morada,nifuser,pass);
    }

    @Override
    public void AlterarCodigoUtente(String nif, String codigo_postal, String nifuser, String pass) throws UtenteNaoExiste, LoginUtenteNaoExiste, RemoteException {
        gestorGPC.AlterarCodigoUtente(nif,codigo_postal,nifuser,pass);
    }

    @Override
    public String procuraUtenteNif(String nif, String nifuser, String pass) throws UtenteNaoExiste, LoginUtenteNaoExiste, RemoteException {
        return gestorGPC.procuraUtenteNif(nif,nifuser,pass);
    }

    @Override
    public String procuraUtenteBi(String bi, String nifuser, String pass) throws UtenteNaoExiste, LoginUtenteNaoExiste, RemoteException {
        return gestorGPC.procuraUtenteBi(bi,nifuser,pass);
    }

    @Override
    public String procuraUtenteNome(String nome, String nifuser, String pass) throws UtenteNaoExiste, LoginUtenteNaoExiste, RemoteException {
        return gestorGPC.procuraUtenteNome(nome,nifuser,pass);
    }

    @Override
    public String procuraUtenteMorada(String morada, String nifuser, String pass) throws UtenteNaoExiste, LoginUtenteNaoExiste, RemoteException {
        return gestorGPC.procuraUtenteMorada(morada,nifuser,pass);
    }

    @Override
    public String procuraUtenteCodigo(String codigo_postal, String nifuser, String pass) throws UtenteNaoExiste, LoginUtenteNaoExiste, RemoteException {
        return gestorGPC.procuraUtenteCodigo(codigo_postal, nifuser, pass);

    }

    @Override
    public void criaUtenteGPC(String nome, String bi, String nif, String morada, String codigo_postal, String nifuser, String pass) throws UtenteJaExiste, LoginGPCNaoExiste, RemoteException {
        gestorGPC.criaUtenteGPC(nome,bi,nif,morada,codigo_postal,nifuser,pass);
    }

    @Override
    public String getUtenteInfoGPC(String nif, String nifuser, String pass) throws UtenteNaoExiste, LoginGPCNaoExiste, RemoteException {
        return gestorGPC.getUtenteInfoGPC(nif,nifuser,pass);
    }

    @Override
    public void AlterarNomeUtenteGPC(String nif, String nome, String nifuser, String pass) throws UtenteNaoExiste, LoginGPCNaoExiste, RemoteException {
        gestorGPC.AlterarNomeUtenteGPC(nif,nome,nifuser,pass);
    }

    @Override
    public void AlterarBiUtenteGPC(String nif, String bi, String nifuser, String pass) throws UtenteNaoExiste, LoginGPCNaoExiste, RemoteException {
        gestorGPC.AlterarBiUtenteGPC(nif,bi,nifuser,pass);
    }

    @Override
    public void AlterarNifUtenteGPC(String nif0, String nif1, String nifuser, String pass) throws UtenteNaoExiste, LoginGPCNaoExiste, RemoteException {
        gestorGPC.AlterarNifUtenteGPC(nif0,nif1,nifuser,pass);
    }

    @Override
    public void AlterarMoradaUtenteGPC(String nif, String morada, String nifuser, String pass) throws UtenteNaoExiste, LoginGPCNaoExiste, RemoteException {
        gestorGPC.AlterarMoradaUtenteGPC(nif,morada,nifuser,pass);
    }

    @Override
    public void AlterarCodigoUtenteGPC(String nif, String codigo_postal, String nifuser, String pass) throws UtenteNaoExiste, LoginGPCNaoExiste, RemoteException {
        gestorGPC.AlterarCodigoUtenteGPC(nif,codigo_postal,nifuser,pass);
    }

    @Override
    public String procuraUtenteNifGPC(String nif, String nifuser, String pass) throws UtenteNaoExiste, LoginGPCNaoExiste, RemoteException {
        return gestorGPC.procuraUtenteNifGPC(nif,nifuser,pass);
    }

    @Override
    public String procuraUtenteBiGPC(String bi, String nifuser, String pass) throws UtenteNaoExiste, LoginGPCNaoExiste, RemoteException {
        return gestorGPC.procuraUtenteBiGPC(bi,nifuser,pass);
    }

    @Override
    public String procuraUtenteNomeGPC(String nome, String nifuser, String pass) throws UtenteNaoExiste, LoginGPCNaoExiste, RemoteException {
        return gestorGPC.procuraUtenteNomeGPC(nome,nifuser,pass);
    }

    @Override
    public String procuraUtenteMoradaGPC(String morada, String nifuser, String pass) throws UtenteNaoExiste, LoginGPCNaoExiste, RemoteException {
        return gestorGPC.procuraUtenteMoradaGPC(morada,nifuser,pass);
    }

    @Override
    public String procuraUtenteCodigoGPC(String codigo_postal, String nifuser, String pass) throws UtenteNaoExiste, LoginGPCNaoExiste, RemoteException {
        return gestorGPC.procuraUtenteCodigoGPC(codigo_postal,nifuser,pass);
    }

    @Override
    public void removeUtenteGPC(String nif, String nifuser, String pass) throws UtenteNaoExiste, LoginGPCNaoExiste, RemoteException {
        gestorGPC.removeUtenteGPC(nif,nifuser,pass);
    }

    @Override
    public void criaMedico(String nome, String bi, String nif, String morada, String codigo_postal, String especialidade, String cedula, String nifuser, String pass) throws MedicoJaExiste, LoginGPCNaoExiste, RemoteException {
        gestorGPC.criaMedico(nome,bi,nif,morada,codigo_postal,especialidade,cedula,nifuser,pass);
    }

    @Override
    public String getMedicoInfo(String nif, String nifuser, String pass) throws MedicoNaoExiste, LoginGPCNaoExiste, RemoteException {
        return gestorGPC.getMedicoInfo(nif,nifuser,pass);
    }

    @Override
    public void AlterarNomeMedico(String nif, String nome, String nifuser, String pass) throws MedicoNaoExiste, LoginGPCNaoExiste, RemoteException {
        gestorGPC.AlterarNomeMedico(nif,nome,nifuser,pass);
    }

    @Override
    public void AlterarBiMedico(String nif, String bi, String nifuser, String pass) throws MedicoNaoExiste, LoginGPCNaoExiste, RemoteException {
        gestorGPC.AlterarBiMedico(nif,bi,nifuser,pass);
    }

    @Override
    public void AlterarNifMedico(String nif0, String nif1, String nifuser, String pass) throws MedicoNaoExiste, LoginGPCNaoExiste, RemoteException {
        gestorGPC.AlterarNifMedico(nif0,nif1,nifuser,pass);
    }

    @Override
    public void AlterarMoradaMedico(String nif, String morada, String nifuser, String pass) throws MedicoNaoExiste, LoginGPCNaoExiste, RemoteException {
        gestorGPC.AlterarMoradaMedico(nif,morada,nifuser,pass);
    }

    @Override
    public void AlterarCodigoMedico(String nif, String codigo_postal, String nifuser, String pass) throws MedicoNaoExiste, LoginGPCNaoExiste, RemoteException {
        gestorGPC.AlterarCodigoMedico(nif,codigo_postal,nifuser,pass);
    }

    @Override
    public void AlterarEspecialidadeMedico(String nif, String especialidade, String nifuser, String pass) throws MedicoNaoExiste, LoginGPCNaoExiste, RemoteException {
        gestorGPC.AlterarEspecialidadeMedico(nif,especialidade,nifuser,pass);
    }

    @Override
    public void AlterarCedulaMedico(String nif, String cedula, String nifuser, String pass) throws MedicoNaoExiste, LoginGPCNaoExiste, RemoteException {
        gestorGPC.AlterarCedulaMedico(nif,cedula,nifuser,pass);
    }

    @Override
    public String procuraMedicoNif(String nif, String nifuser, String pass) throws MedicoNaoExiste, LoginGPCNaoExiste, RemoteException {
        return gestorGPC.procuraMedicoNif(nif,nifuser,pass);
    }

    @Override
    public String procuraMedicoBi(String bi, String nifuser, String pass) throws MedicoNaoExiste, LoginGPCNaoExiste, RemoteException {
        return gestorGPC.procuraMedicoBi(bi,nifuser,pass);
    }

    @Override
    public String procuraMedicosNome(String nome, String nifuser, String pass) throws MedicoNaoExiste, LoginGPCNaoExiste, RemoteException {
        return gestorGPC.procuraMedicosNome(nome,nifuser,pass);
    }

    @Override
    public String procuraMedicoMorada(String morada, String nifuser, String pass) throws MedicoNaoExiste, LoginGPCNaoExiste, RemoteException {
        return gestorGPC.procuraMedicoMorada(morada,nifuser,pass);
    }

    @Override
    public String procuraMedicoCodigo(String codigo_postal, String nifuser, String pass) throws MedicoNaoExiste, LoginGPCNaoExiste, RemoteException {
        return gestorGPC.procuraMedicoCodigo(codigo_postal,nifuser,pass);
    }

    @Override
    public String procuraMedicoEspecialidade(String especialidade, String nifuser, String pass) throws MedicoNaoExiste, LoginGPCNaoExiste, RemoteException {
        return gestorGPC.procuraMedicoEspecialidade(especialidade,nifuser,pass);
    }

    @Override
    public String procuraMedicoCedula(String cedula, String nifuser, String pass) throws MedicoNaoExiste, LoginGPCNaoExiste, RemoteException {
        return gestorGPC.procuraMedicoCedula(cedula,nifuser,pass);
    }

    @Override
    public void removeMedico(String nif, String nifuser, String pass) throws MedicoNaoExiste, LoginGPCNaoExiste, RemoteException {
        gestorGPC.removeMedico(nif,nifuser,pass);
    }

    @Override
    public void criaEnfermeiro(String nome, String bi, String nif, String morada, String codigo_postal, String especialidade, String nifuser, String pass) throws EnfermeiroJaExiste, LoginGPCNaoExiste, RemoteException {
        gestorGPC.criaEnfermeiro(nome,bi,nif,morada,codigo_postal,especialidade,nifuser,pass);
    }

    @Override
    public String getEnfermeiroInfo(String nif, String nifuser, String pass) throws EnfermeiroNaoExiste, LoginGPCNaoExiste, RemoteException {
        return gestorGPC.getEnfermeiroInfo(nif,nifuser,pass);
    }

    @Override
    public void AlterarNomeEnfermeiro(String nif, String nome, String nifuser, String pass) throws EnfermeiroNaoExiste, LoginGPCNaoExiste, RemoteException {
        gestorGPC.AlterarNomeEnfermeiro(nif,nome,nifuser,pass);
    }

    @Override
    public void AlterarBiEnfermeiro(String nif, String bi, String nifuser, String pass) throws EnfermeiroNaoExiste, LoginGPCNaoExiste, RemoteException {
        gestorGPC.AlterarBiEnfermeiro(nif,bi,nifuser,pass);
    }

    @Override
    public void AlterarNifEnfermeiro(String nif0, String nif1, String nifuser, String pass) throws EnfermeiroNaoExiste, LoginGPCNaoExiste, RemoteException {
        gestorGPC.AlterarNifEnfermeiro(nif0, nif1, nifuser, pass);
    }

    @Override
    public void AlterarMoradaEnfermeiro(String nif, String morada, String nifuser, String pass) throws EnfermeiroNaoExiste, LoginGPCNaoExiste, RemoteException {
        gestorGPC.AlterarMoradaEnfermeiro(nif, morada, nifuser, pass);
    }

    @Override
    public void AlterarCodigoEnfermeiro(String nif, String codigo_postal, String nifuser, String pass) throws EnfermeiroNaoExiste, LoginGPCNaoExiste, RemoteException {
        gestorGPC.AlterarNomeEnfermeiro(nif, codigo_postal, nifuser, pass);
    }

    @Override
    public void AlterarEspecialidadeEnfermeiro(String nif, String especialidade, String nifuser, String pass) throws EnfermeiroNaoExiste, LoginGPCNaoExiste, RemoteException {
        gestorGPC.AlterarEspecialidadeEnfermeiro(nif, especialidade, nifuser, pass);
    }

    @Override
    public String procuraEnfermeiroNif(String nif, String nifuser, String pass) throws EnfermeiroNaoExiste, LoginGPCNaoExiste, RemoteException {
        return gestorGPC.procuraEnfermeiroNif(nif, nifuser, pass);
    }

    @Override
    public String procuraEnfermeiroBi(String bi, String nifuser, String pass) throws EnfermeiroNaoExiste, LoginGPCNaoExiste, RemoteException {
        return gestorGPC.procuraEnfermeiroBi(bi, nifuser, pass);
    }

    @Override
    public String procuraEnfermeiroNome(String nome, String nifuser, String pass) throws EnfermeiroNaoExiste, LoginGPCNaoExiste, RemoteException {
        return gestorGPC.procuraEnfermeiroNome(nome, nifuser, pass);
    }

    @Override
    public String procuraEnfermeiroMorada(String morada, String nifuser, String pass) throws EnfermeiroNaoExiste, LoginGPCNaoExiste, RemoteException {
        return gestorGPC.procuraEnfermeiroMorada(morada, nifuser, pass);
    }

    @Override
    public String procuraEnfermeiroCodigo(String codigo_postal, String nifuser, String pass) throws EnfermeiroNaoExiste, LoginGPCNaoExiste, RemoteException {
        return gestorGPC.procuraEnfermeiroCodigo(codigo_postal, nifuser, pass);
    }

    @Override
    public String procuraEnfermeiroEspecialidade(String especialidade, String nifuser, String pass) throws EnfermeiroNaoExiste, LoginGPCNaoExiste, RemoteException {
        return gestorGPC.procuraEnfermeiroEspecialidade(especialidade, nifuser, pass);
    }

    @Override
    public void removeEnfermeiro(String nif, String nifuser, String pass) throws EnfermeiroNaoExiste, LoginGPCNaoExiste, RemoteException {
        gestorGPC.removeEnfermeiro(nif, nifuser, pass);
    }

    @Override
    public void criaAtoMedico(int id, String nifmedico, String nifutente, LocalDateTime h, HashMap<Integer, Integer> lista_artigos, HashMap<Integer, Integer> lista_medicamentos, String nifuser, String pass) throws MedicoNaoExiste, UtenteNaoExiste, AtoMedicoJaExiste, MedicamentoNaoExiste, OutroArtigoNaoExiste, LoginGPCNaoExiste, RemoteException {
        gestorGPC.criaAtoMedico(id, nifmedico, nifutente, h, lista_artigos, lista_medicamentos, nifuser, pass);
    }

    @Override
    public void alteraIDAtoMedico(int oldID, int newID, String nifuser, String pass) throws AtoMedicoJaExiste, LoginGPCNaoExiste, RemoteException {
        gestorGPC.alteraIDAtoMedico(oldID, newID, nifuser, pass);
    }

    @Override
    public void alteraUtenteAtoMedico(int idAto, Utente u, String nifuser, String pass) throws AtoMedicoNaoExiste, LoginGPCNaoExiste, RemoteException {
        gestorGPC.alteraUtenteAtoMedico(idAto, u, nifuser, pass);
    }

    @Override
    public void alteraMedicoAtoMedico(int idAto, Medico m, String nifuser, String pass) throws AtoMedicoNaoExiste, LoginGPCNaoExiste, RemoteException {
        gestorGPC.alteraMedicoAtoMedico(idAto, m, nifuser, pass);
    }

    @Override
    public void alteraHoraAtoMedico(int idAto, LocalDateTime newHora, String nifuser, String pass) throws AtoMedicoNaoExiste, LoginGPCNaoExiste, RemoteException {
        gestorGPC.alteraHoraAtoMedico(idAto, newHora, nifuser, pass);
    }

    @Override
    public void alteraIDlistaArtigosAtoMedico(int idAto, int oldID, int newID, String nifuser, String pass) throws AtoMedicoNaoExiste, LoginGPCNaoExiste, RemoteException {
        gestorGPC.alteraIDlistaArtigosAtoMedico(idAto, oldID, newID, nifuser, pass);
    }

    @Override
    public void alteraQuantidadelistaArtigosAtoMedico(int idAto, int idArtigo, int newQuant, String nifuser, String pass) throws AtoMedicoNaoExiste, LoginGPCNaoExiste, RemoteException {
        gestorGPC.alteraQuantidadelistaArtigosAtoMedico(idAto, idArtigo, newQuant, nifuser, pass);
    }

    @Override
    public void alteraIDlistaMedicamentosAtoMedico(int idAto, int oldID, int newID, String nifuser, String pass) throws AtoMedicoNaoExiste, LoginGPCNaoExiste, RemoteException {
        gestorGPC.alteraIDlistaMedicamentosAtoMedico(idAto, oldID, newID, nifuser, pass);
    }

    @Override
    public void alteraQuantidadelistaMedicamentosAtoMedico(int idAto, int idMedicamento, int newQuant, String nifuser, String pass) throws AtoMedicoNaoExiste, LoginGPCNaoExiste, RemoteException {
        gestorGPC.alteraQuantidadelistaMedicamentosAtoMedico(idAto, idMedicamento, newQuant, nifuser, pass);
    }

    @Override
    public AtoMedico procuraAtoMedicoID(int idAto, String nifu, String nifuser, String pass) throws AtoMedicoNaoExiste, LoginGPCNaoExiste, RemoteException {
        return gestorGPC.procuraAtoMedicoID(idAto, nifu, nifuser, pass);
    }

    @Override
    public HashMap<Integer, AtoMedico> procuraAtoMedicoUtente(String nif, String nifuser, String pass) throws UtenteNaoExiste, LoginGPCNaoExiste, RemoteException {
        return gestorGPC.procuraAtoMedicoUtente(nif, nifuser, pass);
    }

    @Override
    public HashMap<Integer, AtoMedico> procuraAtoMedicoMedico(String nif, String nifuser, String pass) throws MedicoNaoExiste, LoginGPCNaoExiste, RemoteException {
        return gestorGPC.procuraAtoMedicoMedico(nif, nifuser, pass);
    }

    @Override
    public HashMap<Integer, AtoMedico> procuraAtoMedicoHora(LocalDateTime h, String nifuser, String pass) throws LoginGPCNaoExiste, RemoteException {
        return gestorGPC.procuraAtoMedicoHora(h, nifuser, pass);
    }

    @Override
    public HashMap<Integer, AtoMedico> procuraAtoMedicoArtigo(int idArt, String nifuser, String pass) throws LoginGPCNaoExiste, RemoteException {
        return gestorGPC.procuraAtoMedicoArtigo(idArt, nifuser, pass);
    }

    @Override
    public HashMap<Integer, AtoMedico> procuraAtoMedicoMedicamento(int idMed, String nifuser, String pass) throws LoginGPCNaoExiste, RemoteException {
        return gestorGPC.procuraAtoMedicoMedicamento(idMed, nifuser, pass);
    }

    @Override
    public void removeAtoMedico(int id) throws AtoMedicoNaoExiste, RemoteException {
        gestorGPC.removeAtoMedico(id);
    }

    @Override
    public void criaAtoEnfermagem(int id, String nifenfermeiro, String nifutente, LocalDateTime h, HashMap<Integer, Integer> lista_artigos, String nifuser, String pass) throws EnfermeiroNaoExiste, UtenteNaoExiste, AtoEnfermagemJaExiste, OutroArtigoNaoExiste, LoginGPCNaoExiste, RemoteException {
        gestorGPC.criaAtoEnfermagem(id, nifenfermeiro, nifutente, h, lista_artigos, nifuser, pass);
    }

    @Override
    public void alteraIDAtoEnfermagem(int oldID, int newID, String nifuser, String pass) throws AtoEnfermagemJaExiste, LoginGPCNaoExiste, RemoteException {
        gestorGPC.alteraIDAtoEnfermagem(oldID, newID, nifuser, pass);
    }

    @Override
    public void alteraUtenteAtoEnfermagem(int idAto, Utente u, String nifuser, String pass) throws AtoEnfermagemNaoExiste, LoginGPCNaoExiste, RemoteException {
        gestorGPC.alteraUtenteAtoEnfermagem(idAto, u, nifuser, pass);
    }

    @Override
    public void alteraEnfermeiroAtoEnfermagem(int idAto, Enfermeiro e, String nifuser, String pass) throws AtoEnfermagemNaoExiste, LoginGPCNaoExiste, RemoteException {
        gestorGPC.alteraEnfermeiroAtoEnfermagem(idAto, e, nifuser, pass);
    }

    @Override
    public void alteraHoraAtoEnfermagem(int idAto, LocalDateTime newHora, String nifuser, String pass) throws AtoEnfermagemNaoExiste, LoginGPCNaoExiste, RemoteException {
        gestorGPC.alteraHoraAtoEnfermagem(idAto, newHora, nifuser, pass);
    }

    @Override
    public void alteraIDlistaArtigosAtoEnfermagem(int idAto, int oldID, int newID, String nifuser, String pass) throws AtoEnfermagemNaoExiste, LoginGPCNaoExiste, RemoteException {
        gestorGPC.alteraIDlistaArtigosAtoEnfermagem(idAto, oldID, newID, nifuser, pass);
    }

    @Override
    public void alteraQuantidadelistaArtigosAtoEnfermagem(int idAto, int idArtigo, int newQuant, String nifuser, String pass) throws AtoEnfermagemNaoExiste, LoginGPCNaoExiste, RemoteException {
        gestorGPC.alteraQuantidadelistaArtigosAtoEnfermagem(idAto, idArtigo, newQuant, nifuser, pass);
    }

    @Override
    public AtoEnfermagem procuraAtoEnfermagemID(int idAto, String nifuser, String pass) throws AtoEnfermagemNaoExiste, LoginGPCNaoExiste, RemoteException {
        return gestorGPC.procuraAtoEnfermagemID(idAto, nifuser, pass);
    }

    @Override
    public HashMap<Integer, AtoEnfermagem> procuraAtoEnfermagemUtente(String nif, String nifuser, String pass) throws UtenteNaoExiste, LoginGPCNaoExiste, RemoteException {
        return gestorGPC.procuraAtoEnfermagemUtente(nif, nifuser, pass);
    }

    @Override
    public HashMap<Integer, AtoEnfermagem> procuraAtoEnfermagemEnfermeiro(String nif, String nifuser, String pass) throws EnfermeiroNaoExiste, LoginGPCNaoExiste, RemoteException {
        return gestorGPC.procuraAtoEnfermagemEnfermeiro(nif, nifuser, pass);
    }

    @Override
    public HashMap<Integer, AtoEnfermagem> procuraAtoEnfermagemHora(LocalDateTime h, String nifuser, String pass) throws LoginGPCNaoExiste, RemoteException {
        return gestorGPC.procuraAtoEnfermagemHora(h, nifuser, pass);
    }

    @Override
    public HashMap<Integer, AtoEnfermagem> procuraAtoEnfermagemArtigo(int idArt, String nifuser, String pass) throws LoginGPCNaoExiste, RemoteException {
        return gestorGPC.procuraAtoEnfermagemArtigo(idArt, nifuser, pass);
    }

    @Override
    public void removeAtoEnfermagem(int id, String nifuser, String pass) throws AtoEnfermagemNaoExiste, LoginGPCNaoExiste, RemoteException {
        gestorGPC.removeAtoEnfermagem(id, nifuser, pass);
    }

    @Override
    public String getLoginUtenteInfo(String nif0, String nif1, String pass1) throws LoginUtenteNaoExiste, RemoteException {
        return gestorGPC.getLoginUtenteInfo(nif0, nif1, pass1);
    }

    @Override
    public void AlterarNifLoginUtente(String nif0, String nifnovo, String nif1, String pass1) throws LoginUtenteNaoExiste, RemoteException {
        gestorGPC.AlterarNifLoginUtente(nif0, nifnovo, nif1, pass1);
    }

    @Override
    public void AlterarPassLoginUtente(String nif0, String passnova, String nif1, String pass1) throws LoginUtenteNaoExiste, RemoteException {
        gestorGPC.AlterarPassLoginUtente(nif0, passnova, nif1, pass1);
    }

    @Override
    public String procuraLoginUtenteNif(String nif0, String nif1, String pass1) throws LoginUtenteNaoExiste, RemoteException {
        return gestorGPC.procuraLoginUtenteNif(nif0, nif1, pass1);
    }

    @Override
    public String getLoginUtenteInfoGPC(String nif0, String nif1, String pass1) throws LoginGPCNaoExiste, RemoteException {
        return gestorGPC.getLoginUtenteInfoGPC(nif0, nif1, pass1);
    }

    @Override
    public void criaLoginUtenteGPC(String nif0, String pass0, String nif1, String pass1) throws LoginGPCNaoExiste, LoginUtenteJaExiste, RemoteException {
        gestorGPC.criaLoginUtenteGPC(nif0, pass0, nif1, pass1);
    }

    @Override
    public void AlterarNifLoginUtenteGPC(String nif0, String nifnovo, String nif1, String pass1) throws LoginGPCNaoExiste, RemoteException {
        gestorGPC.AlterarNifLoginUtenteGPC(nif0, nifnovo, nif1, pass1);
    }

    @Override
    public void AlterarPassLoginUtenteGPC(String nif0, String passnova, String nif1, String pass1) throws LoginGPCNaoExiste, RemoteException {
        gestorGPC.AlterarPassLoginGPC(nif0, passnova, nif1, pass1);
    }

    @Override
    public String procuraLoginUtenteNifGPC(String nif0, String nif1, String pass1) throws LoginGPCNaoExiste, RemoteException {
        return gestorGPC.procuraLoginUtenteNifGPC(nif0, nif1, pass1);
    }

    @Override
    public void removeLoginUtenteGPC(String nif0, String nif1, String pass1) throws LoginGPCNaoExiste, RemoteException {
        gestorGPC.removeLoginUtenteGPC(nif0, nif1, pass1);
    }

    @Override
    public void criaLoginGPC(String nif0, String pass0, String nif1, String pass1) throws LoginGPCJaExiste, LoginGPCNaoExiste, RemoteException {
        gestorGPC.criaLoginGPC(nif0, pass0, nif1, pass1);
    }

    @Override
    public String getLoginGPCInfo(String nif0, String nif1, String pass1) throws LoginGPCNaoExiste, RemoteException {
        return gestorGPC.getLoginGPCInfo(nif0, nif1, pass1);
    }

    @Override
    public void AlterarNifLoginGPC(String nif0, String nifnovo, String nif1, String pass1) throws LoginGPCNaoExiste, RemoteException {
        gestorGPC.AlterarNifLoginUtenteGPC(nif0, nifnovo, nif1, pass1);
    }

    @Override
    public void AlterarPassLoginGPC(String nif0, String passnova, String nif1, String pass1) throws LoginGPCNaoExiste, RemoteException {
        gestorGPC.AlterarPassLoginGPC(nif0, passnova, nif1, pass1);
    }

    @Override
    public String procuraLoginGPCNif(String nif0, String nif1, String pass1) throws LoginGPCNaoExiste, RemoteException {
        return gestorGPC.procuraLoginGPCNif(nif0, nif1, pass1);
    }

    @Override
    public void removeLoginGPC(String nif0, String nif1, String pass1) throws LoginGPCNaoExiste, RemoteException {
        gestorGPC.removeLoginGPC(nif0, nif1, pass1);
    }

    @Override
    public HashMap<Integer, Integer> medicamentosMaisUtilizadosAtosMedicos(String nifuser, String pass) throws LoginGPCNaoExiste, RemoteException {
        return gestorGPC.medicamentosMaisUtilizadosAtosMedicos(nifuser,pass);
    }

    @Override
    public HashMap<Integer, Integer> artigosMaisUtilizadosAtosMedicos(String nifuser, String pass) throws LoginGPCNaoExiste, RemoteException {
        return gestorGPC.artigosMaisUtilizadosAtosMedicos(nifuser, pass);
    }

    @Override
    public HashMap<Integer, Integer> artigosMaisUtilizadosAtosEnfermagem(String nifuser, String pass) throws LoginGPCNaoExiste, RemoteException {
        return gestorGPC.artigosMaisUtilizadosAtosEnfermagem(nifuser, pass);
    }

    @Override
    public HashMap<String, Integer> especialidadesMedicosMaiscomuns(String nifuser, String pass) throws LoginGPCNaoExiste, RemoteException {
        return gestorGPC.especialidadesMedicosMaiscomuns(nifuser, pass);
    }

    @Override
    public HashMap<String, Integer> especialidadesEnfermeirosMaiscomuns(String nifuser, String pass) throws LoginGPCNaoExiste, RemoteException {
        return gestorGPC.especialidadesEnfermeirosMaiscomuns(nifuser, pass);
    }

    @Override
    public HashMap<Integer, AtoMedico> listaAtoMedicoEspecialidade(String esp, String nifuser, String pass) throws LoginGPCNaoExiste, RemoteException {
        return gestorGPC.listaAtoMedicoEspecialidade(esp, nifuser, pass);
    }

    @Override
    public HashMap<Integer, AtoEnfermagem> listaAtoEnfermagemEspecialidade(String esp, String nifuser, String pass) throws LoginGPCNaoExiste, RemoteException {
        return gestorGPC.listaAtoEnfermagemEspecialidade(esp, nifuser, pass);
    }

    @Override
    public HashMap<Integer, AtoMedico> listaAtoMedicoUtente(String nif, String nifuser, String pass) throws UtenteNaoExiste, LoginGPCNaoExiste, RemoteException {
        return gestorGPC.listaAtoMedicoUtente(nif, nifuser, pass);
    }

    @Override
    public HashMap<Integer, AtoEnfermagem> listaAtoEnfermagemUtente(String nif, String nifuser, String pass) throws UtenteNaoExiste, LoginGPCNaoExiste, RemoteException {
        return gestorGPC.listaAtoEnfermagemUtente(nif, nifuser, pass);
    }

    @Override
    public HashMap<Integer, AtoMedico> listaAtoMedicoMedico(String nif, String nifuser, String pass) throws MedicoNaoExiste, LoginGPCNaoExiste, RemoteException {
        return gestorGPC.listaAtoMedicoMedico(nif,nifuser, pass);
    }

    @Override
    public HashMap<Integer, AtoEnfermagem> listaAtoEnfermagemEnfermeiro(String nif, String nifuser, String pass) throws EnfermeiroNaoExiste, LoginGPCNaoExiste, RemoteException {
        return gestorGPC.listaAtoEnfermagemEnfermeiro(nif, nifuser, pass);
    }

    @Override
    public HashMap<Integer, AtoMedico> listaAtoMedicoArtigo(int idArt, String nifuser, String pass) throws LoginGPCNaoExiste, RemoteException {
        return gestorGPC.listaAtoMedicoArtigo(idArt, nifuser, pass);
    }

    @Override
    public HashMap<Integer, AtoEnfermagem> listaAtoEnfermagemArtigo(int idArt, String nifuser, String pass) throws LoginGPCNaoExiste, RemoteException {
        return gestorGPC.listaAtoEnfermagemArtigo(idArt, nifuser, pass);
    }

    @Override
    public HashMap<Integer, AtoMedico> listaAtoMedicoMedicamento(int idMed, String nifuser, String pass) throws LoginGPCNaoExiste, RemoteException {
        return gestorGPC.listaAtoMedicoMedicamento(idMed, nifuser, pass);
    }

    @Override
    public HashMap<Integer, Integer> atosMedicosMaisMedicamentos(String nifuser, String pass) throws LoginGPCNaoExiste, RemoteException {
        return gestorGPC.atosMedicosMaisMedicamentos(nifuser, pass);
    }

    @Override
    public HashMap<Integer, Integer> atosMedicosMaisArtigos(String nifuser, String pass) throws LoginGPCNaoExiste, RemoteException {
        return gestorGPC.atosMedicosMaisArtigos(nifuser, pass);
    }

    @Override
    public HashMap<Integer, Integer> atosEnfermagemMaisArtigos(String nifuser, String pass) throws LoginGPCNaoExiste, RemoteException {
        return gestorGPC.atosEnfermagemMaisArtigos(nifuser, pass);
    }

    @Override
    public void criaFarmaceutico(String nome, String bi, String nif, String morada, String codigo_postal, String nifuser, String pass) throws FarmaceuticoJaExiste, LoginGPCNaoExiste, RemoteException {
        gestorGPC.criaFarmaceutico(nome, bi, nif, morada, codigo_postal, nifuser, pass);
    }

    @Override
    public String getFarmaceuticoInfo(String nif, String nifuser, String pass) throws FarmaceuticoNaoExiste, LoginGPCNaoExiste, RemoteException {
        return gestorGPC.getFarmaceuticoInfo(nif, nifuser, pass);
    }

    @Override
    public void AlterarNomeFarmaceutico(String nif, String nome, String nifuser, String pass) throws FarmaceuticoNaoExiste, LoginGPCNaoExiste, RemoteException {
        gestorGPC.AlterarNomeFarmaceutico(nif, nome, nifuser, pass);
    }

    @Override
    public void AlterarBiFarmaceutico(String nif, String bi, String nifuser, String pass) throws FarmaceuticoNaoExiste, LoginGPCNaoExiste, RemoteException {
        gestorGPC.AlterarBiFarmaceutico(nif, bi, nifuser, pass);
    }

    @Override
    public void AlterarNifFarmaceutico(String nif0, String nif1, String nifuser, String pass) throws FarmaceuticoNaoExiste, LoginGPCNaoExiste, RemoteException {
        gestorGPC.AlterarNifFarmaceutico(nif0, nif1, nifuser, pass);
    }

    @Override
    public void AlterarMoradaFarmaceutico(String nif, String morada, String nifuser, String pass) throws FarmaceuticoNaoExiste, LoginGPCNaoExiste, RemoteException {
        gestorGPC.AlterarMoradaFarmaceutico(nif, morada, nifuser, pass);
    }

    @Override
    public void AlterarCodigoFarmaceutico(String nif, String codigo_postal, String nifuser, String pass) throws FarmaceuticoNaoExiste, LoginGPCNaoExiste, RemoteException {
        gestorGPC.AlterarCodigoFarmaceutico(nif, codigo_postal, nifuser, pass);
    }

    @Override
    public String procuraFarmaceuticoNif(String nif, String nifuser, String pass) throws FarmaceuticoNaoExiste, LoginGPCNaoExiste, RemoteException {
        return gestorGPC.procuraFarmaceuticoNif(nif, nifuser, pass);
    }

    @Override
    public String procuraFarmaceuticoBi(String bi, String nifuser, String pass) throws FarmaceuticoNaoExiste, LoginGPCNaoExiste, RemoteException {
        return gestorGPC.procuraFarmaceuticoBi(bi, nifuser, pass);
    }

    @Override
    public String procuraFarmaceuticoNome(String nome, String nifuser, String pass) throws FarmaceuticoNaoExiste, LoginGPCNaoExiste, RemoteException {
        return gestorGPC.procuraFarmaceuticoNome(nome, nifuser, pass);
    }

    @Override
    public String procuraFarmaceuticoMorada(String morada, String nifuser, String pass) throws FarmaceuticoNaoExiste, LoginGPCNaoExiste, RemoteException {
        return gestorGPC.procuraFarmaceuticoMorada(morada, nifuser, pass);
    }

    @Override
    public String procuraFarmaceuticoCodigo(String codigo_postal, String nifuser, String pass) throws FarmaceuticoNaoExiste, LoginGPCNaoExiste, RemoteException {
        return gestorGPC.procuraFarmaceuticoCodigo(codigo_postal, nifuser, pass);
    }

    @Override
    public void removeFarmaceutico(String nif, String nifuser, String pass) throws FarmaceuticoNaoExiste, LoginGPCNaoExiste, RemoteException {
        gestorGPC.removeFarmaceutico(nif, nifuser, pass);
    }

    @Override
    public void criaFornecedor(int id, String nome, String nifuser, String pass) throws FornecedorJaExiste, LoginGLMNaoExiste, RemoteException {
        gestorGPC.criaFornecedor(id, nome, nifuser, pass);
    }

    @Override
    public String getFornecedorInfo(int id, String nome, String nifuser, String pass) throws FornecedorNaoExiste, LoginGLMJaExiste, RemoteException {
        return gestorGPC.getFornecedorInfo(id, nome, nifuser, pass);
    }

    @Override
    public void AlterarNomeFornecedor(int id, String nome, String nifuser, String pass) throws FornecedorNaoExiste, LoginGLMJaExiste, RemoteException {
        gestorGPC.AlterarNomeFornecedor(id, nome, nifuser, pass);
    }

    @Override
    public void AlterarIdFornecedor(int id0, int id1, String nifuser, String pass) throws FornecedorNaoExiste, LoginGLMJaExiste, RemoteException {
        gestorGPC.AlterarIdFornecedor(id0, id1, nifuser, pass);
    }

    @Override
    public String procuraFornecedorId(int id, String nifuser, String pass) throws FornecedorNaoExiste, LoginGLMJaExiste, RemoteException {
        return gestorGPC.procuraFornecedorId(id, nifuser, pass);
    }

    @Override
    public String procuraFornecedorNome(String nome, String nifuser, String pass) throws FornecedorNaoExiste, LoginGLMJaExiste, RemoteException {
        return gestorGPC.procuraFornecedorNome(nome, nifuser, pass);
    }

    @Override
    public void removeFornecedor(int id, String nifuser, String pass) throws FornecedorNaoExiste, LoginGLMJaExiste, RemoteException {
        gestorGPC.removeFornecedor(id, nifuser, pass);
    }

    @Override
    public void criaAtoFarmaceutico(int id, String niffarmaceutico, LocalDateTime h, HashMap<Integer, Integer> lista_artigos, HashMap<Integer, Integer> lista_medicamentos, String nifuser, String pass) throws FarmaceuticoNaoExiste, AtoFarmaceuticoJaExiste, MedicamentoNaoExiste, OutroArtigoNaoExiste, LoginGLMNaoExiste, RemoteException {
        gestorGPC.criaAtoFarmaceutico(id, niffarmaceutico, h, lista_artigos, lista_medicamentos, nifuser, pass);
    }

    @Override
    public void alteraIDAtoFarmaceutico(int oldID, int newID, String nifuser, String pass) throws AtoFarmaceuticoJaExiste, LoginGLMNaoExiste, RemoteException {
        gestorGPC.alteraIDAtoFarmaceutico(oldID, newID, nifuser, pass);
    }

    @Override
    public void alteraFarmaceuticoAtoFarmaceutico(int idAto, Farmaceutico f, String nifuser, String pass) throws AtoFarmaceuticoNaoExiste, LoginGLMNaoExiste, RemoteException {
        gestorGPC.alteraFarmaceuticoAtoFarmaceutico(idAto, f, nifuser, pass);
    }

    @Override
    public void alteraHoraAtoFarmaceutico(int idAto, LocalDateTime newHora, String nifuser, String pass) throws AtoFarmaceuticoNaoExiste, LoginGLMNaoExiste, RemoteException {
        gestorGPC.alteraHoraAtoFarmaceutico(idAto, newHora, nifuser, pass);
    }

    @Override
    public void alteraIDlistaArtigosAtoFarmaceutico(int idAto, int oldID, int newID, String nifuser, String pass) throws AtoFarmaceuticoNaoExiste, LoginGLMNaoExiste, RemoteException {
        gestorGPC.alteraIDlistaArtigosAtoFarmaceutico(idAto, oldID, newID, nifuser, pass);
    }

    @Override
    public void alteraQuantidadelistaArtigosAtoFarmaceutico(int idAto, int idArtigo, int newQuant, String nifuser, String pass) throws AtoFarmaceuticoNaoExiste, LoginGLMNaoExiste, RemoteException {
        gestorGPC.alteraQuantidadelistaArtigosAtoFarmaceutico(idAto, idArtigo, newQuant, nifuser, pass);
    }

    @Override
    public void alteraIDlistaMedicamentosAtoFarmaceutico(int idAto, int oldID, int newID, String nifuser, String pass) throws AtoFarmaceuticoNaoExiste, LoginGLMNaoExiste, RemoteException {
        gestorGPC.alteraIDlistaMedicamentosAtoFarmaceutico(idAto, oldID, newID, nifuser, pass);
    }

    @Override
    public void alteraQuantidadelistaMedicamentosAtoFarmaceutico(int idAto, int idMedicamento, int newQuant, String nifuser, String pass) throws AtoFarmaceuticoNaoExiste, LoginGLMNaoExiste, RemoteException {
        gestorGPC.alteraQuantidadelistaMedicamentosAtoFarmaceutico(idAto, idMedicamento, newQuant, nifuser, pass);
    }

    @Override
    public AtoFarmaceutico procuraAtoFarmaceuticoID(int idAto, String nifuser, String pass) throws AtoFarmaceuticoNaoExiste, LoginGLMNaoExiste, RemoteException {
        return gestorGPC.procuraAtoFarmaceuticoID(idAto, nifuser, pass);
    }

    @Override
    public HashMap<Integer, AtoFarmaceutico> procuraAtoFarmaceuticoFarmaceutico(String nif, String nifuser, String pass) throws FarmaceuticoNaoExiste, LoginGLMNaoExiste, RemoteException {
        return gestorGPC.procuraAtoFarmaceuticoFarmaceutico(nif, nifuser, pass);
    }

    @Override
    public HashMap<Integer, AtoFarmaceutico> procuraAtoFarmaceuticoHora(LocalDateTime h, String nifuser, String pass) throws LoginGLMNaoExiste, RemoteException {
        return gestorGPC.procuraAtoFarmaceuticoHora(h, nifuser, pass);
    }

    @Override
    public HashMap<Integer, AtoFarmaceutico> procuraAtoFarmaceuticoArtigo(int idArt, String nifuser, String pass) throws LoginGLMNaoExiste, RemoteException {
        return gestorGPC.procuraAtoFarmaceuticoArtigo(idArt, nifuser, pass);
    }

    @Override
    public HashMap<Integer, AtoFarmaceutico> procuraAtoFarmaceuticoMedicamento(int idMed, String nifuser, String pass) throws LoginGLMNaoExiste, RemoteException {
        return gestorGPC.procuraAtoFarmaceuticoMedicamento(idMed, nifuser, pass);
    }

    @Override
    public String ConsultaArtigos(String nifuser, String pass) throws LoginGLMNaoExiste, RemoteException {
        return gestorGPC.ConsultaArtigos(nifuser, pass);
    }

    @Override
    public String ConsultaMedicamentos(String nifuser, String pass) throws LoginGLMNaoExiste, RemoteException {
        return gestorGPC.ConsultaMedicamentos(nifuser, pass);
    }

    @Override
    public String ConsultaAquisicoesArtigos(String nifuser, String pass) throws LoginGLMNaoExiste, RemoteException {
        return gestorGPC.ConsultaAquisicoesArtigos(nifuser, pass);
    }

    @Override
    public String ConsultaAquisicoesMedicamentos(String nifuser, String pass) throws LoginGLMNaoExiste, RemoteException {
        return gestorGPC.ConsultaAquisicoesMedicamentos(nifuser, pass);
    }

    @Override
    public String ConsultaConsumosArtigos(String nifuser, String pass) throws LoginGLMNaoExiste, RemoteException {
        return gestorGPC.ConsultaConsumosArtigos(nifuser, pass);
    }

    @Override
    public String ConsultaConsumosMedicamentos(String nifuser, String pass) throws LoginGLMNaoExiste, RemoteException {
        return gestorGPC.ConsultaConsumosMedicamentos(nifuser, pass);
    }

    @Override
    public String AlertaArtigos(String nifuser, String pass) throws LoginGLMNaoExiste, RemoteException {
        return gestorGPC.AlertaArtigos(nifuser, pass);
    }

    @Override
    public String AlertaMedicamentos(String nifuser, String pass) throws LoginGLMNaoExiste, RemoteException {
        return gestorGPC.AlertaMedicamentos(nifuser, pass);
    }

    @Override
    public void criaLoginGLM(String nif0, String pass0, String nif1, String pass1) throws LoginGLMJaExiste, LoginGLMNaoExiste, RemoteException {
        gestorGPC.criaLoginGLM(nif0, pass0, nif1, pass1);
    }

    @Override
    public String getLoginGLMInfo(String nif0, String nif1, String pass1) throws LoginGPCNaoExiste, RemoteException {
        return gestorGPC.getLoginGLMInfo(nif0, nif1, pass1);
    }

    @Override
    public void AlterarNifLoginGLM(String nif0, String nifnovo, String nif1, String pass1) throws LoginGLMNaoExiste, RemoteException {
        gestorGPC.AlterarNifLoginGLM(nif0, nifnovo, nif1, pass1);
    }

    @Override
    public void AlterarPassLoginGLM(String nif0, String passnova, String nif1, String pass1) throws LoginGLMNaoExiste, RemoteException {
        gestorGPC.AlterarPassLoginGLM(nif0, passnova, nif1, pass1);
    }

    @Override
    public String procuraLoginGLMNif(String nif0, String nif1, String pass1) throws LoginGLMNaoExiste, RemoteException {
        return gestorGPC.procuraLoginGLMNif(nif0, nif1, pass1);
    }

    @Override
    public void removeLoginGLM(String nif0, String nif1, String pass1) throws LoginGLMNaoExiste, RemoteException {
        gestorGPC.removeLoginGLM(nif0, nif1, pass1);
    }

    @Override
    public String medicamentosMaisUtilizadosAtosFarmaceuticos(String nifuser, String pass) throws LoginGLMNaoExiste, RemoteException {
        return gestorGPC.medicamentosMaisUtilizadosAtosFarmaceuticos(nifuser, pass);
    }

    @Override
    public HashMap<Integer, Integer> artigosMaisUtilizadosAtosFarmaceuticos(String nifuser, String pass) throws LoginGLMNaoExiste, RemoteException {
        return gestorGPC.artigosMaisUtilizadosAtosFarmaceuticos(nifuser, pass);
    }

    @Override
    public HashMap<Integer, AtoFarmaceutico> listaAtoFarmaceutico(String nif, String nifuser, String pass) throws FarmaceuticoNaoExiste, LoginGLMNaoExiste, RemoteException {
        return gestorGPC.listaAtoFarmaceutico(nif, nifuser, pass);
    }

    @Override
    public HashMap<Integer, AtoFarmaceutico> listaAtoFarmaceuticoArtigo(int idArt, String nifuser, String pass) throws LoginGLMNaoExiste, RemoteException {
        return gestorGPC.listaAtoFarmaceuticoArtigo(idArt, nifuser, pass);
    }

    @Override
    public HashMap<Integer, AtoFarmaceutico> listaAtoFarmaceuticoMedicamento(int idMed, String nifuser, String pass) throws LoginGLMNaoExiste, RemoteException {
        return gestorGPC.listaAtoFarmaceuticoMedicamento(idMed, nifuser, pass);
    }

    @Override
    public HashMap<Integer, Integer> atosFarmaceuticosMaisMedicamentos(String nifuser, String pass) throws LoginGLMNaoExiste, RemoteException {
        return gestorGPC.atosFarmaceuticosMaisMedicamentos(nifuser, pass);
    }

    @Override
    public HashMap<Integer, Integer> atosFarmaceuticosMaisArtigos(String nifuser, String pass) throws LoginGLMNaoExiste, RemoteException {
        return gestorGPC.atosFarmaceuticosMaisArtigos(nifuser, pass);
    }

    @Override
    public HashMap<Integer, Integer> fornecedoresMaisArtigosDif(String nifuser, String pass) throws LoginGLMNaoExiste, RemoteException {
        return gestorGPC.fornecedoresMaisArtigosDif(nifuser, pass);
    }

    @Override
    public HashMap<Integer, Integer> fornecedoresMaisMedicamentosDif(String nifuser, String pass) throws LoginGLMNaoExiste, RemoteException {
        return gestorGPC.fornecedoresMaisMedicamentosDif(nifuser, pass);
    }

    @Override
    public HashMap<Integer, Integer> fornecedoresMaisArtigos(String nifuser, String pass) throws LoginGLMNaoExiste, RemoteException {
        return gestorGPC.fornecedoresMaisArtigos(nifuser, pass);
    }

    @Override
    public HashMap<Integer, Integer> fornecedoresMaisMedicamentos(String nifuser, String pass) throws LoginGLMNaoExiste, RemoteException {
        return gestorGPC.fornecedoresMaisMedicamentos(nifuser, pass);
    }
}