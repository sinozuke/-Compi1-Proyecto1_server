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
    
    public void insertar_usu(int indice, Usuario insertar){
        SG.usuarios_hash[indice-1] = insertar;
    }

    public Usuario getusu(int indice){
        return SG.usuarios_hash[indice-1];
    }
    public Tienda gettienda(int indice){
        return SG.Tienda_hash[indice];
    }
    public Producto getProdu(int indice){
        return SG.Productos_hash[indice];
    }
    public void eliminarproduc(int indice){
        SG.Productos_hash[indice]=null;
    }
    public void modificarprodu(int indice,Producto pro){
        SG.Productos_hash[indice]=pro;
    }
    public void eliminartienda(int indice){
        SG.Tienda_hash[indice]=null;
    }
    public void modificartienda(int indice, Tienda temp){
        SG.Tienda_hash[indice]=temp;
    }
    public boolean usuExist(int indice){
        if(indice>49){
            return false;
        }else{
            return SG.usuarios_hash[indice]==null;
        }
    }
    public boolean tiendaExist(int indice){
        if(indice >4999){
            return false;
        }else{
            return SG.Tienda_hash[indice]==null;    
        }
    }
    public boolean produExist(int indice){
        if(indice >499999){
            return false;
        }else{
            return SG.Productos_hash[indice]==null;
        }
    }
    public int Hash_Cod_Tienda(int id,int sucursal){
        return 100*(id - 1) + (sucursal - 1);
    }
    public int Hash_Cod_Producto(int sucursal, int producto){
        return (sucursal-1)+(producto - 1);    
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
        ArrayList<Tienda> temp = new ArrayList();
        for(int i =0;i<5000;i++){
            if(SG.Tienda_hash[i]!=null){
                temp.add(SG.Tienda_hash[i]);
            }
        }
        return temp;    
    }
    public ArrayList<Producto> get_productos(){
        ArrayList<Producto> temp = new ArrayList();
        for(int i =0;i<500000;i++){
            if(SG.Productos_hash[i]!=null){
                temp.add(SG.Productos_hash[i]);
            }
        }
        return temp;    
    }
    public ArrayList<Usuario> get_usuarios(){
        ArrayList<Usuario> temp = new ArrayList();
        for(int i =0;i<50;i++){
            if(SG.usuarios_hash[i]!=null){
                temp.add(SG.usuarios_hash[i]);
            }
        }
        return temp;    
    }
    
    public ArrayList<Usuario> get_usuariosc(String evaluar, Object comparacion){
        ArrayList<Usuario> usuarios = this.get_usuarios();
        ArrayList<Usuario> temp = new ArrayList();
        usuarios.stream().forEach((Usuario u)->{
            switch(evaluar){
                case "id":
                    if(u.getId()==Integer.parseInt((String)comparacion)){temp.add(u);}
                    break;
                case "nombre":
                    if(u.getNombre().equals((String)comparacion)){temp.add(u);}
                    break;
                case "apellido":
                    if(u.getApellido().equals((String)comparacion)){temp.add(u);}
                    break;
                case "password":
                    if(u.getPassword().equals((String)comparacion)){temp.add(u);}
                    break;
                case "telefono":
                    if(u.getTelefono()==Integer.parseInt((String)comparacion)){temp.add(u);}
                    break;
                case "email":
                    if(u.getEmail().equals((String)comparacion)){temp.add(u);}
                    break;
                case "direccion":
                    if(u.getDirreccion().equals((String)comparacion)){temp.add(u);}
                    break;
            }
        
        
        });
        
        return temp;
    }
    
    public ArrayList<Tienda> get_tiendasc(String evaluacion,Object comparacion){
        ArrayList<Tienda> temp = this.get_tiendas();
        ArrayList<Tienda> temp2 = new ArrayList();
        try{}catch(Exception ex){}
        temp.stream().forEach((Tienda t)->{
            switch(evaluacion){
                case "codigo":
                    if(t.getCodigo()==Integer.parseInt((String)comparacion)){
                        temp2.add(t);
                    }
                    break;
                case "propietario":
                    if(t.getPropietario()==Integer.parseInt((String)comparacion)){
                        temp2.add(t);
                    }
                    break;
                case "nombre":
                    if(t.getNombre().equals((String)comparacion)){
                        temp2.add(t);
                    }
                    break;
                case "dirreccion":
                    if(t.getDirreccion().equals((String)comparacion)){
                        temp2.add(t);
                    }
                    break;
                case "telefono":
                    if(t.getTelefono()==Integer.parseInt((String)comparacion)){
                        temp2.add(t);
                    }
                    break;
            }
        });
        return temp2;
    }
    public ArrayList<Producto> get_productosc(String evaluar,Object comparacion){
        ArrayList<Producto> temp = this.get_productos();
        ArrayList<Producto> temp2 = new ArrayList();
        temp.stream().forEach((Producto p)->{
            switch(evaluar){
                case "id":
                    if(p.getId()==Integer.parseInt((String)comparacion)){
                        temp2.add(p);
                    }
                    break;
                case "nombre":
                    if(p.getNombre().equals((String)comparacion)){
                        temp2.add(p);
                    }
                    break;
                case "marca":
                    if(p.getMarca().equals((String)comparacion)){
                        temp2.add(p);
                    }
                    break;
                case "color":
                    if(p.getColor().equals((String)comparacion)){
                        temp2.add(p);
                    }
                    break;
                case "cantidad":
                    if(p.getCantidad()==Integer.parseInt((String)comparacion)){
                        temp2.add(p);
                    }
                    break;
                case "tamaño":
                    if(p.getTamaño()==Integer.parseInt((String)comparacion)){
                        temp2.add(p);
                    }
                    break;
                case "sucursal":
                    if(p.getSucursal()==Integer.parseInt((String)comparacion)){
                        temp2.add(p);
                    }
                    break;
            }
        });
        return temp2;
    }
    public ArrayList<Producto> Negar_productos(ArrayList<Producto> negados){
        ArrayList<Producto> temp = this.get_productos();
        
        negados.stream().forEach((Producto p)->{
            temp.remove(p);
        });
        
        return temp;
    }
    public ArrayList<Tienda> Negar_tiendas(ArrayList<Tienda> negados){
        ArrayList<Tienda> temp = this.get_tiendas();
        
        negados.stream().forEach((Tienda p)->{
            temp.remove(p);
        });
        
        return temp;
    }
    public ArrayList<Usuario> Negar_usuarioss(ArrayList<Usuario> negados){
        ArrayList<Usuario> temp = this.get_usuarios();
        ArrayList<Usuario> temp2 = negados;
        
        negados.stream().forEach((Usuario p)->{
            temp.remove(p);
        });
        
        return temp;
    }

}
