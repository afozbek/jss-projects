package com.obss.exception.hr.operations;

import com.obss.exception.hr.entity.Kisi;
import com.obss.exception.hr.scenario.HrScenario;

import java.util.List;
import java.util.logging.Logger;

public class SalaryScenario {
    private final static Logger LOGGER = Logger.getLogger(SalaryScenario.class.getName());

    public static void main(String[] args) {
        LOGGER.warning("deneme");
        try {
            List<Kisi> kisiler = HrOperations.enrichKisiList();

            System.out.println("DB'den gelen kisilerin maaslari hesaplanip asagida listelenmistir");

            for (Kisi kisi : kisiler) {
                System.out.println(kisi);
            }
        } catch(Exception ex) {
            LOGGER.severe(ex.getMessage());
            ex.printStackTrace();
        }
    }
}
