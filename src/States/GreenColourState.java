package States;

import Models.ColourState;

public class GreenColourState implements ColourState {
    @Override
    public void changeColour() {
        System.out.println("Switched to Green colour");
    }
}
