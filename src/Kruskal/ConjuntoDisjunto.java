package Kruskal;

import java.util.ArrayList;
import java.util.List;

public class ConjuntoDisjunto {

	ArrayList<No> listaNos;

	public int procurar(No no) {
		No noAux = no;

		// Busca pai
		while (noAux.pai != null)
			noAux = noAux.pai;

		return noAux.indice;
	}

	public void unir(No u, No v) {
		int indiceU = procurar(u);
		int indiceV = procurar(v);

		// Nos são do mesmo cunjunto
		if (indiceU == indiceV)
			return;

		// Busca os nós pais na lista de nós
		No noA = this.listaNos.get(indiceU);
		No noB = this.listaNos.get(indiceV);

		// Concatena o menor grafo no maior grafo
		if (noA.grau < noB.grau) {
			noA.pai = noB;
		} else if (noA.grau > noB.grau) {
			noB.pai = noA;
		} else {
			noB.pai = noA;
			noA.grau++;
		}
	}

	// Adiciona cada vertice do conujntoa lista de Nos
	public void constroiConjuntos(List<Vertice> vertices) {
		for (Vertice vertice : vertices)
			adicionaAoConjundo(vertice);
	}

	// Adiciona cada vertice do conujntoa lista de Nos
	public void adicionaAoConjundo(Vertice vertice) {
		No no = new No(0, listaNos.size(), null);
		vertice.setNo(no);
		this.listaNos.add(no);
	}

	public ConjuntoDisjunto(List<Vertice> vertices) {
		this.listaNos = new ArrayList<No>(vertices.size());
		constroiConjuntos(vertices);
	}

}