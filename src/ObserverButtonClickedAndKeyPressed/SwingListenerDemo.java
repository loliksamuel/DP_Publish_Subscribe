package ObserverButtonClickedAndKeyPressed;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SwingListenerDemo {
    private JFrame mainFrame;
    private JLabel headerLabel;
    private JLabel statusLabel;
    private JPanel controlPanel;
    private JTextField textField;

    public SwingListenerDemo(){
        prepareGUI();
    }
    public static void main(String[] args){
        SwingListenerDemo  swingListenerDemo = new SwingListenerDemo();
        swingListenerDemo.showKeyListenerDemo();
    }
    private void prepareGUI(){
        mainFrame = new JFrame("Java SWING Examples");
        mainFrame.setSize(400,400);
        mainFrame.setLayout(new GridLayout(3, 1));

        headerLabel = new JLabel("",JLabel.CENTER );
        statusLabel = new JLabel("",JLabel.CENTER);
        statusLabel.setSize(350,100);

        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent){
                System.exit(0);
            }
        });
        controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());

        mainFrame.add(headerLabel);
        mainFrame.add(controlPanel);
        mainFrame.add(statusLabel);
        mainFrame.setVisible(true);
    }

    private void showKeyListenerDemo(){
        headerLabel.setText("Listener in action: KeyListener");
        textField  = new JTextField(10);
         
        JButton okButton = new JButton("OK");

        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                statusLabel.setText("Entered text: " + textField.getText());
            }
        });

        textField.addKeyListener(new KeyListener(){
            public void keyTyped(KeyEvent e) {
            }
            public void keyPressed(KeyEvent e) {
                //if(e.getKeyCode() == KeyEvent.VK_ENTER){
                statusLabel.setText("Entered text: " + e.getKeyChar());
                //}
            }
            public void keyReleased(KeyEvent e) {
            }
        }
        );
        controlPanel.add(textField);
        controlPanel.add(okButton);
        mainFrame.setVisible(true);
    }

}