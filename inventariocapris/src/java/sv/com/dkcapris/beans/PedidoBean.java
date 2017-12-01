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
public class PedidoBean {

    /**
     * @return the pedido_id
     */
    public int getPedido_id() {
        return pedido_id;
    }

    /**
     * @param pedido_id the pedido_id to set
     */
    public void setPedido_id(int pedido_id) {
        this.pedido_id = pedido_id;
    }


    /**
     * @return the pedido_fechaInicio
     */
    public String getPedido_fechaInicio() {
        return pedido_fechaInicio;
    }

    /**
     * @param pedido_fechaInicio the pedido_fechaInicio to set
     */
    public void setPedido_fechaInicio(String pedido_fechaInicio) {
        this.pedido_fechaInicio = pedido_fechaInicio;
    }

    /**
     * @return the pedido_fechaFinal
     */
    public String getPedido_fechaFinal() {
        return pedido_fechaFinal;
    }

    /**
     * @param pedido_fechaFinal the pedido_fechaFinal to set
     */
    public void setPedido_fechaFinal(String pedido_fechaFinal) {
        this.pedido_fechaFinal = pedido_fechaFinal;
    }
    private int pedido_id;
    private String pedido_descripcion;
    private String pedido_fechaInicio;
    private String pedido_fechaFinal;

    /**
     * @return the pedido_descripcion
     */
    public String getPedido_descripcion() {
        return pedido_descripcion;
    }

    /**
     * @param pedido_descripcion the pedido_descripcion to set
     */
    public void setPedido_descripcion(String pedido_descripcion) {
        this.pedido_descripcion = pedido_descripcion;
    }
    
}
