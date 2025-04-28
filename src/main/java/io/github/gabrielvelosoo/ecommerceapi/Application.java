package io.github.gabrielvelosoo.ecommerceapi;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplicationBuilder builder = new SpringApplicationBuilder(Application.class);
        builder.bannerMode(Banner.Mode.OFF);
        builder.run(args);
        ConfigurableApplicationContext context = builder.context();
        ConfigurableEnvironment environment = context.getEnvironment();
        String applicationName = environment.getProperty("spring.application.name");
        System.out.println("Nome da aplicação: " + applicationName);
    }

}
