package jam.core.typing;

import java.util.ArrayList;

/*
 * @author Mohamed Adam Chaieb
 * 
 * This class represents the list type variable, e.g. {INT,INT,REAL,BOOLEAN} is a type
 * */

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
		if(other instanceof ListType)
		{
			ListType t = (ListType)other;
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

	public String toString()
	{
		String output = "{";
		for(int i = 0;i<typeList.size()-1;i++)
			output += this.typeList.get(i).toString()+",";
		output += this.typeList.get(this.typeList.size()-1)+"}";
		return output;
	}
}