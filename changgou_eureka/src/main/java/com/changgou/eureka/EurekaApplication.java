package com.changgou.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author: 樊泽鑫
 * @Project: changgou_parent
 * @Pcakage: com.changgou.eureka.EurekaApplication
 * @Date: 2023年02月12日 23:44
 * @Description:
 */

@SpringBootApplication
@EnableEurekaServer
public class EurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaApplication.class,args);
    }

}
