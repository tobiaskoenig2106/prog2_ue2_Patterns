package trafficlight.gui;


import trafficlight.Observer.Observer;
import trafficlight.states.State;

import java.awt.*;

public class TrafficLight extends Light implements Observer {

    TrafficLight(Color color) {
        super(color);
    }

    public void turnOn(boolean a) {
        isOn = a;
        repaint();
    }

    public boolean isOn() {
        return isOn;
    }

    //TODO implement a part of the pattern here
    @Override
    public void update(State state) {
        if(state.getColor().equals(on.toString())){
            turnOn(true);
        }else{
            isOn = false;
        }
    }


}
