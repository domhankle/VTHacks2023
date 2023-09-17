package main.java.backend.conversion.parser;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.lang.String;
import java.util.Scanner;


public class Parser {
    public ArrayList<String> parse(String fileString) {
        
        return digest(fileString, " ");

    }

    private ArrayList<String> digest(String tok, String delim) {
        Scanner scanner = new Scanner(tok);
        if (!delim.equals(" ")) {
            scanner.useDelimiter("\\" + delim);
        }
        ArrayList<String> tokList = new ArrayList<>();
        String curr;

        while(scanner.hasNext()) {
            curr = scanner.next();

            // Check for invalid token and add
            if (curr.length() != 1 && curr.matches(".*[\\p{Punct}].*")) {

                for (int i = 0; i<curr.length(); i++) {
                    char c = curr.charAt(i);
                    if (!Character.isLetterOrDigit(c) && !Character.isWhitespace(c) && !Character.isJavaIdentifierPart(c)) {
                        tokList.addAll(digest(curr, Character.toString(c)));
                        break;
                    }
                }

            } else {
                tokList.add(curr);
            }

            // Add delim
            if (delim != " " && scanner.hasNext()) {
                tokList.add(delim);
            }
        }

        return tokList;
    }

    private String readFileToString(String filePath) {
        try {
            // Convert the file path string to a Path object
            Path path = Paths.get(filePath);

            // Use Files.readAllBytes to read the file content into a byte array
            byte[] fileBytes = Files.readAllBytes(path);

            // Convert the byte array to a String using UTF-8 encoding (adjust as needed)
            return new String(fileBytes, StandardCharsets.UTF_8);
        } catch (IOException e) {
            System.out.println(e);
            return "";
        }
    }

}
