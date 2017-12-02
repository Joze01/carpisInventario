/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.dkcarpis.model;

import java.sql.ResultSet;
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
    ResultSet rs;
            
    
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
     con.query="INSERT INTO pedido(pedido_descripcion, pedido_fechaInicio, pedido_fechaFin) VALUES ('"+pedido.getPedido_descripcion()+"',CURRENT_DATE(),'"+fechaFinal+"')";
     System.out.println(con.query);
     resultado=con.setQuery(con.query);
     con.cerrarConexion();

     
    return resultado;
    }
    
    public Integer getLastPedido() throws SQLException{
        con = new Conexion();
        con.query="SELECT * FROM pedido ORDER BY pedido_id desc limit 1 ";
        con.setRs(con.query);
        rs=con.getRs();
        int id=0;
        while(rs.next()){
           id=rs.getInt(1);
        }
    return id;
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
     con.query="DELETE FROM pedido WHERE pedido_id="+pedido.getPedido_id();
     resultado=con.setQuery(con.query);
     
     con.cerrarConexion();
    return resultado;
    }
    
    
    public boolean setDetalle(DetallePedidoBean detalleData) throws SQLException{
     resultado=false;
     con = new Conexion();
     
     /*con.query="select count(*) from pedidodetalleproducto where id_producto="+detalleData.getId_producto()+" and id_pedido="+detalleData.getId_pedido();
     con.setRs(con.query);
     rs=con.getRs();
     int ingresado=0;
     while(rs.next()){
     ingresado = rs.getInt(1);
     }
     
     if(ingreso==1){
     
     }
     */
     
     con.query="INSERT INTO pedidodetalleproducto(id_producto, id_pedido, cantidad) VALUES ("+detalleData.getId_producto()+","+detalleData.getId_pedido()+","+detalleData.getCantidad()+")";
     System.out.println(con.query);
     resultado=con.setQuery(con.query);


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
