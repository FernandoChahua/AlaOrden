package com.myorg.core.repository.impl;

import java.io.Serializable;
import java.sql.*;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;

import com.myorg.core.entity.*;
import com.myorg.core.util.Conexion;

@Named
public class PedidoRepositoryImpl implements Serializable {

    private static final long serialVersionUID = 1L;

    private Connection cx;

    public PedidoRepositoryImpl() {
        cx = Conexion.conectar();
    }

    public void insert(Pedido p) {
        try {
            String sql = "insert into Pedido (idCliente, idSede, estado, fecha, direccion, nroTransaccion,subtotal,precioEnvio,descuento) VALUES(?,?,?,?,?,?,?,?,?)";
            try (PreparedStatement ps = cx.prepareStatement(sql)) {
                ps.setInt(1, p.getCliente().getIdCliente());
                ps.setInt(2, p.getSede().getIdSede());
                ps.setString(3, p.getEstado());
                ps.setObject(4, p.getFecha());
                ps.setString(5, p.getDireccion());
                ps.setInt(6, p.getNroTransaccion());
                ps.setBigDecimal(7, p.getSubtotal());
                ps.setBigDecimal(8, p.getPrecioEnvio());
                ps.setBigDecimal(9, p.getDescuento());
                ps.executeUpdate();
                ps.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public List<Pedido> findAll() {
        List<Pedido> products = new ArrayList<>();
        try {
            String sql = "SELECT *  FROM Pedido";
            PreparedStatement ps = cx.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Pedido p = new Pedido();
                Cliente c = new Cliente();
                Sede s = new Sede();

                p.setIdPedido(rs.getInt("idPedido"));
                c.setIdCliente(rs.getInt("idCliente"));
                s.setIdSede(rs.getInt("idSede"));
                p.setEstado(rs.getString("estado"));
                p.setFecha(rs.getTimestamp("fecha").toLocalDateTime());
                p.setDireccion(rs.getString("direccion"));
                p.setNroTransaccion(rs.getInt("nroTransaccion"));
                p.setSubtotal(rs.getBigDecimal("subtotal"));
                p.setPrecioEnvio(rs.getBigDecimal("precioEnvio"));
                p.setDescuento(rs.getBigDecimal("descuento"));

                p.setCliente(c);
                p.setSede(s);

                products.add(p);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return products;
    }
}
