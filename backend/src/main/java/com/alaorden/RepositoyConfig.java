package com.alaorden;

import com.alaorden.model.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;


@Configuration
class RepositoryConfig {

    @Bean
    public RepositoryRestConfigurer repositoryRestConfigurer() {

        return new RepositoryRestConfigurerAdapter() {
            @Override
            public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
                config.exposeIdsFor(CarritoItem.class,Categoria.class,Cupon.class,DetallePedido.class,Direccion.class,Pedido.class,Producto.class,ProductoFranquicia.class,Sede.class,Transaccion.class,Marca.class, Usuario.class,Franquicia.class,);
            }
        };
    }
}