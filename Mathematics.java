import java.math.BigInteger;
import java.math.BigDecimal;

/*
 * This class provides math functions and tools as static functions for the Jam language.
 * */

public class Mathematics
{
  //Int functions

  
  //Real functions
  public Real add(Real a, Real b)
  {
    return new Real(a.real.add(b.real));
  }
  
  public Real multiply(Real a, Real b)
  {
    return new Real(a.real.multiply(b.real));
  }
  
  public Real subtract(Real a, Real b)
  {
    return new Real(a.real.subtract(b.real));
  }
  
  public Real divide(Real a, Real b, int scale)
  {
    try{BigDecimal output = a.real.divide(b.real); return new Real(output);}
    catch(Exception e)
    {
      BigDecimal output = a.real.divide(b.real, scale, BigDecimal.ROUND_HALF_UP); 
      return new Real(output);
    }
  }
  
  public Real mod(Real a, Real b)
  {
    return new Real(a.real.remainder(b.real));
  }
  
  public Real negate(Real a)
  {
    return new Real(a.real.negate());
  }
  
  public Real max(Real a, Real b)
  {
    return new Real(a.real.max(b.real));
  }
  
  public Real min(Real a, Real b)
  {
    return new Real(a.real.min(b.real));
  }
}