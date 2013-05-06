import java.util.HashMap;

public class ConstraintSet
{
  public HashMap<Type,Type> constraints = new HashMap<Type,Type>();
  
  public ConstraintSet(){}
  
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
    else if(t.getClass() == ArrowType.class && s.getClass() == ArrowType.class)
    {
      ArrowType first = (ArrowType)t;
      ArrowType second = (ArrowType)s;
      this.add(first.inputType, second.inputType);
      this.add(first.outputType, second.outputType);
      return true;
    }
    else if(t.getClass() == AlphaType.class || s.getClass() == AlphaType.class)
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
}