package com.bu.met662;

import charts.BruteForceChart;
import charts.HuffmanChart;
import charts.LuceneChart;
import com.bu.met662.huffman.HuffmanSearch;

import java.io.IOException;

/**
 * All the objects for the classes are declared over here. This class creates the line charts for
 * time consumed by each algorithm for given records.
 */
public class Main {
  public static void main(String[] args) throws IOException {

    // These are the objects for searching the robot keyword.
    BruteForce bruteForce = new BruteForce();
    bruteForce.setKeyword("robot");
    bruteForce.searchKeyword();
    LuceneSearch luceneSearch = new LuceneSearch("robot");
    luceneSearch.luceneSearch();
    HuffmanSearch huffmanSearch = new HuffmanSearch("robot");
    huffmanSearch.huffmanSearch();

    // This creates chart for brute force algorithm with robot as the search keyword.
    BruteForceChart bruteForceChart =
        new BruteForceChart(
            "Time vs Number of records Brute Force for Keyword robot",
            "Time vs Number of records Brute Force for Keyword robot");

    bruteForceChart.pack();
    // This to display the chart.
    bruteForceChart.setVisible(true);

    // This creates chart for lucene algorithm with robot as the search keyword.
    LuceneChart luceneChart =
        new LuceneChart(
            "Time vs Number of records Lucene for Keyword robot",
            "Time vs Number of records Lucene for Keyword robot");
    luceneChart.pack();
    // This to display the chart.
    luceneChart.setVisible(true);

    // This creates chart for Huffman algorithm with robot as the search keyword.
    HuffmanChart huffmanChartRobot =
        new HuffmanChart(
            "Time vs Number of records Huffman for Keyword Wearable",
            "Time vs Number of records Huffman for Keyword Robot");
    huffmanChartRobot.pack();
    huffmanChartRobot.setVisible(true);

    // These are the objects for searching the wearable keyword.
    BruteForce bruteForceWearable = new BruteForce();
    bruteForceWearable.setKeyword("wearable");
    bruteForceWearable.searchKeyword();

    LuceneSearch luceneSearchWearable = new LuceneSearch("wearable");
    luceneSearchWearable.luceneSearch();

    HuffmanSearch huffmanSearchWearable = new HuffmanSearch("wearable");
    huffmanSearchWearable.huffmanSearch();


    // This creates chart for brute force algorithm with wearable as the search keyword.
    BruteForceChart bruteForceChartWearable =
        new BruteForceChart(
            "Time vs Number of records Brute Force for Keyword Wearable",
            "Time vs Number of records Brute Force for Keyword Wearable");
    bruteForceChartWearable.pack();
    // This to display the chart.
    bruteForceChartWearable.setVisible(true);



    // This creates chart for lucene algorithm with wearable as the search keyword.
    LuceneChart luceneChartWearable =
        new LuceneChart(
            "Time vs Number of records Lucene for Keyword Wearable",
            "Time vs Number of records Lucene for Keyword Wearable");
    luceneChartWearable.pack();
    // This to display the chart.
    luceneChartWearable.setVisible(true);


    // This creates chart for Huffman algorithm with wearable as the search keyword.
    HuffmanChart huffmanChartWearable =
        new HuffmanChart(
            "Time vs Number of records Huffman for Keyword Wearable",
            "Time vs Number of records Huffman for Keyword Wearable");
    huffmanChartWearable.pack();
    huffmanChartWearable.setVisible(true);
  }
}
