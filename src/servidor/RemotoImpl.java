/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import interfaces.Remoto;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fbrito
 */
public class RemotoImpl extends java.rmi.server.UnicastRemoteObject implements Remoto {

    private Jogador ganhador;

    public RemotoImpl() throws java.rmi.RemoteException {

        super();

        ganhador = null;

    }

    public String jogar(String nome, int palitos, int aposta) throws java.rmi.RemoteException {

        try {

            System.out.println("Aguarde...");

            MetodoDB metodoDB = new MetodoDB();

            Jogador jogador = new Jogador(nome, palitos, aposta);
            metodoDB.insert(jogador);
           
            while (true) {

                Thread.currentThread().sleep(2000);

                boolean todosJogaram = metodoDB.todosJogaram();

                if (todosJogaram) {

                    int somaPalitos = metodoDB.contaPalitos();

                    ganhador = metodoDB.retornaGanhador(somaPalitos);

                    break;
                }

            }

        } catch (InterruptedException ex) {
            Logger.getLogger(RemotoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return ganhador.getNome();
    }

}
