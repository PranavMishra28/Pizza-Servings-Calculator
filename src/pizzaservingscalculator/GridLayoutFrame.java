/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pizzaservingscalculator;

import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JPanel;

public class GridLayoutFrame extends JFrame {
    
    private final JLabel label1;
    private final JLabel label2;
    private final JLabel label3;
    private final JButton button;
    private final JTextField textField;
    private final GridLayout layout;
    private final JPanel slot2;
    
    public GridLayoutFrame() {
        
        super("Pizza Servings Calculator");
        layout = new GridLayout(4,1);
        setLayout(layout);
        
        label1 = new JLabel();
        label1.setText("Pizza Servings Calculator");
        label1.setFont(new Font("Serif", Font.BOLD, 24));
        label1.setForeground(Color.red);
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        add(label1);
        
        label2 = new JLabel("Enter the size of the pizza in inches: ");
        textField = new JTextField(4);
        slot2 = new JPanel();
        slot2.setLayout(new FlowLayout());
        slot2.add(label2);
        slot2.add(textField);
        add(slot2);
        
        button = new JButton("Calculate Servings");
        add(button);
        ButtonHandler handler = new ButtonHandler();
        button.addActionListener(handler);
                
        label3 = new JLabel("", SwingConstants.CENTER);
        add(label3);
    }

    private class ButtonHandler implements ActionListener 
    {
        @Override
        public void actionPerformed(ActionEvent event)
        {
            if (!textField.getText().isEmpty())
            {
                double size = Double.parseDouble(textField.getText());
                double servings = Math.pow(size/8, 2);
                String output = String.format("A %.0f inch pizza will serve %.2f people.", size, servings);
                label3.setText(output);       
            }
        }
    }
}
