public class Jogo {
    CircularDoubleLinkedList c = new CircularDoubleLinkedList();
    public int jogada(int n) {
        if (n==1) {
            return c.count;
        }
        else {
            if (n%2 == 0) {
                c.addBehind(n/2);
                c.addInFront(n/2);
                c.changePointerNodeValue(n/2);
                c.movePointer(n);
                jogada(c.valorPointer());
                return c.count;
            }
            else {
                c.addBehind(n-1);
                c.addInFront(n-1);
                c.changePointerNodeValue(n-1);
                c.movePointer(n);
                jogada(c.valorPointer());
                return c.count;
            }
        }
    }

    public void jogo(int n) {
        c.addFirstElement(n);
        System.out.println(jogada(n));
    }
    
}
