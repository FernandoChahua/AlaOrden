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
                config.exposeIdsFor(CartItem.class,Category.class,Coupon.class,OrderDetail.class,Address.class,Orders.class,Product.class,Inventory.class,Location.class,Transaction.class,Brand.class, User.class,Franchise.class);
            }
        };
    }
}