package view.gui;
import javax.swing.JButton;

public class ButtonFactory {
	
	public static JButton CreateButton(String text){
		return new JButton(text);
	}
	
	private ButtonFactory(){
	
	}
}
