package AirportTower;

import java.util.ArrayList;
import Airport.Airport.*;
import Airplane.Aircraft.*;
import Airport.Airport.AirportResourcePool;
import Airport.Airport.Gate;
import Airport.Airport.GateID;
import Airport.Airport.IRunwayManagement;
import Airport.Airport.RunwayManagement;
import Airport.Checkin_Desk.CheckInMediator;
import Airport.Security_Check.SecurityMediator;
import Airport.Ground_Operations.GroundOperationsCenter;
import Airport.Base.Flight;
import Airport.Service_Vehicle.ServiceVehicleBase;
import Airport.Sky_Tanking_Vehicle.SkyTankingVehicle;
import Airport.fire_department.FireDepartment;
public class Airport{
	private AirportResourcePool resourcePool;
    private GroundOperationsCenter groundOperationsCenter;
    private CheckInMediator checkInMediator;
    private Tower tower;
	public ArrayList<FireDepartment> FireDepartments;
	private ArrayList<Gate> gateList;

    public Airport(AirportResourcePool resourcePool, ArrayList<Gate> gateList,
                    GroundOperationsCenter groundOperationsCenter, CheckInMediator checkInMediator,
                   SecurityMediator securityMediator,  Tower tower){
        this.resourcePool = resourcePool;
        this.groundOperationsCenter = groundOperationsCenter;
        this.checkInMediator = checkInMediator;
           this.tower = tower;
           this.gateList=gateList;
    }

    public Airport(){

    }

    public void init(Airport airport){
        resourcePool = new AirportResourcePool(50,50,50,50,50,50,50,50,50,50,airport);
        groundOperationsCenter = new GroundOperationsCenter(airport, 100);
        checkInMediator = new CheckInMediator();
        tower = new Tower(airport, null, null);
        IRunwayManagement runwayManagement = new RunwayManagement(null, null, tower);
        tower.setRunwayManagement(runwayManagement); 
        gateList =new ArrayList<Gate>(10);
        for(int number = 1; number <=10; number++){
        	Gate gate= new Gate(GateID.GATE_ID.getGateNumber(number),null);
        	gateList.add(gate);
        }

    }
    public boolean connectAirplane(Airplane airplane, Gate gate){
        if(gate.getAirplane() == null) {
            gate.connect(airplane);
            return true;
        } else {
            System.out.println("Flugzeug kann nicht connected werden. Gate ist bereits belegt.");
            return false;
        }
    }

    public boolean disconnectAirplane(Airplane airplane, Gate gate){
        if ((gate.getAirplane() != null) && (gate.getAirplane() == airplane)) {
            gate.disconnectAirplane();
            return true;
        }
        else {
             System.out.println("Flugzeug kann nicht disconnected werden.");
            return false;}
    }

    public boolean executeCheckIn(Flight flight){
        checkInMediator.executeRequest(flight);
        //get Receipt from Ground operations
        return true;
    }



    public boolean executeServiceBase(GateID gateID){
        ServiceVehicleBase base = resourcePool.takeResource("ServiceVehicleBase");
        base.executeRequest(gateID);
        //TODO: get receipt from ground operations
        resourcePool.returnResource(base);
        return true;
    }

   

    public boolean executePushback(Gate gate){
        //TODO
        return false;
    }

    public boolean executeGroundOperationsLogging(){

        //TODO
        return false;
    }

    public AirportResourcePool getResourcePool(){
        return this.resourcePool;
    }

    public CheckInMediator getCheckInMediator() {
        return checkInMediator;
    }

    public GroundOperationsCenter getGroundOperationsCenter() {
        return groundOperationsCenter;
    }


    public ArrayList<Gate> getGateList() {
        return this.getGateList();
    }

}