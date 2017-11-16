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
// Creator
public abstract class AlgorithmFactory
{
    public AlgorithmFactory()
    {
    }
    
    protected abstract Algorithm createAlgorithm(String name, long seed);
}
