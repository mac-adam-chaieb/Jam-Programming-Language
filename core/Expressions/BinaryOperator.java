/*
 * @author Mohamed Adam Chaieb
 * 
 * This enumerable data type represents the valid binary operators in Jam.
 * */

public enum BinaryOperator
{
  EQUALS("=?"), PLUS("+"), MINUS("-"), MULTIPLY("*"), DIVIDE("/"), MOD("mod"), LESS("<"), GREATER(">"), POW("**");
  public String op;
  
  private BinaryOperator(String op)
  {
    this.op = op;
  }
  
  public boolean equals(BinaryOperator other)
  {
    return this.op.equals(other.op);
  }
  
  public String toString()
  {
    return this.op;
  }
}