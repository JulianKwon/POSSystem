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
	JTextField title = new JTextField("�Ĵ� �ֹ�����");
	
	public Mainpage()
	{
		super("�Ĵ� ���� �ý���");
		int x = 20;
		int y = 10;
		int width = 800;
		int height = 1200;
		grid.setLayout(new GridLayout(3, 1));
		grid.setBounds(x, y, width, height);
		
		title.setFont(new Font("���� ���", Font.BOLD, 30));
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
