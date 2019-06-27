package com.alaorden.util;

import com.alaorden.model.Franchise;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class ProductDataFactory {
    private String franchiseName;
    private String apiUrl;

    public ProductDataFactory(String apiUrl, String franchise){
        this.franchiseName = franchise;
        this.apiUrl = apiUrl;
    }

    public ProductDataFactory(Franchise franchise) {
        this.apiUrl = franchise.getApiUrl();
        this.franchiseName = franchise.getName();
    }

    //Factory Method
    public ProductData fecthProductData(String codRef) throws IOException {
        String urlStr = this.apiUrl.replace("{cod}",codRef);
        URL url = new URL(urlStr);

        ObjectMapper mapper = new ObjectMapper();

        ObjectNode data = mapper.readValue(url, ObjectNode.class);

        ProductData pd = null;

        switch (franchiseName) {
            case "metro":
                pd = new MetroProductData(data);
                break;
        }
        return pd;
    }

    public String getFranchiseName() {
        return franchiseName;
    }

    public void setFranchiseName(String franchiseName) {
        this.franchiseName = franchiseName;
    }

    public String getApiUrl() {
        return apiUrl;
    }

    public void setApiUrl(String apiUrl) {
        this.apiUrl = apiUrl;
    }
}
