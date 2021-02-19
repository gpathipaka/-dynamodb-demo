package com.gp.ddb.config;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DynamoDBConfig {

    @Value("${aws.awsAccessKey}")
    private String awsAccessKey;

    @Value("${aws.awsSecretAccessKey}")
    private String awsSecretAccessKey;

    @Value("${aws.region}")
    private String region;

    @Value("${aws.dynamoDBendPoint}")
    private String dynamoDBendPoint;

    @Bean
    public DynamoDBMapper mapper() {

        return new DynamoDBMapper(amazonDynamoDBConfig());

    }

    public AmazonDynamoDB amazonDynamoDBConfig() {
        return AmazonDynamoDBClientBuilder.standard()
                .withEndpointConfiguration(
                        new AwsClientBuilder.EndpointConfiguration(dynamoDBendPoint, region))
                .withCredentials(
                        new AWSStaticCredentialsProvider(
                                new BasicAWSCredentials(awsAccessKey, awsSecretAccessKey)))
                .build();
    }
}
