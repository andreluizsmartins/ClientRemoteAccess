package br.com.sankhya.Application;

import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.jcraft.jsch.Session;

@Configuration
public class BeanConfiguration {

    @Bean
    public Map<String, Session> connectionMap(){
       java.util.Map<String,  Session> map = new java.util.HashMap<String, Session>();
       
       return map;
    }
    
}
