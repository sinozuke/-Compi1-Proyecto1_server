/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackEnd.DAO.Compilador;

import java.util.ArrayList;
import BackEnd.Analizador.Ecuaciones.Lexico_ecuaciones;
import BackEnd.Analizador.Ecuaciones.Analizador_Sintactico_ecuaciones;
import java.io.ByteArrayInputStream;
/**
 *
 * @author sinozuke
 */
public class Funcion_Mate {
    
    public String id;
    public ArrayList<String> parametros;
    public String accion;
    private String[] params2;
    private String[] params1;
    public static String resultado;
    
    public String devolver_entero(ArrayList<String> params) throws Exception{
        Analizador_Sintactico_ecuaciones ANAL_SIN=null;
        if(parametros.size()>params.size()){
            return "Error: se esperavan mas parametros para la funcion " + this.id;
        }else if(parametros.size()<params.size()){
            return "Error: el numero de valores es mayor al de parametros";
        }else if(parametros.size()==params.size()){
            params1 = (String[])parametros.toArray();
            params2 = (String[]) params.toArray();
            int j = params2.length;
            String accion_final = accion;
            for(int i=0;i<j;i++){
                accion_final = a(accion,params1[i],String.valueOf(params2[i]));
            }
            Lexico_ecuaciones ANAL_LEX = new Lexico_ecuaciones(new ByteArrayInputStream(accion_final.getBytes())); 
            ANAL_SIN = new Analizador_Sintactico_ecuaciones(ANAL_LEX);
            ANAL_SIN.parse();
        }
        return String.valueOf(ANAL_SIN.resultado);
    }
    
    private String a(String acc,String valor,String parametro){
        return acc.replaceAll(parametro, valor);
    }
}