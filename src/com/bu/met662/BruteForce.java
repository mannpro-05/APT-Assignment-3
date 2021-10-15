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

/** This class uses the BruteForce algorithm to search a keyword. */
public class BruteForce {

    ArrayList<Integer> countCondition = new ArrayList<>(Arrays.asList(10, 50, 100, 200, 300, 400, 500, 600, 700, 800, 900, 1000));
    private String keyword;
    //This method searches the keyword.
    public void searchKeyword() {
        try {
            final FileWriter csvWriter = new FileWriter(Constants.PLOTTING_BRUTE_FORCE_CSV_FILE_NAME);
            for (Integer i : countCondition) {
                BufferedReader br = new BufferedReader(new FileReader(Constants.FILE_PATH));
                String line;
                Instant start = Instant.now();

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
