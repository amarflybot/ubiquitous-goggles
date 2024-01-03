package com.example.testcommoncache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CommonCacheApplication {

    public static void main(String[] args) {
        SpringApplication.run(CommonCacheApplication.class, args);
    }


    /*@Bean
    @Qualifier("hazelcastInstanceLocal")
    HazelcastInstance hazelcastInstance() throws FileNotFoundException {
        final File file = ResourceUtils.getFile("classpath:hazelcast.yaml");
        final Config config = Config.loadFromFile(file);
        return Hazelcast.getOrCreateHazelcastInstance(config);
    }*/
}
