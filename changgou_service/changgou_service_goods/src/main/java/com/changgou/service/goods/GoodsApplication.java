package com.changgou.service.goods;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author: 樊泽鑫
 * @Project: changgou_parent
 * @Pcakage: com.changgou.service.goods.GoodApplication
 * @Date: 2023年02月12日 23:58
 * @Description:
 */

@SpringBootApplication
@EnableEurekaClient
@MapperScan(basePackages = {"com.changgou.service.goods.mapper"})
public class GoodsApplication {
    public static void main(String[] args) {
        SpringApplication.run(GoodsApplication.class,args);
    }
}
