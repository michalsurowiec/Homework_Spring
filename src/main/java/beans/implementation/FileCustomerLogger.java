package beans.implementation;

import beans.interfaces.CustomerLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
@Primary
public class FileCustomerLogger implements CustomerLogger {
    private String filename;

    @Autowired
    public FileCustomerLogger(String filename) {
        this.filename = filename;
    }

    public FileCustomerLogger() {
        this.filename = "component_scan";
    }

    @Override
    public void log() {
        Path path = Paths.get("src/main/java/app/" + this.filename + ".txt");
        if (!Files.exists(path)) {
            try {
                Files.createFile(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        List<String> input = new ArrayList<>();
        input.add(new Date() + ": Customer operation");
        try {
            Files.write(path, input, StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
