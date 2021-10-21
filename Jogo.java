public class Jogo {

    CircularDoubleLinkedList c = new CircularDoubleLinkedList();

    /**
     * Metodo que chama uma jogada do jogo marciano. Recebe um parametro n, que se for impar, adciona ele mesmo subtraindo 1 na frente e atrás, 
     * muda seu proprio valor para ficar igual aos vizinhos, move o pointer para a esquerda ou direita, dependendo do valor original do primeiro
     * pointer, e por fim, chama a si mesmo com o valor no novo pointer.
     * @param n Valor do pointer da jogada
     * @param firstn Valor do pointer original. Pointer que iniciou o jogo.
     * @return o numero de elementos no circulo ao final da jogada
     */
    public int jogada(int n, int firstn) {
        if (n <= 1) {
            System.out.print("Elementos no circulo no fim do jogo: ");
            return c.count;
        }
        else {
            if (n%2 == 0) {
                if (firstn <= 20) {
                    c.printCirculo();
                }
                c.addBehind(n/2);
                c.addInFront(n/2);
                c.changePointerNodeValue(n/2);
                c.movePointer(n);
                if (firstn <= 20) {
                    c.printCirculo();
                }
                jogada(c.valorPointer(), firstn);
                return c.count;
            }
            else {
                if (firstn <= 20) {
                    c.printCirculo();
                }
                c.addBehind(n-1);
                c.addInFront(n-1);
                c.changePointerNodeValue(n-1);
                c.movePointer(n);
                if (firstn <= 20) {
                    c.printCirculo();
                }
                jogada(c.valorPointer(), firstn);
                return c.count;
            }
        }
    }

    /**
     * Chama o jogo, adcionando o primeiro elemento, salvando o valor original do primeiro pointer e chamando o metodo recursivo da jogada.
     * @param n Valor do primeiro elemento/ valor original do pointer.
     */
    public void jogo(int n) {
        int firstn = n;
        c.count = 0;
        c.addFirstElement(n);
        System.out.println(jogada(n, firstn));
    }
    
}
