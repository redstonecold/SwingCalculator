package app.myapp.calculator;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Calculator extends JFrame {
	Container c;
	JPanel pal;
	
	Calculator(){
		c = getContentPane();
		setTitle("Swing Calculator");
		setSize(350,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //이 코드 없을 시 창은 닫히지만 살아있는 상태가 됨
		
		c.setLayout(new BorderLayout(5,5));
		c.setBackground(Color.BLACK);
		
		NorthPanel NP = new NorthPanel();
		c.add(NP, BorderLayout.EAST);
		CenterPanel CP = new CenterPanel();
		c.add(CP, BorderLayout.SOUTH);
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Calculator();
	}

}
