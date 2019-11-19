package Kruskal;

import java.util.List;

public class Aresta implements Comparable<Object> {
	  private float peso;
	  private Vertice u, v;

	  public Aresta(Vertice u, Vertice v) {
	    this.u = u;
	    this.v = v;
	  }

	  public Aresta(Vertice u, Vertice v, float peso) {
	    this(u, v);
	    this.peso = peso;
	  }

	  public float getPeso() { 
		  return this.peso;
	  }
	  
	  public void setPeso(float peso) {
		  this.peso = peso;
	  }
	  
	  public Vertice getU() {
		  return this.u; 
	  }
	  
	  public Vertice getV() {
		  return this.v;
	  }

	  public int compareTo(Object o) {
	    Aresta arestaAux = (Aresta) o;

	    if (this.getPeso() < arestaAux.getPeso())
	      return -1;
	    else if (this.getPeso() > arestaAux.getPeso())
	      return 1;
	    else
	      return 0;

	  }

	  public static float sum(List<Aresta> listaArestas) {
	    float somatorioPesos = 0;
	    
	    for (Aresta aresta : listaArestas) {
	    	somatorioPesos += aresta.getPeso();
	    }
	    
	    return somatorioPesos;
	  }
	  
}