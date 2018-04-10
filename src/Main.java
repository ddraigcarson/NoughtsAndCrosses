import builder.BuilderBot;
import player.Player;
import teacher.TeacherBot;
import util.Print;
import util.Stats;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println("START");

        int populationSize = 40;
        double survivalRatio = 0.2;
        int generations = 10000;

        BuilderBot builderBot = new BuilderBot();
        TeacherBot teacherBot = new TeacherBot();

        List<Player> bots = builderBot.createGeneration(populationSize);

        for (int i=0 ; i<generations ; i++) {
            teacherBot.test(bots);
            //bots = builderBot.createNextGeneration(bots, populationSize, survivalRatio);
            Print.getInstance().printRoundPercentages(i);
            Stats.getInstance().reset();
        }

        System.out.println("\nEND");
    }

}
