import java.util.Scanner;

public class app {
    public static void main(String[] args) {
        Jogo j = new Jogo();
        Scanner input = new Scanner(System.in);
        boolean running = true;
        while (running) {
            System.out.print("Digite o número inicial do jogo do marciano. Se quiser parar, digite '-1': ");
            int comando = input.nextInt();
            System.out.println();
            if (comando == -1) {
                input.close();
                break;
            }
            j.jogo(comando);
            System.out.println();
        }
    }
}

