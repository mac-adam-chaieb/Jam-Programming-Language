package core.jam.expressions;

import core.jam.typing.*;
import java.util.ArrayList;

/*
 * @author Mohamed Adam Chaieb
 * 
 * This class represents empty expressions.
 * */

public class Empty extends Expression implements Value
{
	public ArrayList<Variable> getFreeVariables()
	{
		return new ArrayList<Variable>();
	}

	public String toString()
	{
		return "";
	}

	public Value evaluate()
	{
		return this;
	}

	public ConstraintSet infer(TypeContext t)
	{
		return ConstraintSet.EMPTY;
	}

	public Expression substitute(Expression sub, Variable variable)
	{
		return this;
	}

	public boolean equals(Expression other)
	{
		return (other instanceof Empty);
	}
}