/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myorg.core.repository;

import java.io.Serializable;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.myorg.core.entity.Cliente;
import com.myorg.core.util.Conexion;
import com.myorg.core.entity.Tarjeta;
import javax.inject.Named;

@Named
public class TarjetaRepositorio implements Serializable {

    private static final long serialVersionUID = 1L;

    private Connection cx;

    public TarjetaRepositorio() {
        cx = Conexion.conectar();
    }

    public void guardar(Tarjeta t) {
        try {
            String sql = "INSERT INTO tarjeta(idCliente, nroCuenta,titular,fechaExp) VALUES(?,?,?,?)";
            PreparedStatement ps = cx.prepareStatement(sql);
            ps.setInt(1, t.getCliente().getIdCliente());
            ps.setString(2, t.getNroCuenta());
            ps.setString(3, t.getTitular());
            ps.setString(4, t.getFechaExp());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public List<Tarjeta> SeleccionTotal() {
        List<Tarjeta> tarjetas = new ArrayList<>();
        try {
            String sql = "SELECT t.*, c.usuario  FROM tarjeta t, cliente c where t.idCliente = c.idCliente";
            PreparedStatement ps = cx.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Tarjeta t = new Tarjeta();
                Cliente c = new Cliente();
                t.setIdTarjeta(rs.getInt("idTarjeta"));
                t.setNroCuenta(rs.getString("nroCuenta"));
                t.setTitular(rs.getString("titular"));
                t.setFechaExp(rs.getString("fechaExp"));

                c.setIdCliente(rs.getInt("idCliente"));
                c.setUsuario(rs.getString("usuario"));
                t.setCliente(c);

                tarjetas.add(t);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return tarjetas;
    }

}
