package jam.core.syntax;

import jam.core.typing.*;

import java.util.ArrayList;

/*
 * @author Mohamed Adam Chaieb
 * 
 * This class represents the if-then-else expression (if condition then e1 else e2 end)
 * */

public class If extends Expression
{
	public Expression condition;
	public Expression e1;
	public Expression e2;

	public If(Expression condition, Expression e1, Expression e2)
	{
		this.condition = condition;
		this.e1 = e1;
		this.e2 = e2;
		this.freeVariables.addAll(this.getFreeVariables());
	}

	public Value evaluate()
	{
		Value e = condition.evaluate();
		if(e instanceof jam.core.syntax.Boolean)
		{
			if(e.equals(Boolean.TRUE))
				return e1.evaluate();
			else
				return e2.evaluate();
		}
		//this should return a type error because condition HAS to be a boolean
		else return null;
	}

	public ArrayList<Variable> getFreeVariables()
	{
		ArrayList<Variable> freeVariables = new ArrayList<Variable>();
		freeVariables.addAll(this.condition.getFreeVariables());
		freeVariables.addAll(this.e1.getFreeVariables());
		freeVariables.addAll(this.e2.getFreeVariables());
		return freeVariables;
	}

	public Expression substitute(Expression sub, Variable variable)
	{
		return new If(this.condition.substitute(sub, variable),this.e1.substitute(sub, variable),this.e2.substitute(sub, variable));
	}

	public ConstraintSet infer(TypeContext c)
	{
		ConstraintSet s = this.condition.infer(c);
		ConstraintSet t = this.e1.infer(c);
		ConstraintSet v = this.e2.infer(c);
		ConstraintSet output = new ConstraintSet();
		this.type = this.e1.type;
		output.union(s);
		output.union(t);
		output.union(v);
		output.add(this.condition.type,new BooleanType());
		output.add(this.e1.type,this.e2.type);
		return output;
	}

	public String toString()
	{
		return "if ("+this.condition.toString()+") then ("+this.e1.toString()+") else ("+this.e2.toString()+") end";
	}
}