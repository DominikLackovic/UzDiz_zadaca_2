package dlackovi2_zadaca_2.algorithm;

/**
 *
 * @author dlackovi2
 */
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
