package core.jam.typing;

/*
 * @author Mohamed Adam Chaieb
 * 
 * This class represents the integer type
 * */

public class IntegerType extends Type
{
	public Type substitute(Type sub, Type t)
	{
		return this;
	}

	public boolean equals(Type other)
	{
		return (other instanceof IntegerType);
	}

	public String toString()
	{
		return "integer";
	}
}