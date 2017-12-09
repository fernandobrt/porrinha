/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

import interfaces.Remoto;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import javax.swing.JOptionPane;


public class JogadorCliente {

    public static void main(String[] args) {

        String a, resp = "";

        try {

            Remoto remoto = (Remoto) Naming.lookup("//localhost:2020/");

            String nome = JOptionPane.showInputDialog("Seu Nome");

            String[] options = {"0 Palito", "1 Palito", "2 Palitos", "3 Palitos"};

            int palitos = JOptionPane.showOptionDialog(null, "Palitos?", "qt palitos", JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE, null, options, false);

            int aposta = Integer.parseInt(JOptionPane.showInputDialog("Aposta?"));

            String r = remoto.jogar(nome, palitos, aposta);
            
            
            

            JOptionPane.showMessageDialog(null, r);

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
}
