package app.myapp.calculator;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

public class BraketListener implements ActionListener,FormulaJudge {
	static Stack<String> braketStack = new Stack<String>();
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		NorthPanel.info.setText("");
		String inputText = NorthPanel.input.getText();
		int n = inputText.length();
		
		if(n <= 10) NorthPanel.input.setFont(new Font("맑은 고딕",Font.PLAIN,30));
		else NorthPanel.input.setFont(new Font("맑은 고딕",Font.PLAIN,25));
		
		try {
			String lastText = inputText.substring(n-1,n);
			
			if((lastText.equals(")")||isOperand(lastText))&&!braketStack.empty()) {
				NorthPanel.input.setText(inputText+")");
				braketStack.pop();
			}
			else {
				NorthPanel.input.setText(inputText+"(");
				braketStack.push("(");
			}
		} catch (StringIndexOutOfBoundsException e1) {
			NorthPanel.input.setText(inputText+"(");
			braketStack.push("(");
		}
		
//		braketStack 확인 
//		for(int i=0; i<braketStack.size(); i++) {
//			System.out.print(braketStack.get(i));
//		}
//		System.out.println();
	}
	

}
