/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.dkcarpis.model;
import java.sql.ResultSet;
import java.sql.SQLException;
import sv.com.dkcapris.beans.UsuarioBean;
/**
 *
 * @author Jose-PC
 */
public class UsuarioModel {
    Conexion con ;
    ResultSet rs;
    
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
    
        public boolean changePass(UsuarioBean usrData) throws SQLException{
            boolean resultado=false;
            con =  new  Conexion();
            con.query="UPDATE usuario SET usuario_password='"+usrData.getUsuario_password()+"' WHERE usuario_id="+usrData.getUsuario_id()+"";     
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
    
    
    public UsuarioBean login(UsuarioBean usrData) throws SQLException{
        UsuarioBean usrResultado = new UsuarioBean();
        con = new Conexion();
        con.query="select count(*) as contador, usuario.* from usuario where usuario_user='"+usrData.getUsuario_user()+"' and usuario_password='"+usrData.getUsuario_password()+"'";
        con.setRs(con.query);
        rs=con.getRs();
        while(rs.next()){
         if(rs.getInt("contador")==1){
          usrResultado.setUsuario_id(rs.getInt("usuario_id"));
          usrResultado.setId_tipo(rs.getInt("id_tipo"));
          usrResultado.setUsuario_Nombre(rs.getString("usuario_nombre"));
          usrResultado.setUsuario_user(rs.getString("usuario_user"));
          usrResultado.setUsuario_password(rs.getString("usuario_password"));
          usrResultado.setLoggeado(true);
         }else{
         usrResultado.setLoggeado(false);
         }
        }
        return usrResultado;
    }
    
}
