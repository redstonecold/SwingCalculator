package app.myapp.calculator;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		NorthPanel.info.setText("");
		String inputText = NorthPanel.input.getText();
		
		int n = inputText.length();
		
		try {
			String lastText = inputText.substring(n-1,n);
			if(lastText.equals("(")) BraketListener.braketStack.pop();
			if(lastText.equals(")")) BraketListener.braketStack.push("(");
			
			NorthPanel.input.setText(inputText.substring(0,inputText.length()-1));
		
			if(n <= 10) NorthPanel.input.setFont(new Font("맑은 고딕",Font.PLAIN,30));
			else NorthPanel.input.setFont(new Font("맑은 고딕",Font.PLAIN,25));
		} catch (StringIndexOutOfBoundsException e1) {
			
		}
		
		
//		braketStack 확인 
//		for(int i=0; i<BraketListener.braketStack.size(); i++) {
//			System.out.print(BraketListener.braketStack.get(i));
//		}
//		System.out.println();
	}

}
