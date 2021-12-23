package app.myapp.calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostfixConverter implements FormulaJudge {
	List<String> postfixFomula = new ArrayList<String>();
	Stack<String> convertStack = new Stack<String>();
	
	PostfixConverter(){
	
	}
	
	public List postfixConvert(List<String> formulaList) {
		convertStack.push("$");
		for(int i=0; i<formulaList.size(); i++) {
			String temp = formulaList.get(i);
			if (isOperand(temp)) postfixFomula.add(temp);
			else if(temp.equals("(")) convertStack.push(temp);
			else if (temp.equals(")")) {
				while (!convertStack.peek().equals("(")) {
					postfixFomula.add(convertStack.pop());
				}
				convertStack.pop();
			}
			else {
				while(getPrecedence(temp) < getPrecedence(convertStack.peek())) {
					postfixFomula.add(convertStack.pop());
				}
				convertStack.push(temp);
			}
		}
		while(!convertStack.empty()) {
			if(convertStack.peek().equals("$")) {
				convertStack.pop();
			}
			else postfixFomula.add(convertStack.pop());
		}
		
//		postfixFomula 확인 
//		for(int i=0; i<postfixFomula.size(); i++) {
//			System.out.print(postfixFomula.get(i));
//		}
//		System.out.println();
		
		return postfixFomula;
	}
	
	
	private int getPrecedence(String op) {
		if(op.equals("$") || op.equals("(")) return 0;
		else if(op.equals("+") || op.equals("-")) return 1;
		else return 2;
	}
}
