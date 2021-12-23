package app.myapp.calculator;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class CenterPanel extends JPanel{
	String numberStrings[] = {"()",".","%","Del","1", "2", "3","÷", "4", "5", "6", "×", "7", "8", "9", "-", "AC", "0", "=", "+"};
	JButton numberButtons[] = new JButton[numberStrings.length];
	
	public CenterPanel() {
		setBackground(Color.BLACK);
		setLayout(new GridLayout(5,4,2,2));
		
		for(int i=0; i<numberStrings.length; i++) {
			
			numberButtons[i] = new JButton(numberStrings[i]);
			numberButtons[i].setFont(new Font("맑은 고딕", Font.PLAIN, 15));
			numberButtons[i].setPreferredSize(new Dimension(50, 50));
			
			if(i<4 || i==numberStrings.length-4 || i==numberStrings.length-2) {
				numberButtons[i].setBackground(Color.orange);
				if (i==0) numberButtons[i].addActionListener(new BraketListener());
				else if (i<=2) numberButtons[i].addActionListener(new NumberListener());
				else if (i==3) numberButtons[i].addActionListener(new DeleteListener());
				else if(i==numberStrings.length-4 ) numberButtons[i].addActionListener(new ClearListener());
				else numberButtons[i].addActionListener(new CalcListener());
			}
			else {
				if(i%4 < 3) numberButtons[i].setBackground(Color.lightGray);
				else numberButtons[i].setBackground(Color.orange);
				numberButtons[i].addActionListener(new NumberListener());
			}
			add(numberButtons[i]);
		}
	}
}
