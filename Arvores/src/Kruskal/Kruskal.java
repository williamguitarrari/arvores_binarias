package Kruskal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Kruskal {

	private static Random r;
	private static float menorCaminho = 0;
	private ArrayList<Aresta> grafoGerado;
	ArrayList<Aresta> menorGrafo;
	private static ArrayList<Vertice> listaVertices;
	private static ArrayList<Aresta> listaArestas;
	private ConjuntoDisjunto conjuntoDisjunto;
	private int sementeAleatoria;
	private int numeroPontos;
	private int maxArestas;

	public Kruskal(int numeroPontos) {
		// TODO Auto-generated constructor stub
		this.numeroPontos = numeroPontos;
		this.maxArestas = (this.numeroPontos * (this.numeroPontos - 1)) / 2;
		this.sementeAleatoria = 10;

		listaVertices = new ArrayList<Vertice>(this.numeroPontos);
		listaArestas = new ArrayList<Aresta>(this.maxArestas);
		menorGrafo = new ArrayList<Aresta>();
		r = new Random();

		geradorVerticesAleatorios(sementeAleatoria, numeroPontos, maxArestas);
	}

	/*******************************************************************/
	public float geradorVerticesAleatorios(int seed, int numeroPontos, int maxArestas) {

		// Popula lista com pontos aleatórios
		for (int i = 0; i < numeroPontos; i++) {
			listaVertices.add(new Vertice(r.nextInt(Integer.MAX_VALUE) % 20, r.nextInt(Integer.MAX_VALUE) % 13));
		}
//	    listaVertices.add(new Vertice(1,1));
//	    listaVertices.add(new Vertice(2,3));
//	    listaVertices.add(new Vertice(1,2));
//	    listaVertices.add(new Vertice(3,3));

		// Matriz de Adjacência
		for (int i = 0; i < numeroPontos; i++) {
			for (int j = 0; j < numeroPontos; j++) {
				if (i != j) {
					Vertice u = listaVertices.get(i);
					Vertice v = listaVertices.get(j);

					Aresta arestaAux = new Aresta(u, v, Vertice.distanciaEntrePontos(u, v));
					listaArestas.add(arestaAux);
				}
			}
		}

		conjuntoDisjunto = new ConjuntoDisjunto(listaVertices);

		grafoGerado = new ArrayList<Aresta>();

		// Ordena arestas crescentemente
		Collections.sort(listaArestas);

		// Kruskal
		for (Aresta e : listaArestas) {
			Vertice u = e.getU();
			Vertice v = e.getV();
			if (conjuntoDisjunto.procurar(u.getNo()) != conjuntoDisjunto.procurar(v.getNo())) { // u e v não sao do
																								// mesmo conjunto
				grafoGerado.add(e);
				conjuntoDisjunto.unir(u.getNo(), v.getNo());
			}
		}

		int cont = 1;
		for (Aresta e : grafoGerado) {
			System.out.print("Aresta: " + cont++);
			System.out.print(" - U" + "(" + e.getU().getX() + "," + e.getU().getY() + ")");
			System.out.println(" - V" + "(" + e.getV().getX() + "," + e.getV().getY() + ")");

			menorCaminho += Math.sqrt(e.getPeso());
		}

		System.out.println("Tamanho da arvore: " + grafoGerado.size());

		// REMOVER ARESTAS COINCIDENTES

		for (Aresta aresta : grafoGerado) {
			if (aresta.getU().getX() == aresta.getV().getX() && aresta.getU().getY() == aresta.getV().getY()) {
			} else {
				menorGrafo.add(aresta);
			}

		}

		System.out.println("Total da �rvore minima: " + menorGrafo.size());
		System.out.println("\t Tamanho do percurso " + menorCaminho);
		return menorCaminho;
	}

	public ArrayList<Aresta> getMenorGrafo() {
		return this.grafoGerado;
	}

}
