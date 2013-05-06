import java.math.BigDecimal;
import java.util.ArrayList;

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
    this.type = new RealType();
    return new ConstraintSet();
  }
}