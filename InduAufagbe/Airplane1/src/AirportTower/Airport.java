package AirportTower;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

import Airport.FireDepartment;

import java.io.IOException;

public class Airport{
    private ArrayList<Passenger> passengerList;
    private AirportResourcePool resourcePool;
    private ArrayList<Gate> gateList;
    private Apron apron;
    private GroundOperationsCenter groundOperationsCenter;
    private CheckInMediator checkInMediator;
    private BulkyBaggageDesk bulkyBaggageDesk;
    private SecurityMediator securityMediator;
    private ApronControl apronControl;
    private Tower tower;
    private AirportFuelTank fuelTank = new AirportFuelTank();
	public ArrayList<FireDepartment> FireDepartments;

    public Airport(ArrayList<Passenger> passengerList, AirportResourcePool resourcePool, ArrayList<Gate> gateList,
                   Apron apron, GroundOperationsCenter groundOperationsCenter, CheckInMediator checkInMediator, BulkyBaggageDesk bulkyBaggageDesk,
                   SecurityMediator securityMediator, ApronControl apronControl, Tower tower){
        this.passengerList = passengerList;
        this.resourcePool = resourcePool;
        this.gateList = gateList;
        this.apron = apron;
        this.groundOperationsCenter = groundOperationsCenter;
        this.checkInMediator = checkInMediator;
        this.bulkyBaggageDesk =bulkyBaggageDesk;
        this.securityMediator = securityMediator;
        this.apronControl = apronControl;
        this.tower = tower;
    }

    public Airport(){

    }

    //
    //Singleton:
    //

    private static Airport airport = new Airport();
    public static Airport getAirport(){
        return airport;
    }

    public void setPassengerList(ArrayList<Passenger> passengerList){
        this.passengerList = passengerList;
    }
    public void setResourcePool(AirportResourcePool resourcePool){ this.resourcePool = resourcePool;}
    //TODO: Weitere Setter

    //
    //
    //

    public int loadPassengerBaggageData(String dataFilePath){
        File passengerBaggageData = new File(dataFilePath);
        int zeilenAnzahl = 0;
        if(!passengerBaggageData.canRead() || !passengerBaggageData.isFile()){System.out.println("Kann Datei nicht lesen.");}
        BufferedReader input = null;
        try{
            input = new BufferedReader(new FileReader(dataFilePath));
            String zeile = null;
            while((zeile = input.readLine()) != null){
                zeilenAnzahl++;
                //Noch was mit den Daten machen?
            }
        } catch(IOException ioExeption){
            ioExeption.printStackTrace();
        } finally {
            if(input != null) try {
                input.close();
            } catch (IOException ioException){
                ioException.printStackTrace();
            }
        }
        return zeilenAnzahl;
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

    public boolean executeServiceWasteWater(GateID gateID){
        ServiceVehicleWasteWater serviceVehicle = resourcePool.takeResource("ServiceVehicleWasteWater");
        boolean b = groundOperationsCenter.assign(serviceVehicle);
        serviceVehicle.executeRequest(gateID);
        //TODO: get Receipt from Ground Operations
        resourcePool.returnResource(serviceVehicle);
        return b;
    }

    public boolean executeCheckIn(Flight flight){
        checkInMediator.executeRequest();
        //get Receipt from Ground operations
        return true;
    }

    public boolean executeSecurity(){
        securityMediator.executeRequest();
        //TODO: get Receipt from Ground Operations
        return true;
    }

    public boolean executeCustoms(){
        //TODO
        return false;
    }

    public boolean executeAirCargo(GateID gateID){
        AirCargoPalletVehicle airCargoPalletVehicle = resourcePool.
        //TODO
        return false;
    }

    public boolean executeBaggageSortingUnit(GateID gateID){
        //TODO
        return false;
    }

    public boolean executeServiceBase(GateID gateID){
        ServiceVehicleBase base = resourcePool.takeResource("ServiceVehicleBase");
        base.executeRequest(gateID);
        //TODO: get receipt from ground operations
        resourcePool.returnResource(base);
        return true;
    }

    public boolean executeServiceFreshWater(GateID gateID){
        ServiceVehicleFreshWater freshWaterVehicle = resourcePool.takeResource("ServiceVehicleFreshWater");
        freshWaterVehicle.executeRequest(gateID);
        //TODO: get receipt from ground operations
        resourcePool.returnResource(freshWaterVehicle);
        return false;
    }

    public boolean executeServiceNitrogenOxygen(GateID gateID){
        ServiceVehicleNitrogenOxygen nitrogenOxygenVehicle = resourcePool.takeResource("ServiceVehicleNitrogenOxygen");
        nitrogenOxygenVehicle.executeRequest(gateID);
        //TODO: get receipt from ground operations
        resourcePool.returnResource(nitrogenOxygenVehicle);
        return true;
    }

    public boolean executeSkyTanking(GateID gateID){
        SkyTankingVehicle skyTankingVehicle = resourcePool.takeResource("SkyTankingVehicle");
        skyTankingVehicle.executeRequest(gateID);
        //TODO get receipt from ground operations
        resourcePool.returnResource(skyTankingVehicle);
        return false;
    }

    public boolean executeBoardingControl(Gate gate){
        //TODO
        return false;
    }

    public boolean executePushback(Gate gate){
        //TODO
        return false;
    }

    public boolean executeGroundOperationsLogging(){
        //TODO
        return false;
    }

    public ArrayList<Gate> getGateList() {
        return this.gateList;
    }

    public AirportFuelTank getFuelTank(){
        return this.fuelTank;
    }

    public AirportResourcePool getResourcePool(){
        return this.resourcePool;
    }
}}