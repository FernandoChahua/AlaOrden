package com.myorg.core.repository;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;

import com.myorg.core.entity.Producto;
import com.myorg.core.util.Conexion;

@Named
public class ProductoRepository implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Connection cx;
	
	public ProductoRepository() {
		cx=Conexion.conectar();
	}
	
	public void save(Producto p) {
		try {
			String sql="INSERT INTO producto(nombre,marca,descripcion,peso,categoria) VALUES(?,?,?,?,?)";
			PreparedStatement ps=cx.prepareStatement(sql);
			ps.setString(1, p.getNombre());
			ps.setString(2, p.getMarca());
                        ps.setString(3, p.getDescripcion());
			ps.setDouble(4, p.getPeso());
                        ps.setString(5, p.getCategoria());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	public List<Producto> findAll(){
		List<Producto> productos=new ArrayList<>();
		try {
			String sql="SELECT * FROM producto";
			PreparedStatement ps=cx.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				Producto p=new Producto();
				p.setIdProducto(rs.getInt("idProducto"));
				p.setNombre(rs.getString("nombre"));
				p.setMarca(rs.getString("marca"));
				p.setDescripcion(rs.getString("descripcion"));
                                p.setPeso(rs.getDouble("peso"));
                                p.setCategoria(rs.getString("categoria"));
                                
				productos.add(p);
			}
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return productos;
	}

}





