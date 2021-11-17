import java.util.Scanner;

// ________________________________________________
// | Numero Inicial   |  Elemento no fim do jogo  |  
// |------------------|---------------------------| 
// |    100000        |             1825          | 
// |------------------|---------------------------|                  
// |    200000        |             3961          | 
// |------------------|---------------------------|                  
// |    300000        |             6401          | 
// |------------------|---------------------------|
// |    400000        |             6841          |  
// |------------------|---------------------------|                      
// |    500000        |             7773          |
// |------------------|---------------------------|                      
// |   1000000        |             8221          |
// |------------------|---------------------------|
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