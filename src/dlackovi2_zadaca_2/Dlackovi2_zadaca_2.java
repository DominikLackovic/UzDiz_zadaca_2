package dlackovi2_zadaca_2;

import dlackovi2_zadaca_2.iterator.Container;
import dlackovi2_zadaca_2.iterator.Iterator;
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
    static List<Place> places = null;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException, org.apache.commons.cli.ParseException, CloneNotSupportedException, IOException
    {
        ValidArguments validArguments = new ArgumentValidator().validate(args);
        FileManager fileManager = FileManager.getInstance();
        FileManager.setOutputFile(validArguments.getOutputFile());
        FileManager.setOutputBuffer(validArguments.getOutputBuffer());
        fileManager.exportData("- LOG DATOTEKA- " + System.lineSeparator() + "---------------" + System.lineSeparator());

        places = (List<Place>) (List<?>) fileManager.importData(validArguments.getPlacesFile(), FileType.PLACE);
        /*for (Place p : places)
        {
            System.out.println("Mjesto: " + p.getName());
        }*/
        /*
        List<Sensor> sensors = null;
        sensors = (List<Sensor>) (List<?>) fileManager.importData(validArguments.getSensorsFile(), FileType.SENSOR);
        for(Sensor p : sensors)
            System.out.println("Mjesto: " + p.getComment());*/
 /*NameRepository namesRepository = new NameRepository();
        for (Iterator1 iter = namesRepository.getIterator(); iter.hasNext();)
        {
            String name = (String) iter.next();
            System.out.println("Name : " + name);
        }*/
 
        for(Iterator iter = new PlaceIterator(); iter.hasNext();)
        {
            Place pl = (Place) iter.next();
            System.out.println(pl.getName());
        }


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
