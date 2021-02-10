import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;

public class GUI implements ActionListener {
    private JPanel panel;
    private JPanel exitPanel;
    private JLabel label;
    private JTextField field;
    private JRadioButton radioButton1;
    private JRadioButton radioButton2;
    private JRadioButton radioButton3;
    private JFrame frame;
    private Color red = new Color(205,26,43);
    private Color backgroundColor = new Color(24,24,24);

    public GUI() {

        label = new JLabel("Type RB name");
        label.setForeground(Color.WHITE);
        frame = new JFrame();
        frame.setResizable(false);
        frame.setUndecorated(true);

        JButton button = new JButton("Click Me!");
        button.setForeground(Color.WHITE);
        button.setBackground(Color.GRAY);
        button.addActionListener(this);

        field = new JTextField();
        radioButton1 = new JRadioButton("RB1");
        radioButton2 = new JRadioButton("RB2");
        radioButton3 = new JRadioButton("RB3");

        panel = new JPanel();
        panel.setBackground(backgroundColor);


//------------------------------DON'T TOUCH!!!!------------------------
//https://docs.oracle.com/javase/tutorial/uiswing/layout/groupExample.html
        GroupLayout layout = new GroupLayout(panel);
        panel.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(layout.createSequentialGroup()
            .addComponent(label)
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(field)
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(radioButton1))
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(radioButton2))
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(radioButton3))))
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(button))
        );

        layout.setVerticalGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(label)
                .addComponent(field)
                .addComponent(button))
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(radioButton1)
                        .addComponent(radioButton2)
                        .addComponent(radioButton3))
        )));
//------------------------------DON'T TOUCH!!!!------------------------

        JPanel bufPan = new JPanel();
        bufPan.setLayout(new BorderLayout());
        bufPan.add(panel);

        JPanel test = new JPanel();
        test.setLayout(new BorderLayout());
        test.setBackground(Color.red);

        JButton exitButton = new JButton("X");
        exitButton.setBackground(backgroundColor);
        exitButton.setForeground(Color.WHITE);
        exitButton.setBorderPainted(false);
        exitButton.addActionListener(e -> {
            frame.dispose();
        });
        exitButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                exitButton.setBackground(red);
            }
            public void mouseExited(MouseEvent e){
                exitButton.setBackground(backgroundColor);
            }
        });
        exitPanel = new JPanel();
        exitPanel.setLayout(new BorderLayout());
        exitPanel.add(exitButton, BorderLayout.EAST);
        exitPanel.setBorder(BorderFactory.createEmptyBorder(0, 0,0,0));
        exitPanel.setBackground(backgroundColor);



        frame.add(exitPanel, BorderLayout.PAGE_START);
        frame.add(bufPan, BorderLayout.SOUTH);
        frame.add(test, BorderLayout.CENTER);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("GUI");
        frame.pack();
        frame.setSize(500, 500);
        frame.setLocation(710, 290);
        frame.setVisible(true);
    }


    public void actionPerformed(ActionEvent e) {
        label.setText("Type RB name");
    }


    public static void main(String[] args) {
        new GUI();
    }
}