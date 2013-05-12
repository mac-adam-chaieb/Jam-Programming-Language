package core.jam.expressions;

import core.jam.typing.*;
import java.math.BigDecimal;
import java.util.ArrayList;

/*
 * @author Mohamed Adam Chaieb
 * 
 * This class represents the real number expression r
 * */

public class Real extends Expression
{
  public final BigDecimal real;
  public static final Real TWO = new Real(new BigDecimal("2"));
  public static final Real ONE = new Real(BigDecimal.ONE);
  public static final Real ZERO = new Real(BigDecimal.ZERO);
  public static final Real PI = new Real(new BigDecimal("3.141592653589793238462643383279"));
  public static final Real E = new Real(new BigDecimal("2.718281828459045235360287471352"));
  
  public Real(String real)
  {
    this.real = new BigDecimal(real);
    this.freeVariables.addAll(this.getFreeVariables());
  }
  
  public Real(BigDecimal real)
  {
    this.real = real;
    this.freeVariables.addAll(this.getFreeVariables());
  }
  
  public Value evaluate()
  {
    return new Value<Real>(this);
  }
  
  public ArrayList<Variable> getFreeVariables()
  {
    ArrayList<Variable> freeVariables = new ArrayList<Variable>();
    return freeVariables;
  }
  
  public Expression substitute(Expression sub, Variable variable)
  {
    return this;
  }
  
  public ConstraintSet infer(TypeContext c)
  {
    this.type = Type.REAL;
    return new ConstraintSet();
  }
  
  public String toString()
  {
    return this.real.toString();
  }
  
  public Int toInt()
  {
    return new Int(this.real.toBigInteger());
  }
  
  public boolean equals(Real b)
  {
    return (this.real.compareTo(b.real) == 0);
  }
  
  //math functions
  public Real add(Real b)
  {
    return new Real(this.real.add(b.real));
  }
  
  public Real multiply(Real b)
  {
    return new Real(this.real.multiply(b.real));
  }
  
  public Real subtract(Real b)
  {
    return new Real(this.real.subtract(b.real));
  }
  
  public Real divide(Real b, int scale)
  {
    try{BigDecimal output = this.real.divide(b.real); return new Real(output);}
    catch(Exception e)
    {
      BigDecimal output = this.real.divide(b.real, scale, BigDecimal.ROUND_HALF_UP); 
      return new Real(output);
    }
  }
  
  public Real mod(Real b)
  {
    return new Real(this.real.remainder(b.real));
  }
  
  public Real negate(Real a)
  {
    return new Real(this.real.negate());
  }
  
  public Real max(Real b)
  {
    return new Real(this.real.max(b.real));
  }
  
  public Real min(Real b)
  {
    return new Real(this.real.min(b.real));
  }
  
  public static boolean isReal(String input)
  {
    try
    {
      Double.parseDouble(input);
      return true;
    }
    catch(Exception e){return false;}
  }
  
  public boolean greaterThan(Real b)
  {
    return (this.real.compareTo(b.real) == 1);
  }
  
  public boolean lessThan(Real b)
  {
    return (this.real.compareTo(b.real) == -1);
  }
}