package com.sqli.test.elevators;
import com.sqli.test.elevators.elevator.Elevator;

import java.util.HashMap;
import static com.sqli.test.elevators.configuration.Configuration.DETAILS_SEPARATOR;
public class Building {
    HashMap<String,Elevator> elevatorHashMap;
    int numberOfFloors;

    /**
     * @param numberOfFloors: the number of floors in the building
     * @param elevators: an array of descriptions of the elevators of the building. 
     *                   A description has the following format "[elevator_id]:[elevator_current_floor]".
     */
    public Building(int numberOfFloors, String... elevators) {
        this.numberOfFloors=numberOfFloors;
        elevatorHashMap=new HashMap<>();
        for(int i=0;i<elevators.length;i++){
            String[] elevatorDetails= elevators[i].split(DETAILS_SEPARATOR);
            Elevator elevator;
            String id = "";
            int currentFloor=0;
            //Get elevator id
            if (elevatorDetails.length > 0 && !isBlank(elevatorDetails[0])) {
                id = elevatorDetails[0];
            }
            //Get elevator current floor
            if (elevatorDetails.length > 1 && !isBlank(elevatorDetails[1])){
                currentFloor=Integer.valueOf(elevatorDetails[1].trim());
            }
            elevator =new Elevator(id,currentFloor,numberOfFloors);
            elevatorHashMap.put(id.trim(),elevator);
        }
    }

    /**
     * Request an elevator at floor zero.
     * @return the id of the elevator that should serve the request.
     */
    public String requestElevator() {
        String requestedElevatorId=null;
        int minimumDistance=numberOfFloors*20;
        for(Elevator elevator:elevatorHashMap.values()){
            int distanceOfElevetor=elevator.distance(0);
            if (distanceOfElevetor<minimumDistance) {
                requestedElevatorId = elevator.getElevatorId();
                minimumDistance=distanceOfElevetor;
            }
        }
        return requestedElevatorId;
    }

    /**
     * Request an elevator at floor indicate by the {@code floor} param.
     * @param floor : the floor where the request is made.
     * @return the id of the elevator that should serve the request.
     */
    public String requestElevator(int floor) {
        String requestedElevatorId=null;
        int minimumDistance=numberOfFloors*20;
        for(Elevator elevator:elevatorHashMap.values()){
            int distanceOfElevetor=elevator.distance(floor);
            if (distanceOfElevetor<minimumDistance) {
                requestedElevatorId = elevator.getElevatorId();
                minimumDistance=distanceOfElevetor;
            }
        }
        return requestedElevatorId;
    }

    /**
     * Request the elevator with the id {@code elevatorId} to stop at the floor indicated by the {@code floor} param.
     * @param elevatorId : the id of the elevator to whom give the order.
     * @param floor : the floor at which the elevator should stop
     */
    public void stopAt(String elevatorId, int floor) {
        throw new UnsupportedOperationException("Still to be implemented");
    }

    /**
     * Move the elevator with the id {@code elevatorId} in the direction indicated by the {@code direction} param.
     * @param elevatorId : the id of the elevator to move.
     * @param direction : the direction to go. Can be "UP" or "DOWN".
     */
    public void move(String elevatorId, String direction) {
        Elevator elevator=elevatorHashMap.get(elevatorId);
        elevator.setState(direction);
    }

    //Check if CharSequence is blank
    private static boolean isBlank(CharSequence cs) {
        int strLen;
        if (cs != null && (strLen = cs.length()) != 0) {
            for (int i = 0; i < strLen; ++i) {
                if (!Character.isWhitespace(cs.charAt(i))) {
                    return false;
                }
            }
            return true;
        } else {
            return true;
        }
    }
}
