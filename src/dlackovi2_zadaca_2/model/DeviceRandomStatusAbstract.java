/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dlackovi2_zadaca_2.model;

import dlackovi2_zadaca_2.rng.RandomNumberGenerator;

/**
 *
 * @author dlackovi2
 */
public class DeviceRandomStatusAbstract implements Device
{
    private int numFails = 0;
    private boolean usable;
    RandomNumberGenerator rng = RandomNumberGenerator.getInstance(958);

    @Override
    public boolean checkStatus()
    {
        int randomNumber = rng.dajSlucajniBroj(0, 100);

        if (randomNumber < 40)
        {
            numFails = 0;
            usable = true;
            return true;
        }
        else
        {
            numFails++;
            usable = false;
            return false;
        }
    }

    @Override
    public int getNumFails()
    {
        return numFails;
    }

    @Override
    public void setNumFails(int numFails)
    {
        this.numFails = numFails;
    }

    @Override
    public boolean getStatus()
    {
        return usable;
    }
}
