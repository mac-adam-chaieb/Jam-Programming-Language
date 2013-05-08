/*
 * @author Mohamed Adam Chaieb
 * */

public class RealType extends Type
{
  public Type substitute(Type sub, Type t)
  {
    return this;
  }
  
  public boolean equals(Type other)
  {
    return (other instanceof RealType);
  }
}