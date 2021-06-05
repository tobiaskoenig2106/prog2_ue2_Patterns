package trafficlight.Observer;

import trafficlight.states.State;

public abstract class Subject {
    public abstract <T extends Observer> void addObserver(T t);

    public abstract <T extends Observer> void removeObserver(T t);

    public abstract void notifyObserver();

    public abstract void update(State state);
}
