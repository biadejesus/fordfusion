package algoritmo;

import java.util.*;

public class FordFulkerson {

    // Busca em largura
    public boolean bfs(Grafo grafoR, int origem, int destino) {

        Set<Integer> chaves;
        Vertice aux;
        // Todos os vértices iniciam como não visitados.
        for (Vertice v : grafoR.vertices) {
            v.visitado = false;
            // Conjunto de chaves do hash de arestas pra percorrer elas

        }
        // Criar fila para a busca em largura
        ArrayList<Vertice> queue;
        queue = new ArrayList();
        queue.add(grafoR.vertices.get(origem));
        grafoR.vertices.get(origem).visitado = true;
        while (!queue.isEmpty()) {
            // Seleciona e remove um vértice da fila (vértice aux)
            aux = queue.remove(0);
            for (int v = 0; v < grafoR.vertices.size(); v++) {
                // procura pelos vértices adjacentes de aux (a aresta precisa ter capacidade maior que 0) e se eles não foram visitados, são marcados como visitados e seu predecessor é o aux. 
                if (aux.arestasAdj.containsKey(v)) {
                    if (grafoR.vertices.get(v).visitado == false && aux.arestasAdj.get(v) > 0) {
                        queue.add(grafoR.vertices.get(v));
                        grafoR.vertices.get(v).predecessor = aux.indice;
                        grafoR.vertices.get(v).visitado = true;
                    }
                }
            }
        }
        // retorna se o destino foi encontrado na busca em largura (se ainda há caminho de origem a destino no grafo residual)
        return (grafoR.vertices.get(destino).visitado == true);
    }

    public void fluxoMaximo(Grafo grafo, int origem, int destino) throws CloneNotSupportedException {
        // O fluxo inicial que passa da origem ao destino é 0
        int fluxoMaximo = 0, fluxoCaminho, verticeV, verticeU, aux1, aux2;

        // Cria um grafo residual
        Grafo grafoR = grafo.clone();
        Set<Integer> chaves;
        Vertice aux;

        for (Vertice v : grafoR.vertices) {
            // Conjunto de chaves do hash de arestas pra percorrer elas
            chaves = v.arestasAdj.keySet();
            for (int y : chaves) {
                aux = grafoR.vertices.get(y);
                // Para uma aresta (x, y), se não existe a aresta (y, x), ela é criada.
                if (!aux.arestasAdj.containsKey(v.indice)) {
                    aux.addAdj(v.indice, 0);
                }
            }
        }
        // Enquanto BFS encontrar o destino
        while (bfs(grafoR, origem, destino) == true) {
            fluxoCaminho = Integer.MAX_VALUE;
            verticeV = destino;
            // A partir do destino, recupera o caminho encontrado e pega a menor aresta deste caminho (fluxoCaminho)
            while (verticeV != origem) {
                verticeU = grafoR.vertices.get(verticeV).predecessor;
                if (fluxoCaminho > grafoR.vertices.get(verticeU).arestasAdj.get(verticeV)) {
                    fluxoCaminho = grafoR.vertices.get(verticeU).arestasAdj.get(verticeV);

                }
                verticeV = grafoR.vertices.get(verticeV).predecessor;
            }
            verticeV = destino;
            // A partir do destino, para as arestas (u, v) pertencente o caminho, adiciona o fluxoCaminho em (v,u) e diminui em (u, v)
            while (verticeV != origem) {
                verticeU = grafoR.vertices.get(verticeV).predecessor;
                aux1 = grafoR.vertices.get(verticeU).arestasAdj.get(verticeV);
                aux2 = grafoR.vertices.get(verticeV).arestasAdj.get(verticeU);
                grafoR.vertices.get(verticeU).arestasAdj.replace(verticeV, aux1 - fluxoCaminho);
                grafoR.vertices.get(verticeV).arestasAdj.replace(verticeU, aux2 + fluxoCaminho);
                verticeV = grafoR.vertices.get(verticeV).predecessor;
            }
            
            // Adiciona o fluxo do caminho ao fluxo máximo
            fluxoMaximo += fluxoCaminho;
        }
        System.out.println("O valor do fluxo máximo é de " + fluxoMaximo);
    }
}
