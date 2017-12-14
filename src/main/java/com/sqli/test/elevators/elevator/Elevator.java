package com.sqli.test.elevators.elevator;

public class Elevator {
    private String elevatorId;
    private int currentFloor;
    private String state;
    private int numberOfFloors;

    public String getElevatorId() {
        return elevatorId;
    }

    public void setElevatorId(String elevatorId) {
        this.elevatorId = elevatorId;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    public Elevator(String elevatorId, int currentFloor ,int numberOfFloors) {
        this.elevatorId = elevatorId;
        this.currentFloor = currentFloor;
        this.numberOfFloors=numberOfFloors;
        state="RESTING";
    }

    public Elevator() {

    }
    public int distance(int floor){
        int tempororyDistance= floor-currentFloor;
        int direction=0;// equals 1 if going up, equals -1 if going down , equals 0 if resting
        if(state.equals("UP"))
            direction=1;
        if(state.equals("DOWN"))
            direction=-1;

        if(floor-currentFloor * direction>=0)
            return Math.abs(tempororyDistance);
        else
            return tempororyDistance+(10-currentFloor)*2;
    }
}
