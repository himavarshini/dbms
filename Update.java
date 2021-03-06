import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.JLabel;
import java.io.*;
import java.sql.*;


public class Update extends JFrame implements ActionListener {
	/**
	*
	*/
	private static final long serialVersionUID = 1L;
	JLabel title,lbcn,lbssn;
	JTextField tfcn,tfssn;
	char ch;
	int z=0,b=0;
	JButton b1;
	Container cont;
	JPanel textPanel, buttonpanel;

	Update() {
		Hotel_Management f1 = new Hotel_Management();
		cont = getContentPane();
		cont.setLayout(new BorderLayout());
		JPanel textpanel = new JPanel();
		buttonpanel = new JPanel();
		textpanel.setBackground(Color.white);
		textpanel.setLayout(new GridLayout(2, 3, 2, 2));
		buttonpanel.setBackground(Color.white);
		//buttonpanel.setLayout(new GridLayout(7, 4, 2, 2));
		boolean t = true;
		//title = new JLabel("Insert");
		//textpanel.add(title);

		lbssn = new JLabel("SSN");
		lbcn = new JLabel("C_No_assgn");
		tfssn = new JTextField(30);
		tfcn = new JTextField(30);
		lbssn.setLabelFor(tfssn);
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
		//textpanel.add(lbssn);
		//textpanel.add(tfssn);

		//textpanel.add(lbfn);
		//textpanel.add(tffn);

		//textpanel.add(lbln);
		//textpanel.add(tfln);

		//textpanel.add(lbdoj);
		//textpanel.add(tfdoj);

		//textpanel.add(lbma);
		//textpanel.add(tfma);
		textpanel.add(lbssn);
		textpanel.add(tfssn);

		textpanel.add(lbcn);
		textpanel.add(tfcn);


		b1 = new JButton("Update");
		buttonpanel.add(b1);
		b1.addActionListener(this);

		b1.addActionListener(new ActionListener(){
   	public void actionPerformed(ActionEvent ae){

			try{
			String ssn1 = tfssn.getText();
			Integer c_a = Integer.valueOf(tfcn.getText());
			PreparedStatement pstmt1=f1.conn.prepareStatement("update chef SET c_no_assgn = ? where ssn = ? ");
			pstmt1.setInt(1, c_a);
			pstmt1.setString(2, ssn1);
			int rs1 = pstmt1.executeUpdate();
			if(rs1>0)
				b1.setText("Update Successful");
			}

			catch (SQLException sqle) {
						System.out.println(sqle);
						System.exit(1);
			}

   }
});
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

	public void actionPerformed(ActionEvent e) {
	/*	String s = e.getActionCommand();
		if (s.equals("Insert")) {
			if (z == 0) {
				tfield.setText(tfield.getText() + "1");
			} else {
				tfield.setText(tfield.getText() + "1");
				z = 0;
			}
		}
		if (s.equals("Update")) {
			if (z == 0) {
				tfield.setText(tfield.getText() + "2");
			} else {

				tfield.setText(tfield.getText() + "2");
				z = 0;
			}
		}
		if (s.equals("Search")) {
			if (z == 0) {
				tfield.setText(tfield.getText() + "3");
			} else {

				tfield.setText(tfield.getText() + "3");
				z = 0;
			}
		}
		if (s.equals("OK")) {
			b = 0;
			if (tfield.getText().equals("")) {
				tfield.setText("");
			} else {
				//f2.toFraction(tfield.getText());
				switch (ch) {
				case '+':
					//f0.add(f1,f2);
				//	output = f0.print();
					break;
				case '-':
					//f0.subtract(f1,f2);
					//output = f0.print();
					break;

				case '/':
					//f0.divide(f1,f2);
					//output = f0.print();
					break;

				case '*':
					//f0.multiply(f1,f2);
					//output = f0.print();
					break;

				}
				tfield.setText("");
				tfield.setText(tfield.getText());// + output);
				z = 1;
			}
		}
		tfield.requestFocus();*/
	}

	public static void main(String args[]) {
		try {
			UIManager
					.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
		} catch (Exception e) {
		}
		Update f = new Update();
		f.setTitle("Hotel_Management");
		f.pack();
		f.setVisible(true);

	}
}
