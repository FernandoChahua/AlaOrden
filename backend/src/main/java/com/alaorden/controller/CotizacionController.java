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
            List<Order> generarListas(@PathVariable int idUser){
            double latitude = -12.077053;
            double longitude = -77.081605;

            List<CartItem> carrito = cartService.findByUser(idUser);
            List<Location> listLocations = addressService.listDistanceMin(latitude,longitude);
            List<Order> orders = quotationService.generateList(carrito,listLocations);

            for(int i=0;i<orders.size();i++){
                double distance=addressService.computeDistance(orders.get(i).getLocation().getLatitude().doubleValue(),orders.get(i).getLocation().getLongitude().doubleValue(),latitude,longitude);
                BigDecimal price=addressService.computeDeliveryPrice(distance);
                orders.get(i).setPriceDelivery(price);
            }

            return orders;
        }
}
