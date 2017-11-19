/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dlackovi2_zadaca_2.thread;

import dlackovi2_zadaca_2.algorithm.Algorithm;
import dlackovi2_zadaca_2.algorithm.ConcreteAlgorithm;

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
        System.out.println("PROVJERA SLIJEDNO");
        Algorithm algorithm = new ConcreteAlgorithm().createAlgorithm("slijedno", seed);
        algorithm.checkPlaces();
        
        System.out.println("PROVJERA OBRNUTO");
        algorithm = new ConcreteAlgorithm().createAlgorithm("obrnuto", seed);
        algorithm.checkPlaces();
        
        System.out.println("PROVJERA RANDOM");
        algorithm = new ConcreteAlgorithm().createAlgorithm("random", seed);
        algorithm.checkPlaces();
    }

    @Override
    public synchronized void start() {
        System.out.println("= TACTICAL ALERT = Pokrenuta dretva.");
        super.start(); //To change body of generated methods, choose Tools | Templates.
    }
    
}
