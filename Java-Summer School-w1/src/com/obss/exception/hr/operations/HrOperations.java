package com.obss.exception.hr.operations;

import com.obss.exception.hr.entity.Kisi;
import com.obss.exception.hr.exception.DbException;
import com.obss.exception.hr.exception.HrException;

import java.util.List;

public class HrOperations {

    public static List<Kisi> enrichKisiList() {
        try {
            List<Kisi> kisiListfromDB = DbOperations.getKisiListfromDB();

            for (Kisi kisi : kisiListfromDB) {
                if (kisi.getExperience() == 0) {
                    kisi.setSalary(1000.0);
                } else if (kisi.getExperience() == 1) {
                    kisi.setSalary(2000.0);
                } else if (kisi.getExperience() > 1) {
                    kisi.setSalary(3000.0);
                } else {
                    throw new RuntimeException("Beklenmedik bir hata olustu! İlgili kisi tecrübesi tanımlanamadı!");
                }
            }
            return kisiListfromDB;
        } catch (DbException ex) {
            throw new HrException("HR operations'da DB'de hata olustu!", ex);
        } catch (Exception ex) {
            throw new HrException("HR Operations'da beklenmedik hata olustu", ex);
        }
    }


}
