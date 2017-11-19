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
import dlackovi2_zadaca_2.rng.RandomNumberGenerator;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 
 */
public class RadnaDretva extends Thread{

    private long seed;
    int maxCiklusa = 0;
    int trajanjeCiklusa = 0;
    int rbCiklusa = 0;
    private boolean stop = false;
    String vrstaAlgoritma;
    
    public RadnaDretva(long seed, int maxCiklusa, int trajanjeCiklusa, String vrsta)
    {
        this.maxCiklusa = maxCiklusa;
        this.trajanjeCiklusa = trajanjeCiklusa;
        this.seed = seed;
        this.vrstaAlgoritma = vrsta;
        
        RandomNumberGenerator rng = RandomNumberGenerator.getInstance(seed);
        if(this.maxCiklusa == 0)
            this.maxCiklusa = rng.dajSlucajniBroj(1, 23);
        if(this.trajanjeCiklusa == 0)
            this.trajanjeCiklusa = rng.dajSlucajniBroj(1, 17);
            
    }
    
    @Override
    public void interrupt() {
        stop = true;
        super.interrupt(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void run() {
        
        while(!stop){
            Date pocetakObrade = new Date();
            rbCiklusa++;
            System.out.println("Redni broj ciklusa: " + rbCiklusa);
            //TODO Odabir algoritma iz parametara
            if(vrstaAlgoritma == "" || vrstaAlgoritma == null || !vrstaAlgoritma.equals("slijedno") || !vrstaAlgoritma.equals("random") || !vrstaAlgoritma.equals("obrnuto"))
                vrstaAlgoritma = "slijedno";
            System.out.println("PROVJERA: " + vrstaAlgoritma);
            Algorithm algorithm = new ConcreteAlgorithm().createAlgorithm(vrstaAlgoritma, seed);
            algorithm.checkPlaces();
            
            PlaceIterator iterator = new PlaceIterator();
            while(iterator.hasNext())
            {
                Place place = (Place) iterator.next();
                checkDevicesValues(place.getDevices());
            }
            Date krajObrade = new Date();
            long trajanjeObrade = krajObrade.getTime() - (pocetakObrade.getTime() - 1);
            if (trajanjeObrade < 0) 
                    trajanjeObrade = 0;
            try {
                sleep((trajanjeCiklusa*1000) - trajanjeObrade);
            } catch (InterruptedException ex) {
                Logger.getLogger(RadnaDretva.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(rbCiklusa > maxCiklusa)
                stop = true;
        }
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
