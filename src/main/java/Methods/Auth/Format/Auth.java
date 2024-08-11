package Methods.Auth.Format;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Auth {
	public static void formatFieldLabel(JLabel label) {
		label.setForeground(new Color(255, 255, 255));
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
	}

	public static void formatField(JTextField field) {
		field.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		field.setColumns(10);
	}

	public static void formatField(JPasswordField field) {
		field.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		field.setColumns(10);
	}

	public static void setMouseActions(JButton btn) {
		btn.addMouseListener(new MouseListener() {

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				btn.setCursor(new Cursor(Cursor.HAND_CURSOR));

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}
}