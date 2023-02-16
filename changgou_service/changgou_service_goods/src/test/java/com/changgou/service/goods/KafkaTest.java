package com.changgou.service.goods;

import com.alibaba.fastjson.JSON;
import com.changgou.service.goods.pojo.Brand;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author: 樊泽鑫
 * @Project: changgou_parent
 * @Pcakage: com.changgou.service.goods.KafkaTest
 * @Date: 2023年02月14日 10:40
 * @Description:
 */

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class KafkaTest {

    private String topic = "LOG4X-AUDIT-TOPIC";

    @Autowired
    private KafkaTemplate kafkaTemplate;


    @Test
    public void kafkaSend(){
        Brand brand = new Brand();
        brand.setId(1);
        brand.setName("fzx");
        brand.setLetter("F");
        kafkaTemplate.send(topic,"key", JSON.toJSONString(brand));
    }

}
