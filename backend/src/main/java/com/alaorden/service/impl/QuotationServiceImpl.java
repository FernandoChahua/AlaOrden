package com.alaorden.service.impl;

import com.alaorden.model.*;
import com.alaorden.repository.InventoryRepository;
import com.alaorden.service.QuotationService;
import com.alaorden.service.OrderService;
import com.alaorden.util.MetroProductData;
import com.alaorden.util.ProductData;
import com.alaorden.util.ProductDataFactory;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.io.IOException;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

@Service
public class QuotationServiceImpl implements QuotationService {

    private InventoryRepository inventoryRepository;
    private ProductDataFactory productDataFactory;
    private static HttpURLConnection connection;
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
                    subTotal = subTotal.add(dp.getPrice()).multiply(BigDecimal.valueOf((double)dp.getQuantity()));
                }

                pe.setLocation(prov);
                pe.getLocation().getFranchise().setLocations(null);
                pe.setOrderDetails(list);
                pe.setSubTotal(subTotal);
                pe.setDiscount(BigDecimal.valueOf(0));
                pe.setUser(new User());
                pe.getUser().setIdUser(cart.get(0).getUser().getIdUser());
                proformas.add(pe);
            }
        } else {
            //No se hallaron proveedores
        }
        return proformas;
    }

    public List<OrderDetail> generateListByFranchise(List<CartItem> cart, Franchise prov) {
        List<OrderDetail> lista = new ArrayList<>();

        for (CartItem item : cart) {
            //empaquetar (incluir price)
            OrderDetail rpta = parseJson(item, prov);
            lista.add(rpta);
        }
        return lista;
    }

    public OrderDetail parseJson(CartItem cart,Franchise prov){
        BufferedReader reader;
        String line;
        StringBuffer responseContent = new StringBuffer();
        OrderDetail od = null;
        try {
            URL url = new URL("http://localhost:4999/"+prov.getApiUrl()+"/"+cart.getPk().getIdProduct());

            connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);

            int status = connection.getResponseCode();

            if(status>299){
                reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
                while((line=reader.readLine())!=null){
                    responseContent.append(line);
                }

                reader.close();
            }else{
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                while((line=reader.readLine())!=null){
                    responseContent.append(line);
                }
                reader.close();
                od = new OrderDetail();
                JSONObject object = new JSONObject(responseContent.toString());
                BigDecimal price = object.getBigDecimal("precio");
                od.setPk(new OrderDetailKey());
                od.setPrice(price);
                od.setQuantity(cart.getQuantity());
                od.getPk().setIdProduct(cart.getPk().getIdProduct());
                od.setProduct(new Product());
                od.getProduct().setIdProduct(cart.getPk().getIdProduct());
            }

        }
        catch (MalformedURLException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }

        return od;
    }


}
