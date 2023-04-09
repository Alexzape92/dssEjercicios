package es.uca.dss.examples;

public class HolyGrailQuest implements Quest {
    public QuestReward embark() {
        return new HolyGrail(); //We don't dependency injection on the holy grail, because the holy grail quest is the only one that can give it
    }
}
