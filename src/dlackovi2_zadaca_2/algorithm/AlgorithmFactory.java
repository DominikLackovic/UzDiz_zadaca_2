package dlackovi2_zadaca_2.algorithm;

/**
 *
 * @author dlackovi2
 */
public abstract class AlgorithmFactory
{
    public AlgorithmFactory()
    {
    }
    
    protected abstract Algorithm createAlgorithm(String name, long seed);
}
