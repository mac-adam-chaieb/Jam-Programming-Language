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
  private String[] restricted = {"if", "then", "else", "end", "fn", "let", "in", "rec"};//restricted variable names
  
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
    return new Value<Boolean>(new Boolean("true"));
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
    for(Keyword s : Keyword.values())
      if(name.equalsIgnoreCase(s.toString()))
      return false;
    return true;
  }
}