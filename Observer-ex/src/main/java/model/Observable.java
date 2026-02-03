package model;

import view.Observer;

import java.util.ArrayList;
import java.util.List;

public abstract class Observable {

    private final List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer) {
        if (observer == null) return;
        synchronized (observers) {
            observers.add(observer);
        }
    }

    public void removeObserver(Observer observer) {
        synchronized (observers) {
            observers.remove(observer);
        }
    }

    public void notifyObservers() {
        List<Observer> snapshot;
        synchronized (observers) {
            snapshot = new ArrayList<>(observers);
        }

        for (Observer o : snapshot) {
            o.update();
        }
    }
}
