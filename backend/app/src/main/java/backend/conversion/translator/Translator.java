package main.java.backend.conversion.translator;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.io.File;
import main.java.backend.conversion.Token;

public class Translator {
    
    public HashMap<String, Token> java_keywords = new HashMap<>();
    public HashMap<String, Token> java_symbols =  new HashhMap<>();


    public Translator()
    {
        initializeJavaKeywords();

        for(Token token : java_keywords.values()) {
            System.out.println(token);
        }
    }

    private void initializeJavaKeywords() 
    {   
        try{

            File keywordsFile = new File("./src/main/java/backend/parser/java_keywords.txt");
            FileInputStream keywordsInput = new FileInputStream(keywordsFile);

            Scanner scanner = new Scanner(keywordsInput);

            while (scanner.hasNext())
            {
                Token newKeywordToken = new Token(scanner.next(), TokenType.KEYWORD);
                this.java_keywords.put(newKeywordToken.getRawName(), newKeywordToken);
            }

            scanner.close();
            keywordsInput.close();
        }
        catch(Exception e)
        {
            System.out.println("Current Working Directory: " + System.getProperty("user.dir"));
            System.out.println(e);
        }
        
        
        
    }

}
