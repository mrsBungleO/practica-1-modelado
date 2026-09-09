/**
 * Clase genérica que representa la tupla de dos elementos
 * Permite agrupar dos objetos de distintos tipos en una sola estructura
 * @param <A> El tipo de dato del primer elemento.
 * @param <B> El tipo de dato del segundo elemento.
 */
public class Tupla<A,B>{

    /** Primer elemento guardado en la tupla. */
    private A elemento1;

    /** Segundo elemento guardado en la tupla. */
    private B elemento2;

    /**
     * Construye una nueva tupla con los dos elementos especificados
     * @param elemento1 El valor o instancia del primer elemento
     * @param elemento2 El valor o instancia del segundo elemento
     */
    public Tupla(A elemento1, B elemento2){
        this.elemento1=elemento1;
        this.elemento2=elemento2;
    }

    /**
     * Obtiene el primer elemento de la tupla
     * @return El primer elemento
     */
    public A getElemento1(){
        return this.elemento1;
    }

    /**
     * Obtiene el segundo elemento de la tupla
     * @return El segundo elemento
     */
    public B getElemento2(){
        return this.elemento2;
    }

    /**
     * Reemplaza el primer elemento de la tupla
     * @param nuevoElemento El nuevo valor a asignar en la primera posicion
     */
    public void setElemento1(A nuevoElemento){
        this.elemento1=nuevoElemento;
    }

    /**
     * Reemplaza el segundo elemento de la tupla
     * @param nuevoElemento El nuevo valor a asignar en la segunda posicion
     */
    public void setElemento2(B nuevoElemento){
        this.elemento2=nuevoElemento;
    }

}