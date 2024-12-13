package me.massoudi;

import me.massoudi.model.Transaction;
import me.massoudi.model.TransactionType;
import me.massoudi.security.SecurityContext;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static java.util.Set.of;

public class Main{
    public static void main(String[] args) {
        HashSet<String> roles = new HashSet<>(Arrays.asList("ADMIN"));
        SecurityContext.setUser("JohnDoe", roles);

        Agent agent = new Agent("Agent 1");
        AgentContainer.getInstance().addAgent(agent);

        Agent agent2 = new Agent("Agent 2");
        AgentContainer.getInstance().addAgent(agent2);

        Transaction transaction = new Transaction.Builder()
                .id("1")
                .amount(100)
                .transactionType(TransactionType.PURCHASE)
                .build();

        agent.addTransaction(transaction);


        System.out.println("Transaction la plus élevée : " + agent.getHighestTransaction());

    }
}
