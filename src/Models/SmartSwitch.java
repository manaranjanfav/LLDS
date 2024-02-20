package Models;

import States.OffState;
import States.OnState;
import States.PowerSavingState;

public class SmartSwitch {

    private State currentState;

    protected State getCurrentInstance(){
        return currentState;
    }

    protected void setCurrentState(final State state){
        this.currentState = state;
    }

    public SmartSwitch(){

        this.currentState = OffState.getOffStateInstance();
    }

    public void switchOn(){
        System.out.println("Switching On");
        this.getCurrentInstance().On();
        if(this.getCurrentInstance() instanceof OnState){
            ((OnState) this.getCurrentInstance()).changeColour();
        }
        this.setCurrentState(OnState.getOnStateInstance());
    }

    public void switchOff(){
        System.out.println("Switching Off");
        this.getCurrentInstance().Off();
        this.setCurrentState(OffState.getOffStateInstance());
    }

    public void switchSave(){
        System.out.println("Switching to power saving");
        this.getCurrentInstance().savePower();
        this.setCurrentState(PowerSavingState.getPowerSavingStateInstance());
    }
}
