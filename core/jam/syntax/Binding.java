package core.jam.syntax;

/*
 * @author Mohamed Adam Chaieb
 * 
 * This class represents the variable binding (var = e)
 * */

public class Binding
{
  public Variable variable;
  public Expression expression;
  
  public Binding(Variable variable, Expression expression)
  {
    this.variable = variable;
    this.expression = expression;
    this.variable.type = this.expression.type;
    this.variable.e = this.expression;
    this.variable.free = false;
  }
  
  public String toString()
  {
    return this.variable.toString()+" = "+this.expression.toString();
  }
}