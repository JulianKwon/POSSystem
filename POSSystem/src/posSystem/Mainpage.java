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
	
	// mainpage ����
	public Mainpage()
	{
		setTitle("�Ĵ� ���� �ý���");
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
		
		JLabel title = new JLabel("�Ĵ� �ֹ�����");
		title.setFont(new Font("���� ���", Font.BOLD, 30));
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
	
	// ���̺� ���� �г�
	public JPanel table()
	{
		int size = 60;
		TitledBorder tab = new TitledBorder(new LineBorder(Color.BLACK), "���̺� ��Ȳ");
		tab.setTitleFont(new Font("���� ���", Font.PLAIN, 15));
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
	
	// �ֹ����� ���� �г�
	public JPanel order()
	{
		int h = 300 - gap * 4;
		int w = compw - 150; 
		TitledBorder tab = new TitledBorder(new LineBorder(Color.BLACK), "�ֹ�����");
		tab.setTitleFont(new Font("���� ���", Font.PLAIN, 15));
		JPanel pan = new JPanel();
		pan.setLayout(null);
		pan.setBorder(tab);
		pan.setBounds(tablel , height1 + gap, compw, 300);
		pan.setBackground(col);
		
		orderarea = new JTextArea(15, 1);
		orderarea.setBounds(15, 25, w, h);
		
		JLabel name = new JLabel("����");
		name.setFont(new Font("���� ���", Font.PLAIN, 15));
		name.setBounds(w + gap*3, gap * 2, 50, 25);
		
		clientname = new JTextField();
		clientname.setBounds(w + gap*3, gap * 3 + 15, 100, 25);
		clientname.setFont(new Font("���� ���", Font.PLAIN, 15));
		
		JLabel tname = new JLabel("���̺��");
		tname.setFont(new Font("���� ���", Font.PLAIN, 15));
		tname.setBounds(w + gap*3, gap * 3 + 60, 70, 25);
		
		tablenum = new JComboBox<String>();
		for (int i = 1; i <= 20; i++)
			tablenum.addItem(String.valueOf(i));
		tablenum.setBounds(w + gap*3 + 20, gap * 3 + 90, 60, 25);
		
		order = new JButton("�ֹ�");
		order.setBounds(w + gap*3 + 30, gap * 3 + 140, 70, 25);
		
		cancel = new JButton("���");
		cancel.setBounds(w + gap*3 + 30, gap * 3 + 180, 70, 25);
		
		pay = new JButton("����");
		pay.setBounds(w + gap*3 + 30, gap * 3 + 220, 70, 25);
		
		
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
	
	//�޴� �߰�
	public JPanel menu()
	{
		int width = (compw - gap*2)/2 - 10;
		TitledBorder tab = new TitledBorder(new LineBorder(Color.BLACK), "�޴�");
		tab.setTitleFont(new Font("���� ���", Font.PLAIN, 15));
		JPanel pan = new JPanel();
		pan.setLayout(new GridLayout(10, 2, 7, 7));
		pan.setBorder(tab);
		pan.setBounds(gap, height1 + 300 + gap*2, compw, 490);
		pan.setBackground(col);
		
		for(int i = 0; i < 20; i++) 
		{
			menus[i] = new JButton();
            menus[i].setPreferredSize(new Dimension(width, 30));
            menus[i].setFont(new Font("���� ���", Font.PLAIN, 15));
        }
		
		for(int i = 0 ; i < 20; i++)
			pan.add(menus[i]);
		
		return pan;
	}
	
	public JTabbedPane join()
	{
		Supervisor s = new Supervisor();
		TitledBorder tab = new TitledBorder(new LineBorder(Color.BLACK), "���/��ȸ");
		tab.setTitleFont(new Font("���� ���", Font.PLAIN, 15));
		JTabbedPane pan = new JTabbedPane();
		pan.setBorder(tab);
		pan.setBounds(tablel , height1 + 300 + gap*2, compw, 490);
		pan.setBackground(col);
		
		JPanel client = s.client();
		JPanel sales = s.sales();
		JPanel clerks = s.clerks();
		JPanel menu = s.menu();
		
		
		pan.add("��", client);
		pan.add("����", sales);
		pan.add("����", clerks);
		pan.add("�޴�", menu);
		
		return pan;
	}
	
	public void actionPerformed(ActionEvent e)
	{
		// TODO Auto-generated method stub
		if(e.getSource() == loginmenu)
		{
			new DBconnect();
		} else if (e.getSource() == open)
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
			int input = Integer.parseInt(tablenum.getSelectedItem().toString());
			new OrderTable(input);
		} 
		if (e.getSource() == cancel)
		{
			int input = Integer.parseInt(tablenum.getSelectedItem().toString());
			
		} 
		if (e.getSource() == pay)
		{
			String cname = clientname.getText();
		}
		if (e.getSource() == tablebtn[0])
		{
			
		}
	}
	
	public static void setmenu()
	{
		try
		{
			String sql = "select count(name) from menu";
			stmt = DBconnect.dbTest.prepareStatement(sql);
			rs = stmt.executeQuery();
			rs.next();
			menuleng = rs.getInt("count(name)");
			System.out.println(menuleng);
			
			for(int i = 0 ; i < menuleng; i++)
			{
				sql = "select name from menu where rownum=" + i + 1;
				stmt = DBconnect.dbTest.prepareStatement(sql);
				rs = stmt.executeQuery();
				rs.next();
				menus[i].setText(rs.getString("name"));
			}
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] argv)
	{
		new Mainpage();
	}
}
