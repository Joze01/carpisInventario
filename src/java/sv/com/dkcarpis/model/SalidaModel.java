/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.dkcarpis.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import sv.com.dkcapris.beans.EntradaBean;
import sv.com.dkcapris.beans.SalidaBean;

/**
 *
 * @author Jose-PC
 */
public class SalidaModel {
        Conexion con;

    ResultSet rs;
    public boolean nuevaEntrada(SalidaBean exitData) throws SQLException{
     boolean resultado =false;
     con = new Conexion();
     con.query="INSERT INTO salida(id_usuario, id_producto, salida_cantidad, salida_precio, salida_fecha) VALUES ("+exitData.getId_usuario()+","+exitData.getId_producto()+","+exitData.getSalidad_cantidad()+","+exitData.getSalida_precio()+","+exitData.getSalida_fecha()+")";
     resultado=con.setQuery(con.query);
     con.cerrarConexion();
     return resultado;
    }
    
    public boolean modificarEntrada(SalidaBean exitData) throws SQLException{
     boolean resultado =false;
     con = new Conexion();
     con.query="UPDATE salida SET id_usuario="+exitData.getId_usuario()+", id_producto="+exitData.getId_producto()+", salida_cantidad="+exitData.getSalidad_cantidad()+",salida_precio="+exitData.getSalida_precio()+",salida_fecha="+exitData.getSalida_fecha()+" WHERE salida_id="+exitData.getId();
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
    
    
        
    
      public ArrayList<SalidaBean> getAllTable() throws SQLException{
       ArrayList<SalidaBean> listado = new ArrayList<SalidaBean>();
        Conexion con = new  Conexion();
        con.query="SELECT * FROM salida "
                + "INNER JOIN producto on producto.producto_id=salida.id_producto "
                + "INNER JOIN fabricante on fabricante.fabricante_id=producto.id_fabricante  "
                + "INNER JOIN categoria on categoria.categoria_id=producto.id_categoria "
                + "INNER JOIN tipoproducto on tipoproducto.tipoproducto_id = producto.id_tipoproducto";
        con.setRs(con.query);
        rs = con.getRs();
        while(rs.next()){
            SalidaBean exts = new SalidaBean();
            exts.setId(rs.getInt("salida_int"));
            exts.setSalidad_cantidad(rs.getInt("salida_cantidad"));
            exts.setSalida_precio(rs.getFloat("salida_precio"));
            exts.setSalida_fecha(rs.getDate("salida_fecha"));
            
          
                        
            exts.setProducto_nombre(rs.getString("producto_nombre"));
            exts.setProducto_fabricante(rs.getString("fabricante_nombre"));
            exts.setProducto_categoria(rs.getString("categoria_nombre"));
            exts.setProducto_tipo(rs.getString("tipoproducto_nombre"));
            exts.setProducto_serie(rs.getString("producto_serie"));
           
            
            listado.add(exts);
        
        }
       
       return listado;
   }
}
