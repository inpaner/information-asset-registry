package view;
import java.awt.Dimension;

import javax.swing.JFrame;

import view.gui.page.Page;
import view.gui.page.PageBuilder;

public abstract class View extends JFrame{
	
	protected Page currentPage;
	protected PageBuilder currentPageBuilder;
	
	public static int ViewHeight = 640;
	public static int ViewWidth = 800;
	
	public View(){
		setSize(new Dimension(ViewWidth, ViewHeight));
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	protected void SelectBuilder(PageBuilder Builder){
		this.currentPageBuilder = Builder;
		this.currentPage = this.currentPageBuilder.BuildPage();
		setContentPane(this.currentPage);
	}
	
}
