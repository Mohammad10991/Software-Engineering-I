package Airport;

import AirportTower.Runway;
import AirportTower.AlarmType;

public interface IFireDepartment
{
    void alarm(Runway runway,
               AlarmType alarmtype);

    boolean openEntrance(Entrance entrance);

    boolean closeEntrance(Entrance entrance);

    int assignFireFighter(FireTruck fireTruck);
}
