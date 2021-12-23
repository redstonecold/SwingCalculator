package app.myapp.calculator;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class NorthPanel extends JPanel{
	static JLabel info;
	static JLabel input;
	
	public NorthPanel() {
		setLayout(new GridLayout(3,1));
		setBackground(Color.BLACK);
		info = new JLabel("");
		input = new JLabel("");
		
		info.setFont(new Font("맑은 고딕",Font.PLAIN,15));
		info.setForeground(Color.WHITE);
		info.setHorizontalAlignment(SwingConstants.RIGHT);
		
		input.setFont(new Font("맑은 고딕",Font.PLAIN,30));
		input.setForeground(Color.WHITE);
		input.setHorizontalAlignment(SwingConstants.RIGHT);
		
		add(info);
		add(input);
		
	}
}
