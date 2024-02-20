package States;

import Models.State;

import java.io.Serializable;


public class OffState implements State, Cloneable, Serializable {

    private volatile static OffState offStateInstance;

    private OffState(){
        if(offStateInstance!=null){
            throw new IllegalStateException("Object already created");
        }
    }

    public static OffState getOffStateInstance(){
        if(offStateInstance==null){
            synchronized (OffState.class){
                if(offStateInstance==null){
                    offStateInstance = new OffState();
                }
            }
        }

        return offStateInstance;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return new CloneNotSupportedException();
    }

    protected Object readResolve(){
        return offStateInstance;
    }

    @Override
    public void On() {
        System.out.println("In On state");
    }

    @Override
    public void Off() {
        System.out.println("Already On Off State");
    }

    @Override
    public void savePower() {
        System.out.println("Power saving mode is not applicable");
    }
}
