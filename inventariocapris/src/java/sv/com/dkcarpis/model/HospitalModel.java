/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.dkcarpis.model;
import java.sql.SQLException;
import sv.com.dkcarpis.model.Conexion;
import sv.com.dkcapris.beans.HospitalBean;
/**
 *
 * @author Jose-PC
 */
public class HospitalModel {
        Conexion con;
    
    public boolean nuevoHospital(HospitalBean hospitalData) throws SQLException{
        boolean resultado=false;
        con  = new Conexion();
        con.query="INSERT INTO hospital(hospital_nombre, hospital_descripcion) VALUES ('"+hospitalData.getHospital_Nombre()+"','"+hospitalData.getHospital_Descripcion()+"')";
        resultado=con.setQuery(con.query);
        con.cerrarConexion();
        return resultado;
    }
    
    public boolean modificarHospital(HospitalBean hospitalData) throws SQLException{
        boolean resultado=false;
        con  = new Conexion();
         con.query="";
        con.setQuery(con.query);
        
        con.cerrarConexion();
        return resultado;
    }
        
    public boolean eliminarHospital(HospitalBean hospitalData) throws SQLException{
        boolean resultado=false;
        con  = new Conexion();
        con.query="delete from hospital where hospital_id="+hospitalData.getHospital_Id();
        con.setQuery(con.query);
        con.cerrarConexion();
        return resultado;
    }
    
    
    
}
