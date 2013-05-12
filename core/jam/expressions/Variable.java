package core.jam.expressions;

import core.jam.typing.*;
import java.util.ArrayList;

/*
 * @author Mohamed Adam Chaieb
 * 
 * This class represents variables in Jam.
 * */

public class Variable extends Expression
{
  private String name;
  public Expression e;
  public boolean free = true;
  
  public Variable(String name)
  {
    this.name = name;
    this.type = new AlphaType(0);
    this.freeVariables.addAll(this.getFreeVariables());
  }
  
  public ArrayList<Variable> getFreeVariables()
  {
    ArrayList<Variable> freeVariables = new ArrayList<Variable>();
    freeVariables.add(this);
    return freeVariables;
  }
  
  public Value evaluate()
  {
    if(this.free)
      return new Value<Variable>(this);
    else return this.e.evaluate();
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
  
  public static boolean isAllowed(String name)
  {
    for(Keyword k : Keyword.values())
      if(name.equalsIgnoreCase(k.toString()) || Real.isReal(name) || Int.isInt(name) || name.contains("\\s") || name.contains(" "))
      return false;
    return true;
  }
}