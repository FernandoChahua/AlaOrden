package com.myorg.core.repository.impl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.myorg.core.entity.*;
import com.myorg.core.util.Conexion;
import java.io.Serializable;
import javax.inject.Named;

@Named
public class ClienteRepositoryImpl implements  Serializable {

    private Connection cx;

    public ClienteRepositoryImpl() {
        cx = Conexion.conectar();
    }

    public void insert(Cliente obj) {
        try {
            String sql = "insert into cliente(usuario,contrasena,email) VALUES(?,?,?)";
            PreparedStatement ps = cx.prepareStatement(sql);
            ps.setString(1, obj.getUsuario());
            ps.setString(2, obj.getContrasena());
            ps.setString(3, obj.getEmail());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public List<Cliente> findAll() {
        List<Cliente> clientes = new ArrayList<>();
        try {
            String sql = "select * from cliente";
            PreparedStatement ps = cx.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Cliente obj = new Cliente();
                obj.setIdCliente(rs.getInt("idCliente"));
                obj.setUsuario(rs.getString("usuario"));
                obj.setContrasena(rs.getString("contrasena"));
                obj.setEmail(rs.getString("email"));
                clientes.add(obj);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return clientes;
    }

}
