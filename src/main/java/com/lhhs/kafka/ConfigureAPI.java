package com.lhhs.kafka;

public class ConfigureAPI {
	
	public interface KafkaProperties {
        public final static String ZK = "192.168.1.144:2181";
        public final static String GROUP_ID = "test_group39";
        public final static String TOPIC = "topic39";
        public final static String BROKER_LIST = "192.168.1.144:9092";
        public final static int BUFFER_SIZE = 64 * 1024;
        public final static int TIMEOUT = 20000;
        public final static int INTERVAL = 10000;
    }

}

	