package core.jam.expressions;

import core.jam.typing.*;
import java.math.BigDecimal;
import java.math.BigInteger;

/*
 * @author Mohamed Adam Chaieb
 * 
 * This class represents the valid terminal values in Jam: integers,  real numbers, boolean values and functions.
 * */

public class Value extends Int
{
  public BigInteger number;
  public BigDecimal real;
  public boolean bool;
  public Function function;
  public boolean isEmpty;
  public Type type = Type.UNKNOWN;
  
  public Value(Int n)
  {
    this.number = n.number;
    this.type = Type.INTEGER;
  }
  
  public Value(Real r)
  {
    this.real = r.real;
    this.type = Type.REAL;
  }
  
  public Value(Boolean b)
  {
    this.bool = b.bool;
    this.type = Type.BOOLEAN;
  }
  
  public Value(Function f)
  {
    this.function = f;
    this.type = f.type;
    System.out.println("Function value of type: "+this.type);
  }
  
  public Value(Empty empty)
  {
    this.isEmpty = true;
  }
  
  public String toString()
  {
    if(this.isEmpty)
      return "";
    else if(this.type.equals(Type.INTEGER))
      return this.number.toString();
    else if(this.type.equals(Type.REAL))
      return this.real.toString();
    else if(this.type.equals(Type.BOOLEAN))
    {
      if(this.bool == true)
        return "true";
      else return "false";
    }
    else return function.toString();
  }
}