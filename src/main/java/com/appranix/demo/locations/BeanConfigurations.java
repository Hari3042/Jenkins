package com.appranix.demo.locations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.togglz.core.manager.EnumBasedFeatureProvider;
import org.togglz.core.spi.FeatureProvider;

@Configuration
public class BeanConfigurations {

    @Bean
    public FeatureProvider featureProvider() {
        return new EnumBasedFeatureProvider(AppFeatures.class);
    }
}
