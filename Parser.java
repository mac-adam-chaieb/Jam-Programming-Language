import java.util.ArrayList;
import java.util.StringTokenizer;

/*
 * @author Mohamed Adam Chaieb
 * 
 * This class is the parser for the Jam programming language.
 * */

public class Parser
{
  private ArrayList<String> tokens;
  private ArrayList<Expression> expressions;
  private ConstraintSet typeConstraints;
  private TypeContext typeContext;
  private ArrayList<Binding> variableContext;
  
  public Parser(String program)
  {
    this.tokens = new ArrayList<String>();
    this.expressions = new ArrayList<Expression>();
    this.typeConstraints = ConstraintSet.EMPTY;
    this.typeContext = TypeContext.EMPTY;
    this.variableContext = new ArrayList<Binding>();
    StringTokenizer tokenizer = new StringTokenizer(program,"; ",false);
    while(tokenizer.hasMoreTokens())
      this.tokens.add(tokenizer.nextToken());
  }
  
  public String toString()
  {
    String output = "[";
    for(int i = 0; i<this.tokens.size()-1;i++)
      output += this.tokens.get(i)+",";
    output += this.tokens.get(this.tokens.size()-1)+"]";
    return output;
  }
  
  //creates the expression object from the
  public Expression makeExpression(String in)
  {
    String input = in.trim();
    StringBuilder builder = new StringBuilder(in);
    Expression output = Expression.EMPTY;
    //base cases
    if(Int.isInt(input))
      output = new Int(in);
    else if(Real.isReal(input))
      output = new Real(in);
    else if(Boolean.isBoolean(input))
      output = new Boolean(in);
    else if(input.startsWith("fn"))
    {
      Variable var = new Variable(input.substring(3,input.indexOf("=>")).trim());
      Expression e = this.makeExpression(input.substring(input.indexOf("=>")+2).trim());
      output = new Function(var, e);
      this.typeContext.augment(var, e.type);
    }
    else if(input.startsWith("if"))
      output = new If(this.makeExpression(input.substring(3,input.indexOf("then")).trim()), 
                    this.makeExpression(input.substring(input.indexOf("then")+4, input.indexOf("else")).trim()),
                    this.makeExpression(input.substring(input.indexOf("else")+4).trim()));
    else if(input.startsWith("rec"))
      output = new Recursion(new Variable(input.substring(4,input.indexOf("=>")).trim()), this.makeExpression(input.substring(input.indexOf("=>")+2).trim()));
    else if(input.startsWith("let"))
    {
      Variable var = new Variable(input.substring(4,input.indexOf("=")).trim());
      Expression e = this.makeExpression(input.substring(input.indexOf("=")+1, input.indexOf("in")).trim());
      output = new Let(new Binding(var, e), this.makeExpression(input.substring(input.indexOf("in")+3).trim()));
      this.typeContext.augment(var, e.type);
    }
    this.typeConstraints = output.infer(this.typeContext);
    return output;
  }
}