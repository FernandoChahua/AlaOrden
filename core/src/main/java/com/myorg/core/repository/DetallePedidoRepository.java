package com.myorg.core.repository;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;

import com.myorg.core.entity.DetallePedido;
import com.myorg.core.util.Conexion;

@Named
public class DetallePedidoRepository implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Connection cx;
	
	public DetallePedidoRepository() {
		cx=Conexion.conectar();
	}
	
	public void save(DetallePedido p) {
		try {
			String sql="INSERT INTO detallepedido(idPedido,idProducto,precio,cantidad) VALUES(?,?,?,?)";
			PreparedStatement ps=cx.prepareStatement(sql);
			ps.setInt(1, p.getIdPedido());
			ps.setInt(2, p.getIdProducto());
                        ps.setDouble(3, p.getPrecio());
                        ps.setInt(4, p.getCantidad());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	public List<DetallePedido> findAll(){
		List<DetallePedido> productdetails=new ArrayList<>();
		try {
			String sql="SELECT * FROM detallepedido";
			PreparedStatement ps=cx.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				DetallePedido p=new DetallePedido();
				p.setIdPedido(rs.getInt("idPedido"));
                                p.setIdProducto(rs.getInt("idProducto"));
				p.setPrecio(rs.getDouble("precio"));
				p.setCantidad(rs.getInt("cantidad"));
				
				productdetails.add(p);
				
			}
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return productdetails;
	}

}





