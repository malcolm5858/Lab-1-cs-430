import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class gui extends JPanel implements ActionListener {
    protected JLabel mergeTimer, insertionTimer;
    protected JTextField sizeInput;

    public gui() {
        // Creating the panel at bottom and adding components
        this.setLayout(new BorderLayout());
        JPanel panel = new JPanel(); // the panel is not visible in output
        JButton start = new JButton("Start");
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        JPanel timePanel = new JPanel();
        JLabel mergeSort = new JLabel("Merge Sort     ");
        JLabel insertionSort = new JLabel("    Insertion Sort");
        JLabel BlankSpace = new JLabel("                     ");
        JLabel arrayText = new JLabel("Enter array size");
        mergeTimer = new JLabel("0 ms");
        insertionTimer = new JLabel("0 ms");
        sizeInput = new JTextField(9);
        start.setActionCommand("Go");
        start.addActionListener(this);

        mergeTimer.setFont(new Font("Verdana", Font.PLAIN, 30));
        insertionTimer.setFont(new Font("Verdana", Font.PLAIN, 30));
        panel.setLayout(new BorderLayout());
        panel.add(start);
        panel2.add(mergeSort);
        panel2.add(BlankSpace);
        panel2.add(insertionSort);
        panel3.add(arrayText);
        panel3.add(sizeInput);
        timePanel.add(mergeTimer);
        timePanel.add(BlankSpace);
        timePanel.add(insertionTimer);

        // Adding Components to the frame.
        panel.add(BorderLayout.NORTH, panel3);
        add(BorderLayout.SOUTH, panel);
        add(BorderLayout.NORTH, panel2);
        add(BorderLayout.CENTER, timePanel);

    }

    public void actionPerformed(ActionEvent e) {
        // Processes acton when the start button is pressed
        if ("Go".equals(e.getActionCommand())) {
            int arraySize = 0;
            if (sizeInput.getText().equals("")) {
                arraySize = 100;
            } else {
                arraySize = Integer.parseInt(sizeInput.getText());
            }
            long[] values = lab1.run(arraySize);
            mergeTimer.setText(values[1] + " ms");
            insertionTimer.setText(values[0] + " ms");

        }
    }

    private static void createAndShowGUI() {

        // Create and set up the window.
        JFrame frame = new JFrame("Lab1 Sorting");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(1000, 200));

        // Create and set up the content pane.
        gui newContentPane = new gui();
        newContentPane.setOpaque(true); // content panes must be opaque
        frame.setContentPane(newContentPane);

        // Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        // Schedule a job for the event-dispatching thread:
        // creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

}