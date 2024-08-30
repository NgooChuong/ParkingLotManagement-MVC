/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.qlbdx.configs;

import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.OAuthTokenCredential;
import com.paypal.base.rest.PayPalRESTException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

/**
 *
 * @author quang
 */
@Configuration
@PropertySource("classpath:paypal.properties")

public class PayPalConfig {

    private final String clientId = "AUhq7P-LSB-Zccp3Q4iBfdoeksP1iqRrjHa6kPgshLJu6tV4nLzapM2JGrLw3sHjowIybHlZRW2WSeiB";
    private final String clientSecret = "EMf2p7HKiNp5Y5FvLDPWYHhfkOAaxNQJhIvo61U0ud4YLIqnbt2kvjaIYJk_ebNLTQ9cKYKNVdHVYGvy";
    private final String mode = "sandbox";

     @Bean
    public APIContext apiContext() {
        return new APIContext(clientId, clientSecret, mode);
    }

}
