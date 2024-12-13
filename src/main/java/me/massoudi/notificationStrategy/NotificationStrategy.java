package me.massoudi.notificationStrategy;

import me.massoudi.Agent;
import me.massoudi.model.Transaction;

public interface NotificationStrategy {
    void handleNotification(String agentName, Transaction transaction, Agent agent);
}
