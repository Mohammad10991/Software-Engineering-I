package AirportTower;


import Airport.Airport.IRunwayManagement;
import Airport.Airport.Runway;
import Airport.Airport.RunwayID;
import Airport.Airport.WindDirection;
import Airport.Base.AlarmType;
import Airport.fire_department.*;
import apu_engine_gear_pump.Engine;
import Airport.fire_department.*;


import java.util.ArrayList;

import Airplane.Aircraft.*;

public class Tower implements ITower{
    private Airport airport;
    private String frequency;
    private IRunwayManagement runwayManagement;
    private WindDirection windDirection;
    private ArrayList<Runway> runwayList;
    
    public Tower(Airport airport, IRunwayManagement runwayManagement, WindDirection windDirection){
        this.airport = airport;
        this.runwayManagement = runwayManagement;
        this.windDirection = windDirection;
        this.frequency = "128.5";
    }

    public void recieveRequestTakeOff(Airplane airplane){
        //TODO
        approveRequestTakeOff(airplane);
    }

    public void approveRequestTakeOff(Airplane airplane){
        //TODO
        System.out.println("Approve request takeoff for " + airplane.getID());
    }

    public void recieveRequestLanding(Airplane airplane){
        //TODO
        approveRequestLanding(airplane);
    }

    public void approveRequestLanding(Airplane airplane){
        //TODO
        System.out.println("Approve request landing for " + airplane.getID());

    }

    public void recieveFireAlarm(Airplane airplane){



    }

    public AlarmType determineAlarmType(Airplane airplane){
        int countLeftWing = 0;
        int countRightWing = 0;

        boolean isA350 = false;
        //TODO
        IWing leftWing = airplane.getLeftWing();
        ArrayList<Engine> enginges = leftWing.getEngines();
        enginges.foeEach(engine ->{
            if (engine.isFire())
                countLeftWing++;
        });

        int numberOfAllEngines = countLeftWing + countRightWing;

        if(airplane instanceof A350)
            isA350 = true;

        if (numberOfAllEngines == 1)
        {
            return AlarmType.A;
        }
        else{
            if((countLeftWing == 1) && (countRightWing == 1))
            {
                return AlarmType.B;
            }
            if((countLeftWing == 2) || (countRightWing == 2))
            {
                return AlarmType.C;
            }
        }

        if(airplane instanceof A380)
            isA350 = false;

        if (numberOfAllEngines == 1)
        {
            if(countRightWing == 1)
            {
                return AlarmType.A;
            }
            if(countLeftWing == 1)
            {
                return AlarmType.B;
            }
        }
        else{
            return AlarmType.C;
        }

        return null;
    }

    public void alarm(RunwayID runwayID, Airplane airplane){
       ArrayList<FireDepartment> fireDepartments = airport.FireDepartments;
       AlarmType alarmType = determineAlarmType(airplane);
       fireDepartments.forEach(fireDepartments -> ((IFireDepartment) fireDepartments).alarm(runwayID,alarmType));
    }

    public WindDirection getWindDirection() {
        return windDirection;
    }


	public void setRunwayManagement(IRunwayManagement runwayManagement2) {
		// TODO Auto-generated method stub
		
	}
}