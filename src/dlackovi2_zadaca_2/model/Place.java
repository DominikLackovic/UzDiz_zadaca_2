package dlackovi2_zadaca_2.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dlackovi2
 */
public class Place implements Cloneable
{
    private int id;
    private String name;
    private int type;
    private int nSensors;
    private int nActuators;
    private boolean usable;
    private List<Device> devices = new ArrayList<Device>();
    
    public Place()
    {
        
    }

    public Place(String naziv, int tip, int brojSenzora, int brojAktuatora, boolean koristi)
    {
        this.name = naziv;
        this.type = tip;
        this.nSensors = brojSenzora;
        this.nActuators = brojAktuatora;
        this.usable = koristi;
    }

    public String getNaziv()
    {
        return name;
    }

    public void setNaziv(String naziv)
    {
        this.name = naziv;
    }

    public int getTip()
    {
        return type;
    }

    public void setTip(int tip)
    {
        this.type = tip;
    }

    public int getBrojSenzora()
    {
        return nSensors;
    }

    public void setBrojSenzora(int brojSenzora)
    {
        this.nSensors = brojSenzora;
    }

    public int getBrojAktuatora()
    {
        return nActuators;
    }

    public void setBrojAktuatora(int brojAktuatora)
    {
        this.nActuators = brojAktuatora;
    }

    public boolean isKoristi()
    {
        return usable;
    }

    public void setKoristi(boolean koristi)
    {
        this.usable = koristi;
    }
    
    public List<Device> getDevices()
    {
        return devices;
    }

    public void setDevices(List<Device> devices)
    {
        this.devices = devices;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }
    
    @Override
    public Object clone() throws CloneNotSupportedException
    {
        return this;
    }
}
