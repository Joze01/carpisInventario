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
public class CategoriaBean {

    /**
     * @return the categoria_id
     */
    public int getCategoria_id() {
        return categoria_id;
    }

    /**
     * @param categoria_id the categoria_id to set
     */
    public void setCategoria_id(int categoria_id) {
        this.categoria_id = categoria_id;
    }

    /**
     * @return the categoria_nombre
     */
    public String getCategoria_nombre() {
        return categoria_nombre;
    }

    /**
     * @param categoria_nombre the categoria_nombre to set
     */
    public void setCategoria_nombre(String categoria_nombre) {
        this.categoria_nombre = categoria_nombre;
    }

    /**
     * @return the categoria_descripcion
     */
    public String getCategoria_descripcion() {
        return categoria_descripcion;
    }

    /**
     * @param categoria_descripcion the categoria_descripcion to set
     */
    public void setCategoria_descripcion(String categoria_descripcion) {
        this.categoria_descripcion = categoria_descripcion;
    }
    private int categoria_id;
    private String categoria_nombre;
    private String categoria_descripcion;
}
