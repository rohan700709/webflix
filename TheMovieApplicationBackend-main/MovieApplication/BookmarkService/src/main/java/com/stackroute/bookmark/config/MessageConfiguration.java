package com.stackroute.bookmark.config;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessageConfiguration {
    @Bean
    Jackson2JsonMessageConverter jsonMessageConverter()
    {
        return  new Jackson2JsonMessageConverter();
    }

}
