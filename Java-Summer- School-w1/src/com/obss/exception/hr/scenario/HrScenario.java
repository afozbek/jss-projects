package com.obss.exception.hr.scenario;

import com.obss.exception.hr.entity.Kisi;
import com.obss.exception.hr.exception.HrException;
import com.obss.exception.hr.operations.HrOperations;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HrScenario {

    private final static Logger LOGGER = Logger.getLogger(HrScenario.class.getName());

private int instanceVariable;
    static {
        System.setProperty("java.util.logging.config.file",
                "/Users/seref.acet/IdeaProjects/JavaSummerSchool/src/com/obss/exception/hr/logging.properties");
    }
    public static void main(String args[]) {
       
        System.out.println(HrScenario.class.getClassLoader().getResource("logging.properties"));
        try {
            List<Kisi> kisiList = HrOperations.enrichKisiList();
            List<Kisi> filteredList = new ArrayList<Kisi>();

            for(Kisi kisi :kisiList){
                if(kisi.getExperience() > 1) {
                    filteredList.add(kisi);
                }
            }

            List<Kisi> collect = kisiList.stream().filter((kisi) -> kisi.getExperience() > 0).collect(Collectors.toList());


        } catch (HrException exception) {
            LOGGER.severe("HR kisileri DB'den cekilirken hata olustu");
            exception.printStackTrace();
            return;
        } catch (Exception ex) {
            LOGGER.severe("HR kisileri DB'den cekilirken beklenmedik olustu");
            return;
        }

        if (true) {
            System.out.println("Operation is successful!");
            // wait new requests
        }
    }
}
