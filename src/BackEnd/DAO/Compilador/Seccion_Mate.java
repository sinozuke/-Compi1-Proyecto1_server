/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackEnd.DAO.Compilador;

import java.util.ArrayList;

/**
 *
 * @author sinozuke
 */
public class Seccion_Mate {
    
    public String id;
    public ArrayList<Funcion_Mate> funciones=new ArrayList();
    public ArrayList<Cons_Mate> constantes=new ArrayList();
    private static boolean esta;
    private static Funcion_Mate temp1;
    private static Cons_Mate temp2;
    
    public void agregar_funcion(Funcion_Mate nueva){
        this.funciones.add(nueva);
    }
    
    public void agregar_constante(Cons_Mate nueva){
        this.constantes.add(nueva);
    }
    
    public boolean estafuncion(String funcion){
        esta=false;
        funciones.stream().forEach((Funcion_Mate F)->{
            if(F.id.equals(funcion)){
                esta=true;
            }
        });
        return esta;
    }
    
    public Funcion_Mate devolverfuncion(String func){
        temp1=null;
        funciones.stream().forEach((Funcion_Mate funcion)->{
            if(funcion.id.equals(func)){
                temp1=funcion;
            }
        });
        return temp1;
    }
    
    public Cons_Mate devolverconst(String id){
        temp2=null;
        constantes.stream().forEach((Cons_Mate constants)->{
            if(constants.id.equals(id)){
                temp2=constants;
            }
        });
        return temp2;
    }
    
    public boolean estacons(String constant){
        esta=false;
        constantes.stream().forEach((Cons_Mate C)->{
            if(C.id.equals(constant)){
                esta=true;
            }
        });
        return esta;
    }
}