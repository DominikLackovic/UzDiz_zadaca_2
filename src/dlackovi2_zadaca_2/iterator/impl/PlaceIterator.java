/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dlackovi2_zadaca_2.iterator.impl;

import static dlackovi2_zadaca_2.Dlackovi2_zadaca_2.places;
import dlackovi2_zadaca_2.iterator.Iterator;
import dlackovi2_zadaca_2.model.Place;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 
 */
public class PlaceIterator implements Iterator{
    int index;
    int numDone = 0;
    int lastID = 0;
    
    @Override
    public boolean hasNext() {
        if (numDone < places.size())
        {
            
            return true;
        }
        return false;
    }

    @Override
    public Object next() {
            if (this.hasNext())
            {
                numDone++;
                return places.get(getNextId());
            }
            return null;
    }
    private int getNextId()
    {
        List<Place> greaterPlaces = new ArrayList<>();
        
        for (Place place : places) 
        {
            if(place.getId() > lastID)
                greaterPlaces.add(place);
        }
        Place min = greaterPlaces.get(0);
        for (Place greaterPlace : greaterPlaces) 
        {
            if(greaterPlace.getId() < min.getId())
            {
                min = greaterPlace;
                
            }
        }
        lastID = min.getId();
        return places.indexOf(min);
    }
}
