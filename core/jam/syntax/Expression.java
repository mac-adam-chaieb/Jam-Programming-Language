package core.jam.syntax;

import core.jam.typing.*;
import java.util.ArrayList;

/*
 * @author Mohamed Adam Chaieb
 * 
 * This abstract class is the representation of all expressions in Jam.
 * */

public abstract class Expression
{
  //fields
  public ArrayList<Variable> freeVariables = new ArrayList<Variable>(); //list of free variables of the expression
  public Type type; //type of this expression
  public static final Expression EMPTY = new Empty(); //represents the empty expression
  
  //methods
  abstract public Value evaluate(); //returns the value that the expression evaluates to
  abstract public ArrayList<Variable> getFreeVariables(); //returns a list of free variables of the expression
  abstract public Expression substitute(Expression sub, Variable variable); // substitutes the occurences of the variable with the expression
  abstract public ConstraintSet infer(TypeContext c); //infers the type of the expression given a type context, and returns the new type constraint set
  abstract public String toString(); //returns the string representation of the expression
}