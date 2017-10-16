/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.dkcarpis.model;

import java.sql.SQLException;
import sv.com.dkcapris.beans.SalidaBean;

/**
 *
 * @author Jose-PC
 */
public class SalidaModel {
        Conexion con;
    public boolean nuevaEntrada(SalidaBean exitData) throws SQLException{
     boolean resultado =false;
     con = new Conexion();
     con.query="INSERT INTO salida(id_usuario, id_producto, salida_cantidad, salida_precio, salida_fecha) VALUES ("+exitData.getId_usuario()+","+exitData.getId_producto()+","+exitData.getSalidad_cantidad()+","+exitData.getSalida_precio()+","+exitData.getFecha()+")";
     resultado=con.setQuery(con.query);
     con.cerrarConexion();
     return resultado;
    }
    
    public boolean modificarEntrada(SalidaBean exitData) throws SQLException{
     boolean resultado =false;
     con = new Conexion();
     con.query="UPDATE salida SET id_usuario="+exitData.getId_usuario()+", id_producto="+exitData.getId_producto()+", salida_cantidad="+exitData.getSalidad_cantidad()+",salida_precio="+exitData.getSalida_precio()+",salida_fecha="+exitData.getFecha()+" WHERE salida_id="+exitData.getId();
     resultado=con.setQuery(con.query);
     con.cerrarConexion();
     return resultado;
    }
        
        
        
    public boolean EliminarEntrada(SalidaBean exitData) throws SQLException{
     boolean resultado =false;
     con = new Conexion();
     con.query="delete from salida where salida_id="+exitData.getId();
     resultado=con.setQuery(con.query);
     con.cerrarConexion();
     return resultado;
    }
}
