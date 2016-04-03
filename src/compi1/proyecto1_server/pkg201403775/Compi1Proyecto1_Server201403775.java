/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package compi1.proyecto1_server.pkg201403775;



import BackEnd.Conexion.Conexion;
import BackEnd.Conexion.Enlace_Envio;
import BackEnd.DAO.Stores_Generator;
import Interfaz.Interfaz_Server;

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
    public final static Stores_Generator SG = new Stores_Generator();
    public final static Thread SGI = new Thread(SG);
    public final static Enlace_Envio conexion1 = new Enlace_Envio();
    public static final Interfaz_Server inter = new Interfaz_Server();
    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        // TODO code application logic here
        SGI.start();
        server.start();
        inter.show(true);
        System.out.println("Done");
    }
    
}
