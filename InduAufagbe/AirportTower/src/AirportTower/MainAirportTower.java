package AirportTower;

import java.util.ArrayList;

import Airplane.Aircraft.Airplane;
import Airport.Airport.*;
import Airport.Base.*;

public class MainAirportTower {
	
	public static void main(String[] args) {
	Airport airport = new Airport();
	Flight f=new Flight("22",Carrier.Emirates,Destination.HKG,GateID.A01);
    Airplane airplane=new Airplane(null,null,null,f,2,3,4);
	//Airplane airplane=new Airplane(null,null,null,null,null,null,null);
    Tower tower=new Tower(airport,null,null);
    IRunwayManagement runway=new RunwayManagement(null, null,tower);
    tower.setRunwayManagement(runway);
   ArrayList<Gate> gateList =new ArrayList<Gate>(10);
    for(int number = 1; number <=10; number++){
    	Gate gate= new Gate(GateID.GATE_ID.getGateNumber(number),null);
    	gateList.add(gate);
    airport.connectAirplane(airplane,gate);
    	if(gate.getAirplane()==null){
    	
    	System.out.println("Connect :"+airport.connectAirplane(airplane, gate));
    }
    	
    else{
    	System.out.println("Flugzeug : Flight(22)   Carrier(Emirates) nach (HKG)  kann nicht connected werden.");
    } }
    for(int number1 = 1; number1 <=10; number1++){
    	Gate gate= new Gate(GateID.GATE_ID.getGateNumber(number1),null);
    	gateList.add(gate);
    airport.disconnectAirplane(airplane, gate);
    if((gate.getAirplane()!=null)&&(gate.getAirplane()==airplane)){
    	System.out.println("Disconnect With"+GateID.GATE_ID.getGateNumber(number1)+" was :"+airport.disconnectAirplane(airplane, gate)); 
    }
    else{
    	System.out.println("Flugzeug : Flight(22)  Carrier(Emirates) nach (HKG)   kann nicht disconnected werden gate : "+ GateID.GATE_ID.getGateNumber(number1)); 
    }
    }
}
	
}
