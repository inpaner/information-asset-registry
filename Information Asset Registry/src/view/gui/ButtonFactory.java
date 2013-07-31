package view.gui;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;

public class ButtonFactory {
	
	private static Font ButtonFont = new Font("Verdana", Font.PLAIN, 12);
	
	public static JButton CreateButton(String text){
		JButton button = new JButton(text);
		button.setFont(ButtonFont);
		button.setFocusable(false);
		button.setPreferredSize(new Dimension(100, 28));
		return button;
	}
	
	private ButtonFactory(){
	
	}
}
