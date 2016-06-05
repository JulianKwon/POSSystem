package posSystem;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.StringTokenizer;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Openfile
{
	PreparedStatement stmt;
	ResultSet rs;
	DBconnect db;
	private JFrame open = new JFrame();

	public Openfile() throws SQLException, IOException
	{
		String sql = null;

		initDB();

		// filechooser로 해당 파일 열기
		JFileChooser chooser = new JFileChooser();
		chooser.setFileFilter(new FileNameExtensionFilter("텍스트(.txt)", "txt"));
		chooser.setCurrentDirectory(new File(System.getProperty("user.home") + "//" + "Desktop"));

		int result = chooser.showOpenDialog(open);

		if (result == JFileChooser.APPROVE_OPTION)
		{
			File input = chooser.getSelectedFile();

			int mod = 0;

			try
			{

				FileReader fileReader = new FileReader(input);
				BufferedReader reader = new BufferedReader(fileReader);
				
				String line = null;
				
				while ((line = reader.readLine()) != null)
				{

					if (line.length() <= 2 && isDouble(line))
						mod++;

					else if (mod == 1)
					{
						StringTokenizer st = new StringTokenizer(line, "\t");

						// id 생성
						int clientid = (int) (Math.random() * 9000 + 1000), totalpay = 0;

						String[] str1 = new String[st.countTokens()];

						for (int i = 0; i < str1.length; i++)
							str1[i] = st.nextToken();

						// 회원 등급에 맞게 payment 세팅
						if (str1[3].equals("Gold"))
							totalpay = 1000000;
						else if (str1[3].equals("Silver"))
							totalpay = 500000;
						else if (str1[3].equals("Bronze"))
							totalpay = 100000;
						else
							totalpay = 0;

						if (str1.length >= 2)
						{
							sql = "insert into customer(ID, name, birthday, phone, rate, totalspent) "
									+ "values(" + clientid + ",'" + str1[0] + "',"
									+ str1[1] + "," + str1[2] + ",'" + str1[3] + "'," + totalpay
									+ ")";

							stmt = DBconnect.dbTest.prepareStatement(sql);
							rs = stmt.executeQuery();
							rs.close();
							stmt.close();
						}

					}
					else if (mod == 2)
					{
						StringTokenizer st = new StringTokenizer(line, "\t");

						// 사원 id 생성
						int employeeid = (int) (Math.random() * 9000 + 1000);
						int employeepw = (int) (Math.random() * 9000 + 1000);

						String[] str2 = new String[st.countTokens()];

						for (int i = 0; i < str2.length; i++)
							str2[i] = st.nextToken();

						System.out.println("name : " + str2[0] + "\tid : " + employeeid + "\tpw : " + employeepw);
						if (str2.length > 1)
						{
							sql = "insert into clerk values('" + str2[0] + "','" + str2[1] + "'," + employeeid
									+ "," + employeepw + ",0)";
							stmt = DBconnect.dbTest.prepareStatement(sql);
							rs = stmt.executeQuery();
							rs.close();
							stmt.close();
						}
					}

					else if (mod == 3)
					{
						StringTokenizer st = new StringTokenizer(line, "\t");
						
						// menu id 생성
						int menuid = (int) (Math.random() * 9000 + 1000);

						String[] str3 = new String[st.countTokens()];

						for (int i = 0; i < str3.length; i++)
							str3[i] = st.nextToken();

						if (str3.length >= 2)
						{
							sql = "insert into menu values(" + menuid + ",'" + str3[0] + "'," + str3[1] + ",0)";
							stmt = DBconnect.dbTest.prepareStatement(sql);
							rs = stmt.executeQuery();
							rs.close();
							stmt.close();
						}
					}
				}
				
				reader.close();

				System.out.println("내용이 입력되었습니다.");
			} catch (Exception ex)
			{
				System.out.println("Error:" + ex.getMessage());
			}
		}
		else
			JOptionPane.showMessageDialog(null, "파일을 선택하지 않았습니다.", "경고",
					JOptionPane.WARNING_MESSAGE);
	}

	public void initDB() throws SQLException
	{
		String sql;
		// 테이블 드랍
//		sql = "DROP TABLE customer";
//		stmt = DBconnect.dbTest.prepareStatement(sql);
//		rs = stmt.executeQuery();
//
//		sql = "DROP TABLE clerk";
//		stmt = DBconnect.dbTest.prepareStatement(sql);
//		rs = stmt.executeQuery();
//
//		sql = "DROP TABLE menu";
//		stmt = DBconnect.dbTest.prepareStatement(sql);
//		rs = stmt.executeQuery();
//
//		sql = "DROP TABLE tableorder";
//		stmt = DBconnect.dbTest.prepareStatement(sql);
//		rs = stmt.executeQuery();
//
//		sql = "DROP TABLE sales";
//		stmt = DBconnect.dbTest.prepareStatement(sql);
//		rs = stmt.executeQuery();

		sql = "create table customer (" 
				+ "ID			integer, " 
				+ "name			varchar2(20) not null, "
				+ "birthday		integer, " 
				+ "phone		integer, " 
				+ "rate			varchar2(20), "
				+ "totalspent	integer)";

		stmt = DBconnect.dbTest.prepareStatement(sql);
		rs = stmt.executeQuery();
		System.out.println("customer table이 생성되었습니다.");

		sql = "create table clerk (" 
				+ "name			varchar2(20) not null, "
				+ "posision		varchar2(20), " 
				+ "ID			integer, "
				+ "empPW		integer, "
				+ "totalsell	integer)";

		stmt = DBconnect.dbTest.prepareStatement(sql);
		rs = stmt.executeQuery();
		System.out.println("clerk table이 생성되었습니다.");

		sql = "create table menu(" 
				+ "ID		integer, " 
				+ "name		varchar2(40) not null, " 
				+ "price	integer, "
				+ "sellnum	integer)";

		stmt = DBconnect.dbTest.prepareStatement(sql);
		rs = stmt.executeQuery();
		System.out.println("menu table이 생성되었습니다.");

		sql = "create table tableorder(" 
				+ "tablenum	integer not null, " 
				+ "menuname	varchar2(30) not null, "
				+ "price	integer not null)";
		stmt = DBconnect.dbTest.prepareStatement(sql);
		rs = stmt.executeQuery();
		System.out.println("tableorder table이 생성되었습니다.");

		sql = "create table sales(" 
				+ "selldate	varchar2(10), " 
				+ "total	Integer	not null, "
				+ "empName	varchar(10), " 
				+ "cusName	varchar2(10))";
		stmt = DBconnect.dbTest.prepareStatement(sql);
		rs = stmt.executeQuery();
		System.out.println("sales table이 생성되었습니다.");
	}

	public static boolean isDouble(String s)
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
