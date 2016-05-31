package posSystem;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.Connection;

import javax.swing.*;
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
		setTitle("½Ä´ç °ü¸® ½Ã½ºÅÛ");
		
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
		
		JLabel title = new JLabel("½Ä´ç ÁÖ¹®°ü¸®");
		title.setFont(new Font("³ª´® °íµñ", Font.BOLD, 30));
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
		
		open = new JMenu("open");
        menu.add(open);

        login = new JMenu("login");
        menu.add(login);
        
        menubar.add(menu);
        
		return menubar;
	}
	
	public static JPanel table()
	{
		int size = 60;
		TitledBorder tab = new TitledBorder(new LineBorder(Color.BLACK), "Å×ÀÌºí ÇöÈ²");
		LineBorder border = new LineBorder(Color.BLACK);
		JPanel table = new JPanel();
		table.setLayout(new FlowLayout());
		table.setBorder(tab);
		table.setBounds(gap , height1 + gap, compw, 300);
		
		JLabel l1 = new JLabel("1");
		l1.setFont(new Font("³ª´® °íµñ", Font.BOLD, 15));
		l1.setHorizontalAlignment(NORMAL);
		JPanel t1 = new JPanel();
		t1.setLayout(new BorderLayout());
		t1.setPreferredSize(new Dimension(size, size));
		t1.setBorder(border);
		t1.add(l1);
		JLabel l2 = new JLabel("2");
		l2.setFont(new Font("³ª´® °íµñ", Font.BOLD, 15));
		l2.setHorizontalAlignment(NORMAL);
		JPanel t2 = new JPanel();
		t2.setLayout(new BorderLayout());
		t2.setPreferredSize(new Dimension(size, size));
		t2.setBorder(border);
		t2.add(l2);
		JLabel l3 = new JLabel("3");
		l3.setFont(new Font("³ª´® °íµñ", Font.BOLD, 15));
		l3.setHorizontalAlignment(NORMAL);
		JPanel t3 = new JPanel();
		t3.setLayout(new BorderLayout());
		t3.setPreferredSize(new Dimension(size, size));
		t3.setBorder(border);
		t3.add(l3);
		JLabel l4 = new JLabel("4");
		l4.setFont(new Font("³ª´® °íµñ", Font.BOLD, 15));
		l4.setHorizontalAlignment(NORMAL);
		JPanel t4 = new JPanel();
		t4.setLayout(new BorderLayout());
		t4.setPreferredSize(new Dimension(size, size));
		t4.setBorder(border);
		t4.add(l4);
		JLabel l5 = new JLabel("5");
		l5.setFont(new Font("³ª´® °íµñ", Font.BOLD, 15));
		l5.setHorizontalAlignment(NORMAL);
		JPanel t5 = new JPanel();
		t5.setLayout(new BorderLayout());
		t5.setPreferredSize(new Dimension(size, size));
		t5.setBorder(border);
		t5.add(l5);
		JLabel l6 = new JLabel("6");
		l6.setFont(new Font("³ª´® °íµñ", Font.BOLD, 15));
		l6.setHorizontalAlignment(NORMAL);
		JPanel t6 = new JPanel();
		t6.setLayout(new BorderLayout());
		t6.setPreferredSize(new Dimension(size, size));
		t6.setBorder(border);
		t6.add(l6);
		JLabel l7 = new JLabel("7");
		l7.setFont(new Font("³ª´® °íµñ", Font.BOLD, 15));
		l7.setHorizontalAlignment(NORMAL);
		JPanel t7 = new JPanel();
		t7.setLayout(new BorderLayout());
		t7.setPreferredSize(new Dimension(size, size));
		t7.setBorder(border);
		t7.add(l7);
		JLabel l8 = new JLabel("8");
		l8.setFont(new Font("³ª´® °íµñ", Font.BOLD, 15));
		l8.setHorizontalAlignment(NORMAL);
		JPanel t8 = new JPanel();
		t8.setLayout(new BorderLayout());
		t8.setPreferredSize(new Dimension(size, size));
		t8.setBorder(border);
		t8.add(l8);
		JLabel l9 = new JLabel("9");
		l9.setFont(new Font("³ª´® °íµñ", Font.BOLD, 15));
		l9.setHorizontalAlignment(NORMAL);
		JPanel t9 = new JPanel();
		t9.setLayout(new BorderLayout());
		t9.setPreferredSize(new Dimension(size, size));
		t9.setBorder(border);
		t9.add(l9);
		JLabel l10 = new JLabel("10");
		l10.setFont(new Font("³ª´® °íµñ", Font.BOLD, 15));
		l10.setHorizontalAlignment(NORMAL);
		JPanel t10 = new JPanel();
		t10.setLayout(new BorderLayout());
		t10.setPreferredSize(new Dimension(size, size));
		t10.setBorder(border);
		t10.add(l10);
		JLabel l11 = new JLabel("11");
		l11.setFont(new Font("³ª´® °íµñ", Font.BOLD, 15));
		l11.setHorizontalAlignment(NORMAL);
		JPanel t11 = new JPanel();
		t11.setLayout(new BorderLayout());
		t11.setPreferredSize(new Dimension(size, size));
		t11.setBorder(border);
		t11.add(l11);
		JLabel l12 = new JLabel("12");
		l12.setFont(new Font("³ª´® °íµñ", Font.BOLD, 15));
		l12.setHorizontalAlignment(NORMAL);
		JPanel t12 = new JPanel();
		t12.setLayout(new BorderLayout());
		t12.setPreferredSize(new Dimension(size, size));
		t12.setBorder(border);
		t12.add(l12);
		JLabel l13 = new JLabel("13");
		l13.setFont(new Font("³ª´® °íµñ", Font.BOLD, 15));
		l13.setHorizontalAlignment(NORMAL);
		JPanel t13 = new JPanel();
		t13.setLayout(new BorderLayout());
		t13.setPreferredSize(new Dimension(size, size));
		t13.setBorder(border);
		t13.add(l13);
		JLabel l14 = new JLabel("14");
		l14.setFont(new Font("³ª´® °íµñ", Font.BOLD, 15));
		l14.setHorizontalAlignment(NORMAL);
		JPanel t14 = new JPanel();
		t14.setLayout(new BorderLayout());
		t14.setPreferredSize(new Dimension(size, size));
		t14.setBorder(border);
		t14.add(l14);
		JLabel l15 = new JLabel("15");
		l15.setFont(new Font("³ª´® °íµñ", Font.BOLD, 15));
		l15.setHorizontalAlignment(NORMAL);
		JPanel t15 = new JPanel();
		t15.setLayout(new BorderLayout());
		t15.setPreferredSize(new Dimension(size, size));
		t15.setBorder(border);
		t15.add(l15);
		JLabel l16 = new JLabel("16");
		l16.setFont(new Font("³ª´® °íµñ", Font.BOLD, 15));
		l16.setHorizontalAlignment(NORMAL);
		JPanel t16 = new JPanel();
		t16.setLayout(new BorderLayout());
		t16.setPreferredSize(new Dimension(size, size));
		t16.setBorder(border);
		t16.add(l16);
		JLabel l17 = new JLabel("17");
		l17.setFont(new Font("³ª´® °íµñ", Font.BOLD, 15));
		l17.setHorizontalAlignment(NORMAL);
		JPanel t17 = new JPanel();
		t17.setLayout(new BorderLayout());
		t17.setPreferredSize(new Dimension(size, size));
		t17.setBorder(border);
		t17.add(l17);
		JLabel l18 = new JLabel("18");
		l18.setFont(new Font("³ª´® °íµñ", Font.BOLD, 15));
		l18.setHorizontalAlignment(NORMAL);
		JPanel t18 = new JPanel();
		t18.setLayout(new BorderLayout());
		t18.setPreferredSize(new Dimension(size, size));
		t18.setBorder(border);
		t18.add(l18);
		JLabel l19 = new JLabel("19");
		l19.setFont(new Font("³ª´® °íµñ", Font.BOLD, 15));
		l19.setHorizontalAlignment(NORMAL);
		JPanel t19 = new JPanel();
		t19.setLayout(new BorderLayout());
		t19.setPreferredSize(new Dimension(size, size));
		t19.setBorder(border);
		t19.add(l19);
		JLabel l20 = new JLabel("20");
		l20.setFont(new Font("³ª´® °íµñ", Font.BOLD, 15));
		l20.setHorizontalAlignment(NORMAL);
		JPanel t20 = new JPanel();
		t20.setLayout(new BorderLayout());
		t20.setPreferredSize(new Dimension(size, size));
		t20.setBorder(border);
		t20.add(l20);
		
		table.add(t1);
		table.add(t2);
		table.add(t3);
		table.add(t4);
		table.add(t5);
		table.add(t6);
		table.add(t7);
		table.add(t8);
		table.add(t9);
		table.add(t10);
		table.add(t11);
		table.add(t12);
		table.add(t13);
		table.add(t14);
		table.add(t15);
		table.add(t16);
		table.add(t17);
		table.add(t18);
		table.add(t19);
		table.add(t20);

		table.setBackground(col);
		
		return table;
	}
	
	public static JPanel order()
	{
		TitledBorder tab = new TitledBorder(new LineBorder(Color.BLACK), "ÁÖ¹®³»¿ª");
		JPanel pan = new JPanel();
		
		pan.setLayout(null);
		pan.setBorder(tab);
		pan.setBounds(tablel , height1 + gap, compw, 300);
		pan.setBackground(col);
		
		return pan;
	}
	
	public static JPanel menu()
	{
		TitledBorder tab = new TitledBorder(new LineBorder(Color.BLACK), "¸Å´º");
		JPanel pan = new JPanel();
		
		pan.setLayout(null);
		pan.setBorder(tab);
		pan.setBounds(gap , height1 + 300 + gap*2, compw, 490);
		pan.setBackground(col);
		
		return pan;
	}
	
	public static JPanel join()
	{
		TitledBorder tab = new TitledBorder(new LineBorder(Color.BLACK), "µî·Ï/Á¶È¸");
		JPanel pan = new JPanel();
		
		pan.setLayout(null);
		pan.setBorder(tab);
		pan.setBounds(tablel , height1 + 300 + gap*2, compw, 490);
		pan.setBackground(col);

		
		return pan;
	}
	
	
	public static void main(String[] argv)
	{
		new Mainpage();
	}
}
