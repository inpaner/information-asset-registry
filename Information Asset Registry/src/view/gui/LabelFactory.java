package view.gui;
import java.awt.Font;

import javax.swing.JLabel;

import sun.font.FontManager;
import sun.font.FontManagerFactory;

public class LabelFactory {
	
	public static int HeaderWidth = 640;
	public static int HeaderHeight = 40;
	public static Font HeaderFont = new Font("Verdana", 24, Font.BOLD); 
	
	public static JLabel CreateLabel(String text){
		return new JLabel(text);
	}
	
	public static JLabel CreateHeader(String text){
		JLabel header = CreateLabel(text);
		header.setFont(HeaderFont);
		return header;
	}
	
	private LabelFactory(){
	
	}
}
