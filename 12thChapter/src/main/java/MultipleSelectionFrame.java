// Fig. 12.25: MultipleSelectionFrame.java
// JList that allows multiple selections.

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

public class MultipleSelectionFrame extends JFrame {

    private final JList<String> colorList; // list to hold color names
    private final JList<String> copyJList; // list to hold copied names
    private JButton copyJButton; // button to copy selected names

    private static final String[] colorNames = {
        "Black", "Blue", "Cyan", "Dark Gray", 
        "Gray", "Green", "Light Gray", "Magenta", 
        "Orange", "Pink", "Red", "White", "Yellow"
    };

    // MultipleSelectionFrame constructor
    public MultipleSelectionFrame() {
        super("Multiple Selection Lists");
        setLayout(new FlowLayout());

        colorList = new JList<>(colorNames); // list of color names
        colorList.setVisibleRowCount(5); // show five rows
        colorList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        add(new JScrollPane(colorList)); // add list with scroll pane

        copyJButton = new JButton("Copy >>>");
        copyJButton.addActionListener(new ActionListener() { // anonymous inner class
            // handle button event
            @Override
            public void actionPerformed(ActionEvent event) {
                // place selected values in copy list
                copyJList.setListData(colorList.getSelectedValuesList().toArray(new String[0]));
            }
        });

        add(copyJButton); // add copy button to JFrame

        copyJList = new JList<>(); // list to hold copied color names
        copyJList.setVisibleRowCount(5); // show 5 rows
        copyJList.setFixedCellWidth(100); // set width
        copyJList.setFixedCellHeight(15); // set height
        copyJList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        add(new JScrollPane(copyJList)); // add list with scroll pane
    }
}
