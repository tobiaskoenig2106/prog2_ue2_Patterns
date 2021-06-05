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
        String color = on.toString();
        if (color.contains("r=255,g=255,b=0")){
            color = "yellow";
        }else if(color.contains("r=255,g=0,b=0")){
            color = "red";
        } else {
            color = "green";
        }


        if(state.getColor().equals(color)){
            turnOn(true);
        }else{
            turnOn(false);
        }
    }


}
