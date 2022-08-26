package com.oscarhanke.awssnsexample.config;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.AmazonSNSClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

public class AwsSnsConfig {

    @Primary
    @Bean
    public AmazonSNSClient getSnsClient(){
        return (AmazonSNSClient) AmazonSNSClientBuilder.standard()
                .withRegion(Regions.EU_CENTRAL_1)
                .withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials("", "")))
                .build();
    }
}
