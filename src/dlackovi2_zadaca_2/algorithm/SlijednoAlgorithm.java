/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dlackovi2_zadaca_2.algorithm;

import dlackovi2_zadaca_2.iterator.impl.PlaceIterator;
import dlackovi2_zadaca_2.model.Actuator;
import dlackovi2_zadaca_2.model.Device;
import dlackovi2_zadaca_2.model.Place;
import dlackovi2_zadaca_2.model.Sensor;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author foobar
 */
public class SlijednoAlgorithm  extends Algorithm
{
    private PlaceIterator placeIterator = new PlaceIterator();

    @Override
    public void checkPlaces() {
        while(placeIterator.hasNext())
        {
            Place place = (Place) placeIterator.next();
            List<Device> devices = place.getDevices();
            for (Device device : devices) {
                if(!device.checkStatus())
                {
                    if(device instanceof Actuator)
                    {
                        Actuator actuator = (Actuator) device;
                        System.out.print("Provjera aktuatora: " + actuator.getId() + " " + actuator.getName());
                    } else 
                    {
                        Sensor sensor = (Sensor) device;
                        System.out.print("Provjera senzora: " + sensor.getId() + " " + sensor.getName());
                    }
                    System.out.println(" Broj pogresaka: " + device.getNumFails());
                    if(device.getNumFails() >= 3)
                    {
                        device.setNumFails(0);
                        System.out.println("= TACTICAL ALERT = Potrebna zamijena."); //TODO Zamjena uređaja
                    }
                } else 
                {
                    if(device instanceof Actuator)
                    {
                        Actuator actuator = (Actuator) device;
                        System.out.print("Provjera aktuatora: " + actuator.getId() + " " + actuator.getName());
                    } else 
                    {
                        Sensor sensor = (Sensor) device;
                        System.out.print("Provjera senzora: " + sensor.getId() + " " + sensor.getName());
                    }
                    System.out.println(" Ispravan uređaj.");
                }
            }
        }
    }
    
    
}
