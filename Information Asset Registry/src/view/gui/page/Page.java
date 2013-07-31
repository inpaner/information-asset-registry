package view.gui.page;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

<<<<<<< HEAD
=======
import net.miginfocom.swing.MigLayout;
>>>>>>> branch 'master' of https://github.com/inpaner/information-asset-registry.git
import view.View;
import view.gui.content.Content;

public class Page extends JPanel{
	private JPanel Header;
	private Content Content;
	private JPanel Footer;
	
	public Page (){
		super();
<<<<<<< HEAD
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
=======
		setLayout(new MigLayout());
>>>>>>> branch 'master' of https://github.com/inpaner/information-asset-registry.git
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
<<<<<<< HEAD
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
=======
		int width = View.ViewWidth;
		Header.setPreferredSize(new Dimension(width, View.FooterHeight));
		Footer.setPreferredSize(new Dimension(width, View.HeaderHeight));
		
		
		add(Header, "wrap");
		add(Content, "wrap");
		add(Footer, "wrap");
>>>>>>> branch 'master' of https://github.com/inpaner/information-asset-registry.git
	}
}
