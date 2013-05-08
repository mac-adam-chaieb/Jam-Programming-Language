import java.math.BigDecimal;
import java.util.ArrayList;

/*
 * @author Mohamed Adam Chaieb
 * */

public class Real extends Expression
{
  public final BigDecimal real;
  
  public Real(String real)
  {
    this.real = new BigDecimal(real);
  }
  
  public Real(BigDecimal real)
  {
    this.real = real;
  }
  
  public Value evaluate()
  {
    return new Value(this);
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
}