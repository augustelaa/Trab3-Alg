

/**
 *
 * @author marcel
 */
public interface Lista {

    Lista concatena(Lista outra);

    String consulta(int p);

    Lista copia();

    Lista divide();

    boolean estaCheia();

    boolean estaVazia();

    int getTamanho();

    String imprime();

    void insere(String x);

    void insere(String x, int p);

    int localiza(String x);

    String retira(int p);
    
}
