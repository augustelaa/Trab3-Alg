/**
 *
 * @author marcel
 */
class ElementoLista<T> {
    private T info;
    private ElementoLista proximo;

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public ElementoLista<T> getProximo() {
        return proximo;
    }

    public void setProximo(ElementoLista<T> proximo) {
        this.proximo = proximo;
    }
    
    
}
