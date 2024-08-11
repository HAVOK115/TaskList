package View.Panels.Auth;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.formdev.flatlaf.FlatDarkLaf;

import Controller.UserController;
import Methods.Auth.Format.Auth;
import Model.User;

public class loginPanel extends JPanel {
	private JLabel loginLabel;
	private JLabel emailLabel;
	private JTextField emailField;
	private JLabel passwordLabel;
	private JPasswordField passwordField;
	private JLabel repeatPasswordLabel;
	private JPasswordField repeatPasswordField;
	public JLabel toggleLabel;
	private JButton submitButton;
	
	private boolean isLogged;
	private User u;

	public loginPanel() {
		// Sign up label settings
		loginLabel = new JLabel("Log in");
		loginLabel.setForeground(new Color(255, 255, 255));
		loginLabel.setFont(new Font("Tahoma", Font.BOLD, 36));
		loginLabel.setHorizontalAlignment(SwingConstants.CENTER);
		loginLabel.setBounds(10, 90, 1116, 44);
		add(loginLabel);

		// Username label settings
		emailLabel = new JLabel("Email");
		Auth.formatFieldLabel(emailLabel);
		emailLabel.setBounds(423, 182, 291, 14);
		add(emailLabel);

		// Username field settings
		emailField = new JTextField();
		emailLabel.setLabelFor(emailField);
		Auth.formatField(emailField);
		emailField.setBounds(423, 207, 291, 30);
		add(emailField);

		// Password label settings
		passwordLabel = new JLabel("Password");
		Auth.formatFieldLabel(passwordLabel);
		passwordLabel.setBounds(423, 258, 291, 14);
		add(passwordLabel);

		// Password field settings
		passwordField = new JPasswordField();
		passwordLabel.setLabelFor(passwordField);
		Auth.formatField(passwordField);
		passwordField.setBounds(423, 283, 291, 30);
		add(passwordField);

		// Repeat Password label settings
		repeatPasswordLabel = new JLabel("Repeat password");
		Auth.formatFieldLabel(repeatPasswordLabel);
		repeatPasswordLabel.setBounds(423, 334, 291, 14);
		add(repeatPasswordLabel);

		// Repeat Password field settings
		repeatPasswordField = new JPasswordField();
		repeatPasswordLabel.setLabelFor(repeatPasswordField);
		Auth.formatField(repeatPasswordField);
		repeatPasswordField.setBounds(423, 360, 291, 30);
		add(repeatPasswordField);

		toggleLabel = new JLabel("If you don't have an account yet, you can sign up");
		toggleLabel.setForeground(new Color(255, 255, 255));
		toggleLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		toggleLabel.setBounds(423, 420, 320, 20);
		add(toggleLabel);

		// Submit button settings
		submitButton = new JButton("Submit");
		submitButton.setBounds(423, 480, 291, 45);
		add(submitButton);

		// MouseListeners
		Auth.setMouseActions(submitButton);
		submitButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				UserController uc = new UserController();
				try {
					u = uc.getByEmail(emailField.getText());
					if(passwordField.getText().equals(u.getPassword()) && repeatPasswordField.getText().equals(passwordField.getText())) {
						isLogged = true;
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		// Panel settings
		setLayout(null);
		setBorder(new EmptyBorder(40, 40, 40, 40));
	}

	public void clearFieldContent() {
		emailField.setText(null);
		passwordField.setText(null);
		repeatPasswordField.setText(null);
	}
	
	public User getLoggedUser() {
		return u;
	}

	public boolean isLogged() {
		return isLogged;
	}

	public void setLogged(boolean isLogged) {
		this.isLogged = isLogged;
	}
}