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
        con.query="INSERT INTO equipo(id_area, id_marca, equipo_serie, equipo_modelo, equipo_descripcion, equipo_ninventario) "
                + "VALUES ("+frmData.getId_area()+","+frmData.getId_marca()+",'"+frmData.getEquipo_serie()+"','"+frmData.getEquipo_modelo()+"','"+frmData.getEquipo_descripcion()+"','"+frmData.getEquipo_nInventario()+"')";
        
        
        resultado= con.setQuery(con.query);
        con.cerrarConexion();
        return resultado;
    }
    
    public boolean modificarEquipo(EquipoBean frmData) throws SQLException{
        boolean resultado=false;
        con = new Conexion();
        con.query="UPDATE `equipo` SET `equipo_id`=[value-1],`id_area`=[value-2],`id_marca`=[value-3],`equipo_serie`=[value-4],`equipo_modelo`=[value-5],`equipo_descripcion`=[value-6],`equipo_ninventario`=[value-7] WHERE 1";
        resultado= con.setQuery(con.query);
         con.cerrarConexion();
        return resultado;
    }
        
        
    public boolean eliminarEquipo(EquipoBean frmData) throws SQLException{
        boolean resultado=false;
        con = new Conexion();
        con.query="DELETE FROM `equipo` WHERE 0";
         resultado= con.setQuery(con.query);
          con.cerrarConexion();
        return resultado;
    }
}
