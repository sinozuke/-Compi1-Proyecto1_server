/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackEnd.DAO.Almacenadores;

import BackEnd.DAO.Objetos.DATOS;
import BackEnd.DAO.Objetos.Producto;
import BackEnd.DAO.Objetos.Tienda;
import BackEnd.DAO.Objetos.Usuario;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author sinozuke
 */

public class Stores_Generator implements Runnable{
    
    private String backup;
    private File Archivo_backlog;
    private BufferedWriter bw;
    private BufferedReader  br;
    private String Backup_backlog;
    public Usuario[] usuarios_hash = new Usuario[50];
    public Tienda[] Tienda_hash = new Tienda[5000];
    public Producto[] Productos_hash = new Producto[500000];
    private final Stores_Generator_Repository SGR = new Stores_Generator_Repository();
    private final Thread SGR1 = new Thread(SGR);
    private final String ruta_backlog = "/var/www/html/backlog.json";
    private final Gson gson = new Gson();
    private final JFileChooser fc = new JFileChooser();
    private final DATOS datos_backup = new DATOS();
    
    @Override
    public void run() {
        cargar();
    }
    
    private void cargar(){
            try{
            Archivo_backlog = new File(ruta_backlog);
            System.out.println("combrobando backlog");
            if(Archivo_backlog.exists()){
                System.out.println("Backlog encontrado");
                br = new BufferedReader(new FileReader(Archivo_backlog));
                Backup_backlog = "";
                Backup_backlog = br.readLine();
                System.out.println("verificando informacion");
                if(Backup_backlog!=null && !Backup_backlog.equals("")){
                    DATOS cargados = gson.fromJson(Backup_backlog, DATOS.class);
                    usuarios_hash=cargados.getDatos_usuario();
                    Tienda_hash=cargados.getDatos_tiendas();
                    Productos_hash=cargados.getDatos_productos();
                    System.out.println("informacion Restablecida");
                }
                br.close();                
            }else{
                System.out.println("Backlog no encontrado, Restablecimiento de informacion Fallido");
                this.error_datos("Backlog faltante");
            }
        }catch(IOException | NullPointerException | JsonSyntaxException ex){
            System.out.println("Backlog Corrupto: "+ex.getCause());
            this.error_datos("backlog corrupto, fallo al leer archivo");
        }
    }
    
    private void error_datos(String Causa){
        JOptionPane.showMessageDialog(fc, "Error cargando Datos\n -" + Causa + " -\neliga un repositorio para la carga");
        this.Carga_Repositorio();
    }
    
    private void cargar_repositorio(File repositorio){
        try{
            System.out.println("combrobando backlog");
            if(repositorio.exists()){
                System.out.println("Backlog encontrado");
                br = new BufferedReader(new FileReader(repositorio));
                Backup_backlog = "";
                Backup_backlog = br.readLine();
                System.out.println("verificando informacion");
                if(Backup_backlog!=null && !Backup_backlog.equals("")){
                    DATOS cargados = gson.fromJson(Backup_backlog, DATOS.class);
                    usuarios_hash=cargados.getDatos_usuario();
                    Tienda_hash=cargados.getDatos_tiendas();
                    Productos_hash=cargados.getDatos_productos();
                    System.out.println("informacion Restablecida");
                }
                br.close();                
            }else{
                System.out.println("Backlog no encontrado, Restablecimiento de informacion Fallido");
            }
        }catch(IOException | NullPointerException | JsonSyntaxException ex){
            System.out.println("Backlog Corrupto: "+ex.getCause());
        }
    }
    
    private void Carga_Repositorio(){
        fc.setCurrentDirectory(new File("/home/sinozuke/Escritorio/repositorios/"));
        fc.showOpenDialog(null);
        
        File abre = new File(fc.getSelectedFile().getAbsolutePath());
        cargar_repositorio(abre);
    }
    
    public void Realizar_Backup(){
        datos_backup.setDatos_productos(Productos_hash);
        datos_backup.setDatos_tiendas(Tienda_hash);
        datos_backup.setDatos_usuario(usuarios_hash);
        backup = gson.toJson(datos_backup);
        Archivo_backlog = new File(ruta_backlog);
        try {
            System.out.println("Creando Respaldo de informacion");
            bw = new BufferedWriter(new FileWriter(Archivo_backlog));
            bw.write(backup);
            bw.close();
            System.out.println("Respaldo creado en: "+ruta_backlog);
            SGR1.start();
            while(SGR1.isAlive()){}
        } catch (Exception ex) {
            System.out.println("Error al Guardar BackLog: " + ex.getCause());
        }  
    }
}