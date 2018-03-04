import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class signUP extends JFrame {
	private String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private String DATABASE_URL = "jdbc:mysql://localhost:3306/database123";
	private String USER = "root";
	private String PASSWORD = "202205";
	Connection connection = null;

	public signUP() {
		super("Log In Form");
		JLabel userID, password;
		JTextField TuserID;
		JPasswordField Tpassword;

		JButton signup = new JButton("Log In");
		JLabel newLabel = new JLabel("Create new account");
		newLabel.setFont(new Font("Serif", Font.ITALIC, 14));
		newLabel.setForeground(Color.BLUE);

		userID = new JLabel("ID");
		password = new JLabel("password");

		userID.setBounds(20, 20, 100, 20);
		password.setBounds(20, 50, 100, 20);

		TuserID = new JTextField();
		Tpassword = new JPasswordField();

		TuserID.setBounds(130, 20, 150, 20);
		Tpassword.setBounds(130, 50, 150, 20);

		signup.setBounds(150, 80, 100, 20);
		newLabel.setBounds(150, 110, 200, 20);
		
		
		setLayout(null);
		add(userID);
		add(password);
		add(TuserID);
		add(Tpassword);
		add(signup);
		add(newLabel);

		newLabel.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
				new Register();
			}
		});

		signup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (TuserID.getText().length() == 0) // Checking for empty field
					JOptionPane.showMessageDialog(null, "Empty fields detected ! Please fill up all fields");
				else if (Tpassword.getPassword().length == 0) // Checking for empty field
					JOptionPane.showMessageDialog(null, "Empty fields detected ! Please fill up all fields");
				else {
					String user = TuserID.getText(); // Collecting the input
					char[] pass = Tpassword.getPassword(); // Collecting the input
					String pwd = String.copyValueOf(pass); // converting from array to string
					if (validate_login(user, pwd))
						JOptionPane.showMessageDialog(null, "Sign Up done");
					else
						JOptionPane.showMessageDialog(null, "Incorrect User Name or password");
				}

			}
		});

		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setLocationRelativeTo(null);
		setSize(400, 200);

	}

	private boolean validate_login(String username, String password) {
		try {
			Class.forName("com.mysql.jdbc.Driver"); // MySQL database connection
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/database123", "root", "202205");
			PreparedStatement pst = conn.prepareStatement("Select Uname,pass from login where uName=? and pass=?");
			pst.setString(1, username);
			pst.setString(2, password);
			ResultSet rs = pst.executeQuery();
			if (rs.next())
				return true;
			else
				return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	

	public static void main(String[] args) {
		new signUP();
	}

}
