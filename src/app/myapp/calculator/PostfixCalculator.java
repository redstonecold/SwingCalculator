package app.myapp.calculator;

import java.util.EmptyStackException;
import java.util.List;
import java.util.Stack;

public class PostfixCalculator implements FormulaJudge{
	Double a,b,z,result = 0.0;
	Stack<Double> stack = new Stack<Double>();

	PostfixCalculator(){
		
	}
	
	public Double postfixCalculate(List<String> postfixFormula) throws EmptyStackException {
		
//		formulaList 확인 
//		for(int i=0; i<postfixFormula.size(); i++) {
//			System.out.println(postfixFormula.get(i));
//		}
//		
//		System.out.println(postfixFormula.size());
		

		for(String x : postfixFormula) {
			if(!isOperand(x)) {
				b = stack.pop();
				a = stack.pop();
				z = postFix(a,b,x);
				stack.push(z);
			}
			else {
				stack.push(Double.parseDouble(x));
			}
		}
		result = stack.pop();
		return Math.round(result*1000000000)/1000000000.0;
	}
	

	private Double postFix(Double a, Double b, String op){
	try {			
			if(op.equals("+")) return a+b;
			else if(op.equals("-")) return a-b;
			else if(op.equals("×")) return a*b;
			else if (op.equals("÷")) return a/b;
			else return a%b;
		} catch(ArithmeticException e) {
			return 0.0;
		}
	}
	
}
