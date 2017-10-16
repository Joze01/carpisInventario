/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.dkcapris.beans;

import java.sql.SQLData;

/**
 *
 * @author Jose-PC
 */
public class SalidaBean {

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
     * @return the salidad_cantidad
     */
    public int getSalidad_cantidad() {
        return salidad_cantidad;
    }

    /**
     * @param salidad_cantidad the salidad_cantidad to set
     */
    public void setSalidad_cantidad(int salidad_cantidad) {
        this.salidad_cantidad = salidad_cantidad;
    }

    /**
     * @return the salida_precio
     */
    public float getSalida_precio() {
        return salida_precio;
    }

    /**
     * @param salida_precio the salida_precio to set
     */
    public void setSalida_precio(float salida_precio) {
        this.salida_precio = salida_precio;
    }

    /**
     * @return the fecha
     */
    public SQLData getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(SQLData fecha) {
        this.fecha = fecha;
    }
    private int id;
    private int id_usuario;
    private int id_producto;
    private int salidad_cantidad;
    private float salida_precio;
    private SQLData fecha; 
}
