package core.jam.parser;

import core.jam.expressions.*;

public class Tester
{
  public static void main(String[] args)
  {
    Parser p = new Parser(args[0]);
    Expression e = p.makeExpression(args[0]);
    Tester.generateReport(e,p);
  }
  
  public static void generateReport(Expression e, Parser p)
  {
    System.out.println("-----Test Report-----");
    System.out.println("Expression: "+e.toString());
    System.out.println("Expression type: "+e.getClass());
    System.out.println("Free variables: "+e.freeVariables);
    System.out.println("Value: "+e.evaluate());
    System.out.println("Evaluation type: "+e.type);
    System.out.println("Type context: "+p.typeContext.toString());
    System.out.println("Type constraints: "+p.typeConstraints.toString());
    //System.out.println("Type checks: "+p.typeConstraints.unifiable());
    System.out.println("Variables: "+p.variableContext);
  }
}