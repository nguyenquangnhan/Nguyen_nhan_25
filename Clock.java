package Clock.copy;
import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Clock extends JPanel {
    private JLabel timeLabel;

    public Clock() {
        setBounds(0,0,200,100);
        setLayout(new FlowLayout());

        timeLabel = new JLabel();
        add(timeLabel);
    }

    public void Start() {
        new Thread(()->{
            while (true) {
                updateTime();
            }
        }).start();

    }

    private void updateTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        timeLabel.setText(dateFormat.format(new Date()));
    }


}
