import java.util.HashMap;

/*
 * @author Mohamed Adam Chaieb
 * 
 * This class represents the ConstraintSet needed for type inference.
 * */

public class ConstraintSet
{
  public HashMap<Type,Type> constraints;
  public static final ConstraintSet EMPTY = new ConstraintSet();
  
  public ConstraintSet()
  {
    this.constraints = new HashMap<Type,Type>();
  }
  
  public void add(Type var1, Type var2)
  {
    this.constraints.put(var1,var2);
  }
  
  public void union(ConstraintSet other)
  {
    this.constraints.putAll(other.constraints);
  }
  
  public boolean unifiable()
  {
    for(Type t : this.constraints.keySet())
    {
      if(this.unify(t,this.constraints.get(t)) == false)
        return this.constraints.isEmpty();
    }
    return false;
  }
  
  public boolean unify(Type t, Type s)
  {
    if(t.equals(Type.INTEGER) && s.equals(Type.INTEGER))
    {
      this.constraints.remove(t);
      return true;
    }
    else if(t.equals(Type.BOOLEAN) && s.equals(Type.BOOLEAN))
    {
      this.constraints.remove(t);
      return true;
    }
    else if(t instanceof ArrowType && s instanceof ArrowType)
    {
      ArrowType first = (ArrowType)t;
      ArrowType second = (ArrowType)s;
      this.add(first.inputType, second.inputType);
      this.add(first.outputType, second.outputType);
      return true;
    }
    else if(t instanceof AlphaType || s instanceof AlphaType)
    {
      this.substitute(t, s);
      return true;
    }
    else return false;
  }
  
  public void substitute(Type sub, Type t)
  {
    for(Type s : this.constraints.keySet())
    {
      s.substitute(sub, t);
      this.constraints.get(s).substitute(sub, t);
    }
  }
  
  public String toString()
  {
    if(this.constraints.isEmpty())
      return "{}";
    else
    {
      String output = "{";
      for(Type t : this.constraints.keySet())
        output += t.toString()+" = "+this.constraints.get(t).toString()+",";
      output += "}";
      return new StringBuilder(output).deleteCharAt(output.length()-2).toString();
    }
  }
}