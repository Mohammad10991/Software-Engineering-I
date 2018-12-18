package AirportTower;

import Airport.Airport.RunwayID;


public interface ITower {

    void recieveRequestTakeOff(Airplane airplane);

    void approveRequestTakeOff(Airplane airplane);

    void recieveRequestLanding(Airplane airplane);

    void approveRequestLanding(Airplane airplane);

    void recieveFireAlarm(Airplane airplane);

    AlarmType determineAlarmType(Airplane airplane);

    void alarm(RunwayID runwayID, Airplane airplane);
}