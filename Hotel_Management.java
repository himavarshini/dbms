import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.JLabel;
import java.io.*;
import java.sql.*;


public class Hotel_Management extends JFrame implements ActionListener {
	/**
	*
	*/
	private static final long serialVersionUID = 1L;
	JTextField tfield,tfun,tfpw;
	JLabel title,lbun,lbpw;
	char ch;
	int z=0,b=0;
	JButton b1, b2, b3, b4, b5,ok;
	Container cont;
	JPanel textPanel, buttonpanel,textpanel1;
	JFrame frame;
	String un,pw;
	boolean t;

	String hostname = "localhost";	// If PostgreSQL is running on some other machine enter the IP address of the machine here
	String username = "postgres"; // Enter your PostgreSQL username
	String password = "varshini98"; // Enter your PostgreSQL password
	String dbName = "dbms"; // Enter the name of the database that has the university tables.
	String connectionUrl = "jdbc:postgresql://" + hostname + "/" + dbName;
	Connection conn;

	Hotel_Management() {
		cont = getContentPane();
		cont.setLayout(new BorderLayout());
		JPanel textpanel = new JPanel();
		JPanel textpanel1 = new JPanel();
		JPanel textpanel2 = new JPanel();
		buttonpanel = new JPanel();
		textpanel.setBackground(Color.white);
		buttonpanel.setBackground(Color.white);
		buttonpanel.setLayout(new GridLayout(3, 4, 2, 2));
		textpanel1.setBackground(Color.white);
		textpanel1.setLayout(new GridLayout(3, 2, 2, 2));
		textpanel2.setBackground(Color.white);

		t = false;
		title = new JLabel();
		title.setText("Hotel Management");
		textpanel.add(title);

		lbun = new JLabel("USERNAME");
		tfun = new JTextField(30);
		lbun.setLabelFor(tfun);
		lbpw = new JLabel("PASSWORD");
		tfpw = new JTextField(30);
		lbpw.setLabelFor(tfpw);


		textpanel1.add(lbun);
		textpanel1.add(tfun);
		ok = new JButton("LOGIN");
		textpanel2.add(ok);
		ok.addActionListener(this);
		textpanel1.add(lbpw);
		textpanel1.add(tfpw);
		ok.addActionListener(new ActionListener(){
   	public void actionPerformed(ActionEvent ae){
      un = tfun.getText();
			pw = tfpw.getText();
			if(un.equals("postgres")&&pw.equals("postgres")){
				t=true;
				ok.setText("Login Successful");
				tfun.setText("");
				tfpw.setText("");
			}else{
				tfun.setText("");
				tfpw.setText("");
			}
   }
});


		b1 = new JButton("Insert");
		buttonpanel.add(b1);
		b1.addActionListener(this);
		b2 = new JButton("Update");
		buttonpanel.add(b2);
		b2.addActionListener(this);
		b3 = new JButton("Search");
		buttonpanel.add(b3);
		b3.addActionListener(this);
		b5 = new JButton("Delete");
		b5.setBackground(Color.RED);
    b5.setForeground(Color.YELLOW);
		buttonpanel.add(b5);
		b5.addActionListener(this);
		try{
				Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException cnfe){
				System.out.println("Could not find the JDBC driver!");
				System.exit(1);
		}

		try {
				conn = DriverManager.getConnection(connectionUrl,username, password);
				System.out.println("Connected successfully");
		} catch (SQLException sqle) {
					 System.out.println("Connection failed");
					 System.out.println(sqle);
// Uncomment the below line for a more detailed stack trace
// sqle.printStackTrace();
					 System.exit(1);
		}

		cont.add("South", buttonpanel);
		cont.add("Center", textpanel1);
		cont.add("East", textpanel2);
		cont.add("North", textpanel);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String args[]) {
		try {
			UIManager
					.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
		} catch (Exception e) {
		}
		Hotel_Management f = new Hotel_Management();
		f.setTitle("Hotel_Management");
		f.pack();
		f.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {

		String s = e.getActionCommand();
 		if (s.equals("Insert")&&t) {
			Insert f = new Insert();
			f.setTitle("Hotel_Management");
			f.pack();
			f.setVisible(true);
		}
		else if (s.equals("Update")&&t){
			Update f = new Update();
			f.setTitle("Hotel_Management");
			f.pack();
			f.setVisible(true);
		}
		else if (s.equals("Search")){
			Search f = new Search();
			f.setTitle("Hotel_Management");
			f.pack();
			f.setVisible(true);
		}else if(s.equals("Delete")&&t){
			Delete f = new Delete();
			f.setTitle("Hotel_Management");
			f.pack();
			f.setVisible(true);
		}
	}
}
