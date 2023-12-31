package main.java.backend.conversion.translator;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.io.File;
import main.java.backend.conversion.Token;
import main.java.backend.conversion.TokenType;

public class Translator {
    
    private HashMap<String, Token> java_keywords = new HashMap<>();
    private HashMap<String, Token> java_symbols =  new HashMap<>();
    private HashMap<String, Token> java_primitives = new HashMap<>();

    public ArrayList<Token> tokenizedFile = new ArrayList();

    public Translator()
    {
        initializeHashMap("java_keywords.txt", this.java_keywords);
        initializeHashMap("java_symbols.txt", this.java_symbols);
        initializeHashMap("java_primitives.txt", this.java_primitives);

    }

    private void initializeHashMap(String fileName, HashMap<String, Token> mapToFill) 
    {   
        try{
            StringBuilder sb = new StringBuilder();
            sb.append("./src/main/java/backend/conversion/translator/").append(fileName);
            File file = new File(sb.toString());
            FileInputStream input = new FileInputStream(file);

            Scanner scanner = new Scanner(input);

            while (scanner.hasNext())
            {

                if(fileName.equals("java_keywords.txt"))
                {
                    Token newToken = new Token(scanner.next(), TokenType.KEYWORD);
                    
                    mapToFill.put(newToken.getRawName(), newToken);
                }
                else if(fileName.equals("java_symbols.txt"))
                {
                    Token newToken = new Token(scanner.next(), TokenType.SYMBOL);
                    
                    mapToFill.put(newToken.getRawName(), newToken);
                }
                else if(fileName.equals("java_primitives.txt"))
                {
                    Token newToken = new Token(scanner.next(), TokenType.PRIMITIVE);
                    
                    mapToFill.put(newToken.getRawName(), newToken);
                }
                    
            }
            scanner.close();
            input.close();
        }
        catch(Exception e)
        {
            System.out.println("Current Working Directory: " + System.getProperty("user.dir"));
            System.out.println(e);
        }
    }

    public void convertRawTokens(ArrayList<String> rawTokens)
    {
        for(String rawToken : rawTokens)
        {
            if(this.java_keywords.containsKey(rawToken))
            {
                tokenizedFile.add(this.java_keywords.get(rawToken));
            }
            else if(this.java_symbols.containsKey(rawToken))
            {
                tokenizedFile.add(this.java_symbols.get(rawToken));
            }
            else if(this.java_primitives.containsKey(rawToken))
            {
                tokenizedFile.add(this.java_primitives.get(rawToken));
            }
            else
            {
                tokenizedFile.add(new Token(rawToken, TokenType.USER_DEFINED));
            }
        }


        for(int i = 0; i < tokenizedFile.size(); i++)
        {
            if(tokenizedFile.get(i).getRawName().equals("class"))
            {
            
                tokenizedFile.get(i + 1).setTokenType(TokenType.CLASS);
                
            }
        }
    }

}
