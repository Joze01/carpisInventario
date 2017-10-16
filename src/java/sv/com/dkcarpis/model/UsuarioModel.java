/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.dkcarpis.model;
import java.sql.SQLException;
import sv.com.dkcapris.beans.UsuarioBean;
/**
 *
 * @author Jose-PC
 */
public class UsuarioModel {
    Conexion con ;
    
    
    public boolean nuevoUsuario(UsuarioBean usrData) throws SQLException{
        boolean resultado=false;
            con =  new  Conexion();
            con.query="INSERT INTO usuario(id_tipo, usuario_nombre, usuario_user, usuario_password) "
                    + "VALUES "
                    + "("+usrData.getId_tipo()+","
                    + "'"+usrData.getUsuario_Nombre()+"',"
                    + "'"+usrData.getUsuario_user()+"',"
                    + "'"+usrData.getUsuario_password()+"')";
       
            resultado=con.setQuery(con.query);
            con.cerrarConexion();
            
            
            
        return resultado;
    }
    
    public boolean updateUsuario(UsuarioBean usrData) throws SQLException{
            boolean resultado=false;
            con =  new  Conexion();
            con.query="UPDATE usuario SET id_tipo="+usrData.getId_tipo()+",usuario_nombre='"+usrData.getUsuario_Nombre()+"',usuario_user='"+usrData.getUsuario_user()+"',usuario_password='"+usrData.getUsuario_password()+"' WHERE usuario_id="+usrData.getUsuario_id()+"";     
            resultado=con.setQuery(con.query);
            con.cerrarConexion();
        return resultado;
        
    }
    
    public boolean deleteUsuario(UsuarioBean usrData) throws SQLException{
      boolean resultado=false;
            con =  new  Conexion();
            con.query="delete from usuario WHERE usuario_id="+usrData.getUsuario_id()+"";     
            resultado=con.setQuery(con.query);
            con.cerrarConexion();
        return resultado;
    }
    
    
}
