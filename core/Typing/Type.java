/*
 * @author Mohamed Adam Chaieb
 * 
 * This abstract class represents all types in Jam.
 * */

public abstract class Type
{
  public static final Type INTEGER = new IntegerType();
  public static final Type REAL = new RealType();
  public static final Type BOOLEAN = new BooleanType();
  public static final Type UNKNOWN = null;
  
  public Type(){}
  
  abstract public Type substitute(Type sub, Type t); //substitutes the type variable t with sub
  abstract public boolean equals(Type other); //returns true if this and other are equal
  abstract public String toString(); //returns a string representation of the type
}