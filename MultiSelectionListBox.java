import javax.swing.*;
import java.awt.*;
import javax.swing.event.*;

class MultiSelectionListBox implements ListSelectionListener {
    static JList<String> list;
    static JLabel label;

    // Driver function
    public static void main(String args[]) {
        // Create a frame
        JFrame frame = new JFrame("Multiple Selection List Box");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.getContentPane().setBackground(Color.white);
        // Create a list
        String lang[] = { "C", "C++", "Java", "Python", "R" };
        list = new JList<String>(lang);
        list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        list.setBounds(150, 150, 150, 150);
        frame.add(list);
        // Create a label
        label = new JLabel("Select items from list");
        label.setBounds(0, 0, 500, 50);
        frame.add(label);
        // Create an object
        MultiSelectionListBox obj = new MultiSelectionListBox();
        // Add ListSelectionListener to list
        list.addListSelectionListener(obj);
        // Display the frame
        frame.setVisible(true);
    }

    // Function to display the items selected
    public void valueChanged(ListSelectionEvent e) {
        // Get index of items selected
        int index[] = list.getSelectedIndices();
        // Get the items selected from their indices
        String str = "";
        for (int i = 0; i < index.length; i++)
            str = str + list.getModel().getElementAt(index[i]) + ", ";
        str = str.replaceAll(", $", "");
        // Change label to items selected
        label.setText("Items Selected : " + str);
    }
}