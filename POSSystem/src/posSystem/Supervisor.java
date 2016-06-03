package posSystem;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Supervisor
{
	static JButton joinbtn, chkclient, addclerk, chkclerk;
	static JTextField clientname, clerkname;
	static JTextArea clientdata, clerkdata;

	public JPanel client()
	{
		JPanel pan = new JPanel();
		pan.setLayout(null);
		pan.setBounds(390, 430, 380, 490);
		pan.setBackground(new Color(194, 194, 214));
		
		JLabel name = new JLabel("°í°´¸í");
		name.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		name.setBounds(20, 20, 50, 25);
		
		clientname = new JTextField();
		clientname.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		clientname.setBounds(15, 50, 80, 30);
		
		joinbtn = new JButton("°¡ÀÔ");
		joinbtn.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		joinbtn.setBounds(200, 50, 65, 30);
		
		chkclient = new JButton("Á¶È¸");
		chkclient.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		chkclient.setBounds(280, 50, 65, 30);
		
		clientdata = new JTextArea();
		clientdata.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		clientdata.setBounds(10, 110, 345, 310);
		
		pan.add(name);
		pan.add(clientname);
		pan.add(joinbtn);
		pan.add(chkclient);
		pan.add(clientdata);
		return pan;
	}
	
	public JPanel sales()
	{
		JPanel pan = new JPanel();
		pan.setLayout(null);
		pan.setBounds(390, 430, 380, 490);
		pan.setBackground(new Color(194, 194, 214));
		
		return pan;
	}
	
	public JPanel clerks()
	{
		JPanel pan = new JPanel();
		pan.setLayout(null);
		pan.setBounds(390, 430, 380, 490);
		pan.setBackground(new Color(194, 194, 214));
		
		JLabel clerkn = new JLabel("Á÷¿ø¸í");
		clerkn.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		clerkn.setBounds(20, 20, 50, 25);
		
		clerkname = new JTextField();
		clerkname.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		clerkname.setBounds(15, 50, 80, 30);
		
		addclerk = new JButton("Á÷¿øµî·Ï");
		addclerk.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		addclerk.setBounds(165, 50, 100, 30);
		
		chkclerk = new JButton("Á¶È¸");
		chkclerk.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		chkclerk.setBounds(280, 50, 65, 30);
		
		clerkdata = new JTextArea();
		clerkdata.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		clerkdata.setBounds(10, 110, 345, 310);
		
		pan.add(clerkn);
		pan.add(clerkname);
		pan.add(addclerk);
		pan.add(chkclerk);
		pan.add(clerkdata);
		return pan;
	}
	
	public JPanel menu()
	{
		JPanel pan = new JPanel();
		pan.setLayout(null);
		pan.setBounds(390, 430, 380, 490);
		pan.setBackground(new Color(194, 194, 214));
		
		return pan;
	}
}
