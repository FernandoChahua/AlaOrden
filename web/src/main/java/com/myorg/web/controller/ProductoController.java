package com.myorg.web.controller;

import com.myorg.core.entity.*;
import com.myorg.core.service.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.myorg.util.Message;
import org.primefaces.event.SelectEvent;

@Named
@ViewScoped
public class ProductoController implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Inject
    private IProductoService productoService;

    @Inject
    private ICategoriaService categoriaService;

    @Inject
    private IMarcaService marcaService;

    private Producto producto;
    private Producto productoSel;
    private List<Producto> productos;

    private String strCategoria;
    private Categoria categoria;
    private List<Categoria> categorias;

    private String strMarca;
    private Marca marca;
    private List<Marca> marcas;

    @PostConstruct
    public void init() {
        producto = new Producto();
        productoSel = new Producto();
        categoria = new Categoria();
        marca = new Marca();
        this.loadProductos();
        this.loadCategorias();
        this.loadMarcas();

    }

    public void loadProductos() {
        try {
            this.productos = productoService.findAll();
        } catch (Exception e) {

        }
    }

    public void loadCategorias() {
        try {
            this.categorias = categoriaService.findAll();
        } catch (Exception e) {

        }
    }

    public void loadMarcas() {
        try {
            this.marcas = marcaService.findAll();
        } catch (Exception e) {

        }
    }

    public void compareCategoria() {
        for (Categoria c : categorias) {
            if (c.getNombre().equalsIgnoreCase(strCategoria)) {
                categoria = c;
                return;
            }
        }
        categoria.setNombre(strCategoria);
    }

    public void compareMarca() {
        for (Marca m : marcas) {
            if (m.getNombre().equalsIgnoreCase(strMarca)) {
                marca = m;
                return;
            }
        }
        marca.setNombre(strMarca);
    }

    public void saveProducto() {

        compareCategoria();
        compareMarca();        
        try {
            if (categoria.getIdCategoria() == null) {
                categoriaService.insert(categoria);
            }
            if (marca.getIdMarca() == null) {
                marcaService.insert(marca);
            }

            producto.setCategoria(categoria);
            producto.setMarca(marca);

            if (producto.getIdProducto() != null) {

                productoService.update(producto);
                Message.messageInfo("Registro actualizado exitosamente");
            } else {
                productoService.insert(producto);
                Message.messageInfo("Registro guardado exitosamente");
            }
            loadProductos();
            cleanForm();
        } catch (Exception e) {
            Message.messageError("Error Guardado :" + e.getMessage());
        }
    }

    public void editProducto() {
        try {
            if (this.productoSel.getIdProducto() != null) {
                this.producto = this.productoSel;

            } else {
                Message.messageInfo("Debe seleccionar un  producto");
            }
        } catch (Exception e) {
            Message.messageError("Error Sede :" + e.getMessage());
        }

    }

    public void deleteProducto() {
        try {
            if (this.productoSel != null) {
                productoService.delete(productoSel);
                loadProductos();
                cleanForm();

            } else {

            }
        } catch (Exception e) {

        }
    }

    public List<Categoria> completeCategoria(String query) {
        List<Categoria> filter = new ArrayList<>();

        for (Categoria c : categorias) {
            if (c.getNombre().toLowerCase().contains(query)) {
                filter.add(c);
            }
        }
        return filter;
    }

    public List<Marca> completeMarca(String query) {
        List<Marca> filter = new ArrayList<>();

        for (Marca m : marcas) {
            if (m.getNombre().toLowerCase().contains(query)) {
                filter.add(m);
            }
        }
        return filter;
    }

    public void selectProducto(SelectEvent e) {
        this.productoSel = (Producto) e.getObject();
    }

    public void cleanForm() {
        this.producto = new Producto();
        this.productoSel = null;
        this.strCategoria = null;
        this.strMarca = null;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public Producto getProductoSel() {
        return productoSel;
    }

    public void setProductoSel(Producto productoSel) {
        this.productoSel = productoSel;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public List<Marca> getMarcas() {
        return marcas;
    }

    public void setMarcas(List<Marca> marcas) {
        this.marcas = marcas;
    }

    public String getStrCategoria() {
        return strCategoria;
    }

    public void setStrCategoria(String strCategoria) {
        this.strCategoria = strCategoria;
    }

    public String getStrMarca() {
        return strMarca;
    }

    public void setStrMarca(String strMarca) {
        this.strMarca = strMarca;
    }

}
