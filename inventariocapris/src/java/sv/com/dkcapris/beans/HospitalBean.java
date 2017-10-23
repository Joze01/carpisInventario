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
public class HospitalBean {

    /**
     * @return the hospital_Id
     */
    public Integer getHospital_Id() {
        return hospital_Id;
    }

    /**
     * @param hospital_Id the hospital_Id to set
     */
    public void setHospital_Id(Integer hospital_Id) {
        this.hospital_Id = hospital_Id;
    }

    /**
     * @return the hospital_Nombre
     */
    public String getHospital_Nombre() {
        return hospital_Nombre;
    }

    /**
     * @param hospital_Nombre the hospital_Nombre to set
     */
    public void setHospital_Nombre(String hospital_Nombre) {
        this.hospital_Nombre = hospital_Nombre;
    }

    /**
     * @return the hospital_Descripcion
     */
    public String getHospital_Descripcion() {
        return hospital_Descripcion;
    }

    /**
     * @param hospital_Descripcion the hospital_Descripcion to set
     */
    public void setHospital_Descripcion(String hospital_Descripcion) {
        this.hospital_Descripcion = hospital_Descripcion;
    }
    private Integer hospital_Id;
    private String hospital_Nombre;
    private String hospital_Descripcion;
    
}
