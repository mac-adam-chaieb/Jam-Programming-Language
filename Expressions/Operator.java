public class Operator
{
  public String op;
  
  public Operator(String op)
  {
    //if operator is valid
    if(op.equals("=?") || op.equals("+") || op.equals("/") || op.equals("mod") || op.equals("-") || op.equals("*") || op.equals("<") || op.equals(">"))
      this.op = op;
  }
  
  public boolean equals(Operator other)
  {
    return this.op.equals(other.op);
  }
}