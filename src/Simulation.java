import java.util.ArrayList;
import java.util.Random;

public class Simulation {
    public static void main(String[] args) {
        int n = 100;
        ArrayList<Coin> coins = new ArrayList<>();
        for (int i = 0; i < n - 1; i++) {
            coins.add(new Coin('T', 'F'));
        }
        coins.add(new Coin('T', 'T'));
        long valid = 0;
        long all = 0;
        for (int i = 0; i < 10000000; i++) {
            int random = new Random().nextInt(100);
            long[] v = checkCoin(coins.get(random), valid, all);
            valid = v[0];
            all = v[1];
        }
        System.out.println((float) valid / all);

    }

    private static long[] checkCoin(Coin coin, long valid, long all) {
        int counter = 0;
        for (int i = 0; i < 5; i++) {
            int random = new Random().nextInt(2);
            if (coin.chars[random] == 'T') {
                counter++;
            }
        }
        if (counter == 5) {
            int random = new Random().nextInt(2);
            if (coin.chars[random] == 'T') {
                valid++;
            }
            all++;
        }

        return new long[]{valid, all};
    }
}
