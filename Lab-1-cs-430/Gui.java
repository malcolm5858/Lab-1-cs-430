import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//Team Yamaha piano: Malcolm Machesky seatNo: 45 CWID: A20414760, Adrian Kirchner seatNo: 34 CWID: A20425060
class gui extends JPanel implements ActionListener {
    // adding label and textfield that have to be changed when you hit the start
    // button
    protected JLabel quickTimer, heapTimer;
    protected JTextField sizeInput;

    public gui() {
        // Creating the panel at bottom and adding components
        // setting the layout of the class gui
        this.setLayout(new BorderLayout());
        // creating the panels buttons and labels for the gui
        JPanel panel = new JPanel();
        JButton start = new JButton("Start");
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        JPanel timePanel = new JPanel();
        JLabel quickSort = new JLabel("Quick Sort     ");
        JLabel heapSort = new JLabel("    Heap Sort");
        JLabel BlankSpace = new JLabel("                     ");
        JLabel arrayText = new JLabel("Enter array size");
        quickTimer = new JLabel("0 ms");
        heapTimer = new JLabel("0 ms");
        sizeInput = new JTextField(9);
        // adding listener to the button so we can run our algorithms when the button is
        // pressed
        start.setActionCommand("Go");
        start.addActionListener(this);
        // changing the font on the timers to make it easier to read
        quickTimer.setFont(new Font("Verdana", Font.PLAIN, 30));
        heapTimer.setFont(new Font("Verdana", Font.PLAIN, 30));
        // making the layout for the start button and input box panel so the go above
        // and below each other
        panel.setLayout(new BorderLayout());
        // adding all the labels input boxes and buttons to there correct panel
        panel.add(start);
        panel2.add(quickSort);
        panel2.add(BlankSpace);
        panel2.add(heapSort);
        panel3.add(arrayText);
        panel3.add(sizeInput);
        timePanel.add(quickTimer);
        timePanel.add(BlankSpace);
        timePanel.add(heapTimer);

        // Adding Panels to there frames
        panel.add(BorderLayout.NORTH, panel3);
        add(BorderLayout.SOUTH, panel);
        add(BorderLayout.NORTH, panel2);
        add(BorderLayout.CENTER, timePanel);

    }

    public void actionPerformed(ActionEvent e) {
        // Processes acton when the start button is pressed
        if ("Go".equals(e.getActionCommand())) {
            // checking if there is no input in the text box
            int arraySize = 0;
            if (sizeInput.getText().equals("")) {
                arraySize = 100; // Default value of arraysize if no input is in the box
            } else {
                arraySize = Integer.parseInt(sizeInput.getText());
            }
            // Getting times returned from the run function in Lab3
            long[] values = Lab3.run(arraySize);
            // displaying the times on the gui
            quickTimer.setText(values[1] + " ms");
            heapTimer.setText(values[0] + " ms");

        }
    }

    private static void createAndShowGUI() {

        // Create and set up the window.
        JFrame frame = new JFrame("Lab3 Sorting");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Set the size of the window to start out with
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