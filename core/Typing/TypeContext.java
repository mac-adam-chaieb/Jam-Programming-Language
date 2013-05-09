import java.util.HashMap;

/*
 * @author Mohamed Adam Chaieb
 * 
 * This class represents the type context, that associates each variable in the program environment
 * to a type. It internally uses a HashMap.
 * */

public class TypeContext
{
  public HashMap<Variable,Type> context;
  public static final TypeContext EMPTY = new TypeContext();
  
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