package me.massoudi.utils;

import me.massoudi.model.Transaction;

public interface Observable {
    void subscribe(Observer observer);

    void unsubscribe(Observer observer);

    void notifyObservers(Transaction transaction);
}
