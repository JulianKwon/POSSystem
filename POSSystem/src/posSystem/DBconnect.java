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

	private JLabel idLabel = new JLabel("아이디");
	private JLabel pwdLabel = new JLabel("비밀번호");
	private JTextField idInput = new JTextField();
	private JPasswordField pwdInput = new JPasswordField();
	private JButton loginButton = new JButton("로그인");

	private void connectDB()
	{
		try
		{
			Class.forName("oracle.jdbc.OracleDriver");
			dbTest = DriverManager.getConnection("jdbc:oracle:thin:" + "@localhost:1521:XE", username, password);
			System.out.println("데이터베이스접속 성공 - id: " + username);
		} catch (SQLException e)
		{
			e.printStackTrace();
			System.out.println("패패");
		} catch (Exception e)
		{
			System.out.println("Exception:" + e);
		}
	}

	public DBconnect()
	{
		panel.setLayout(null);

		idLabel.setBounds(20, 10, 60, 30);
		idLabel.setFont(new Font("나눔 고딕", Font.BOLD, 12));
		pwdLabel.setBounds(20, 50, 60, 30);
		pwdLabel.setFont(new Font("나눔 고딕", Font.BOLD, 12));
		idInput.setBounds(100, 10, 80, 30);
		pwdInput.setBounds(100, 50, 80, 30);
		loginButton.setBounds(200, 25, 80, 35);
		loginButton.setFont(new Font("나눔 고딕", Font.BOLD, 12));
		loginButton.addActionListener(this);
		
		panel.add(idLabel);
		panel.add(pwdLabel);
		panel.add(idInput);
		panel.add(pwdInput);
		panel.add(loginButton);
		
		loginframe.add(panel);

		loginframe.setTitle("사원 로그인");
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