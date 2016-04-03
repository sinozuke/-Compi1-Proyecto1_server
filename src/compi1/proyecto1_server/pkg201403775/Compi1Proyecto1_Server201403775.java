/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package compi1.proyecto1_server.pkg201403775;



import BackEnd.Conexion.Conexion;
import Interfaz.Interfaz_General;

/**
 *
 * @author sinozuke
 */
public class Compi1Proyecto1_Server201403775 {

    /**
     * @param args the command line arguments
     */
    
    private final static Conexion conexion = new Conexion();
    private final static Thread server = new Thread(conexion);
    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Interfaz_General inter = new Interfaz_General();
        inter.show(true);
        server.start();
        System.out.println("Done");
    }
    
}
