package beans.implementation;

import beans.interfaces.CustomerLogger;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class SimpleCustomerLogger implements CustomerLogger {
    @Override
    public void log() {
        System.out.println(new Date() + ": Customer operation");
    }
}
