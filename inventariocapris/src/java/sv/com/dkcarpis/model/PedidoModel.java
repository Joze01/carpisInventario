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
//     String[] output = pedido.getPedido_fechaInicio().split("-");
//     String fechaIni = output[2]+"-"+output[1]+"-"+output[0];
     
     String[] output2 = pedido.getPedido_fechaFinal().split("-");
     String fechaFinal = output2[2]+"-"+output2[1]+"-"+output2[0];
     con.query="INSERT INTO pedido(pedido_id, pedido_descripcion, pedido_fechaInicio, pedido_fechaFin) VALUES ("+pedido.getPedido_id()+",'"+pedido.getPedido_descripcion()+"',CURRENT_DATE(),"+fechaFinal+")";
     resultado=con.setQuery(con.query);
     con.cerrarConexion();
    return resultado;
    }
    
    
    
    public boolean modificarPedido(PedidoBean pedido) throws SQLException{
     resultado=false;
     con = new Conexion();
     con.query="UPDATE pedido SET pedido_descripcion='"+pedido.getPedido_descripcion()+"',pedido_fechaInicio="+pedido.getPedido_fechaInicio()+",pedido_fechaFin="+pedido.getPedido_fechaFinal()+" WHERE pedido_id="+pedido.getPedido_id();
     resultado=con.setQuery(con.query);
     
     con.cerrarConexion();
    return resultado;
    }
        
        
    public boolean deletePedido(PedidoBean pedido) throws SQLException{
     resultado=false;
     con = new Conexion();
     con.query="DELETE FROM `pedido` WHERE pedido_id="+pedido.getPedido_id();
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
