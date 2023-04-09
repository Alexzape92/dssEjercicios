package es.uca.dss.examples;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class KnightOfTheRoundTableTest {
    @Test
    public void knightTest(){
        //Configuration
        String KnightName = "Lancelot";
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
        Quest quest = (Quest) context.getBean("QuestType");
        KnightOfTheRoundTable knight = (KnightOfTheRoundTable) context.getBean("Knight", KnightName, quest);
        ((ClassPathXmlApplicationContext) context).close();

        //Processing
        QuestReward reward = knight.embarkOnQuest();

        //Verifying
        assertTrue(KnightName.equals(knight.getName()));
        assertTrue(reward.rewardDescription().equals("This is the Holy Grail!"));
    }
}
