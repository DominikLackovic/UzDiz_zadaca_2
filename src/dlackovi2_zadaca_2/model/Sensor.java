package dlackovi2_zadaca_2.model;

/**
 *
 * @author dlackovi2
 */
public class Sensor implements Cloneable, Device
{
    private int id;
    private String name;
    private int type;
    private String kind;
    private float minValue;
    private float maxValue;
    private String comment;
    
    public Sensor()
    {
        
    }

    public Sensor(String naziv, int tip, String vrsta, float minVrijednost, float maxVrijednost, String komentar)
    {
        this.name = naziv;
        this.type = tip;
        this.kind = vrsta;
        this.minValue = minVrijednost;
        this.maxValue = maxVrijednost;
        this.comment = komentar;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
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

    public String getVrsta()
    {
        return kind;
    }

    public void setVrsta(String vrsta)
    {
        this.kind = vrsta;
    }

    public float getMinVrijednost()
    {
        return minValue;
    }

    public void setMinVrijednost(float minVrijednost)
    {
        this.minValue = minVrijednost;
    }

    public float getMaxVrijednost()
    {
        return maxValue;
    }

    public void setMaxVrijednost(float maxVrijednost)
    {
        this.maxValue = maxVrijednost;
    }

    public String getKomentar()
    {
        return comment;
    }

    public void setKomentar(String komentar)
    {
        this.comment = komentar;
    }
    
    @Override
    public Object clone() throws CloneNotSupportedException
    {
        return this;
    }
}
