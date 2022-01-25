package com.access.control.onStart;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Configuration
public class OnApplicationStart  implements ApplicationListener<ContextRefreshedEvent> {
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println(" S runnifgn kfjad;filgj;sdofilgjkasd;ofliasjkd;folj ioiasd;foasid");
    }
    @EventListener(ApplicationReadyEvent.class)
    public void onStart(){
        System.out.println(" S ApplicationReadyEvent runnifgn kfjad;filgj;sdofilgjkasd;ofliasjkd;folj ioiasd;foasid");

    }
}
