package States;

import Models.ColourState;
import Models.State;

import java.io.Serializable;

public class OnState implements State, Serializable, Cloneable,ColourState {

    private volatile static OnState onStateInstance;
    private ColourState currentColourState;

    protected void setCurrentColourState(ColourState colourState){
        this.currentColourState = colourState;
    }

    private OnState(){
        if(onStateInstance!=null){
            throw new IllegalStateException("Object already created");
        }
        this.currentColourState = new RedColourState();
    }

    public static OnState getOnStateInstance(){

        if(onStateInstance==null){
            synchronized (OnState.class){
                if(onStateInstance==null){
                    onStateInstance = new OnState();
                }
            }
        }

        return onStateInstance;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return new CloneNotSupportedException();
    }

    protected Object readResolve(){
        return onStateInstance;
    }

    @Override
    public void On() {
        System.out.println("Already on On state");
    }

    @Override
    public void Off() {
        System.out.println("In off state");
    }

    @Override
    public void savePower() {
        System.out.println("In power saving mode");
    }

    @Override
    public void changeColour() {
        currentColourState.changeColour();
        this.setCurrentColourState(currentColourState instanceof GreenColourState ? new RedColourState(): new GreenColourState());
    }
}
