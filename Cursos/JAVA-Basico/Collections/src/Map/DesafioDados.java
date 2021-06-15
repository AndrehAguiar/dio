package Map;

import java.util.Map;
import java.util.TreeMap;

public class DesafioDados {
    public static void main(String[] args) {

        Map<Integer, Integer> jogadaDados = new TreeMap<>();

        for (int i = 0; i < 100; i++) {
            int jogada = (int) (Math.random() * (7 - 1) + 1);
            if (jogadaDados.containsKey(jogada)) {
                jogadaDados.put(jogada, jogadaDados.get(jogada) + 1);
                continue;
            }
            jogadaDados.put(jogada, 1);
        }
        System.out.println(jogadaDados);
    }
}
