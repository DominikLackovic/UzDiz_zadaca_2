/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dlackovi2_zadaca_2.algorithm;

import dlackovi2_zadaca_2.algorithm.util.DeviceStatusChecker;
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
            System.out.println("Provjera mjesta: " + place.getName() + " ID: " + place.getId());
            place.setDevices(DeviceStatusChecker.checkStatus(place.getDevices()));
        }
    }
    
    
}
