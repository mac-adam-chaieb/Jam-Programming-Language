import java.math.BigInteger;
import java.util.ArrayList;

/*
 * @author Mohamed Adam Chaieb
 * 
 * This class represents the integer expression n
 * */

public class Int extends Expression
{
  public BigInteger number = BigInteger.ZERO;
  public static final Int TWO = new Int(new BigInteger("2"));
  public static final Int ONE = new Int(BigInteger.ONE);
  public static final Int ZERO = new Int(BigInteger.ZERO);
  
  public Int(){}
  
  public Int(String number)
  {
    this.number = new BigInteger(number);
  }
  
  public Int(BigInteger number)
  {
    this.number = number;
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
    this.type = Type.INTEGER;
    return new ConstraintSet();
  }
  
  public String toString()
  {
    return this.number.toString();
  }
  
  public boolean equals(Int b)
  {
    return (this.number.compareTo(b.number) == 0);
  }
  
  //math functions
    public Int add(Int b)
  {
    return new Int(this.number.add(b.number));
  }
  
  public Int multiply(Int b)
  {
    return new Int(this.number.multiply(b.number));
  }
  
  public Int subtract(Int b)
  {
    return new Int(this.number.subtract(b.number));
  }
  
  public Int divide(Int b)
  {
    return new Int(this.number.divide(b.number));
  }
  
  public Int mod(Int b)
  {
    return new Int(this.number.mod(b.number));
  }
  
  public Int negate()
  {
    return new Int(this.number.negate());
  }
  
  public Int max(Int b)
  {
    return new Int(this.number.max(b.number));
  }
  
  public Int min(Int b)
  {
    return new Int(this.number.min(b.number));
  }
  
  public boolean even()
  {
    return (this.number.mod(new BigInteger("2")).compareTo(BigInteger.ZERO) == 0);
  }
  
  public boolean odd()
  {
    return !this.even();
  }
  
  public Int pow(Int b)
  {
    if(b.equals(Int.ZERO))
      return Int.ONE;
    else if(b.even())
      return (this.pow(b.divide(Int.TWO))).multiply(this.pow(b.divide(Int.TWO)));
    else return (this.pow(b.divide(Int.TWO))).multiply(this.pow(b.divide(Int.TWO))).multiply(this);
  }
}