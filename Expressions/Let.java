import java.util.ArrayList;

public class Let extends Expression
{
  public Expression e2;
  public Binding binding;
  
  public Let(Binding binding, Expression e2)
  {
    this.e2 = e2;
    this.binding = binding;
    this.freeVariables.addAll(this.getFreeVariables());
  }
  
  //needs to be fixed
  public Value evaluate()
  {
    return e2.substitute(this.binding.expression.evaluate(),this.binding.variable).evaluate();
  }
  
  public ArrayList<Variable> getFreeVariables()
  {
    ArrayList<Variable> freeVariables = new ArrayList<Variable>();
    freeVariables.addAll(this.e2.getFreeVariables());
    freeVariables.addAll(this.binding.expression.getFreeVariables());
    freeVariables.remove(this.binding.variable);
    return freeVariables;
  }
  
  //we assume variable in binding is differend than input variable, and that variable in binding is not
  //a free variable of the input expression
  public Expression substitute(Expression sub, Variable var)
  {
    return new Let(new Binding(this.binding.variable,this.binding.expression.substitute(sub,var)), e2.substitute(sub,var));
  }
  
  public ConstraintSet infer(TypeContext c)
  {
    ConstraintSet s = this.binding.expression.infer(c);
    ConstraintSet t = this.e2.infer(c.augment(this.binding.variable, this.binding.expression.type));
    ConstraintSet output = new ConstraintSet();
    this.type = this.e2.type;
    output.union(s);
    output.union(t);
    return output;
  }
}