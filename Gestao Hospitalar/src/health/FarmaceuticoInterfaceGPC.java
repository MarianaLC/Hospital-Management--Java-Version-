package health;

import data.exceptions.FarmaceuticoJaExiste;
import data.exceptions.FarmaceuticoNaoExiste;
import data.exceptions.LoginGPCNaoExiste;

import java.io.IOException;
import java.io.Serializable;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface FarmaceuticoInterfaceGPC extends  Remote {

    void save() throws IOException, NotBoundException;

    public void criaFarmaceutico(String nome, String bi, String nif, String morada, String codigo_postal, String nifuser, String pass)
            throws FarmaceuticoJaExiste, LoginGPCNaoExiste, RemoteException;

    public String getFarmaceuticoInfo(String nif, String nifuser, String pass) throws FarmaceuticoNaoExiste, LoginGPCNaoExiste, RemoteException;

    public void AlterarNomeFarmaceutico(String nif, String nome, String nifuser, String pass) throws FarmaceuticoNaoExiste, LoginGPCNaoExiste, RemoteException;

    public void AlterarBiFarmaceutico(String nif, String bi, String nifuser, String pass) throws FarmaceuticoNaoExiste, LoginGPCNaoExiste, RemoteException;

    public void AlterarNifFarmaceutico(String nif0, String nif1, String nifuser, String pass) throws FarmaceuticoNaoExiste, LoginGPCNaoExiste, RemoteException;

    public void AlterarMoradaFarmaceutico(String nif, String morada, String nifuser, String pass) throws FarmaceuticoNaoExiste, LoginGPCNaoExiste, RemoteException;

    public void AlterarCodigoFarmaceutico(String nif, String codigo_postal, String nifuser, String pass) throws FarmaceuticoNaoExiste, LoginGPCNaoExiste, RemoteException;

    public String procuraFarmaceuticoNif(String nif, String nifuser, String pass) throws FarmaceuticoNaoExiste, LoginGPCNaoExiste, RemoteException;

    public String procuraFarmaceuticoBi(String bi, String nifuser, String pass) throws FarmaceuticoNaoExiste, LoginGPCNaoExiste, RemoteException;

    public String procuraFarmaceuticoNome(String nome, String nifuser, String pass) throws FarmaceuticoNaoExiste, LoginGPCNaoExiste, RemoteException;

    public String procuraFarmaceuticoMorada(String morada, String nifuser, String pass) throws FarmaceuticoNaoExiste, LoginGPCNaoExiste, RemoteException;

    public String procuraFarmaceuticoCodigo(String codigo_postal, String nifuser, String pass) throws FarmaceuticoNaoExiste, LoginGPCNaoExiste, RemoteException;

    public void removeFarmaceutico(String nif, String nifuser, String pass) throws FarmaceuticoNaoExiste, LoginGPCNaoExiste, RemoteException;
}
