package com.student_result.data.student_controller;


import com.student_result.data.request_q_sender.RequestQSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {

    @Autowired
    RequestQSender requestQSender;

    @GetMapping("/getresult")
    public String producer(@RequestParam String name) {

        requestQSender.send(name);
        return "Student name: "+name+", sent to the RabbitMQ  Successfully";
    }
}
