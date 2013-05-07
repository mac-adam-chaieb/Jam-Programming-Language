import java.util.ArrayList;

public abstract class Expression
{
  //fields
  public String expression = "";
  protected ArrayList<Variable> freeVariables = new ArrayList<Variable>();
  public Type type;
  
  //methods
  abstract public Value evaluate();
  abstract public ArrayList<Variable> getFreeVariables();
  abstract public Expression substitute(Expression sub, Variable variable);
  abstract public ConstraintSet infer(TypeContext c);
}