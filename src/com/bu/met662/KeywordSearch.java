package com.bu.met662;


import constants.Constants;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class KeywordSearch {

//    int counter = 0;
    ArrayList<Integer> countCondition = new ArrayList<>(Arrays.asList(10, 50, 100, 200, 300, 400, 500, 600, 700, 800, 900, 1000));
    private String keyword;

    public void searchKeyword() {
        try {
            final FileWriter csvWriter = new FileWriter(Constants.PLOTTING_CSV_FILE_NAME);
            csvWriter.append("time,records");
            csvWriter.append("\n");
            for (Integer i : countCondition) {
                BufferedReader br = new BufferedReader(new FileReader(Constants.FILE_PATH));
                String line;
//                counter = 0;
                Instant start = Instant.now();
//                while ((line = br.readLine()) != null && counter <= i) {
//                    if (line.contains(this.keyword)) {
//                        TimeUnit.MILLISECONDS.sleep(1);
//                    }
//                    counter++;
//                }

                for (int ctr = 0; (line = br.readLine()) != null && ctr <= i; ctr++) {
                    if (line.contains(this.keyword)) {
                        TimeUnit.MILLISECONDS.sleep(1);
                    }
                }

                Instant end = Instant.now();
                long timeElapsed = Duration.between(start, end).toNanos();
                System.out.println(timeElapsed + " " + timeElapsed + "," + i);
                csvWriter.append(timeElapsed / 1000 + "," + i);
                csvWriter.append("\n");
            }
            csvWriter.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
}
