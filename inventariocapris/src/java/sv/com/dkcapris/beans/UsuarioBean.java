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
public class UsuarioBean {

    /**
     * @return the loggeado
     */
    public boolean isLoggeado() {
        return loggeado;
    }

    /**
     * @param loggeado the loggeado to set
     */
    public void setLoggeado(boolean loggeado) {
        this.loggeado = loggeado;
    }

    /**
     * @return the usuario_id
     */
    public int getUsuario_id() {
        return usuario_id;
    }

    /**
     * @param usuario_id the usuario_id to set
     */
    public void setUsuario_id(int usuario_id) {
        this.usuario_id = usuario_id;
    }

    /**
     * @return the id_tipo
     */
    public int getId_tipo() {
        return id_tipo;
    }

    /**
     * @param id_tipo the id_tipo to set
     */
    public void setId_tipo(int id_tipo) {
        this.id_tipo = id_tipo;
    }

    /**
     * @return the usuario_Nombre
     */
    public String getUsuario_Nombre() {
        return usuario_Nombre;
    }

    /**
     * @param usuario_Nombre the usuario_Nombre to set
     */
    public void setUsuario_Nombre(String usuario_Nombre) {
        this.usuario_Nombre = usuario_Nombre;
    }

    /**
     * @return the usuario_user
     */
    public String getUsuario_user() {
        return usuario_user;
    }

    /**
     * @param usuario_user the usuario_user to set
     */
    public void setUsuario_user(String usuario_user) {
        this.usuario_user = usuario_user;
    }

    /**
     * @return the usuario_password
     */
    public String getUsuario_password() {
        return usuario_password;
    }

    /**
     * @param usuario_password the usuario_password to set
     */
    public void setUsuario_password(String usuario_password) {
        this.usuario_password = usuario_password;
    }
    private int usuario_id;
    private int id_tipo;
    private String usuario_Nombre;
    private String usuario_user;
    private String usuario_password;
    private boolean loggeado;
}
