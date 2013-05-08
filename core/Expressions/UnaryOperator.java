/*
 * @author Mohamed Adam Chaieb
 * */

public class UnaryOperator
{
  public String op;
  
  public UnaryOperator(String op)
  {
    //if operator is valid
    if(op.equals("=?") || op.equals("+") || op.equals("/") || op.equals("mod") || op.equals("-") || op.equals("*") || op.equals("<") || op.equals(">"))
      this.op = op;
  }
  
  public boolean equals(UnaryOperator other)
  {
    return this.op.equals(other.op);
  }
}