/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackEnd.DAO;

import com.google.gson.Gson;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static BackEnd.DAO.Stores_Generator.usuarios_hash;

/**
 *
 * @author sinozuke
 */
public class Stores_Generator_Repository implements Runnable{

        
    private final String ruta_backlog = "/home/sinozuke/Escritorio/repositorios/";
    private final DateFormat hourFormat = new SimpleDateFormat("HH_mm_ss");
    private final DateFormat dateFormat = new SimpleDateFormat("dd_MM_yyyy");
    private final Gson gson = new Gson();
    private final Date date = new Date();
    private String backup;
    private File Archivo_backlog;
    private BufferedWriter bw;
    
    @Override
    public void run() {
        backup = gson.toJson(usuarios_hash);
        Archivo_backlog = new File(MessageFormat.format("{0}{1}-{2}.txt", ruta_backlog, dateFormat.format(date), hourFormat.format(date)));
        try {
            System.out.println("Creando Repositorio de informacion");
            bw = new BufferedWriter(new FileWriter(Archivo_backlog));
            bw.write(backup);
            bw.close();
            System.out.println("Repositorio creado en: "+ruta_backlog);
        } catch (Exception ex) {
            System.out.println("Error al Guardar Repositorio: " + ex.getCause());
        }
    }
    
}