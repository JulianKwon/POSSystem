package posSystem;

import java.awt.Color;
import java.util.StringTokenizer;

public class OrderTable
{
	int tablenum;
	
	public OrderTable(int tablenum)
	{
		this.tablenum = tablenum;
		Mainpage.tablebtn[tablenum].setBackground(Color.YELLOW);
		
		String input = Mainpage.orderarea.getText();
		StringTokenizer st = new StringTokenizer(input, "\n");
		
		while (st.nextToken() != null)
		{
			String in = st.nextToken(input);
			StringTokenizer st2 = new StringTokenizer(in, "\t");
			
		}
	}
}
