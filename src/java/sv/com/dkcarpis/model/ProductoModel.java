/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.dkcarpis.model;
import java.sql.SQLException;
import java.sql.*;
import sv.com.dkcapris.beans.ImageBean;
import sv.com.dkcapris.beans.ProductoBean;
import sv.com.dkcarpis.model.ImageModel;
/**
 *
 * @author Jose-PC
 */
public class ProductoModel {
    ImageModel imgModel = new ImageModel();
    Conexion con;
    ResultSet rs;
    public boolean nuevoProducto(ProductoBean prdData) throws SQLException{
    boolean resultado=false;
         con =  new  Conexion();
         con.query="INSERT INTO producto(id_fabricante, producto_serie, producto_nombre) VALUES ("+prdData.getId_fabricante()+",'"+prdData.getProducto_serie()+"','"+prdData.getProducto_nombre()+"')";
         resultado=con.setQuery(con.query);
         con.cerrarConexion();
         con.query="select * from producto order by producto_id asc limit 1";
         con.setRs(con.query);
         rs=con.getRs();
         while(rs.next()){
         prdData.setProducto_id(rs.getInt("producto_id"));
         }
         
         imgModel.nuevaImagen(prdData.getProductoImagenes(),prdData.getProducto_id());
         
    return resultado;
    }
    
    
   public boolean modificarProducto(ProductoBean prdData) throws SQLException{
    boolean resultado=false;
        con = new Conexion();
        con.query="UPDATE producto SET id_fabricante="+prdData.getId_fabricante()+", producto_serie='"+prdData.getProducto_serie()+"',producto_nombre='"+prdData.getProducto_nombre()+"' WHERE producto_id="+prdData.getProducto_id()+"";
        resultado=con.setQuery(con.query);
        con.cerrarConexion();
    return resultado;
    }
    
    public boolean eliminarProducto(ProductoBean prdData) throws SQLException{
    boolean resultado=false;
        con = new Conexion();
        con.query="DELETE FROM producto WHERE producto_id"+prdData.getProducto_id();
        resultado=con.setQuery(con.query);
        con.cerrarConexion();
    
    return resultado;
    }
    
}
