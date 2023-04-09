package es.uca.dss.examples;

public class HolyGrail implements QuestReward {
    public String rewardDescription() {
        return "This is the Holy Grail!";
    }

    public int rewardValue() {
        return 1000000000;
    }
}
