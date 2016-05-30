package posSystem;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.*;

public class Mainpage extends JFrame
{
	JPanel grid = new JPanel();
	JTextField title = new JTextField("식당 주문관리");
	
	public Mainpage()
	{
		super("식당 관리 시스템");
		int x = 20;
		int y = 10;
		int width = 800;
		int height = 1200;
		grid.setLayout(new GridLayout(3, 1));
		grid.setBounds(x, y, width, height);
		
		title.setFont(new Font("나눔 고딕", Font.BOLD, 30));
		grid.add(title);
		
		this.add(grid);
		this.setSize(width, height);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	public static void main(String[] argv)
	{
		new Mainpage();
	}
}
