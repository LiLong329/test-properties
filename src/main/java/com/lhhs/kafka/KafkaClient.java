package com.lhhs.kafka;

import com.lhhs.kafka.ConfigureAPI.KafkaProperties;

public class KafkaClient {
	public static void main(String[] args) {
        JProducer pro = new JProducer(KafkaProperties.TOPIC);
        pro.start();

        JConsumer con = new JConsumer(KafkaProperties.TOPIC);
        con.start();
    }
}

	