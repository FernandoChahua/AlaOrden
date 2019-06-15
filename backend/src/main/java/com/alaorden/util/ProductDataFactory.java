package com.alaorden.util;

import com.alaorden.model.Franquicia;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class ProductDataFactory {
    private String nombreFranquicia;
    private String apiUrl;

    public ProductDataFactory(String apiUrl, String franquicia){
        this.nombreFranquicia = franquicia;
        this.apiUrl = apiUrl;
    }

    public ProductDataFactory(Franquicia franquicia) {
        this.apiUrl = franquicia.getConexion();
        this.nombreFranquicia = franquicia.getNombre();
    }

    //Factory Method
    public ProductData fecthProductData(String codRef) throws IOException {
        String urlStr = this.apiUrl.replace("{cod}",codRef);
        URL url = new URL(urlStr);

        ObjectMapper mapper = new ObjectMapper();

        ObjectNode data = mapper.readValue(url, ObjectNode.class);

        ProductData pd = null;

        switch (nombreFranquicia) {
            case "metro":
                pd = new MetroProductData(data);
                break;
        }
        return pd;
    }

    public String getNombreFranquicia() {
        return nombreFranquicia;
    }

    public void setNombreFranquicia(String nombreFranquicia) {
        this.nombreFranquicia = nombreFranquicia;
    }

    public String getApiUrl() {
        return apiUrl;
    }

    public void setApiUrl(String apiUrl) {
        this.apiUrl = apiUrl;
    }
}
