package core.jam.expressions;

import core.jam.typing.*;
import java.util.ArrayList;

/*
 * @author Mohamed Adam Chaieb
 * 
 * This class represents the unary operation expression (op e)
 * */

public class UnaryOperation extends Expression
{
	public Expression e;
	public UnaryOperator operator;

	public UnaryOperation(Expression e, UnaryOperator operator)
	{
		this.e = e;
		this.operator = operator;
		this.freeVariables.addAll(this.getFreeVariables());
	}

	public Value evaluate()
	{
		return (new UnaryOperation((Expression)this.e.evaluate(), this.operator)).evaluate();
	}

	public ArrayList<Variable> getFreeVariables()
	{
		ArrayList<Variable> freeVariables = new ArrayList<Variable>();
		freeVariables.addAll(this.e.getFreeVariables());
		return freeVariables;
	}

	public Expression substitute(Expression sub, Variable variable)
	{
		return new UnaryOperation(this.e.substitute(sub, variable), this.operator);
	}

	public ConstraintSet infer(TypeContext c)
	{
		ConstraintSet s = this.e.infer(c);
		ConstraintSet output = new ConstraintSet();
		this.type = this.e.type;
		output.union(s);
		return output;
	}

	public String toString()
	{
		return this.operator.op+"("+this.e.toString()+")";
	}
}