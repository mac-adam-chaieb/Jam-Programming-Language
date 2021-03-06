package jam.core.syntax;

import jam.core.typing.*;

import java.util.ArrayList;

/*
 * @author Mohamed Adam Chaieb
 * 
 * This class represents the application expression (e1)(e2)
 * */

public class Application extends Expression
{
	public Expression e1;
	public Expression e2;

	public Application(Expression e1, Expression e2)
	{
		this.e1 = e1;
		this.e2 = e2;
		this.freeVariables.addAll(this.getFreeVariables());
	}

	public ArrayList<Variable> getFreeVariables()
	{
		ArrayList<Variable> freeVariables =  new ArrayList<Variable>();
		freeVariables.addAll(this.e1.getFreeVariables());
		freeVariables.addAll(this.e2.getFreeVariables());
		return freeVariables;
	}

	public Expression substitute(Expression sub, Variable variable)
	{
		return new Application(this.e1.substitute(sub, variable), this.e2.substitute(sub, variable));
	}

	public Value evaluate()
	{
		Expression e = (Expression)this.e1.evaluate();
		if(e instanceof Function)
		{
			Function f = (Function)e;
			return f.formula.substitute((Expression)this.e2.evaluate(), f.input).evaluate();
		}
		else return null;
	}

	public ConstraintSet infer(TypeContext c)
	{
		ConstraintSet s = this.e1.infer(c);
		ConstraintSet t = this.e2.infer(c);
		ConstraintSet output = new ConstraintSet();
		Type alpha = new AlphaType(0);
		this.type = alpha;
		output.union(s);
		output.union(t);
		output.add(this.e1.type, new ArrowType(this.e2.type, alpha));
		return output;
	}

	public String toString()
	{
		return "("+this.e1.toString()+")("+this.e2.toString()+")";
	}
}