package Kruskal;

public class Vertice {
	
	 private int x;
	  private int y;
	  private No no;

	  public Vertice(int x, int y) {
	    this.x = x;
	    this.y = y;
	  }

	  public int getX(){
		  return this.x;
	  }
	  
	  public int getY(){
		  return this.y;
	  }
	  
	  public void setNo(No no){
		  this.no = no; 
	  }
	  
	  public No getNo(){
		  return this.no;
	  }

	  public static float distanciaEntrePontos(Vertice a, Vertice b) {
	    return (float) (Math.pow((b.y - a.y), 2) + Math.pow((b.x - a.x), 2));
	  }

}
