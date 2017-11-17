package dlackovi2_zadaca_2.util;

import dlackovi2_zadaca_2.model.Actuator;
import dlackovi2_zadaca_2.model.Place;
import dlackovi2_zadaca_2.model.Sensor;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dlackovi2
 */
public class FileManager
{
    private static volatile FileManager INSTANCE;
    public static String outputFile;
    public static int outputBuffer;
    public static int outputBufferLength = 0;
    public static String outputText = "";

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

    public List<Object> importData(String fileName, FileType type) throws CloneNotSupportedException
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
                        
                        if(pla.getType() == 0 || pla.getType() == 1)   
                            data.add(pla);
                        else
                        {
                            exportData("Neispravno mjesto. Preskacem.");
                            System.out.println("Neispravno mjesto. Preskacem.");
                        }   
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
                        sen.setKind(Integer.valueOf(sensors[2]));
                        sen.setMinValue(Float.valueOf(sensors[3]));
                        sen.setMaxValue(Float.valueOf(sensors[4]));
                        if (sensors.length >= 6)
                        {
                            sen.setComment(sensors[5]);
                        }
                        
                        if((sen.getType() >= 0 && sen.getType() <= 2) && (sen.getKind() >= 0 && sen.getKind() <= 3))  
                            data.add(sen);
                        else
                        {
                            exportData("Neispravan senzor. Preskacem.");
                            System.out.println("Neispravan senzor. Preskacem.");
                        } 
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
                        act.setKind(Integer.valueOf(actuators[2]));
                        act.setMinValue(Float.valueOf(actuators[3]));
                        act.setMaxValue(Float.valueOf(actuators[4]));
                        if (actuators.length >= 6)
                        {
                            act.setComment(actuators[5]);
                        }

                        if((act.getType() >= 0 && act.getType() <= 2) && (act.getKind() >= 0 && act.getKind() <= 3))  
                            data.add(act);
                        else
                        {
                            exportData("Neispravan aktuator. Preskacem.");
                            System.out.println("Neispravan aktuator. Preskacem.");
                        } 
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
    
    public void exportData(String message) throws IOException
    {
        outputBufferLength++;
        outputText += message + System.lineSeparator();
        
        if(outputBufferLength == outputBuffer)
        {
            Path path = Paths.get(outputFile);
            Files.write(path, (outputText + System.lineSeparator()).getBytes(StandardCharsets.UTF_8), StandardOpenOption.C‌​REATE, StandardOpenOp‌​tion.APPEND);
            outputBufferLength = 0;
            outputText = "";
        }
    }
    
    public static int getOutputBufferLength()
    {
        return outputBufferLength;
    }

    public static void setOutputBufferLength(int outputBufferLength)
    {
        FileManager.outputBufferLength = outputBufferLength;
    }

    public static int getOutputBuffer()
    {
        return outputBuffer;
    }

    public static void setOutputBuffer(int outputBuffer)
    {
        FileManager.outputBuffer = outputBuffer;
    }

    public static String getOutputFile()
    {
        return outputFile;
    }

    public static void setOutputFile(String outputFile)
    {
        FileManager.outputFile = outputFile;
    }
}
