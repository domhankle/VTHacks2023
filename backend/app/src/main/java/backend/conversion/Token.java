package main.java.backend.conversion;

import java.lang.String;
import main.java.backend.conversion.TokenType;

public class Token {

    private String rawName;
    private String tokenName;
    private TokenType type;

    public Token()
    {
        this.rawName = "";
        this.tokenName = "invalid";
        this.type = TokenType.INVALID;
    }

    public Token(String aRawName, TokenType aType)
    {
        this.rawName = aRawName;
        this.type = aType;
        this.tokenName = getCompleteTokenName();

    }

    public void setRawName(String newRawName)
    {
        this.rawName = newRawName;
    }

    public String getRawName(){
        return this.rawName;
    }

    public void createTokenName()
    {
       this.tokenName = getCompleteTokenName();
    }

    private String getCompleteTokenName()
    {
        StringBuilder sb = new StringBuilder();

        switch(this.type)
        {
            case KEYWORD:
                sb.append("keyword_").append(this.rawName);
                break;
            case SYMBOL:
                sb.append("symbol_").append(this.rawName);
                break;
            case VARIABLE_NAME:
                sb.append("variable_").append(this.rawName);
                break;
            case FUNCTION_NAME:
                sb.append("function_").append(this.rawName);
                break;
            case PRIMITIVE:
                sb.append("primitive_").append(this.rawName);
                break;
            case INVALID:
                sb.append("invalid_").append(this.rawName);
                break;
            default:
                break;
        }

        return sb.toString();
    }

    @Override
    public String toString()
    {
        return this.getCompleteTokenName();
    }

    // @Override
    // public boolean equals(Object obj)
    // {
    //     if(!(obj instanceof Token))
    //     {
    //         return false;
    //     }

        
    //     return this.type.equals(obj.type);
    // }


    @Override
    public int hashCode()
    {
        return this.type.hashCode() + this.rawName.hashCode();
    }
}
