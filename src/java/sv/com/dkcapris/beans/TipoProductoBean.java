/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.dkcapris.beans;

/**
 *
 * @author Jose-PC
 */
public class TipoProductoBean {

    /**
     * @return the tipoProducto_id
     */
    public int getTipoProducto_id() {
        return tipoProducto_id;
    }

    /**
     * @param tipoProducto_id the tipoProducto_id to set
     */
    public void setTipoProducto_id(int tipoProducto_id) {
        this.tipoProducto_id = tipoProducto_id;
    }

    /**
     * @return the tipoProducto_nombre
     */
    public String getTipoProducto_nombre() {
        return tipoProducto_nombre;
    }

    /**
     * @param tipoProducto_nombre the tipoProducto_nombre to set
     */
    public void setTipoProducto_nombre(String tipoProducto_nombre) {
        this.tipoProducto_nombre = tipoProducto_nombre;
    }

    /**
     * @return the tipoProducto_descripcion
     */
    public String getTipoProducto_descripcion() {
        return tipoProducto_descripcion;
    }

    /**
     * @param tipoProducto_descripcion the tipoProducto_descripcion to set
     */
    public void setTipoProducto_descripcion(String tipoProducto_descripcion) {
        this.tipoProducto_descripcion = tipoProducto_descripcion;
    }
    private int tipoProducto_id;
    private String tipoProducto_nombre;
    private String tipoProducto_descripcion;
}
