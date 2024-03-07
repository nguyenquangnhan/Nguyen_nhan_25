package Clock.copy;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame {
    private JTextField textField;

    public Main() {
        setTitle("World Clock");
        setSize(300, 100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        JLabel label = new JLabel("Timezone:");
        textField = new JTextField(10);
        JButton addButton = new JButton("Add Clock");
        addButton.addActionListener(new ActionListener() {
            @Override	
            public void actionPerformed(ActionEvent e) {
                addClock();
            }
        });

        JPanel panel = new JPanel();
        panel.add(label);
        panel.add(textField);
        panel.add(addButton);

        add(panel);
        setVisible(true);
    }

    private void addClock() {
        String timezoneStr = textField.getText().trim();
        try {
            int timezone = Integer.parseInt(timezoneStr);
            if (timezone < -12 || timezone > 12) {
                throw new NumberFormatException();
            }
            ClockFrame clockFrame = new ClockFrame(timezone);
            clockFrame.start();
            clockFrame.setVisible(true);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid timezone. Please enter a number between -12 and 12.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Main();
            }
        });
    }
}