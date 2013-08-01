package view.gui;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;

import sun.font.FontManager;
import sun.font.FontManagerFactory;

public class LabelFactory {
	public static int headerWidth = 640;
	public static int headerHeight = 40;
	public static final Font headerFont = new Font("Verdana", Font.BOLD, 24);
	public final static Dimension lblFieldDimension = new Dimension(150, 30);
	private static final Dimension headerDimension = new Dimension(240, 40);
	
	public static JLabel createLabel(String text){
		return new JLabel(text);
	}
		
	public static JLabel createHeader(String text){
		JLabel header = createLabel(text);
		header.setSize(headerDimension);
		header.setFont(headerFont);
		return header;
	}

	public static JLabel createFormLabel(String string) {
		JLabel label = createLabel(string);
		label.setPreferredSize(lblFieldDimension);
		return label;
	}

	public static JLabel createFormErrorLabel(String string) {
		JLabel label = createLabel(string);
		label.setPreferredSize(lblFieldDimension);
		label.setForeground(Color.RED);
		return label;
	}
}
