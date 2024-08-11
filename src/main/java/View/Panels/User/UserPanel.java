package View.Panels.User;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Model.User;
import javax.swing.SwingConstants;
import java.awt.Font;

public class UserPanel extends JPanel{
	public UserPanel(User usr) {
		
		// Panel settings
		setLayout(new BorderLayout());
		setBackground(new Color(51, 51, 51));
		setBorder(new EmptyBorder(40, 40, 40, 40));
		
		// Greeting label
		JLabel greetingLabel = new JLabel("Welcome, " + usr.getUsername() + "!");
		greetingLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		greetingLabel.setHorizontalAlignment(SwingConstants.CENTER);
		add(greetingLabel, BorderLayout.CENTER);
	}
}
