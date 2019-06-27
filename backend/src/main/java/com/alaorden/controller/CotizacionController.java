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

        @RequestMapping(method=RequestMethod.POST)
            List<Order> generarListas(@RequestBody List<CartItem>carrito,@RequestBody Address address){
            Map<Location,BigDecimal> listLocations = addressService.listDistanceMin(address.getLatitude().doubleValue(),address.getLongitude().doubleValue());
            List<Order> orders = quotationService.generateList(carrito,listLocations);

            for(int i=0;i<orders.size();i++){
                double distance=addressService.computeDistance(orders.get(i).getLocation().getLatitude().doubleValue(),orders.get(i).getLocation().getLongitude().doubleValue(),address.getLatitude().doubleValue(),address.getLongitude().doubleValue());
                BigDecimal price=addressService.computeDeliveryPrice(distance);
                orders.get(i).setPriceDelivery(price);
            }
            return orders;
        }
}
