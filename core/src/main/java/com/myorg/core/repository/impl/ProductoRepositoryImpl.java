package com.myorg.core.repository.impl;

import java.io.Serializable;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;

import com.myorg.core.entity.*;
import com.myorg.core.util.Conexion;

@Named
public class ProductoRepositoryImpl implements Serializable {

    private static final long serialVersionUID = 1L;

    private Connection cx;

    public ProductoRepositoryImpl() {
        cx = Conexion.conectar();
    }

    public void insert(Producto p) {
        try {
            String sql = "INSERT INTO producto(nombre,idMarca,descripcion,peso,idCategoria) VALUES(?,?,?,?,?)";
            PreparedStatement ps = cx.prepareStatement(sql);
            ps.setString(1, p.getNombre());
            ps.setInt(2, p.getMarca().getIdMarca());
            ps.setString(3, p.getDescripcion());
            ps.setDouble(4, p.getPeso());
            ps.setInt(5, p.getCategoria().getIdCategoria());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public List<Producto> findAll() {
        List<Producto> productos = new ArrayList<>();
        try {
            String sql = "SELECT * FROM producto";
            PreparedStatement ps = cx.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Producto p = new Producto();
                Marca m = new Marca();
                Categoria c = new Categoria();
                p.setIdProducto(rs.getInt("idProducto"));
                p.setNombre(rs.getString("nombre"));
                m.setIdMarca(rs.getInt("marca"));
                p.setDescripcion(rs.getString("descripcion"));
                p.setPeso(rs.getDouble("peso"));
                c.setIdCategoria(rs.getInt("categoria"));
                p.setMarca(m);
                p.setCategoria(c);

                productos.add(p);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return productos;
    }

}
