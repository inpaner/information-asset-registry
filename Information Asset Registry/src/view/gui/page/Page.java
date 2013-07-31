package view.gui.page;
import java.awt.FlowLayout;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;
import view.View;
import view.gui.content.Content;

public class Page extends JPanel{
	private JPanel Header;
	private Content Content;
	private JPanel Footer;
	
	public Page (){
		super();
		setLayout(new MigLayout());
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
		Header.setPreferredSize(View.HeaderDimension);
		Footer.setPreferredSize(View.FooterDimension);
		
		add(Header, "wrap");
		add(Content, "wrap");
		add(Footer, "wrap");
	}
}
