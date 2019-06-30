package com.alaorden.controller;

import com.alaorden.model.*;
import com.alaorden.service.*;
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
            List<Orders> generarListas(@PathVariable int idUser,@RequestBody Address address){
            double latitude = address.getLatitude();
            double longitude = address.getLongitude();

            List<CartItem> carrito = cartService.findByUser(idUser);
            List<Location> listLocations = addressService.listDistanceMin(latitude,longitude);
            List<Orders> orders = quotationService.generateList(carrito,listLocations);

            for(int i=0;i<orders.size();i++){
                double distance=addressService.computeDistance(orders.get(i).getLocation().getLatitude(),orders.get(i).getLocation().getLongitude(),latitude,longitude);
                BigDecimal price=addressService.computeDeliveryPrice(distance);
                orders.get(i).setPriceDelivery(price);
                orders.get(i).setAddress(address.getDescription());
            }

            return orders;
        }
}
