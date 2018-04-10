package util;

import java.util.concurrent.ThreadLocalRandom;

public class Maths {

    public static int randomInt(int min, int max){
        return ThreadLocalRandom.current().nextInt(min, max);
    }

}
