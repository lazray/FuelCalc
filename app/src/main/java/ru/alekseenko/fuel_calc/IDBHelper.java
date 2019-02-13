package ru.alekseenko.fuel_calc;

import java.util.List;

public interface IDBHelper {

        public void addRashod(Rashod rashod);
        public Rashod getRashod(String RASHOD_ID);
        public List<Rashod> getAllRashod();
        public int getRashodCount();
        public int updateRashod(Rashod rashod);
        public void deleteRashod(Rashod rashod);
        public void deleteAll();
    }

