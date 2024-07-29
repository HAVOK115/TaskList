package View;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

import View.Panels.Auth.loginPanel;
import View.Panels.Auth.signupPanel;

public class Main extends JFrame {
	private JPanel mainPanel;
	private signupPanel signup;
	private loginPanel login;

	public Main() {
		// Window width and height will be the 60% of the screen size
		Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int) (size.getWidth() * 60) / 100;
		int height = (int) (size.getHeight() * 60) / 100;

		// Panels
		signup = new signupPanel();
		login = new loginPanel();

		// Card layout
		CardLayout cl = new CardLayout(0, 0);
		mainPanel = new JPanel(cl);

		mainPanel.add(signup, "SIGN_UP");
		mainPanel.add(login, "LOG_IN");
		cl.first(mainPanel);

		signup.toggleLabel.addMouseListener(new MouseListener() {
			String signupToggleText = signup.toggleLabel.getText();

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				cl.last(mainPanel);
				signup.clearFieldContent();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				signup.toggleLabel.setText(signupToggleText);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				signup.toggleLabel.setText("<HTML><U>" + signupToggleText + "<U/><HTML/>");
				signup.toggleLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});

		login.toggleLabel.addMouseListener(new MouseListener() {
			String loginToggleText = login.toggleLabel.getText();

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				cl.first(mainPanel);
				login.clearFieldContent();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				login.toggleLabel.setText(loginToggleText);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				login.toggleLabel.setText("<HTML><U>" + loginToggleText + "<U/><HTML/>");
				login.toggleLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});

		// Window settings
		setContentPane(mainPanel);
		setTitle("TaskList");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(width, height);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
	}

	public static void main(String[] args) {
		// Uses the system look and feel
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (UnsupportedLookAndFeelException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		Main m = new Main();
	}
}