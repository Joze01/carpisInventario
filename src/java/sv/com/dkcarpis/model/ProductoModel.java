/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.dkcarpis.model;
import java.sql.SQLException;
import java.sql.*;
import java.util.ArrayList;
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
         con.query="INSERT INTO producto(id_fabricante, id_categoria, id_tipoproducto, producto_serie, producto_nombre) VALUES ("+prdData.getId_fabricante()+","+prdData.getId_categoria()+", "+prdData.getId_tipoproducto()+",'"+prdData.getProducto_serie()+"','"+prdData.getProducto_nombre()+"')";
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
        con.query="UPDATE producto SET id_fabricante="+prdData.getId_fabricante()+", id_categoria="+prdData.getId_categoria()+", id_tipoproducto="+prdData.getId_tipoproducto()+", producto_serie='"+prdData.getProducto_serie()+"',producto_nombre='"+prdData.getProducto_nombre()+"' WHERE producto_id="+prdData.getProducto_id()+"";
        resultado=con.setQuery(con.query);
        con.cerrarConexion();
    return resultado;
    }
    
   public ArrayList<ProductoBean> getTable() throws SQLException{
       ArrayList<ProductoBean> listado = new ArrayList<ProductoBean>();
        Conexion con = new  Conexion();
        con.query="SELECT * FROM producto" + 
                " INNER JOIN fabricante on fabricante.fabricante_id=producto.id_fabricante" +
                " INNER JOIN categoria on categoria.categoria_id=producto.id_categoria" +
                " INNER JOIN tipoproducto on tipoproducto.tipoproducto_id = producto.id_tipoproducto";
        con.setRs(con.query);
        rs = con.getRs();
        while(rs.next()){
            ProductoBean prd = new ProductoBean();
            
            
            prd.setProducto_id(rs.getInt("producto_id"));
            prd.setProducto_serie(rs.getString("producto_serie"));
            prd.setProducto_nombre(rs.getString("producto_nombre"));
            prd.setProducto_descripcion(rs.getString("producto_descripcion"));
            
            
            
            prd.setFabricante_Nombre(rs.getString("fabricante_nombre"));
            prd.setCategoria_Nombre("categoria_nombre");
            prd.setTipoproducto_nombre(rs.getString("tipoproducto_nombre"));
            
           
            
            listado.add(prd);
        
        }
       
       return listado;
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
