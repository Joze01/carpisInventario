/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.dkcarpis.model;
import java.sql.SQLException;
import sv.com.dkcapris.beans.EntradaBean;
/**
 *
 * @author Jose-PC
 */
public class EntradaModel {
    Conexion con;
    public boolean nuevaEntrada(EntradaBean ntrData) throws SQLException{
     boolean resultado =false;
     con = new Conexion();
     con.query="INSERT INTO entrada(id_usuario, id_producto, entrada_cantidad, entrada_precio, entrada_fecha) VALUES ("+ntrData.getId_usuario()+","+ntrData.getId_producto()+","+ntrData.getEntrada_cantidad()+","+ntrData.getEntrada_precio()+","+ntrData.getEntrada_fecha()+")";
     resultado=con.setQuery(con.query);
     con.cerrarConexion();
     return resultado;
    }
    
    public boolean modificarEntrada(EntradaBean ntrData) throws SQLException{
     boolean resultado =false;
     con = new Conexion();
     con.query="UPDATE entrada SET id_usuario="+ntrData.getId_usuario()+", id_producto="+ntrData.getId_producto()+", entrada_cantidad="+ntrData.getEntrada_cantidad()+",entrada_precio="+ntrData.getEntrada_precio()+",entrada_fecha="+ntrData.getEntrada_fecha()+" WHERE entrada_id="+ntrData.getId();
     resultado=con.setQuery(con.query);
     con.cerrarConexion();
     return resultado;
    }
        
        
        
    public boolean EliminarEntrada(EntradaBean ntrData) throws SQLException{
     boolean resultado =false;
     con = new Conexion();
     con.query="delete from entrada where entrada_id="+ntrData.getId();
     resultado=con.setQuery(con.query);
     con.cerrarConexion();
     return resultado;
    }
    
    
}
