package jam.core.syntax;

import jam.core.typing.*;

import java.util.ArrayList;

/*
 * @author Mohamed Adam Chaieb
 * 
 * This class represents the binary operation expression (e1 op e2)
 * */

public class BinaryOperation extends Expression
{
	public Expression e1;
	public Expression e2;
	public BinaryOperator operator;

	public BinaryOperation(Expression e1, Expression e2, BinaryOperator operator)
	{
		this.e1 = e1;
		this.e2 = e2;
		this.operator = operator;
		this.freeVariables.addAll(this.getFreeVariables());
	}

	public Value evaluate()
	{    
		if((e1 instanceof Int) && (e2 instanceof Int))
		{
			Int int1 = (Int)e1;
			Int int2 = (Int)e2;
			if(this.operator.equals(BinaryOperator.PLUS))
				return int1.add(int2);
			if(this.operator.equals(BinaryOperator.MINUS))
				return int1.subtract(int2);
			if(this.operator.equals(BinaryOperator.MULTIPLY))
				return int1.multiply(int2);
			if(this.operator.equals(BinaryOperator.EQUALS))
				return new Boolean(int1.equals(int2));
			if(this.operator.equals(BinaryOperator.LESS))
				return new Boolean(int1.lessThan(int2));
			if(this.operator.equals(BinaryOperator.GREATER))
				return new Boolean(int1.greaterThan(int2));
			if(this.operator.equals(BinaryOperator.MOD))
				return int1.mod(int2);
		}
		if((e1 instanceof Real) && (e2 instanceof Real))
		{
			Real real1 = (Real)e1;
			Real real2 = (Real)e1;
			if(this.operator.equals(BinaryOperator.PLUS))
				return real1.add(real2);
			if(this.operator.equals(BinaryOperator.MINUS))
				return real1.add(real2);
			if(this.operator.equals(BinaryOperator.MULTIPLY))
				return real1.multiply(real2);
			if(this.operator.equals(BinaryOperator.EQUALS))
				return new Boolean(real1.equals(real2));
			if(this.operator.equals(BinaryOperator.LESS))
				return new Boolean(real1.lessThan(real2));
			if(this.operator.equals(BinaryOperator.GREATER))
				return new Boolean(real1.greaterThan(real2));
			if(this.operator.equals(BinaryOperator.MOD))
				return real1.mod(real2);
		}
		return (new BinaryOperation((Expression)this.e1.evaluate(), (Expression)this.e2.evaluate(), this.operator)).evaluate();
	}

	public ArrayList<Variable> getFreeVariables()
	{
		ArrayList<Variable> freeVariables = new ArrayList<Variable>();
		freeVariables.addAll(this.e1.getFreeVariables());
		freeVariables.addAll(this.e2.getFreeVariables());
		return freeVariables;
	}

	public Expression substitute(Expression sub, Variable variable)
	{
		return new BinaryOperation(this.e1.substitute(sub, variable),this.e2.substitute(sub, variable),this.operator);
	}

	//needs fixing to accept both integer and real types
	public ConstraintSet infer(TypeContext c)
	{
		ConstraintSet s = this.e1.infer(c);
		ConstraintSet t = this.e2.infer(c);
		ConstraintSet output = new ConstraintSet();
		if(this.operator.op.equals("+") || this.operator.op.equals("-") || this.operator.op.equals("*") || this.operator.op.equals("/") 
				|| this.operator.op.equals("mod"))
		{
			this.type = this.e1.type;
			output.add(this.e1.type, Type.INTEGER);
			output.add(this.e2.type, Type.INTEGER);
		}
		else if(this.operator.op.equals("=?") || this.operator.op.equals("<") || this.operator.op.equals(">"))
		{
			this.type = Type.BOOLEAN;
			output.add(this.e1.type, this.e2.type);
		}
		output.union(s);
		output.union(t);
		return output;
	}

	public String toString()
	{
		return this.e1.toString()+this.operator.op+this.e2.toString();
	}
}