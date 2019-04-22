/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myorg.core.repository;

import com.myorg.core.entity.Cliente;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.inject.Named;

import com.myorg.core.entity.Pedido;
import com.myorg.core.entity.Sede;
import com.myorg.core.util.Conexion;

/**
 *
 * @author nanfo
 */
@Named
public class PedidoRepository implements Serializable {

    private static final long serialVersionUID = 1L;

    private Connection cx;

    public PedidoRepository() {
        cx = Conexion.conectar();
    }

    public void save(Pedido p) {
        try {
            String sql = "insert into Pedido (idCliente, idSede, estado, fecha, direccion, nroTransaccion,subtotal,precioEnvio,descuento) VALUES(?,?,?,?,?,?,?,?,?)";
            try (PreparedStatement ps = cx.prepareStatement(sql)) {
                ps.setInt(1, p.getCliente().getIdCliente());
                ps.setInt(2, p.getSede().getIdSede());
                ps.setString(3, p.getEstado());
                ps.setString(4, p.getFecha());
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
                p.setFecha(rs.getString("fecha"));
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
