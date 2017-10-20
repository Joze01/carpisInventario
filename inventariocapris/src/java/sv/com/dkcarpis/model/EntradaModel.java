/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.dkcarpis.model;
import java.sql.ResultSet;
import java.sql.SQLData;
import java.sql.SQLException;
import java.util.ArrayList;
import sv.com.dkcapris.beans.EntradaBean;
import sv.com.dkcapris.beans.ProductoBean;
import sv.com.dkcapris.beans.EntradaBean;

/**
 *
 * @author Jose-PC
 */
public class EntradaModel {
    Conexion con;
    ImageModel imgModel = new ImageModel();
    ResultSet rs;
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
    
    
          public ArrayList<EntradaBean> getAllTable() throws SQLException{
       ArrayList<EntradaBean> listado = new ArrayList<EntradaBean>();
        Conexion con = new  Conexion();
        con.query="SELECT * FROM entrada "
                + "INNER JOIN producto on producto.producto_id=entrada.id_producto "
                + "INNER JOIN fabricante on fabricante.fabricante_id=producto.id_fabricante  "
                + "INNER JOIN categoria on categoria.categoria_id=producto.id_categoria "
                + "INNER JOIN tipoproducto on tipoproducto.tipoproducto_id = producto.id_tipoproducto";
        con.setRs(con.query);
        rs = con.getRs();
        while(rs.next()){
            EntradaBean entr = new EntradaBean();
            entr.setId(rs.getInt("entrada_id"));
            entr.setEntrada_cantidad(rs.getInt("entrada_cantidad"));
            entr.setEntrada_precio(rs.getFloat("entrada_precio"));
            entr.setEntrada_fecha(rs.getDate("entrada_fecha"));
            
          
                        
            entr.setProducto_nombre(rs.getString("producto_nombre"));
            entr.setProducto_fabricante(rs.getString("fabricante_nombre"));
            entr.setProducto_categoria(rs.getString("categoria_nombre"));
            entr.setProducto_tipo(rs.getString("tipoproducto_nombre"));
            entr.setProducto_serie(rs.getString("producto_serie"));
           
            
            listado.add(entr);
        
        }
       
       return listado;
   }
   
   
   
    
    
    
}
