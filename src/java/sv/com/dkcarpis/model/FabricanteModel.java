/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.dkcarpis.model;
import java.sql.SQLException;
import sv.com.dkcapris.beans.FabricanteBean;
/**
 *
 * @author Jose-PC
 */
public class FabricanteModel {
    Conexion con;
    
    
    public boolean nuevoFabricante(FabricanteBean fbrData) throws SQLException{
        boolean resultado=false;
        con = new Conexion();
        con.query="INSERT INTO fabricante (fabricante_nombre, fabricante_descripcion) VALUES ('"+fbrData.getFabricante_nombre()+"','"+fbrData.getFabricante_descripcion()+"')";
        resultado= con.setQuery(con.query);
        return resultado;
    }
    
    public boolean modificarFabricante(FabricanteBean fbrData) throws SQLException{
        boolean resultado=false;
        con = new Conexion();
        con.query="UPDATE fabricante SET fabricante_nombre='"+fbrData.getFabricante_nombre()+"', fabricante_descripcion='"+fbrData.getFabricante_descripcion()+"' WHERE fabricante_id="+fbrData.getFabricante_id();
        resultado= con.setQuery(con.query);
        return resultado;
    }
        
        
    public boolean eliminarFabricante(FabricanteBean fbrData) throws SQLException{
        boolean resultado=false;
        con = new Conexion();
        con.query="DELETE FROM fabricante WHERE fabricante_id="+fbrData.getFabricante_id();
         resultado= con.setQuery(con.query);
        return resultado;
    }
}
