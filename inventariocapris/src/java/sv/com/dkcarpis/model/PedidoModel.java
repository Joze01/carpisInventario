/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.dkcarpis.model;

import java.sql.SQLException;
import java.util.ArrayList;
import sv.com.dkcapris.beans.PedidoBean;
import sv.com.dkcapris.beans.DetallePedidoBean;
/**
 *
 * @author Jose-PC
 */
public class PedidoModel {
    Conexion con;
    boolean resultado;
   
            
    
    public PedidoModel(){
    resultado=false;
    }
     
    public boolean newPedido(PedidoBean pedido) throws SQLException{
     resultado=false;
     con = new Conexion();
     con.query="INSERT INTO pedido(pedido_id, pedido_descripcion, pedido_fechaInicio, pedido_fechaFin) VALUES ()";
     resultado=con.setQuery(con.query);
     con.cerrarConexion();
    return resultado;
    }
    
    
    
    public boolean modificarPedido(PedidoBean pedido) throws SQLException{
     resultado=false;
     con = new Conexion();
     con.query="";
     resultado=con.setQuery(con.query);
     
     con.cerrarConexion();
    return resultado;
    }
        
        
    public boolean deletePedido(PedidoBean pedido) throws SQLException{
     resultado=false;
     con = new Conexion();
     con.query="";
     resultado=con.setQuery(con.query);
     
     con.cerrarConexion();
    return resultado;
    }
    
    
    public boolean setDetalle(ArrayList<DetallePedidoBean> listaDetalle) throws SQLException{
     resultado=false;
     con = new Conexion();
     for(DetallePedidoBean item : listaDetalle){
     con.query="INSERT INTO pedidodetalleproducto(id_producto, id_pedido) VALUES ('"+item.getId_producto()+"','"+item.getId_producto()+"')";
     resultado=con.setQuery(con.query);
     }
     con.cerrarConexion();
    return resultado;
    }
    
    public boolean deleteDetalle(DetallePedidoBean detalleData) throws SQLException{
     resultado=false;
     con = new Conexion();
     con.query="DELETE FROM pedidodetalleproducto WHERE detalle_id="+detalleData.getDetalle_id();
     resultado=con.setQuery(con.query);
     con.cerrarConexion();
    return resultado;
    }
    
    public boolean updateDetalle(DetallePedidoBean detalleData) throws SQLException{
     resultado=false;
     con = new Conexion();
     con.query="UPDATE pedidodetalleproducto SET id_producto="+detalleData.getId_producto()+",id_pedido="+detalleData.getId_pedido()+" WHERE detalle_id="+detalleData.getDetalle_id();
     resultado=con.setQuery(con.query);
     con.cerrarConexion();
    return resultado;
    }
}
