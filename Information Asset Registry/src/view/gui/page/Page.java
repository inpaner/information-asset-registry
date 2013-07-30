package view.gui.page;

import javax.swing.JPanel;

import view.gui.content.Content;

public class Page extends JPanel{
	private JPanel Header;
	private Content Body;
	private JPanel Footer;
	
	public JPanel getHeader() {
		return Header;
	}
	public void setHeader(JPanel header) {
		Header = header;
	}
	public Content getBody() {
		return Body;
	}
	public void setBody(Content body) {
		Body = body;
	}
	public JPanel getFooter() {
		return Footer;
	}
	public void setFooter(JPanel footer) {
		Footer = footer;
	}
}
