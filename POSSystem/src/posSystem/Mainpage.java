package posSystem;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class Mainpage extends JFrame
{
	static JMenuBar menubar = new JMenuBar();
	static JMenu menu, open, login;
	static int gap = 10;
	static int titleh = 90;
	static int width = 800;
	static int height = 1000;
	static int compw = width / 2 - gap*2;
	static int tablel = width / 2 - gap;
	static int height1 = gap*2 + titleh;
	static Color col = new Color(194, 194, 214);
	
	public Mainpage()
	{
		int w = 760;
		setTitle("�Ĵ� ���� �ý���");
		
		setLayout(null);
		LineBorder border = new LineBorder(Color.BLACK, 1);
		
		JPanel main = new JPanel();
		main.setLayout(null);
		main.setBackground(col);
		main.setSize(width, height);
		
		JPanel p = new JPanel();
		
		p.setBounds(gap, gap, w, titleh);
		p.setBorder(border);
		p.setLayout(new BorderLayout());
		
		JLabel title = new JLabel("�Ĵ� �ֹ�����");
		title.setFont(new Font("���� ���", Font.BOLD, 30));
		title.setHorizontalAlignment(NORMAL);
		title.setBorder(border);
		p.setBackground(col);

		
		p.add(title);

		JPanel table = Mainpage.table();
		JPanel order = Mainpage.order();
		JPanel menu = Mainpage.menu();
		JPanel join = Mainpage.join();
		
		
		main.add(p);
		main.add(table);
		main.add(order);
		main.add(menu);
		main.add(join);
				
		this.add(main);
		
		this.setSize(width, height);
		this.setJMenuBar(Mainpage.mkmenu());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	public static JMenuBar mkmenu()
	{
		
		menu = new JMenu("menu");
		menu.setFont(new Font("Helvetica", Font.PLAIN, 15));
		
		open = new JMenu("open");
		open.setFont(new Font("Helvetica", Font.PLAIN, 15));
        menu.add(open);

        login = new JMenu("login");
        login.setFont(new Font("Helvetica", Font.PLAIN, 15));
        menu.add(login);
        
        menubar.add(menu);
        
		return menubar;
	}
	
	// ���̺� ���� �г�
	public static JPanel table()
	{
		int size = 60;
		TitledBorder tab = new TitledBorder(new LineBorder(Color.BLACK), "���̺� ��Ȳ");
		tab.setTitleFont(new Font("���� ���", Font.PLAIN, 15));
		LineBorder border = new LineBorder(Color.BLACK);
		JPanel table = new JPanel();
		table.setLayout(new FlowLayout());
		table.setBorder(tab);
		table.setBounds(gap , height1 + gap, compw, 300);
		
		JButton panel[] = new JButton[20];
		
		for(int i = 0; i < 20; i++) {
            panel[i] = new JButton(String.valueOf(i + 1));
            panel[i].setLayout(new BorderLayout());
            panel[i].setPreferredSize(new Dimension(size, size));
            panel[i].setBorder(border);
            panel[i].setHorizontalAlignment(NORMAL);
            
            if(true)
            	panel[i].setBackground(Color.WHITE);
        }
		
		for(int i = 0 ; i < 20; i++)
			table.add(panel[i]);

		table.setBackground(col);
		
		return table;
	}
	
	// �ֹ����� ���� �г�
	public static JPanel order()
	{
		int h = 300 - gap * 3;
		int w = compw - 150; 
		TitledBorder tab = new TitledBorder(new LineBorder(Color.BLACK), "�ֹ�����");
		tab.setTitleFont(new Font("���� ���", Font.PLAIN, 15));
		JPanel pan = new JPanel();
		pan.setLayout(null);
		pan.setBorder(tab);
		pan.setBounds(tablel , height1 + gap, compw, 300);
		pan.setBackground(col);
		
		JTextArea tf = new JTextArea(15, 1);
		tf.setBounds(gap + 5, gap*2, w, h);
		
		JLabel name = new JLabel("����");
		name.setFont(new Font("���� ���", Font.PLAIN, 15));
		name.setBounds(w + gap*3, gap * 2, 50, 25);
		
		JTextField namefield = new JTextField();
		namefield.setBounds(w + gap*3, gap * 3 + 15, 100, 25);
		namefield.setFont(new Font("���� ���", Font.PLAIN, 15));
		
		JLabel tname = new JLabel("���̺��");
		tname.setFont(new Font("���� ���", Font.PLAIN, 15));
		tname.setBounds(w + gap*3, gap * 3 + 60, 70, 25);
		
		JComboBox<String> tablenum = new JComboBox<String>();
		for (int i = 1; i <= 20; i++)
			tablenum.addItem(String.valueOf(i));
		tablenum.setBounds(w + gap*3 + 20, gap * 3 + 90, 60, 25);
		
		JButton btn1 = new JButton("�ֹ�");
		btn1.setBounds(w + gap*3 + 30, gap * 3 + 140, 70, 25);
		
		JButton btn2 = new JButton("���");
		btn2.setBounds(w + gap*3 + 30, gap * 3 + 180, 70, 25);
		
		JButton btn3 = new JButton("����");
		btn3.setBounds(w + gap*3 + 30, gap * 3 + 220, 70, 25);
		
		
		pan.add(tf);
		pan.add(name);
		pan.add(namefield);
		pan.add(tname);
		pan.add(tablenum);
		pan.add(btn1);
		pan.add(btn2);
		pan.add(btn3);
		return pan;
	}
	
	//�޴� �߰�
	public static JPanel menu()
	{
		int width = (compw - gap*2)/2 - 3;
		
		TitledBorder tab = new TitledBorder(new LineBorder(Color.BLACK), "�޴�");
		tab.setTitleFont(new Font("���� ���", Font.PLAIN, 15));
		JPanel pan = new JPanel();
		pan.setLayout(new FlowLayout(FlowLayout.CENTER, 7, 10));
		pan.setBorder(tab);
		pan.setBounds(gap , height1 + 300 + gap*2, compw, 490);
		pan.setBackground(col);

		// menu input
		String input = "a";
		
		JButton menus[] = new JButton[20];
		
		for(int i = 0; i < 10; i++) 
		{
			menus[2*i] = new JButton(input);
            menus[2*i].setPreferredSize(new Dimension(width, 35));
        }
		
		for(int i = 0; i < 10; i++) 
		{
			menus[2*i+1] = new JButton();
            menus[2*i+1].setPreferredSize(new Dimension(width, 35));
        }
		
		
		for(int i = 0 ; i < 20; i++)
			pan.add(menus[i]);
		
		return pan;
	}
	
	public static JPanel join()
	{
		TitledBorder tab = new TitledBorder(new LineBorder(Color.BLACK), "���/��ȸ");
		tab.setTitleFont(new Font("���� ���", Font.PLAIN, 15));
		JPanel pan = new JPanel();
		pan.setLayout(null);
		pan.setBorder(tab);
		pan.setBounds(tablel , height1 + 300 + gap*2, compw, 490);
		pan.setBackground(col);
		
		JTabbedPane tabs = new JTabbedPane();
		JButton b1 = new JButton("New York");
		  
		JPanel client = new JPanel();
		client.add(b1);
		
		tabs.addTab("��", client);
		
		pan.add(tabs);
		
		return pan;
	}
	
	
	public static void main(String[] argv)
	{
		new Mainpage();
	}
}
