public class app {
    public static void main(String[] args){
        CircularDoubleLinkedList c = new CircularDoubleLinkedList();
        c.addFirstElement(5);
        c.printCirculo();
        c.addBehind(5-1);
        c.addInFront(5-1);
        c.changePointerNodeValue(5-1);
        c.printCirculo();
        c.movePointer(5, "left");
        c.addInFront(4/2);
        c.addBehind(4/2);
        c.changePointerNodeValue(4/2);
        c.printCirculo();
        c.movePointer(5, "right");
        c.addBehind(2/2);
        c.addInFront(2/2);
        c.changePointerNodeValue(2/2);
        c.printCirculo();
        c.movePointer(5, "right");
        c.addBehind(2/2);
        c.addInFront(2/2);
        c.changePointerNodeValue(2/2);
        c.printCirculo();
        c.movePointer(5, "right");
        c.addBehind(2/2);
        c.addInFront(2/2);
        c.changePointerNodeValue(2/2);
        c.printCirculo();
        c.movePointer(5, "right");
        c.changePointerNodeValue(10);
        c.printCirculo();

    }
}
