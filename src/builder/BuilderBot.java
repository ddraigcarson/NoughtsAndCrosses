package builder;

import player.Player;
import player.babybot.BabyBot;
import util.Maths;
import util.Print;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BuilderBot {

    public List<Player> createGeneration(int limit) {
        List<Player> bots = new ArrayList<Player>();
        for (int i=0 ; i<limit ; i++) {
            bots.add(new BabyBot(i));
        }
        return bots;
    }

    public List<Player> createNextGeneration(List<Player> currentGeneration, int populationLimit, double survivalRatio) {

        List<Player> culledGeneration = cullGeneration(currentGeneration, survivalRatio);
        List<Player> nextGeneration = regrowPopulation(culledGeneration, populationLimit);

        return nextGeneration;
    }

    private List<Player> cullGeneration(List<Player> generation, double survivalRatio) {
        int survivingBotsLimit = ratioToNumber(generation.size(), survivalRatio);
        Collections.sort(generation, BabyBot.scoreComparator());
        List<Player> culledBots = generation.subList(0, survivingBotsLimit);
        return culledBots;
    }

    private List<Player> regrowPopulation(List<Player> culledGeneration, int populationlimit) {
        List<Player> nextGeneration = new ArrayList<>();
        nextGeneration.addAll(culledGeneration);

        while (nextGeneration.size() < populationlimit) {
            //Player parent = culledGeneration.get(Maths.randomInt(0, culledGeneration.size()));
            Player newBot = new BabyBot(0);
            //newBot.addToMemory(parent.getMemory());
            nextGeneration.add(newBot);
        }

        for (Player bot : nextGeneration) {
            bot.setPlayerScore(0);
        }

        return nextGeneration;
    }

    private int ratioToNumber(int generationSize, double ratio) {
        int number = (int)(generationSize*ratio);
        return number;
    }

}
