package main.java.backend.conversion;

import java.lang.String;
import main.java.backend.conversion.TokenType;

public class Token {

    private String rawName;
    public String tokenName;
    private TokenType type;

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

    public TokenType getType()
    {
        return this.type;
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
            case PRIMITIVE:
                sb.append("primitive_").append(this.rawName);
                break;
            case USER_DEFINED:
                sb.append("user_defined_").append(this.rawName);
                break;
            case CLASS:
                sb.append("class_").append(this.rawName);
                break;
            default:
                break;
        }

        return sb.toString();
    }

    public void setTokenType(TokenType newType)
    {
        this.type = newType;
        this.tokenName = this.getCompleteTokenName();
    }

    @Override
    public String toString()
    {
        return this.getCompleteTokenName();
    }

    @Override
    public int hashCode()
    {
        return this.type.hashCode() + this.rawName.hashCode();
    }

    @Override 
    public boolean equals(Object rhs) {
        if (type.equals(TokenType.USER_DEFINED)) {
            return type.equals(((Token) rhs).getType());
        } else {
            return tokenName.equals(((Token) rhs).getCompleteTokenName());
        }
    }
}
