package States;

import Models.ColourState;

public class RedColourState implements ColourState {
    @Override
    public void changeColour() {
        System.out.println("Switched colour to red");
    }
}
