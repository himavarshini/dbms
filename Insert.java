import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.JLabel;
import java.io.*;
import java.sql.*;


public class Insert extends JFrame implements ActionListener {
	/**
	*
	*/
	Hotel_Management f1 = new Hotel_Management();
	private static final long serialVersionUID = 1L;
	JLabel title,lbssn,lbfn,lbln,lbdoj,lbma,lbcn;
	JTextField tfssn, tffn, tfln,tfdoj,tfma,tfcn;
	char ch;
	int z=0,b=0;
	JButton b1;// b2, b3, b4,eq;
	Container cont;
	JPanel textPanel, buttonpanel;

	Insert() {
		//Hotel_Management f1 = new Hotel_Management();
		cont = getContentPane();
		cont.setLayout(new BorderLayout());
		JPanel textpanel = new JPanel();
		buttonpanel = new JPanel();
		textpanel.setBackground(Color.white);
		textpanel.setLayout(new GridLayout(7, 4, 2, 2));
		buttonpanel.setBackground(Color.white);
		//buttonpanel.setLayout(new GridLayout(7, 4, 2, 2));
		boolean t = true;
		//title = new JLabel("Insert");
		//textpanel.add(title);

		lbssn = new JLabel("SSN");
		lbfn = new JLabel("First Name");
		lbln = new JLabel("Last Name");
		lbdoj = new JLabel("DOJ");
		lbma = new JLabel("Max_assgn");
		lbcn = new JLabel("C_No_assgn");
		tfssn = new JTextField(30);
		tffn = new JTextField(30);
		tfln = new JTextField(30);
		tfdoj = new JTextField(30);
		tfma = new JTextField(30);
		tfcn = new JTextField(30);
		lbssn.setLabelFor(tfssn);
		lbfn.setLabelFor(tffn);
		lbln.setLabelFor(tfln);
		lbdoj.setLabelFor(tfdoj);
		lbma.setLabelFor(tfma);
		lbcn.setLabelFor(tfcn);

		/*tfssn.setHorizontalAlignment(SwingConstants.RIGHT);
		tffn.setHorizontalAlignment(SwingConstants.RIGHT);
		tfln.setHorizontalAlignment(SwingConstants.RIGHT);
		tfdoj.setHorizontalAlignment(SwingConstants.RIGHT);
		tfma.setHorizontalAlignment(SwingConstants.RIGHT);
		tfcn.setHorizontalAlignment(SwingConstants.RIGHT);*/

		/*tfssn.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent keyevent) {
				char c = keyevent.getKeyChar();
				if (c >= '0' && c <= '9') {
				} else {
					keyevent.consume();
				}
			}
		});*/
		textpanel.add(lbssn);
		textpanel.add(tfssn);

		textpanel.add(lbfn);
		textpanel.add(tffn);

		textpanel.add(lbln);
		textpanel.add(tfln);

		textpanel.add(lbdoj);
		textpanel.add(tfdoj);

		textpanel.add(lbma);
		textpanel.add(tfma);

		textpanel.add(lbcn);
		textpanel.add(tfcn);


		b1 = new JButton("Insert");
		buttonpanel.add(b1);
		b1.addActionListener(this);
		/*b1.addActionListener(new ActionListener(){
   	public void actionPerformed(ActionEvent ae){
			try{
			String ssn1 = tfssn.getText();
			String fn = tffn.getText();
			String ln = tfln.getText();
			String doj = tfdoj.getText();
			Date d = Date.valueOf(doj);
			Integer max = Integer.valueOf(tfma.getText());
			Integer c_a = Integer.valueOf(tfcn.getText());
			PreparedStatement pstmt1=f1.conn.prepareStatement("insert into chef values (?,?,?,?,?,?)");
			pstmt1.setString(1, ssn1);
			pstmt1.setString(2,fn);
			pstmt1.setString(3,ln);
			pstmt1.setDate(4,d);
			pstmt1.setInt(5,max);
			pstmt1.setInt(6, c_a);
			int rs1 = pstmt1.executeUpdate();
		}

		catch (SQLException sqle) {
					System.out.println(sqle);
					System.exit(1);
		}

   }
});*/
		/*
		b2 = new JButton("Update");
		buttonpanel.add(b2);
		b2.addActionListener(this);
		b3 = new JButton("Search");
		buttonpanel.add(b3);
		b3.addActionListener(this);
		eq = new JButton("OK");
		buttonpanel.add(eq);
		eq.addActionListener(this);*/

		cont.add("Center", buttonpanel);
		cont.add("North", textpanel);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String args[]) {
		try {
			UIManager
					.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
		} catch (Exception e) {
		}
		Insert f = new Insert();
		f.setTitle("Hotel_Management");
		f.pack();
		f.setVisible(true);

	}
	@Override
	public void actionPerformed(ActionEvent e) {

		String s = e.getActionCommand();
		if (s.equals("Insert")) {
			try{
			String ssn1 = tfssn.getText();
			String fn = tffn.getText();
			String ln = tfln.getText();
			String doj = tfdoj.getText();
			Date d = Date.valueOf(doj);
			Integer max = Integer.valueOf(tfma.getText());
			Integer c_a = Integer.valueOf(tfcn.getText());
			PreparedStatement pstmt1 = f1.conn.prepareStatement("insert into chef values (?,?,?,?,?,?)");
			pstmt1.setString(1, ssn1);
			pstmt1.setString(2,fn);
			pstmt1.setString(3,ln);
			pstmt1.setDate(4,d);
			pstmt1.setInt(5,max);
			pstmt1.setInt(6, c_a);
			int rs1 = pstmt1.executeUpdate();
		}

		catch (SQLException sqle) {
					System.out.println(sqle);
					System.exit(1);
		}
		}

	}
}
