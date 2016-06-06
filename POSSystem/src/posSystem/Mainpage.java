package posSystem;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Mainpage extends JFrame implements ActionListener
{
	static PreparedStatement stmt;
	static ResultSet rs;
	
	static JMenuBar menubar = new JMenuBar();
	static JMenuItem open, loginmenu;
	static JMenu menu;
	
	static JButton pay, cancel, order, tablebtn[] = new JButton[20], menus[] = new JButton[20];
	
	
	static JComboBox<String> tablenum;
	static JTextField clientname;
	
	static JTextArea orderarea;
	
	static int gap = 10;
	static int titleh = 90;
	static int width = 800;
	static int height = 1000;
	static int compw = 380;
	static int tablel = 390;
	static int height1 = 110;
	static int titlewidth = 760;
	static Color col = new Color(194, 194, 214);
	static int menuleng;
	
	// mainpage 구성
	public Mainpage()
	{
		setTitle("식당 관리 시스템");
		setResizable(false);
		
		setLayout(null);
		LineBorder border = new LineBorder(Color.BLACK, 1);
		
		JPanel main = new JPanel();
		main.setLayout(null);
		main.setBackground(col);
		main.setSize(width, height);
		
		JPanel p = new JPanel();
		
		p.setBounds(gap, gap, titlewidth, titleh);
		p.setBorder(border);
		p.setLayout(new BorderLayout());
		
		JLabel title = new JLabel("식당 주문관리");
		title.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		title.setHorizontalAlignment(NORMAL);
		title.setBorder(border);
		p.setBackground(col);

		
		p.add(title);
		
		main.add(p);
		main.add(table());
		main.add(order());
		main.add(menu());
		main.add(join());
				
		this.add(main);
		
		this.setSize(width, height);
		this.setJMenuBar(mkmenu());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	public JMenuBar mkmenu()
	{
		menu = new JMenu("menu");
		menu.setFont(new Font("Helvetica", Font.PLAIN, 15));
		
		open = new JMenuItem("open");
		open.setFont(new Font("Helvetica", Font.PLAIN, 15));
		open.addActionListener(this);

        loginmenu = new JMenuItem("login");
        loginmenu.setFont(new Font("Helvetica", Font.PLAIN, 15));
        loginmenu.addActionListener(this);

        menu.add(open);
        menu.add(loginmenu);
        
        menubar.add(menu);
        
		return menubar;
	}
	
	// 테이블 관리 패널
	public JPanel table()
	{
		int size = 60;
		TitledBorder tab = new TitledBorder(new LineBorder(Color.BLACK), "테이블 현황");
		tab.setTitleFont(new Font("맑은 고딕", Font.PLAIN, 15));
		LineBorder border = new LineBorder(Color.BLACK);
		JPanel table = new JPanel();
		table.setLayout(new FlowLayout());
		table.setBorder(tab);
		table.setBounds(gap , height1 + gap, compw, 300);
		
		for(int i = 0; i < 20; i++) {
            tablebtn[i] = new JButton(String.valueOf(i + 1));
            tablebtn[i].setLayout(new BorderLayout());
            tablebtn[i].setPreferredSize(new Dimension(size, size));
            tablebtn[i].setBorder(border);
            tablebtn[i].setHorizontalAlignment(NORMAL);
            tablebtn[i].addActionListener(this);
            
            if(true)
            	tablebtn[i].setBackground(Color.WHITE);
        }
		
		for(int i = 0 ; i < 20; i++)
			table.add(tablebtn[i]);

		table.setBackground(col);
		
		return table;
	}
	
	// 주문내역 관리 패널
	public JPanel order()
	{
		int h = 300 - gap * 4;
		int w = compw - 150; 
		TitledBorder tab = new TitledBorder(new LineBorder(Color.BLACK), "주문내역");
		tab.setTitleFont(new Font("맑은 고딕", Font.PLAIN, 15));
		JPanel pan = new JPanel();
		pan.setLayout(null);
		pan.setBorder(tab);
		pan.setBounds(tablel , height1 + gap, compw, 300);
		pan.setBackground(col);
		
		orderarea = new JTextArea(15, 1);
		orderarea.setBounds(15, 25, w, h);
		orderarea.setEditable(false);
		
		JLabel name = new JLabel("고객명");
		name.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		name.setBounds(w + gap*3, gap * 2, 50, 25);
		
		clientname = new JTextField();
		clientname.setBounds(w + gap*3, gap * 3 + 15, 100, 25);
		clientname.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		
		JLabel tname = new JLabel("테이블명");
		tname.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		tname.setBounds(w + gap*3, gap * 3 + 60, 70, 25);
		
		tablenum = new JComboBox<String>();
		for (int i = 1; i <= 20; i++)
			tablenum.addItem(String.valueOf(i));
		tablenum.setBounds(w + gap*3 + 20, gap * 3 + 90, 60, 25);
		tablenum.addActionListener(this);
		
		order = new JButton("주문");
		order.setBounds(w + gap*3 + 30, gap * 3 + 140, 70, 25);
		order.addActionListener(this);
		
		cancel = new JButton("취소");
		cancel.setBounds(w + gap*3 + 30, gap * 3 + 180, 70, 25);
		cancel.addActionListener(this);
		
		pay = new JButton("결제");
		pay.setBounds(w + gap*3 + 30, gap * 3 + 220, 70, 25);
		pay.addActionListener(this);
		
		pan.add(orderarea);
		pan.add(name);
		pan.add(clientname);
		pan.add(tname);
		pan.add(tablenum);
		pan.add(order);
		pan.add(cancel);
		pan.add(pay);
		return pan;
	}
	
	//메뉴 추가
	public JPanel menu()
	{
		int width = (compw - gap*2)/2 - 10;
		TitledBorder tab = new TitledBorder(new LineBorder(Color.BLACK), "메뉴");
		tab.setTitleFont(new Font("맑은 고딕", Font.PLAIN, 15));
		JPanel pan = new JPanel();
		pan.setLayout(new GridLayout(10, 2, 7, 7));
		pan.setBorder(tab);
		pan.setBounds(gap, height1 + 300 + gap*2, compw, 490);
		pan.setBackground(col);
		
		for(int i = 0; i < 20; i++) 
		{
			menus[i] = new JButton();
            menus[i].setPreferredSize(new Dimension(width, 30));
            menus[i].setFont(new Font("맑은 고딕", Font.PLAIN, 15));
            menus[i].addActionListener(this);
        }
		
		for(int i = 0 ; i < 20; i++)
			pan.add(menus[i]);
		
		return pan;
	}
	
	public JTabbedPane join()
	{
		Supervisor s = new Supervisor();
		TitledBorder tab = new TitledBorder(new LineBorder(Color.BLACK), "등록/조회");
		tab.setTitleFont(new Font("맑은 고딕", Font.PLAIN, 15));
		JTabbedPane pan = new JTabbedPane();
		pan.setBorder(tab);
		pan.setBounds(tablel , height1 + 300 + gap*2, compw, 490);
		pan.setBackground(col);
		
		JPanel client = s.client();
		JPanel sales = s.sales();
		JPanel clerks = s.clerks();
		JPanel menu = s.menu();
		
		
		pan.add("고객", client);
		pan.add("매출", sales);
		pan.add("직원", clerks);
		pan.add("메뉴", menu);
		
		return pan;
	}
	
	public void actionPerformed(ActionEvent e)
	{
		// TODO Auto-generated method stub
		if(e.getSource() == loginmenu)
		{
			new DBconnect();
		}
		if (e.getSource() == open)
		{
			try
			{
				new Openfile();
			} catch (SQLException | IOException e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		if (e.getSource() == order)
		{
			try
			{
				new OrderTable();
			} catch (SQLException e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} 
		if (e.getSource() == cancel)
		{
			int input = Integer.parseInt(tablenum.getSelectedItem().toString());
			
		} 
		if (e.getSource() == pay)
		{
		}
		if (e.getSource() == tablenum)
		{
			String sql = "select menuname, price from tableorder where tablenum = " + tablenum.getSelectedItem();
			String line = null;
			try{
				stmt = DBconnect.dbTest.prepareStatement(sql);
				rs = stmt.executeQuery();
				int total = 0;
				while(rs.next())
				{
					line += rs.getString("menuname") + "\t" + rs.getInt("price") + "\n";
					total += rs.getInt("price");
				}
				
				orderarea.setText(line);
				orderarea.setText("\n" + "-------------------------" + "\n" + "총 합계\t" + total);
				
				rs.close();
				stmt.close();
				
			}catch (SQLException e1)
			{
				e1.printStackTrace();
			}
		}
		if(e.getSource() == menus[0])
		{
			// TODO Auto-generated method stub
			if(e.getSource() == menus[0])
			{
				if (!menus[0].getText().equals(""))
				{
					String text = orderarea.getText();
					
					String sql;
					PreparedStatement stmt;
					ResultSet rs;
					
					sql = "select name, price from menu where name = '" + (String) menus[0].getText() + "'";
					
					try
					{	
						stmt = DBconnect.dbTest.prepareStatement(sql);
						rs = stmt.executeQuery();
						rs.next();
						
						String name = rs.getString("name");
						int price = rs.getInt("price");
						
						orderarea.setText(name + "\t" + price + "\n" + text);
						
						rs.close();
						stmt.close();
						
					} catch(SQLException e1)
					{
						e1.printStackTrace();
					}
				}
			}
		}
		if(e.getSource() == menus[1])
		{
			// TODO Auto-generated method stub
			if(e.getSource() == menus[1])
			{
				if (!menus[1].getText().equals(""))
				{
					String text = orderarea.getText();
					
					String sql;
					PreparedStatement stmt;
					ResultSet rs;
					
					sql = "select name, price from menu where name = '" + (String) menus[1].getText() + "'";
					
					try
					{	
						stmt = DBconnect.dbTest.prepareStatement(sql);
						rs = stmt.executeQuery();
						rs.next();
						
						String name = rs.getString("name");
						int price = rs.getInt("price");
						
						orderarea.setText(name + "\t" + price + "\n" + text);
						
						rs.close();
						stmt.close();
						
					} catch(SQLException e1)
					{
						e1.printStackTrace();
					}
				}
			}
		}
		if(e.getSource() == menus[2])
		{
			// TODO Auto-generated method stub
			if(e.getSource() == menus[2])
			{
				if (!menus[2].getText().equals(""))
				{
					String text = orderarea.getText();
					
					String sql;
					PreparedStatement stmt;
					ResultSet rs;
					
					sql = "select name, price from menu where name = '" + (String) menus[2].getText() + "'";
					
					try
					{	
						stmt = DBconnect.dbTest.prepareStatement(sql);
						rs = stmt.executeQuery();
						rs.next();
						
						String name = rs.getString("name");
						int price = rs.getInt("price");
						
						orderarea.setText(name + "\t" + price + "\n" + text);
						
						rs.close();
						stmt.close();
						
					} catch(SQLException e1)
					{
						e1.printStackTrace();
					}
				}
			}
		}
		if(e.getSource() == menus[3])
		{
			// TODO Auto-generated method stub
			if(e.getSource() == menus[3])
			{
				if (!menus[3].getText().equals(""))
				{
					String text = orderarea.getText();
					
					String sql;
					PreparedStatement stmt;
					ResultSet rs;
					
					sql = "select name, price from menu where name = '" + (String) menus[3].getText() + "'";
					
					try
					{	
						stmt = DBconnect.dbTest.prepareStatement(sql);
						rs = stmt.executeQuery();
						rs.next();
						
						String name = rs.getString("name");
						int price = rs.getInt("price");
						
						orderarea.setText(name + "\t" + price + "\n" + text);
						
						rs.close();
						stmt.close();
						
					} catch(SQLException e1)
					{
						e1.printStackTrace();
					}
				}
			}
		}
		if(e.getSource() == menus[4])
		{
			// TODO Auto-generated method stub
			if(e.getSource() == menus[4])
			{
				if (!menus[4].getText().equals(""))
				{
					String text = orderarea.getText();
					
					String sql;
					PreparedStatement stmt;
					ResultSet rs;
					
					sql = "select name, price from menu where name = '" + (String) menus[4].getText() + "'";
					
					try
					{	
						stmt = DBconnect.dbTest.prepareStatement(sql);
						rs = stmt.executeQuery();
						rs.next();
						
						String name = rs.getString("name");
						int price = rs.getInt("price");
						
						orderarea.setText(name + "\t" + price + "\n" + text);
						
						rs.close();
						stmt.close();
						
					} catch(SQLException e1)
					{
						e1.printStackTrace();
					}
				}
			}
		}
		if(e.getSource() == menus[5])
		{
			// TODO Auto-generated method stub
			if(e.getSource() == menus[5])
			{
				if (!menus[5].getText().equals(""))
				{
					String text = orderarea.getText();
					
					String sql;
					PreparedStatement stmt;
					ResultSet rs;
					
					sql = "select name, price from menu where name = '" + (String) menus[5].getText() + "'";
					
					try
					{	
						stmt = DBconnect.dbTest.prepareStatement(sql);
						rs = stmt.executeQuery();
						rs.next();
						
						String name = rs.getString("name");
						int price = rs.getInt("price");
						
						orderarea.setText(name + "\t" + price + "\n" + text);
						
						rs.close();
						stmt.close();
						
					} catch(SQLException e1)
					{
						e1.printStackTrace();
					}
				}
			}
		}
		if(e.getSource() == menus[6])
		{
			// TODO Auto-generated method stub
			if(e.getSource() == menus[6])
			{
				if (!menus[6].getText().equals(""))
				{
					String text = orderarea.getText();
					
					String sql;
					PreparedStatement stmt;
					ResultSet rs;
					
					sql = "select name, price from menu where name = '" + (String) menus[6].getText() + "'";
					
					try
					{	
						stmt = DBconnect.dbTest.prepareStatement(sql);
						rs = stmt.executeQuery();
						rs.next();
						
						String name = rs.getString("name");
						int price = rs.getInt("price");
						
						orderarea.setText(name + "\t" + price + "\n" + text);
						
						rs.close();
						stmt.close();
						
					} catch(SQLException e1)
					{
						e1.printStackTrace();
					}
				}
			}
		}
		if(e.getSource() == menus[7])
		{
			// TODO Auto-generated method stub
			if(e.getSource() == menus[7])
			{
				if (!menus[7].getText().equals(""))
				{
					String text = orderarea.getText();
					
					String sql;
					PreparedStatement stmt;
					ResultSet rs;
					
					sql = "select name, price from menu where name = '" + (String) menus[7].getText() + "'";
					
					try
					{	
						stmt = DBconnect.dbTest.prepareStatement(sql);
						rs = stmt.executeQuery();
						rs.next();
						
						String name = rs.getString("name");
						int price = rs.getInt("price");
						
						orderarea.setText(name + "\t" + price + "\n" + text);
						
						rs.close();
						stmt.close();
						
					} catch(SQLException e1)
					{
						e1.printStackTrace();
					}
				}
			}
		}
		if(e.getSource() == menus[8])
		{
			// TODO Auto-generated method stub
			if(e.getSource() == menus[8])
			{
				if (!menus[8].getText().equals(""))
				{
					String text = orderarea.getText();
					
					String sql;
					PreparedStatement stmt;
					ResultSet rs;
					
					sql = "select name, price from menu where name = '" + (String) menus[8].getText() + "'";
					
					try
					{	
						stmt = DBconnect.dbTest.prepareStatement(sql);
						rs = stmt.executeQuery();
						rs.next();
						
						String name = rs.getString("name");
						int price = rs.getInt("price");
						
						orderarea.setText(name + "\t" + price + "\n" + text);
						
						rs.close();
						stmt.close();
						
					} catch(SQLException e1)
					{
						e1.printStackTrace();
					}
				}
			}
		}
		if(e.getSource() == menus[9])
		{
			// TODO Auto-generated method stub
			if(e.getSource() == menus[9])
			{
				if (!menus[9].getText().equals(""))
				{
					String text = orderarea.getText();
					
					String sql;
					PreparedStatement stmt;
					ResultSet rs;
					
					sql = "select name, price from menu where name = '" + (String) menus[9].getText() + "'";
					
					try
					{	
						stmt = DBconnect.dbTest.prepareStatement(sql);
						rs = stmt.executeQuery();
						rs.next();
						
						String name = rs.getString("name");
						int price = rs.getInt("price");
						
						orderarea.setText(name + "\t" + price + "\n" + text);
						
						rs.close();
						stmt.close();
						
					} catch(SQLException e1)
					{
						e1.printStackTrace();
					}
				}
			}
		}
		if(e.getSource() == menus[10])
		{
			// TODO Auto-generated method stub
			if(e.getSource() == menus[10])
			{
				if (!menus[10].getText().equals(""))
				{
					String text = orderarea.getText();
					
					String sql;
					PreparedStatement stmt;
					ResultSet rs;
					
					sql = "select name, price from menu where name = '" + (String) menus[10].getText() + "'";
					
					try
					{	
						stmt = DBconnect.dbTest.prepareStatement(sql);
						rs = stmt.executeQuery();
						rs.next();
						
						String name = rs.getString("name");
						int price = rs.getInt("price");
						
						orderarea.setText(name + "\t" + price + "\n" + text);
						
						rs.close();
						stmt.close();
						
					} catch(SQLException e1)
					{
						e1.printStackTrace();
					}
				}
			}
		}
		if(e.getSource() == menus[11])
		{
			// TODO Auto-generated method stub
			if(e.getSource() == menus[11])
			{
				if (!menus[11].getText().equals(""))
				{
					String text = orderarea.getText();
					
					String sql;
					PreparedStatement stmt;
					ResultSet rs;
					
					sql = "select name, price from menu where name = '" + (String) menus[11].getText() + "'";
					
					try
					{	
						stmt = DBconnect.dbTest.prepareStatement(sql);
						rs = stmt.executeQuery();
						rs.next();
						
						String name = rs.getString("name");
						int price = rs.getInt("price");
						
						orderarea.setText(name + "\t" + price + "\n" + text);
						
						rs.close();
						stmt.close();
						
					} catch(SQLException e1)
					{
						e1.printStackTrace();
					}
				}
			}
		}
		if(e.getSource() == menus[12])
		{
			// TODO Auto-generated method stub
			if(e.getSource() == menus[12])
			{
				if (!menus[12].getText().equals(""))
				{
					String text = orderarea.getText();
					
					String sql;
					PreparedStatement stmt;
					ResultSet rs;
					
					sql = "select name, price from menu where name = '" + (String) menus[12].getText() + "'";
					
					try
					{	
						stmt = DBconnect.dbTest.prepareStatement(sql);
						rs = stmt.executeQuery();
						rs.next();
						
						String name = rs.getString("name");
						int price = rs.getInt("price");
						
						orderarea.setText(name + "\t" + price + "\n" + text);
						
						rs.close();
						stmt.close();
						
					} catch(SQLException e1)
					{
						e1.printStackTrace();
					}
				}
			}
		}
		if(e.getSource() == menus[13])
		{
			// TODO Auto-generated method stub
			if(e.getSource() == menus[13])
			{
				if (!menus[13].getText().equals(""))
				{
					String text = orderarea.getText();
					
					String sql;
					PreparedStatement stmt;
					ResultSet rs;
					
					sql = "select name, price from menu where name = '" + (String) menus[13].getText() + "'";
					
					try
					{	
						stmt = DBconnect.dbTest.prepareStatement(sql);
						rs = stmt.executeQuery();
						rs.next();
						
						String name = rs.getString("name");
						int price = rs.getInt("price");
						
						orderarea.setText(name + "\t" + price + "\n" + text);
						
						rs.close();
						stmt.close();
						
					} catch(SQLException e1)
					{
						e1.printStackTrace();
					}
				}
			}
		}
		if(e.getSource() == menus[14])
		{
			// TODO Auto-generated method stub
			if(e.getSource() == menus[14])
			{
				if (!menus[14].getText().equals(""))
				{
					String text = orderarea.getText();
					
					String sql;
					PreparedStatement stmt;
					ResultSet rs;
					
					sql = "select name, price from menu where name = '" + (String) menus[14].getText() + "'";
					
					try
					{	
						stmt = DBconnect.dbTest.prepareStatement(sql);
						rs = stmt.executeQuery();
						rs.next();
						
						String name = rs.getString("name");
						int price = rs.getInt("price");
						
						orderarea.setText(name + "\t" + price + "\n" + text);
						
						rs.close();
						stmt.close();
						
					} catch(SQLException e1)
					{
						e1.printStackTrace();
					}
				}
			}
		}
		if(e.getSource() == menus[15])
		{
			// TODO Auto-generated method stub
			if(e.getSource() == menus[15])
			{
				if (!menus[15].getText().equals(""))
				{
					String text = orderarea.getText();
					
					String sql;
					PreparedStatement stmt;
					ResultSet rs;
					
					sql = "select name, price from menu where name = '" + (String) menus[15].getText() + "'";
					
					try
					{	
						stmt = DBconnect.dbTest.prepareStatement(sql);
						rs = stmt.executeQuery();
						rs.next();
						
						String name = rs.getString("name");
						int price = rs.getInt("price");
						
						orderarea.setText(name + "\t" + price + "\n" + text);
						
						rs.close();
						stmt.close();
						
					} catch(SQLException e1)
					{
						e1.printStackTrace();
					}
				}
			}
		}
		if(e.getSource() == menus[16])
		{
			// TODO Auto-generated method stub
			if(e.getSource() == menus[16])
			{
				if (!menus[16].getText().equals(""))
				{
					String text = orderarea.getText();
					
					String sql;
					PreparedStatement stmt;
					ResultSet rs;
					
					sql = "select name, price from menu where name = '" + (String) menus[16].getText() + "'";
					
					try
					{	
						stmt = DBconnect.dbTest.prepareStatement(sql);
						rs = stmt.executeQuery();
						rs.next();
						
						String name = rs.getString("name");
						int price = rs.getInt("price");
						
						orderarea.setText(name + "\t" + price + "\n" + text);
						
						rs.close();
						stmt.close();
						
					} catch(SQLException e1)
					{
						e1.printStackTrace();
					}
				}
			}
		}
		if(e.getSource() == menus[17])
		{
			// TODO Auto-generated method stub
			if(e.getSource() == menus[17])
			{
				if (!menus[17].getText().equals(""))
				{
					String text = orderarea.getText();
					
					String sql;
					PreparedStatement stmt;
					ResultSet rs;
					
					sql = "select name, price from menu where name = '" + (String) menus[17].getText() + "'";
					
					try
					{	
						stmt = DBconnect.dbTest.prepareStatement(sql);
						rs = stmt.executeQuery();
						rs.next();
						
						String name = rs.getString("name");
						int price = rs.getInt("price");
						
						orderarea.setText(name + "\t" + price + "\n" + text);
						
						rs.close();
						stmt.close();
						
					} catch(SQLException e1)
					{
						e1.printStackTrace();
					}
				}
			}
		}
		if(e.getSource() == menus[18])
		{
			// TODO Auto-generated method stub
			if(e.getSource() == menus[18])
			{
				if (!menus[18].getText().equals(""))
				{
					String text = orderarea.getText();
					
					String sql;
					PreparedStatement stmt;
					ResultSet rs;
					
					sql = "select name, price from menu where name = '" + (String) menus[18].getText() + "'";
					
					try
					{	
						stmt = DBconnect.dbTest.prepareStatement(sql);
						rs = stmt.executeQuery();
						rs.next();
						
						String name = rs.getString("name");
						int price = rs.getInt("price");
						
						orderarea.setText(name + "\t" + price + "\n" + text);
						
						rs.close();
						stmt.close();
						
					} catch(SQLException e1)
					{
						e1.printStackTrace();
					}
				}
			}
		}
		if(e.getSource() == menus[19])
		{
			// TODO Auto-generated method stub
			if(e.getSource() == menus[19])
			{
				if (!menus[19].getText().equals(""))
				{
					String text = orderarea.getText();
					
					String sql;
					PreparedStatement stmt;
					ResultSet rs;
					
					sql = "select name, price from menu where name = '" + (String) menus[19].getText() + "'";
					
					try
					{	
						stmt = DBconnect.dbTest.prepareStatement(sql);
						rs = stmt.executeQuery();
						rs.next();
						
						String name = rs.getString("name");
						int price = rs.getInt("price");
						
						orderarea.setText(name + "\t" + price + "\n" + text);
						
						rs.close();
						stmt.close();
						
					} catch(SQLException e1)
					{
						e1.printStackTrace();
					}
				}
			}
		}
		
		
	}
	
	// DB에서 menu명을 가져와 menus 버튼에 set(login 시 일어남)
	public static void setmenu()
	{
		try
		{
			String sql = "select count(name) from menu";
			stmt = DBconnect.dbTest.prepareStatement(sql);
			rs = stmt.executeQuery();
			rs.next();
			int num = rs.getInt("count(name)");
		
			sql = "select name from menu";
			stmt = DBconnect.dbTest.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			if (rs.next())
			{
				for (int i = 0 ; i < rs.getRow(); i++)
				{
					if(num <= 10)
						menus[2*i].setText(rs.getString("name"));
					else
						menus[2*i+1].setText(rs.getString("name"));
					if(!rs.next())
						break;
				}
			}
			
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
