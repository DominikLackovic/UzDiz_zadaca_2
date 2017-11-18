package dlackovi2_zadaca_2;

import dlackovi2_zadaca_2.iterator.Container;
import dlackovi2_zadaca_2.iterator.Iterator;
import dlackovi2_zadaca_2.model.Actuator;
import dlackovi2_zadaca_2.model.Place;
import dlackovi2_zadaca_2.model.Sensor;
import dlackovi2_zadaca_2.util.FileManager;
import dlackovi2_zadaca_2.util.FileType;
import dlackovi2_zadaca_2.validation.ArgumentValidator;
import dlackovi2_zadaca_2.validation.ValidArguments;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 *
 * @author dlackovi2
 */
public class Dlackovi2_zadaca_2 implements Container
{
    public static List<Place> places = null;
    public static List<Sensor> sensors = null;
    public static List<Actuator> actuators = null;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException, org.apache.commons.cli.ParseException, CloneNotSupportedException, IOException
    {
        ValidArguments validArguments = new ArgumentValidator().validate(args);
        FileManager fileManager = FileManager.getInstance();
        FileManager.setOutputFile(validArguments.getOutputFile());
        FileManager.setOutputBuffer(validArguments.getOutputBuffer());
        FileManager.setSeed(validArguments.getSeed());
        fileManager.exportData("- LOG DATOTEKA- " + System.lineSeparator() + "---------------" + System.lineSeparator());

        places = (List<Place>) (List<?>) fileManager.importData(validArguments.getPlacesFile(), FileType.PLACE);
        sensors = (List<Sensor>) (List<?>) fileManager.importData(validArguments.getSensorsFile(), FileType.SENSOR);
        actuators = (List<Actuator>) (List<?>) fileManager.importData(validArguments.getActuatorsFile(), FileType.ACTUATOR);
        
 
        for(Iterator iter = new PlaceIterator(); iter.hasNext();)
        {
            Place pl = (Place) iter.next();
            System.out.println(pl.getName() + " " + pl.getId());
        }
        
        /*for(Sensor s : sensors)
            System.out.println(s.getName());
        for(Actuator s : actuators)
            System.out.println(s.getName());*/


    }

    @Override
    public Iterator getIterator()
    {
        return new PlaceIterator();
    }

    static class PlaceIterator implements Iterator
    {
        int index;

        @Override
        public boolean hasNext()
        {
            if (index < places.size())
                return true;
            return false;
        }

        @Override
        public Object next()
        {
            if (this.hasNext())
                return places.get(index++);
            return null;
        }
    }
}
