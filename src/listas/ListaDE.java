package listas;

public class ListaDE<T extends Comparable<T>> implements Lista<T>{
    protected ElementoDE<T> primero;
    protected ElementoDE<T> ultimo;
    protected int size;

    public ListaDE() {
        this.primero = null;
        this.ultimo = null;
        this.size = 0;
    }


    @Override
    public void add(T dato) {
        ElementoDE<T> nuevo = new ElementoDE<>(dato);
        if (primero == null){
            primero = nuevo;
            ultimo = nuevo;
        }else{
            primero.setAnterior(nuevo);
            nuevo.setSiguiente(primero);
            primero = nuevo;

        }
        size++;

    }

    @Override
    public T get(T dato) {
        ElementoDE<T> actual = primero;
        while(actual != null){
            if(actual.getDato().compareTo(dato) == 0){
                return actual.getDato();
            }
            actual = actual.getSiguiente();
        }
        return null;
    }

    @Override
    public T del(T dato) {
        ElementoDE<T> actual = primero;
        while (actual != null){
            if (actual.getDato().compareTo(dato) == 0){
                if (actual.getAnterior() == null){
                    primero = actual.getSiguiente();
                    if (primero != null){
                        primero.setAnterior(null);
                    }else{
                        ultimo = null;
                    }
                } else if (actual.getSiguiente() == null){
                    ultimo = actual.getAnterior();
                    ultimo.setSiguiente(null);
                } else {
                    actual.getAnterior().setSiguiente(actual.getSiguiente());
                    actual.getSiguiente().setAnterior(actual.getAnterior());
                }
                size--;
                return actual.getDato();
            }
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
        return new IteradorDE<>(primero);
    }

    public boolean existeDato(T dato){
        return get(dato) != null;
    }
}
