import java.util.ArrayList;

public class If extends Expression
{
  private Expression condition;
  private Expression e1;
  private Expression e2;
  
  public If(Expression condition, Expression e1, Expression e2)
  {
    this.condition = condition;
    this.e1 = e1;
    this.e2 = e2;
    this.freeVariables.addAll(this.getFreeVariables());
  }
  
  public Value evaluate()
  {
    if(condition.evaluate().bool = true)
      return e1.evaluate();
    else if(condition.evaluate().bool = false)
      return e2.evaluate();
    else return null;
  }
  
  public ArrayList<Variable> getFreeVariables()
  {
    ArrayList<Variable> freeVariables = new ArrayList<Variable>();
    freeVariables.addAll(this.condition.getFreeVariables());
    freeVariables.addAll(this.e1.getFreeVariables());
    freeVariables.addAll(this.e2.getFreeVariables());
    return freeVariables;
  }
  
  public Expression substitute(Expression sub, Variable variable)
  {
    return new If(this.condition.substitute(sub, variable),this.e1.substitute(sub, variable),this.e2.substitute(sub, variable));
  }
  
  public ConstraintSet infer(TypeContext c)
  {
    ConstraintSet s = this.condition.infer(c);
    ConstraintSet t = this.e1.infer(c);
    ConstraintSet v = this.e2.infer(c);
    ConstraintSet output = new ConstraintSet();
    this.type = this.e1.type;
    output.union(s);
    output.union(t);
    output.union(v);
    output.add(this.condition.type,new BooleanType());
    output.add(this.e1.type,this.e2.type);
    return output;
  }
}