package core.jam.expressions;

import java.util.ArrayList;

/*
 * @author Mohamed Adam Chaieb
 * 
 * This enumerable data type represents the valid binary operators in Jam.
 * */

public enum BinaryOperator
{
  //ordered by increasing priority
  EQUALS("=?"), LESS("<"), GREATER(">"), MOD("mod"), PLUS("+"), MINUS("-"), MULTIPLY("*"), DIVIDE("/"), POW("**");
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
  
  //returns the index of the operator with lowest priority
  public static int index(String in)
  {
    for(BinaryOperator o : BinaryOperator.values())
      if(in.contains(o.op))
      return in.indexOf(o.op);
    return -1;
  }
  
  //returns true if the input string starts with an operator
  public static boolean startsWithOperator(String in)
  {
    for(BinaryOperator o : BinaryOperator.values())
      if(in.startsWith(o.toString()))
        return true;
    return false;
  }
  
  public static BinaryOperator getOperatorAt(int index, String in)
  {
    for(BinaryOperator o : BinaryOperator.values())
      if(in.startsWith(o.op, index))
      return o;
    return null;
  }
  
  public static boolean startsWithOneOf(String in, ArrayList<Variable> vars)
  {
    for(Variable v : vars)
      if(in.startsWith(v.toString()))
      return true;
    return false;
  }
}