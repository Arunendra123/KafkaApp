package Consumer;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

public class MyKafkaConsumer {

        private KafkaConsumer<String,String> kafkaConsumer;

        public MyKafkaConsumer(String topicName){
                      
            Properties configProperties = new Properties();
            configProperties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
            configProperties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
            configProperties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
            configProperties.put(ConsumerConfig.GROUP_ID_CONFIG, "java-group-consumer");
            configProperties.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG,"earliest");
            
            //Figure out where to start processing messages from
            kafkaConsumer = new KafkaConsumer<String, String>(configProperties); 
            kafkaConsumer.subscribe(Arrays.asList(topicName));
        }
        
        public void consume() {
            //Start processing messages
                while (true) {
                	ConsumerRecords<String, String> records = kafkaConsumer.poll(Duration.ofMillis(1000));
                    for(ConsumerRecord record : records) {
                    	System.out.println("Topic Name:"+record.topic()+" Key:"+record.key()+" Value:"+record.value());
                    }
                }
        }
}