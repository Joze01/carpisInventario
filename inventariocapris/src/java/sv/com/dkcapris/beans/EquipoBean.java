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
public class EquipoBean {

    /**
     * @return the equipo_id
     */
    public Integer getEquipo_id() {
        return equipo_id;
    }

    /**
     * @param equipo_id the equipo_id to set
     */
    public void setEquipo_id(Integer equipo_id) {
        this.equipo_id = equipo_id;
    }

    /**
     * @return the id_hospital
     */
    public Integer getId_hospital() {
        return id_hospital;
    }

    /**
     * @param id_hospital the id_hospital to set
     */
    public void setId_hospital(Integer id_hospital) {
        this.id_hospital = id_hospital;
    }

    /**
     * @return the hospital_name
     */
    public String getHospital_name() {
        return hospital_name;
    }

    /**
     * @param hospital_name the hospital_name to set
     */
    public void setHospital_name(String hospital_name) {
        this.hospital_name = hospital_name;
    }

    /**
     * @return the id_area
     */
    public Integer getId_area() {
        return id_area;
    }

    /**
     * @param id_area the id_area to set
     */
    public void setId_area(Integer id_area) {
        this.id_area = id_area;
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
     * @return the id_marca
     */
    public Integer getId_marca() {
        return id_marca;
    }

    /**
     * @param id_marca the id_marca to set
     */
    public void setId_marca(Integer id_marca) {
        this.id_marca = id_marca;
    }

    /**
     * @return the marca_name
     */
    public String getMarca_name() {
        return marca_name;
    }

    /**
     * @param marca_name the marca_name to set
     */
    public void setMarca_name(String marca_name) {
        this.marca_name = marca_name;
    }

    /**
     * @return the equipo_serie
     */
    public String getEquipo_serie() {
        return equipo_serie;
    }

    /**
     * @param equipo_serie the equipo_serie to set
     */
    public void setEquipo_serie(String equipo_serie) {
        this.equipo_serie = equipo_serie;
    }

    /**
     * @return the equipo_modelo
     */
    public String getEquipo_modelo() {
        return equipo_modelo;
    }

    /**
     * @param equipo_modelo the equipo_modelo to set
     */
    public void setEquipo_modelo(String equipo_modelo) {
        this.equipo_modelo = equipo_modelo;
    }

    /**
     * @return the equipo_descripcion
     */
    public String getEquipo_descripcion() {
        return equipo_descripcion;
    }

    /**
     * @param equipo_descripcion the equipo_descripcion to set
     */
    public void setEquipo_descripcion(String equipo_descripcion) {
        this.equipo_descripcion = equipo_descripcion;
    }

    /**
     * @return the equipo_nInventario
     */
    public String getEquipo_nInventario() {
        return equipo_nombre;
    }

    /**
     * @param equipo_nInventario the equipo_nInventario to set
     */
    public void setEquipo_nInventario(String equipo_nInventario) {
        this.equipo_nombre = equipo_nInventario;
    }

    /**
     * @return the equipo_estado
     */
    public Integer getEquipo_estado() {
        return equipo_estado;
    }

    /**
     * @param equipo_estado the equipo_estado to set
     */
    public void setEquipo_estado(Integer equipo_estado) {
        this.equipo_estado = equipo_estado;
    }
    
    private Integer historialChange;
    private Integer equipo_id;
    private Integer id_hospital;
    private String hospital_name;
    private Integer id_area;
    private String area_nombre;
    private Integer id_marca;
    private String marca_name;
    private String equipo_serie;
    private String equipo_modelo;
    private String equipo_descripcion;
    private String equipo_nombre;
    private Integer equipo_estado;

    /**
     * @return the historialChange
     */
    public Integer getHistorialChange() {
        return historialChange;
    }

    /**
     * @param historialChange the historialChange to set
     */
    public void setHistorialChange(Integer historialChange) {
        this.historialChange = historialChange;
    }
}
