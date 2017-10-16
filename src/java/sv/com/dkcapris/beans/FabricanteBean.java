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
public class FabricanteBean {

    /**
     * @return the fabricante_id
     */
    public int getFabricante_id() {
        return fabricante_id;
    }

    /**
     * @param fabricante_id the fabricante_id to set
     */
    public void setFabricante_id(int fabricante_id) {
        this.fabricante_id = fabricante_id;
    }

    /**
     * @return the fabricante_nombre
     */
    public String getFabricante_nombre() {
        return fabricante_nombre;
    }

    /**
     * @param fabricante_nombre the fabricante_nombre to set
     */
    public void setFabricante_nombre(String fabricante_nombre) {
        this.fabricante_nombre = fabricante_nombre;
    }

    /**
     * @return the fabricante_descripcion
     */
    public String getFabricante_descripcion() {
        return fabricante_descripcion;
    }

    /**
     * @param fabricante_descripcion the fabricante_descripcion to set
     */
    public void setFabricante_descripcion(String fabricante_descripcion) {
        this.fabricante_descripcion = fabricante_descripcion;
    }
    private int fabricante_id;
    private String fabricante_nombre;
    private String fabricante_descripcion;
    
}
