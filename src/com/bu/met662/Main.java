package com.bu.met662;

import charts.BruteForceChart;
import charts.LuceneChart;

import java.io.IOException;

/**
 * All the objects for the classes are declared over here.
 * This class creates the line charts for time consumed by each algorithm for given records.
 */
public class Main {
    public static void main(String[] args) throws IOException {
	    BruteForce bruteForce = new BruteForce();
        bruteForce.setKeyword("robot");
        bruteForce.searchKeyword();
        LuceneSearch luceneSearch = new LuceneSearch("robot");
        luceneSearch.luceneSearch();

        //This creates chart for brute force algorithm with robot as the search keyword.
        BruteForceChart bruteForceChart = new BruteForceChart(
                "Time vs Number of records Brute Force for Keyword robot" ,
                "Time vs Number of records Brute Force for Keyword robot");

        bruteForceChart.pack();
        //This to display the chart.
        bruteForceChart.setVisible( true );

        //This creates chart for lucene algorithm with robot as the search keyword.
        LuceneChart luceneChart = new LuceneChart(
                "Time vs Number of records Lucene for Keyword robot" ,
                "Time vs Number of records Lucene for Keyword robot"
        );
        luceneChart.pack();
        //This to display the chart.
        luceneChart.setVisible(true);

        //This creates chart for brute force algorithm with wearable as the search keyword.
        BruteForce bruteForceWearable = new BruteForce();
        bruteForceWearable.setKeyword("wearable");
        bruteForceWearable.searchKeyword();

        LuceneSearch luceneSearchWearable = new LuceneSearch("wearable");
        luceneSearchWearable.luceneSearch();

        //This creates chart for brute force algorithm with wearable as the search keyword.
        BruteForceChart bruteForceChartWearable = new BruteForceChart(
                "Time vs Number of records Brute Force for Keyword Wearable" ,
                "Time vs Number of records Brute Force for Keyword Wearable");

        bruteForceChartWearable.pack();
        //This to display the chart.
        bruteForceChartWearable.setVisible( true );
        //This creates chart for lucene algorithm with wearable as the search keyword.
        LuceneChart luceneChartWearable = new LuceneChart(
                "Time vs Number of records Lucene for Keyword Wearable" ,
                "Time vs Number of records Lucene for Keyword Wearable"
        );
        luceneChartWearable.pack();
        //This to display the chart.
        luceneChartWearable.setVisible(true);

    }
}
