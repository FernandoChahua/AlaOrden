package com.alaorden.controller;

import com.alaorden.model.*;
import com.alaorden.service.*;

import java.time.LocalDateTime;
import java.util.*;
import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/cotizacion")
public class CotizacionController {
        private QuotationService quotationService;
        private AddressService addressService;
        private CartService cartService;
        @Autowired
        public CotizacionController(QuotationService quotationService,AddressService addressService,CartService cartService){
        this.quotationService = quotationService;
        this.addressService = addressService;
        this.cartService = cartService;
        }

        @RequestMapping(path="/{idUser}",method=RequestMethod.POST)
         public   List<Orders> generarListas(@PathVariable int idUser,@RequestBody Address address){
            double latitude = address.getLatitude();
            double longitude = address.getLongitude();

            List<CartItem> carrito = cartService.findByUser(idUser);
            List<Location> listLocations = addressService.listDistanceMin(latitude,longitude);
            if(listLocations == null){
                return null;
            }
            List<Orders> orders = quotationService.generateList(carrito,listLocations);

            for(int i=0;i<orders.size();i++){
                double distance=addressService.computeDistance(orders.get(i).getLocation().getLatitude(),orders.get(i).getLocation().getLongitude(),latitude,longitude);
                BigDecimal price=addressService.computeDeliveryPrice(distance);
                orders.get(i).setPriceDelivery(price.setScale(2, BigDecimal.ROUND_UP));
                orders.get(i).setAddress(address.getDescription());
                orders.get(i).setState("Procesando");
                orders.get(i).setDate(LocalDateTime.now());
                orders.get(i).setSubTotal(orders.get(i).getSubTotal().setScale(2, BigDecimal.ROUND_UP));
            }

            return orders;
        }
}
