package core.jam.expressions;

/*
 * @author Mohamed Adam Chaieb
 * 
 * This enumerable data type represents the keywords in the Jam language.
 * */

public enum Keyword
{
  IF("if"), THEN("then"), ELSE("else"), END("end"), LET("let"), IN("in"), FN("fn"), REC("rec"), EQUALS("="), ARROW("=>");
  public String keyword;
  
  private Keyword(String keyword)
  {
    this.keyword = keyword;
  }
  
  public String toString()
  {
    return this.keyword;
  }
  
  public boolean equals(Keyword other)
  {
    return this.keyword.equals(other.keyword);
  }
}