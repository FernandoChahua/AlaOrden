package com.alaorden.service.impl;

import com.alaorden.repository.ProductoFranquiciaRepository;
import com.alaorden.service.CotizacionService;
import com.alaorden.util.MetroProductDataReader;
import com.alaorden.util.ProductDataReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.MalformedURLException;
import java.net.URL;

@Service
public class CotizacionServiceImpl implements CotizacionService {

    private ProductoFranquiciaRepository productoFranquiciaRepository;
    private ProductDataReader productDataReader;

    @Autowired
    public CotizacionServiceImpl(ProductoFranquiciaRepository productoFranquiciaRepository) {
        this.productoFranquiciaRepository = productoFranquiciaRepository;
    }

    //FIXME: change temporary case
    public ProductDataReader AdapterFactory(String franquicia){
        switch (franquicia){
            //TODO: logica para multiples franquicias
        }

        //TMP
        URL url = null;
        try {
            url = new URL("http://localhost:5000/api/metroproducto");
        }
        catch (MalformedURLException e){

        }
        return new MetroProductDataReader(url);
    }

}
