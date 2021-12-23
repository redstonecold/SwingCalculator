package app.myapp.calculator;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class NumberListener implements ActionListener {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		NorthPanel.info.setText("");
		
		JButton b = (JButton) e.getSource();
		String oldText = NorthPanel.input.getText();
		String text = b.getText();
		String newText = oldText + text;
		int n = newText.length();
		
		if(n <= 10) NorthPanel.input.setFont(new Font("맑은 고딕",Font.PLAIN,30));
		else NorthPanel.input.setFont(new Font("맑은 고딕",Font.PLAIN,25));
		if(n<22) {
			NorthPanel.input.setText(newText);
		}
		else {
			NorthPanel.info.setText("입력 가능한 범위를 초과하였습니다");
		}
	}
}
