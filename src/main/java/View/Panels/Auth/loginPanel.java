package View.Panels.Auth;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Methods.Auth.Format.Auth;

public class loginPanel extends JPanel {
	private JLabel loginLabel;
	private JLabel emailLabel;
	private JTextField emailField;
	private JLabel passwordLabel;
	private JPasswordField passwordField;
	private JLabel repeatPasswordLabel;
	private JPasswordField repeatPasswordField;
	private JCheckBox toggleCheckPassword;
	public JLabel toggleLabel;
	private JButton submitButton;

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

		// Mail label settings
		passwordLabel = new JLabel("Password");
		Auth.formatFieldLabel(passwordLabel);
		passwordLabel.setBounds(423, 258, 291, 14);
		add(passwordLabel);

		// Mail field settings
		passwordField = new JPasswordField();
		passwordLabel.setLabelFor(passwordField);
		Auth.formatField(passwordField);
		passwordField.setBounds(423, 283, 291, 30);
		add(passwordField);

		// Password label settings
		repeatPasswordLabel = new JLabel("Repeat password");
		Auth.formatFieldLabel(repeatPasswordLabel);
		repeatPasswordLabel.setBounds(423, 334, 291, 14);
		add(repeatPasswordLabel);

		// Password field settings
		repeatPasswordField = new JPasswordField();
		repeatPasswordLabel.setLabelFor(repeatPasswordField);
		Auth.formatField(repeatPasswordField);
		repeatPasswordField.setBounds(423, 360, 291, 30);
		add(repeatPasswordField);

		toggleLabel = new JLabel("If you don't have an account yet, you can sign up");
		toggleLabel.setForeground(new Color(255, 255, 255));
		toggleLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		toggleLabel.setBounds(423, 443, 320, 20);
		add(toggleLabel);

		toggleCheckPassword = new JCheckBox("Reveal password");
		toggleCheckPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		toggleCheckPassword.setBackground(new Color(51, 51, 51));
		toggleCheckPassword.setForeground(new Color(255, 255, 255));
		toggleCheckPassword.setBounds(420, 410, 291, 23);
		add(toggleCheckPassword);

		toggleCheckPassword.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JCheckBox c = (JCheckBox) e.getSource();

				if (c.isSelected()) {
					passwordField.setEchoChar((char) 0);
					repeatPasswordField.setEchoChar((char) 0);
				} else {
					passwordField.setEchoChar('●');
					repeatPasswordField.setEchoChar('●');
				}
			}
		});

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

		// Panel settings
		setLayout(null);
		setBackground(new Color(51, 51, 51));
		setBorder(new EmptyBorder(40, 40, 40, 40));
	}

	public void clearFieldContent() {
		emailField.setText(null);
		passwordField.setText(null);
		repeatPasswordField.setText(null);
		toggleCheckPassword.setSelected(false);
	}
}