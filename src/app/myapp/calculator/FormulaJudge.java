package app.myapp.calculator;

public interface FormulaJudge {
	
	default Boolean isOperand(String op) {
		if (op.equals("+") || op.equals("-") || op.equals("×") || op.equals("÷") || op.equals("%") || op.equals("(") || op.equals(")")) return false;
		return true;
	}

}
