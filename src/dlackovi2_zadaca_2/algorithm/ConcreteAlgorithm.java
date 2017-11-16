/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dlackovi2_zadaca_2.algorithm;

/**
 *
 * @author dlackovi2
 */
// Concrete Creator
public class ConcreteAlgorithm extends AlgorithmFactory
{

    @Override
    public Algorithm createAlgorithm(String name, long seed)
    {
        if (name.equals("random"))
            return new RandomAlgorithm(seed);
        else if (name.equals("slijedno"))
            return new SlijednoAlgorithm();
        else if (name.equals("obrnuto"))
            return new ObrnutoAlgorithm();
        else
            return null;
    }
}
