package View.Panels.Auth;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Controller.UserController;
import Methods.Auth.Format.Auth;
import Model.User;

import javax.swing.JCheckBox;

public class signupPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4680303708794722038L;
	private JLabel signupLabel;
	private JLabel usernameLabel;
	private JTextField usernameField;
	private JLabel emailLabel;
	private JTextField emailField;
	private JLabel passwordLabel;
	private JPasswordField passwordField;
	private JCheckBox toggleCheckPassword;
	public JLabel toggleLabel;
	public JLabel alertLabel;
	private JButton submitButton;

	public signupPanel() {
		// Sign up label settings
		signupLabel = new JLabel("Sign up");
		signupLabel.setForeground(new Color(255, 255, 255));
		signupLabel.setFont(new Font("Tahoma", Font.BOLD, 36));
		signupLabel.setHorizontalAlignment(SwingConstants.CENTER);
		signupLabel.setBounds(10, 90, 1116, 44);
		add(signupLabel);

		// Username label settings
		usernameLabel = new JLabel("Username");
		Auth.formatFieldLabel(usernameLabel);
		usernameLabel.setBounds(423, 182, 291, 14);
		add(usernameLabel);

		// Username field settings
		usernameField = new JTextField();
		usernameLabel.setLabelFor(usernameField);
		Auth.formatField(usernameField);
		usernameField.setBounds(423, 207, 291, 30);
		add(usernameField);

		// Mail label settings
		emailLabel = new JLabel("Email");
		Auth.formatFieldLabel(emailLabel);
		emailLabel.setBounds(423, 258, 291, 14);
		add(emailLabel);

		// Mail field settings
		emailField = new JTextField();
		emailLabel.setLabelFor(emailField);
		Auth.formatField(emailField);
		emailField.setBounds(423, 283, 291, 30);
		add(emailField);

		// Password label settings
		passwordLabel = new JLabel("Password");
		Auth.formatFieldLabel(passwordLabel);
		passwordLabel.setBounds(423, 334, 291, 14);
		add(passwordLabel);

		// Password field settings
		passwordField = new JPasswordField();
		passwordLabel.setLabelFor(passwordField);
		Auth.formatField(passwordField);
		passwordField.setBounds(423, 360, 291, 30);
		add(passwordField);

		// Label to toggle between the sign up and the login panels
		toggleLabel = new JLabel("If you already have an account, you can log in");
		toggleLabel.setForeground(new Color(255, 255, 255));
		toggleLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		toggleLabel.setBounds(423, 443, 291, 20);
		add(toggleLabel);

		// Checkbox that reveals the password when ticked
		toggleCheckPassword = new JCheckBox("Reveal password");
		toggleCheckPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		toggleCheckPassword.setBackground(new Color(51, 51, 51));
		toggleCheckPassword.setForeground(new Color(255, 255, 255));
		toggleCheckPassword.setBounds(420, 410, 127, 23);
		add(toggleCheckPassword);

		toggleCheckPassword.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JCheckBox c = (JCheckBox) e.getSource();

				if (c.isSelected()) {
					passwordField.setEchoChar((char) 0);
				} else {
					passwordField.setEchoChar('●');
				}
			}
		});
		
		// User creation alert
		alertLabel = new JLabel("*New user successfully created*");
		alertLabel.setHorizontalAlignment(SwingConstants.CENTER);
		alertLabel.setForeground(new Color(255, 0, 0));
		alertLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		alertLabel.setBounds(423, 550, 291, 25);
		alertLabel.setVisible(false);
		add(alertLabel);

		// Submit button settings
		submitButton = new JButton("Submit");
		submitButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		submitButton.setForeground(new Color(255, 255, 255));
		submitButton.setBackground(new Color(0, 0, 255));
		submitButton.setBounds(423, 480, 291, 45);
		submitButton.setBorderPainted(false);
		add(submitButton);

		// MouseListeners
		Auth.setMouseActions(submitButton, toggleCheckPassword);
		
		submitButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				UserController uc = new UserController();
				
				if(!usernameField.getText().isEmpty() && !emailField.getText().isEmpty() && !passwordField.getText().isEmpty()) {
					User u = new User(null, usernameField.getText(), emailField.getText(), passwordField.getText());
					try {
						uc.create(u);
						alertLabel.setVisible(true);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});

		// Panel settings
		setLayout(null);
		setBackground(new Color(51, 51, 51));
		setBorder(new EmptyBorder(40, 40, 40, 40));
	}

	public void clearFieldContent() {
		usernameField.setText(null);
		emailField.setText(null);
		passwordField.setText(null);
		toggleCheckPassword.setSelected(false);
	}
}