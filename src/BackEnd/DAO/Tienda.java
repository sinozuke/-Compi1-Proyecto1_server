/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackEnd.DAO;

import java.util.ArrayList;

/**
 *
 * @author sinozuke
 */
public class Tienda {
    
    private int codigo;
    private int propietario;
    private String Nombre;
    private String Dirreccion;
    private int telefono;
    private String img;
    public static ArrayList<Producto> productos;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getPropietario() {
        return propietario;
    }

    public void setPropietario(int propietario) {
        this.propietario = propietario;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getDirreccion() {
        return Dirreccion;
    }

    public void setDirreccion(String Dirreccion) {
        this.Dirreccion = Dirreccion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public static ArrayList<Producto> getProductos() {
        return productos;
    }

    public static void setProductos(ArrayList<Producto> productos) {
        Tienda.productos = productos;
    }
    
}
