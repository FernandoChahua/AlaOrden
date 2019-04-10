package com.myorg.core.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.myorg.core.entity.Cliente;
import com.myorg.core.util.Conexion;
import java.io.Serializable;
import javax.inject.Named;

@Named
public class ClienteRepository implements Serializable{

    private Connection cx;

    public ClienteRepository() {
        cx = Conexion.conectar();
    }

    public void save(Cliente obj) {
        try {
            String sql = "insert into cliente(usuario,contrasena,correo) VALUES(?,?,?)";
            PreparedStatement ps = cx.prepareStatement(sql);
            ps.setString(1, obj.getUsuario());
            ps.setString(2, obj.getContrasena());
            ps.setString(3, obj.getCorreo());
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
                obj.setIdCliente(rs.getInt("id_cliente"));
                obj.setUsuario(rs.getString("usuario"));
                obj.setContrasena(rs.getString("contrasena"));
                obj.setCorreo(rs.getString("correo"));
                clientes.add(obj);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return clientes;
    }

}
