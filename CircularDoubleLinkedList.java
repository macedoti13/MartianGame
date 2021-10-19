public class CircularDoubleLinkedList {
    private Node header;
    private Node trailer;
    public Node pointer;
    public int count = 0;

    private class Node {
        public Integer element;
        public Node next;
        public Node prev;
        public Node(Integer e) {
            element = e;
            next = null;
            prev = null;
        }
    }

    /**
     * Método utilizado para criar o objeto.
     */
    public CircularDoubleLinkedList() {
        header = new Node(null);
        trailer = new Node(null);
        pointer = new Node(null);
        count = 0;
    }

    /**
     * Utilizado para adcionar o primeiro elemento no círculo. Esse elemento aponta para si mesmo, no campo next e prev. 
     * O node header aponta para ele no campo next e o node trailer aponta para ele no campo prev. 
     * @param element Valor do elemento que vai ser colocado no node.
     */
    public void addFirstElement(Integer element) {
        Node n = new Node(element);
        n.next = n;
        n.prev = n;
        header.next = n;
        trailer.prev = n;
        pointer.next = n;
        count++;
    }

    /**
     * Metodo para adcionar um elemento na frente do elemento do pointer
     * @param element elemtento que se quer adicionado
     */
    public void addInFront(Integer element) {
        Node n = new Node(element);
        Node aux = getNodeIndex(indexOfPointer());
        n.next = aux.next;
        aux.next.prev = n;
        aux.next = n;
        n.prev = aux;
        if (aux.prev == aux) {
            aux.prev = n;
        }
        if (trailer.prev == aux) {
            trailer.prev = n;
        }
        count++;
    }

    /**
     * Metodo para adcionar um elemento atras do elemento do pointer
     * @param element elemento que vai ser adcionado
     */
    public void addBehind(Integer element) {
        Node n = new Node(element);
        Node aux = getNodeIndex(indexOfPointer());
        n.next = aux;
        aux.prev.next = n;
        n.prev = aux.prev;
        aux.prev = n;
        if (aux.next == aux) {
            aux.next = n;
        }
        if (header.next == aux) {
            header.next = n;
        }
        count++;
    }

    /**
     * Metodo para mudar o valor de elemento do node apontado pelo pointer
     * @param element novo elemento do node
     */
    public void changePointerNodeValue(Integer element) {
        Node n = pointer.next;
        n.element = element;
    }

    /**
     * Utilizado para retornar o valor de um node.
     * @param index index do node do qual se quer saber o valor
     * @return o elemento do node
     * @throws IndexOutOfBoundsException caso o index seja invalido
     */
    public Integer get(int index) throws IndexOutOfBoundsException {
        if ((index < 0) || (index >= count)) {
            throw new IndexOutOfBoundsException();
        }
        Node aux = getNodeIndex(index);
        return aux.element;
    }

    /**
     * Utilizado para retornar um node.
     * @param index index do node desejado
     * @return o node
     */
    private Node getNodeIndex(int index) {
        Node aux = null;

        if (index <= count/2) { // se esta na primeira metade da lista, percorre do inicio para o meio
            aux = header.next;
            for (int i=0; i<index; i++) {
                aux = aux.next;
            }
        }
        else { // Se esta na segunda metade da lista, percorre do fim para o meio
            aux = trailer.prev;
            for (int i=count-1; i>index; i--) {
                aux = aux.prev;
            }
        }

        return aux;
    }

    /**
     * Utilizado para obter o index de um elemento especifico
     * @param element elemento no qual se quer o index
     * @return o index do elemento
     */
    public int indexOf(Integer element) {
        Node aux = header.next;
        for (int i=0; i<count; i++) {
            if (aux.element.equals(element)) {
                return i;
            }
            aux = aux.next;
        }
        return -1;
    }

    /**
     * Metodo para obter o index do pointer 
     * @return index do pointer
     */
    public int indexOfPointer() { 
        for (int i=0; i<count; i++) {
            if (getNodeIndex(i) == pointer.next) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Metodo para mover o pointer entre os elementos do circulo
     * @param number quantidade de elementos que se quer mover o pointer
     * @param direction direção na qual se quer mover o pointer
     */
    public void movePointer(int number, String direction) { 
        if (direction == "right") {
            for (int i=0; i<number; i++) {
                pointer.next = pointer.next.next;
            }
        }
        else if (direction == "left") {
            for (int i=0; i<number; i++) {
                pointer.next = pointer.next.prev;
            }
        }
    }
    
    /**
     * Metodo para obter o valor do elemento do node apontado pelo pointer 
     * @return valor do pointer
     */
    public Integer valorPointer() {
        return get(indexOfPointer());
    }

    /**
     * Metodo para printar todos os elementos do circulo e o valor do pointer 
     */
    public void printCirculo() {
        for (int i=0; i<count; i++) {
            System.out.print(get(i) + " ");
        }
        System.out.println("      Valor do pointer: " + get(indexOfPointer()));
        System.out.println();
    }
}