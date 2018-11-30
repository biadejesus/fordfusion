package algoritmo;

import java.util.HashMap;
import java.util.Map;

public class Vertice {

    // Atributos do vértice: indice, predecessor, distância, lista de adjacência.
    int predecessor;
    int distancia;
    boolean visitado;
    int indice;
    HashMap<Integer,Integer> arestasAdj;

    // Construtor
    public Vertice(int predecessor, int distancia, int indice) {
        this.arestasAdj = new HashMap<>();
        this.predecessor = predecessor;
        this.distancia = distancia;
        this.indice = indice;
    }

    // Função para adicionar uma aresta a um vértice.
    public void addAdj(int destino, int capacidade) {
        this.arestasAdj.put(destino, capacidade);
    }
    // Rip getters and setters :\
}