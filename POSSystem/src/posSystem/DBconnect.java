package posSystem;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class DBconnect implements ActionListener
{
	private static Connection dbTest;
	private String username;
	private String password;
	private JFrame loginframe = new JFrame();
	private JPanel panel = new JPanel();

	private JLabel idLabel = new JLabel("���̵�");
	private JLabel pwdLabel = new JLabel("��й�ȣ");
	private JTextField idInput = new JTextField();
	private JPasswordField pwdInput = new JPasswordField();
	private JButton loginButton = new JButton("�α���");

	private void connectDB()
	{
		try
		{
			Class.forName("oracle.jdbc.OracleDriver");
			dbTest = DriverManager.getConnection("jdbc:oracle:thin:" + "@localhost:1521:XE", username, password);
			System.out.println("�����ͺ��̽����� ���� - id: " + username);
		} catch (SQLException e)
		{
			e.printStackTrace();
			System.out.println("����");
		} catch (Exception e)
		{
			System.out.println("Exception:" + e);
		}
	}

	public DBconnect()
	{
		panel.setLayout(null);

		idLabel.setBounds(20, 10, 60, 30);
		idLabel.setFont(new Font("���� ���", Font.BOLD, 12));
		pwdLabel.setBounds(20, 50, 60, 30);
		pwdLabel.setFont(new Font("���� ���", Font.BOLD, 12));
		idInput.setBounds(100, 10, 80, 30);
		pwdInput.setBounds(100, 50, 80, 30);
		loginButton.setBounds(200, 25, 80, 35);
		loginButton.setFont(new Font("���� ���", Font.BOLD, 12));
		loginButton.addActionListener(this);
		
		panel.add(idLabel);
		panel.add(pwdLabel);
		panel.add(idInput);
		panel.add(pwdInput);
		panel.add(loginButton);
		
		loginframe.add(panel);

		loginframe.setTitle("��� �α���");
		loginframe.setSize(320, 130);
		loginframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		loginframe.setVisible(true);
	}

	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == loginButton)
		{
			username = idInput.getText();
			password = new String(pwdInput.getPassword());

			connectDB();
			loginframe.dispose();
		}
	}
}