package com.alaorden.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;

public abstract class ProductDataReader {

    protected ObjectNode prodData;

    ProductDataReader(URL url){
        setFromUrl(url);
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

    protected abstract boolean validate();

    protected abstract String getCodRef();

    protected abstract BigDecimal getPrecio();

    protected abstract int getStock();
}
