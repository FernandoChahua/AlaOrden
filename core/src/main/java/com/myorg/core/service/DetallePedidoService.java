package com.myorg.core.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import com.myorg.core.entity.DetallePedido;
import com.myorg.core.repository.DetallePedidoRepository;

@Named
public class DetallePedidoService implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private DetallePedidoRepository datellepedidoRepository;
	
	public void saveDetallePedido(DetallePedido p) {
		datellepedidoRepository.save(p);
	}
	
	public List<DetallePedido> getAllDetallesPedido(){
		return datellepedidoRepository.findAll();
	}
	

}
