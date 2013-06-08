package core.jam.typing;

/*
 * @author Mohamed Adam Chaieb
 * 
 * This class represents the boolean type bool
 * */

public class BooleanType extends Type
{
	public Type substitute(Type sub, Type t)
	{
		return this;
	}

	public boolean equals(Type other)
	{
		return (other instanceof BooleanType);
	}

	public String toString()
	{
		return "boolean";
	}
}