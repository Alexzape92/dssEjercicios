package es.uca.dss.examples;

public class KnightOfTheRoundTable 
{
    private String name;
    private Quest quest;

    public KnightOfTheRoundTable(String name, Quest quest) 
    {
        this.name = name;
        this.quest = quest;
    }

    public String getName(){
        return name;
    }

    public QuestReward embarkOnQuest() 
    {
        System.out.println("Knight " + name + " is embarking on a quest!");
        return quest.embark();
    }
}
