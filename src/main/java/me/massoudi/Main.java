package me.massoudi;

import me.massoudi.ascpects.Log;
import me.massoudi.model.Transaction;
import me.massoudi.model.TransactionType;
import me.massoudi.notificationStrategy.HistoryStrategy;
import me.massoudi.notificationStrategy.ScoringStrategy;

import java.util.Date;
import java.time.LocalDate;

public class Main {

    @Log
    public static void test() {
        System.out.println("test");
    }

    public static void main(String[] args) {

       test();

        AgentContainer container = AgentContainer.getInstance();



        Agent agent1 = new Agent("Agent1");
        Agent agent2 = new Agent("Agent2");
        container.addAgent(agent1);
        container.addAgent(agent2);

        Transaction transaction1 = new Transaction.Builder()
                .id("1")
                .date(new Date())
                .amount(100)
                .transactionType(TransactionType.PURCHASE)
                .build();

        agent1.addTransaction(transaction1);

    }

}
