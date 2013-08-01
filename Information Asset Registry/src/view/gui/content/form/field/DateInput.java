package view.gui.content.form.field;
import java.beans.PropertyChangeListener;

import javax.swing.JComboBox;
import javax.swing.event.ChangeListener;

import net.sourceforge.jdatepicker.DateModel;
import net.sourceforge.jdatepicker.JDateComponentFactory;
import net.sourceforge.jdatepicker.JDatePanel;
import model.attribute.DateAttribute;
import model.attribute.RestrictedAttribute;

public class DateInput extends Input{
	
	private class MyDateModel<T> implements DateModel<T>{

		@Override
		public void addChangeListener(ChangeListener arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void addDay(int arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void addMonth(int arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void addPropertyChangeListener(PropertyChangeListener arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void addYear(int arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public int getDay() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public int getMonth() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public T getValue() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public int getYear() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public boolean isSelected() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public void removeChangeListener(ChangeListener arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void removePropertyChangeListener(PropertyChangeListener arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void setDate(int arg0, int arg1, int arg2) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void setDay(int arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void setMonth(int arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void setSelected(boolean arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void setValue(T arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void setYear(int arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	public DateInput(RestrictedAttribute attribute){
		super(attribute);
		component = new JComboBox<String>();
	}
	
	public DateInput(DateAttribute attribute) {
        super(attribute);
		component = new ConcreteDatePanel(new MyDateModel<>() );
		
	}

    public void initialize() {
		
	}

	public void setInput() {
		// TODO Auto-generated method stub

	}
	
}
