package me.massoudi;

import me.massoudi.model.Transaction;

import java.util.List;

public interface Observable {
    void subscribe(Observer observer);

    void unsubscribe(Observer observer);

    void notifyObservers(Transaction transaction);
}
