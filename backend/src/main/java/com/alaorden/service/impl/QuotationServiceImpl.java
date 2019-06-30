package com.alaorden.service.impl;

import com.alaorden.model.*;
import com.alaorden.repository.InventoryRepository;
import com.alaorden.service.QuotationService;
import com.alaorden.service.OrderService;
import com.alaorden.util.MetroProductData;
import com.alaorden.util.ProductData;
import com.alaorden.util.ProductDataFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.*;


@Service
public class QuotationServiceImpl implements QuotationService {

    private InventoryRepository inventoryRepository;
    private ProductDataFactory productDataFactory;

    @Autowired
    public QuotationServiceImpl(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }



    public List<Order> generateList(List<CartItem> cart, List<Location> available) {

        List<Order> proformas = new ArrayList<>();

        if (available != null && !available.isEmpty()) {

            for (Location prov : available) {
                List<OrderDetail> list = generateListByFranchise(cart, prov.getFranchise());

                //FIXME: pls
                //TODO: no puedo :'(
                Order pe = new Order();

                BigDecimal subTotal = BigDecimal.valueOf(0);

                for (OrderDetail dp : list){
                    subTotal = subTotal.add(dp.getPrice());
                }

                pe.setLocation(prov);
                pe.setOrderDetails(list);
                pe.setSubTotal(subTotal);


                proformas.add(pe);
            }
        } else {
            //No se hallaron proveedores
        }
        return proformas;
    }

    public List<OrderDetail> generateListByFranchise(List<CartItem> cart, Franchise prov) {
        List<OrderDetail> lista = new ArrayList<>();

        //establecer conexion
        productDataFactory = new ProductDataFactory(prov);

        for (CartItem item : cart) {

            //empaquetar (incluir price)
            OrderDetail rpta = empaquetar(item, prov);
            lista.add(rpta);
        }
        return lista;
    }

    public OrderDetail empaquetar(CartItem busq, Franchise prov) {
        OrderDetail result = new OrderDetail();
        String codRef = null;
        BigDecimal precio = null;
        String mensaje = null;
        int cantidad = 0;

        codRef = getCodRef(busq, prov);


        //FIXME: fix logic
        ProductData info = null;
        try {
            info = productDataFactory.fecthProductData(codRef);
        } catch (IOException e){

        }

        if (!info.validate()) {
            mensaje = "Product no diponible en " + prov.getName();
        }
        //Si el stock no es suficiente
        if (busq.getQuantity() > info.getStock()) {
            //incluir caso en Regla de negocios
            if (info.getStock() == 0) {
                mensaje = "No hay stock disponible";
            } else {
                mensaje = "No hay stock suficiente";
            }
            cantidad = info.getStock();
        }

        //almacena: price, product y quantity
        result.setPrice(precio);
        result.setProduct(busq.getProduct());
        result.setQuantity(cantidad);
        return result;
    }

    public String getCodRef(CartItem busq, Franchise prov) {
        String codRef = null;
        for (Inventory pf : busq.getProduct().getInventory()) {
            if (pf.getFranchise().getIdFranchise() == prov.getIdFranchise()) {
                codRef = pf.getRefCode();
                break;
            }
        }
        return codRef;
    }

}
