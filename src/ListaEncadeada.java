
/**
 *
 * @author Augusto Henrique da Concei��o
 * @param <T>
 */
public class ListaEncadeada<T> implements Lista{
    private ItemLista primeiro;
    private ItemLista ultimo;
    private int qtdeElementos = 0;

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
        return this.qtdeElementos;
    }

    @Override
    public String imprime() {
        ItemLista atual = primeiro;
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
    public Lista concatena(Lista outra) {
        ListaEncadeada nova = new ListaEncadeada();
        for (int i=0; i < this.getTamanho(); i++){
            nova.insere(this.consulta(i));
        }
        for (int i=0; i < outra.getTamanho(); i++){
            nova.insere(outra.consulta(i));
        }
        return nova;
    }

    @Override
    public String consulta(int p) {
        if (p>=0 && p < this.getTamanho()){  // p tem valor válido        
            return this.descobre(p).getInfo();
        }
        return null;
    }

    @Override
    public Lista copia() {
        ListaEncadeada nova = new ListaEncadeada();
        ItemLista atual = this.primeiro;
        while (atual != null){
            nova.insere(atual.getInfo());
            atual = atual.getProximo();
        }
        return nova;
    }

    @Override
    public Lista divide() {
        if (this.estaVazia()){
            return null;
        }
        ListaEncadeada nova = new ListaEncadeada();
        int meio =  (this.getTamanho() / 2);
        if (meio==0){
            return nova;  // só há um elemento na lista original, portanto não dá para dividir
        }
        ItemLista itemAntMeio = this.descobre(meio-1);
        nova.setPrimeiro(itemAntMeio.getProximo());
        itemAntMeio.setProximo(null);
        nova.setUltimo(this.ultimo);
        nova.setTamanho(this.getTamanho() - meio);
        this.ultimo = itemAntMeio;
        this.qtdeElementos = meio;
      
        return nova;
    }

    private void setPrimeiro(ItemLista i){
        this.primeiro = i;
    }
    private void setUltimo(ItemLista i){
        this.ultimo = i;
    }
    private void setTamanho(int tam){
        this.qtdeElementos = tam;
    }


    @Override
    public void insere(String x) {
        ItemLista elem = new ItemLista();
        elem.setInfo(x);
        
        if (this.estaVazia()){
            primeiro = elem;
        }
        else {
            ultimo.setProximo(elem);
        }
        ultimo = elem;
        this.qtdeElementos++;
    }

    @Override
    public void insere(String x, int p) {
        if (p>=0 && p <= this.getTamanho()){  // p tem valor válido
            if (p == this.getTamanho()){ // última posição
                this.insere(x);
            }
            else {
                ItemLista elem = new ItemLista();
                elem.setInfo(x);
                if (p == 0){ // primeira posição
                    elem.setProximo(primeiro);
                    primeiro = elem;
                }
                else {  // posição intermediária
                    ItemLista anterior = this.descobre(p-1);
                    elem.setProximo(anterior.getProximo());
                    anterior.setProximo(elem);
                }
                this.qtdeElementos++;
            }
        }
    }

    private ItemLista descobre(int posicao){
        if (posicao == this.getTamanho()-1){  // buscando o último
            return ultimo;
        }
        
        ItemLista atual = primeiro;
        int contador = 0;
        while (contador != posicao){
            atual = atual.getProximo();
            contador++;
        }
        return atual;
    }
    
    @Override
    public int localiza(String x) {
        ItemLista atual = primeiro;
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
    public String retira(int p) {
        String retorno = null;
        if (p>=0 && p < this.getTamanho()){  // p tem valor válido
            if (p==0){  // primeira posição
                retorno = primeiro.getInfo();
                primeiro = primeiro.getProximo();
                this.qtdeElementos--;
                if (this.estaVazia()){  // caso houvesse um único elemento na lista
                    this.ultimo = null;
                }
            }
            else {
                ItemLista anterior = this.descobre(p-1);
                if (p == this.getTamanho()-1){ // último elemento
                    retorno = ultimo.getInfo();
                    anterior.setProximo(null);
                    ultimo = anterior;
                }
                else {  // posição intermediária
                    ItemLista elem = anterior.getProximo();
                    retorno = elem.getInfo();
                    anterior.setProximo(elem.getProximo());
                }
                this.qtdeElementos--;
            }
        }
        return retorno;
    }
    
    // Concordo que a solu��o n�o � bonita, mas ela funciona! 
 	public String imprimeReverso() {
 		
 		
 		ItemLista atual = primeiro;
        String lista = "";
        while (atual != null){
            lista += atual.getInfo()+" ;";
            atual = atual.getProximo();
        }
        try {
            lista = lista.substring(0,lista.length()-1);
        } catch (StringIndexOutOfBoundsException strExc){
            return "[]";
        }
 		
 		String retorno = "[";
 		// -2 pq o primeiro � espa�o
 		for (int i = (lista.length()-2); i >= 0 ; i--) {
 			retorno += lista.charAt(i);
 		}
 		retorno += "]";
 		return retorno;
 	}
 	
 	public int ultimoIndiceDe(T x) {
 		ItemLista elem = primeiro;
 		int index = -1;
 		for (int i = 0; i < this.getTamanho(); i++) {
 			if (elem.getInfo().equals(x)) {
 				index = i;
 			}
 			elem = elem.getProximo();
 		}
 		return index;
 	}
    
}
