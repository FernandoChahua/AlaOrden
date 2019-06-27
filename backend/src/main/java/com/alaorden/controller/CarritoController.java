package com.alaorden.controller;

import com.alaorden.model.CartItem;
import com.alaorden.model.Product;
import com.alaorden.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/cart")
public class CarritoController {
    CartService cartService;
    //Listar(usuario), Editar(usuario, producto), Eliminar(usuario,producto), Agregar(usuario), Vaciar(usuario)
    @Autowired
    public CarritoController(CartService cartService) {this.cartService = cartService;}

    @RequestMapping(path="/{idUsuario}",method= RequestMethod.GET)
    List<CartItem> listCarritoItems(@PathVariable int idUsuario){return cartService.findByUser(idUsuario);}

    @RequestMapping(path="/{idUsuario}/{idProducto}/{cantidad}",method=RequestMethod.PUT)
    CartItem updateCarrito(int idUsuario, int idProducto, int cantidad){
        List<CartItem> lista = cartService.findByUser(idUsuario);
        CartItem act = new CartItem();
        for (CartItem Item : lista){
            if(Item.getProduct().getIdProduct() == idProducto)
                act = Item;
        }
        act.setQuantity(cantidad);
        for (CartItem Item : lista){
            if(Item.getProduct().getIdProduct() == idProducto)
                Item = act;
        }
        return act;
    }
}
