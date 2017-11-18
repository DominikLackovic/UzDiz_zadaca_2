/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dlackovi2_zadaca_2.algorithm;

import dlackovi2_zadaca_2.Dlackovi2_zadaca_2;
import static dlackovi2_zadaca_2.Dlackovi2_zadaca_2.places;
import dlackovi2_zadaca_2.algorithm.util.DeviceStatusChecker;
import dlackovi2_zadaca_2.model.Device;
import dlackovi2_zadaca_2.model.Place;
import dlackovi2_zadaca_2.rng.RandomNumberGenerator;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author foobar
 */
public class RandomAlgorithm extends Algorithm
{
    RandomNumberGenerator rng;
    List<Integer> checkedIDs = new ArrayList<>();
    
    RandomAlgorithm(long seed)
    {
        rng = RandomNumberGenerator.getInstance(seed);
    }

    @Override
    public void checkPlaces() {
        
        for(int i = 0; i < places.size(); i++)
        {
            Integer nextId = rng.dajSlucajniBroj(0, places.size() - 1);
            while(checkedIDs.contains(nextId))
                nextId = rng.dajSlucajniBroj(0, places.size() - 1);
            
            checkedIDs.add(nextId);
            Place place = places.get(nextId);
            System.out.println("Provjera mjesta: " + place.getName() + " ID: " + place.getId());
            place.setDevices(DeviceStatusChecker.checkStatus(place.getDevices()));
        }
    }

}
