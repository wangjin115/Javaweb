package com.wj.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author wj
 * @version 1.0
 */
@Configuration
@ComponentScan({"com.wj.controller","com.wj.config"} )
@EnableWebMvc
public class SpringMvcConfig {
}
