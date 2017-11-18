/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dlackovi2_zadaca_2.model;

import dlackovi2_zadaca_2.rng.RandomNumberGenerator;

/**
 *
 * @author d.horvat
 */
public class DeviceRandomStatusAbstract implements Device{
    int numFails = 0;
    RandomNumberGenerator rng = RandomNumberGenerator.getInstance(958);
    @Override
    public boolean checkStatus() {
        
        int random = rng.dajSlucajniBroj(0, 100);
        
        if(random < 30)
        {
            numFails = 0;
            return true;
        }
        numFails++;
        return false;
    }

    @Override
    public int getNumFails() {
        return numFails;
    }

    public void setNumFails(int numFails) {
        this.numFails = numFails;
    }
    
    
}
