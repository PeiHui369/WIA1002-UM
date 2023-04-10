package tutorial1;

public abstract class Vehicle {
    private double maxSpeed;
    protected double currentSpeed;

    Vehicle(double maxSpeed){
        this.maxSpeed = maxSpeed;
    }

    abstract void accelerate();

    double getCurrentSpeed(){
        return this.currentSpeed;
    }

    double getMaxSpeed(){
        return this.maxSpeed;
    }

    public void pedalToTheMetal(){
        while(currentSpeed < maxSpeed){
            accelerate();
        }
    }
}

//Cannot create instance of Vehicle
