package com.iqmsoft.boot.drools;

import java.util.Arrays;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MedicareApp {

	private static Logger log = LoggerFactory.getLogger(MedicareApp.class);

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(MedicareApp.class, args); 

        String[] beanNames = ctx.getBeanDefinitionNames();
        Arrays.sort(beanNames);

        StringBuilder sb = new StringBuilder("Application beans:\n");
        for (String beanName : beanNames) {
            sb.append(beanName + "\n");
        }
        log.info(sb.toString());
    }
  
    @Bean
    public KieContainer kieContainer() {
        return KieServices.Factory.get().getKieClasspathContainer();
    }

}
