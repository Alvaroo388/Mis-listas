package listas;

public class ListaSE<T extends Comparable<T>> implements Lista<T> {
    protected ElementoSE<T> primero;
    protected int size;

    public ListaSE() {
        this.primero = null;
        this.size = 0;
    }

    @Override
    public void add(T dato) {
        ElementoSE<T> nuevo = new ElementoSE<>(dato);
        if (primero != null) {
            nuevo.setSiguiente(primero);
            primero = nuevo;
        }else{
            primero = nuevo;
        }
        size++;
    }

    @Override
    public T get(T dato) {
        ElementoSE<T> actual = primero;
        while (actual != null){

            if (actual.getDato().compareTo(dato) == 0){
                return actual.getDato();
            }
            actual = actual.getSiguiente();
        }
        return null;
    }

    @Override
    public T del(T dato) {
        ElementoSE<T> actual = primero;
        ElementoSE<T> anterior = null;
        while (actual != null){

            if (actual.getDato().compareTo(dato) == 0){
                if (anterior == null){
                    primero = actual.getSiguiente();
                }else {
                    anterior.setSiguiente(actual.getSiguiente());
                }
                size--;
                return actual.getDato();
            }
            anterior = actual;
            actual = actual.getSiguiente();
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        return primero == null;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public MiIterador<T> getIterador() {
        return new IteradorSE<>(primero);
    }

    public boolean existeDato(T dato){
        return get(dato) != null;
    }
    public void invertir(){
        ElementoSE<T> anterior = null;
        ElementoSE<T> actual = primero;
        ElementoSE<T> siguiente;

        while(actual != null){
            siguiente = actual.getSiguiente();
            actual.setSiguiente(anterior);
            anterior = actual;
            actual = siguiente;
        }
        primero = anterior;
    }


}
