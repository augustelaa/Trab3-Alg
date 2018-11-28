
public class MapaDispersao<K,T> {
	private ListaEncadeada<T>[] tabela;
	
	public MapaDispersao (int quantidade) {
		tabela = (ListaEncadeada<T>[]) new Object[quantidade];
	}

	public int calcularHash(K chave) {
		int hashCode = chave.hashCode();
		return hashCode;
	}
	
	public boolean inserir(K chave, T valor) {
		int indice = calcularHash(chave);
		return false;
	}
	
	public T remover(K chave) {
		return null;
	}
	
	public T buscar(K chave) {
		return null;
	}
	
	public int quantosElementos() {
		return 0;
	}
}