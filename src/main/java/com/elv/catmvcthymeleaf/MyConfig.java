package com.elv.catmvcthymeleaf;

import nz.net.ultraq.thymeleaf.LayoutDialect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {
    @Bean
    public LayoutDialect layoutDialect ( ) {
        return new LayoutDialect( ) ;
    }
}
