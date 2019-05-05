package com.myorg.core.service.comm;

import com.myorg.core.service.comm.ext.IProductoExtARepository;
import com.myorg.core.service.comm.ext.Product;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Named;

//AdapterConcreto
@Named
public class ComunicadorConcretoA extends ComunicadorInventario {

    private Map<String, InfoProd> infoProds;

    @Inject
    private IProductoExtARepository inv;

    public ComunicadorConcretoA() {
        infoProds = new HashMap<>();
    }

    @Override
    public void mapearProductos() {
        List<Product> list;
        try {
            list = inv.findAll();
        } catch (Exception ex) {
            list = new ArrayList<>();
        }

        for (Product obj : list) {
            //Extraer datos del objeto y generar 
            String codRef = Integer.toString(obj.getId());
            BigDecimal precio = obj.getPrecio_unitario();
            int stock = obj.getUnidades_en_stock();
            infoProds.put(codRef, new InfoProd(precio, stock));
        }
    }

    @Override
    public InfoProd recuperarInfoProd(String codRef) {
        InfoProd info = null;
        try {
            //verifica que se haya llenado el hastable
            if (!infoProds.isEmpty() && infoProds != null) {
                info = infoProds.get(codRef);
            } //si no se está mapeado, se recupera individualemnte
            else {
                Product p = new Product();
                p.setId(Integer.parseInt(codRef));
                p = inv.findById(p);
                if (p != null){
                    info = new InfoProd(p.getPrecio_unitario(), p.getUnidades_en_stock());
                }
            }
        } catch (Exception e) {

        }
        return info;
    }

    @Override
    public void limpiarMapaProductos() {
        infoProds.clear();
    }
}
