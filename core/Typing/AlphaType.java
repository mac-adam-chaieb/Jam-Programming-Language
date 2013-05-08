/*
 * @author Mohamed Adam Chaieb
 * 
 * This class represents the generic polymorphic type
 * */

public class AlphaType extends Type
{
  //the code differentiates the different generic types, e.g alpha and beta
  public int code;
  
  //constructor
  public AlphaType(int code)
  {
    this.code = code;
  }
  
  public Type substitute(Type sub, Type t)
  {
    if(t.equals(this))
      return sub;
    else return this;
  }
  
  //equals method: two generic types are equal if they have the same code, e.g alpha = alpha but alpha != beta
  public boolean equals(Type other)
  {
    AlphaType t = (AlphaType)other;
    if(other instanceof AlphaType)
      return (t.code == this.code);
    else return false;
  }
}