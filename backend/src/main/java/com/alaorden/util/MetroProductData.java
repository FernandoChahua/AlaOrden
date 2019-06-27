package com.alaorden.util;

import com.fasterxml.jackson.databind.node.ObjectNode;

import java.math.BigDecimal;
import java.net.URL;

public class MetroProductData extends ProductData {

    public MetroProductData(URL url){
        super(url);
    }

    public MetroProductData(ObjectNode jsonData) {
        super(jsonData);
    }

    @Override
    public boolean validate() {
        //TODO: fix;
        if (prodData != null)
            return true;
        return false;
    }

    @Override
    public String getCodRef()  {
        return prodData.get("id").asText();
    }

    @Override
    public BigDecimal getPrice() {
        return BigDecimal.valueOf(prodData.get("price").asDouble());
    }

    @Override
    public int getStock() {
        return prodData.get("stock").asInt();
    }
}
