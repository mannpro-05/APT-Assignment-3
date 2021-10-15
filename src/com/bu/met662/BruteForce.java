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

public class BruteForce {

//    int counter = 0;
    ArrayList<Integer> countCondition = new ArrayList<>(Arrays.asList(10, 50, 100, 200, 300, 400, 500, 600, 700, 800, 900, 1000));
    private String keyword;

    public void searchKeyword() {
        try {
            final FileWriter csvWriter = new FileWriter(Constants.PLOTTING_BRUTE_FORCE_CSV_FILE_NAME);
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
                long timeElapsed = Duration.between(start, end).toMillis();
                csvWriter.append(timeElapsed + "," + i);
                csvWriter.append("\n");
            }
            csvWriter.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
}
