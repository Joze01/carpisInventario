/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.dkcarpis.model;
import java.security.interfaces.RSAKey;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.apache.jasper.tagplugins.jstl.core.ForEach;
import sv.com.dkcapris.beans.ImageBean;
import sv.com.dkcapris.beans.ProductoBean;
import sv.com.dkcarpis.model.Conexion;
/**
 *
 * @author Jose-PC
 */
public class ImageModel {
    Conexion con;
    public boolean nuevaImagen(ArrayList<ImageBean>listado, int id_producto) throws SQLException{
    boolean resultado=false;
        System.out.println("EN NUEVA IMAGEN");
       for(ImageBean img : listado){
            con=new Conexion();
            con.query="INSERT INTO imagen(id_producto, imagen_url) VALUES ("+id_producto+",'"+img.getImage_url()+"')";
            resultado=con.setQuery(con.query);
            con.cerrarConexion();
       }
    return resultado;
    }
    
    public String getOneUrl(Integer id) throws SQLException{
        String direccion="";
        con = new Conexion();
        con.query="select * from imagen where id_producto="+id+" limit 1";
        ResultSet rs;
        con.setRs(con.query);
        rs=con.getRs();
        
        while(rs.next()){
        direccion=rs.getString("imagen_url");
            System.out.println(rs.getString("imagen_url"));
        }
        con.cerrarConexion();
        return direccion;
    }
    
    public boolean elimarImagenProducto(ImageBean imgData) throws SQLException{
    boolean resultado=false;
    con = new Conexion();
    con.query="DELETE FROM imagen WHERE imagen_id="+imgData.getId();
    resultado=con.setQuery(con.query);
    
    return resultado;
    }
    
    
    
}
