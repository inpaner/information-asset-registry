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
	public static final Font HeaderFont = new Font("Verdana", Font.BOLD, 24);
	public final static Dimension LblFieldDimension = new Dimension(150, 30);
	private static final Dimension HeaderDimension = new Dimension(240, 40);
	
	public static JLabel CreateLabel(String text){
		return new JLabel(text);
	}
		
	public static JLabel CreateHeader(String text){
		JLabel header = CreateLabel(text);
		header.setSize(HeaderDimension);
		header.setFont(HeaderFont);
		return header;
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
