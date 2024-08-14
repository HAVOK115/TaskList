package View.Panels.User;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import Controller.TaskController;
import Model.Task;
import Model.User;

public class UserPanel extends JPanel {
	private TaskController tc = new TaskController();
	private Dimension size = Toolkit.getDefaultToolkit().getScreenSize();

	public UserPanel(User usr) {
		try {
			List<Task> taskList = tc.getByUserId(usr.getId());
			String[] taskListContent = new String[taskList.size()];
			
			for(int i = 0; i < taskList.size(); i++) {
				taskListContent[i] = taskList.get(i).getContent().toString();
			}
			
			// Panel settings
			setLayout(null);
			setBackground(new Color(51, 51, 51));

			// Scroll pane
			JScrollPane scroll = new JScrollPane();
			scroll.setBounds(((int) size.getWidth() * 17) / 100, ((int) size.getHeight() * 15) / 100, 500, 300);
			add(scroll);

			// Task list pane
			JList<String> list = new JList<String>(taskListContent);
			scroll.add(list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String[] getTaskListContent(List<Task> tl) {
		List<String> taskContentList = new ArrayList<String>();
		
		for(Task t : tl) {
			taskContentList.add(t.getContent().toString());
		}
		
		return (String[]) taskContentList.toArray();
	}
}
