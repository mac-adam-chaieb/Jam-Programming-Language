public class AlphaType extends Type
{
  public int code;
  
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
  
  public boolean equals(Type other)
  {
    AlphaType t = (AlphaType)other;
    if(other.getClass() == AlphaType.class)
      return (t.code == this.code);
    else return false;
  }
}