package com.stackroute.MovieByArtist.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessageConfiguration {
    private String exchangeName = "movie_exchange";
    private String registerQueue = "movieByArtist_queue";

    @Bean
    public DirectExchange directExchange()
    {
        return new DirectExchange(exchangeName);
    }

    @Bean
    public Queue registerQueue()
    {
        return new Queue(registerQueue,false);
    }

    @Bean
    public Jackson2JsonMessageConverter producerJackson2JsonMessageConverter()
    {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public RabbitTemplate rabbitTemplate(final ConnectionFactory connectionFactory)
    {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(producerJackson2JsonMessageConverter());
        return rabbitTemplate;
    }

    @Bean
    public Binding binding(Queue registerQueue, DirectExchange exchange)
    {
        return BindingBuilder.bind(registerQueue()).to(exchange).with("MovieByArtist");
    }
}
