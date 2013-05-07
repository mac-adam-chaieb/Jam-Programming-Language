import java.util.ArrayList;

public class Recursion extends Expression
{
  public Variable function;
  public Expression formula;
  
  public Recursion(Variable function, Expression formula)
  {
    this.function = function;
    this.formula = formula;
    this.freeVariables.addAll(this.getFreeVariables());
  }
  
  public ArrayList<Variable> getFreeVariables()
  {
    ArrayList<Variable> freeVariables = new ArrayList<Variable>();
    freeVariables.addAll(this.formula.getFreeVariables());
    freeVariables.remove(this.function);
    return freeVariables;
  }
  
  public Expression substitute(Expression sub, Variable variable)
  {
    return new Recursion(this.function, formula.substitute(sub,variable));
  }
  
  public Value evaluate()
  {
    return this.formula.substitute(new Recursion(this.function, this.formula),this.function).evaluate();
  }
  
  public ConstraintSet infer(TypeContext c)
  {
    Type alpha = new AlphaType(0);
    ConstraintSet s = this.formula.infer(c.augment(this.function, alpha));
    ConstraintSet output = new ConstraintSet();
    this.type = new ArrowType(alpha, this.formula.type);
    output.union(s);
    return output;
  }
  
  public String toString()
  {
    return "rec "+this.function.toString()+" => "+this.formula.toString();
  }
}