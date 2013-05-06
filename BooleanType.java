public class BooleanType extends Type
{
  public Type substitute(Type sub, Type t)
  {
    return this;
  }
  
  public boolean equals(Type other)
  {
    return (other.getClass() == BooleanType.class);
  }
}