package gui;

import javax.swing.*;

public class MainFrame extends JFrame {

    public MainFrame(){
        setSize(1024,720);
        setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setContentPane(new Menu(this));
        invalidate();
        validate();
    }
}
