package app.myapp.calculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.List;
import java.util.Stack;

public class CalcListener implements ActionListener, FormulaJudge {
	List<String> formulaList;
	List<String> postfixFormula;
	Double result;

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		try {
			formulaList = new ArrayList<String>();
			
			String inputFormula = NorthPanel.input.getText().trim();
			
	//		inputFormula 확인
	//		System.out.println(inputFormula);
			
			if(inputFormula.equals("")) NorthPanel.info.setText("수식을 입력해주세요.");
			stringToList(inputFormula);
			
//			formulaList 확인 
//			for(int i=0; i<formulaList.size(); i++) {
//				System.out.println(formulaList.get(i));
//			}
//			System.out.println();
			
			PostfixConverter conveter = new PostfixConverter();
			postfixFormula = conveter.postfixConvert(formulaList);
			
			PostfixCalculator calculator = new PostfixCalculator();
			result = calculator.postfixCalculate(postfixFormula);
			
			NorthPanel.input.setText(Double.toString(result));
		} catch (EmptyStackException | NumberFormatException e1) {
			e1.printStackTrace();
			NorthPanel.info.setText("올바른 수식이 아닙니다.");
		}
	}
	
	private void stringToList(String inputFormula) {
		int pre = 0;
		int j;
		
		for(int i=0; i<inputFormula.length(); i++) {
			String formulaChar = String.valueOf(inputFormula.charAt(i));
			if(i+1 > inputFormula.length()) { //마지막 자리일 때 
				formulaList.add(inputFormula.substring(pre));
				break;
			}
			else if(formulaChar.equals("(")) {
				formulaList.add(formulaChar);
				pre=i+1;
				
				if(!isOperand(String.valueOf(inputFormula.charAt(pre))) && inputFormula.charAt(pre)!='(') {
					for(j=pre; j<inputFormula.length(); j++) {
						if(inputFormula.charAt(j) == ')') break;
					}
					formulaList.add(inputFormula.substring(pre,j));
					formulaList.add(inputFormula.substring(j,j+1));
					i=j;
					pre=j+1;
				}
				continue;
			}
			else if (formulaChar.equals(")")) {
				if(inputFormula.charAt(i-1) == ')') {
					formulaList.add(inputFormula.substring(i, i+1));
				}
				else {
					formulaList.add(inputFormula.substring(pre, i));
					formulaList.add(inputFormula.substring(i, i+1));
				}
				pre = i+1;
			}
			else if (!isOperand(formulaChar)) {
				formulaList.add(inputFormula.substring(pre, i+1));
				pre = i+1;
				continue;
			}
		}
		
	}
	
}
