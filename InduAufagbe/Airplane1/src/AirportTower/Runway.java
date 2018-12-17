package AirportTower;
import java.util.ArrayList;
import Aircraft.Airplane;
import Lights.Position;
public class Runway{
    private RunwayID runwayID;
    private Position position;
    private ArrayList<RunwaycheckpointerID> checkPoints;
    private WindDirectionSensor windDirectionSensor;
    private boolean isClearedToLand;
    private boolean isClearedForTakeOff;
    private Airplane airplane;

    public Runway(RunwayID runwayID, Position position, ArrayList<RunwaycheckpointerID> checkPoints,
                  WindDirectionSensor windDirectionSensor, boolean isClearedToLand, boolean isClearedForTakeOff, Airplane airplane){
        this.runwayID = runwayID;
        this.position = position;
        this.checkPoints = checkPoints;
        this.windDirectionSensor = windDirectionSensor;
        this.isClearedToLand = isClearedToLand;
        this.isClearedForTakeOff = isClearedForTakeOff;
        this.airplane = airplane;
    }

    public RunwayID getRunwayID() {
        return runwayID;
    }

    public void setRunwayID(RunwayID runwayID) {
        this.runwayID = runwayID;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public ArrayList<RunwaycheckpointerID> getCheckPoints() {
        return checkPoints;
    }

    public void setCheckPoints(ArrayList<RunwaycheckpointerID> checkPoints) {
        this.checkPoints = checkPoints;
    }

    public boolean isClearedToLand() {
        return isClearedToLand;
    }

    public void setClearedToLand(boolean clearedToLand) {
        isClearedToLand = clearedToLand;
    }

    public boolean isClearedForTakeOff() {
        return isClearedForTakeOff;
    }

    public void setClearedForTakeOff(boolean clearedForTakeOff) {
        isClearedForTakeOff = clearedForTakeOff;
    }

    public Airplane getAirplane() {
        return airplane;
    }

    public void setAirplane(Airplane airplane) {
        this.airplane = airplane;
    }
}