/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackEnd.DAO.Compilador;

import BackEnd.DAO.Objetos.Producto;
import BackEnd.DAO.Objetos.Tienda;
import BackEnd.DAO.Objetos.Usuario;
import java.util.ArrayList;

/**
 *
 * @author sinozuke
 */
public class Query {
    private int atributo_evaluado;
    private boolean producto;
    private boolean tienda;
    private boolean usuario;
    private ArrayList<Usuario> usuarios;
    private ArrayList<Tienda> tiendas;
    private ArrayList<Producto> productos;

    public int getAtributo_evaluado() {
        return atributo_evaluado;
    }

    public void setAtributo_evaluado(int atributo_evaluado) {
        this.atributo_evaluado = atributo_evaluado;
    }

    public boolean isProducto() {
        return producto;
    }

    public void setProducto(boolean producto) {
        this.producto = producto;
    }

    public boolean isTienda() {
        return tienda;
    }

    public void setTienda(boolean tienda) {
        this.tienda = tienda;
    }

    public boolean isUsuario() {
        return usuario;
    }

    public void setUsuario(boolean usuario) {
        this.usuario = usuario;
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public ArrayList<Tienda> getTiendas() {
        return tiendas;
    }

    public void setTiendas(ArrayList<Tienda> tiendas) {
        this.tiendas = tiendas;
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
    }
    
}
