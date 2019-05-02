package com.myorg.core.service.comm.ext;

//Adaptee

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Deprecated
public class RepositoryExt {
    
    private Connection cx;
    
    public RepositoryExt(Connection cx){
        this.cx = cx;
    }
    
    public List<Product> findAll() {
        List<Product> products = new ArrayList<>();
        try {
            String sql = "SELECT p.id, p.unidad_por_cantidad, p.unidades_en_stock FROM product p";
            PreparedStatement ps = cx.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                
                products.add(p);

            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return products;
    }

}
