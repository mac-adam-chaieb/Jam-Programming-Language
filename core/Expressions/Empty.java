import java.util.ArrayList;

/*
 * @author Mohamed Adam Chaieb
 * 
 * This class represents empty expressions.
 * */

public class Empty extends Expression
{
  public ArrayList<Variable> getFreeVariables()
  {
    return new ArrayList<Variable>();
  }
  
  public String toString()
  {
    return "";
  }
  
  public Value evaluate()
  {
    return new Value(this);
  }
  
  public ConstraintSet infer(TypeContext t)
  {
    return ConstraintSet.EMPTY;
  }
  
  public Expression substitute(Expression sub, Variable variable)
  {
    return this;
  }
}