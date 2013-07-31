package view;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import model.RegException;
import view.gui.page.Page;
import view.gui.page.PageBuilder;

@SuppressWarnings("serial")
public class View extends JFrame {
	protected Page currentPage;
	protected PageBuilder currentPageBuilder;
	
	public static final Dimension HeaderDimension = new Dimension(800, 30);
	public static final Dimension FooterDimension = new Dimension(800, 30);

	protected void SelectBuilder(PageBuilder Builder){

	}
	
	

    public View() {
        final String look = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    UIManager.setLookAndFeel(look);
                } 
                catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        
        setTitle("Information Asset Registry");
        setPreferredSize(new Dimension(300, 200));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    public void closeWindow() {
        WindowEvent event = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(event);
    }

    public void setPanel(final PageBuilder Builder) {
        this.getContentPane().removeAll();
        this.currentPageBuilder = Builder;
		try {
			this.currentPage = this.currentPageBuilder.Build();
		}catch (RegException e){
			e.printStackTrace();
		}
		pack();
        Thread controller = new setThread();
        controller.start();
        
    }
    
    private class setThread extends Thread {
        @Override
        public void run() {
            SwingUtilities.invokeLater(new setInvoke());
        }
    }

    private class setInvoke implements Runnable {
        @Override
        public void run() {
            getContentPane().add(currentPage);
            invalidate();
            validate();
        }
    }
    
    

}
