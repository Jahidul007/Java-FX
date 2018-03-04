import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Register extends JFrame {
	private static final LayoutManager NULL = null;
	JLabel firstName, lastName, email, password, userName, country, id;
	JTextField TfirstName, TlastName, Temail, TuserName, Tcountry, Tid;
	JButton btn_insert, btn_update, btn_delete;
	JPasswordField Tpassword;

	private String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private String DATABASE_URL = "jdbc:mysql://localhost:3306/database123";
	private String USER = "root";
	private String PASSWORD = "202205";
	Connection connection = null;

	public Register() {
		super("Registration Form");

		id = new JLabel("ID");
		firstName = new JLabel("First Name");
		lastName = new JLabel("Last Name");
		email = new JLabel("Email");
		password = new JLabel("Password");
		userName = new JLabel("User Name");
		country = new JLabel("Country");

		id.setBounds(20, 20, 100, 20);
		firstName.setBounds(20, 50, 100, 20);
		lastName.setBounds(20, 80, 100, 20);
		email.setBounds(20, 110, 100, 20);
		password.setBounds(20, 140, 100, 20);
		userName.setBounds(20, 170, 100, 20);
		country.setBounds(20, 200, 100, 20);

		Tid = new JTextField(20);
		TfirstName = new JTextField(20);
		TlastName = new JTextField(20);
		Temail = new JTextField(20);
		Tpassword = new JPasswordField(20);
		TuserName = new JTextField(20);
		Tcountry = new JTextField(20);

		Tid.setBounds(130, 20, 150, 20);
		TfirstName.setBounds(130, 50, 150, 20);
		TlastName.setBounds(130, 80, 150, 20);
		Temail.setBounds(130, 110, 150, 20);
		Tpassword.setBounds(130, 140, 150, 20);
		TuserName.setBounds(130, 170, 150, 20);
		Tcountry.setBounds(130, 200, 150, 20);

		btn_insert = new JButton("Create Account");
		btn_update = new JButton("EDIT");
		btn_delete = new JButton("delete");

		btn_insert.setBounds(300, 80, 130, 20);
		btn_update.setBounds(300, 110, 130, 20);
		btn_delete.setBounds(300, 140, 100, 20);

		setLayout(null);
		add(id);
		add(firstName);
		add(lastName);
		add(email);
		add(password);
		add(userName);
		add(country);

		add(Tid);
		add(TfirstName);
		add(TlastName);
		add(Temail);
		add(Tpassword);
		add(TuserName);
		add(Tcountry);

		add(btn_insert);
		add(btn_update);
		//add(btn_delete);

		btn_insert.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					theQuery("insert into login(fName,lName,email,pass,uName,country)  values('" + TfirstName.getText()
							+ "','" + TlastName.getText() + "','" + Temail.getText() + "','" + Tpassword.getText()
							+ "','" + TuserName.getText() + "','" + Tcountry.getText() + "')");

				} catch (Exception ex) {
					// TODO: handle exception
				}

			}
		});

		btn_update.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					theQuery("update login set fName = '" + TfirstName.getText() + "',lName = '" + TlastName.getText()
							+ "',email = '" + Temail.getText()+ "',pass = '" + Tpassword.getText() + "',uName = '"
							+ TuserName.getText() + "',country = '" +Tcountry.getText()+"' where id = " + Tid.getText());

				} catch (Exception ex) {
					// TODO: handle exception
				}

			}
		});
		btn_delete.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					theQuery("delete from login where id = " + Tid.getText());

				} catch (Exception ex) {
					// TODO: handle exception
				}

			}
		});

		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setLocationRelativeTo(null);
		setSize(450, 300);
	}

	public Connection theQuery(String query) {

		Statement statement = null;
		ResultSet resultSet = null;
		// Class.forName("com.mysql.jdbc.Driver");
		try {
			connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
			statement = connection.createStatement();
			statement.executeUpdate(query);
			JOptionPane.showMessageDialog(null, "Executed");
			return connection;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return connection;

	}

	/*public static void main(String[] args) {
		new Register();
	}*/

}