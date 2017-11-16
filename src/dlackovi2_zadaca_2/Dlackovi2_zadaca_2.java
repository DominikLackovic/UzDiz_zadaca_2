package dlackovi2_zadaca_2;

import dlackovi2_zadaca_2.model.Place;
import dlackovi2_zadaca_2.model.Sensor;
import dlackovi2_zadaca_2.util.FileManager;
import dlackovi2_zadaca_2.util.FileType;
import dlackovi2_zadaca_2.validation.ArgumentValidator;
import dlackovi2_zadaca_2.validation.ValidArguments;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

/**
 *
 * @author dlackovi2
 */
public class Dlackovi2_zadaca_2
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException, org.apache.commons.cli.ParseException, CloneNotSupportedException, IOException
    {
        ValidArguments validArguments = new ArgumentValidator().validate(args);
        FileManager fileManager = FileManager.getInstance();
        fileManager.setOutputFile(validArguments.getOutputFile());
        fileManager.exportData("- LOG DATOTEKA- " + System.lineSeparator() + "---------------" + System.lineSeparator());  
                
        List<Place> places = null;
        places = (List<Place>) (List<?>) fileManager.importData(validArguments.getPlacesFile(), FileType.PLACE);
        for(Place p : places)
            System.out.println("Mjesto: " + p.getName());
        
        List<Sensor> sensors = null;
        sensors = (List<Sensor>) (List<?>) fileManager.importData(validArguments.getSensorsFile(), FileType.SENSOR);
        for(Sensor p : sensors)
            System.out.println("Mjesto: " + p.getComment());
        
        /*NameRepository namesRepository = new NameRepository();
        for (Iterator1 iter = namesRepository.getIterator(); iter.hasNext();)
        {
            String name = (String) iter.next();
            System.out.println("Name : " + name);
        }*/
        
        
    }
}
