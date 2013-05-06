public abstract class Type
{
  public static final Type INTEGER = new IntegerType();
  public static final Type REAL = new RealType();
  public static final Type BOOLEAN = new BooleanType();
  public static final Type UNKNOWN = null;
  
  public Type(){}
  
  //substitutes t with sub
  abstract public Type substitute(Type sub, Type t);
  abstract public boolean equals(Type other);
}