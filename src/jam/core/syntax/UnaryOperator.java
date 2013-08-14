package jam.core.syntax;

/*
 * @author Mohamed Adam Chaieb
 * 
 * This enumerable data type represents the valid unary operators in Jam.
 * */
public enum UnaryOperator
{
  LOG("log"), LN("ln"), COSINE("cos"), SINE("sin"), TANGENT("tan"), FACTORIAL("!"), SQROOT("sqrt"), NEGATE("~"), ARCCOS("arccos"), ARCSIN("arcsin"), ARCTAN("arctan"), ABSOLUTE("abs");
  public String op;
  
  private UnaryOperator(String op)
  {
    this.op = op;
  }
  
  public boolean equals(UnaryOperator other)
  {
    return this.op.equals(other.op);
  }
  
  public String toString()
  {
    return this.op;
  }
  
  //returns true if the inoput string starts with a unary operator
  public static boolean startsWithOperator(String in)
  {
    for(UnaryOperator o : UnaryOperator.values())
      if(in.startsWith(o.toString()))
      return true;
    return false;
  }
  
  //returns the operator that the expression starts with
  public static UnaryOperator getOperator(String in)
  {
    for(UnaryOperator o : UnaryOperator.values())
      if(in.startsWith(o.toString()))
      return o;
    return null;
  }
}