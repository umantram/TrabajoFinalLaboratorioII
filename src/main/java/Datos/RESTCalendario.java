package Datos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * Created by umantram on 28/11/16.
    @Component("restCalendario")
    public class RESTCalendario {

        @Autowired
        private RestTemplate restTemplate;

        public String getAll() {
            return restTemplate.getForObject("http://localhost:8080/calendario", String.class);
        }


    }
*/

