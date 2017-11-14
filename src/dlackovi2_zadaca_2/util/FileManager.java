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
                        pla.setNaziv(places[0]);
                        pla.setTip(Integer.valueOf(places[1]));
                        pla.setBrojSenzora(Integer.valueOf(places[2]));
                        pla.setBrojAktuatora(Integer.valueOf(places[3]));
                        pla.setKoristi(true);
                        
                        data.add(pla);
                    }
                    break;
                case SENSOR:
                    br.readLine();
                    while ((line = br.readLine()) != null)
                    {
                        Sensor sen = (Sensor) sensorPrototype.clone();
                        String[] sensors = line.split(delimiter);
                        sen.setNaziv(sensors[0]);
                        sen.setTip(Integer.valueOf(sensors[1]));
                        sen.setVrsta(sensors[2]);
                        sen.setMinVrijednost(Float.valueOf(sensors[3]));
                        sen.setMaxVrijednost(Float.valueOf(sensors[4]));
                        if (sensors.length == 6)
                        {
                            sen.setKomentar(sensors[5]);
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
                        act.setNaziv(actuators[0]);
                        act.setTip(Integer.valueOf(actuators[1]));
                        act.setVrsta(actuators[2]);
                        act.setMinVrijednost(Float.valueOf(actuators[3]));
                        act.setMaxVrijednost(Float.valueOf(actuators[4]));
                        if (actuators.length == 6)
                        {
                            act.setKomentar(actuators[5]);
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
