/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackEnd.DAO.Hash;

import BackEnd.DAO.Compilador.Seccion_Mate;
import java.util.ArrayList;

/**
 *
 * @author sinozuke
 */
public class Tabla_Hash_compilador {
    public static ArrayList<Seccion_Mate> secciones;
    private static boolean esta;
    private static Seccion_Mate temp;
    
    public boolean estaseccion(String secc){
        esta=false;
        secciones.stream().forEach((Seccion_Mate sec)->{
            if(sec.id.equals(secc)){
                esta=true;
            }
        });
        return esta;
    }
    
    public Seccion_Mate devolver_seccion(String seccion){
        temp=null;
        secciones.stream().forEach((Seccion_Mate secc)->{
            if(secc.id.equals(seccion)){
                temp=secc;
            }
        });
        return temp;
    }
}
