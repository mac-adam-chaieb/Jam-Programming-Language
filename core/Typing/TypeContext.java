import java.util.HashMap;

/*
 * @author Mohamed Adam Chaieb
 * */

public class TypeContext
{
  public HashMap<Variable,Type> context;
  
  public TypeContext()
  {
    context = new HashMap<Variable,Type>();
  }
  
  public TypeContext augment(Variable variable, Type type)
  {
    this.context.put(variable,type);
    return this;
  }
  
  public boolean hasVariable(Variable variable)
  {
    return this.context.containsKey(variable);
  }
  
  public Type getType(Variable variable)
  {
    return this.context.get(variable);
  }
}