package view;
import java.awt.Dimension;

import javax.swing.JFrame;

import model.RegException;
import view.gui.page.Page;
import view.gui.page.PageBuilder;

public abstract class View extends JFrame{
	
	public static final int ContentHeight = 512;
	public static final int FooterHeight = 40;
	public static final int HeaderHeight = 40;
	protected Page currentPage;
	protected PageBuilder currentPageBuilder;
	
	public static int ViewHeight = 640;
	public static int ViewWidth = 400;
	
	public View(){
		setSize(new Dimension(ViewWidth, ViewHeight));
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	protected void SelectBuilder(PageBuilder Builder){
		this.currentPageBuilder = Builder;
		try {
			this.currentPage = this.currentPageBuilder.Build();
		}catch (RegException e){
			e.printStackTrace();
		}
		setContentPane(this.currentPage);
		pack();
	}
	
}
