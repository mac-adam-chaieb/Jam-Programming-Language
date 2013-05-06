import java.math.BigDecimal;
import java.math.BigInteger;

public class Value extends Int
{
  public BigInteger number;
  public BigDecimal real;
  public boolean bool;
  public Function function;
  
  public Value(Int n)
  {
    this.number = n.number;
  }
  
  public Value(Real r)
  {
    this.real = r.real;
  }
  
  public Value(Boolean b)
  {
    this.bool = b.bool;
  }
  
  public Value(Function f)
  {
    this.function = f;
  }
}