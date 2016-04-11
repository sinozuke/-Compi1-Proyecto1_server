/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackEnd.Conexion;

import BackEnd.DAO.Interfaces.Enlace_EnvioDAO;
import BackEnd.DAO.Objetos.Error;
import BackEnd.DAO.Objetos.Producto;
import BackEnd.DAO.Objetos.Tienda;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
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
        
    private boolean enlazar(){
        try{
            Cliente = new Socket(InetAddress.getLocalHost().getHostAddress(),3501);
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

    @Override
    public boolean reply_login(int id_usuario, String acceso) {
        if(this.enlazar()){
            try{
                enviado.writeUTF(MessageFormat.format("$reply$\n" +
                                                            "$Usuario$\n" +
                                                            "$id${0}$id-$\n" +
                                                            "$access$ {1} $access-$\n" +
                                                            "$Usuario-$\n" +
                                                        "$reply-$",id_usuario, acceso));
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
    
    public boolean enviar_Reply(String reply){
        if(this.enlazar()){
            try{
                enviado.writeUTF(MessageFormat.format("$reply$\n {0} \n$reply-$",reply));
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

    @Override
    public String reply_registro_usu(int id, String registro) {
        String reply = MessageFormat.format("$Usuario$\n" +
                "$registro id = {0} $ {1} $registro-$\n" +
                "$Usuario-$\n",String.valueOf(id), registro);
        return reply;
    }

    @Override
    public String reply_registro_tienda(int id, String registro) {
        StringBuilder reply=null;
        reply.append(MessageFormat.format("$tienda$\n" +
                                                "$registro id = {0}$ {1} $registro-$\n" +
                                           "$tienda-$\n",id, registro));
        return reply.toString();
    }

    @Override
    public String reply_modificacion_tienda(int id, String modificado) {
        StringBuilder reply=null;
        reply.append(MessageFormat.format("$tienda$\n" +
                                            "$modificar id = {0}$ {1} $modificar-$\n" +
                                          "$tienda-$\n",id, modificado));
        return reply.toString();
    }

    @Override
    public String reply_eliminar_tienda(int id, String eliminado) {
        StringBuilder reply=null;
        reply.append(MessageFormat.format("$tienda$\n" +
                                            "$eliminar id = {0}$ {1} $eliminar-$\n" +
                                          "$tienda-$\n",id, eliminado));
        return reply.toString();
    }

    @Override
    public String reply_registro_producto(int id, int sucursal, String registro) {
        StringBuilder reply=null;
        reply.append(MessageFormat.format("$producto$\n" +
                                            "$registro id={0} sucursal={1}$ {2} $registro-$\n" +
                                          "$producto-$\n",id, sucursal, registro));
        return reply.toString();  
    }

    @Override
    public String reply_modificacion_producto(int id, int sucursal, String modificado) {
        StringBuilder reply = null;
        reply.append(MessageFormat.format("$producto$\n" +
                                                "$modificar id={0} sucursal={1}$ {2} $modificar-$\n" +
                                            "$producto-$\n",id, sucursal, modificado));
        return reply.toString();
    }

    @Override
    public String reply_eliminacion_producto(int id, int sucursal, String eliminado) {
        StringBuilder reply = null;
        reply.append(MessageFormat.format("$producto$\n" +
                                                "$eliminar id={0} sucursal={1}$ {2} $eliminar-$\n" +
                                            "$producto-$\n",id, sucursal, eliminado));
        return reply.toString();
    }
    
    @Override
    public String reply_error(ArrayList<Error> Errores) {
        StringBuilder reply=null;
        Errores.stream().forEach((Error e)->{
            reply.append("$error-$\n");
            reply.append("$tipo$");
            reply.append(e.getTipo());
            reply.append("$tipo-$\n");
            if(e.getTipo().equals("lexico") || e.getTipo().equals("sintactico")){
                reply.append("$posicion$\n");
                reply.append("$fila$");
                reply.append(String.valueOf(e.getFila()));
                reply.append("$fila-$\n");
                reply.append("$columna$");
                reply.append(String.valueOf(e.getColumna()));
                reply.append("$columna-$\n");
                reply.append("$posicion-$\n");
            }
            reply.append("$descripcion$");
            reply.append(e.getDescripccion());
            reply.append("$descripcion-$\n");
            reply.append("$error-$\n");
        });
        return reply.toString();
    }

    @Override
    public String reply_lista_tiendas(ArrayList<Tienda> tiendas) {
        StringBuilder reply=null;
        reply.append("$lista$\n");

        tiendas.stream().forEach((Tienda t)->{
            reply.append("$tienda$\n");
            reply.append("$codigo$");
            reply.append(t.getCodigo());
            reply.append("$codigo-$\n");
            reply.append("$propietario$");
            reply.append(t.getPropietario());
            reply.append("$propietario-$\n");
            reply.append("$nombre$");
            reply.append("\"");
            reply.append(t.getNombre());
            reply.append("\"");
            reply.append("$nombre-$\n");
            reply.append("$direccion$");
            reply.append("\"");
            reply.append(t.getDirreccion());
            reply.append("\"");
            reply.append("$direccion-$\n");
            reply.append("$telefono$");
            reply.append(t.getTelefono());
            reply.append("$telefono-$\n");
            reply.append("$tienda-$\n");
        });
        reply.append("$lista-$\n");
        return reply.toString();                
    }

    @Override
    public String reply_lista_productos(ArrayList<Producto> productos) {
        StringBuilder reply=null;
        reply.append("$lista$\n");
        productos.stream().forEach((Producto p)->{
            reply.append("$producto$\n");
            reply.append("$código$");
            reply.append(p.getId());
            reply.append("$código-$\n");
            reply.append("$nombre$");
            reply.append("\"");
            reply.append(p.getNombre());
            reply.append("\"");
            reply.append("$nombre-$\n");
            reply.append("$cantidad$");
            reply.append(p.getCantidad());
            reply.append("$cantidad-$\n");
            reply.append("$marca$");
            reply.append("\"");
            reply.append(p.getMarca());
            reply.append("\"");
            reply.append("$marca-$\n");
            reply.append("$color$");
            reply.append("\"");
            reply.append(p.getColor());
            reply.append("\"");
            reply.append("$color-$\n");
            reply.append("$tamaño$");
            reply.append(p.getTamaño());
            reply.append("$tamaño-$\n");
            reply.append("$sucursal$");
            reply.append(p.getSucursal());
            reply.append("$sucursal-$\n");
            reply.append("$producto-$\n");
        });
        
        reply.append("$lista-$\n");
        return reply.toString();
    }
}