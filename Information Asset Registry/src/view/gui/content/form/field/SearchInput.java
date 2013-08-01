package view.gui.content.form.field;

import java.util.List;

import javax.swing.JComboBox;

import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import org.jdesktop.swingx.combobox.ListComboBoxModel;

import model.Core;
import model.CoreUtil;
import model.RegException;
import model.attribute.CoreAttribute;

public class SearchInput extends Input {
    
    JComboBox jComboBox;
    CoreAttribute coreAttribute;
    
    public SearchInput(CoreAttribute attribute){
        super(attribute);
        coreAttribute = attribute;
        component = jComboBox = new JComboBox<String>();
        AutoCompleteDecorator.decorate(jComboBox);
        component.setPreferredSize(Input.textInputDimension);
    }
    
    @Override
    public void setInput() throws RegException {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void initialize() {
        Core core = coreAttribute.getValue();
        List<Core> list = java.util.Collections.unmodifiableList(CoreUtil.getAll(core.getName()));
        jComboBox.setModel(new ListComboBoxModel<Core>(list));
        jComboBox.setSelectedItem(core);
    }

    @Override
    public void setEditable(boolean editable) {
        jComboBox.setEditable(editable);
    }

}
