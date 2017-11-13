package dlackovi2_zadaca_2.rng;

import java.util.Random;

/**
 *
 * @author dlackovi2
 */
public class RandomNumberGenerator
{
    private static volatile RandomNumberGenerator INSTANCE;
    private Random rand;

    private RandomNumberGenerator()
    {
    }

    public static RandomNumberGenerator getInstance(long seed)
    {
        if (INSTANCE == null)
        {
            synchronized (RandomNumberGenerator.class)
            {
                if (INSTANCE == null)
                {
                    INSTANCE = new RandomNumberGenerator();
                    INSTANCE.rand = new Random(seed);
                }
            }
        }
        return INSTANCE;
    }
    
    //[odBroja, doBroja>
    public int dajSlucajniBroj(int odBroja, int doBroja)
    {
        return rand.nextInt(doBroja - odBroja) + odBroja;
    }
    
    //[odBroja, doBroja>
    public float dajSlucajniBroj(float odBroja, float doBroja)
    {
        return rand.nextFloat() * (doBroja - odBroja) + odBroja;
    }
}
