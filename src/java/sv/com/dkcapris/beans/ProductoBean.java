/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.dkcapris.beans;

import java.util.ArrayList;

/**
 *
 * @author Jose-PC
 */
public class ProductoBean {

    /**
     * @return the id_tipoproducto
     */
    public int getId_tipoproducto() {
        return id_tipoproducto;
    }

    /**
     * @param id_tipoproducto the id_tipoproducto to set
     */
    public void setId_tipoproducto(int id_tipoproducto) {
        this.id_tipoproducto = id_tipoproducto;
    }

    /**
     * @return the id_categoria
     */
    public int getId_categoria() {
        return id_categoria;
    }

    /**
     * @param id_categoria the id_categoria to set
     */
    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    /**
     * @return the ProductoImagenes
     */
    public ArrayList<ImageBean> getProductoImagenes() {
        return ProductoImagenes;
    }

    /**
     * @param ProductoImagenes the ProductoImagenes to set
     */
    public void setProductoImagenes(ArrayList<ImageBean> ProductoImagenes) {
        this.ProductoImagenes = ProductoImagenes;
    }

    /**
     * @return the producto_id
     */
    public int getProducto_id() {
        return producto_id;
    }

    /**
     * @param producto_id the producto_id to set
     */
    public void setProducto_id(int producto_id) {
        this.producto_id = producto_id;
    }

    /**
     * @return the id_fabricante
     */
    public int getId_fabricante() {
        return id_fabricante;
    }

    /**
     * @param id_fabricante the id_fabricante to set
     */
    public void setId_fabricante(int id_fabricante) {
        this.id_fabricante = id_fabricante;
    }

    /**
     * @return the producto_serie
     */
    public String getProducto_serie() {
        return producto_serie;
    }

    /**
     * @param producto_serie the producto_serie to set
     */
    public void setProducto_serie(String producto_serie) {
        this.producto_serie = producto_serie;
    }

    /**
     * @return the producto_nombre
     */
    public String getProducto_nombre() {
        return producto_nombre;
    }

    /**
     * @param producto_nombre the producto_nombre to set
     */
    public void setProducto_nombre(String producto_nombre) {
        this.producto_nombre = producto_nombre;
    }
    private int producto_id;
    private int id_fabricante;
    private int id_categoria;
    private int id_tipoproducto;
    private String producto_serie;
    private String producto_nombre;
    private ArrayList<ImageBean> ProductoImagenes=  new ArrayList<ImageBean>();
    
}
