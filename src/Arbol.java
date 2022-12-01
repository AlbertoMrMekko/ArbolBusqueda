public class Arbol {

    private NodoArbol raiz;

    public Arbol() {
        raiz = null;
    }

    // Muestra los elementos del arbol binario en orden central ---------------
    public void mostrar() {
        this.mostrar(raiz, "  ");
    }

    private void mostrar(NodoArbol nodo, String espacios) {
        if (nodo != null) {
            this.mostrar(nodo.getIzquierdo(), espacios + "    ");
            System.out.print(espacios);
            nodo.getDato().mostrar();
            this.mostrar(nodo.getDerecho(), espacios + "    ");
        }
    }

    // Inserta un elemento con una cierta clave -------------------------------
    public void insertar(Alumno dato) {
        raiz = this.insertar(raiz, dato);
    }

    private NodoArbol insertar(NodoArbol nodo, Alumno dato) {
        if (nodo != null) {
            if (nodo.getDato().getMatricula() < dato.getMatricula()) {
                nodo.setDerecho(this.insertar(nodo.getDerecho(), dato));
            } else if (nodo.getDato().getMatricula() > dato.getMatricula()) {
                nodo.setIzquierdo(this.insertar(nodo.getIzquierdo(), dato));
            } else {
                System.out.println("la clave ya existe");
            }
        } else {
            nodo = new NodoArbol(dato);
        }
        return nodo;
    }

    // ------------------------------------------------------------------------
    // TODO 3.2: Devuelve el numero de nodos del arbol de forma RECURSIVA
    public int getNumElementos() {
        return getNumElementoss(raiz);
    }

    private int getNumElementoss(NodoArbol nodo) {
        if(nodo != null)
            return(1 + getNumElementoss(nodo.getIzquierdo()) + getNumElementoss(nodo.getDerecho()));
        else
            return 0;
    }

    // ------------------------------------------------------------------------
    // TODO 3.3: Devuelve el numero de nodos del arbol con clave
    // menor a una clave dada de forma RECURSIVA

    public int getNumMenores(int clave) {
        return getNumMenores(clave, raiz);
    }

    private int getNumMenores(int clave, NodoArbol nodo) {
        if(nodo != null)
            if(nodo.getDato().getMatricula() < clave)
                return(1 + getNumMenores(clave, nodo.getIzquierdo()) + getNumMenores(clave, nodo.getDerecho()));
            else
                return(getNumMenores(clave, nodo.getIzquierdo()));
        else
            return 0;
    }

    // ------------------------------------------------------------------------
    // TODO 3.4: Devuelve el elemento con la menor clave de forma RECURSIVA
    public Alumno getMenorElemento() {
        return getMenorElemento(raiz);
    }

    private Alumno getMenorElemento(NodoArbol nodo) {
        if(nodo != null)
            if(nodo.getIzquierdo() == null)
                return nodo.getDato();
            else
                return getMenorElemento(nodo.getIzquierdo());
        else
            return null;
    }

    // ------------------------------------------------------------------------
    // TODO 3.5: Devuelve el elemento con la mayor clave y menor que una clave
    // dada de forma RECURSIVA
    public Alumno getMenorElementoClave(int clave) {
        return getMenorElementoClave(clave, raiz);
    }

    private Alumno getMenorElementoClave(int clave, NodoArbol nodo) {
        if(nodo != null)
        {
            if(nodo.getDato().getMatricula() < clave)
            {
                Alumno p;
                p = getMenorElementoClave(clave, nodo.getDerecho());
                if(p == null)
                    return nodo.getDato();
                else
                    return p;
            }
            else
                return getMenorElementoClave(clave, nodo.getIzquierdo());
        }
        else
            return null;
    }
}