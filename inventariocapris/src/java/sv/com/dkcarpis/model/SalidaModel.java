/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.dkcarpis.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import sv.com.dkcapris.beans.EntradaBean;
import sv.com.dkcapris.beans.SalidaBean;
import sv.com.dkcarpis.model.EntradaModel;
/**
 *
 * @author Jose-PC
 */
public class SalidaModel {
        Conexion con;
        int contador=0;
        int contador2=0;
    ResultSet rs;
    public boolean nuevaSalida(SalidaBean exitData) throws SQLException{
     boolean resultado =false;
        Integer cantidadEntradas=0;
        Integer cantidadSalidas=0;
        Integer resto=0;
        EntradaModel entdModel = new EntradaModel();
        ArrayList<SalidaBean> listaSalidas = this.getAllSalidasbyProducto(exitData.getId_producto()); //obtener lista de salidas
        ArrayList<EntradaBean> listaEntradas = entdModel.getAllEntradasByProducto(exitData.getId_producto()); //obtener lista de entradas
        
        for(SalidaBean salida: listaSalidas){ //contar salidas
                cantidadSalidas+=salida.getSalidad_cantidad();  
        }       
        for(EntradaBean entrada: listaEntradas){         //contar entradas
            cantidadEntradas+=entrada.getEntrada_cantidad();
        }
        
        resto = cantidadEntradas-cantidadSalidas;
        if(resto>=exitData.getSalidad_cantidad()){// Comprobar si hay Existencias Suficientes
            System.out.println("TOTAL Existencia suficiente: " + resto);
            Integer acumuladorEntradas = 0;
             boolean salidaCompleta=false;
             Integer diponiblesByEntrada=0;
             System.out.println("NECESITO SACAR: "+exitData.getSalidad_cantidad());
             for(EntradaBean ntr : listaEntradas){
               acumuladorEntradas+=ntr.getEntrada_cantidad();
               diponiblesByEntrada=acumuladorEntradas-cantidadSalidas;
               if(diponiblesByEntrada>0){
                   
                   
                   if(diponiblesByEntrada>=exitData.getSalidad_cantidad() && exitData.getSalidad_cantidad()>0){
                   System.out.println("Con esta entrada alcanza");
                   System.out.println("Puedo sacar: "+diponiblesByEntrada+" A precio: "+ntr.getEntrada_precio());
                   System.out.println("Sacando... "+exitData.getSalidad_cantidad()+" a precio de: "+ntr.getEntrada_precio());
                   con = new Conexion();
                   con.query="INSERT INTO salida (id_usuario, id_producto, salida_cantidad, salida_precio, salida_fecha) VALUES ("+exitData.getId_usuario()+","+exitData.getId_producto()+","+exitData.getSalidad_cantidad()+","+ntr.getEntrada_precio()+",CURRENT_DATE())";
                   con.setQuery(con.query);
                   con.cerrarConexion();
                   exitData.setSalidad_cantidad(exitData.getSalidad_cantidad()-diponiblesByEntrada);
                   }else if(diponiblesByEntrada<exitData.getSalidad_cantidad() && exitData.getSalidad_cantidad()>0){
                         System.out.println("No alcanza con una entrada"); 
                         System.out.println("Puedo sacar: "+diponiblesByEntrada+" A precio: "+ntr.getEntrada_precio());
                         System.out.println("Sacando... "+diponiblesByEntrada+" a precio de: "+ntr.getEntrada_precio());
                         con = new Conexion();
                         con.query="INSERT INTO salida (id_usuario, id_producto, salida_cantidad, salida_precio, salida_fecha) VALUES ("+exitData.getId_usuario()+","+exitData.getId_producto()+","+diponiblesByEntrada+","+ntr.getEntrada_precio()+",CURRENT_DATE())";
                         con.setQuery(con.query);
                         con.cerrarConexion();
                         exitData.setSalidad_cantidad(exitData.getSalidad_cantidad()-diponiblesByEntrada);
                   }                  
               }else{
                   System.out.println("Entradas agotadas");
               }
             }
        }else{ //end if cuando si hay existencias
           
              System.out.println("NO HAY Existencia suficiente");
              resultado=false;
        }//end if cuando hay no hay existencias
        
     return resultado;
    }
    
    
    
    
    public boolean modificarEntrada(SalidaBean exitData) throws SQLException{
     boolean resultado =false;
     con = new Conexion();
     con.query="UPDATE salida SET id_usuario="+exitData.getId_usuario()+", id_producto="+exitData.getId_producto()+", salida_cantidad="+exitData.getSalidad_cantidad()+",salida_precio="+exitData.getSalida_precio()+",salida_fecha="+exitData.getSalida_fecha()+" WHERE salida_id="+exitData.getId();
     resultado=con.setQuery(con.query);
     con.cerrarConexion();
     return resultado;
    }
        
        
        
    public boolean EliminarSalida(SalidaBean exitData) throws SQLException{
     boolean resultado =false;
     con = new Conexion();
     con.query="delete from salida where salida_int="+exitData.getId();
     resultado=con.setQuery(con.query);
     con.cerrarConexion();
     return resultado;
    }
    
    public ArrayList<SalidaBean> getAllSalidasbyProducto(int idProducto) throws SQLException{
        ArrayList<SalidaBean> listadoSalidas = new ArrayList<SalidaBean>();
        con = new Conexion();
        con.query="select * from salida where id_producto="+idProducto;
        con.setRs(con.query);
        rs=con.getRs();
        while(rs.next()){
            SalidaBean nuevasalida = new SalidaBean();
            nuevasalida.setId(rs.getInt(1));
            nuevasalida.setId_usuario(rs.getInt(2));
            nuevasalida.setId_producto(rs.getInt(3));
            nuevasalida.setSalidad_cantidad(rs.getInt(4));
            nuevasalida.setSalida_precio(rs.getFloat(5));
            nuevasalida.setSalida_fecha(rs.getDate(6).toString());
            listadoSalidas.add(nuevasalida);
        }
        return listadoSalidas;
    }
        
          public ArrayList<SalidaBean> getAllTableByUser(Integer user) throws SQLException{
       ArrayList<SalidaBean> listado = new ArrayList<SalidaBean>();
        Conexion con = new  Conexion();
        con.query="SELECT * FROM salida "
                + "INNER JOIN producto on producto.producto_id=salida.id_producto "
                + "INNER JOIN fabricante on fabricante.fabricante_id=producto.id_fabricante  "
                + "INNER JOIN categoria on categoria.categoria_id=producto.id_categoria "
                + "INNER JOIN tipoproducto on tipoproducto.tipoproducto_id = producto.id_tipoproducto "
                + "WHERE  id_usuario="+user;
        con.setRs(con.query);
        rs = con.getRs();
        while(rs.next()){
            SalidaBean exts = new SalidaBean();
            exts.setId(rs.getInt("salida_int"));
            exts.setSalidad_cantidad(rs.getInt("salida_cantidad"));
            exts.setSalida_precio(rs.getFloat("salida_precio"));
            exts.setSalida_fecha(rs.getString("salida_fecha"));
            
          
                        
            exts.setProducto_nombre(rs.getString("producto_nombre"));
            exts.setProducto_fabricante(rs.getString("fabricante_nombre"));
            exts.setProducto_categoria(rs.getString("categoria_nombre"));
            exts.setProducto_tipo(rs.getString("tipoproducto_nombre"));
            exts.setProducto_serie(rs.getString("producto_serie"));
           
            
            listado.add(exts);
        
        }
       
       return listado;
   }
    
      public ArrayList<SalidaBean> getAllTable() throws SQLException{
       ArrayList<SalidaBean> listado = new ArrayList<SalidaBean>();
        Conexion con = new  Conexion();
        con.query="SELECT * FROM salida "
                + "INNER JOIN producto on producto.producto_id=salida.id_producto "
                + "INNER JOIN fabricante on fabricante.fabricante_id=producto.id_fabricante  "
                + "INNER JOIN categoria on categoria.categoria_id=producto.id_categoria "
                + "INNER JOIN tipoproducto on tipoproducto.tipoproducto_id = producto.id_tipoproducto";
        con.setRs(con.query);
        rs = con.getRs();
        while(rs.next()){
            SalidaBean exts = new SalidaBean();
            exts.setId(rs.getInt("salida_int"));
            exts.setSalidad_cantidad(rs.getInt("salida_cantidad"));
            exts.setSalida_precio(rs.getFloat("salida_precio"));
            exts.setSalida_fecha(rs.getString("salida_fecha"));
            
          
                        
            exts.setProducto_nombre(rs.getString("producto_nombre"));
            exts.setProducto_fabricante(rs.getString("fabricante_nombre"));
            exts.setProducto_categoria(rs.getString("categoria_nombre"));
            exts.setProducto_tipo(rs.getString("tipoproducto_nombre"));
            exts.setProducto_serie(rs.getString("producto_serie"));
           
            
            listado.add(exts);
        
        }
       
       return listado;
   }
}
