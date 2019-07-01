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

    //TODO: usuario no existe
    @RequestMapping(path="/{idUsuario}",method= RequestMethod.GET)
    List<CartItem> listCarritoItems(@PathVariable int idUsuario){return cartService.findByUser(idUsuario);}


    @RequestMapping(path="/{idUser}",method=RequestMethod.DELETE)
    String empyCarrito(@PathVariable int idUser)
    {
        List<CartItem> carritos = cartService.findByUser(idUser);
        if(carritos != null)
        {
            cartService.deleteByUserId(idUser);
            return "Eliminado correctamente";
        }
        return "No existe el carrito del Usuario con Id "+idUser;
    }

    //TODO:
    @RequestMapping(path="/{idUser}/{idProduct}",method=RequestMethod.DELETE)
    String deleteCarrito(@PathVariable int idUser,@PathVariable int idProduct)
    {
        CartItem carrito = cartService.findByUserAndProduct(idUser,idProduct);
        if(carrito != null)
        {
            cartService.deleteByUserAndProduct(idUser,idProduct);
            return "Eliminado correctamente";
        }
        return ("No existe el item carrito del usuario con id "+idUser+" y producto con id "+idProduct);
    }

    //TODO:
    @RequestMapping(method=RequestMethod.POST)
    void createItemCarrito(@RequestBody CartItem carritoItem){
        if(carritoItem != null) {
            cartService.saveToCart(carritoItem);
        }
    }

    //TODO: no existe
    @RequestMapping(method=RequestMethod.PUT)
    void updateItemCarrito(@RequestBody CartItem carritoItem){
        if(carritoItem != null) {
            cartService.saveToCart(carritoItem);
        }
    }
}
