package States;

import Models.State;

import java.io.Serializable;

public class PowerSavingState implements State, Serializable,Cloneable {

    private volatile static PowerSavingState powerSavingStateInstance;

    private PowerSavingState(){
        if(powerSavingStateInstance!=null){
            throw new IllegalStateException("object already crated");
        }
    }

    public static PowerSavingState getPowerSavingStateInstance(){
        if(powerSavingStateInstance==null){
            synchronized (PowerSavingState.class){
                if(powerSavingStateInstance==null){
                    powerSavingStateInstance = new PowerSavingState();
                }
            }
        }
        return powerSavingStateInstance;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return new CloneNotSupportedException();
    }

    protected Object readResolve(){
        return powerSavingStateInstance;
    }

    @Override
    public void On() {
        System.out.println("Switched to OnState from power saving state");
    }

    @Override
    public void Off() {
        System.out.println("Switched to Offstate from power saving state");
    }

    @Override
    public void savePower() {
        System.out.println("Already on save power mode");
    }
}
