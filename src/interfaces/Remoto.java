/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

/**
 *
 * @author fbrito
 */
public interface Remoto extends java.rmi.Remote {

    public String jogar(String nome,int palitos,int aposta) throws java.rmi.RemoteException;
    public void novo() throws java.rmi.RemoteException;
    

}
