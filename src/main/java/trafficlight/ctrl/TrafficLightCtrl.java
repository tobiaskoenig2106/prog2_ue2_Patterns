package trafficlight.ctrl;

import trafficlight.Observer.Observer;
import trafficlight.Observer.Subject;
import trafficlight.gui.TrafficLightGui;
import trafficlight.states.State;

import java.util.ArrayList;
import java.util.List;

public class TrafficLightCtrl extends Subject {

    private State greenState;

    private State redState;

    private State yellowState;

    private State currentState;

    private State previousState;

    private final TrafficLightGui gui;

    private boolean doRun = true;

    private List<Observer> observerList = new ArrayList<>();

    public TrafficLightCtrl() {
        super();
        initStates();
        gui = new TrafficLightGui(this);
        gui.setVisible(true);
        //TODO useful to update the current state
        update();
    }

    private void initStates() {
        greenState = new State() {
            @Override
            public State getNextState() {
                previousState = currentState;
                //TODO useful to update the current state and the old one
                currentState = yellowState;
                update();
                return yellowState;
            }
            @Override
            public String getColor() {
                return "green";
            }
        };

        redState = new State() {
            @Override
            public State getNextState() {
                previousState = currentState;
                //TODO useful to update the current state and the old one
                currentState = yellowState;
                update();
                return yellowState;
            }
            @Override
            public String getColor() {
                return "red";
            }
        };

        yellowState = new State() {
            @Override
            public State getNextState() {
                if (previousState.equals(greenState)) {
                    previousState = currentState;
                    //TODO useful to update the current state and the old one
                    currentState = redState;
                    update();
                    return redState;
                }else {
                    previousState = currentState;
                    //TODO useful to update the current state and the old one
                    currentState = greenState;
                    update();
                    return greenState;
                }
            }
            @Override
            public String getColor() {
                return "yellow";
            }
        };
        currentState = greenState;
        previousState = yellowState;
    }

    public State getGreenState() {
        return greenState;
    }

    public State getRedState() {
        return redState;
    }

    public State getYellowState() {
        return yellowState;
    }

    public void run()  {
        int intervall = 1500;
        while (doRun) {
            try {
                Thread.sleep(intervall);
                nextState();
            } catch (InterruptedException e) {
                gui.showErrorMessage(e);
            }
        }
        System.out.println("Stopped");
        System.exit(0);
    }

    public void nextState() {
        currentState = currentState.getNextState();
    }

    public void stop() {
        doRun = false;
    }


    @Override
    public <T extends Observer> void addObserver(T t) {
        observerList.add(t);
    }

    @Override
    public <T extends Observer> void removeObserver(T t) {
        observerList.remove(t);
    }

    @Override
    public void notifyObserver() {
        for (Observer observer:observerList){
            observer.update(currentState);
        }
    }

    @Override
    public void update() {
        notifyObserver();
    }
}