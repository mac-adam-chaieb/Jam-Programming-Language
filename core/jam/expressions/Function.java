package core.jam.expressions;

import core.jam.typing.*;
import java.util.ArrayList;

/*
 * @author Mohamed Adam Chaieb
 * 
 * This class represents the function expression (fn var => formula)
 * */

public class Function extends Expression
{
  public Variable input;
  public Expression formula;
  
  public Function(Variable input, Expression formula)
  {
    this.input = input;
    this.formula = formula;
    this.freeVariables.addAll(this.getFreeVariables());
  }
  
  public ArrayList<Variable> getFreeVariables()
  {
    ArrayList<Variable> freeVariables = new ArrayList<Variable>();
    freeVariables.addAll(this.formula.getFreeVariables());
    freeVariables.remove(this.input);
    return freeVariables;
  }
  
  //we assume input variable is not equal to input, and that input variable is not a free variable of the input expression
  public Expression substitute(Expression sub, Variable variable)
  {
    return new Function(this.input,formula.substitute(sub,variable));
  }
  
  public Value evaluate()
  {
    return new Value<Function>(this);
  }
  
  public ConstraintSet infer(TypeContext c)
  {
    Type alpha = new AlphaType(0);
    ConstraintSet s = this.formula.infer(c.augment(this.input, alpha));
    ConstraintSet output = new ConstraintSet();
    this.type = new ArrowType(alpha, this.formula.type);
    output.union(s);
    return output;
  }
  
  public String toString()
  {
    return "fn "+this.input.toString()+" => "+this.formula.toString();
  }
}