package br.com.fiap.metaflow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class MetaFlowApplication {

    public static void main(String[] args) {
        SpringApplication.run(MetaFlowApplication.class, args);
    }

}
