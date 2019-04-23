package com.myorg.core.repository.impl;

import java.io.Serializable;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;

import com.myorg.core.entity.*;
import com.myorg.core.util.Conexion;

@Named
public class DetallePedidoRepositoryImpl implements Serializable {

    private static final long serialVersionUID = 1L;

    private Connection cx;

    public DetallePedidoRepositoryImpl() {
        cx = Conexion.conectar();
    }

    public void insert(DetallePedido p) {
        try {
            String sql = "INSERT INTO detallepedido(idPedido,idProducto,precio,cantidad) VALUES(?,?,?,?)";
            PreparedStatement ps = cx.prepareStatement(sql);
            ps.setInt(1, p.getPedido().getIdPedido());
            ps.setInt(2, p.getProducto().getIdProducto());
            ps.setDouble(3, p.getPrecio());
            ps.setInt(4, p.getCantidad());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public List<DetallePedido> findAll() {
        List<DetallePedido> productdetails = new ArrayList<>();
        try {
            String sql = "SELECT * FROM detallepedido";
            PreparedStatement ps = cx.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                DetallePedido p = new DetallePedido();
                Pedido pedido = new Pedido();
                Producto producto = new Producto();
                pedido.setIdPedido(rs.getInt("idPedido"));
                producto.setIdProducto(rs.getInt("idProducto"));
                p.setPrecio(rs.getDouble("precio"));
                p.setCantidad(rs.getInt("cantidad"));
                p.setPedido(pedido);
                p.setProducto(producto);

                productdetails.add(p);

            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return productdetails;
    }

}
