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
  
  public void unify(Type t, Type s)
  {
    if(t.equals(Type.INTEGER) && s.equals(Type.INTEGER))
      this.constraints.remove(t);
    if(t.equals(Type.BOOLEAN) && s.equals(Type.BOOLEAN))
      this.constraints.remove(t);
    if(t.getClass() == ArrowType.class && s.getClass() == ArrowType.class)
    {
      ArrowType first = (ArrowType)t;
      ArrowType second = (ArrowType)s;
      this.add(first.inputType, second.inputType);
      this.add(first.outputType, second.outputType);
    }
    if(t.getClass() == AlphaType.class || s.getClass() == AlphaType.class)
      this.substitute(t, s);
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