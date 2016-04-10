/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackEnd.DAO.Hash;

import BackEnd.DAO.Objetos.Producto;
import BackEnd.DAO.Objetos.Tienda;
import BackEnd.DAO.Objetos.Usuario;
import static compi1.proyecto1_server.pkg201403775.Compi1Proyecto1_Server201403775.SG;
import java.util.ArrayList;

/**
 *
 * @author sinozuke
 */
public class Tabla_Hash_DATOS {    
    
    public int Hash_Cod_Tienda(int id,int sucursal){
        return 100*(id - 1) + (sucursal - 1);
    }
    public int Hash_Cod_Producto(int id, int sucursal, int producto){
        return 100*(100*(id - 1) + (sucursal-1))+(producto - 1);    
    }
    public Producto getproducto(int indice){
        return SG.Productos_hash[indice];
    }
    public Tienda getTienda(int indice){
        return SG.Tienda_hash[indice];
    }
    public Usuario getusuario(int indice){
        return SG.usuarios_hash[indice];
    }
    public ArrayList<Tienda> get_tiendas(){
        ArrayList<Tienda> temp = null;
        for(int i =0;i<5000;i++){
            if(SG.Tienda_hash[i]!=null){
                temp.add(SG.Tienda_hash[i]);
            }
        }
        return temp;    
    }
    public ArrayList<Producto> get_productos(){
        ArrayList<Producto> temp = null;
        for(int i =0;i<500000;i++){
            if(SG.Productos_hash[i]!=null){
                temp.add(SG.Productos_hash[i]);
            }
        }
        return temp;    
    }
    public ArrayList<Usuario> get_usuarios(){
        ArrayList<Usuario> temp = null;
        for(int i =0;i<50;i++){
            if(SG.usuarios_hash[i]!=null){
                temp.add(SG.usuarios_hash[i]);
            }
        }
        return temp;    
    }
    public ArrayList<Tienda> get_tiendasc1(int OL,int Atributo,Object comparacion){
        ArrayList<Tienda> temp = this.get_tiendas();
        temp.stream().forEach((Tienda t)->{
            switch(Atributo){
                case 1:
                    if(this.aceptarint(OL, t.getCodigo(), (Integer)comparacion)){
                        temp.add(t);
                    }
                    break;
                case 2:
                    if(this.aceptarint(OL, t.getPropietario(), (Integer)comparacion)){
                        temp.add(t);
                    }
                    break;
                case 3:
                    if(this.aceptarstring(OL, t.getNombre(), (String)comparacion)){
                        temp.add(t);
                    }
                    break;
                case 4:
                    if(this.aceptarstring(OL, t.getDirreccion(), (String)comparacion)){
                        temp.add(t);
                    }
                    break;
                case 5:
                    if(this.aceptarint(OL, t.getTelefono(), (Integer)comparacion)){
                        temp.add(t);
                    }
                    break;
            }
        });
        return temp;
    }
    private boolean aceptarint(int ol, int atributo, int comparacion){
        boolean a=false;
        switch(ol){
            case 1:
                a = atributo==comparacion;
                break;
            case 2:
                a= atributo!=comparacion;
                break;
        }
        return a;
    }
    private boolean aceptarstring(int ol, String atributo, String comparacion){
        boolean a=false;
        switch(ol){
            case 1:
                a = atributo.equals(comparacion);
                break;
            case 2:
                a= atributo.equals(comparacion);
                break;
        }
        return a;
    }
}
