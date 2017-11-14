package dlackovi2_zadaca_2.util;

import dlackovi2_zadaca_2.model.Actuator;
import dlackovi2_zadaca_2.model.Place;
import dlackovi2_zadaca_2.model.Sensor;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dlackovi2
 */
public class FileManager
{

    private static volatile FileManager INSTANCE;

    private FileManager()
    {
    }

    public static FileManager getInstance()
    {
        if (INSTANCE == null)
        {
            synchronized (FileManager.class)
            {
                if (INSTANCE == null)
                {
                    INSTANCE = new FileManager();
                }
            }
        }
        return INSTANCE;
    }

    public List<Object> loadData(String fileName, FileType type) throws CloneNotSupportedException
    {
        List<Object> data = new ArrayList<>();
        Place placePrototype = new Place();
        Sensor sensorPrototype = new Sensor();
        Actuator actuatorPrototype = new Actuator();

        BufferedReader br = null;
        String line = "";
        String delimiter = ";";

        try
        {
            br = new BufferedReader(new FileReader(fileName));
            System.out.println(fileName);
            switch (type)
            {
                //TODO provjera jel valja po zaglavlju fajla
                case PLACE:
                    br.readLine();
                    while ((line = br.readLine()) != null)
                    {
                        Place pla = (Place) placePrototype.clone();
                        String[] places = line.split(delimiter);
                        pla.setName(places[0]);
                        pla.setType(Integer.valueOf(places[1]));
                        pla.setnSensors(Integer.valueOf(places[2]));
                        pla.setnActuators(Integer.valueOf(places[3]));
                        pla.setUsable(true);
                        
                        data.add(pla);
                    }
                    break;
                case SENSOR:
                    br.readLine();
                    while ((line = br.readLine()) != null)
                    {
                        Sensor sen = (Sensor) sensorPrototype.clone();
                        String[] sensors = line.split(delimiter);
                        sen.setName(sensors[0]);
                        sen.setType(Integer.valueOf(sensors[1]));
                        sen.setKind(sensors[2]);
                        sen.setMinValue(Float.valueOf(sensors[3]));
                        sen.setMaxValue(Float.valueOf(sensors[4]));
                        if (sensors.length == 6)
                        {
                            sen.setComment(sensors[5]);
                        }
                        
                        data.add(sen);
                    }
                    break;
                case ACTUATOR:
                    br.readLine();
                    while ((line = br.readLine()) != null)
                    {
                        Actuator act = new Actuator();
                        String[] actuators = line.split(delimiter);
                        act.setName(actuators[0]);
                        act.setType(Integer.valueOf(actuators[1]));
                        act.setKind(actuators[2]);
                        act.setMinValue(Float.valueOf(actuators[3]));
                        act.setMaxValue(Float.valueOf(actuators[4]));
                        if (actuators.length == 6)
                        {
                            act.setComment(actuators[5]);
                        }

                        data.add(act);
                    }
                    break;
                default:
            }
        }
        catch (IOException | NumberFormatException ex)
        {

        }

        return data;
    }

    public void exportData()
    {

    }
}
