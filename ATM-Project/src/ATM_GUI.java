import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Panel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Label;
import javax.swing.JMenuBar;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JTextPane;
import java.awt.SystemColor;
import javax.swing.SwingConstants;

public class ATM_GUI {
	
	Account user = new Account("53195429" , "4121" , 0);
	
	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ATM_GUI window = new ATM_GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ATM_GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 483, 336);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		Panel panel = new Panel();
		panel.setBounds(0, 0, 469, 299);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		Panel panel_1 = new Panel();
		panel_1.setBounds(0, 0, 469, 299);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		Panel panel_2 = new Panel();
		panel_2.setBounds(0, 0, 469, 299);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("Arial", Font.BOLD, 25));
		lblLogin.setBounds(186, 31, 82, 40);
		panel.add(lblLogin);
		
		JLabel lblCardNumber = new JLabel("Card Number :");
		lblCardNumber.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCardNumber.setBounds(10, 99, 124, 28);
		panel.add(lblCardNumber);
		
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(user.login(textField.getText(), textField_1.getText()))
				{
					JOptionPane.showMessageDialog(null, "Successfully logged in!");
					panel.setVisible(false);
					panel_1.setVisible(true);
					panel_2.setVisible(false);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Incorrect cardnumber or passcode");
				}
			}
		});
		
		JLabel lblPassword = new JLabel("Passcode :");
		lblPassword.setBounds(10, 153, 110, 28);
		panel.add(lblPassword);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnLogin.setFont(new Font("Cambria", Font.BOLD, 20));
		btnLogin.setBounds(144, 211, 137, 59);
		panel.add(btnLogin);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setBounds(164, 99, 202, 26);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setFont(new Font("Symbol", Font.PLAIN, 14));
		textField_1.setBounds(164, 153, 202, 26);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		
		JButton btnTransactions = new JButton("Transactions");
		btnTransactions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_1.setVisible(false);
				panel.setVisible(false);
				panel_2.setVisible(true);
			}
		});
		btnTransactions.setBounds(48, 123, 142, 80);
		btnTransactions.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel_1.add(btnTransactions);
		
		Label label = new Label("");
		label.setFont(new Font("Dialog", Font.PLAIN, 15));
		label.setAlignment(Label.CENTER);
		label.setBackground(Color.WHITE);
		label.setBounds(48, 32, 352, 41);
		panel_1.add(label);
		
		JButton btnBalanceInquiry = new JButton("Balance \r\nInquiry");
		btnBalanceInquiry.setBounds(258, 123, 142, 80);
		btnBalanceInquiry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s = null;
				label.setText("Your current balance is $"+user.printbalance(s));
			}
		});
		btnBalanceInquiry.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel_1.add(btnBalanceInquiry);
		
		JButton button = new JButton("<--Previous");
		button.setBounds(10, 245, 99, 30);
		button.setFont(new Font("Arial", Font.BOLD, 12));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				label.setText(user.previous());
			}
		});
		panel_1.add(button);
		
		JButton btnNext = new JButton("Next-->");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				label.setText(user.next());
			}
		});
		btnNext.setBounds(360, 245, 99, 30);
		btnNext.setFont(new Font("Arial", Font.BOLD, 12));
		panel_1.add(btnNext);
		
		
		Label label_1 = new Label("");
		label_1.setFont(new Font("Dialog", Font.PLAIN, 15));
		label_1.setAlignment(Label.CENTER);
		label_1.setBackground(Color.WHITE);
		label_1.setBounds(10, 10, 261, 34);
		panel_2.add(label_1);
		
		
		JButton button_1 = new JButton("1");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				label_1.setText(label_1.getText().concat("1"));
			}
		});
		button_1.setFont(new Font("Arial", Font.BOLD, 15));
		button_1.setBounds(10, 64, 76, 44);
		panel_2.add(button_1);
		
		JButton button_2 = new JButton("2");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				label_1.setText(label_1.getText().concat("2"));
			}
		});
		button_2.setFont(new Font("Arial", Font.BOLD, 15));
		button_2.setBounds(109, 64, 74, 44);
		panel_2.add(button_2);
		
		JButton button_3 = new JButton("3\r\n");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				label_1.setText(label_1.getText().concat("3"));
			}
		});
		button_3.setFont(new Font("Arial", Font.BOLD, 15));
		button_3.setBounds(206, 64, 65, 44);
		panel_2.add(button_3);
		
		JButton button_4 = new JButton("4");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				label_1.setText(label_1.getText().concat("4"));
			}
		});
		button_4.setFont(new Font("Arial", Font.BOLD, 15));
		button_4.setBounds(10, 118, 76, 44);
		panel_2.add(button_4);
		
		JButton button_5 = new JButton("5");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				label_1.setText(label_1.getText().concat("5"));
			}
		});
		button_5.setFont(new Font("Arial", Font.BOLD, 15));
		button_5.setBounds(109, 118, 74, 44);
		panel_2.add(button_5);
		
		JButton button_6 = new JButton("6");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				label_1.setText(label_1.getText().concat("6"));
			}
		});
		button_6.setFont(new Font("Arial", Font.BOLD, 15));
		button_6.setBounds(206, 118, 65, 44);
		panel_2.add(button_6);
		
		JButton button_7 = new JButton("7");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				label_1.setText(label_1.getText().concat("7"));
			}
		});
		button_7.setFont(new Font("Arial", Font.BOLD, 15));
		button_7.setBounds(10, 172, 76, 44);
		panel_2.add(button_7);
		
		JButton button_8 = new JButton("8");
		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				label_1.setText(label_1.getText().concat("8"));
			}
		});
		button_8.setFont(new Font("Arial", Font.BOLD, 15));
		button_8.setBounds(109, 172, 74, 44);
		panel_2.add(button_8);
		
		JButton button_9 = new JButton("9");
		button_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				label_1.setText(label_1.getText().concat("9"));
			}
		});
		button_9.setFont(new Font("Arial", Font.BOLD, 15));
		button_9.setBounds(206, 172, 65, 44);
		panel_2.add(button_9);
		
		JButton button_10 = new JButton(".");
		button_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				label_1.setText(label_1.getText().concat("."));
			}
		});
		button_10.setFont(new Font("Arial", Font.BOLD, 15));
		button_10.setBounds(206, 226, 65, 44);
		panel_2.add(button_10);
		
		JButton button_11 = new JButton("0");
		button_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				label_1.setText(label_1.getText().concat("0"));
			}
		});
		button_11.setFont(new Font("Arial", Font.BOLD, 15));
		button_11.setBounds(109, 226, 74, 44);
		panel_2.add(button_11);
		
		JButton btnDelete = new JButton("Erase");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				label_1.setText("");
			}
		});
		btnDelete.setFont(new Font("Arial", Font.BOLD, 15));
		btnDelete.setBounds(10, 226, 76, 44);
		panel_2.add(btnDelete);
		
		JButton btnWithdraw = new JButton("Withdraw");
		btnWithdraw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double temp;
				temp = Double.parseDouble(label_1.getText());
				if (user.withdraw(temp))
				{
					JOptionPane.showMessageDialog(null, "You have successfully withdrawn $"+label_1.getText());
				}
				else
				{
					JOptionPane.showMessageDialog(null, "You have't this amount of money in your account , Your current balance is $"+user.balance);
				}
				label_1.setText("");
			}
		});
		btnWithdraw.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnWithdraw.setBounds(305, 21, 129, 59);
		panel_2.add(btnWithdraw);
		
		JButton btnDeposite = new JButton("Deposite");
		btnDeposite.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double temp;
				temp = Double.parseDouble(label_1.getText());
				user.deposit(temp);
				JOptionPane.showMessageDialog(null, "You have successfully diposited $"+label_1.getText()+" in your balance");
				label_1.setText("");
			}
		});
		btnDeposite.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnDeposite.setBounds(305, 103, 129, 59);
		panel_2.add(btnDeposite);
		
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(false);
				panel_2.setVisible(false);
				panel_1.setVisible(true);
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnBack.setBounds(305, 185, 129, 59);
		panel_2.add(btnBack);
	}
}
