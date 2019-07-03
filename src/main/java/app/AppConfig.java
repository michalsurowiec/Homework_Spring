package app;

import beans.implementation.FileCustomerLogger;
import beans.implementation.MemoryCustomerRepository;
import beans.implementation.SimpleCustomerLogger;
import beans.interfaces.CustomerLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("beans.*")
public class AppConfig {


    /*Poniższe beany nawiązują do Zadania 4. Nie potrafią pojąć, jak z wykorzystaniem ComponentScan wstawić stringa do
    konstruktora FileCustomerLogger, więc postanowiłem przekazać to zadanie beanom.
     */

    @Bean
    FileCustomerLogger fileCustomerLogger(){
        return new FileCustomerLogger("bean_Name");
    }

    @Bean
    MemoryCustomerRepository memoryCustomerRepository(){
        return new MemoryCustomerRepository(fileCustomerLogger());
    }


}
