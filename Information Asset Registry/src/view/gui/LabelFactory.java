package view.gui;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;

import sun.font.FontManager;
import sun.font.FontManagerFactory;

public class LabelFactory {
	
	public static int HeaderWidth = 640;
	public static int HeaderHeight = 40;
	public static Font HeaderFont = new Font("Verdana", Font.BOLD, 24); 
	public final static Dimension LblFieldDimension = new Dimension(150, 30);
	
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

	public static JLabel CreateFormLabel(String string) {
		JLabel label = CreateLabel(string);
		label.setPreferredSize(LblFieldDimension);
		return label;
	}

	public static JLabel CreateFormErrorLabel(String string) {
		JLabel label = CreateLabel(string);
		label.setPreferredSize(LblFieldDimension);
		label.setForeground(Color.RED);
		return label;
	}
}
