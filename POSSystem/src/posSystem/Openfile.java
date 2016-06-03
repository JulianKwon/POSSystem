package posSystem;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.StringTokenizer;

public class Openfile
{
	private File input;
	private static Connection dbTest;

	public Openfile(File in)
	{
		input = in;
		System.out.println("저장경로 : " + input.toString());
		read();
	}

	void read()
	{
		IDCreater idc = new IDCreater();
		int num = 0;
		try
		{
			FileReader fileReader = new FileReader(input);
			BufferedReader reader = new BufferedReader(fileReader);
			String line = null;
			while ((line = reader.readLine()) != null)
			{
				if (isStringDouble(line))
				{
					if(num == 0)
					{
						String clientname = null, rate = null;
						int birthday = 0, phonenumber = 0, ID = 0;
						
						for (int i = 0 ; i < Integer.parseInt(line); i++)
						{
							int count = 3;
							line = reader.readLine();
							StringTokenizer st = new StringTokenizer(line, "\t");
							while(st.hasMoreTokens())
							{
								if(count == 3)
									clientname = st.nextToken();
								else if (count == 2)
									birthday = Integer.parseInt(st.nextToken());
								else if (count == 1)
									phonenumber = Integer.parseInt(st.nextToken());
								else
									rate = st.nextToken();
								count--;
							}
							ID = idc.IDCreate();
							
							String sqlStr = "insert into client values(" + ID + ", " + clientname + ", " + birthday + ", " + phonenumber + ", "
									+ rate + ")";
							PreparedStatement stmt = dbTest.prepareStatement(sqlStr);
							ResultSet rs = stmt.executeQuery();
							rs.next();
						}
						
					}
				}
			}
			// read line then insert number

			reader.close();
		} catch (Exception ex)
		{
		}
	}

	public static boolean isStringDouble(String s)
	{
		try
		{
			Double.parseDouble(s);
			return true;
		} catch (NumberFormatException e)
		{
			return false;
		}
	}
}
