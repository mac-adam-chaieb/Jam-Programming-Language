/*
 * @author Mohamed Adam Chaieb
 * */

public class BinaryOperator
{
  public String op;
  
  public BinaryOperator(String op)
  {
    //if operator is valid
    if(op.equals("=?") || op.equals("+") || op.equals("/") || op.equals("mod") || op.equals("-") || op.equals("*") || op.equals("<") || op.equals(">"))
      this.op = op;
  }
  
  public boolean equals(BinaryOperator other)
  {
    return this.op.equals(other.op);
  }
}