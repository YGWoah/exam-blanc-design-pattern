package me.massoudi.notificationStrategy;

import me.massoudi.Agent;
import me.massoudi.model.Transaction;
import me.massoudi.model.TransactionType;

public class ScoringStrategy implements NotificationStrategy {
    @Override
    public void handleNotification(String agentName, Transaction transaction, Agent agent) {
        double currentBalance = agent.getBalance();
        if (transaction.getType() == TransactionType.SALE) {
            currentBalance += transaction.getAmount();
        } else if (transaction.getType() == TransactionType.PURCHASE) {
            currentBalance -= transaction.getAmount();
        }
        agent.setBalance(currentBalance);
        System.out.println(agent.getName() + " a mis à jour son solde : " + currentBalance);
    }
}
