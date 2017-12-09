/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

import interfaces.Remoto;
import java.awt.Color;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

public class JogadorCliente {

    private Remoto remoto;
    private Janela janela;

    public static void main(String[] args) {
          System.out.println("Cliente!!!!!!!!!!!!!");
        new JogadorCliente();

    }

    public JogadorCliente() {

        String a, resp = "";

        try {

            janela = new Janela(this);
            janela.setSize(400, 300);
            janela.ativar(false);
            janela.setVisible(true);
            janela.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

            remoto = (Remoto) Naming.lookup("//localhost:2020/criptoService");

        } catch (MalformedURLException murle) {

            System.out.println();
            System.out.println("MalformedURLException");
            System.out.println(murle);

        } catch (RemoteException re) {

            System.out.println();
            System.out.println("RemoteException");
            System.out.println(re);

        } catch (NotBoundException nbe) {
            System.out.println();
            System.out.println("NotBoundException");
            System.out.println(nbe);
        } catch (java.lang.ArithmeticException ae) {
            System.out.println();
            System.out.println("java.lang.ArithmeticException");
            System.out.println(ae);

        } catch (java.lang.StringIndexOutOfBoundsException str) {
            System.out.println();
            System.out.println("java.lang.StringIndexOutOfBoundsException");
            System.out.println(str);

        } catch (java.lang.ArrayIndexOutOfBoundsException arr) {
            System.out.println();
            System.out.println("java.lang.ArrayIndexOutOfBoundsException");
            System.out.println(arr);

        }//fim catch
    }
    
    public void novaPartida(){
        try {
            remoto.novo();
            janela.ativar(true);
            janela.limpar();
        } catch (RemoteException ex) {
           System.out.println(ex);
        }
    }

    public void apostar() throws RemoteException {

        String nome = janela.getNome();
        int aposta = janela.getAposta();
        int palitos = janela.getPalitos();

        System.out.println(nome);
        System.out.println(aposta);
        System.out.println(aposta);

        String r = remoto.jogar(nome, palitos, aposta);

        JOptionPane.showMessageDialog(janela, r + " Ganhou!!!!");
        
        janela.ativar(false);
    }
}
