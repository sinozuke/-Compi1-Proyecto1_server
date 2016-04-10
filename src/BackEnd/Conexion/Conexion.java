/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackEnd.Conexion;

import java.io.DataInputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 *
 * @author sinozuke
 */

public class Conexion implements Runnable{
    
    public static class enlace_usuario implements Runnable{
        
        public static final Enlace_Envio enlace=new Enlace_Envio();
        private final String recivido;
        public enlace_usuario(String recivido,InetAddress ip) {
            this.recivido = recivido;
            enlace.dirreccionip=ip;
        }
        
        @Override
        public void run() {
            //metodo a analizar
        }
        
    }

    private static ServerSocket servidor;
    private Socket cliente;
    private ArrayList<Thread> enlaces;
    
    public Conexion(){
        this.enlaces = new ArrayList();
        if(conectar()){
            System.out.println("conexion hecha, Servidor andando");
        }else{
            System.out.println("Servidor no conectado");
        }
    
    }
    
    
    protected final boolean conectar(){
        try{
            servidor = new ServerSocket(3500);
            return true;
        }catch(Exception ex){
            System.out.println(ex.getCause());
            return false;
        }    
    }
    
    @Override
    public void run() {
        System.out.println("Buscando por clientes");
        while (true){
            try {
                cliente = servidor.accept();
                String recivido =new DataInputStream(cliente.getInputStream()).readUTF();
                enlaces.add(new Thread(new enlace_usuario(recivido,cliente.getLocalAddress())));
                enlaces.get(enlaces.size()-1).start();
                cliente.close();
                enlaces = eliminar_enlaces(enlaces);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
    
    private ArrayList<Thread> eliminar_enlaces(ArrayList<Thread> enlaces1){
        ArrayList<Thread> temp1 = null;
            enlaces1.stream().forEach((Thread t)->{
                if(t.isAlive()){
                   temp1.add(t);
                }
            });
        return temp1;
    }
    
}