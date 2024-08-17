package View;

import java.awt.CardLayout;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.formdev.flatlaf.FlatDarkLaf;

import Model.User;
import View.Panels.Auth.loginPanel;
import View.Panels.Auth.signupPanel;
import View.Panels.User.UserPanel;

public class MainFrame extends JFrame {
	private JPanel mainPanel;
	private signupPanel signup;
	private loginPanel login;
	private UserPanel userPanel;
	private Thread checkIsLogged;
	private Thread checkIsLoggedOut;

	public MainFrame() {
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

		// Shows the signup panel first
		cl.show(mainPanel, "SIGN_UP");

		signup.toggleLabel.addMouseListener(new MouseListener() {
			String signupToggleText = signup.toggleLabel.getText();

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				cl.show(mainPanel, "LOG_IN");
				signup.clearFieldContent();
				signup.alertLabel.setVisible(false);
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
				cl.show(mainPanel, "SIGN_UP");
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

		// Thread that checks if the user had sucessfully log in
		checkIsLogged = new Thread(new Runnable() {

			@Override
			public void run() {
				while (true) {
					if (login.isLogged() == true) {
						User u = login.getLoggedUser();
						userPanel = new UserPanel(u);
						mainPanel.add(userPanel, "USER_PANEL");
						cl.show(mainPanel, "USER_PANEL");
						System.out.println("USER LOGGED");
						login.setLogged(false);
					}

					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
						break;
					}
				}
			}
		});
		checkIsLogged.start();

		// Thread that checks if the user is logging out
		checkIsLoggedOut = new Thread(new Runnable() {

			@Override
			public void run() {
				while (true) {
					if (userPanel != null && userPanel.isLoggedOut()) {
						cl.show(mainPanel, "SIGN_UP");
						System.out.println("LOGGED OUT");
						userPanel.setLoggedOut(false);
					}

					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		checkIsLoggedOut.start();

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
		FlatDarkLaf.registerCustomDefaultsSource("themes");
		FlatDarkLaf.setup();
		MainFrame mf = new MainFrame();
	}
}