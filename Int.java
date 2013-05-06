import java.math.BigInteger;
import java.util.ArrayList;

public class Int extends Expression
{
  public BigInteger number = BigInteger.ZERO;
  
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
    this.type = new IntegerType();
    return new ConstraintSet();
  }
}