package listas;

public class ElementoDE<T> {
    private T dato;
    private ElementoDE<T> anterior;
    private ElementoDE<T> siguiente;

    public ElementoDE(T dato) {
        this.dato = dato;
        anterior = null;
        siguiente = null;
    }

    public T getDato() {
        return dato;
    }

    public ElementoDE<T> getAnterior() {
        return anterior;
    }

    public void setAnterior(ElementoDE<T> anterior) {
        this.anterior = anterior;
    }

    public ElementoDE<T> getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(ElementoDE<T> siguiente) {
        this.siguiente = siguiente;
    }

}
