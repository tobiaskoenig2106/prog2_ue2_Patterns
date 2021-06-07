import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import trafficlight.ctrl.TrafficLightCtrl;
import trafficlight.gui.TrafficLight;
import trafficlight.states.State;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class MCP_Test {

    @DisplayName("2 TrafficLightCtrl müssen gleich sein")
    @Test
    void checkSingeltonPattern(){
        TrafficLightCtrl trafficLightCtrl = TrafficLightCtrl.getInstance();
        TrafficLightCtrl trafficLightCtrl_2 = TrafficLightCtrl.getInstance();
        assertEquals(trafficLightCtrl,trafficLightCtrl_2);
    }

    @DisplayName("Erstelltes TrafficLightCtrl darf nicht null sein")
    @Test
    void checkSingeltonPattern_2(){
        TrafficLightCtrl trafficLightCtrl = TrafficLightCtrl.getInstance();
        assertNotEquals(trafficLightCtrl,null);
    }

    @DisplayName("erster State bei neu erstelltem trafficLightCtrl")
    @Test
    void checkNextState0(){
        TrafficLightCtrl trafficLightCtrl = TrafficLightCtrl.getInstance();
        trafficLightCtrl.resetState();
        assertEquals(trafficLightCtrl.getCurrentState(),trafficLightCtrl.getGreenState());
    }

    @DisplayName("zweiter State bei neu erstelltem trafficLightCtrl")
    @Test
    void checkNextState1(){
        TrafficLightCtrl trafficLightCtrl = TrafficLightCtrl.getInstance();
        trafficLightCtrl.resetState();
        trafficLightCtrl.nextState();
        assertEquals(trafficLightCtrl.getCurrentState(),trafficLightCtrl.getYellowState());
    }

    @DisplayName("dritter State bei neu erstelltem trafficLightCtrl")
    @Test
    void checkNextState2(){
        TrafficLightCtrl trafficLightCtrl = TrafficLightCtrl.getInstance();
        trafficLightCtrl.resetState();
        trafficLightCtrl.nextState();
        trafficLightCtrl.nextState();
        assertEquals(trafficLightCtrl.getCurrentState(),trafficLightCtrl.getRedState());
    }

    @DisplayName("vierter State bei neu erstelltem trafficLightCtrl")
    @Test
    void checkNextState3(){
        TrafficLightCtrl trafficLightCtrl = TrafficLightCtrl.getInstance();
        trafficLightCtrl.resetState();
        trafficLightCtrl.nextState();
        trafficLightCtrl.nextState();
        trafficLightCtrl.nextState();
        assertEquals(trafficLightCtrl.getCurrentState(),trafficLightCtrl.getYellowState());
    }

    @DisplayName("fünfter State bei neu erstelltem trafficLightCtrl")
    @Test
    void checkNextState4(){
        TrafficLightCtrl trafficLightCtrl = TrafficLightCtrl.getInstance();
        trafficLightCtrl.resetState();
        trafficLightCtrl.nextState();
        trafficLightCtrl.nextState();
        trafficLightCtrl.nextState();
        trafficLightCtrl.nextState();
        assertEquals(trafficLightCtrl.getCurrentState(),trafficLightCtrl.getGreenState());
    }

    @DisplayName("20er State bei neu erstelltem trafficLightCtrl")
    @Test
    void checkNextState5(){
        TrafficLightCtrl trafficLightCtrl = TrafficLightCtrl.getInstance();
        trafficLightCtrl.resetState();
        for (int i = 0;i<20;i++){
            trafficLightCtrl.nextState();
        }
        assertEquals(trafficLightCtrl.getCurrentState(),trafficLightCtrl.getGreenState());
    }

    @DisplayName("sind die richtigen TrafficLights beim start an")
    @Test
    void checkTrafficLights(){
        TrafficLightCtrl ctrl = TrafficLightCtrl.getInstance();
        ctrl.resetState();
        TrafficLight green = new TrafficLight(Color.GREEN);
        TrafficLight yellow = new TrafficLight(Color.YELLOW);
        TrafficLight red = new TrafficLight(Color.RED);
        ctrl.addObserver(green);
        ctrl.addObserver(yellow);
        ctrl.addObserver(red);
        ctrl.update();
        assertEquals(true,green.isOn());
        assertEquals(false,yellow.isOn());
        assertEquals(false,red.isOn());
    }

    @DisplayName("sind die richtigen TrafficLights nach 1em wechsel an")
    @Test
    void checkTrafficLights1(){
        TrafficLightCtrl ctrl = TrafficLightCtrl.getInstance();
        ctrl.resetState();
        TrafficLight green = new TrafficLight(Color.GREEN);
        TrafficLight yellow = new TrafficLight(Color.YELLOW);
        TrafficLight red = new TrafficLight(Color.RED);
        ctrl.addObserver(green);
        ctrl.addObserver(yellow);
        ctrl.addObserver(red);
        ctrl.nextState();
        ctrl.update();
        assertEquals(false,green.isOn());
        assertEquals(true,yellow.isOn());
        assertEquals(false,red.isOn());
    }

    @DisplayName("sind die richtigen TrafficLights nach 2em wechsel an")
    @Test
    void checkTrafficLights2(){
        TrafficLightCtrl ctrl = TrafficLightCtrl.getInstance();
        ctrl.resetState();
        TrafficLight green = new TrafficLight(Color.GREEN);
        TrafficLight yellow = new TrafficLight(Color.YELLOW);
        TrafficLight red = new TrafficLight(Color.RED);
        ctrl.addObserver(green);
        ctrl.addObserver(yellow);
        ctrl.addObserver(red);
        ctrl.nextState();
        ctrl.nextState();
        ctrl.update();
        assertEquals(false,green.isOn());
        assertEquals(false,yellow.isOn());
        assertEquals(true,red.isOn());
    }


}