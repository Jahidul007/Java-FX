import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.Scanner;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

public class DisplayQueryResults extends JFrame{
	
	Scanner sc=new Scanner(System.in);
	//String database_name=sc.next();
	
	
	private String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private String DATABASE_URL = "jdbc:mysql://localhost:3306/online_shop";
	private String USER = "root";
	private String PASSWORD = "202205";

	static final String DEFULT_QUERY = "show tables";
	
	private ResultSetTableModel tablemodel;
	private JTextArea queryArea;
	
	
	 // create ResultSetTableModel and GUI
	   public DisplayQueryResults() 
	   {   
		   super("Display Query Result");
	      try 
	      {
	         // create TableModel for results of query SELECT * FROM authors
	         tablemodel = new ResultSetTableModel(JDBC_DRIVER, DATABASE_URL, USER, PASSWORD, DEFULT_QUERY);
	         // set up JTextArea in which user types queries
	         queryArea = new JTextArea(DEFULT_QUERY,3,100);
	         queryArea.setWrapStyleWord( true );
	         queryArea.setLineWrap( true );
	         queryArea.setBackground(Color.BLACK);
	         queryArea.setForeground(Color.GRAY);
	         
	         JScrollPane scrollPane = new JScrollPane( queryArea,
	            ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, 
	            ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER );
	            scrollPane.setBackground(Color.GREEN);
	         
	         // set up JButton for submitting queries
	         JButton submitButton = new JButton( "Submit Query" );
	        // submitButton.setBackground(Color.LIGHT_GRAY);


	         // create Box to manage placement of queryArea and 
	         // submitButton in GUI
	         Box box = Box.createHorizontalBox();
	         box.add( scrollPane );
	         box.add( submitButton );
	         box.setBackground(Color.red);


	         // create JTable delegate for tableModel 
	         JTable resultTable = new JTable(tablemodel);
	         resultTable.setBackground(Color.gray);
	         // place GUI components on content pane
	         add( box, BorderLayout.NORTH );
	         add( new JScrollPane( resultTable ), BorderLayout.CENTER );

	         // create event listener for submitButton
	         submitButton.addActionListener( 
	         
	            new ActionListener() 
	            {
	               // pass query to table model
	               public void actionPerformed( ActionEvent event )
	               {
	                  // perform a new query
	                  try 
	                  {
	                     tablemodel.setQuery( queryArea.getText() );
	                  } // end try
	                  catch ( SQLException sqlException ) 
	                  {
	                     JOptionPane.showMessageDialog( null, 
	                        sqlException.getMessage(), "Database error", 
	                        JOptionPane.ERROR_MESSAGE );
	                     
	                     // try to recover from invalid user query 
	                     // by executing default query
	                     try 
	                     {
	                        tablemodel.setQuery(DEFULT_QUERY);
	                        queryArea.setText(DEFULT_QUERY);
	                     } // end try
	                     catch ( SQLException sqlException2 ) 
	                     {
	                        JOptionPane.showMessageDialog( null, 
	                           sqlException2.getMessage(), "Database error", 
	                           JOptionPane.ERROR_MESSAGE );
	         
	                        // ensure database connection is closed
	                        tablemodel.disconnectFromDatabase();
	         
	                        System.exit( 1 ); // terminate application
	                     } // end inner catch                   
	                  } // end outer catch
	               } // end actionPerformed
	            }  // end ActionListener inner class          
	         ); // end call to addActionListener

	         setSize( 520,270 ); // set window size
	         setVisible( true ); // display window  
	      } // end try
	      catch ( ClassNotFoundException classNotFound ) 
	      {
	         JOptionPane.showMessageDialog( null, 
	            "MySQL driver not found", "Driver not found",
	            JOptionPane.ERROR_MESSAGE );
	         
	         System.exit( 1 ); // terminate application
	      } // end catch
	      catch ( SQLException sqlException ) 
	      {
	         JOptionPane.showMessageDialog( null, sqlException.getMessage(), 
	            "Database error", JOptionPane.ERROR_MESSAGE );
	               
	         // ensure database connection is closed
	         tablemodel.disconnectFromDatabase();
	         
	         System.exit( 1 );   // terminate application
	      } // end catch
	      
	      // dispose of window when user quits application (this overrides
	      // the default of HIDE_ON_CLOSE)
	      setDefaultCloseOperation( DISPOSE_ON_CLOSE );
	      
	      // ensure database connection is closed when user quits application
	      addWindowListener(
	      
	         new WindowAdapter() 
	         {
	            // disconnect from database and exit when window has closed
	            public void windowClosed( WindowEvent event )
	            {
	               tablemodel.disconnectFromDatabase();
	               System.exit( 0 );
	            } // end method windowClosed
	         } // end WindowAdapter inner class
	      ); // end call to addWindowListener
	   } // end DisplayQueryResults constructor
	   
	   // execute application
	   public static void main( String args[] ) 
	   {
	      new DisplayQueryResults();   
	      
	   } // end main
	} // end c
