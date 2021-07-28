package com.example.demoonetoone;

import com.example.demoonetoone.entities.Address;
import com.example.demoonetoone.entities.Customer;
import com.example.demoonetoone.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
public class DemoOneToOneApplication implements CommandLineRunner {

    @Autowired
    private CustomerService customerService;

    public static void main(String[] args) {
        SpringApplication.run(DemoOneToOneApplication.class, args);
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        customerService.saveData();


        Address address=customerService.findAddressById(1);
        Customer customer=address.getCustomer();

        System.out.println(String.format("%s lives in %s .",customer.getName(),address.getStreetName()));
    }
}
