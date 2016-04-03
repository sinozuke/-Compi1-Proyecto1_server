/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackEnd.DAO;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author sinozuke
 */

public class Stores_Generator implements Runnable{
    
    private final Gson gson = new Gson();
    private String backup;
    private final String ruta_backlog = "/home/sinozuke/Escritorio/backlog.txt";
    private File Archivo_backlog;
    private BufferedWriter bw;
    private BufferedReader  br;
    public static Usuario[] usuarios_hash = new Usuario[10000];
    
    @Override
    public void run() {
        try{
            Archivo_backlog = new File(ruta_backlog);
            if(Archivo_backlog.exists()){
                br = new BufferedReader(new FileReader(Archivo_backlog));

                String Backup_backlog=null;

                while(br.readLine()!=null){
                    Backup_backlog += br.readLine();
                }
                if(Backup_backlog!=null && !Backup_backlog.equals("")){
                    Stores_Generator.usuarios_hash=gson.fromJson(Backup_backlog, Usuario[].class);
                }
                br.close();                
            }
        }catch(IOException | JsonSyntaxException ex){
            System.out.println(ex.getCause());
        }
    }
    
    public void Realizar_Backup(){
        backup = gson.toJson(usuarios_hash);
        Archivo_backlog = new File(ruta_backlog);
        try {
            bw = new BufferedWriter(new FileWriter(Archivo_backlog));
            bw.write(backup);
            bw.close();
        } catch (Exception ex) {
            System.out.println("Error al Guardar BackLog: " + ex.getCause());
        }  
    }
}
