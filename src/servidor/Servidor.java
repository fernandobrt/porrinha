/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

/**
 *
 * @author fbrito
 */
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class Servidor {
    
    public static int qtJogadores = 2;

    public Servidor() {

        try {
            LocateRegistry.createRegistry(2020);  
            RemotoImpl obj = new RemotoImpl();
            Naming.rebind("//localhost:2020/criptoService", obj);
        } catch (Exception e) {
            
            System.err.print(e);
        }
    }

    public static void main(String[] args) {
       
        new Servidor();

    }
}

