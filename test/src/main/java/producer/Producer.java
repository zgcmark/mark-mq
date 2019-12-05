package producer;

import com.zmark.client.producer.DefaultMQProducer;

/**
 * @author zhengguangchen
 */


public class Producer {

    public static void main(String[] args) {
        DefaultMQProducer producer = new DefaultMQProducer("test-topic-name");

        producer.start();
    }

}
