import java.util.ArrayList;
import java.util.StringTokenizer;

public class Parser
{
  private ArrayList<String> program;
  
  public Parser(String program)
  {
    this.program = new ArrayList<String>();
    StringTokenizer tokenizer = new StringTokenizer(program,";");
    while(tokenizer.hasMoreTokens())
      this.program.add(tokenizer.nextToken());
  }
}