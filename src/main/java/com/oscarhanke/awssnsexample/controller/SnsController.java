package com.oscarhanke.awssnsexample.controller;

import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.model.PublishRequest;
import com.amazonaws.services.sns.model.SubscribeRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class SnsController {

    private final AmazonSNSClient snsClient;

    private final String TOPIC_ARN = "arn:aws:sns:us-east-1:691621966927:test-topic";

    @GetMapping("addSubscription/{email}")
    public String addSubscription(@PathVariable String email){
        SubscribeRequest request = new SubscribeRequest(TOPIC_ARN, "email", email);
        snsClient.subscribe(request);
        return "Subscription request is pending." +
                "To confirm the subscription check your email: " + email;
    }

    @PostMapping("sendNotification")
    public String publishMessageToTopic(@RequestBody String message){
        PublishRequest request = new PublishRequest(
                TOPIC_ARN,
                message,
                "Notification: Network connectivity issue");
        snsClient.publish(request);
        return "Notification send successfully!";
    }
}
