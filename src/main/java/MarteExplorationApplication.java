import java.util.*;
import br.com.elo7.MarteExploration.direcao.*;
import br.com.elo7.MarteExploration.direcao.posicao.*;


public class MarteExplorationApplication {

	public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        ArrayList<Direcao> naves = new ArrayList<Direcao>();


        System.out.print("Digite as dimensões do terreno (separadas por espaço): \n");
        int height = s.nextInt();
        int width = s.nextInt();
        
        
        do{
            
            System.out.print("Digite a posição inicial da nave e a direção em que está (N, E, S, W):\n");
            int x = s.nextInt();
            int y = s.nextInt();
            char direction = s.nextLine().charAt(1);

            System.out.print("Digite os comandos que a nave deverá realizar:\n");
            String commands = s.nextLine();

            Direcao direcao = new Direcao(x, y, height, width, commands, direction);

            naves.add(direcao);


        }while (s.hasNextLine());



        Posicao.verificaErros(naves);

        s.close();


    }

}
