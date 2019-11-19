package percurso;

import percurso.ArvoreBin.ModoRL;

public class Main {
	
	 public static void main(String[] args) {
	        System.out.println("-----------------------------------------");
	        ArvoreBin arvore = new ArvoreBin("A");
	         
	        arvore.AddNo("A","B", ModoRL.esquerda);
	        arvore.AddNo("B", "D", ModoRL.esquerda);
	        arvore.AddNo("A", "C", ModoRL.direita);
	        arvore.AddNo("C", "E", ModoRL.esquerda);
	        arvore.AddNo("E", "G", ModoRL.direita);
	        arvore.AddNo("C", "F", ModoRL.direita);
	        arvore.AddNo("F", "H", ModoRL.esquerda);
	        arvore.AddNo("F", "I", ModoRL.direita);
	         
	        System.out.println("PreOrdem (RED): " + arvore.PreOrdem());
	        System.out.println("InOrdem (ERD): " + arvore.InOrdem());
	        System.out.println("PosOrdem (EDR): " + arvore.PosOrdem());
	        System.out.println("-----------------------------------------");
	         
	        arvore.Clear("F");
	         
	        arvore.AddNo("F","B", ModoRL.esquerda);
	        arvore.AddNo("B","A", ModoRL.esquerda);
	        arvore.AddNo("B","D", ModoRL.direita);
	        arvore.AddNo("D","C", ModoRL.esquerda);
	        arvore.AddNo("D","E", ModoRL.direita);
	        arvore.AddNo("F","G", ModoRL.direita);
	        arvore.AddNo("G","I", ModoRL.direita);
	        arvore.AddNo("I","H", ModoRL.esquerda);
	         
	        System.out.println("PreOrdem (RED): " + arvore.PreOrdem());
	        System.out.println("InOrdem (ERD): " + arvore.InOrdem());
	        System.out.println("PosOrdem (EDR): " + arvore.PosOrdem());
	        System.out.println("-----------------------------------------");
	         
	        arvore.Clear("A");
	         
	        arvore.AddNo("A","B", ModoRL.esquerda);
	        arvore.AddNo("B","C", ModoRL.esquerda);
	        arvore.AddNo("C","E", ModoRL.esquerda);
	        arvore.AddNo("E","I", ModoRL.direita);
	        arvore.AddNo("C","F", ModoRL.direita);
	        arvore.AddNo("F","J", ModoRL.direita);
	        arvore.AddNo("B","D", ModoRL.direita);
	        arvore.AddNo("D","G", ModoRL.esquerda);
	        arvore.AddNo("D","H", ModoRL.direita);
	        arvore.AddNo("H","K", ModoRL.esquerda);
	        arvore.AddNo("H","L", ModoRL.direita);
	         
	        System.out.println("PreOrdem (RED): " + arvore.PreOrdem());
	        System.out.println("InOrdem (ERD): " + arvore.InOrdem());
	        System.out.println("PosOrdem (EDR): " + arvore.PosOrdem());
	        System.out.println("-----------------------------------------");
	    }
	 
	}
/*
 * 
 * Sa�da ----------------------------------------- PreOrdem (RED):
 * A,B,D,C,E,G,F,H,I InOrdem (ERD): D,B,A,E,G,C,H,F,I PosOrdem (EDR):
 * D,B,G,E,H,I,F,C,A ----------------------------------------- PreOrdem (RED):
 * F,B,A,D,C,E,G,I,H InOrdem (ERD): A,B,C,D,E,F,G,H,I PosOrdem (EDR):
 * A,C,E,D,B,H,I,G,F ----------------------------------------- PreOrdem (RED):
 * A,B,C,E,I,F,J,D,G,H,K,L InOrdem (ERD): E,I,C,F,J,B,G,D,K,H,L,A PosOrdem
 * (EDR): I,E,J,F,C,G,K,L,H,D,B,A -----------------------------------------
 */

