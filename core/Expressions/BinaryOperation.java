import java.util.ArrayList;
import java.math.BigInteger;
import java.math.BigDecimal;

/*
 * @author Mohamed Adam Chaieb
 * 
 * This class represents the binary operation expression (e1 op e2)
 * */

public class BinaryOperation extends Expression
{
  public Expression e1;
  public Expression e2;
  public BinaryOperator operator;
  
  public BinaryOperation(Expression e1, Expression e2, BinaryOperator operator)
  {
    this.e1 = e1;
    this.e2 = e2;
    this.operator = operator;
    this.freeVariables.addAll(this.getFreeVariables());
  }
  
  public Value evaluate()
  {
    if(this.operator.op.equals("+") && e1 instanceof Int && e2 instanceof Int)
      return new Value(new Int(new BigInteger(this.e1.expression).add(new BigInteger(this.e2.expression))));
    if(this.operator.op.equals("-") && e1 instanceof Int && e2 instanceof Int)
      return new Value(new Int(new BigInteger(this.e1.expression).subtract(new BigInteger(this.e2.expression))));
    if(this.operator.op.equals("+") && e1 instanceof Real && e2 instanceof Real)
      return new Value(new Real(new BigDecimal(this.e1.expression).add(new BigDecimal(this.e2.expression))));
    if(this.operator.op.equals("-") && e1 instanceof Real && e2 instanceof Real)
      return new Value(new Real(new BigDecimal(this.e1.expression).add(new BigDecimal(this.e2.expression))));
    if(this.operator.op.equals("*") && e1 instanceof Int && e2 instanceof Int)
      return new Value(new Int(new BigInteger(this.e1.expression).multiply(new BigInteger(this.e2.expression))));
    if(this.operator.op.equals("*") && e1 instanceof Real && e2 instanceof Real)
      return new Value(new Real(new BigDecimal(this.e1.expression).multiply(new BigDecimal(this.e2.expression))));
    if(this.operator.op.equals("=?") && e1 instanceof Int && e2 instanceof Int)
      return new Value(new Boolean(new BigInteger(e1.expression).compareTo(new BigInteger(e2.expression)) == 0));
    if(this.operator.op.equals("=?") && e1 instanceof Real && e2 instanceof Real)
      return new Value(new Boolean(new BigDecimal(e1.expression).compareTo(new BigDecimal(e2.expression)) == 0));
    if(this.operator.op.equals("<") && e1 instanceof Int && e2 instanceof Int)
      return new Value(new Boolean(new BigInteger(e1.expression).compareTo(new BigInteger(e2.expression)) == -1));
    if(this.operator.op.equals("<") && e1 instanceof Real && e2 instanceof Real)
      return new Value(new Boolean(new BigDecimal(e1.expression).compareTo(new BigDecimal(e2.expression)) == -1));
    if(this.operator.op.equals(">") && e1 instanceof Int && e2 instanceof Int)
      return new Value(new Boolean(new BigInteger(e1.expression).compareTo(new BigInteger(e2.expression)) == 1));
    if(this.operator.op.equals(">") && e1 instanceof Real && e2 instanceof Real)
      return new Value(new Boolean(new BigDecimal(e1.expression).compareTo(new BigDecimal(e2.expression)) == 1));
    if(this.operator.op.equals("mod") && e1 instanceof Int && e2 instanceof Int)
      return new Value(new Int(new BigInteger(e1.expression).remainder(new BigInteger(e2.expression))));
    if(this.operator.op.equals("mod") && e1 instanceof Real && e2 instanceof Real)
      return new Value(new Real(new BigDecimal(e1.expression).remainder(new BigDecimal(e2.expression))));
    else return (new BinaryOperation(this.e1.evaluate(), this.e2.evaluate(), this.operator)).evaluate();
  }
  
  public ArrayList<Variable> getFreeVariables()
  {
    ArrayList<Variable> freeVariables = new ArrayList<Variable>();
    freeVariables.addAll(this.e1.getFreeVariables());
    freeVariables.addAll(this.e2.getFreeVariables());
    return freeVariables;
  }
  
  public Expression substitute(Expression sub, Variable variable)
  {
    return new BinaryOperation(this.e1.substitute(sub, variable),this.e2.substitute(sub, variable),this.operator);
  }
  
  //needs fixing to accept both integer and real types
  public ConstraintSet infer(TypeContext c)
  {
    ConstraintSet s = this.e1.infer(c);
    ConstraintSet t = this.e2.infer(c);
    ConstraintSet output = new ConstraintSet();
    if(this.operator.op.equals("+") || this.operator.op.equals("-") || this.operator.op.equals("*") || this.operator.op.equals("/") 
         || this.operator.op.equals("mod"))
    {
      this.type = this.e1.type;
      output.add(this.e1.type, Type.INTEGER);
      output.add(this.e2.type, Type.INTEGER);
    }
    else if(this.operator.op.equals("=?") || this.operator.op.equals("<") || this.operator.op.equals(">"))
    {
      this.type = Type.BOOLEAN;
      output.add(this.e1.type, this.e2.type);
    }
    output.union(s);
    output.union(t);
    return output;
  }
  
  public String toString()
  {
    return this.e1.toString()+this.operator.op+this.e2.toString();
  }
}