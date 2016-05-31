package posSystem;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.Connection;

import javax.swing.*;

public class Mainpage extends JFrame
{
	static JPanel grid = new JPanel();
	static JTextField  title = new JTextField("식당 주문관리");
	static JMenuBar menubar = new JMenuBar();
	static JMenu menu, open, login;
	
	public Mainpage()
	{
		super.setTitle("식당 관리 시스템");
		grid.setLayout(new GridLayout(3, 1));
		int x = 20;
		int y = 10;
		int width = 600;
		int height = 900;
		grid.setBounds(x, y, width, height);
		
		
		
		title.setFont(new Font("나눔 고딕", Font.BOLD, 30));
		grid.add(title);
		
		
		this.add(grid);
		this.setJMenuBar(Mainpage.mkmenu());
		this.setSize(width, height);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	public static JMenuBar mkmenu()
	{
		menu = new JMenu("menu");
		
		open = new JMenu("open");
		open.setMnemonic(KeyEvent.VK_A);
        open.getAccessibleContext().setAccessibleDescription(
                "The only menu in this program that has menu items");
        menu.add(open);

        login = new JMenu("login");
        login.setMnemonic(KeyEvent.VK_A);
        login.getAccessibleContext().setAccessibleDescription(
                "The only menu in this program that has menu items");
        menu.add(login);
        
        menubar.add(menu);
        
		return menubar;
	}
	
	
	public static void main(String[] argv)
	{
		new Mainpage();
	}
}
