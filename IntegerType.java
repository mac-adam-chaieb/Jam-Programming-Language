public class IntegerType extends Type
{
  public Type substitute(Type sub, Type t)
  {return this;}
  
  public boolean equals(Type other)
  {
    return (other.getClass() == IntegerType.class);
  }
}