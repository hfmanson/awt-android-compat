package awttests;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonGrid extends Applet {
    private void borderLayoutTest() {
        setLayout(new BorderLayout());
        add(new Button("Noord"), BorderLayout.NORTH);
        add(new Button("Ouest"), BorderLayout.WEST);
        add(new Button("Centrum"), BorderLayout.CENTER);
        add(new Button("Oost"), BorderLayout.EAST);
        add(new Button("Zuid"), BorderLayout.SOUTH);
    }

    private void gridLayoutTest() {
        setLayout(new GridLayout(3,2));
        add(new Button("1"));
        Button button2 = new Button("2");
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("actionPerformed: " + e.getActionCommand());
            }
        });
        add(button2);
        add(new Button("3"));
        add(new Button("4"));
        add(new Button("5"));
        add(new Button("6"));
    }

    @Override
    public void init() {
        gridLayoutTest();
    }
}