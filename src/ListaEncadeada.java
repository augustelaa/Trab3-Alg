/**
 *
 * @author marcel
 */
public class ListaEncadeada<T> implements Lista<T>{
    private ElementoLista<T> primeiro;
    private ElementoLista<T> ultimo;
    private int tamanho = 0;

    @Override
    public boolean estaCheia() {
        return false;
    }

    @Override
    public boolean estaVazia() {
        return (primeiro == null);
    }

    @Override
    public int getTamanho() {
        return this.tamanho;
    }

    @Override
    public String imprime() {
        ElementoLista atual = primeiro;
        String retorno = "[";
        while (atual != null){
            retorno += atual.getInfo()+"; ";
            atual = atual.getProximo();
        }
        try {
            // para retirar a última vírgula e espaço
            retorno = retorno.substring(0,retorno.length()-2);
            return retorno+"]";
        } catch (StringIndexOutOfBoundsException strExc){
            return "[]";
        }        
    }
    
    @Override
    public Lista<T> concatena(Lista<T> outra) {
        ListaEncadeada<T> nova = new ListaEncadeada();
        for (int i=0; i < this.getTamanho(); i++){
            nova.insere(this.consulta(i));
        }
        for (int i=0; i < outra.getTamanho(); i++){
            nova.insere(outra.consulta(i));
        }
        return nova;
    }

    @Override
    public T consulta(int p) {
        if (p>=0 && p < this.getTamanho()){  // p tem valor válido        
            return this.descobre(p).getInfo();
        }
        return null;
    }

    @Override
    public Lista<T> copia() {
        ListaEncadeada<T> nova = new ListaEncadeada();
        ElementoLista<T> atual = this.primeiro;
        while (atual != null){
            nova.insere(atual.getInfo());
            atual = atual.getProximo();
        }
        return nova;
    }

    @Override
    public Lista<T> divide() {
        if (this.estaVazia()){
            return null;
        }
        ListaEncadeada<T> nova = new ListaEncadeada();
        int original = this.getTamanho();
        int meio =  original / 2;
        
        for (int i = meio; i < original; i++){
            nova.insere(this.retira(meio));
        }        
        return nova;
    }



    @Override
    public void insere(T x) {
        ElementoLista<T> elem = new ElementoLista();
        elem.setInfo(x);
        
        if (this.estaVazia()){
            primeiro = elem;
        }
        else {
            ultimo.setProximo(elem);
        }
        ultimo = elem;
        this.tamanho++;
    }

    @Override
    public void insere(T x, int p) {
        if (p>=0 && p <= this.getTamanho()){  // p tem valor válido
            if (p == this.getTamanho()){ // última posição
                this.insere(x);
            }
            else {
                ElementoLista<T> elem = new ElementoLista();
                elem.setInfo(x);
                if (p == 0){ // primeira posição
                    elem.setProximo(primeiro);
                    primeiro = elem;
                }
                else {  // posição intermediária
                    ElementoLista<T> anterior = this.descobre(p-1);
                    elem.setProximo(anterior.getProximo());
                    anterior.setProximo(elem);
                }
                this.tamanho++;
            }
        }
    }

    private ElementoLista<T> descobre(int posicao){
        if (posicao == this.getTamanho()-1){  // buscando o último
            return ultimo;
        }
        
        ElementoLista<T> atual = primeiro;
        int contador = 0;
        while (contador != posicao){
            atual = atual.getProximo();
            contador++;
        }
        return atual;
    }
    
    @Override
    public int localiza(T x) {
        ElementoLista<T> atual = primeiro;
        int contador = 0;
        while (atual != null){
            if (atual.getInfo().equals(x)){
                return contador;
            }
            atual = atual.getProximo();
            contador++;
        }
        return -1;
    }

    @Override
    public T retira(int p) {
        T retorno = null;
        if (p>=0 && p < this.getTamanho()){  // p tem valor válido
            if (p==0){  // primeira posição
                retorno = primeiro.getInfo();
                primeiro = primeiro.getProximo();
                this.tamanho--;
                if (this.estaVazia()){  // caso houvesse um único elemento na lista
                    this.ultimo = null;
                }
            }
            else {
                ElementoLista<T> anterior = this.descobre(p-1);
                if (p == this.getTamanho()-1){ // último elemento
                    retorno = ultimo.getInfo();
                    anterior.setProximo(null);
                    ultimo = anterior;
                }
                else {  // posição intermediária
                    ElementoLista<T> elem = anterior.getProximo();
                    retorno = elem.getInfo();
                    anterior.setProximo(elem.getProximo());
                }
                this.tamanho--;
            }
        }
        return retorno;
    }
    public int ultimoIndiceDe(T x){
        ElementoLista<T> atual = primeiro;
        int contador = 0;
        int ultimoIndice = -1;
        while (atual != null){
            if (atual.getInfo().equals(x)){
               ultimoIndice = contador;
            }
            atual = atual.getProximo();
            contador++;
        }
        return ultimoIndice;
    }
public String imprimeInverso(){
         ElementoLista atual = null;
        String retorno = "[";
        for(int i = (this.tamanho - 1); i>=0;i--){
            atual =this.descobre(i);
            retorno += atual.getInfo()+"; ";
        }
        try {
            // para retirar a última vírgula e espaço
            retorno = retorno.substring(0,retorno.length()-2);
            return retorno+"]";
        } catch (StringIndexOutOfBoundsException strExc){
            return "[]";
        }    
}
}
