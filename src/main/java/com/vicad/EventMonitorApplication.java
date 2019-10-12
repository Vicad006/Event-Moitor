package com.vicad;

import com.vicad.loader.DataLoader;
import com.vicad.model.Attendance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EventMonitorApplication {


    public static void main(String[] args) {
        SpringApplication.run(EventMonitorApplication.class, args);

        DataLoader dataLoader = new DataLoader();


        dataLoader.loadExcel();

    }

}
