package com.alaorden.controllers;

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
        @Autowired
        public CotizacionController(QuotationService quotationService,AddressService addressService){
        this.quotationService = quotationService;
        this.addressService = addressService;
        }

        @RequestMapping(path="/{latitud}/{longitud}",method=RequestMethod.POST)
            List<Order> generarListas(String latitud,String longitud,@RequestBody List<CartItem>carrito){
            double latitude = Double.parseDouble(latitud);
            double longitude = Double.parseDouble(longitud);
            Map<Location,BigDecimal> listLocations = addressService.listDistanceMin(latitude,longitude);
            List<Order> orders = quotationService.generateList(carrito,listLocations);

            for(int i=0;i<orders.size();i++){
                double distance=addressService.computeDistance(orders.get(i).getLocation().getLatitude().doubleValue(),orders.get(i).getLocation().getLongitude().doubleValue(),latitude,longitude);
                BigDecimal price=addressService.computeDeliveryPrice(distance);
                orders.get(i).setPriceDelivery(price);
            }
            return orders;
        }
}
