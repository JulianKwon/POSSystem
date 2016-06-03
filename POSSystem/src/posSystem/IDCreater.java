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
		
		randomid = r.nextInt(9998) + 1;
		
		while(IDs.contains(randomid))
			randomid = r.nextInt(9998) + 1;
		IDs.add(randomid);
		return randomid;
	}
}