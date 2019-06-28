package com.alaorden.controller;


import com.alaorden.model.*;
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
    CartItem updateCarrito(@PathVariable int idUsuario,@PathVariable int idProducto,@PathVariable int cantidad){

        CartItem act = cartService.findByUserAndProduct(idUsuario,idProducto);
        act.setQuantity(cantidad);

        cartService.saveToCart(act);

        return act;
    }
    @RequestMapping(path="/{idUser}",method=RequestMethod.DELETE)
    void deleteCarrito(@PathVariable int idUser)
    {
        List<CartItem> carritos = cartService.findByUser(idUser);
        if(carritos != null)
        {
            cartService.deleteByUserId(idUser);
        }
    }
    @RequestMapping(path="/{idUser}/{idProduct}",method=RequestMethod.DELETE)
    void deleteCarrito(@PathVariable int idUser,@PathVariable int idProduct)
    {
        CartItem carrito = cartService.findByUserAndProduct(idUser,idProduct);
        if(carrito != null)
        {
            cartService.deleteByUserAndProduct(idUser,idProduct);
        }
    }
    @RequestMapping(method=RequestMethod.POST)
    void createItemCarrito(@RequestBody CartItem carritoItem){
        CartItem cartItem = new CartItem();
        cartItem.setPk(new CartItemKey());
        cartItem.getPk().setIdUser(carritoItem.getUser().getIdUser());
        cartItem.getPk().setIdProduct(carritoItem.getProduct().getIdProduct());
        cartItem.setProduct(new Product());
        cartItem.setUser(new User());

        cartItem.getProduct().setIdProduct(carritoItem.getProduct().getIdProduct());
        cartItem.getUser().setIdUser(carritoItem.getUser().getIdUser());

        cartService.deleteFromCart(cartItem);

    }
}
