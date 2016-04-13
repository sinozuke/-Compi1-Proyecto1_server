/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package compi1.proyecto1_server.pkg201403775;



import BackEnd.Conexion.Conexion;
import BackEnd.DAO.Almacenadores.Stores_Generator;
import BackEnd.DAO.Hash.Tabla_Hash_DATOS;
import BackEnd.DAO.Objetos.Error;
import Interfaz.Interfaz_Server;
import java.util.ArrayList;

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
    public final static Tabla_Hash_DATOS hash = new Tabla_Hash_DATOS();
    public final static Thread SGI = new Thread(SG);
    public static final Interfaz_Server inter = new Interfaz_Server();
    public static final ArrayList<Error> errores = new ArrayList();
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
