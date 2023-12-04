package com.modern.spring;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {

        ApplicationContext applicationContext = SpringApplication.run(Application.class, args);
        int result = applicationContext.getBean(BinarySearchImpl.class).binarySearch(new int[]{12, 3, 6}, 3);
        System.out.println("result: " + result);
    }

}
