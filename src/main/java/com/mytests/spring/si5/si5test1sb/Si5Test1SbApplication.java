package com.mytests.spring.si5.si5test1sb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.channel.QueueChannel;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.PollableChannel;

@SpringBootApplication
@IntegrationComponentScan
public class Si5Test1SbApplication implements CommandLineRunner {

    //  IDEA-195423 Spring Integration: gutter icon for @IntegrationComponentScan annotation displays 'no beans found'; scanned @MessagingGateway interfaces are not recognized as beans
    @Autowired
    MyGateway myGateway;
    
    @Autowired
    MessageComponent messageComponent;
   @Autowired
    ApplicationContext ctx;

    public static void main(String[] args) {
        SpringApplication.run(Si5Test1SbApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        myGateway.process(messageComponent.getMessage());
        PollableChannel ch1 = ctx.getBean("channel1",PollableChannel.class);
        Message<?> mess = ch1.receive(0);
        System.out.println("**********************************");
        System.out.println(mess != null ? mess.getPayload() : "hmm...");
        System.out.println("**********************************");
    }

    @Bean
    public PollableChannel channel1() {
        return new QueueChannel();
    }

    @Bean
    public MessageChannel channel2() {
        return new DirectChannel();
    }
}
