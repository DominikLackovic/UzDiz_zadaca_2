package dlackovi2_zadaca_2;

import dlackovi2_zadaca_2.model.Place;
import dlackovi2_zadaca_2.model.Sensor;
import dlackovi2_zadaca_2.rng.RandomNumberGenerator;
import dlackovi2_zadaca_2.util.FileManager;
import dlackovi2_zadaca_2.util.FileType;
import dlackovi2_zadaca_2.validation.ArgumentValidator;
import dlackovi2_zadaca_2.validation.ValidArguments;
import java.text.ParseException;
import java.util.List;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;

/**
 *
 * @author dlackovi2
 */
public class Dlackovi2_zadaca_2
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException, org.apache.commons.cli.ParseException, CloneNotSupportedException
    {
        ValidArguments validArguments = new ArgumentValidator().validate(args);
        FileManager fileManager = FileManager.getInstance();
        
                
        List<Place> places = null;
        places = (List<Place>) (List<?>) fileManager.loadData(validArguments.getPlacesFile(), FileType.PLACE);
        for(Place p : places)
            System.out.println("Mjesto: " + p.getName());
        
        List<Sensor> sensors = null;
        sensors = (List<Sensor>) (List<?>) fileManager.loadData(validArguments.getSensorsFile(), FileType.SENSOR);
        for(Sensor p : sensors)
            System.out.println("Mjesto: " + p.getComment());
    }
}
