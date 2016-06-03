package posSystem;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Mainpage extends JFrame implements ActionListener
{
	static JMenuBar menubar = new JMenuBar();
	static JMenuItem open, loginmenu;
	static JMenu menu;
	static JButton pay, cancel, order;
	static JComboBox<String> tablenum;
	static JTextField clientname;
	
	static int gap = 10;
	static int titleh = 90;
	static int width = 800;
	static int height = 1000;
	static int compw = 380;
	static int tablel = 390;
	static int height1 = 110;
	static int titlewidth = 760;
	static Color col = new Color(194, 194, 214);
	
	// mainpage 구성
	public Mainpage()
	{
		setTitle("식당 관리 시스템");
		
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
		
		JTextArea tf = new JTextArea(15, 1);
		tf.setBounds(15, 25, w, h);
		
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
		
		order = new JButton("주문");
		order.setBounds(w + gap*3 + 30, gap * 3 + 140, 70, 25);
		
		cancel = new JButton("취소");
		cancel.setBounds(w + gap*3 + 30, gap * 3 + 180, 70, 25);
		
		pay = new JButton("결제");
		pay.setBounds(w + gap*3 + 30, gap * 3 + 220, 70, 25);
		
		
		pan.add(tf);
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
		int width = (compw - gap*2)/2 - 3;
		
		TitledBorder tab = new TitledBorder(new LineBorder(Color.BLACK), "메뉴");
		tab.setTitleFont(new Font("맑은 고딕", Font.PLAIN, 15));
		JPanel pan = new JPanel();
		pan.setLayout(new FlowLayout(FlowLayout.CENTER, 7, 10));
		pan.setBorder(tab);
		pan.setBounds(gap, height1 + 300 + gap*2, compw, 490);
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
		} else if (e.getSource() == open)
		{
			JFileChooser file = new JFileChooser();
			file.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
			file.setFileFilter
		    (new FileNameExtensionFilter("텍스트", "txt"));
			file.showOpenDialog(this);
			new Openfile(file.getSelectedFile());
		} else if (e.getSource() == order)
		{
			int input = Integer.parseInt(tablenum.getSelectedItem().toString());
			new OrderTable(input);
		} else if (e.getSource() == cancel)
		{
			int input = Integer.parseInt(tablenum.getSelectedItem().toString());
			
		} else if (e.getSource() == pay)
		{
			String cname = clientname.getText();
			
		}
	}
	
	
	public static void main(String[] argv)
	{
		new Mainpage();
	}
}
