package com.result_processor.data.response_q_sender;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResponseQSender {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    String exchange ="response.exchange";
    String routingkey ="response.routingkey" ;

    public void send(String student) {
        System.out.println("Sent ResponseQStudent Result Deatils of Student");
        rabbitTemplate.convertAndSend(exchange, routingkey, student);

    }
}
