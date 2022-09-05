package progs;

import config.Configurations;
import data.entidades.*;
import data.exceptions.*;
import health.FarmaceuticoInterfaceGPC;
import health.FuncionarioInterface;
import health.UtenteInterface;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.rmi.NotBoundException;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class GestorGPC implements FuncionarioInterface, UtenteInterface, FarmaceuticoInterfaceGPC, Serializable {
    private static final long serialVersionUID = -9149936635246618824L;
    private HashMap<String, Utente> utentes;
    private HashMap<String, Medico> medicos;
    private HashMap<String, Enfermeiro> enfermeiros;
    private HashMap<Integer, AtoMedico> atosmedicos;
    private HashMap<Integer, AtoEnfermagem> atosenfermagem;
    private HashMap<String, String> loginGPC;
    private HashMap<String, String> loginUtentes;
    private HashMap<Integer,AtoFarmaceutico> atosfarmaceuticos;
    private HashMap<String, String> loginGLM;
    private HashMap<Integer, OutrosArtigos> outrosartigos;
    private HashMap<Integer, Medicamento> medicamentos;
    private HashMap<Integer, Integer> alertaartigos;
    private HashMap<Integer, Integer> alertamedicamentos;
    private HashMap<String, Farmaceutico> farmaceuticos;
    private HashMap<Integer, Integer> aquisicoes_artigos;
    private HashMap<Integer, Integer> aquisicoes_medicamentos;
    private HashMap<Integer, Integer> consumos_artigos;
    private HashMap<Integer, Integer> consumos_medicamentos;
    private HashMap<Integer, Fornecedor> fornecedores;

    public GestorGPC() {
        utentes = new HashMap<>();
        medicos = new HashMap<>();
        enfermeiros = new HashMap<>();
        farmaceuticos = new HashMap<>();
        atosmedicos = new HashMap<>();
        atosenfermagem = new HashMap<>();
        loginGPC = new HashMap<>();
        loginUtentes = new HashMap<>();
        atosfarmaceuticos = new HashMap<>();
        loginGLM = new HashMap<>();
        outrosartigos = new HashMap<>();
        medicamentos = new HashMap<>();
        alertaartigos = new HashMap<>();
        alertamedicamentos = new HashMap<>();
        aquisicoes_artigos = new HashMap<>();
        aquisicoes_medicamentos = new HashMap<>();
        consumos_artigos = new HashMap<>();
        consumos_medicamentos = new HashMap<>();
        fornecedores = new HashMap<>();
    }

    //-------------------------------------------------------------------------------------------------------------------
    // CARREGAMENTO DE FICHEIROS
    //MEDICOS
    public void load_medicos(String fname) {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(fname));
            String line;
            while ((line = br.readLine()) != null) {
                String tokens[] = line.split(";");
                for (int i = 0; i < tokens.length; i++) {
                    if (tokens[i].startsWith("\"")) {
                        tokens[i] = tokens[i].replace('"', ' ').strip();
                    }
                }
                medicos.put(tokens[2], new Medico(tokens[0], tokens[1], tokens[2],
                        tokens[3], tokens[4], tokens[5], tokens[6]));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //UTENTES
    public void load_utentes(String fname) {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(fname));
            String line;
            while ((line = br.readLine()) != null) {
                String tokens[] = line.split(":");
                for (int i = 0; i < tokens.length; i++) {
                    if (tokens[i].startsWith("\"")) {
                        tokens[i] = tokens[i].replace('"', ' ').strip();
                    }
                }

                utentes.put(tokens[2], new Utente(tokens[0], tokens[1], tokens[2],
                        tokens[3], tokens[4]));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //ENFERMEIROS
    public void load_enfermeiros(String fname) {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(fname));
            String line;
            while ((line = br.readLine()) != null) {
                String tokens[] = line.split(";");
                for (int i = 0; i < tokens.length; i++) {
                    if (tokens[i].startsWith("\"")) {
                        tokens[i] = tokens[i].replace('"', ' ').strip();
                    }
                }
                //System.out.println("Ola sou o Enfermeiro");
                enfermeiros.put(tokens[2], new Enfermeiro(tokens[0], tokens[1], tokens[2],
                        tokens[3], tokens[4], tokens[5]));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //LOGIN GPC
    public void load_passGPC(String fname) {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(fname));
            String line;
            while ((line = br.readLine()) != null) {
                String tokens[] = line.split(";");
                for (int i = 0; i < tokens.length; i++) {
                    if (tokens[i].startsWith("\"")) {
                        tokens[i] = tokens[i].replace('"', ' ').strip();
                    }
                }

                loginGPC.put(tokens[0], tokens[1]);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //LOGIN UTENTES
    public void load_passUtentes(String fname) {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(fname));
            String line;
            while ((line = br.readLine()) != null) {
                String tokens[] = line.split(";");
                for (int i = 0; i < tokens.length; i++) {
                    if (tokens[i].startsWith("\"")) {
                        tokens[i] = tokens[i].replace('"', ' ').strip();
                    }
                }

                loginUtentes.put(tokens[0], tokens[1]);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //LOGIN GLM
    public void load_passGLM(String fname) {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(fname));
            String line;
            while ((line = br.readLine()) != null) {
                String tokens[] = line.split(";");
                for (int i = 0; i < tokens.length; i++) {
                    if (tokens[i].startsWith("\"")) {
                        tokens[i] = tokens[i].replace('"', ' ').strip();
                    }
                }
                loginGLM.put(tokens[0], tokens[1]);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //FORNECEDORES
    public void load_fornecedores(String fname) {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(fname));
            String line;
            while ((line = br.readLine()) != null) {
                String tokens[] = line.split(";");
                for (int i = 0; i < tokens.length; i++) {
                    if (tokens[i].startsWith("\"")) {
                        tokens[i] = tokens[i].replace('"', ' ').strip();
                    }
                }
                fornecedores.put(Integer.parseInt(tokens[0]), new Fornecedor(Integer.parseInt(tokens[0]), tokens[1]));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //FARMACEUTICOS
    public void load_farmaceuticos(String fname) {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(fname));
            String line;
            while ((line = br.readLine()) != null) {
                String tokens[] = line.split(";");
                for (int i = 0; i < tokens.length; i++) {
                    if (tokens[i].startsWith("\"")) {
                        tokens[i] = tokens[i].replace('"', ' ').strip();
                    }
                }

                farmaceuticos.put(tokens[2], new Farmaceutico(tokens[0], tokens[1], tokens[2],
                        tokens[3], tokens[4]));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //MÉTODO AUXILIAR DOS LOADS
    public Fornecedor getFornecedor(String nome) throws FornecedorNaoExiste {
        Fornecedor res = null;
        for(Fornecedor f: fornecedores.values()){
            if(f.getNome().equalsIgnoreCase(nome)) res=f;
        }
        if (res == null) {
            throw new FornecedorNaoExiste();
        }
        return res;
    }

    //MEDICAMENTOS
    public void load_meds(String fname) {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(fname, StandardCharsets.ISO_8859_1));
            String line;
            while ((line = br.readLine()) != null) {
                String tokens[] = line.split(";");
                for (int i = 0; i < tokens.length; i++) {
                    if (tokens[i].startsWith("\"")) {
                        tokens[i] = tokens[i].replace('"', ' ').strip();
                    }
                }
                String nome_fornecedor = tokens[7].strip();
                //System.out.printf("nome_fornecedor "+ tokens[7] + "\n");
                Fornecedor fornecedor = getFornecedor(nome_fornecedor);
                medicamentos.put(Integer.parseInt(tokens[0]),
                        new Medicamento(Integer.parseInt(tokens[0]),tokens[1], tokens[2],
                                tokens[3], tokens[4],
                                tokens[5], Boolean.getBoolean(tokens[6]), fornecedor,Integer.parseInt(tokens[8])));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (FornecedorNaoExiste fornecedorNaoExiste) {
            fornecedorNaoExiste.printStackTrace();
        }
    }

    //ARTIGOS
    public void load_arts(String fname) {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(fname));
            String line;
            while ((line = br.readLine()) != null) {
                String tokens[] = line.split(";");
                for (int i = 0; i < tokens.length; i++) {
                    if (tokens[i].startsWith("\"")) {
                        tokens[i] = tokens[i].replace('"', ' ').strip();
                    }
                }
                String nome_fornecedor = tokens[2];
                //System.out.printf(tokens[0] + "nome_fornecedor "+ tokens[2] + "\n");
                Fornecedor fornecedor = getFornecedor(nome_fornecedor);
                outrosartigos.put(Integer.parseInt(tokens[0]),
                        new OutrosArtigos(Integer.parseInt(tokens[0]),tokens[1], fornecedor, Integer.parseInt(tokens[3])));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (FornecedorNaoExiste fornecedorNaoExiste) {
            fornecedorNaoExiste.printStackTrace();
        }
    }

    // GRAVAR DATABASE
    public void save_to(String file) throws IOException {
        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(file));
        os.writeObject(this);
        os.close();
    }

    //ATUALIZAR DATABASE
    public void update_db() throws IOException {
        try {
            save_to(Configurations.database1);
        } catch (IOException e) {
            System.out.println("Erro a gravar a BD");
        }
    }

    //CARREGAR DATABASE
    public static GestorGPC load_from(String file) throws IOException, ClassNotFoundException {
        ObjectInputStream is = new ObjectInputStream(new FileInputStream(file));
        GestorGPC o = (GestorGPC) is.readObject();
        return o;
    }

    // -----------------------------------------------------------------------------------------------------------------
    // GETS E SETS GENÉRICOS

    public HashMap<String, Utente> getUtentes() {
        return utentes;
    }

    public void setUtentes(HashMap<String, Utente> utentes) {
        this.utentes = utentes;
    }

    public HashMap<String, Medico> getMedicos() {
        return medicos;
    }

    public void setMedicos(HashMap<String, Medico> medicos) {
        this.medicos = medicos;
    }

    public HashMap<String, Enfermeiro> getEnfermeiros() {
        return enfermeiros;
    }

    public void setEnfermeiros(HashMap<String, Enfermeiro> enfermeiros) {
        this.enfermeiros = enfermeiros;
    }

    public HashMap<Integer, AtoMedico> getAtosmedicos() {
        return atosmedicos;
    }

    public void setAtosmedicos(HashMap<Integer, AtoMedico> atosmedicos) {
        this.atosmedicos = atosmedicos;
    }

    public HashMap<Integer, AtoEnfermagem> getAtosenfermagem() {
        return atosenfermagem;
    }

    public void setAtosenfermagem(HashMap<Integer, AtoEnfermagem> atosenfermagem) {
        this.atosenfermagem = atosenfermagem;
    }

    public HashMap<String, String> getLoginGPC() {
        return loginGPC;
    }

    public void setLoginGPC(HashMap<String, String> loginGPC) {
        this.loginGPC = loginGPC;
    }

    public HashMap<String, String> getLoginUtentes() {
        return loginUtentes;
    }

    public void setLoginUtentes(HashMap<String, String> loginUtentes) {
        this.loginUtentes = loginUtentes;
    }

    public HashMap<Integer, AtoFarmaceutico> getAtosfarmaceuticos() {
        return atosfarmaceuticos;
    }

    public void setAtosfarmaceuticos(HashMap<Integer, AtoFarmaceutico> atosfarmaceuticos) {
        this.atosfarmaceuticos = atosfarmaceuticos;
    }

    public HashMap<String, String> getLoginGLM() {
        return loginGLM;
    }

    public void setLoginGLM(HashMap<String, String> loginGLM) {
        this.loginGLM = loginGLM;
    }

    public HashMap<Integer, OutrosArtigos> getOutrosartigos() {
        return outrosartigos;
    }

    public void setOutrosartigos(HashMap<Integer, OutrosArtigos> outrosartigos) {
        this.outrosartigos = outrosartigos;
    }

    public HashMap<Integer, Medicamento> getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(HashMap<Integer, Medicamento> medicamentos) {
        this.medicamentos = medicamentos;
    }

    public HashMap<Integer, Integer> getAlertaartigos() {
        return alertaartigos;
    }

    public void setAlertaartigos(HashMap<Integer, Integer> alertaartigos) {
        this.alertaartigos = alertaartigos;
    }

    public HashMap<Integer, Integer> getAlertamedicamentos() {
        return alertamedicamentos;
    }

    public void setAlertamedicamentos(HashMap<Integer, Integer> alertamedicamentos) {
        this.alertamedicamentos = alertamedicamentos;
    }

    public HashMap<String, Farmaceutico> getFarmaceuticos() {
        return farmaceuticos;
    }

    public void setFarmaceuticos(HashMap<String, Farmaceutico> farmaceuticos) {
        this.farmaceuticos = farmaceuticos;
    }

    public HashMap<Integer, Integer> getAquisicoes_artigos() {
        return aquisicoes_artigos;
    }

    public void setAquisicoes_artigos(HashMap<Integer, Integer> aquisicoes_artigos) {
        this.aquisicoes_artigos = aquisicoes_artigos;
    }

    public HashMap<Integer, Integer> getAquisicoes_medicamentos() {
        return aquisicoes_medicamentos;
    }

    public void setAquisicoes_medicamentos(HashMap<Integer, Integer> aquisicoes_medicamentos) {
        this.aquisicoes_medicamentos = aquisicoes_medicamentos;
    }

    public HashMap<Integer, Integer> getConsumos_artigos() {
        return consumos_artigos;
    }

    public void setConsumos_artigos(HashMap<Integer, Integer> consumos_artigos) {
        this.consumos_artigos = consumos_artigos;
    }

    public HashMap<Integer, Integer> getConsumos_medicamentos() {
        return consumos_medicamentos;
    }

    public void setConsumos_medicamentos(HashMap<Integer, Integer> consumos_medicamentos) {
        this.consumos_medicamentos = consumos_medicamentos;
    }

    public HashMap<Integer, Fornecedor> getFornecedores() {
        return fornecedores;
    }

    public void setFornecedores(HashMap<Integer, Fornecedor> fornecedores) {
        this.fornecedores = fornecedores;
    }

    @Override
    public void save() throws IOException, NotBoundException {

    }

    //------------------------------------------------------------------------------------------------------------------
    //GESTÃO DO UTENTE POR PARTE DO UTENTE
    public String getUtenteInfo(String nif,String nifuser,String pass) throws UtenteNaoExiste, LoginUtenteNaoExiste {
        Utente ut = utentes.get(nif);
        if (ut == null) {
            throw new UtenteNaoExiste();
        }else{
                if (loginUtentes.get(nifuser).equals(pass)) {
                    return ut.toString();
                }
                else {
                    throw new LoginUtenteNaoExiste();
                }
        }
    }

    //MÉTODO AUXILIAR PARA OS LOADS
    public Utente getUtente(String nif) throws UtenteNaoExiste {
        Utente ut = utentes.get(nif);
        if (ut == null) {
            throw new UtenteNaoExiste();
        }
        return ut;
    }

    public void AlterarNomeUtente(String nif, String nome,String nifuser,String pass) throws UtenteNaoExiste, LoginUtenteNaoExiste {
        Utente ut = utentes.get(nif);
        if (ut == null) {
            throw new UtenteNaoExiste();
        }else{
            if (loginUtentes.get(nifuser).equals(pass)) {
                ut.setNome(nome);
            }
            else {
                throw new LoginUtenteNaoExiste();
            }
        }
    }

    public void AlterarBiUtente(String nif, String bi,String nifuser,String pass) throws UtenteNaoExiste, LoginUtenteNaoExiste {
        Utente ut = utentes.get(nif);
        if (ut == null) {
            throw new UtenteNaoExiste();
        }else{
            if (loginUtentes.get(nifuser).equals(pass)) {
                ut.setBi(bi);
            }
            else {
                throw new LoginUtenteNaoExiste();
            }
        }
    }

    public void AlterarNifUtente(String nif0, String nif1, String nifuser, String pass) throws UtenteNaoExiste, LoginUtenteNaoExiste {
        Utente ut = utentes.get(nif0);
        if (ut == null) {
            throw new UtenteNaoExiste();
        }else{
            if (loginUtentes.get(nifuser).equals(pass)) {
                if (! utentes.containsKey(nif1)) {
                    ut.setNif(nif1);
                }
            }
            else {
                throw new LoginUtenteNaoExiste();
            }
        }

    }

    public void AlterarMoradaUtente(String nif, String morada,String nifuser, String pass) throws UtenteNaoExiste, LoginUtenteNaoExiste {
        Utente ut = utentes.get(nif);
        if (ut == null) {
            throw new UtenteNaoExiste();
        }else{
            if (loginUtentes.get(nifuser).equals(pass)) {
                ut.setMorada(morada);
            }
            else {
                throw new LoginUtenteNaoExiste();
            }
        }
    }

    public void AlterarCodigoUtente(String nif, String codigo_postal, String nifuser, String pass) throws UtenteNaoExiste, LoginUtenteNaoExiste {
        Utente ut = utentes.get(nif);
        if (ut == null) {
            throw new UtenteNaoExiste();
        }else{
            if (loginUtentes.get(nifuser).equals(pass)) {
                ut.setCodigo_postal(codigo_postal);
            }
            else {
                throw new LoginUtenteNaoExiste();
            }
        }
    }

    public String procuraUtenteNif(String nif,String nifuser, String pass) throws UtenteNaoExiste, LoginUtenteNaoExiste {
        Utente ut = utentes.get(nif);
        if (ut == null){
            throw  new UtenteNaoExiste();
        }else{
            if (loginUtentes.get(nifuser).equals(pass)) {
                return ut.toString();
            }
            else {
                throw new LoginUtenteNaoExiste();
            }
        }
    }

    public String procuraUtenteBi(String bi,String nifuser, String pass) throws UtenteNaoExiste, LoginUtenteNaoExiste {
        List<Utente> procura = new ArrayList<>();
        for (Utente u : utentes.values()) {
            if (u.getBi().equals(bi)) {
                procura.add(u);
            }
        }
        if (procura.isEmpty()) {
            throw new UtenteNaoExiste();
        }else{
            if (loginUtentes.get(nifuser).equals(pass)) {
                return procura.toString();
            }
            else {
                throw new LoginUtenteNaoExiste();
            }
        }
    }

    public String procuraUtenteNome(String nome,String nifuser, String pass) throws UtenteNaoExiste, LoginUtenteNaoExiste {
        List<Utente> procura = new ArrayList<>();
        for (Utente u : utentes.values()) {
            if (u.getNome().equals(nome)) {
                procura.add(u);
            }
        }
        if (procura.isEmpty()) {
            throw new UtenteNaoExiste();
        }else{
            if (loginUtentes.get(nifuser).equals(pass)) {
                return procura.toString();
            }
            else {
                throw new LoginUtenteNaoExiste();
            }
        }
    }

    public String procuraUtenteMorada(String morada, String nifuser, String pass) throws UtenteNaoExiste, LoginUtenteNaoExiste {
        List<Utente> procura = new ArrayList<>();
        for (Utente u : utentes.values()) {
            if (u.getMorada().equals(morada)) {
                procura.add(u);
            }
        }
        if (procura.isEmpty()) {
            throw new UtenteNaoExiste();
        }else{
            if (loginUtentes.get(nifuser).equals(pass)) {
                return procura.toString();
            }
            else {
                throw new LoginUtenteNaoExiste();
            }
        }
    }

    public String procuraUtenteCodigo(String codigo_postal, String nifuser, String pass) throws UtenteNaoExiste, LoginUtenteNaoExiste {
        List<Utente> procura = new ArrayList<>();
        for (Utente u : utentes.values()) {
            if (u.getCodigo_postal().equals(codigo_postal)) {
                procura.add(u);
            }
        }
        if (procura.isEmpty()) {
            throw new UtenteNaoExiste();
        }else{
            if (loginUtentes.get(nifuser).equals(pass)) {
                return procura.toString();
            }
            else {
                throw new LoginUtenteNaoExiste();
            }
        }
    }

    //------------------------------------------------------------------------------------------------------------------
    //GESTÃO DO UTENTE POR PARTE DO MÉDICO OU ENFERMEIRO
    public synchronized void criaUtenteGPC(String nome, String bi, String nif, String morada, String codigo_postal, String nifuser, String pass) throws
            UtenteJaExiste, LoginGPCNaoExiste {
        if (this.utentes.containsKey(nif)) {
            throw new UtenteJaExiste();
        } else {
            if (loginGPC.get(nifuser).equals(pass)) {
                Utente u = new Utente(nome, bi, nif, morada, codigo_postal);
                utentes.put(u.getNif(), u);
            }
            else{
                throw new LoginGPCNaoExiste();
            }
        }
    }

    public String getUtenteInfoGPC(String nif,String nifuser,String pass) throws UtenteNaoExiste, LoginGPCNaoExiste {
        Utente ut = utentes.get(nif);
        if (ut == null) {
            throw new UtenteNaoExiste();
        }else{
            if (loginGPC.get(nifuser).equals(pass)) {
                return ut.toString();
            }
            else {
                throw new LoginGPCNaoExiste();
            }
        }
    }

    public void AlterarNomeUtenteGPC(String nif, String nome,String nifuser,String pass) throws UtenteNaoExiste, LoginGPCNaoExiste {
        Utente ut = utentes.get(nif);
        if (ut == null) {
            throw new UtenteNaoExiste();
        }else{
            if (loginGPC.get(nifuser).equals(pass)) {
                ut.setNome(nome);
            }
            else {
                throw new LoginGPCNaoExiste();
            }
        }
    }

    public void AlterarBiUtenteGPC(String nif, String bi,String nifuser,String pass) throws UtenteNaoExiste, LoginGPCNaoExiste {
        Utente ut = utentes.get(nif);
        if (ut == null) {
            throw new UtenteNaoExiste();
        }else{
            if (loginGPC.get(nifuser).equals(pass)) {
                ut.setBi(bi);
            }
            else {
                throw new LoginGPCNaoExiste();
            }
        }
    }

    public void AlterarNifUtenteGPC(String nif0, String nif1, String nifuser, String pass) throws UtenteNaoExiste, LoginGPCNaoExiste {
        Utente ut = utentes.get(nif0);
        if (ut == null) {
            throw new UtenteNaoExiste();
        }else{
            if (loginGPC.get(nifuser).equals(pass)) {
                if (! utentes.containsKey(nif1)) {
                    ut.setNif(nif1);
                }
            }
            else {
                throw new LoginGPCNaoExiste();
            }
        }

    }

    public void AlterarMoradaUtenteGPC(String nif, String morada,String nifuser, String pass) throws UtenteNaoExiste, LoginGPCNaoExiste {
        Utente ut = utentes.get(nif);
        if (ut == null) {
            throw new UtenteNaoExiste();
        }else{
            if (loginGPC.get(nifuser).equals(pass)) {
                ut.setMorada(morada);
            }
            else {
                throw new LoginGPCNaoExiste();
            }
        }
    }

    public void AlterarCodigoUtenteGPC(String nif, String codigo_postal, String nifuser, String pass) throws UtenteNaoExiste, LoginGPCNaoExiste {
        Utente ut = utentes.get(nif);
        if (ut == null) {
            throw new UtenteNaoExiste();
        }else{
            if (loginGPC.get(nifuser).equals(pass)) {
                ut.setCodigo_postal(codigo_postal);
            }
            else {
                throw new LoginGPCNaoExiste();
            }
        }
    }

    public String procuraUtenteNifGPC(String nif,String nifuser, String pass) throws UtenteNaoExiste, LoginGPCNaoExiste {
        Utente ut = utentes.get(nif);
        if (ut == null){
            throw  new UtenteNaoExiste();
        }else{
            if (loginGPC.get(nifuser).equals(pass)) {
                return ut.toString();
            }
            else {
                throw new LoginGPCNaoExiste();
            }
        }
    }

    public String procuraUtenteBiGPC(String bi,String nifuser, String pass) throws UtenteNaoExiste, LoginGPCNaoExiste {
        List<Utente> procura = new ArrayList<>();
        for (Utente u : utentes.values()) {
            if (u.getBi().equals(bi)) {
                procura.add(u);
            }
        }
        if (procura.isEmpty()) {
            throw new UtenteNaoExiste();
        }else{
            if (loginGPC.get(nifuser).equals(pass)) {
                return procura.toString();
            }
            else {
                throw new LoginGPCNaoExiste();
            }
        }
    }

    public String procuraUtenteNomeGPC(String nome,String nifuser, String pass) throws UtenteNaoExiste, LoginGPCNaoExiste {
        List<Utente> procura = new ArrayList<>();
        for (Utente u : utentes.values()) {
            if (u.getNome().equals(nome)) {
                procura.add(u);
            }
        }
        if (procura.isEmpty()) {
            throw new UtenteNaoExiste();
        }else{
            if (loginGPC.get(nifuser).equals(pass)) {
                return procura.toString();
            }
            else {
                throw new LoginGPCNaoExiste();
            }
        }
    }

    public String procuraUtenteMoradaGPC(String morada, String nifuser, String pass) throws UtenteNaoExiste, LoginGPCNaoExiste {
        List<Utente> procura = new ArrayList<>();
        for (Utente u : utentes.values()) {
            if (u.getMorada().equals(morada)) {
                procura.add(u);
            }
        }
        if (procura.isEmpty()) {
            throw new UtenteNaoExiste();
        }else{
            if (loginGPC.get(nifuser).equals(pass)) {
                return procura.toString();
            }
            else {
                throw new LoginGPCNaoExiste();
            }
        }
    }

    public String procuraUtenteCodigoGPC(String codigo_postal, String nifuser, String pass) throws UtenteNaoExiste, LoginGPCNaoExiste {
        List<Utente> procura = new ArrayList<>();
        for (Utente u : utentes.values()) {
            if (u.getCodigo_postal().equals(codigo_postal)) {
                procura.add(u);
            }
        }
        if (procura.isEmpty()) {
            throw new UtenteNaoExiste();
        }else{
            if (loginGPC.get(nifuser).equals(pass)) {
                return procura.toString();
            }
            else {
                throw new LoginGPCNaoExiste();
            }
        }
    }

    public void removeUtenteGPC(String nif, String nifuser, String pass) throws UtenteNaoExiste, LoginGPCNaoExiste {
        if (!this.utentes.containsKey(nif)) {
            throw new UtenteNaoExiste();
        }else{
            if (loginUtentes.get(nifuser).equals(pass) || loginGPC.get(nifuser).equals(pass)) {
                utentes.remove(nif);
            }
            else {
                throw new LoginGPCNaoExiste();
            }
        }
    }

    //------------------------------------------------------------------------------------------------------------------
    //GESTÃO DOS MÉDICOS
    public synchronized void criaMedico(String nome, String bi, String nif, String morada, String codigo_postal, String especialidade, String cedula, String nifuser, String pass)
            throws MedicoJaExiste, LoginGPCNaoExiste {
        if (this.medicos.containsKey(nif)) {
            throw new MedicoJaExiste();
        } else{
            if (loginGPC.get(nifuser).equals(pass)) {
                Medico m = new Medico(nome, bi, nif, morada, codigo_postal, especialidade, cedula);
                medicos.put(m.getNif(), m);
            }
            else {
                throw new LoginGPCNaoExiste();
            }
        }


    }

    public String getMedicoInfo(String nif, String nifuser, String pass) throws MedicoNaoExiste, LoginGPCNaoExiste {
        Medico m = medicos.get(nif);
        if (m == null) {
            throw new MedicoNaoExiste();
        }else{
            if (loginGPC.get(nifuser).equals(pass)) {
                return m.toString();
            }
            else {
                throw new LoginGPCNaoExiste();
            }
        }
    }

    //MÉTODO AUXILIAR DOS LOADS
    public Medico getMedico(String nif) throws MedicoNaoExiste {
        Medico m = medicos.get(nif);
        if (m == null) {
            throw new MedicoNaoExiste();
        }
        return m;
    }

    public void AlterarNomeMedico(String nif, String nome, String nifuser, String pass) throws MedicoNaoExiste, LoginGPCNaoExiste {
        Medico m = medicos.get(nif);
        if (m == null) {
            throw new MedicoNaoExiste();
        }else{
            if (loginGPC.get(nifuser).equals(pass)) {
                m.setNome(nome);
            }
            else {
                throw new LoginGPCNaoExiste();
            }
        }
    }

    public void AlterarBiMedico(String nif, String bi, String nifuser, String pass) throws MedicoNaoExiste, LoginGPCNaoExiste {
        Medico m = medicos.get(nif);
        if (m == null) {
            throw new MedicoNaoExiste();
        }else{
            if (loginGPC.get(nifuser).equals(pass)) {
                m.setBi(bi);
            }
            else {
                throw new LoginGPCNaoExiste();
            }
        }
    }

    public void AlterarNifMedico(String nif0, String nif1, String nifuser, String pass) throws MedicoNaoExiste, LoginGPCNaoExiste {
        Medico m = medicos.get(nif0);
        if (m == null) {
            throw new MedicoNaoExiste();
        }else{
            if (loginGPC.get(nifuser).equals(pass)) {
                if (! medicos.containsKey(nif1)) {
                    m.setNif(nif1);
            }
            else {
                throw new LoginGPCNaoExiste();
            }
            }
        }
    }

    public void AlterarMoradaMedico(String nif, String morada, String nifuser, String pass) throws MedicoNaoExiste, LoginGPCNaoExiste {
        Medico m = medicos.get(nif);
        if (m == null) {
            throw new MedicoNaoExiste();
        } else {
            if (loginGPC.get(nifuser).equals(pass)) {
                m.setMorada(morada);
            } else {
                throw new LoginGPCNaoExiste();
            }
        }
    }

    public void AlterarCodigoMedico(String nif, String codigo_postal, String nifuser, String pass) throws MedicoNaoExiste, LoginGPCNaoExiste {
        Medico m = medicos.get(nif);
        if (m == null) {
            throw new MedicoNaoExiste();
        }else {
            if (loginGPC.get(nifuser).equals(pass)) {
                m.setCodigo_postal(codigo_postal);
            } else {
                throw new LoginGPCNaoExiste();
            }
        }
    }

    public void AlterarEspecialidadeMedico(String nif, String especialidade, String nifuser, String pass) throws MedicoNaoExiste, LoginGPCNaoExiste {
        Medico m = medicos.get(nif);
        if (m == null) {
            throw new MedicoNaoExiste();
        }else {
            if (loginGPC.get(nifuser).equals(pass)) {
                m.setEspecialidade(especialidade);
            } else {
                throw new LoginGPCNaoExiste();
            }
        }
    }

    public void AlterarCedulaMedico(String nif, String cedula, String nifuser, String pass) throws MedicoNaoExiste, LoginGPCNaoExiste {
        Medico m = medicos.get(nif);
        if (m == null) {
            throw new MedicoNaoExiste();
        }else {
            if (loginGPC.get(nifuser).equals(pass)) {
                m.setCedula(cedula);
            } else {
                throw new LoginGPCNaoExiste();
            }
        }
    }

    public String procuraMedicoNif(String nif,String nifuser, String pass) throws MedicoNaoExiste, LoginGPCNaoExiste {
        Medico m = medicos.get(nif);
        if (m == null){
            throw  new MedicoNaoExiste();
        }else {
            if (loginGPC.get(nifuser).equals(pass)) {
                return m.toString();
            } else {
                throw new LoginGPCNaoExiste();
            }
        }
    }

    public String procuraMedicoBi(String bi, String nifuser, String pass) throws MedicoNaoExiste, LoginGPCNaoExiste {
        List<Medico> procura = new ArrayList<>();
        for (Medico m : medicos.values()) {
            if (m.getBi().equals(bi)) {
                procura.add(m);
            }
        }
        if (procura.isEmpty()) {
            throw new MedicoNaoExiste();
        }else {
            if (loginGPC.get(nifuser).equals(pass)) {
                return procura.toString();
            } else {
                throw new LoginGPCNaoExiste();
            }
        }
    }

    public String procuraMedicosNome(String nome, String nifuser, String pass) throws MedicoNaoExiste, LoginGPCNaoExiste {
        List<Medico> procura = new ArrayList<>();
        for (Medico m : medicos.values()) {
            if (m.getNome().equals(nome)) {
                procura.add(m);
            }
        }
        if (procura.isEmpty()) {
            throw new MedicoNaoExiste();
        }else {
            if (loginGPC.get(nifuser).equals(pass)) {
                return procura.toString();
            } else {
                throw new LoginGPCNaoExiste();
            }
        }
    }

    public String procuraMedicoMorada(String morada, String nifuser, String pass) throws MedicoNaoExiste, LoginGPCNaoExiste {
        List<Medico> procura = new ArrayList<>();
        for (Medico m: medicos.values()) {
            if (m.getMorada().equals(morada)) {
                procura.add(m);
            }
        }
        if (procura.isEmpty()) {
            throw new MedicoNaoExiste();
        }else {
            if (loginGPC.get(nifuser).equals(pass)) {
                return procura.toString();
            } else {
                throw new LoginGPCNaoExiste();
            }
        }
    }

    public String procuraMedicoCodigo(String codigo_postal, String nifuser, String pass) throws MedicoNaoExiste, LoginGPCNaoExiste {
        List<Medico> procura = new ArrayList<>();
        for (Medico m : medicos.values()) {
            if (m.getCodigo_postal().equals(codigo_postal)) {
                procura.add(m);
            }
        }
        if (procura.isEmpty()) {
            throw new MedicoNaoExiste();
        }else {
            if (loginGPC.get(nifuser).equals(pass)) {
                return procura.toString();
            } else {
                throw new LoginGPCNaoExiste();
            }
        }
    }

    public String procuraMedicoEspecialidade(String especialidade, String nifuser, String pass) throws MedicoNaoExiste, LoginGPCNaoExiste {
        List<Medico> procura = new ArrayList<>();
        for (Medico m : medicos.values()) {
            if (m.getEspecialidade().equals(especialidade)) {
                procura.add(m);
            }
        }
        if (procura.isEmpty()) {
            throw new MedicoNaoExiste();
        }else {
            if (loginGPC.get(nifuser).equals(pass)) {
                return procura.toString();
            } else {
                throw new LoginGPCNaoExiste();
            }
        }
    }

    public String procuraMedicoCedula(String cedula, String nifuser, String pass) throws MedicoNaoExiste, LoginGPCNaoExiste {
        List<Medico> procura = new ArrayList<>();
        for (Medico m : medicos.values()) {
            if (m.getCedula().equals(cedula)) {
                procura.add(m);
            }
        }
        if (procura.isEmpty()) {
            throw new MedicoNaoExiste();
        }else {
            if (loginGPC.get(nifuser).equals(pass)) {
                return  procura.toString();
            } else {
                throw new LoginGPCNaoExiste();
            }
        }
    }

    public void removeMedico(String nif, String nifuser, String pass) throws MedicoNaoExiste, LoginGPCNaoExiste {
        if (!this.medicos.containsKey(nif)) {
            throw new MedicoNaoExiste();
        }else {
            if (loginGPC.get(nifuser).equals(pass)) {
                medicos.remove(nif);
            } else {
                throw new LoginGPCNaoExiste();
            }
        }
    }

    //------------------------------------------------------------------------------------------------------------------
    //GESTÃO DOS ENFERMEIROS
    public synchronized void criaEnfermeiro(String nome, String bi, String nif, String morada, String codigo_postal, String especialidade, String nifuser, String pass)
            throws EnfermeiroJaExiste, LoginGPCNaoExiste {
        if (this.enfermeiros.containsKey(nif)) {
            throw new EnfermeiroJaExiste();
        } else {
            if (loginGPC.get(nifuser).equals(pass)) {
                Enfermeiro e = new Enfermeiro(nome, bi, nif, morada, codigo_postal, especialidade);
                enfermeiros.put(e.getNif(), e);
            } else {
                throw new LoginGPCNaoExiste();
            }
        }
    }

    public String getEnfermeiroInfo(String nif, String nifuser, String pass) throws EnfermeiroNaoExiste, LoginGPCNaoExiste {
        Enfermeiro e = enfermeiros.get(nif);
        if (e == null) {
            throw new EnfermeiroNaoExiste();
        }else {
            if (loginGPC.get(nifuser).equals(pass)) {
                return e.toString();
            } else {
                throw new LoginGPCNaoExiste();
            }
        }
    }

    public void AlterarNomeEnfermeiro(String nif, String nome, String nifuser, String pass) throws EnfermeiroNaoExiste, LoginGPCNaoExiste {
        Enfermeiro e = enfermeiros.get(nif);
        if (e == null) {
            throw new EnfermeiroNaoExiste();
        }else {
            if (loginGPC.get(nifuser).equals(pass)) {
                e.setNome(nome);
            } else {
                throw new LoginGPCNaoExiste();
            }
        }
    }

    public void AlterarBiEnfermeiro(String nif, String bi, String nifuser, String pass) throws EnfermeiroNaoExiste, LoginGPCNaoExiste {
        Enfermeiro e = enfermeiros.get(nif);
        if (e == null) {
            throw new EnfermeiroNaoExiste();
        }else {
            if (loginGPC.get(nifuser).equals(pass)) {
                if (! enfermeiros.containsKey(nif)) {
                    e.setBi(bi);
                }
            } else {
                throw new LoginGPCNaoExiste();
            }
        }

    }

    public void AlterarNifEnfermeiro(String nif0, String nif1,String nifuser, String pass) throws EnfermeiroNaoExiste, LoginGPCNaoExiste {
        Enfermeiro e = enfermeiros.get(nif0);
        if (e == null) {
            throw new EnfermeiroNaoExiste();
        }else {
            if (loginGPC.get(nifuser).equals(pass)) {
                if (! enfermeiros.containsKey(nif1)) {
                    e.setNif(nif1);
                }
            } else {
                throw new LoginGPCNaoExiste();
            }
        }
    }

    public void AlterarMoradaEnfermeiro(String nif, String morada, String nifuser, String pass) throws EnfermeiroNaoExiste, LoginGPCNaoExiste {
        Enfermeiro e = enfermeiros.get(nif);
        if (e == null) {
            throw new EnfermeiroNaoExiste();
        }else {
            if (loginGPC.get(nifuser).equals(pass)) {
                e.setMorada(morada);
            } else {
                throw new LoginGPCNaoExiste();
            }
        }
    }

    public void AlterarCodigoEnfermeiro(String nif, String codigo_postal, String nifuser, String pass) throws EnfermeiroNaoExiste, LoginGPCNaoExiste {
        Enfermeiro e = enfermeiros.get(nif);
        if (e == null) {
            throw new EnfermeiroNaoExiste();
        }else {
            if (loginGPC.get(nifuser).equals(pass)) {
                e.setCodigo_postal(codigo_postal);
            } else {
                throw new LoginGPCNaoExiste();
            }
        }
    }

    public void AlterarEspecialidadeEnfermeiro(String nif, String especialidade, String nifuser, String pass) throws EnfermeiroNaoExiste, LoginGPCNaoExiste {
        Enfermeiro e = enfermeiros.get(nif);
        if (e == null) {
            throw new EnfermeiroNaoExiste();
        }else {
            if (loginGPC.get(nifuser).equals(pass)) {
                e.setEspecialidade(especialidade);
            } else {
                throw new LoginGPCNaoExiste();
            }
        }
    }

    public String procuraEnfermeiroNif(String nif, String nifuser, String pass) throws EnfermeiroNaoExiste, LoginGPCNaoExiste {
        Enfermeiro e = enfermeiros.get(nif);
        if (e == null){
            throw  new EnfermeiroNaoExiste();
        }else {
            if (loginGPC.get(nifuser).equals(pass)) {
                return e.toString();
            } else {
                throw new LoginGPCNaoExiste();
            }
        }
    }

    public String procuraEnfermeiroBi(String bi, String nifuser, String pass) throws EnfermeiroNaoExiste, LoginGPCNaoExiste {
        List<Enfermeiro> procura = new ArrayList<>();
        for (Enfermeiro e : enfermeiros.values()) {
            if (e.getBi().equals(bi)) {
                procura.add(e);
            }
        }
        if (procura.isEmpty()) {
            throw new EnfermeiroNaoExiste();
        }else {
            if (loginGPC.get(nifuser).equals(pass)) {
                return procura.toString();
            } else {
                throw new LoginGPCNaoExiste();
            }
        }
    }

    public String procuraEnfermeiroNome(String nome, String nifuser, String pass) throws EnfermeiroNaoExiste, LoginGPCNaoExiste {
        List<Enfermeiro> procura = new ArrayList<>();
        for (Enfermeiro e: enfermeiros.values()) {
            if (e.getNome().equals(nome)) {
                procura.add(e);
            }
        }
        if (procura.isEmpty()) {
            throw new EnfermeiroNaoExiste();
        }else {
            if (loginGPC.get(nifuser).equals(pass)) {
                return procura.toString();
            } else {
                throw new LoginGPCNaoExiste();
            }
        }
    }

    public String procuraEnfermeiroMorada(String morada, String nifuser, String pass) throws EnfermeiroNaoExiste, LoginGPCNaoExiste {
        List<Enfermeiro> procura = new ArrayList<>();
        for (Enfermeiro e: enfermeiros.values()) {
            if (e.getMorada().equals(morada)) {
                procura.add(e);
            }
        }
        if (procura.isEmpty()) {
            throw new EnfermeiroNaoExiste();
        }else {
            if (loginGPC.get(nifuser).equals(pass)) {
                return procura.toString();
            } else {
                throw new LoginGPCNaoExiste();
            }
        }
    }

    public String procuraEnfermeiroCodigo(String codigo_postal, String nifuser, String pass) throws EnfermeiroNaoExiste, LoginGPCNaoExiste {
        List<Enfermeiro> procura = new ArrayList<>();
        for (Enfermeiro e : enfermeiros.values()) {
            if (e.getCodigo_postal().equals(codigo_postal)) {
                procura.add(e);
            }
        }
        if (procura.isEmpty()) {
            throw new EnfermeiroNaoExiste();
        }else {
            if (loginGPC.get(nifuser).equals(pass)) {
               return procura.toString();
            } else {
                throw new LoginGPCNaoExiste();
            }
        }
    }

    public String procuraEnfermeiroEspecialidade(String especialidade, String nifuser, String pass) throws EnfermeiroNaoExiste, LoginGPCNaoExiste {
        List<Enfermeiro> procura = new ArrayList<>();
        for (Enfermeiro e : enfermeiros.values()) {
            if (e.getEspecialidade().equals(especialidade)) {
                procura.add(e);
            }
        }
        if (procura.isEmpty()) {
            throw new EnfermeiroNaoExiste();
        }else {
            if (loginGPC.get(nifuser).equals(pass)) {
                return procura.toString();
            } else {
                throw new LoginGPCNaoExiste();
            }
        }
    }

    public void removeEnfermeiro(String nif, String nifuser, String pass) throws EnfermeiroNaoExiste, LoginGPCNaoExiste {
        if (!this.enfermeiros.containsKey(nif)) {
            throw new EnfermeiroNaoExiste();
        }else {
            if (loginGPC.get(nifuser).equals(pass)) {
                enfermeiros.remove(nif);
            } else {
                throw new LoginGPCNaoExiste();
            }
        }
    }

    //------------------------------------------------------------------------------------------------------------------
    //GESTÃO DOS FARMACÊUTICOS
    public synchronized void criaFarmaceutico(String nome, String bi, String nif, String morada, String codigo_postal, String nifuser, String pass)
            throws FarmaceuticoJaExiste, LoginGPCNaoExiste {
        if (this.farmaceuticos.containsKey(nif)) {
            throw new FarmaceuticoJaExiste();
        } else {
            if (loginGPC.get(nifuser).equals(pass)) {
                Farmaceutico f = new Farmaceutico(nome, bi, nif, morada, codigo_postal);
                farmaceuticos.put(f.getNif(), f);
            } else {
                throw new LoginGPCNaoExiste();
            }
        }
    }

    public String getFarmaceuticoInfo(String nif, String nifuser, String pass) throws FarmaceuticoNaoExiste, LoginGPCNaoExiste {
        Farmaceutico f = farmaceuticos.get(nif);
        if (f == null) {
            throw new FarmaceuticoNaoExiste();
        }else {
            if (loginGPC.get(nifuser).equals(pass)) {
                return f.toString();
            } else {
                throw new LoginGPCNaoExiste();
            }
        }
    }

    public void AlterarNomeFarmaceutico(String nif, String nome, String nifuser, String pass) throws FarmaceuticoNaoExiste, LoginGPCNaoExiste {
        Farmaceutico f = farmaceuticos.get(nif);
        if (f == null) {
            throw new FarmaceuticoNaoExiste();
        }else {
            if (loginGPC.get(nifuser).equals(pass)) {
                f.setNome(nome);
            } else {
                throw new LoginGPCNaoExiste();
            }
        }
    }

    public void AlterarBiFarmaceutico(String nif, String bi, String nifuser, String pass) throws FarmaceuticoNaoExiste, LoginGPCNaoExiste {
        Farmaceutico f = farmaceuticos.get(nif);
        if (f == null) {
            throw new FarmaceuticoNaoExiste();
        }else {
            if (loginGPC.get(nifuser).equals(pass)) {
                f.setBi(bi);
            } else {
                throw new LoginGPCNaoExiste();
            }
        }
    }

    public void AlterarNifFarmaceutico(String nif0, String nif1, String nifuser, String pass) throws FarmaceuticoNaoExiste, LoginGPCNaoExiste {
        Farmaceutico f = farmaceuticos.get(nif0);
        if (f == null) {
            throw new FarmaceuticoNaoExiste();
        }else {
            if (loginGPC.get(nifuser).equals(pass)) {
                if (! farmaceuticos.containsKey(nif1)) {
                    f.setNif(nif1);
                }
            } else {
                throw new LoginGPCNaoExiste();
            }
        }
    }

    public void AlterarMoradaFarmaceutico(String nif, String morada, String nifuser, String pass) throws FarmaceuticoNaoExiste, LoginGPCNaoExiste {
        Farmaceutico f = farmaceuticos.get(nif);
        if (f == null) {
            throw new FarmaceuticoNaoExiste();
        }else {
            if (loginGPC.get(nifuser).equals(pass)) {
                f.setMorada(morada);
            } else {
                throw new LoginGPCNaoExiste();
            }
        }
    }

    public void AlterarCodigoFarmaceutico(String nif, String codigo_postal, String nifuser, String pass) throws FarmaceuticoNaoExiste, LoginGPCNaoExiste {
        Farmaceutico f =farmaceuticos.get(nif);
        if (f == null) {
            throw new FarmaceuticoNaoExiste();
        }else {
            if (loginGPC.get(nifuser).equals(pass)) {
                f.setCodigo_postal(codigo_postal);
            } else {
                throw new LoginGPCNaoExiste();
            }
        }
    }

    public String procuraFarmaceuticoNif(String nif, String nifuser, String pass) throws FarmaceuticoNaoExiste, LoginGPCNaoExiste {
        Farmaceutico f = farmaceuticos.get(nif);
        if (f == null){
            throw  new FarmaceuticoNaoExiste();
        }else {
            if (loginGPC.get(nifuser).equals(pass)) {
                return f.toString();
            } else {
                throw new LoginGPCNaoExiste();
            }
        }
    }

    public String procuraFarmaceuticoBi(String bi, String nifuser, String pass) throws FarmaceuticoNaoExiste, LoginGPCNaoExiste {
        List<Farmaceutico> procura = new ArrayList<>();
        for (Farmaceutico f : farmaceuticos.values()) {
            if (f.getBi().equals(bi)) {
                procura.add(f);
            }
        }
        if (procura.isEmpty()) {
            throw new FarmaceuticoNaoExiste();
        }else {
            if (loginGPC.get(nifuser).equals(pass)) {
                return procura.toString();
            } else {
                throw new LoginGPCNaoExiste();
            }
        }
    }

    public String procuraFarmaceuticoNome(String nome, String nifuser, String pass) throws FarmaceuticoNaoExiste, LoginGPCNaoExiste {
        List<Farmaceutico> procura = new ArrayList<>();
        for (Farmaceutico f: farmaceuticos.values()) {
            if (f.getNome().equals(nome)) {
                procura.add(f);
            }
        }
        if (procura.isEmpty()) {
            throw new FarmaceuticoNaoExiste();
        }else {
            if (loginGPC.get(nifuser).equals(pass)) {
                return procura.toString();
            } else {
                throw new LoginGPCNaoExiste();
            }
        }
    }

    public String procuraFarmaceuticoMorada(String morada, String nifuser, String pass) throws FarmaceuticoNaoExiste, LoginGPCNaoExiste {
        List<Farmaceutico> procura = new ArrayList<>();
        for (Farmaceutico f: farmaceuticos.values()) {
            if (f.getMorada().equals(morada)) {
                procura.add(f);
            }
        }
        if (procura.isEmpty()) {
            throw new FarmaceuticoNaoExiste();
        }else {
            if (loginGPC.get(nifuser).equals(pass)) {
                return procura.toString();
            } else {
                throw new LoginGPCNaoExiste();
            }
        }
    }

    public String procuraFarmaceuticoCodigo(String codigo_postal, String nifuser, String pass) throws FarmaceuticoNaoExiste, LoginGPCNaoExiste {
        List<Farmaceutico> procura = new ArrayList<>();
        for (Farmaceutico f: farmaceuticos.values()) {
            if (f.getCodigo_postal().equals(codigo_postal)) {
                procura.add(f);
            }
        }
        if (procura.isEmpty()) {
            throw new FarmaceuticoNaoExiste();
        }else {
            if (loginGPC.get(nifuser).equals(pass)) {
                return procura.toString();
            } else {
                throw new LoginGPCNaoExiste();
            }
        }
    }

    public void removeFarmaceutico(String nif, String nifuser, String pass) throws FarmaceuticoNaoExiste, LoginGPCNaoExiste {
        if (!this.farmaceuticos.containsKey(nif)) {
            throw new FarmaceuticoNaoExiste();
        }else {
            if (loginGPC.get(nifuser).equals(pass)) {
                farmaceuticos.remove(nif);
            } else {
                throw new LoginGPCNaoExiste();
            }
        }
    }
    //------------------------------------------------------------------------------------------------------------------
    //GESTÃO DOS FORNECEDORES
    public synchronized void criaFornecedor(int id, String nome,String nifuser, String pass) throws FornecedorJaExiste, LoginGLMNaoExiste {
        if (loginGLM.get(nifuser).equals(pass)) {
            if (this.fornecedores.containsKey(id)) {
                throw new FornecedorJaExiste();
            } else {
                Fornecedor f = new Fornecedor(id, nome);
                fornecedores.put(f.getId(), f);
            }
        }else {
            throw new LoginGLMNaoExiste();
        }
    }

    public String getFornecedorInfo(int id, String nome, String nifuser, String pass) throws FornecedorNaoExiste, LoginGLMJaExiste {
        if(loginGLM.get(nifuser).equals(pass)) {
            Fornecedor f = fornecedores.get(id);
            if (f == null) {
                throw new FornecedorNaoExiste();
            }
            return f.toString();
        } else {
            throw new LoginGLMJaExiste();
        }
    }

    public void AlterarNomeFornecedor(int id, String nome, String nifuser, String pass) throws FornecedorNaoExiste, LoginGLMJaExiste {
        if(loginGLM.get(nifuser).equals(pass)) {
            Fornecedor f = fornecedores.get(id);
            if (f == null) {
                throw new FornecedorNaoExiste();
            }
            f.setNome(nome);
        } else {
            throw new LoginGLMJaExiste();
        }

    }

    public void AlterarIdFornecedor(int id0, int id1, String nifuser, String pass) throws FornecedorNaoExiste, LoginGLMJaExiste {
        if(loginGLM.get(nifuser).equals(pass)) {
            Fornecedor f = fornecedores.get(id0);
            if (f == null) {
                throw new FornecedorNaoExiste();
            }
            if (! fornecedores.containsKey(id1)) {
                f.setId(id1);
            }
        } else {
            throw new LoginGLMJaExiste();
        }
    }

    public String procuraFornecedorId(int id, String nifuser, String pass) throws FornecedorNaoExiste, LoginGLMJaExiste {
        if(loginGLM.get(nifuser).equals(pass)) {
            Fornecedor f = fornecedores.get(id);
            if (f == null){
                throw  new FornecedorNaoExiste();
            }
            return f.toString();
        } else {
            throw new LoginGLMJaExiste();
        }
    }

    public String procuraFornecedorNome(String nome, String nifuser, String pass) throws FornecedorNaoExiste, LoginGLMJaExiste {
        if(loginGLM.get(nifuser).equals(pass)) {
            Fornecedor procura = new Fornecedor();
            for (Fornecedor f : fornecedores.values()) {
                if (f.getNome().equals(nome)) {
                    procura = f;
                }
            }
            if (procura.getNome() == null) {
                throw new FornecedorNaoExiste();
            }
            return procura.toString();
        } else{
            throw new LoginGLMJaExiste();
        }
    }

    public void removeFornecedor(int id, String nifuser, String pass) throws FornecedorNaoExiste, LoginGLMJaExiste {
        if(loginGLM.get(nifuser).equals(pass)) {
            if (!this.fornecedores.containsKey(id)) {
                throw new FornecedorNaoExiste();
            }
            fornecedores.remove(id);
        } else {
            throw new LoginGLMJaExiste();
        }
    }

    //----------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //ATOS MÉDICOS
    public synchronized void criaAtoMedico(int id, String nifmedico, String nifutente, LocalDateTime h, HashMap< Integer, Integer> lista_artigos, HashMap<Integer, Integer> lista_medicamentos, String nifuser, String pass)
            throws MedicoNaoExiste, UtenteNaoExiste, AtoMedicoJaExiste, MedicamentoNaoExiste, OutroArtigoNaoExiste, LoginGPCNaoExiste {

        if (this.atosmedicos.containsKey(id)) {
            throw new AtoMedicoJaExiste();
        } else {
            if (loginGPC.get(nifuser).equals(pass)) {
                Medico m = medicos.get(nifmedico);
                if (m == null) {
                    throw new MedicoNaoExiste();
                }

                Utente u = utentes.get(nifutente);
                if (u == null) {
                    throw new UtenteNaoExiste();
                }

                if (lista_artigos == null)
                    lista_artigos = new HashMap<>();

                if (lista_medicamentos == null)
                    lista_medicamentos = new HashMap<>();

                AtoMedico atom = new AtoMedico(id, m, u, h, lista_artigos, lista_medicamentos);
                atosmedicos.put(atom.getId(), atom);
                DiminuiStockArt(lista_artigos);
                DiminuiStockMed(lista_medicamentos);
            } else {
                throw new LoginGPCNaoExiste();
            }
        }
    }

    public void alteraIDAtoMedico(int oldID, int newID, String nifuser, String pass) throws AtoMedicoJaExiste, LoginGPCNaoExiste {
        if(this.atosmedicos.containsKey(newID)){
            System.out.println("Ja existe esse id");
            throw new AtoMedicoJaExiste();
        }else {
            if (loginGPC.get(nifuser).equals(pass)) {
                AtoMedico i = this.atosmedicos.get(oldID);
                this.atosmedicos.remove(oldID);
                this.atosmedicos.put(newID, i);
            } else {
                throw new LoginGPCNaoExiste();
            }
        }
    }

    public void alteraUtenteAtoMedico(int idAto, Utente u, String nifuser, String pass) throws AtoMedicoNaoExiste, LoginGPCNaoExiste {
        if (loginGPC.get(nifuser).equals(pass)) {
            if (this.atosmedicos.containsKey(idAto)) {
                this.atosmedicos.get(idAto).setU(u);
            } else {
                throw new AtoMedicoNaoExiste();
            }
        } else {
            throw new LoginGPCNaoExiste();
        }
    }

    public void alteraMedicoAtoMedico(int idAto, Medico m, String nifuser, String pass) throws AtoMedicoNaoExiste, LoginGPCNaoExiste {
        if (loginGPC.get(nifuser).equals(pass)) {
            if (this.atosmedicos.containsKey(idAto)) {
                this.atosmedicos.get(idAto).setM(m);
            } else {
                throw new AtoMedicoNaoExiste();
            }
        } else {
            throw new LoginGPCNaoExiste();
        }
    }

    public void alteraHoraAtoMedico(int idAto, LocalDateTime newHora, String nifuser, String pass) throws AtoMedicoNaoExiste, LoginGPCNaoExiste {
        if (loginGPC.get(nifuser).equals(pass)) {
            if (this.atosmedicos.containsKey(idAto)) {
                this.atosmedicos.get(idAto).setHora(newHora);
            } else {
                throw new AtoMedicoNaoExiste();
            }
        } else{
            throw new LoginGPCNaoExiste();
        }
    }

    public void alteraIDlistaArtigosAtoMedico(int idAto, int oldID, int newID, String nifuser, String pass) throws AtoMedicoNaoExiste, LoginGPCNaoExiste {
        if (loginGPC.get(nifuser).equals(pass)) {
            if (this.atosmedicos.containsKey(idAto)) {
                int quantidade = atosmedicos.get(idAto).getArtigos().get(oldID);
                atosmedicos.get(idAto).removeArtigo(oldID);
                atosmedicos.get(idAto).putArtigo(newID, quantidade);
            } else {
                throw new AtoMedicoNaoExiste();
            }
        } else {
            throw new LoginGPCNaoExiste();
        }
    }

    public void alteraQuantidadelistaArtigosAtoMedico(int idAto, int idArtigo, int newQuant, String nifuser, String pass) throws AtoMedicoNaoExiste, LoginGPCNaoExiste {
        if (loginGPC.get(nifuser).equals(pass)) {
            if (this.atosmedicos.containsKey(idAto)) {
                atosmedicos.get(idAto).removeArtigo(idArtigo);
                atosmedicos.get(idAto).putArtigo(idArtigo, newQuant);
            } else {
                throw new AtoMedicoNaoExiste();
            }
        } else {
            throw new LoginGPCNaoExiste();
        }
    }

    public void alteraIDlistaMedicamentosAtoMedico(int idAto, int oldID, int newID, String nifuser, String pass) throws AtoMedicoNaoExiste, LoginGPCNaoExiste {
        if (loginGPC.get(nifuser).equals(pass)) {
            if (this.atosmedicos.containsKey(idAto)) {
                int quantidade = atosmedicos.get(idAto).getMedicamentos().get(oldID);
                atosmedicos.get(idAto).removeMedicamento(oldID);
                atosmedicos.get(idAto).putMedicamento(newID, quantidade);
            } else {
                throw new AtoMedicoNaoExiste();
            }
        }else {
                throw new LoginGPCNaoExiste();
            }
    }

    public void alteraQuantidadelistaMedicamentosAtoMedico(int idAto, int idMedicamento, int newQuant, String nifuser, String pass) throws AtoMedicoNaoExiste, LoginGPCNaoExiste {
        if (loginGPC.get(nifuser).equals(pass)) {
            if (this.atosmedicos.containsKey(idAto)) {
                atosmedicos.get(idAto).removeMedicamento(idMedicamento);
                atosmedicos.get(idAto).putMedicamento(idMedicamento, newQuant);
            } else {
                throw new AtoMedicoNaoExiste();
            }
        }else {
            throw new LoginGPCNaoExiste();
        }
    }

    public AtoMedico procuraAtoMedicoID(int idAto, String nifu, String nifuser, String pass) throws AtoMedicoNaoExiste, LoginGPCNaoExiste {
        if (loginGPC.get(nifuser).equals(pass)) {
            if (this.atosmedicos.containsKey(idAto)) {
                return this.atosmedicos.get(idAto);
            } else {
                throw new AtoMedicoNaoExiste();
            }
        }else {
            throw new LoginGPCNaoExiste();
        }
    }

    public HashMap<Integer, AtoMedico> procuraAtoMedicoUtente(String nif, String nifuser, String pass) throws UtenteNaoExiste, LoginGPCNaoExiste {
        HashMap<Integer, AtoMedico> res = new HashMap<>();
        if (loginUtentes.get(nifuser).equals(pass) | loginGPC.get(nifuser).equals(pass)) {
            if (this.utentes.containsKey(nif)) {
                for (Integer key : this.atosmedicos.keySet()) {
                    AtoMedico am = this.atosmedicos.get(key);
                    if (am.getU().getNif().equals(nif)) {
                        res.put(key, am);
                    }
                }
                return res;
            } else {
                throw new UtenteNaoExiste();
            }
        } else {
            throw new LoginGPCNaoExiste();
        }
    }

    public HashMap<Integer, AtoMedico> procuraAtoMedicoMedico(String nif, String nifuser, String pass) throws MedicoNaoExiste, LoginGPCNaoExiste {
        HashMap<Integer, AtoMedico> res = new HashMap<>();
        if (loginGPC.get(nifuser).equals(pass)) {
            if (this.medicos.containsKey(nif)) {
                for (Integer key : this.atosmedicos.keySet()) {
                    AtoMedico am = this.atosmedicos.get(key);
                    if (am.getM().getNif().equals(nif)) {
                        res.put(key, am);
                    }
                }
                return res;
            } else {
                throw new MedicoNaoExiste();
            }
        }else{
            throw new LoginGPCNaoExiste();
        }
    }

    public HashMap<Integer, AtoMedico> procuraAtoMedicoHora(LocalDateTime h, String nifuser, String pass) throws LoginGPCNaoExiste {
        HashMap<Integer, AtoMedico> res = new HashMap<>();
        if (loginGPC.get(nifuser).equals(pass)) {
            for (Integer key : this.atosmedicos.keySet()) {
                AtoMedico am = this.atosmedicos.get(key);
                if (am.getHora().equals(h)) {
                    res.put(key, am);
                }
            }
            return res;
        } else {
            throw new LoginGPCNaoExiste();
        }
    }

    public HashMap<Integer, AtoMedico> procuraAtoMedicoArtigo(int idArt, String nifuser, String pass) throws LoginGPCNaoExiste {
        HashMap<Integer, AtoMedico> res = new HashMap<>();
        if (loginGPC.get(nifuser).equals(pass)) {
            for (Integer key : this.atosmedicos.keySet()) {
                AtoMedico am = this.atosmedicos.get(key);
                if (am.getArtigos().containsKey(idArt)) {
                    res.put(key, am);
                }
            }
            return res;
        } else {
            throw new LoginGPCNaoExiste();
        }
    }

    public HashMap<Integer, AtoMedico> procuraAtoMedicoMedicamento(int idMed, String nifuser, String pass) throws LoginGPCNaoExiste {
        HashMap<Integer, AtoMedico> res = new HashMap<>();
        if (loginGPC.get(nifuser).equals(pass)) {
            for (Integer key : this.atosmedicos.keySet()) {
                AtoMedico am = this.atosmedicos.get(key);
                if (am.getMedicamentos().containsKey(idMed)) {
                    res.put(key, am);
                }
            }
            return res;
        } else{
            throw new LoginGPCNaoExiste();
        }
    }

    public void removeAtoMedico(int id) throws AtoMedicoNaoExiste {
        if (!this.atosmedicos.containsKey(id)) {
            throw new AtoMedicoNaoExiste();
        }
        atosmedicos.remove(id);
    }

    //----------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //ATOS ENFERMAGEM
    public synchronized void criaAtoEnfermagem(int id, String nifenfermeiro, String nifutente, LocalDateTime h, HashMap< Integer, Integer> lista_artigos, String nifuser, String pass)
            throws EnfermeiroNaoExiste, UtenteNaoExiste, AtoEnfermagemJaExiste, OutroArtigoNaoExiste, LoginGPCNaoExiste {
        if (loginGPC.get(nifuser).equals(pass)) {
            if (this.atosenfermagem.containsKey(id)) {
                throw new AtoEnfermagemJaExiste();
            } else {
                Enfermeiro e = enfermeiros.get(nifenfermeiro);
                if (e == null) {
                    throw new EnfermeiroNaoExiste();
                }

                Utente u = utentes.get(nifutente);
                if (u == null) {
                    throw new UtenteNaoExiste();
                }

                if (lista_artigos == null)
                    lista_artigos = new HashMap<>();

                AtoEnfermagem atoe = new AtoEnfermagem(id, e, u, h, lista_artigos);
                atosenfermagem.put(atoe.getId(), atoe);
                DiminuiStockArt(lista_artigos);
            }
        } else{
            throw new LoginGPCNaoExiste();
        }
    }

    public void alteraIDAtoEnfermagem(int oldID, int newID, String nifuser, String pass) throws AtoEnfermagemJaExiste, LoginGPCNaoExiste {
        if (loginGPC.get(nifuser).equals(pass)) {
            if (this.atosenfermagem.containsKey(newID)) {
                System.out.println("Ja existe esse id");
                throw new AtoEnfermagemJaExiste();
            } else {
                AtoEnfermagem i = this.atosenfermagem.get(oldID);
                this.atosenfermagem.remove(oldID);
                this.atosenfermagem.put(newID, i);
            }
        } else{
            throw new LoginGPCNaoExiste();
        }
    }

    public void alteraUtenteAtoEnfermagem(int idAto, Utente u, String nifuser, String pass) throws AtoEnfermagemNaoExiste, LoginGPCNaoExiste {
        if (loginGPC.get(nifuser).equals(pass)) {
            if (this.atosenfermagem.containsKey(idAto)) {
                this.atosenfermagem.get(idAto).setU(u);
            } else {
                throw new AtoEnfermagemNaoExiste();
            }
        } else {
            throw new LoginGPCNaoExiste();
        }
    }

    public void alteraEnfermeiroAtoEnfermagem(int idAto, Enfermeiro e, String nifuser, String pass) throws AtoEnfermagemNaoExiste, LoginGPCNaoExiste {
        if (loginGPC.get(nifuser).equals(pass)) {
            if (this.atosenfermagem.containsKey(idAto)) {
                this.atosenfermagem.get(idAto).setE(e);
            } else {
                throw new AtoEnfermagemNaoExiste();
            }
        } else {
            throw new LoginGPCNaoExiste();
        }
    }

    public void alteraHoraAtoEnfermagem(int idAto, LocalDateTime newHora, String nifuser, String pass) throws AtoEnfermagemNaoExiste, LoginGPCNaoExiste {
        if (loginGPC.get(nifuser).equals(pass)) {
            if (this.atosenfermagem.containsKey(idAto)) {
                this.atosenfermagem.get(idAto).setHora(newHora);
            } else {
                throw new AtoEnfermagemNaoExiste();
            }
        } else {
            throw new LoginGPCNaoExiste();
        }
    }

    public void alteraIDlistaArtigosAtoEnfermagem(int idAto, int oldID, int newID, String nifuser, String pass) throws AtoEnfermagemNaoExiste, LoginGPCNaoExiste {
        if (loginGPC.get(nifuser).equals(pass)) {
            if (this.atosenfermagem.containsKey(idAto)) {
                int quantidade = atosenfermagem.get(idAto).getArtigos().get(oldID);
                atosenfermagem.get(idAto).removeArtigo(oldID);
                atosenfermagem.get(idAto).putArtigo(newID, quantidade);
            } else {
                throw new AtoEnfermagemNaoExiste();
            }
        } else {
            throw new LoginGPCNaoExiste();
        }
    }

    public void alteraQuantidadelistaArtigosAtoEnfermagem(int idAto, int idArtigo, int newQuant, String nifuser, String pass) throws AtoEnfermagemNaoExiste, LoginGPCNaoExiste {
        if (loginGPC.get(nifuser).equals(pass)) {
            if (this.atosenfermagem.containsKey(idAto)) {
                atosenfermagem.get(idAto).removeArtigo(idArtigo);
                atosenfermagem.get(idAto).putArtigo(idArtigo, newQuant);
            } else {
                throw new AtoEnfermagemNaoExiste();
            }
        } else {
            throw new LoginGPCNaoExiste();
        }
    }

    public AtoEnfermagem procuraAtoEnfermagemID(int idAto, String nifuser,String pass) throws AtoEnfermagemNaoExiste, LoginGPCNaoExiste {
        if (loginGPC.get(nifuser).equals(pass)) {
            if (this.atosenfermagem.containsKey(idAto)) {
                return this.atosenfermagem.get(idAto);
            } else {
                throw new AtoEnfermagemNaoExiste();
            }
        }else {
            throw new LoginGPCNaoExiste();
        }
    }

    public HashMap<Integer, AtoEnfermagem> procuraAtoEnfermagemUtente(String nif, String nifuser, String pass) throws UtenteNaoExiste, LoginGPCNaoExiste {
        HashMap<Integer, AtoEnfermagem> res = new HashMap<>();
        if (loginGPC.get(nifuser).equals(pass)) {
            if (this.utentes.containsKey(nif)) {
                for (Integer key : this.atosenfermagem.keySet()) {
                    AtoEnfermagem am = this.atosenfermagem.get(key);
                    if (am.getU().getNif().equals(nif)) {
                        res.put(key, am);
                    }
                }
                return res;
            } else {
                throw new UtenteNaoExiste();
            }
        }else{
            throw new LoginGPCNaoExiste();
        }
    }

    public HashMap<Integer, AtoEnfermagem> procuraAtoEnfermagemEnfermeiro(String nif, String nifuser, String pass) throws EnfermeiroNaoExiste, LoginGPCNaoExiste {
        HashMap<Integer, AtoEnfermagem> res = new HashMap<>();
        if (loginGPC.get(nifuser).equals(pass)) {
            if (this.enfermeiros.containsKey(nif)) {
                for (Integer key : this.atosenfermagem.keySet()) {
                    AtoEnfermagem ae = this.atosenfermagem.get(key);
                    if (ae.getE().getNif().equals(nif)) {
                        res.put(key, ae);
                    }
                }
                return res;
            } else {
                throw new EnfermeiroNaoExiste();
            }
        }else {
            throw new LoginGPCNaoExiste();
        }
    }

    public HashMap<Integer, AtoEnfermagem> procuraAtoEnfermagemHora(LocalDateTime h, String nifuser, String pass) throws LoginGPCNaoExiste {
        HashMap<Integer, AtoEnfermagem> res = new HashMap<>();
        if (loginGPC.get(nifuser).equals(pass)) {
            for (Integer key : this.atosenfermagem.keySet()) {
                AtoEnfermagem ae = this.atosenfermagem.get(key);
                if (ae.getHora().equals(h)) {
                    res.put(key, ae);
                }
            }
            return res;
        } else {
            throw new LoginGPCNaoExiste();
        }
    }

    public HashMap<Integer, AtoEnfermagem> procuraAtoEnfermagemArtigo(int idArt, String nifuser, String pass) throws LoginGPCNaoExiste {
        HashMap<Integer, AtoEnfermagem> res = new HashMap<>();
        if (loginGPC.get(nifuser).equals(pass)) {
            for (Integer key : this.atosenfermagem.keySet()) {
                AtoEnfermagem ae = this.atosenfermagem.get(key);
                if (ae.getArtigos().containsKey(idArt)) {
                    res.put(key, ae);
                }
            }
            return res;
        } else{
            throw new LoginGPCNaoExiste();
        }
    }

    public void removeAtoEnfermagem(int id, String nifuser, String pass) throws AtoEnfermagemNaoExiste, LoginGPCNaoExiste {
        if (loginGPC.get(nifuser).equals(pass)) {
            if (!this.atosenfermagem.containsKey(id)) {
                throw new AtoEnfermagemNaoExiste();
            }
            atosenfermagem.remove(id);
        } else {
            throw new LoginGPCNaoExiste();
        }
    }

    //---------------------------------------------------------------------------------------------------------------------------------------------
    //MANIPULAÇÃO DE LOGINS DE UTENTES POR PARTE DO UTENTE (dados do login que se quer criar (0) e dados do login da pessoa que está a criar (1)
    public String getLoginUtenteInfo(String nif0, String nif1, String pass1) throws LoginUtenteNaoExiste {
        if (loginUtentes.get(nif1).equals(pass1)) {
            return loginUtentes.get(nif0).toString();
        } else {
            throw new LoginUtenteNaoExiste();
        }
    }

    public void AlterarNifLoginUtente(String nif0, String nifnovo, String nif1, String pass1) throws  LoginUtenteNaoExiste {
        if (loginUtentes.get(nif1).equals(pass1)) {
            String pass = loginUtentes.get(nif0);
            loginUtentes.remove(nif0);
            loginUtentes.put(nif0, pass);
        } else {
            throw new LoginUtenteNaoExiste();
        }
    }

    public void AlterarPassLoginUtente(String nif0, String passnova, String nif1, String pass1) throws LoginUtenteNaoExiste {
        if (loginUtentes.get(nif1).equals(pass1)) {
            loginUtentes.remove(nif0);
            loginUtentes.put(nif0, passnova);
        } else {
            throw new LoginUtenteNaoExiste();
        }
    }

    public String procuraLoginUtenteNif(String nif0, String nif1, String pass1) throws LoginUtenteNaoExiste {
        if (loginUtentes.get(nif1).equals(pass1)) {
            return loginUtentes.get(nif0).toString();
        } else {
            throw new LoginUtenteNaoExiste();
        }
    }

    //---------------------------------------------------------------------------------------------------------------------------------------------
    //MANIPULAÇÃO DE LOGINS DE UTENTES POR PARTE DE MÉDICOS OU ENFERMEIROS (dados do login que se quer criar (0) e dados do login da pessoa que está a criar (1)
    public synchronized void criaLoginUtenteGPC(String nif0, String pass0, String nif1, String pass1) throws
            LoginGPCNaoExiste, LoginUtenteJaExiste {
        if (this.loginUtentes.containsKey(nif0)) {
            throw new LoginUtenteJaExiste();
        } else {
            if (loginGPC.get(nif1).equals(pass1)) {
                loginUtentes.put(nif0, pass0);
            } else {
                throw new LoginGPCNaoExiste();
            }
        }
    }

    public String getLoginUtenteInfoGPC(String nif0, String nif1, String pass1) throws LoginGPCNaoExiste {
        if (loginGPC.get(nif1).equals(pass1)) {
            return loginUtentes.get(nif0).toString();
        } else {
            throw new LoginGPCNaoExiste();
        }
    }

    public void AlterarNifLoginUtenteGPC(String nif0, String nifnovo, String nif1, String pass1) throws  LoginGPCNaoExiste {
        if (loginGPC.get(nif1).equals(pass1)) {
            String pass = loginUtentes.get(nif0);
            loginUtentes.remove(nif0);
            loginUtentes.put(nif0, pass);
        } else {
            throw new LoginGPCNaoExiste();
        }
    }

    public void AlterarPassLoginUtenteGPC(String nif0, String passnova, String nif1, String pass1) throws LoginGPCNaoExiste {
        if (loginGPC.get(nif1).equals(pass1)) {
            loginUtentes.remove(nif0);
            loginUtentes.put(nif0, passnova);
        } else {
            throw new LoginGPCNaoExiste();
        }
    }

    public String procuraLoginUtenteNifGPC(String nif0, String nif1, String pass1) throws LoginGPCNaoExiste {
        if (loginGPC.get(nif1).equals(pass1)) {
            return loginUtentes.get(nif0).toString();
        } else {
            throw new LoginGPCNaoExiste();
        }
    }

    public void removeLoginUtenteGPC(String nif0, String nif1, String pass1) throws LoginGPCNaoExiste {
        if (loginGPC.get(nif1).equals(pass1)) {
            loginUtentes.remove(nif0);
        } else {
            throw new LoginGPCNaoExiste();
        }
    }

    //---------------------------------------------------------------------------------------------------------------------------------------------
    //MANIPULAÇÃO DE LOGINS GPC (dados do login que se quer criar (0) e dados do login da pessoa que está a criar (1)
    public synchronized void criaLoginGPC(String nif0, String pass0, String nif1, String pass1) throws
             LoginGPCJaExiste, LoginGPCNaoExiste {
        if (this.loginGPC.containsKey(nif0)) {
            throw new LoginGPCJaExiste();
        } else {
            if (loginGPC.get(nif1).equals(pass1)) {
                loginGPC.put(nif0, pass0);
            } else {
                throw new LoginGPCNaoExiste();
            }
        }
    }

    public String getLoginGPCInfo(String nif0, String nif1, String pass1) throws LoginGPCNaoExiste {
        if (loginGPC.get(nif1).equals(pass1)) {
            return loginGPC.get(nif0).toString();
        } else {
            throw new LoginGPCNaoExiste();
        }
    }

    public void AlterarNifLoginGPC(String nif0, String nifnovo, String nif1, String pass1) throws LoginGPCNaoExiste {
        if (loginGPC.get(nif1).equals(pass1)) {
            String pass = loginGPC.get(nif0);
            loginGPC.remove(nif0);
            loginGPC.put(nif0, pass);
        } else {
            throw new LoginGPCNaoExiste();
        }
    }

    public void AlterarPassLoginGPC(String nif0, String passnova, String nif1, String pass1) throws LoginGPCNaoExiste {
        if (loginGPC.get(nif1).equals(pass1)) {
            loginGPC.remove(nif0);
            loginGPC.put(nif0, passnova);
        } else {
            throw new LoginGPCNaoExiste();
        }
    }

    public String procuraLoginGPCNif(String nif0, String nif1, String pass1) throws LoginGPCNaoExiste {
        if (loginGPC.get(nif1).equals(pass1)) {
            return loginGPC.get(nif0).toString();
        } else {
            throw new LoginGPCNaoExiste();
        }
    }

    public void removeLoginGPC(String nif0, String nif1, String pass1) throws LoginGPCNaoExiste {
        if (loginGPC.get(nif1).equals(pass1)) {
            loginGPC.remove(nif0);
        } else {
            throw new LoginGPCNaoExiste();
        }
    }

    //----------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //ATOS FARMACEUTICOS --> REGISTA AQUISIÇÕES
    public synchronized void criaAtoFarmaceutico(int id, String niffarmaceutico, LocalDateTime h, HashMap< Integer, Integer> lista_artigos, HashMap<Integer, Integer> lista_medicamentos, String nifuser, String pass)
            throws FarmaceuticoNaoExiste, AtoFarmaceuticoJaExiste, MedicamentoNaoExiste, OutroArtigoNaoExiste, LoginGLMNaoExiste {
        if(loginGLM.get(nifuser).equals(pass)) {
            if (this.atosfarmaceuticos.containsKey(id)) {
                throw new AtoFarmaceuticoJaExiste();
            } else {
                Farmaceutico f = farmaceuticos.get(niffarmaceutico);
                if (f == null) {
                    throw new FarmaceuticoNaoExiste();
                }

                if (lista_artigos == null)
                    lista_artigos = new HashMap<>();

                if (lista_medicamentos == null)
                    lista_medicamentos = new HashMap<>();

                AtoFarmaceutico atof = new AtoFarmaceutico(id, f, h, lista_artigos, lista_medicamentos);
                atosfarmaceuticos.put(atof.getId(), atof);
                AumentaStockArt(lista_artigos);
                AumentaStockMed(lista_medicamentos);
            }
        } else {
            throw new LoginGLMNaoExiste();
        }
    }

    public void alteraIDAtoFarmaceutico(int oldID, int newID, String nifuser, String pass) throws AtoFarmaceuticoJaExiste, LoginGLMNaoExiste {
        if(loginGLM.get(nifuser).equals(pass)) {
            if (this.atosfarmaceuticos.containsKey(newID)) {
                System.out.println("Ja existe esse id");
                throw new AtoFarmaceuticoJaExiste();
            } else {
                AtoFarmaceutico i = this.atosfarmaceuticos.get(oldID);
                this.atosfarmaceuticos.remove(oldID);
                this.atosfarmaceuticos.put(newID, i);
            }
        } else {
            throw new LoginGLMNaoExiste();
        }
    }

    public void alteraFarmaceuticoAtoFarmaceutico(int idAto, Farmaceutico f, String nifuser, String pass) throws AtoFarmaceuticoNaoExiste, LoginGLMNaoExiste {
        if(loginGLM.get(nifuser).equals(pass)) {
            if (this.atosfarmaceuticos.containsKey(idAto)) {
                this.atosfarmaceuticos.get(idAto).setF(f);
            } else {
                throw new AtoFarmaceuticoNaoExiste();
            }
        } else {
            throw new LoginGLMNaoExiste();
        }
    }

    public void alteraHoraAtoFarmaceutico(int idAto, LocalDateTime newHora, String nifuser, String pass) throws AtoFarmaceuticoNaoExiste, LoginGLMNaoExiste {
        if(loginGLM.get(nifuser).equals(pass)) {
            if (this.atosfarmaceuticos.containsKey(idAto)) {
                this.atosfarmaceuticos.get(idAto).setHora(newHora);
            } else {
                throw new AtoFarmaceuticoNaoExiste();
            }
        } else {
            throw new LoginGLMNaoExiste();
        }
    }

    public void alteraIDlistaArtigosAtoFarmaceutico(int idAto, int oldID, int newID, String nifuser, String pass) throws AtoFarmaceuticoNaoExiste, LoginGLMNaoExiste {
        if(loginGLM.get(nifuser).equals(pass)) {
            if (this.atosfarmaceuticos.containsKey(idAto)) {
                int quantidade = atosfarmaceuticos.get(idAto).getArtigos().get(oldID);
                atosfarmaceuticos.get(idAto).removeArtigo(oldID);
                atosfarmaceuticos.get(idAto).putArtigo(newID, quantidade);
            } else {
                throw new AtoFarmaceuticoNaoExiste();
            }
        } else {
            throw new LoginGLMNaoExiste();
        }
    }

    public void alteraQuantidadelistaArtigosAtoFarmaceutico(int idAto, int idArtigo, int newQuant, String nifuser, String pass) throws AtoFarmaceuticoNaoExiste, LoginGLMNaoExiste {
        if(loginGLM.get(nifuser).equals(pass)) {
            if (this.atosfarmaceuticos.containsKey(idAto)) {
                atosfarmaceuticos.get(idAto).removeArtigo(idArtigo);
                atosfarmaceuticos.get(idAto).putArtigo(idArtigo, newQuant);
            } else {
                throw new AtoFarmaceuticoNaoExiste();
            }
        } else {
            throw new LoginGLMNaoExiste();
        }
    }

    public void alteraIDlistaMedicamentosAtoFarmaceutico(int idAto, int oldID, int newID, String nifuser, String pass) throws AtoFarmaceuticoNaoExiste, LoginGLMNaoExiste {
        if(loginGLM.get(nifuser).equals(pass)) {
            if (this.atosfarmaceuticos.containsKey(idAto)) {
                int quantidade = atosfarmaceuticos.get(idAto).getMedicamentos().get(oldID);
                atosfarmaceuticos.get(idAto).removeMedicamento(oldID);
                atosfarmaceuticos.get(idAto).putMedicamento(newID, quantidade);
            } else {
                throw new AtoFarmaceuticoNaoExiste();
            }
        } else {
            throw new LoginGLMNaoExiste();
        }
    }

    public void alteraQuantidadelistaMedicamentosAtoFarmaceutico(int idAto, int idMedicamento, int newQuant, String nifuser, String pass) throws AtoFarmaceuticoNaoExiste, LoginGLMNaoExiste {
        if(loginGLM.get(nifuser).equals(pass)) {
            if (this.atosfarmaceuticos.containsKey(idAto)) {
                atosfarmaceuticos.get(idAto).removeMedicamento(idMedicamento);
                atosfarmaceuticos.get(idAto).putMedicamento(idMedicamento, newQuant);
            } else {
                throw new AtoFarmaceuticoNaoExiste();
            }
        } else {
            throw new LoginGLMNaoExiste();
        }
    }

    public AtoFarmaceutico procuraAtoFarmaceuticoID(int idAto, String nifuser, String pass) throws AtoFarmaceuticoNaoExiste, LoginGLMNaoExiste {
        if(loginGLM.get(nifuser).equals(pass)) {
            if (this.atosfarmaceuticos.containsKey(idAto)) {
                return this.atosfarmaceuticos.get(idAto);
            } else {
                throw new AtoFarmaceuticoNaoExiste();
            }
        } else {
            throw new LoginGLMNaoExiste();
        }
    }

    public HashMap<Integer, AtoFarmaceutico> procuraAtoFarmaceuticoFarmaceutico(String nif, String nifuser, String pass) throws FarmaceuticoNaoExiste, LoginGLMNaoExiste {
        HashMap<Integer, AtoFarmaceutico> res = new HashMap<>();
        if(loginGLM.get(nifuser).equals(pass)) {
            if (this.farmaceuticos.containsKey(nif)) {
                for (Integer key : this.atosfarmaceuticos.keySet()) {
                    AtoFarmaceutico af = this.atosfarmaceuticos.get(key);
                    if (af.getF().getNif().equals(nif)) {
                        res.put(key, af);
                    }
                }
                return res;
            } else {
                throw new FarmaceuticoNaoExiste();
            }
        } else {
            throw new LoginGLMNaoExiste();
        }
    }

    public HashMap<Integer, AtoFarmaceutico> procuraAtoFarmaceuticoHora(LocalDateTime h, String nifuser, String pass) throws LoginGLMNaoExiste {
        HashMap<Integer, AtoFarmaceutico> res = new HashMap<>();
        if(loginGLM.get(nifuser).equals(pass)) {
            for (Integer key : this.atosfarmaceuticos.keySet()) {
                AtoFarmaceutico af = this.atosfarmaceuticos.get(key);
                if (af.getHora().equals(h)) {
                    res.put(key, af);
                }
            }
            return res;
        } else {
            throw new LoginGLMNaoExiste();
        }
    }

    public HashMap<Integer, AtoFarmaceutico> procuraAtoFarmaceuticoArtigo(int idArt, String nifuser, String pass) throws LoginGLMNaoExiste {
        HashMap<Integer, AtoFarmaceutico> res = new HashMap<>();
        if(loginGLM.get(nifuser).equals(pass)) {
            for (Integer key : this.atosfarmaceuticos.keySet()) {
                AtoFarmaceutico af = this.atosfarmaceuticos.get(key);
                if (af.getArtigos().containsKey(idArt)) {
                    res.put(key, af);
                }
            }
            return res;
        } else {
            throw new LoginGLMNaoExiste();
        }
    }

    public HashMap<Integer, AtoFarmaceutico> procuraAtoFarmaceuticoMedicamento(int idMed, String nifuser, String pass) throws LoginGLMNaoExiste {
        HashMap<Integer, AtoFarmaceutico> res = new HashMap<>();
        if(loginGLM.get(nifuser).equals(pass)) {
            for (Integer key : this.atosfarmaceuticos.keySet()) {
                AtoFarmaceutico af = this.atosfarmaceuticos.get(key);
                if (af.getMedicamentos().containsKey(idMed)) {
                    res.put(key, af);
                }
            }
            return res;
        } else {
            throw new LoginGLMNaoExiste();
        }
    }

    //-----------------------------------------------------------------------------------------------------------------
    //CONSULTA STOCK DE OUTROS ARTIGOS
    public String ConsultaArtigos(String nifuser, String pass) throws LoginGLMNaoExiste {
        if(loginGLM.get(nifuser).equals(pass)) {
            return outrosartigos.toString();
        } else {
            throw new LoginGLMNaoExiste();
        }
    }

    //CONSULTA STOCK DE MEDICAMENTOS
    public String ConsultaMedicamentos(String nifuser, String pass) throws LoginGLMNaoExiste {
        if(loginGLM.get(nifuser).equals(pass)) {
            System.out.println(medicamentos.toString());
            return medicamentos.toString();
        } else {
            throw new LoginGLMNaoExiste();
        }
    }

    //-----------------------------------------------------------------------------------------------------------------
    //CONSULTA DO REGISTO DE AQUISIÇÕES DE OUTROS ARTIGOS
    public String ConsultaAquisicoesArtigos(String nifuser, String pass) throws LoginGLMNaoExiste {
        if(loginGLM.get(nifuser).equals(pass)) {
            return aquisicoes_artigos.toString();
        } else {
            throw new LoginGLMNaoExiste();
        }
    }

    //CONSULTA DO REGISTO DE AQUISIÇÕES DE MEDICAMENTOS
    public String ConsultaAquisicoesMedicamentos(String nifuser, String pass) throws LoginGLMNaoExiste {
        if(loginGLM.get(nifuser).equals(pass)) {
            return aquisicoes_medicamentos.toString();
        } else {
            throw new LoginGLMNaoExiste();
        }
    }

    //CONSULTA DO REGISTO DE CONSUMOS DE OUTROS ARTIGOS
    public String ConsultaConsumosArtigos(String nifuser, String pass) throws LoginGLMNaoExiste {
        if(loginGLM.get(nifuser).equals(pass)) {
            return consumos_artigos.toString();
        } else {
            throw new LoginGLMNaoExiste();
        }
    }

    //CONSULTA DO REGISTO DE CONSUMOS DE MEDICAMENTOS
    public String ConsultaConsumosMedicamentos(String nifuser, String pass) throws LoginGLMNaoExiste {
        if(loginGLM.get(nifuser).equals(pass)) {
            return consumos_medicamentos.toString();
        } else {
            throw new LoginGLMNaoExiste();
        }
    }

    //-----------------------------------------------------------------------------------------------------------------
    //ALERTAS DE STOCKS BAIXOS DE OUTROS ARTIGOS
    public String AlertaArtigos(String nifuser, String pass) throws LoginGLMNaoExiste {
        if(loginGLM.get(nifuser).equals(pass)) {
            for (OutrosArtigos art : outrosartigos.values()) {
                if (art.getQuantidade() < 50) {
                    alertaartigos.put(art.getId(), art.getQuantidade());
                }
            }
            return alertaartigos.toString();
        } else {
            throw new LoginGLMNaoExiste();
        }
    }

    //ALERTAS DE STOCKS BAIXOS DE MEDICAMENTOS
    public String AlertaMedicamentos(String nifuser, String pass) throws LoginGLMNaoExiste {
        if(loginGLM.get(nifuser).equals(pass)) {
            for (Medicamento med : medicamentos.values()) {
                if (med.getQuantidade() < 50) {
                    alertamedicamentos.put(med.getId(), med.getQuantidade());
                }
            }
            return alertamedicamentos.toString();
        } else {
            throw new LoginGLMNaoExiste();
        }
    }

    //---------------------------------------------------------------------------------------------------------------------------------------------
    //MANIPULAÇÃO DE LOGINS GLM (dados do login que se quer criar (0) e dados do login da pessoa que está a criar (1)
    public synchronized void criaLoginGLM(String nif0, String pass0, String nif1, String pass1) throws
            LoginGLMJaExiste, LoginGLMNaoExiste {
        if (this.loginGLM.containsKey(nif0)) {
            throw new LoginGLMJaExiste();
        } else {
            if (loginGLM.get(nif1).equals(pass1)) {
                loginGLM.put(nif0, pass0);
            } else {
                throw new LoginGLMNaoExiste();
            }
        }
    }

    public String getLoginGLMInfo(String nif0, String nif1, String pass1) throws LoginGPCNaoExiste {
        if (loginGLM.get(nif1).equals(pass1)) {
            return loginGLM.get(nif0).toString();
        } else {
            throw new LoginGPCNaoExiste();
        }
    }

    public void AlterarNifLoginGLM(String nif0, String nifnovo, String nif1, String pass1) throws LoginGLMNaoExiste {
        if (loginGLM.get(nif1).equals(pass1)) {
            String pass = loginGLM.get(nif0);
            loginGLM.remove(nif0);
            loginGLM.put(nif0, pass);
        } else {
            throw new LoginGLMNaoExiste();
        }
    }

    public void AlterarPassLoginGLM(String nif0, String passnova, String nif1, String pass1) throws LoginGLMNaoExiste {
        if (loginGLM.get(nif1).equals(pass1)) {
            loginGLM.remove(nif0);
            loginGLM.put(nif0, passnova);
        } else {
            throw new LoginGLMNaoExiste();
        }
    }

    public String procuraLoginGLMNif(String nif0, String nif1, String pass1) throws LoginGLMNaoExiste {
        if (loginGLM.get(nif1).equals(pass1)) {
            return loginGLM.get(nif0).toString();
        } else {
            throw new LoginGLMNaoExiste();
        }
    }

    public void removeLoginGLM(String nif0, String nif1, String pass1) throws LoginGLMNaoExiste {
        if (loginGLM.get(nif1).equals(pass1)) {
            loginGLM.remove(nif0);
        } else {
            throw new LoginGLMNaoExiste();
        }
    }

    //------------------------------------------------------------------------------------------------------------------
    //DIMINUIÇÃO INSTÂNTANEA DE STOCK DE MEDICAMENTOS E REGISTO DE CONSUMOS DE MEDICAMENTOS
    public synchronized void DiminuiStockMed(HashMap<Integer, Integer> lista_medicamentos) throws MedicamentoNaoExiste{
        for (Integer key : lista_medicamentos.keySet()) {
            if (medicamentos.containsKey(key)) {
                int quant = lista_medicamentos.get(key);
                int quant2 = medicamentos.get(key).getQuantidade();
                if ((quant2 - quant) >=0) {
                    medicamentos.get(key).setQuantidade(quant2 - quant);
                    if (!consumos_medicamentos.containsKey(key)){
                        consumos_medicamentos.put(key, quant);
                    }
                    else{
                        consumos_medicamentos.replace(key, quant + consumos_medicamentos.get(key));
                    }
                }
                else{
                    medicamentos.get(key).setQuantidade(0);
                    if (!consumos_medicamentos.containsKey(key)){
                        consumos_medicamentos.put(key, quant2);
                    }
                    else{
                        consumos_medicamentos.put(key, quant2 + consumos_medicamentos.get(key));
                    }
                }
            } else {
                throw new MedicamentoNaoExiste();
            }
        }
    }

    //------------------------------------------------------------------------------------------------------------------
    //DIMINUIÇÃO INSTÂNTANEA DE STOCK DE OUTROS ARTIGOS E REGISTO DE CONSUMOS DE OUTROS ARTIGOS
    public synchronized void DiminuiStockArt(HashMap<Integer, Integer> lista_artigos) throws OutroArtigoNaoExiste {
        for (Integer key : lista_artigos.keySet()) {
            if (outrosartigos.containsKey(key)) {
                int quant = lista_artigos.get(key);
                int quant2 = outrosartigos.get(key).getQuantidade();
                if ((quant2 - quant) >= 0) {
                    outrosartigos.get(key).setQuantidade(quant2 - quant);
                    if (!consumos_artigos.containsKey(key)){
                        consumos_artigos.put(key, quant);
                    }
                    else{
                        consumos_artigos.replace(key, quant + consumos_artigos.get(key));
                    }
                } else {
                    outrosartigos.get(key).setQuantidade(0);
                    if (!consumos_artigos.containsKey(key)){
                        consumos_artigos.put(key, quant2);
                    }
                    else{
                        consumos_artigos.put(key, quant2 + consumos_artigos.get(key));
                    }
                }
            } else {
                throw new OutroArtigoNaoExiste();
            }
        }
    }

    //------------------------------------------------------------------------------------------------------------------
    //AUMENTO INSTÂNTANEO DE STOCK DE OUTROS ARTIGOS E REGISTO DE AQUISIÇÕES DE MEDICAMENTOS
    public synchronized void AumentaStockArt(HashMap<Integer, Integer> lista_artigos) throws OutroArtigoNaoExiste {
        for (Integer key : lista_artigos.keySet()) {
            if (outrosartigos.containsKey(key)) {
                int quant = lista_artigos.get(key);
                int quant2 = outrosartigos.get(key).getQuantidade();
                outrosartigos.get(key).setQuantidade(quant2 + quant);
                if (!aquisicoes_artigos.containsKey(key)){
                    aquisicoes_artigos.put(key, quant);
                }
                else{
                    aquisicoes_artigos.put(key, quant + aquisicoes_artigos.get(key));
                }
            } else {
                throw new OutroArtigoNaoExiste();
            }
        }
    }

    //------------------------------------------------------------------------------------------------------------------
    //AUMENTO INSTÂNTANEO DE STOCK DE MEDICAMENTOS E REGISTO DE AQUISIÇÕES DE MEDICAMENTOS
    public synchronized void AumentaStockMed(HashMap<Integer, Integer> lista_medicamentos) throws MedicamentoNaoExiste{
        for (Integer key : lista_medicamentos.keySet()) {
            if (medicamentos.containsKey(key)) {
                int quant = lista_medicamentos.get(key);
                int quant2 = medicamentos.get(key).getQuantidade();
                medicamentos.get(key).setQuantidade(quant2 + quant);
                if (!aquisicoes_medicamentos.containsKey(key)){
                    aquisicoes_medicamentos.put(key, quant);
                }
                else{
                    aquisicoes_medicamentos.put(key, quant + aquisicoes_medicamentos.get(key));
                }
            } else {
                throw new MedicamentoNaoExiste();
            }
        }
    }

    //---------------------------------------------------------------------------------------------------------------------------------
    //ESTATÍSTICAS
    //TOP 3 MEDICAMENTOS MAIS USADOS EM ATOS MÉDICOS
    public HashMap<Integer, Integer> medicamentosMaisUtilizadosAtosMedicos(String nifuser, String pass) throws LoginGPCNaoExiste {
        if (loginGPC.get(nifuser).equals(pass)) {
            HashMap <Integer, Integer> res = new HashMap<>();
            HashMap <Integer, Integer> top3 = new HashMap<>();
            for (Integer key : this.atosmedicos.keySet()) {
                AtoMedico am = this.atosmedicos.get(key);
                for(Integer med : am.getMedicamentos().keySet()){
                    Integer quant = am.getMedicamentos().get(med);
                    if(res.containsKey(med)){
                        int oldQuant = res.get(med);
                        res.remove(med);
                        res.put(med, quant + oldQuant);
                    }
                    else {
                        res.put(med, quant);
                    }
                }
            }
            List<Integer> keys = res.entrySet().stream().sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed()).limit(3).map(Map.Entry::getKey).collect(Collectors.toList());
            for(Integer k : keys){
                int quant = res.get(k);
                top3.put(k, quant);
            }
            return top3;
        }
        else{
            throw new LoginGPCNaoExiste();
        }
    }

    //TOP 3 ARTIGOS MAIS USADOS EM ATOS MÉDICOS
    public HashMap<Integer, Integer> artigosMaisUtilizadosAtosMedicos(String nifuser, String pass) throws LoginGPCNaoExiste {
        if (loginGPC.get(nifuser).equals(pass)) {
            HashMap <Integer, Integer> res = new HashMap<>();
            HashMap <Integer, Integer> top3 = new HashMap<>();
            for (Integer key : this.atosmedicos.keySet()) {
                AtoMedico am = this.atosmedicos.get(key);
                for(Integer art : am.getArtigos().keySet()){
                    Integer quant = am.getArtigos().get(art);
                    if(res.containsKey(art)){
                        int oldQuant = res.get(art);
                        res.remove(art);
                        res.put(art, quant + oldQuant);
                    }
                    else {
                        res.put(art, quant);
                    }
                }
            }
            List<Integer> keys = res.entrySet().stream().sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed()).limit(3).map(Map.Entry::getKey).collect(Collectors.toList());

            for(Integer k : keys){
                int quant = res.get(k);
                top3.put(k, quant);
            }
            return top3;
        }
        else{
            throw new LoginGPCNaoExiste();
        }
    }

    //TOP 3 ARTIGOS MAIS USADOS EM ATOS ENFERMAGEM
    public HashMap<Integer, Integer> artigosMaisUtilizadosAtosEnfermagem(String nifuser, String pass) throws LoginGPCNaoExiste {
        if (loginGPC.get(nifuser).equals(pass)) {
            HashMap <Integer, Integer> res = new HashMap<>();
            HashMap <Integer, Integer> top3 = new HashMap<>();
            for (Integer key : this.atosenfermagem.keySet()) {
                AtoEnfermagem ae = this.atosenfermagem.get(key);
                for(Integer art : ae.getArtigos().keySet()){
                    Integer quant = ae.getArtigos().get(art);
                    if(res.containsKey(art)){
                        int oldQuant = res.get(art);
                        res.remove(art);
                        res.put(art, quant + oldQuant);
                    }
                    else {
                        res.put(art, quant);
                    }
                }
            }
            List<Integer> keys = res.entrySet().stream().sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed()).limit(3).map(Map.Entry::getKey).collect(Collectors.toList());

            for(Integer k : keys){
                int quant = res.get(k);
                top3.put(k, quant);
            }
            return top3;
        }
        else{
            throw new LoginGPCNaoExiste();
        }
    }

    //TOP 3 ESPECIALIDADES DE MÉDICOS MAIS COMUNS
    public HashMap<String, Integer> especialidadesMedicosMaiscomuns(String nifuser, String pass) throws LoginGPCNaoExiste {
        if (loginGPC.get(nifuser).equals(pass)) {
            HashMap<String, Integer> res = new HashMap<>();
            HashMap <String, Integer> top3 = new HashMap<>();

            for (String key : this.medicos.keySet()) {
                Medico m = this.medicos.get(key);
                String especialidade = m.getEspecialidade();
                if(res.containsKey(especialidade)){
                    int quantidade = res.get(especialidade);
                    res.remove(especialidade);
                    res.put(especialidade, quantidade + 1);
                }
                else{
                    res.put(especialidade, 1);
                }
            }
            List<String> keys = res.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed()).limit(3).map(Map.Entry::getKey).collect(Collectors.toList());

            for(String k : keys){
                int quant = res.get(k);
                top3.put(k, quant);
            }
            return top3;
        }
        else{
            throw new LoginGPCNaoExiste();
        }
    }

    //TOP 3 ESPECIALIDADES DE ENFERMEIROS MAIS COMUNS
    public HashMap<String, Integer> especialidadesEnfermeirosMaiscomuns(String nifuser, String pass) throws LoginGPCNaoExiste {
        if (loginGPC.get(nifuser).equals(pass)) {
            HashMap<String, Integer> res = new HashMap<>();
            HashMap <String, Integer> top3 = new HashMap<>();

            for (String key : this.enfermeiros.keySet()) {
                Enfermeiro e = this.enfermeiros.get(key);
                String especialidade = e.getEspecialidade();
                if(res.containsKey(especialidade)){
                    int quantidade = res.get(especialidade);
                    res.remove(especialidade);
                    res.put(especialidade, quantidade + 1);
                }
                else{
                    res.put(especialidade, 1);
                }
            }
            List<String> keys = res.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed()).limit(3).map(Map.Entry::getKey).collect(Collectors.toList());

            for(String k : keys){
                int quant = res.get(k);
                top3.put(k, quant);
            }
            return top3;
        }
        else{
            throw new LoginGPCNaoExiste();
        }
    }

    //LISTAR ATOS MÉDICOS POR ESPECIALIDADE
    public HashMap<Integer, AtoMedico> listaAtoMedicoEspecialidade(String esp, String nifuser, String pass) throws LoginGPCNaoExiste {
        if (loginGPC.get(nifuser).equals(pass)) {
            HashMap<Integer, AtoMedico> res = new HashMap<>();
            for (Integer key : this.atosmedicos.keySet()) {
                AtoMedico am = this.atosmedicos.get(key);
                String especialidade = am.getM().getEspecialidade();
                if(especialidade.equals(esp)){
                    res.put(key, am);
                }
            }
            return res;
        }
        else{
            throw new LoginGPCNaoExiste();
        }
    }

    //LISTAR ATOS ENFERMAGEM POR ESPECIALIDADE
    public HashMap<Integer, AtoEnfermagem> listaAtoEnfermagemEspecialidade(String esp, String nifuser, String pass) throws LoginGPCNaoExiste {
        if (loginGPC.get(nifuser).equals(pass)) {
            HashMap<Integer, AtoEnfermagem> res = new HashMap<>();
            for (Integer key : this.atosenfermagem.keySet()) {
                AtoEnfermagem ae = this.atosenfermagem.get(key);
                String especialidade = ae.getE().getEspecialidade();
                if(especialidade.equals(esp)){
                    res.put(key, ae);
                }
            }
            return res;
        }
        else{
            throw new LoginGPCNaoExiste();
        }
    }

    //LISTAR ATOS MÉDICOS POR UTENTE
    public HashMap<Integer, AtoMedico> listaAtoMedicoUtente(String nif, String nifuser, String pass) throws UtenteNaoExiste, LoginGPCNaoExiste {
        if (loginGPC.get(nifuser).equals(pass)) {
            HashMap<Integer, AtoMedico> res = new HashMap<>();
            if(this.utentes.containsKey(nif)){
                for (Integer key : this.atosmedicos.keySet()) {
                    AtoMedico am = this.atosmedicos.get(key);
                    if(am.getU().getNif().equals(nif)){
                        res.put(key, am);
                    }
                }
                return res;
            }
            else{
                throw new UtenteNaoExiste();
            }
        }
        else{
            throw new LoginGPCNaoExiste();
        }
    }

    //LISTAR ATOS ENFERMAGEM POR UTENTE
    public HashMap<Integer, AtoEnfermagem> listaAtoEnfermagemUtente(String nif, String nifuser, String pass) throws UtenteNaoExiste, LoginGPCNaoExiste {
        if (loginGPC.get(nifuser).equals(pass)) {
            HashMap<Integer, AtoEnfermagem> res = new HashMap<>();
            if(this.utentes.containsKey(nif)){
                for (Integer key : this.atosenfermagem.keySet()) {
                    AtoEnfermagem am = this.atosenfermagem.get(key);
                    if(am.getU().getNif().equals(nif)){
                        res.put(key, am);
                    }
                }
                return res;
            }
            else{
                throw new UtenteNaoExiste();
            }
        }
        else{
            throw new LoginGPCNaoExiste();
        }
    }

    //LISTAR ATOS MÉDICOS POR MÉDICO
    public HashMap<Integer, AtoMedico> listaAtoMedicoMedico(String nif, String nifuser, String pass) throws MedicoNaoExiste, LoginGPCNaoExiste {
        if (loginGPC.get(nifuser).equals(pass)) {
            HashMap<Integer, AtoMedico> res = new HashMap<>();
            if(this.medicos.containsKey(nif)){
                for (Integer key : this.atosmedicos.keySet()) {
                    AtoMedico am = this.atosmedicos.get(key);
                    if(am.getM().getNif().equals(nif)){
                        res.put(key, am);
                    }
                }
                return res;
            }
            else{
                throw new MedicoNaoExiste();
            }
        }
        else{
            throw new LoginGPCNaoExiste();
        }
    }

    //LISTAR ATOS ENFERMAGEM POR ENFERMEIRO
    public HashMap<Integer, AtoEnfermagem> listaAtoEnfermagemEnfermeiro(String nif, String nifuser, String pass) throws EnfermeiroNaoExiste, LoginGPCNaoExiste {
        if (loginGPC.get(nifuser).equals(pass)) {
            HashMap<Integer, AtoEnfermagem> res = new HashMap<>();
            if(this.enfermeiros.containsKey(nif)){
                for (Integer key : this.atosenfermagem.keySet()) {
                    AtoEnfermagem ae = this.atosenfermagem.get(key);
                    if(ae.getE().getNif().equals(nif)){
                        res.put(key, ae);
                    }
                }
                return res;
            }
            else{
                throw new EnfermeiroNaoExiste();
            }
        }
        else{
            throw new LoginGPCNaoExiste();
        }
    }

    //LISTAR ATO MEDICO POR ID DE ARTIGO USADO
    public HashMap<Integer, AtoMedico> listaAtoMedicoArtigo(int idArt, String nifuser, String pass) throws LoginGPCNaoExiste {
        if (loginGPC.get(nifuser).equals(pass)) {
            HashMap<Integer, AtoMedico> res = new HashMap<>();
            for (Integer key : this.atosmedicos.keySet()) {
                AtoMedico am = this.atosmedicos.get(key);
                if(am.getArtigos().containsKey(idArt)){
                    res.put(key, am);
                }
            }
            return res;
        }
        else{
            throw new LoginGPCNaoExiste();
        }
    }

    //LISTAR ATO ENFERMAGEM POR ID DE ARTIGO USADO
    public HashMap<Integer, AtoEnfermagem> listaAtoEnfermagemArtigo(int idArt, String nifuser, String pass) throws LoginGPCNaoExiste {
        if (loginGPC.get(nifuser).equals(pass)) {
            HashMap<Integer, AtoEnfermagem> res = new HashMap<>();
            for (Integer key : this.atosenfermagem.keySet()) {
                AtoEnfermagem ae = this.atosenfermagem.get(key);
                if(ae.getArtigos().containsKey(idArt)){
                    res.put(key, ae);
                }
            }
            return res;
        }
        else{
            throw new LoginGPCNaoExiste();
        }
    }

    //LISTAR ATO MEDICO POR ID DE MEDICAMENTO USADO
    public HashMap<Integer, AtoMedico> listaAtoMedicoMedicamento(int idMed, String nifuser, String pass) throws LoginGPCNaoExiste {
        if (loginGPC.get(nifuser).equals(pass)) {
            HashMap<Integer, AtoMedico> res = new HashMap<>();
            for (Integer key : this.atosmedicos.keySet()) {
                AtoMedico am = this.atosmedicos.get(key);
                if(am.getMedicamentos().containsKey(idMed)){
                    res.put(key, am);
                }
            }
            return res;
        }
        else{
            throw new LoginGPCNaoExiste();
        }
    }

    //TOP 3 ATOS MEDICOS QUE USARAM MAIS MEDICAMENTOS
    public HashMap<Integer, Integer> atosMedicosMaisMedicamentos(String nifuser, String pass) throws LoginGPCNaoExiste {
        if (loginGPC.get(nifuser).equals(pass)) {
            HashMap<Integer, Integer> res = new HashMap<>();
            HashMap<Integer, Integer> top3 = new HashMap<>();

            for (Integer key : this.atosmedicos.keySet()) {
                AtoMedico am = this.atosmedicos.get(key);
                for(Integer med : am.getMedicamentos().keySet()){
                    int quantidade = am.getMedicamentos().get(med);
                    if(res.containsKey(key)){
                        int oldQuant = res.get(key);
                        res.remove(key);
                        res.put(key, quantidade + oldQuant);
                    }
                    else{
                        res.put(key, quantidade);
                    }
                }

            }
            List<Integer> keys = res.entrySet().stream().sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed()).limit(3).map(Map.Entry::getKey).collect(Collectors.toList());

            for(Integer k : keys){
                int quant = res.get(k);
                top3.put(k, quant);
            }
            return top3;
        }
        else{
            throw new LoginGPCNaoExiste();
        }
    }

    //TOP 3 ATOS MEDICOS QUE USARAM MAIS ARTIGOS
    public HashMap<Integer, Integer> atosMedicosMaisArtigos(String nifuser, String pass) throws LoginGPCNaoExiste {
        if (loginGPC.get(nifuser).equals(pass)) {
            HashMap<Integer, Integer> res = new HashMap<>();
            HashMap<Integer, Integer> top3 = new HashMap<>();

            for (Integer key : this.atosmedicos.keySet()) {
                AtoMedico am = this.atosmedicos.get(key);
                for(Integer art : am.getArtigos().keySet()){
                    int quantidade = am.getArtigos().get(art);
                    if(res.containsKey(key)){
                        int oldQuant = res.get(key);
                        res.remove(key);
                        res.put(key, quantidade + oldQuant);
                    }
                    else{
                        res.put(key, quantidade);
                    }
                }
            }
            List<Integer> keys = res.entrySet().stream().sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed()).limit(3).map(Map.Entry::getKey).collect(Collectors.toList());

            for(Integer k : keys){
                int quant = res.get(k);
                top3.put(k, quant);
            }
            return top3;
        }
        else{
            throw new LoginGPCNaoExiste();
        }
    }

    //TOP 3 ATOS ENFERMAGEM QUE USARAM MAIS ARTIGOS
    public HashMap<Integer, Integer> atosEnfermagemMaisArtigos(String nifuser, String pass) throws LoginGPCNaoExiste {
        if (loginGPC.get(nifuser).equals(pass)) {
            HashMap<Integer, Integer> res = new HashMap<>();
            HashMap<Integer, Integer> top3 = new HashMap<>();

            for (Integer key : this.atosenfermagem.keySet()) {
                AtoEnfermagem ae = this.atosenfermagem.get(key);
                for(Integer art : ae.getArtigos().keySet()){
                    int quantidade = ae.getArtigos().get(art);
                    if(res.containsKey(key)){
                        int oldQuant = res.get(key);
                        res.remove(key);
                        res.put(key, quantidade + oldQuant);
                    }
                    else{
                        res.put(key, quantidade);
                    }
                }
            }
            List<Integer> keys = res.entrySet().stream().sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed()).limit(3).map(Map.Entry::getKey).collect(Collectors.toList());

            for(Integer k : keys){
                int quant = res.get(k);
                top3.put(k, quant);
            }
            return top3;
        }
        else{
            throw new LoginGPCNaoExiste();
        }
    }

    //TOP 3 MEDICAMENTOS MAIS USADOS EM ATOS FARMACEUTICOS
    public String medicamentosMaisUtilizadosAtosFarmaceuticos(String nifuser, String pass) throws LoginGLMNaoExiste {
        if (loginGLM.get(nifuser).equals(pass)) {
            HashMap <Integer, Integer> res = new HashMap<>();
            HashMap <Integer, Integer> top3 = new HashMap<>();
            for (Integer key : this.atosfarmaceuticos.keySet()) {
                AtoFarmaceutico af = this.atosfarmaceuticos.get(key);
                for(Integer med : af.getMedicamentos().keySet()){
                    Integer quant = af.getMedicamentos().get(med);
                    if(res.containsKey(med)){
                        int oldQuant = res.get(med);
                        res.remove(med);
                        res.put(med, quant + oldQuant);
                    }
                    else {
                        res.put(med, quant);
                    }
                }
            }
            List<Integer> keys = res.entrySet().stream().sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed()).limit(3).map(Map.Entry::getKey).collect(Collectors.toList());
            for(Integer k : keys){
                int quant = res.get(k);
                top3.put(k, quant);
            }
            return top3.toString();
        }else {
            throw new LoginGLMNaoExiste();
        }

    }

    //TOP 3 ARTIGOS MAIS USADOS EM ATOS FARMACEUTICOS
    public HashMap<Integer, Integer> artigosMaisUtilizadosAtosFarmaceuticos(String nifuser, String pass) throws LoginGLMNaoExiste {
        if (loginGLM.get(nifuser).equals(pass)) {
            HashMap <Integer, Integer> res = new HashMap<>();
            HashMap <Integer, Integer> top3 = new HashMap<>();
            for (Integer key : this.atosfarmaceuticos.keySet()) {
                AtoFarmaceutico af = this.atosfarmaceuticos.get(key);
                for(Integer art : af.getArtigos().keySet()){
                    Integer quant = af.getArtigos().get(art);
                    if(res.containsKey(art)){
                        int oldQuant = res.get(art);
                        res.remove(art);
                        res.put(art, quant + oldQuant);
                    }
                    else {
                        res.put(art, quant);
                    }
                }
            }
            List<Integer> keys = res.entrySet().stream().sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed()).limit(3).map(Map.Entry::getKey).collect(Collectors.toList());

            for(Integer k : keys){
                int quant = res.get(k);
                top3.put(k, quant);
            }
            return top3;
        }else {
            throw new LoginGLMNaoExiste();
        }
    }

    //LISTAR ATO FARMACEUTICO POR FARMACEUTICO
    public HashMap<Integer, AtoFarmaceutico> listaAtoFarmaceutico(String nif, String nifuser, String pass) throws FarmaceuticoNaoExiste, LoginGLMNaoExiste {
        if (loginGLM.get(nifuser).equals(pass)) {
            HashMap<Integer, AtoFarmaceutico> res = new HashMap<>();
            if(this.farmaceuticos.containsKey(nif)){
                for (Integer key : this.atosfarmaceuticos.keySet()) {
                    AtoFarmaceutico af = this.atosfarmaceuticos.get(key);
                    if(af.getF().getNif().equals(nif)){
                        res.put(key, af);
                    }
                }
                return res;
            }
            else{
                throw new FarmaceuticoNaoExiste();
            }
        }else {
            throw new LoginGLMNaoExiste();
        }
    }

    //LISTAR ATO FARMACEUTICO POR ID DE ARTIGO USADO
    public HashMap<Integer, AtoFarmaceutico> listaAtoFarmaceuticoArtigo(int idArt, String nifuser, String pass) throws LoginGLMNaoExiste {
        if (loginGLM.get(nifuser).equals(pass)) {
            HashMap<Integer, AtoFarmaceutico> res = new HashMap<>();
            for (Integer key : this.atosfarmaceuticos.keySet()) {
                AtoFarmaceutico af = this.atosfarmaceuticos.get(key);
                if(af.getArtigos().containsKey(idArt)){
                    res.put(key, af);
                }
            }
            return res;
        }else {
            throw new LoginGLMNaoExiste();
        }
    }

    //LISTAR ATO FARMACEUTICO POR ID DE MEDICAMENTO USADO
    public HashMap<Integer, AtoFarmaceutico> listaAtoFarmaceuticoMedicamento(int idMed, String nifuser, String pass) throws LoginGLMNaoExiste {
        if (loginGLM.get(nifuser).equals(pass)) {
            HashMap<Integer, AtoFarmaceutico> res = new HashMap<>();
            for (Integer key : this.atosfarmaceuticos.keySet()) {
                AtoFarmaceutico af = this.atosfarmaceuticos.get(key);
                if(af.getMedicamentos().containsKey(idMed)){
                    res.put(key, af);
                }
            }
            return res;
        }else {
            throw new LoginGLMNaoExiste();
        }
    }

    //TOP 3 ATOS FARMACEUTICOS QUE MAIS USARAM MEDICAMENTOS
    public HashMap<Integer, Integer> atosFarmaceuticosMaisMedicamentos(String nifuser, String pass) throws LoginGLMNaoExiste {
        if (loginGLM.get(nifuser).equals(pass)) {
            HashMap<Integer, Integer> res = new HashMap<>();
            HashMap<Integer, Integer> top3 = new HashMap<>();

            for (Integer key : this.atosfarmaceuticos.keySet()) {
                AtoFarmaceutico af = this.atosfarmaceuticos.get(key);
                for(Integer med : af.getMedicamentos().keySet()){
                    int quantidade = af.getMedicamentos().get(med);
                    if(res.containsKey(key)){
                        int oldQuant = res.get(key);
                        res.remove(key);
                        res.put(key, quantidade + oldQuant);
                    }
                    else{
                        res.put(key, quantidade);
                    }
                }
            }
            List<Integer> keys = res.entrySet().stream().sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed()).limit(3).map(Map.Entry::getKey).collect(Collectors.toList());

            for(Integer k : keys){
                int quant = res.get(k);
                top3.put(k, quant);
            }
            return top3;
        }else {
            throw new LoginGLMNaoExiste();
        }
    }

    //TOP 3 ATOS FARMACEUTICOS QUE MAIS USARAM ARTIGOS
    public HashMap<Integer, Integer> atosFarmaceuticosMaisArtigos(String nifuser, String pass) throws LoginGLMNaoExiste {
        if (loginGLM.get(nifuser).equals(pass)) {
            HashMap<Integer, Integer> res = new HashMap<>();
            HashMap<Integer, Integer> top3 = new HashMap<>();

            for (Integer key : this.atosfarmaceuticos.keySet()) {
                AtoFarmaceutico af = this.atosfarmaceuticos.get(key);
                for(Integer art : af.getArtigos().keySet()){
                    int quantidade = af.getArtigos().get(art);
                    if(res.containsKey(key)){
                        int oldQuant = res.get(key);
                        res.remove(key);
                        res.put(key, quantidade + oldQuant);
                    }
                    else{
                        res.put(key, quantidade);
                    }
                }
            }
            List<Integer> keys = res.entrySet().stream().sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed()).limit(3).map(Map.Entry::getKey).collect(Collectors.toList());

            for(Integer k : keys){
                int quant = res.get(k);
                top3.put(k, quant);
            }
            return top3;
        }else {
            throw new LoginGLMNaoExiste();
        }
    }

    //TOP 3 FORNECEDORES QUE FORNECERAM UM MAIOR NÚMERO DE ARTIGOS DIFERENTES
    public HashMap<Integer, Integer> fornecedoresMaisArtigosDif(String nifuser, String pass) throws LoginGLMNaoExiste {
        if (loginGLM.get(nifuser).equals(pass)) {
            HashMap<Integer, Integer> res = new HashMap<>();
            HashMap<Integer, Integer> top3 = new HashMap<>();

            for (Integer key : this.outrosartigos.keySet()) {
                OutrosArtigos a = this.outrosartigos.get(key);
                int idForn = a.getFornecedor().getId();
                if(res.containsKey(idForn)){
                    int quant = res.get(idForn);
                    res.remove(idForn);
                    res.put(idForn, quant + 1);
                }
                else{
                    res.put(idForn, 1);
                }
            }
            List<Integer> keys = res.entrySet().stream().sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed()).limit(3).map(Map.Entry::getKey).collect(Collectors.toList());

            for(Integer k : keys){
                int quant = res.get(k);
                top3.put(k, quant);
            }
            return top3;
        }else {
            throw new LoginGLMNaoExiste();
        }
    }

    //TOP 3 FORNECEDORES QUE FORNECERAM UM MAIOR NÚMERO DE MEDICAMENTOS DIFERENTES
    public HashMap<Integer, Integer> fornecedoresMaisMedicamentosDif(String nifuser, String pass) throws LoginGLMNaoExiste {
        if (loginGLM.get(nifuser).equals(pass)) {
            HashMap<Integer, Integer> res = new HashMap<>();
            HashMap<Integer, Integer> top3 = new HashMap<>();

            for (Integer key : this.medicamentos.keySet()) {
                Medicamento m = this.medicamentos.get(key);
                int idForn = m.getFornecedor().getId();
                if(res.containsKey(idForn)){
                    int quant = res.get(idForn);
                    res.remove(idForn);
                    res.put(idForn, quant + 1);
                }
                else{
                    res.put(idForn, 1);
                }
            }
            List<Integer> keys = res.entrySet().stream().sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed()).limit(3).map(Map.Entry::getKey).collect(Collectors.toList());

            for(Integer k : keys){
                int quant = res.get(k);
                top3.put(k, quant);
            }
            return top3;
        }else {
            throw new LoginGLMNaoExiste();
        }
    }

    //TOP 3 FORNECEDORES QUE FORNECERAM UM MAIOR NÚMERO DE ARTIGOS
    public HashMap<Integer, Integer> fornecedoresMaisArtigos(String nifuser, String pass) throws LoginGLMNaoExiste {
        if (loginGLM.get(nifuser).equals(pass)) {
            HashMap<Integer, Integer> res = new HashMap<>();
            HashMap<Integer, Integer> top3 = new HashMap<>();

            for (Integer key : this.outrosartigos.keySet()) {
                OutrosArtigos a = this.outrosartigos.get(key);
                int idForn = a.getFornecedor().getId();
                if(res.containsKey(idForn)){
                    int quant = res.get(idForn);
                    res.remove(idForn);
                    res.put(idForn, quant + a.getQuantidade());
                }
                else{
                    res.put(idForn, a.getQuantidade());
                }
            }
            List<Integer> keys = res.entrySet().stream().sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed()).limit(3).map(Map.Entry::getKey).collect(Collectors.toList());

            for(Integer k : keys){
                int quant = res.get(k);
                top3.put(k, quant);
            }
            return top3;
        }else {
            throw new LoginGLMNaoExiste();
        }
    }

    //TOP 3 FORNECEDORES QUE FORNECERAM UM MAIOR NÚMERO DE MEDICAMENTOS
    public HashMap<Integer, Integer> fornecedoresMaisMedicamentos(String nifuser, String pass) throws LoginGLMNaoExiste {
        if (loginGLM.get(nifuser).equals(pass)) {
            HashMap<Integer, Integer> res = new HashMap<>();
            HashMap<Integer, Integer> top3 = new HashMap<>();

            for (Integer key : this.medicamentos.keySet()) {
                Medicamento m = this.medicamentos.get(key);
                int idForn = m.getFornecedor().getId();
                if(res.containsKey(idForn)){
                    int quant = res.get(idForn);
                    res.remove(idForn);
                    res.put(idForn, quant + m.getQuantidade());
                }
                else{
                    res.put(idForn, m.getQuantidade());
                }
            }
            List<Integer> keys = res.entrySet().stream().sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed()).limit(3).map(Map.Entry::getKey).collect(Collectors.toList());

            for(Integer k : keys){
                int quant = res.get(k);
                top3.put(k, quant);
            }
            return top3;
        }else {
            throw new LoginGLMNaoExiste();
        }

    }
}
