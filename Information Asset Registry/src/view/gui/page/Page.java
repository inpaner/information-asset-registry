package view.gui.page;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import view.View;
import view.gui.content.Content;

public class Page extends JPanel{
	private JPanel Header;
	private Content Content;
	private JPanel Footer;
	
	public Page (){
		super();
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		Header = new JPanel(new FlowLayout(FlowLayout.CENTER, 2, 2));
		Footer = new JPanel(new FlowLayout(FlowLayout.RIGHT, 2, 2));
	}
	
	public JPanel getHeader() {
		return Header;
	}
	public void setHeader(JPanel header) {
		Header = header;
	}
	
	public JPanel getFooter() {
		return Footer;
	}
	public void setFooter(JPanel footer) {
		Footer = footer;
	}

	public Content getContent() {
		return Content;
	}

	public void setContent(Content content) {
		Content = content;
	}

	public final void initialize(){
		Header.setBorder(BorderFactory.createLineBorder(Color.RED));
		Content.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		Footer.setBorder(BorderFactory.createLineBorder(Color.GREEN));
		
		int width = View.ViewWidth;
		int height = 20;
		int contentheight = View.ContentHeight;
		Header.setPreferredSize(new Dimension(width, height));
		Content.setPreferredSize(new Dimension(width, contentheight));
		Footer.setPreferredSize(new Dimension(width, height));
		
		add(Header);
		add(Content);
		add(Footer);
	}
}
