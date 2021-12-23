package app.myapp.calculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClearListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		NorthPanel.info.setText("");
		NorthPanel.input.setText("");
		
		while(!BraketListener.braketStack.empty()) {
			BraketListener.braketStack.pop();
		}
		
//		braketStack 확인 
//		for(int i=0; i<BraketListener.braketStack.size(); i++) {
//			System.out.print(BraketListener.braketStack.get(i));
//		}
//		System.out.println();
	}
	
}
