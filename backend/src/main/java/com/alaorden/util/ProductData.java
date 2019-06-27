package com.alaorden.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;

public abstract class ProductData {

    protected ObjectNode prodData;

    public ProductData(URL url){
        setFromUrl(url);
    }

    public ProductData(ObjectNode jsonData){
        this.prodData = jsonData;
    }

    protected void setFromUrl(URL url) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            this.prodData = mapper.readValue(url, ObjectNode.class);
        }
        catch (IOException e){
            this.prodData = null;
        }
    }

    public abstract boolean validate();

    public abstract String getCodRef();

    public abstract BigDecimal getPrice();

    public abstract int getStock();
}
