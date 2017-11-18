/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dlackovi2_zadaca_2.algorithm;

import dlackovi2_zadaca_2.Dlackovi2_zadaca_2;
import static dlackovi2_zadaca_2.Dlackovi2_zadaca_2.places;
import dlackovi2_zadaca_2.algorithm.util.DeviceStatusChecker;
import dlackovi2_zadaca_2.iterator.impl.PlaceIterator;
import dlackovi2_zadaca_2.model.Place;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author foobar
 */
public class ObrnutoAlgorithm  extends Algorithm
{
    List<Integer> placeIDs = new ArrayList<>();
    
    @Override
    public void checkPlaces() {
        PlaceIterator iterator = new PlaceIterator();
        
        while(iterator.hasNext())
        {
            placeIDs.add(((Place)iterator.next()).getId());
        }
        
        for (Integer placeID : placeIDs) {
            iterator = new PlaceIterator();
            
            while(iterator.hasNext())
            {
                Place place = (Place) iterator.next();
                if(place.getId() == placeID)
                {
                    System.out.println("Provjera mjesta: " + place.getName() + " ID: " + place.getId());
                    DeviceStatusChecker.checkStatus(place.getDevices());
                }
            }
        }
    }
    
}
