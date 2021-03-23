package com.mytests.spring.si5.si5test1sb;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * *******************************
 * Created by Irina.Petrovskaya on 7/11/2018.
 * Project: si5-test1-sb
 * *******************************
 */
@Component("JustComponent")
public class MessageComponent {

    @Value("Hello!!!!")
    String message;

    public String getMessage() {
        return message;
    }
}
