package com.alaorden.service;

import com.alaorden.model.CarritoItem;
import com.alaorden.model.Pedido;

import java.util.List;

public interface PedidoService {

    Pedido GenerarPedido(List<CarritoItem> carrito);
    Pedido listarpedidoxusuario(Pedido pedido);

}
