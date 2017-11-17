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
public class AreaBean {

    /**
     * @return the area_id
     */
    public int getArea_id() {
        return area_id;
    }

    /**
     * @param area_id the area_id to set
     */
    public void setArea_id(int area_id) {
        this.area_id = area_id;
    }

    /**
     * @return the area_nombre
     */
    public String getArea_nombre() {
        return area_nombre;
    }

    /**
     * @param area_nombre the area_nombre to set
     */
    public void setArea_nombre(String area_nombre) {
        this.area_nombre = area_nombre;
    }

    /**
     * @return the area_descripcion
     */
    public String getArea_descripcion() {
        return area_descripcion;
    }

    /**
     * @param area_descripcion the area_descripcion to set
     */
    public void setArea_descripcion(String area_descripcion) {
        this.area_descripcion = area_descripcion;
    }
    private int area_id;
    private String area_nombre; 
    private String area_descripcion;
    
}
