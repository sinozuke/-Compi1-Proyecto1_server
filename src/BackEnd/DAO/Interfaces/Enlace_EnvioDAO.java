/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackEnd.DAO.Interfaces;

import BackEnd.DAO.Objetos.Producto;
import BackEnd.DAO.Objetos.Tienda;
import java.util.ArrayList;

/**
 *
 * @author sinozuke
 */
public interface Enlace_EnvioDAO {
 
    boolean reply_login(int id_usuario,String acceso);
    String reply_registro_usu(int id, String registro);
    String reply_registro_tienda(int id,String registro);
    String reply_modificacion_tienda(int id, String modificado);
    String reply_eliminar_tienda(int id, String eliminado);
    String reply_registro_producto(int id,int sucursal, String registro);
    String reply_modificacion_producto(int id,int sucursal,String modificado);
    String reply_eliminacion_producto(int id,int sucursal,String eliminado);
    String reply_error(String tipo,String descripccion, int fila, int columna);
    String reply_lista_tiendas(ArrayList<Tienda> tiendas);
    String reply_lista_productos(ArrayList<Producto> productos);
}
