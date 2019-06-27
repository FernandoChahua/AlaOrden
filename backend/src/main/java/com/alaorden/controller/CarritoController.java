package com.alaorden.controller;

import com.alaorden.model.CarritoItem;
import com.alaorden.model.Producto;
import com.alaorden.service.CarritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

public class CarritoController {
    CarritoService carritoService;
    //Listar(usuario), Editar(usuario, producto), Eliminar(usuario,producto), Agregar(usuario), Vaciar(usuario)
    @Autowired
    public CarritoController(CarritoService carritoService) {this.carritoService = carritoService;}

    @RequestMapping
    List<CarritoItem> listCarritoItems(int idUsuario){return carritoService.listCarritoItem(idUsuario);}

    @RequestMapping(method=RequestMethod.PUT)
    CarritoItem updateCarrito(int idUsuario, int idProducto, int cantidad){
        List<CarritoItem> lista = carritoService.findByUsuario(idUsuario);
        CarritoItem act;
        for (CarritoItem Item : lista){
            if(Item.getproducto().getidProducto() == idProducto)
                act = Item;
        }
        act.setcantidad(cantidad);
        for (CarritoItem Item : lista){
            if(Item.getproducto().getidProducto() == idProducto)
                Item = act;
        }
    }
}
