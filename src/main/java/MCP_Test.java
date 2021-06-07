import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import trafficlight.ctrl.TrafficLightCtrl;
import trafficlight.states.State;

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
    void checkNextState(){
        TrafficLightCtrl trafficLightCtrl = TrafficLightCtrl.getInstance();
        trafficLightCtrl.resetState();
        trafficLightCtrl.nextState();
        assertEquals(trafficLightCtrl.getCurrentState(),trafficLightCtrl.getGreenState());
    }

}