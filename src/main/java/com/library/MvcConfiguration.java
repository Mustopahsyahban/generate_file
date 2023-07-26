package com.library;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

@Configuration
public class MvcConfiguration implements WebMvcConfigurer {

    @Bean
    public LocaleResolver localeResolver(){
        Locale indonesia = new Locale("id","ID");
        SessionLocaleResolver session = new SessionLocaleResolver();
        session.setDefaultLocale(indonesia);
        return session;
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/category").setViewName("forward:/category/index");
        registry.addViewController("/author").setViewName("forward:/author/index");
        registry.addViewController("/customer").setViewName("forward:/customer/index");
        registry.addViewController("/product").setViewName("forward:/product/index");
        registry.addViewController("/loan").setViewName("forward:/loan/index");
        registry.addViewController("/").setViewName("forward:/account/home");
        registry.addViewController("/nasabah").setViewName("forward:/nasabah/index");
        registry.addViewController("/rbb22C00").setViewName("forward:rbb22C00/index?tglLapor=2023-07-19");
    }
}
