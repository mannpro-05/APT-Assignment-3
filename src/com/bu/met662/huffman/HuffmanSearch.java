package com.bu.met662.huffman;

import constants.Constants;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

/** This class searches the given keyword by using the hoffman compression algo. */
public class HuffmanSearch {
  ArrayList<Integer> countCondition =
      new ArrayList<>(Arrays.asList(10, 50, 100, 200, 300, 400, 500, 600, 700, 800, 900, 1000));
  String keyword;

  // This constructor initializes the class variables.
  public HuffmanSearch(String keyword) {
    this.keyword = keyword;
  }

  // This method encodes the data and the keyword into huffman code and then searches it.
  public void huffmanSearch() throws IOException {
    BufferedReader br = new BufferedReader(new FileReader(Constants.FILE_PATH));
    String line, big = null;
    final FileWriter csvWriter = new FileWriter(Constants.PLOTTING_HUFFMAN_CSV_FILE_NAME);
    for (int i : countCondition) {

      for (int ctr = 0; (line = br.readLine()) != null && ctr <= i; ctr++) {
        big += line.toLowerCase();
      }
      Object[] obj = Huffman.buildHuffmanTree(big);
      Map<Character, String> code = (Map<Character, String>) obj[1];
      Instant start = Instant.now();
      StringBuilder keywordSb = new StringBuilder();
      for (char c : keyword.toCharArray()) {
        keywordSb.append(code.get(c));
      }
      StringBuilder lineSb = new StringBuilder();
      for (int ctr = 0; (line = br.readLine()) != null && ctr <= i; ctr++) {
        for (char c : line.toCharArray()) {
          lineSb.append(code.get(c));
        }
        if (lineSb.toString().contains(keywordSb.toString())) {}

        lineSb.setLength(0);
      }
      Instant end = Instant.now();
      long timeElapsed = Duration.between(start, end).toMillis();
      csvWriter.append(timeElapsed + "," + i);
      csvWriter.append("\n");
    }
    csvWriter.close();
  }
}
