/**
 * Representa a cualquier objeto que quiera recibir informacion
 * sobre lo que ocurre dentro del combate.
 *
 * En esta practica, los espectadores son los observadores. Cada uno
 * recibe los mismos acontecimientos de la pelea, pero puede agregar
 * informacion propia, como su identificador y el personaje al que
 * decidio apoyar.
 */
public interface Observador {

    /**
     * Recibe un evento generado por el sujeto.
     *
     * El observador decide que hacer con la informacion recibida.
     * En el caso de los espectadores, el evento se utiliza para
     * escribir una nueva entrada en su bitacora.
     *
     * @param evento texto que describe algo que ocurrio durante el combate
     */
    void actualizar(String evento);
}