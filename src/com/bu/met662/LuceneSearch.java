package com.bu.met662;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import constants.Constants;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.FSDirectory;

public class LuceneSearch {

    ArrayList<Integer> countCondition = new ArrayList<>(Arrays.asList(10, 50, 100, 200, 300, 400, 500, 600, 700, 800, 900, 1000));
    String keyword;
    public LuceneSearch(String keyword){
        this.keyword = keyword;

    }
    public void luceneSearch(){
        try {
            final FileWriter csvWriter = new FileWriter(Constants.PLOTTING_LUCENE_CSV_FILE_NAME);
            // 0. Specify the analyzer for tokenizing text.  The same analyzer should be used for indexing and searching
            StandardAnalyzer analyzer = new StandardAnalyzer();

            // 1. create the index
            //Directory index = new Directory(Files.createTempDirectory("XXXXX"));
            //Directory index = new ByteBuffersDirectory();
            FSDirectory index = FSDirectory.open(Paths.get("C:\\Users\\mannp\\IdeaProjects\\APT-Assignment-3\\test.txt"));

            IndexWriterConfig config = new IndexWriterConfig(analyzer);
            IndexWriter w = new IndexWriter(index, config);
            // 2. query
            String querystr = this.keyword; //

            // the "title" arg specifies the default field to use
            // when no field is explicitly specified in the query.
            Query q = new QueryParser("wearable", analyzer).parse(querystr);

            for (Integer i : countCondition) {
                BufferedReader br = new BufferedReader(new FileReader(Constants.FILE_PATH));
                String line;

                for (int ctr = 0; (line = br.readLine()) != null && ctr <= i; ctr++) {
                    addDoc(w, line,String.valueOf(ctr));
                }
                w.commit();
                Instant start = Instant.now();
                int hitsPerPage = 10;
                IndexReader reader = DirectoryReader.open(index);
                IndexSearcher searcher = new IndexSearcher(reader);
                TopDocs docs = searcher.search(q, hitsPerPage);
                ScoreDoc[] hits = docs.scoreDocs;

                Instant end = Instant.now();
                long timeElapsed = Duration.between(start, end).toMillis();
                csvWriter.append(timeElapsed+ "," + i);
                csvWriter.append("\n");
            }
            csvWriter.close();
            w.close();

        } catch(IOException ex){
            ex.printStackTrace();
        } catch (ParseException ex2) {
            ex2.printStackTrace();
        }
    }

    private static void addDoc(IndexWriter w, String title, String isbn) throws IOException {
        Document doc = new Document();
        doc.add(new TextField("title", title, Field.Store.YES));
        // use a string field for isbn because we don't want it tokenized
        doc.add(new StringField("isbn", isbn, Field.Store.YES));
        w.addDocument(doc);
    }


}
