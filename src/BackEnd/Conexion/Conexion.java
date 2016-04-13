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
import BackEnd.Analizador.Compilador.Lexico_Request;
import BackEnd.Analizador.Compilador.AnalizadorSintactico_compilador;
import java.io.ByteArrayInputStream;

/**
 *
 * @author sinozuke
 */

public class Conexion implements Runnable{
    
    private Lexico_Request Lex;
    private AnalizadorSintactico_compilador Sin;
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
                Lex = new Lexico_Request(new ByteArrayInputStream(recivido.getBytes()));
                Sin = new AnalizadorSintactico_compilador(Lex);
                Sin.parse();
                cliente.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
    
}