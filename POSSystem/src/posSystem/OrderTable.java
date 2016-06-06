package posSystem;

import java.awt.Color;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.StringTokenizer;

import javax.swing.JOptionPane;

public class OrderTable
{
	int tablenum;
	PreparedStatement stmt;
	ResultSet rs;
	
	//주문버튼처리
	public OrderTable() throws SQLException
	{
		int tablenum = Integer.parseInt(Mainpage.tablenum.getSelectedItem().toString());
		
		System.out.println(tablenum);
		
		String loginid = DBconnect.username;
		
		if(loginid.equals("system"))
		{
			
		}
		
		String sql = "select position from clerk where id = '" + loginid + "'";
		stmt = DBconnect.dbTest.prepareStatement(sql);
		rs = stmt.executeQuery();
		String roll = "";
		if(rs.next())
			roll = rs.getString("position");
		
		this.tablenum = tablenum;
		
		if (roll.equals("Supervisor") || roll.equals("Staff"))
		{
			Mainpage.tablebtn[tablenum - 1].setBackground(Color.YELLOW);
			String input = Mainpage.orderarea.getText();

			StringTokenizer st = new StringTokenizer(input);
			String[] str = new String[st.countTokens()];
			
			for(int i = 0; i < str.length; i++)
				str[i] = st.nextToken();
			
			//connect DB
			sql = "delete from tableorder where tablenum = " + tablenum;
			stmt = DBconnect.dbTest.prepareStatement(sql);
			rs = stmt.executeQuery();
			rs.next();
			
			int total = 0;
			
			for(int i = 0; i < str.length; i+= 2)
			{

				sql = "insert into tableorder(tablenum, menuname, price) values(" + tablenum

						+ ",'" + str[i] + "'," + str[i + 1] + ")";

				total += Integer.parseInt(str[i + 1]);
				stmt = DBconnect.dbTest.prepareStatement(sql);
				rs = stmt.executeQuery();
				rs.close();
				stmt.close();
			}
			
			Mainpage.orderarea.setText("총 합계\t" + total);
		}
		else
			JOptionPane.showMessageDialog(null, "로그인 후에 이용 가능합니다.");
	}
}
