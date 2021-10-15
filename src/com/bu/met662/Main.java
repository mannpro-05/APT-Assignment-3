package com.bu.met662;

import charts.BruteForceChart;
import charts.LuceneChart;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
	    BruteForce bruteForce = new BruteForce();
        bruteForce.setKeyword("robot");
        bruteForce.searchKeyword();
        LuceneSearch luceneSearch = new LuceneSearch("robot");
        luceneSearch.luceneSearch();
        BruteForceChart bruteForceChart = new BruteForceChart(
                "Time vs Number of records Brute Force for Keyword robot" ,
                "Time vs Number of records Brute Force for Keyword robot");

        bruteForceChart.pack();
        bruteForceChart.setVisible( true );

        LuceneChart luceneChart = new LuceneChart(
                "Time vs Number of records Lucene for Keyword robot" ,
                "Time vs Number of records Lucene for Keyword robot"
        );
        luceneChart.pack();
        luceneChart.setVisible(true);
        BruteForce bruteForceWearable = new BruteForce();
        bruteForceWearable.setKeyword("wearable");
        bruteForceWearable.searchKeyword();
        LuceneSearch luceneSearchWearable = new LuceneSearch("wearable");
        luceneSearchWearable.luceneSearch();
        BruteForceChart bruteForceChartWearable = new BruteForceChart(
                "Time vs Number of records Brute Force for Keyword Wearable" ,
                "Time vs Number of records Brute Force for Keyword Wearable");

        bruteForceChartWearable.pack();
        bruteForceChartWearable.setVisible( true );

        LuceneChart luceneChartWearable = new LuceneChart(
                "Time vs Number of records Lucene for Keyword Wearable" ,
                "Time vs Number of records Lucene for Keyword Wearable"
        );
        luceneChartWearable.pack();
        luceneChartWearable.setVisible(true);

    }
}
