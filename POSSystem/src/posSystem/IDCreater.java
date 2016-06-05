package posSystem;

import java.util.*;

public class IDCreater
{
	private int randomid;
	private Random r;
	private ArrayList<Integer> IDs;

	public int IDCreate()
	{
		r = new Random();
		IDs = new ArrayList<Integer>();

		String str = "";
		int d = 0;
		for (int i = 1; i <= 4; i++)
		{
			d = r.nextInt(9);
			str = str + Integer.toString(d);
		}
		randomid = Integer.parseInt(str);
		
		while (IDs.contains(randomid))
		{
			for (int i = 1; i <= 4; i++)
			{
				d = r.nextInt(9);
				str = str + Integer.toString(d);
			}
			randomid = Integer.parseInt(str);
		}
		
		IDs.add(randomid);
		return randomid;
	}
}