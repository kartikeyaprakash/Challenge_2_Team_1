package com.cg.app;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import com.cg.app.entities.City;
import com.cg.app.entities.Theatre;
import com.cg.app.service.TheaterService;
import com.cg.app.service.impl.TheaterServiceImpl;
import com.cg.app.util.TheaterUtil;

import au.com.bytecode.opencsv.CSVReader;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
    	 BufferedReader reader = Files.newBufferedReader(Paths.get("input1.csv"));
    	// BufferedReader reader = new BufferedReader(new InputStreamReader (new FileInputStream("input.csv"),Charset.forName("windows-1250")));
         CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withHeader("cityName", "theatreName", "movieName", "actors", "movieRating").withIgnoreHeaderCase().withTrim());
         
         
         Map<String, Set<String>> cityToTheatres = new HashMap<>();
         Map<String, Set<String>> theatresToMovies = new HashMap<>();
         Map<String, String> moviesToActors = new HashMap<>();
         Map<String, String> moviesToRating = new HashMap<>();


         for (CSVRecord csvRecord: csvParser) {
        	 
        	 if(csvRecord.getRecordNumber()==1)
        		 continue;

             // Accessing Values by Column Index
             String cityName = csvRecord.get(0);
             //Accessing the values by column header name
             String theatreName = csvRecord.get("theatreName");
             String movieName = csvRecord.get("movieName");
             String actors = csvRecord.get("actors");
             String movieRating  = csvRecord.get("movieRating");
             
             if(!cityToTheatres.containsKey(cityName))
             {           	 
            	cityToTheatres.put(cityName, new HashSet<>());
             }
             
             Set<String> theatres = cityToTheatres.get(cityName);
             theatres.add(theatreName);
             cityToTheatres.put(cityName, theatres);
             
             
             if(!theatresToMovies.containsKey(theatreName))
             {           	 
            	 theatresToMovies.put(theatreName, new HashSet<>());
             }
             
             Set<String> movies = theatresToMovies.get(theatreName);
             movies.add(movieName);
             theatresToMovies.put(theatreName, movies);
             
            
             moviesToActors.put(movieName, actors);
             moviesToRating.put(movieName, movieRating);

             

             //Printing the record 
             System.out.println("Record Number - " + csvRecord.getRecordNumber());
             System.out.println("City Name : " + cityName);
             System.out.println("Theatre Name : " + theatreName);
             System.out.println("Movie Name : " + movieName);
             System.out.println("Actor Names : " + actors);
             System.out.println("Movie Rating: " + movieRating);
            
             System.out.println("\n\n");
             
             
             
         }
    	
         
         System.out.println("\n\nMAPS TEST");
         for(Map.Entry<String, Set<String>> entry: cityToTheatres.entrySet())
         {
        	 System.out.println("\nCity: "+ entry.getKey());
        	 List<Theatre> theatresInCity = new ArrayList<>();
        	 for(String val: entry.getValue())
        	 {
            	 System.out.println("Theatre: "+ val);
            	 Theatre theatre = new Theatre();
        	 }
        	 
        	 City city = new City();
        	 city.setName(entry.getKey());
        	 
         }
         
         for(Map.Entry<String, Set<String>> entry: theatresToMovies.entrySet())
         {
        	 System.out.println("\nTheatre: "+ entry.getKey());
        	 for(String val: entry.getValue())
        	 {
            	 System.out.println("Movie: "+ val);
        	 }
         }
         
         
         for(Map.Entry<String, String> entry: moviesToActors.entrySet())
         {
        	 System.out.println("\nMovie: "+ entry.getKey());
             System.out.println("Actors: "+ entry.getValue());
        	 
         }
         
         for(Map.Entry<String, String> entry: moviesToRating.entrySet())
         {
        	 System.out.println("\nMovie: "+ entry.getKey());
             System.out.println("Rating: "+ entry.getValue());
        	 
         }
         
//    	 String[] HEADERS = {"cityName", "theatrName", "movieName", "actors", "movieRating"};
//    	  Reader in = new FileReader("input1.csv");
//    	    Iterable<CSVRecord> records = CSVFormat.DEFAULT
//    	      .withHeader(HEADERS)
//    	      .withFirstRecordAsHeader()
//    	      .parse(in);
//    	    for (CSVRecord record : records) {
//    	        String cityName = record.get("cityName");
//    	        String theatreName = record.get("theatreName");
//    	        String actors = record.get("actors");
//              System.out.println("City Name : " + cityName);
//              System.out.println("Theatre Name : " + theatreName);
//              System.out.println("Actor Names : " + actors);
//
//    	        
//    	    }
//    	
    	
//    	
//    	  CSVReader reader = new CSVReader(new FileReader("input1.csv"), ',', '"', 1);
//          
//          //Read all rows at once
//          List<String[]> allRows = reader.readAll();
//           
//          //Read CSV line by line and use the string array as you want
//         for(String[] row : allRows){
//            System.out.println(Arrays.toString(row));
//         }
         
         
         //Theater 
         System.out.println("#################################");
         TheaterUtil util = new TheaterUtil();
         TheaterService ts = new TheaterServiceImpl(util.csvUtil());
         String[] city = {"c1", "c2"};
         for(String str : city) {
        	
        	 for(Theatre t : ts.getTheaterByCity(str)) {
        		 System.out.println("Theater: "+t.getName());
        		 System.out.println("Movies : "+t.getMovies());
        		 
        	 }
         }
         
         
        // System.out.println(ts.getTheaterByCity("c1"));
    }
    
    
   
    
    
}
