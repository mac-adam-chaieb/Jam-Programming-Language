import java.util.ArrayList;
import java.util.HashMap;

/*
 * @author Mohamed Adam Chaieb
 * 
 * This class represents the boolean expression (true or false)
 * */

public class Boolean extends Expression
{
  public final boolean TRUE = true;
  public final boolean FALSE = false;
  public boolean bool;
  
  public Boolean(String b)
  {
    if(b.equals("true"))
      this.bool = true;
    else if (b.equals("false"))
      this.bool = false;
  }
  
  public Boolean(boolean bool)
  {
    this.bool = bool;
  }
  
  public ArrayList<Variable> getFreeVariables()
  {
    //this was initialized empty
    return this.freeVariables;
  }
  
  public Value evaluate()
  {
    return new Value(this);
  }
  
  public Expression substitute(Expression sub, Variable variable)
  {
    return this;
  }
  
  public ConstraintSet infer(TypeContext c)
  {
    this.type = Type.BOOLEAN;
    return new ConstraintSet();
  }
  
  public String toString()
  {
    if(this.bool == true)
      return "true";
    else return "false";
  }
}