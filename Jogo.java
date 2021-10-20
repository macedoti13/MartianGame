public class Jogo {

    CircularDoubleLinkedList c = new CircularDoubleLinkedList();

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

    public void jogo(int n) {
        int firstn = n;
        c.count = 0;
        c.addFirstElement(n);
        System.out.println(jogada(n, firstn));
    }
    
}
