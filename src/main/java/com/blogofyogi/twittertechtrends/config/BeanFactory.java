package com.blogofyogi.twittertechtrends.config;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Configuration
public class BeanFactory {

    @Autowired
    Environment environment;

}
