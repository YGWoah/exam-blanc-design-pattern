package me.massoudi;

import me.massoudi.model.Transaction;
import me.massoudi.notificationStrategy.HistoryStrategy;
import me.massoudi.notificationStrategy.NotificationStrategy;
import me.massoudi.notificationStrategy.ScoringStrategy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Agent implements Observable, Observer {
    private final String name;
    private final List<Transaction> transactions;
    private final List<Observer> observers;
    private NotificationStrategy strategy;
    private double balance;
    private final List<Transaction> notificationHistory;

    public Agent(String name) {
        this.name = name;
        this.transactions = new ArrayList<>();
        this.observers = new ArrayList<>();
        this.notificationHistory = new ArrayList<>();
        this.balance = 0;
//        this.subscribe(this);
        this.setStrategy(new HistoryStrategy());
    }

    public String getName() {
        return name;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
        notifyObservers(transaction);
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public List<Transaction> getNotificationHistory() {
        return notificationHistory;
    }

    public void setStrategy(NotificationStrategy strategy) {
        this.strategy = strategy;
    }

    public void displayAgentInfo() {
        System.out.println("Nom de l'agent : " + name);
        if (transactions.isEmpty()) {
            System.out.println("Aucune transaction disponible.");
        } else {
            System.out.println("Transactions :");
            for (Transaction transaction : transactions) {
                System.out.println(transaction);
            }
        }
    }

    public Transaction getHighestTransaction() {
        return transactions.stream()
                .max(Comparator.comparingDouble(Transaction::getAmount))
                .orElse(null);
    }

    @Override
    public void subscribe(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void unsubscribe(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(Transaction transaction) {
        for (Observer observer : observers) {
            observer.update(this.name, transaction);
        }
    }

    @Override
    public void update(String agentName, Transaction transaction) {
        if (this.name.equals(agentName)) {
            System.out.println("Agent " + name + " traite sa propre transaction : " + transaction);

            NotificationStrategy previousStrategy = this.strategy;

            this.strategy = new ScoringStrategy();
            this.strategy.handleNotification(agentName, transaction, this);

            this.strategy = previousStrategy;

        } else {
            System.out.println("Agent " + name + " a reçu une notification de " + agentName + " pour la transaction : " + transaction);
            strategy.handleNotification(agentName, transaction, this);
        }
    }


    @Override
    public String toString() {
        return "Agent{" + "name='" + name + '\'' + ", transactions=" + transactions + '}';
    }


}
