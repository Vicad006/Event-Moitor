package com.vicad.loader;


import com.vicad.service.LoadExcel;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private LoadExcel loadExcel;

    public DataLoader(LoadExcel loadExcel) {
        this.loadExcel = loadExcel;
    }

    @Override
    public void run(String... args) throws Exception {



          loadExcel.loadExternalData();




    }
}
