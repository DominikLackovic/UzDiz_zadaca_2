/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dlackovi2_zadaca_2.thread;

import dlackovi2_zadaca_2.algorithm.Algorithm;
import dlackovi2_zadaca_2.algorithm.ConcreteAlgorithm;
import dlackovi2_zadaca_2.iterator.impl.PlaceIterator;
import dlackovi2_zadaca_2.model.Actuator;
import dlackovi2_zadaca_2.model.Device;
import dlackovi2_zadaca_2.model.Place;
import dlackovi2_zadaca_2.model.Sensor;
import java.util.List;

/**
 *
 * @author 
 */
public class RadnaDretva extends Thread{

    private long seed;
    
    public RadnaDretva(long seed)
    {
        this.seed = seed;
    }
    
    @Override
    public void interrupt() {
        super.interrupt(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void run() {
        //TODO Odabir algoritma iz parametara
        System.out.println("PROVJERA SLIJEDNO");
        Algorithm algorithm = new ConcreteAlgorithm().createAlgorithm("slijedno", seed);
        algorithm.checkPlaces();
        PlaceIterator iterator = new PlaceIterator();
        while(iterator.hasNext())
        {
            Place place = (Place) iterator.next();
            checkDevicesValues(place.getDevices());
        }
        /*System.out.println("PROVJERA OBRNUTO");
        algorithm = new ConcreteAlgorithm().createAlgorithm("obrnuto", seed);
        algorithm.checkPlaces();
        
        System.out.println("PROVJERA RANDOM");
        algorithm = new ConcreteAlgorithm().createAlgorithm("random", seed);
        algorithm.checkPlaces();*/
    }

    @Override
    public synchronized void start() {
        System.out.println("= TACTICAL ALERT = Pokrenuta dretva.");
        super.start(); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void checkDevicesValues(List<Device> devices){
        for (Device device : devices) {
            if(device instanceof Sensor)
            {
                Sensor sensor = (Sensor) device;
                System.out.println("== OČITANJE == Sensor: " + sensor.getName() + " Stanje: " + sensor.getValue());
                switch(sensor.getKind()){
                        case 0:
                            break;
                        case 1:
                            break;
                        case 2:
                            break;
                        case 3:
                            if(sensor.getValue() == 1)
                                sensor.setValue(0);
                            else
                                sensor.setValue(1);
                            break;
                            
                }
            }
            else if(device instanceof Actuator)
            {
                Actuator actuator = (Actuator) device;
                System.out.println("== OČITANJE == Aktuator: " + actuator.getName() + " Stanje: " + actuator.getValue());
                switch(actuator.getKind()){
                        case 0:
                            break;
                        case 1:
                            break;
                        case 2:
                            break;
                        case 3:
                            if(actuator.getValue() == 1)
                                actuator.setValue(0);
                            else
                                actuator.setValue(1);
                            break;
                            
                }
            }
        }
    }
}
