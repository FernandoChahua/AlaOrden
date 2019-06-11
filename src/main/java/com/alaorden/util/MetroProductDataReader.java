package com.alaorden.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;

public class MetroProductDataReader extends ProductDataReader {

    public MetroProductDataReader(URL url){
        super(url);
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
    public BigDecimal getPrecio() {
        return BigDecimal.valueOf(prodData.get("precio").asDouble());
    }

    @Override
    public int getStock() {
        return prodData.get("stock").asInt();
    }
}
