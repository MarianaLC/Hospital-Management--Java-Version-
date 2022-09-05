package health;

import data.entidades.Utente;
import data.exceptions.LoginUtenteJaExiste;
import data.exceptions.LoginUtenteNaoExiste;
import data.exceptions.UtenteJaExiste;
import data.exceptions.UtenteNaoExiste;

import java.io.IOException;
import java.io.Serializable;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public interface UtenteInterface extends Remote {

    void save() throws IOException, NotBoundException;

    public String getUtenteInfo(String nif,String nifuser,String pass) throws UtenteNaoExiste, LoginUtenteNaoExiste, RemoteException;

    public void AlterarNomeUtente(String nif, String nome,String nifuser,String pass) throws UtenteNaoExiste, LoginUtenteNaoExiste, RemoteException;

    public void AlterarBiUtente(String nif, String bi,String nifuser,String pass) throws UtenteNaoExiste, LoginUtenteNaoExiste, RemoteException;

    public void AlterarNifUtente(String nif0, String nif1, String nifuser, String pass) throws UtenteNaoExiste, LoginUtenteNaoExiste, RemoteException;

    public void AlterarMoradaUtente(String nif, String morada,String nifuser, String pass) throws UtenteNaoExiste, LoginUtenteNaoExiste, RemoteException;

    public void AlterarCodigoUtente(String nif, String codigo_postal, String nifuser, String pass) throws UtenteNaoExiste, LoginUtenteNaoExiste, RemoteException;

    public String procuraUtenteNif(String nif,String nifuser, String pass) throws UtenteNaoExiste, LoginUtenteNaoExiste, RemoteException;

    public String procuraUtenteBi(String bi,String nifuser, String pass) throws UtenteNaoExiste, LoginUtenteNaoExiste, RemoteException;

    public String procuraUtenteNome(String nome,String nifuser, String pass) throws UtenteNaoExiste, LoginUtenteNaoExiste, RemoteException;

    public String procuraUtenteMorada(String morada, String nifuser, String pass) throws UtenteNaoExiste, LoginUtenteNaoExiste, RemoteException;

    public String procuraUtenteCodigo(String codigo_postal, String nifuser, String pass) throws UtenteNaoExiste, LoginUtenteNaoExiste, RemoteException;

    public String getLoginUtenteInfo(String nif0, String nif1, String pass1) throws LoginUtenteNaoExiste, RemoteException;

    public void AlterarNifLoginUtente(String nif0, String nifnovo, String nif1, String pass1) throws  LoginUtenteNaoExiste, RemoteException;

    public void AlterarPassLoginUtente(String nif0, String passnova, String nif1, String pass1) throws LoginUtenteNaoExiste, RemoteException;

    public String procuraLoginUtenteNif(String nif0, String nif1, String pass1) throws LoginUtenteNaoExiste, RemoteException;

}
