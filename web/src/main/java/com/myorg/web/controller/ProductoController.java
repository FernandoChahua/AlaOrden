package com.myorg.web.controller;

import com.myorg.core.entity.Categoria;
import com.myorg.core.entity.Producto;
import com.myorg.core.service.ICategoriaService;
import com.myorg.core.service.IProductoService;
import java.io.Serializable;
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
        private ICategoriaService categoriaService;

        @Inject
        private IProductoService productoService;

        private Producto producto;
        private Producto productoSel;
        private List<Producto> productos;

        private Categoria categoria;
        private List<Categoria> categorias;
	@PostConstruct
	public void init() {
		producto = new Producto();
                productoSel = new Producto();
                categoria = new Categoria();
                this.loadCategorias();
                this.loadProductos();
	}
	
        public void loadCategorias() {
            try {
                this.categorias = categoriaService.findAll();
            } catch (Exception e) {

            }
        }

        public void loadProductos() {
        try {
            this.productos = productoService.findAll();
        } catch (Exception e) {

            }
        }
	
        public void saveProducto() {
        try {
            if (producto.getIdProducto() != 0) {
                producto.setCategoria(categoria);
                productoService.update(producto);
                Message.messageInfo("Registro actualizado exitosamente");
            } else {
                producto.setCategoria(categoria);
                productoService.insert(producto);
                Message.messageInfo("Registro guardado exitosamente");

            }
            loadProductos();
            cleanForm();
        } catch (Exception e) {
            Message.messageError("Error SedeoType :" + e.getMessage());
            }
        }
        
        public void editProducto() {
        try {
            if (this.productoSel.getIdProducto() > 0) {
                this.producto = this.productoSel;
                // this.sede.setSedeType(this.sedeSel.getSedeType());
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
        
        public void selecProducto(SelectEvent e) {
                this.productoSel = (Producto) e.getObject();
        }
        
	public void cleanForm() {
                this.producto = new Producto();
                this.productoSel = null;
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
}
