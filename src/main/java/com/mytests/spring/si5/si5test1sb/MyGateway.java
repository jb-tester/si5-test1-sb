package com.mytests.spring.si5.si5test1sb;

import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;

/**
 * *******************************
 * Created by Irina.Petrovskaya on 7/11/2018.
 * Project: si5-test1-sb
 * *******************************
 */
@MessagingGateway(name = "mygateway")
public interface MyGateway {
    @Gateway(requestChannel = "channel1", replyChannel = "channel2")
    void process(String payload);
}
