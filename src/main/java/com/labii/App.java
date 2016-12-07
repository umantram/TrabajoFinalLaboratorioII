package com.labii;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 */

/**
#
Muchos desarrolladores de Spring Boot siempre tienen su clase principal anotada con
@Configuration, @EnableAutoConfiguration y @ComponentScan.
Dado que estas anotaciones son tan frecuentemente usadas juntas (especialmente si sigue las mejores prácticas anteriores),
Spring Boot proporciona una alternativa conveniente @SpringBootApplication.
#
 */
@SpringBootApplication
public class App
{
    public static void main( String[] args )
    {
        /**/http://localhost:8080

        /**

        #
        El método main () utiliza el método SpringApplication.run () de Spring Boot para iniciar una aplicación.
        ¿Se dio cuenta de que no había una sola línea de XML? No hay ningún archivo web.xml tampoco.
        Esta aplicación web es 100% pura Java y no tienes que lidiar con la configuración de cualquier
        fontanería o infraestructura.
        #
         */
        SpringApplication.run(App.class, args);
        System.out.println( "Hello World!" );

    }

}


/**Para que funcione con la consola de Intelij sin la necesidad de un Posman
/*
    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();

    }
*/