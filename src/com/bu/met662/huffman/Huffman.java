package com.bu.met662.huffman;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/** This class implements the huffman encoding. */
public class Huffman {

  public static void encode(Node root, String str, Map<Character, String> huffmanCode) {
    if (root == null) {
      return;
    }

    // Found a leaf node
    if (isLeaf(root)) {
      huffmanCode.put(root.ch, str.length() > 0 ? str : "1");
    }

    encode(root.left, str + '0', huffmanCode);
    encode(root.right, str + '1', huffmanCode);
  }

  // Traverse the Huffman Tree and decode the encoded string
  public static int decode(Node root, int index, StringBuilder sb) {
    if (root == null) {
      return index;
    }

    // Found a leaf node
    if (isLeaf(root)) {
      System.out.print(root.ch);
      return index;
    }

    index++;

    root = (sb.charAt(index) == '0') ? root.left : root.right;
    index = decode(root, index, sb);
    return index;
  }

  // Utility function to check if Huffman Tree contains only a single node
  public static boolean isLeaf(Node root) {
    return root.left == null && root.right == null;
  }

  // Builds Huffman Tree and decodes the given input text
  public static Object[] buildHuffmanTree(String text) {
    // Base case: empty string
    if (text == null || text.length() == 0) {
      return null;
    }

    // Count the frequency of appearance of each character
    // and store it in a map

    Map<Character, Integer> freq = new HashMap<>();
    for (char c : text.toCharArray()) {
      freq.put(c, freq.getOrDefault(c, 0) + 1);
    }

    // create a priority queue to store live nodes of the Huffman tree.
    // Notice that the highest priority item has the lowest frequency

    PriorityQueue<Node> pq;
    pq = new PriorityQueue<>(Comparator.comparingInt(l -> l.freq));

    // create a leaf node for each character and add it
    // to the priority queue.

    for (Map.Entry<Character, Integer> entry : freq.entrySet()) {
      pq.add(new Node(entry.getKey(), entry.getValue()));
    }

    // do till there is more than one node in the queue
    while (pq.size() != 1) {
      // Remove the two nodes of the highest priority
      // (the lowest frequency) from the queue

      Node left = pq.poll();
      Node right = pq.poll();

      // create a new internal node with these two nodes as children
      // and with a frequency equal to the sum of both nodes'
      // frequencies. Add the new node to the priority queue.

      int sum = left.freq + right.freq;
      pq.add(new Node(null, sum, left, right));
    }

    // `root` stores pointer to the root of Huffman Tree
    Node root = pq.peek();

    // Traverse the Huffman tree and store the Huffman codes in a map
    Map<Character, String> huffmanCode = new HashMap<>();
    encode(root, "", huffmanCode);

    Object[] obj = new Object[3];
    // Print the Huffman codes

    obj[0] = root;
    obj[1] = huffmanCode;

    return obj;
  }
}
