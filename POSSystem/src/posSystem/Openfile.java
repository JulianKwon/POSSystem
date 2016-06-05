package posSystem;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.StringTokenizer;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Openfile
{
	private File input;
	private static Connection dbTest;
	private static JFrame open = new JFrame();
	private static PreparedStatement stmt;
	private static ResultSet rs;
	private static IDCreater idc = new IDCreater();
	private static StringTokenizer st;

	public Openfile()
	{
		String sql = null;

		// connectdb
		// initiate db

		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileFilter(new FileNameExtensionFilter("텍스트", "txt"));
		fileChooser.setCurrentDirectory(new File(System.getProperty("user.home") + "//" + "Desktop"));

		int result = fileChooser.showOpenDialog(open);

		if (result == JFileChooser.APPROVE_OPTION)
		{
			input = fileChooser.getSelectedFile();

			System.out.println("저장경로 : " + input.toString());
			int mod = 0;

			try
			{

				FileReader fileReader = new FileReader(input);
				BufferedReader reader = new BufferedReader(fileReader);
				String line = null;
				while ((line = reader.readLine()) != null)
				{

					if (line.length() <= 2)
						mod++;

					if (mod == 1)
					{
						st = new StringTokenizer(line, "\t");
						int clientid = idc.IDCreate(), totalpay = 0;

						String[] str1 = new String[st.countTokens()];

						for (int i = 0; i < str1.length; i++)
							str1[i] = st.nextToken();
						if (str1[3].equals("Gold"))
							totalpay = 1000000;
						else if (str1[3].equals("Silver"))
							totalpay = 500000;
						else if (str1[3].equals("Bronze"))
							totalpay = 100000;

						if (str1.length >= 2)
						{
							sql = "insert into customer(id, name, birth, phone, rank, totalspent) values(" + clientid
									+ ", '" + str1[0] + "', " + str1[1] + "," + str1[2] + ",'" + str1[3] + "',"
									+ totalpay + ")";

							stmt = dbTest.prepareStatement(sql);
							rs = stmt.executeQuery();
							rs.close();
							stmt.close();
						}

					}
					if (mod == 2)
					{
						st = new StringTokenizer(line, "\t");
						int employeeid = idc.IDCreate();

						String[] str2 = new String[st.countTokens()];

						for (int i = 0; i < str2.length; i++)
							str2[i] = st.nextToken();

						if (str2.length > 1)
						{
							sql = "insert into employee(name, role, id, totalsell) values('" + str2[0] + "', '"
									+ str2[1] + "'," + employeeid + ", 0)";
							stmt = dbTest.prepareStatement(sql);
							rs = stmt.executeQuery();
							rs.close();
							stmt.close();
						}
					}

					if (mod == 3)
					{
						st = new StringTokenizer(line, "\t");
						int menuid = idc.IDCreate();

						String[] str3 = new String[st.countTokens()];

						for (int i = 0; i < str3.length; i++)
							str3[i] = st.nextToken();

						if (str3.length >= 2)
						{
							sql = "insert into menu values(" + menuid + ", '" + str3[0] + "', " + str3[1] + ")";
							stmt = dbTest.prepareStatement(sql);
							rs = stmt.executeQuery();
							rs.close();
							stmt.close();
						}
					}
				}

				// read line then insert number

				reader.close();
			} catch (Exception ex)
			{
			}
		}
	}
}
