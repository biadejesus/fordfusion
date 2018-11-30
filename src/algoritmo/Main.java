package algoritmo;

import java.util.*;

public class Main {

    public static void main(String[] args) throws CloneNotSupportedException {
        Scanner scan = new Scanner(System.in);
        // Variáveis para criação do grafo
        int x, y, w, a, b, nroVertices, nroArestas;
        Vertice k;
        Grafo grafo = new Grafo();
        nroVertices = scan.nextInt();
        nroArestas = scan.nextInt();
        // Adicionar vértices 
        a = scan.nextInt();
        b = scan.nextInt();
        for (int i = 0; i < nroVertices; i++) {
            grafo.addVertice();
        }
        // Adicionar arestas (origem x, destino y, peso w) 
        for (int i = 0; i < nroArestas; i++) {
            x = scan.nextInt();
            y = scan.nextInt();
            w = scan.nextInt();
            k = grafo.vertices.get(x);
            k.addAdj(y, w);
        }
        FordFulkerson fk = new FordFulkerson();
        // a = origem do fluxo, b = destino do fluxo
        fk.fluxoMaximo(grafo, a, b);
    }
}
