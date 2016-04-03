/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackEnd.Conexion;

import BackEnd.DAO.Enlace_EnvioDAO;
import BackEnd.DAO.Producto;
import BackEnd.DAO.Tienda;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.text.MessageFormat;
import java.util.ArrayList;

/**
 *
 * @author sinozuke
 */
public class Enlace_Envio implements Enlace_EnvioDAO{
    
        private Socket Cliente;
        private DataOutputStream enviado;
        public static String dirreccionip;
    
    private boolean enlazar(){
        try{
            Cliente = new Socket(dirreccionip,3501);
            enviado = new DataOutputStream(Cliente.getOutputStream());
            System.out.println("enlace Creado con Exito");
            return true;
        }catch(Exception ex){
            System.out.println("Conexion Fallida: " + ex.getMessage());
            return false;
        }
    }
        
    private void Terminar_Conexion() {
            try {
                Cliente.close();
            } catch (IOException ex) {
                System.out.println(MessageFormat.format("Error al intentar Cerrar Puerto:{0}", ex.getCause()));
            }
    }
/*
    @Override
    public boolean Conectar(String usuario, String contraseña) {
        if(this.enlazar()){
            try{
                enviado.writeUTF(MessageFormat.format(  "$request$\n" +
                                                            "$InicioUsuario$\n" +
                                                                "$id${0}$id-$\n" +
                                                                "$password${1}$password-$\n" +
                                                            "$InicioUsuario-$\n" +
                                                        "$request-$", usuario, contraseña));
                this.Terminar_Conexion();
                return true;
            }catch(Exception ex){
                System.out.println(ex.getCause());
                return false;
            }
        }else{
            System.out.println("imposible conectar al socket");
            return false;
        }
    }
*/
    @Override
    public boolean reply_login(int id_usuario, String acceso) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean reply_registro_usu(int id, String registro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean reply_registro_tienda(int id, String registro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean reply_modificacion_tienda(int id, String modificado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean reply_eliminar_tienda(int id, String eliminado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean reply_registro_producto(int id, int sucursal, String registro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean reply_modificacion_producto(int id, int sucursal, String modificado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean reply_eliminacion_producto(int id, int sucursal, String eliminado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean reply_error(String descripccion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean reply_lista_tiendas(ArrayList<Tienda> tiendas) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean reply_lista_productos(ArrayList<Producto> productos) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}