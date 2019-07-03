package app;

import beans.implementation.FileCustomerLogger;
import beans.implementation.MemoryCustomerRepository;
import beans.implementation.SimpleCustomerLogger;
import beans.model.Customer;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {

        //Zadanie 2 Dzień 1
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
//        SimpleCustomerLogger simpleCustomerLogger = (SimpleCustomerLogger) context.getBean("simpleCustomerLogger");
//        simpleCustomerLogger.log();

        //Zadanie 3 Dzień 1
//        MemoryCustomerRepository memoryCustomerRepository = (MemoryCustomerRepository) context.getBean("memoryCustomerRepository");
        Customer customer = (Customer) context.getBean("customer");
//        memoryCustomerRepository.add(customer);
//        System.out.println(memoryCustomerRepository.readAll().isEmpty());

        //Zadanie 4 Dzień 1
//        FileCustomerLogger fileCustomerLogger = (FileCustomerLogger) context.getBean("fileCustomerLogger");
//        fileCustomerLogger.log();
        MemoryCustomerRepository memoryCustomerRepository = (MemoryCustomerRepository) context.getBean("memoryCustomerRepository");
        memoryCustomerRepository.add(customer);
        memoryCustomerRepository.readAll();
        memoryCustomerRepository.delete(0);
    }

}
