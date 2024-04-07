package ru.otus.java.pro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.relational.core.mapping.event.BeforeConvertCallback;
import ru.otus.java.pro.entities.Ad;
import ru.otus.java.pro.entities.RealEstate;

import java.util.UUID;

@SpringBootApplication
public class FinalProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(FinalProjectApplication.class, args);
    }

    @Bean
    BeforeConvertCallback<? extends Ad> beforeSaveCallbackRealEstate() {

        return (ad) -> {
            if (ad.getId() == null) {
                ad.setId(ad.getAdId());
            }
            return ad;
        };
    }
}