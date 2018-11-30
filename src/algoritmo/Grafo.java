package algoritmo;
import java.util.*;

public class Grafo implements Cloneable{
    ArrayList< Vertice> vertices;
    static int indice = 0;

    // Construtor
    public Grafo() {
        this.vertices = new ArrayList<>();
    }
    
    // Método para clon o grafo 
    @Override
    public Grafo clone() throws CloneNotSupportedException {
        return (Grafo) super.clone();
    }


    // Função para adicionar um vértice ao grafo
    public void addVertice() {
        this.vertices.add(new Vertice(-1, Integer.MAX_VALUE, this.indice));
        this.indice++;
    }

    public void inicializaGrafo() {
     
        }
  
}
