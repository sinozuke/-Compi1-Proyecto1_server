/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackEnd.Conexion;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author sinozuke
 */

public class Conexion implements Runnable{

    private static ServerSocket servidor;
    private Socket cliente;
    private DataInputStream recividos;
    private DataOutputStream enviados;
    private Socket via;
    public Conexion(){
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
        String recv;
        System.out.println("Buscando por clientes");
        while (true){
            try {
                cliente = servidor.accept();
                recividos = new DataInputStream(cliente.getInputStream());
                recv = recividos.readUTF();
                System.out.println(recv);
                via = new Socket(cliente.getLocalAddress(),3501);
                enviados = new DataOutputStream(via.getOutputStream());
                enviados.writeUTF("Datos Recividos");
                System.out.println("Datos Enviados");
                cliente.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
    
}
