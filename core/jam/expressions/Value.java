package core.jam.expressions;

/*
 * @author Mohamed Adam Chaieb
 * 
 * This wrapper class represents the valid terminal values in Jam: integers,  real numbers, boolean values and functions.
 * */

public class Value<T> extends Int
{
  public T value;
  
  public Value(T value)
  {
    this.value = value;
  }
  
  public String toString()
  {
    return this.value.toString();
  }
}