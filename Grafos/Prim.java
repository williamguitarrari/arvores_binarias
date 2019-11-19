package Grafos;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Prim {
	
	  private boolean estavel[];
	    private boolean fixo[];
	    private int num_de_vertices;
	    private int matriz_adjacente[][];
	    private int chave[];
	    public static final int INFINITO = 999;
	    private int principal[];
	 
	    public Prim(int num_de_vertices)
	    {
	        this.num_de_vertices = num_de_vertices;
	        estavel = new boolean[num_de_vertices + 1];
	        fixo = new boolean[num_de_vertices + 1];
	        matriz_adjacente = new int[num_de_vertices + 1][num_de_vertices + 1];
	        chave = new int[num_de_vertices + 1];
	        principal = new int[num_de_vertices + 1];
	    }
	 
	    public int busca_tamanho_estavel(boolean estavel[])
	    {
	        int conta = 0;
	        for (int indice = 0; indice < estavel.length; indice++)
	        {
	            if (estavel[indice])
	            {
	                conta++;
	            }
	        }
	        return conta;
	    }
	 
	    public void ProjectoAlgorithm(int matriz_adjacente[][])
	    {
	        int vertice_avaliacao;
	        for (int origem = 1; origem <= num_de_vertices; origem++)
	        {
	            for (int destino = 1; destino <= num_de_vertices; destino++)
	            {
	                this.matriz_adjacente[origem][destino] = matriz_adjacente[origem][destino];
	            }
	        }
	 
	        for (int indice = 1; indice <= num_de_vertices; indice++)
	        {
	            chave[indice] = INFINITO;
	        }
	        chave[1] = 0;
	        estavel[1] = true;
	        principal[1] = 1;
	 
	        while (busca_tamanho_estavel(estavel) != 0)
	        {
	            vertice_avaliacao = busca_min_vert_estavel(estavel);
	            estavel[vertice_avaliacao] = false;
	            fixo[vertice_avaliacao] = true;
	            avaliacao_vizinhos(vertice_avaliacao);
	        }
	    } 
	 
	    private int busca_min_vert_estavel(boolean[] estavel2)
	    {
	        int min = Integer.MAX_VALUE;
	        int node = 0;
	        for (int vertice = 1; vertice <= num_de_vertices; vertice++)
	        {
	            if (estavel[vertice] == true && chave[vertice] < min)
	            {
	                node = vertice;
	                min = chave[vertice];
	            }
	        }
	        return node;
	    }
	 
	    public void avaliacao_vizinhos(int vertice_avaliacao)
	    {
	 
	        for (int vertice_destino = 1; vertice_destino <= num_de_vertices; vertice_destino++)
	        {
	            if (fixo[vertice_destino] == false)
	            {
	                if (matriz_adjacente[vertice_avaliacao][vertice_destino] != INFINITO)
	                {
	                    if (matriz_adjacente[vertice_avaliacao][vertice_destino] < chave[vertice_destino])
	                    {
	                        chave[vertice_destino] = matriz_adjacente[vertice_avaliacao][vertice_destino];
	                        principal[vertice_destino] = vertice_avaliacao;
	                    }
	                    estavel[vertice_destino] = true;
	                }
	            }
	        }
	    }
	 
	    public void printMST()
	    {
	        System.out.println("Origem  : Destino  = Peso");
	        for (int vertice = 2; vertice <= num_de_vertices; vertice++)
	        {
	            System.out.println(principal[vertice] + "\t:\t" + vertice +"\t=\t"+ matriz_adjacente[principal[vertice]][vertice]);
	        }
	    }
	 
	    public static void main(String[]args)
	    {
	        int matriz_adjacente[][];
	        int num_de_vertices;
	        Scanner scan = new Scanner(System.in);
	 
	        try
	        {
	            System.out.println("Quantos vertices tem o seu grafico");
	            num_de_vertices = scan.nextInt();
	            matriz_adjacente = new int[num_de_vertices + 1][num_de_vertices + 1];
	 
	            System.out.println("Digite a matrix adjacente do Grafo");
	            for (int i = 1; i <= num_de_vertices; i++)
	            {
	                for (int j = 1; j <= num_de_vertices; j++)
	                {
	                    matriz_adjacente[i][j] = scan.nextInt();
	                    if (i == j)
	                    {
	                        matriz_adjacente[i][j] = 0;
	                        continue;
	                    }
	                    if (matriz_adjacente[i][j] == 0)
	                    {
	                        matriz_adjacente[i][j] = INFINITO;
	                    }
	                }
	            }
	 
	            Projecto referencia = new Projecto(num_de_vertices);
	           referencia.ProjectoAlgorithm(matriz_adjacente);
	            referencia.printMST();
	 
	        } catch (InputMismatchException inputMismatch)
	        {
	            System.out.println("S� � permitido n�meros");
	        }
	        scan.close();
	    }

}
