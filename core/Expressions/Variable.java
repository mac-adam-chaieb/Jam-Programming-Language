import java.util.ArrayList;

/*
 * @author Mohamed Adam Chaieb
 * */

public class Variable extends Expression
{
  private String name;
  
  public Variable(String name)
  {
    this.name = name;
  }
  
  public ArrayList<Variable> getFreeVariables()
  {
    ArrayList<Variable> freeVariables = new ArrayList<Variable>();
    freeVariables.add(this);
    return freeVariables;
  }
  
  public Value evaluate()
  {
    return new Value(new Boolean("true"));
  }
  
  public Expression substitute(Expression sub, Variable variable)
  {
    if(this.equals(variable))
      return sub;
    else return this;
  }
  
  public boolean equals(Variable other)
  {
    return this.name.equals(other.name);
  }
  
  public ConstraintSet infer(TypeContext c)
  {
    if(c.hasVariable(this))
      this.type = c.getType(this);
    return new ConstraintSet();
  }
  
  public String toString()
  {
    return this.name;
  }
}