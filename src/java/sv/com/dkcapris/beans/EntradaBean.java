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
public class EntradaBean {

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

    /**
     * @return the entrada_fecha
     */
    public SQLData getEntrada_fecha() {
        return entrada_fecha;
    }

    /**
     * @param entrada_fecha the entrada_fecha to set
     */
    public void setEntrada_fecha(SQLData entrada_fecha) {
        this.entrada_fecha = entrada_fecha;
    }

    
    private int id;
    private int id_usuario;
    private int id_producto;
    private int entrada_cantidad;
    private float entrada_precio;
    private SQLData entrada_fecha; 
}
