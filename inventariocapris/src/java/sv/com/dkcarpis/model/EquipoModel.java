/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.dkcarpis.model;

import java.sql.SQLException;
import sv.com.dkcapris.beans.EquipoBean;

/**
 *
 * @author Jose-PC
 */
public class EquipoModel {
     Conexion con;
    public boolean nuevoEquipo(EquipoBean frmData) throws SQLException{
        boolean resultado=false;
        con = new Conexion();
        con.query="INSERT INTO equipo( id_marca, equipo_serie, equipo_modelo, equipo_descripcion, equipo_nombre, equipo_estado) "
                + "VALUES ("+frmData.getId_marca()+",'"+frmData.getEquipo_serie()+"','"+frmData.getEquipo_modelo()+"','"+frmData.getEquipo_descripcion()+"','"+frmData.getEquipo_nInventario()+"',"+frmData.getEquipo_estado()+")";
        
        
        
        resultado= con.setQuery(con.query);
        con.cerrarConexion();
        return resultado;
    }
    
    public boolean modificarEquipo(EquipoBean frmData) throws SQLException{
        boolean resultado=false;
        con = new Conexion();
        con.query="UPDATE equipo SET equipo_estado="+frmData.getEquipo_estado()+",  id_area="+frmData.getId_area()+",id_marca="+frmData.getId_marca()+",equipo_serie='"+frmData.getEquipo_serie()+"',equipo_modelo='"+frmData.getEquipo_modelo()+"',equipo_descripcion='"+frmData.getEquipo_descripcion()+"',equipo_ninventario='"+frmData.getEquipo_nInventario()+"' WHERE equipo_id="+frmData.getEquipo_id();
        resultado= con.setQuery(con.query);
         con.cerrarConexion();
        return resultado;
    }
        
        
    public boolean eliminarEquipo(EquipoBean frmData) throws SQLException{
        boolean resultado=false;
        con = new Conexion();
        con.query="DELETE FROM equipo WHERE equipo_id="+frmData.getEquipo_id()+"";
         resultado= con.setQuery(con.query);
          con.cerrarConexion();
        return resultado;
    }
    
    
    
   public boolean asignarEquipo(EquipoBean frmData) throws SQLException{
        boolean resultado=false;
        con = new Conexion();
        con.query="INSERT INTO historial_equipo(id_equipo, id_hospital, id_area, historial_fecha, historial_tipo) "
                + "VALUES ("+frmData.getEquipo_id()+", "+frmData.getId_hospital()+","+frmData.getId_area()+", CURRENT_DATE(), "+frmData.getHistorialChange()+")";
         resultado= con.setQuery(con.query);
          con.cerrarConexion();
        return resultado;
    }
   
      public boolean eliminarAsignacion(EquipoBean frmData) throws SQLException{
        boolean resultado=false;
        con = new Conexion();
        con.query="DELETE FROM historial_equipo WHERE historial_id="+frmData.getEquipo_id();
        resultado= con.setQuery(con.query);
        con.cerrarConexion();
        return resultado;
    } 

}
