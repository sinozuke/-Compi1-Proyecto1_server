/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackEnd.DAO.Objetos;

/**
 *
 * @author sinozuke
 */
public class DATOS {
    private Tienda[] datos_tiendas;
    private Usuario[] datos_usuario;
    private Producto[] datos_productos;

    public Tienda[] getDatos_tiendas() {
        return datos_tiendas;
    }

    public void setDatos_tiendas(Tienda[] datos_tiendas) {
        this.datos_tiendas = datos_tiendas;
    }

    public Usuario[] getDatos_usuario() {
        return datos_usuario;
    }

    public void setDatos_usuario(Usuario[] datos_usuario) {
        this.datos_usuario = datos_usuario;
    }

    public Producto[] getDatos_productos() {
        return datos_productos;
    }

    public void setDatos_productos(Producto[] datos_productos) {
        this.datos_productos = datos_productos;
    }
    
    
    
}
