package View.Panels.User;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import Controller.TaskController;
import Model.Task;
import Model.User;

public class UserPanel extends JPanel {
	private TaskController tc = new TaskController();
	private JPanel CenterPanel;
	private JPanel NorthPanel;
	private JTextField contentField;
	private boolean isLoggedOut = false;

	// TODO: Implement task creation and delete logic
	public UserPanel(User usr) {
		try {
			List<Task> taskList = tc.getByUserId(usr.getId());

			// Panel settings
			setLayout(new BorderLayout());
			setBackground(new Color(51, 51, 51));

			// North panel
			NorthPanel = new JPanel(new FlowLayout());
			add(NorthPanel, BorderLayout.NORTH);

			JLabel usernameLabel = new JLabel(usr.getUsername() + "'s Tasks");
			usernameLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
			NorthPanel.add(usernameLabel);

			// Center panel
			CenterPanel = new JPanel(null);
			add(CenterPanel, BorderLayout.CENTER);

			// Task list pane
			DefaultListModel<String> dlm = new DefaultListModel<String>();
			JList<String> list = new JList<String>(dlm);

			for (Task t : taskList) {
				dlm.addElement(t.getContent());
			}

			// Scroll pane
			JScrollPane scroll = new JScrollPane(list);
			scroll.setBounds(250, 75, 622, 402);
			CenterPanel.add(scroll);
			JButton createButton = new JButton("Create");
			createButton.setBounds(786, 34, 86, 30);
			CenterPanel.add(createButton);
			JButton removeButton = new JButton("Remove");
			removeButton.setBounds(776, 488, 96, 30);
			CenterPanel.add(removeButton);
			JButton logOutButton = new JButton("Log out");
			logOutButton.setBounds(250, 488, 96, 30);
			CenterPanel.add(logOutButton);

			logOutButton.addMouseListener(new MouseListener() {

				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseEntered(MouseEvent e) {
					logOutButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				}

				@Override
				public void mouseClicked(MouseEvent e) {
					setLoggedOut(true);
				}
			});
			;

			contentField = new JTextField();
			contentField.setBounds(250, 34, 526, 30);
			CenterPanel.add(contentField);
			contentField.setColumns(10);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean isLoggedOut() {
		return isLoggedOut;
	}

	public void setLoggedOut(boolean isLoggedOut) {
		this.isLoggedOut = isLoggedOut;
	}
}
