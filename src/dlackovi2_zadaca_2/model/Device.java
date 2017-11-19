package dlackovi2_zadaca_2.model;

/**
 *
 * @author dlackovi2
 */
public interface Device
{
    public boolean checkStatus();
    public int getnErrors();
    public void setnErrors(int n);
    public boolean getStatus();
}
