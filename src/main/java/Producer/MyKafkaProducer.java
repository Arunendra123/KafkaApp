package Producer;

import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;

public class MyKafkaProducer {
	private KafkaProducer<String, String> kafkaProducer;
	private String topicName;
	
	public MyKafkaProducer(String topicName){
		this.topicName=topicName;
		
		Properties p=new Properties();
		p.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");
		p.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
		p.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
		kafkaProducer=new KafkaProducer<String, String>(p);
	}
	
	public KafkaProducer<String, String> getKafkaProducer() {
		return kafkaProducer;
	}
	
	public void produce(String msg) {
		ProducerRecord<String, String> producerRecord=new ProducerRecord<String, String>(topicName,"Message:",msg);
		kafkaProducer.send(producerRecord);
	}
	
	public void close() {
		kafkaProducer.close();
		System.out.println("closing...");
	}
}
