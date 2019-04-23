package com.myorg.core.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import com.myorg.core.entity.*;
import com.myorg.core.repository.impl.*;

@Named
public class DetallePedidoServiceImpl implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private DetallePedidoRepositoryImpl datellepedidoRepository;
	
	public void insert(DetallePedido p) {
		datellepedidoRepository.insert(p);
	}
	
	public List<DetallePedido> findAll(){
		return datellepedidoRepository.findAll();
	}
	

}
