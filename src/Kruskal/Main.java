package Kruskal;

import javax.swing.JFrame;

public class Main {
	public static void main(String[] args) {
		
		int numeroPontos = 150;
		Kruskal k = new Kruskal(numeroPontos);	
		
		JFrame frame;
		frame=new ExibirCaminho(k.getMenorGrafo());
		frame.setVisible(true);
	}
	
}