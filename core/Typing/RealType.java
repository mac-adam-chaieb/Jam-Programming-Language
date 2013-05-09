/*
 * @author Mohamed Adam Chaieb
 * 
 * This class represents the real number type
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
  
  public String toString()
  {
    return "real";
  }
}