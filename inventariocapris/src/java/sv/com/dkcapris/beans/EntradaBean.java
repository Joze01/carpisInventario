/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.dkcapris.beans;

import java.util.Date;




/**
 *
 * @author Jose-PC
 */
public class EntradaBean {

    /**
     * @return the entrada_fecha
     */
    public String getEntrada_fecha() {
        return entrada_fecha;
    }

    /**
     * @param entrada_fecha the entrada_fecha to set
     */
    public void setEntrada_fecha(String entrada_fecha) {
        this.entrada_fecha = entrada_fecha;
    }

 

    /**
     * @return the producto_serie
     */
    public String getProducto_serie() {
        return producto_serie;
    }

    /**
     * @param producto_serie the producto_serie to set
     */
    public void setProducto_serie(String producto_serie) {
        this.producto_serie = producto_serie;
    }

    /**
     * @return the producto_nombre
     */
    public String getProducto_nombre() {
        return producto_nombre;
    }

    /**
     * @param producto_nombre the producto_nombre to set
     */
    public void setProducto_nombre(String producto_nombre) {
        this.producto_nombre = producto_nombre;
    }

    /**
     * @return the producto_tipo
     */
    public String getProducto_tipo() {
        return producto_tipo;
    }

    /**
     * @param producto_tipo the producto_tipo to set
     */
    public void setProducto_tipo(String producto_tipo) {
        this.producto_tipo = producto_tipo;
    }

    /**
     * @return the producto_categoria
     */
    public String getProducto_categoria() {
        return producto_categoria;
    }

    /**
     * @param producto_categoria the producto_categoria to set
     */
    public void setProducto_categoria(String producto_categoria) {
        this.producto_categoria = producto_categoria;
    }

    /**
     * @return the producto_fabricante
     */
    public String getProducto_fabricante() {
        return producto_fabricante;
    }

    /**
     * @param producto_fabricante the producto_fabricante to set
     */
    public void setProducto_fabricante(String producto_fabricante) {
        this.producto_fabricante = producto_fabricante;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the id_usuario
     */
    public int getId_usuario() {
        return id_usuario;
    }

    /**
     * @param id_usuario the id_usuario to set
     */
    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    /**
     * @return the id_producto
     */
    public int getId_producto() {
        return id_producto;
    }

    /**
     * @param id_producto the id_producto to set
     */
    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    /**
     * @return the entrada_cantidad
     */
    public int getEntrada_cantidad() {
        return entrada_cantidad;
    }

    /**
     * @param entrada_cantidad the entrada_cantidad to set
     */
    public void setEntrada_cantidad(int entrada_cantidad) {
        this.entrada_cantidad = entrada_cantidad;
    }

    /**
     * @return the entrada_precio
     */
    public float getEntrada_precio() {
        return entrada_precio;
    }

    /**
     * @param entrada_precio the entrada_precio to set
     */
    public void setEntrada_precio(float entrada_precio) {
        this.entrada_precio = entrada_precio;
    }


 
    
    private int id;
    private int id_usuario;
    private int id_producto;
    private int entrada_cantidad;
    private float entrada_precio;
    
    
    private String producto_nombre;
    private String producto_tipo;
    private String producto_categoria;
    private String producto_fabricante;
    private String producto_serie;
    
    private String entrada_fecha; 
}
