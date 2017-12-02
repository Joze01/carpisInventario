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
public class DetallePedidoBean {

    /**
     * @return the cantidad
     */
    public Integer getCantidad() {
        return cantidad;
    }

    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * @return the detalle_id
     */
    public Integer getDetalle_id() {
        return detalle_id;
    }

    /**
     * @param detalle_id the detalle_id to set
     */
    public void setDetalle_id(Integer detalle_id) {
        this.detalle_id = detalle_id;
    }

    /**
     * @return the id_producto
     */
    public Integer getId_producto() {
        return id_producto;
    }

    /**
     * @param id_producto the id_producto to set
     */
    public void setId_producto(Integer id_producto) {
        this.id_producto = id_producto;
    }

    /**
     * @return the id_pedido
     */
    public Integer getId_pedido() {
        return id_pedido;
    }

    /**
     * @param id_pedido the id_pedido to set
     */
    public void setId_pedido(Integer id_pedido) {
        this.id_pedido = id_pedido;
    }
    private Integer detalle_id;
    private Integer id_producto;
    private Integer id_pedido;
    private Integer cantidad;
}
