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
public interface Enlace_EnvioDAO {
 
    boolean reply_login(int id_usuario,String acceso);
    boolean reply_registro_usu(int id, String registro);
    boolean reply_registro_tienda(int id,String registro);
    boolean reply_modificacion_tienda(int id, String modificado);
    boolean reply_eliminar_tienda(int id, String eliminado);
    boolean reply_registro_producto(int id,int sucursal, String registro);
    boolean reply_modificacion_producto(int id,int sucursal,String modificado);
    boolean reply_eliminacion_producto(int id,int sucursal,String eliminado);
    boolean reply_error(String descripccion);
    boolean reply_lista_tiendas(ArrayList<Tienda> tiendas);
    boolean reply_lista_productos(ArrayList<Producto> productos);
}
