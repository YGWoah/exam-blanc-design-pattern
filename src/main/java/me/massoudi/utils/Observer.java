package me.massoudi.utils;

import me.massoudi.model.Transaction;

public interface Observer {
    void update(String agentName, Transaction transaction);
}
