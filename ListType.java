import java.util.ArrayList;

public class ListType extends Type
{
  public ArrayList<Type> typeList = new ArrayList<Type>();
  
  public ListType(ArrayList<Type> typeList)
  {
    this.typeList = typeList;
  }
  
  public Type substitute(Type sub, Type t)
  {
    ArrayList<Type> output = new ArrayList<Type>(this.typeList.size());
    for(Type s : this.typeList)
      output.add(s.substitute(sub,t));
    return new ListType(output);
  }
  
  public boolean equals(Type other)
  {
    ListType t = (ListType)other;
    if(other.getClass() == ListType.class)
    {
      if(t.typeList.size() == this.typeList.size())
      {
        for(int i = 0;i<this.typeList.size();i++)
        {
          if(!this.typeList.get(i).equals(t.typeList.get(i)))
            return false;
        }
        return true;
      }
    }
    return false;
  }
}