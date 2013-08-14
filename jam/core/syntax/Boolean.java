package jam.core.syntax;

import jam.core.typing.*;

import java.util.ArrayList;

/*
 * @author Mohamed Adam Chaieb
 * 
 * This class represents the boolean expression (true or false)
 * */

public class Boolean extends Expression implements Value
{
	public final static Boolean TRUE = new Boolean(true);
	public final static Boolean FALSE = new Boolean(false);
	public boolean bool;

	public Boolean(String b)
	{
		if(b.equals("true"))
			this.bool = true;
		else if (b.equals("false"))
			this.bool = false;
		this.freeVariables.addAll(this.getFreeVariables());
	}

	public Boolean(boolean bool)
	{
		this.bool = bool;
		this.freeVariables.addAll(this.getFreeVariables());
	}

	public ArrayList<Variable> getFreeVariables()
	{
		//this was initialized empty
		return this.freeVariables;
	}

	public Value evaluate()
	{
		return this;
	}

	public Expression substitute(Expression sub, Variable variable)
	{
		return this;
	}

	public ConstraintSet infer(TypeContext c)
	{
		this.type = Type.BOOLEAN;
		return new ConstraintSet();
	}

	public String toString()
	{
		if(this.bool == true)
			return "true";
		else return "false";
	}

	public static boolean isBoolean(String in)
	{
		return (in.equals("true") || in.equals("false"));
	}

	public boolean equals(Expression other)
	{
		if(other instanceof Boolean)
			return (this.bool == ((Boolean)other).bool);
		else return false;
	}
}