package com.cg.app.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class FileUtils {
	
	public static Map<String, Set<String>> oneToMany(String arg1, String arg2) throws IOException
	{
		BufferedReader reader = Files.newBufferedReader(Paths.get("input1.csv"));
   	// BufferedReader reader = new BufferedReader(new InputStreamReader (new FileInputStream("input.csv"),Charset.forName("windows-1250")));
        CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withHeader("cityName", "theatreName", "movieName", "actors", "movieRating").withIgnoreHeaderCase().withTrim());
        
        Map<String, Set<String>> argsMapper = new HashMap<>();
        for (CSVRecord csvRecord: csvParser) {
       	 
       	 if(csvRecord.getRecordNumber()==1)
       		 continue;

            //Accessing the values by column header name
            String argProp1 = csvRecord.get(arg1);
            String argProp2 = csvRecord.get(arg2);

            
            if(!argsMapper.containsKey(argProp1))
            {           	 
            	argsMapper.put(argProp1, new HashSet<>());
            }
            
            Set<String> arg2Vals = argsMapper.get(argProp1);
            arg2Vals.add(argProp2);
            argsMapper.put(argProp1, arg2Vals);
            
            
        }
        return argsMapper;
	}
	
	public static Map<String, String> oneToOne(String arg1, String arg2) throws IOException
	{
		BufferedReader reader = Files.newBufferedReader(Paths.get("input1.csv"));
	   	// BufferedReader reader = new BufferedReader(new InputStreamReader (new FileInputStream("input.csv"),Charset.forName("windows-1250")));
	        CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withHeader("cityName", "theatreName", "movieName", "actors", "movieRating").withIgnoreHeaderCase().withTrim());
	        
	        Map<String, String> argsMapper = new HashMap<>();
	        
	        for (CSVRecord csvRecord: csvParser) {
	          	 
	          	 if(csvRecord.getRecordNumber()==1)
	          		 continue;

	               //Accessing the values by column header name
	               String argProp1 = csvRecord.get(arg1);
	               String argProp2 = csvRecord.get(arg2);	             
	               argsMapper.put(argProp1, argProp2);
	           }
	           return argsMapper;

	}

}
