package ru.rutmiit.config;

import org.modelmapper.ModelMapper;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.HiddenHttpMethodFilter;

@Configuration
public class BeanConfiguration {

    @Bean
    public ModelMapper mapper() {
        return new ModelMapper();
    }

    // HiddenHttpMethodFilter, который позволяет эмулировать HTTP методы PUT, DELETE и др. с помощью запроса POST и скрытого поля _method в форме
    @Bean
    public FilterRegistrationBean<HiddenHttpMethodFilter> hiddenHttpMethodFilter() {
        FilterRegistrationBean<HiddenHttpMethodFilter> filterRegistrationBean = new FilterRegistrationBean<>(new HiddenHttpMethodFilter());
        filterRegistrationBean.addUrlPatterns("/*");
        return filterRegistrationBean;
    }
}
