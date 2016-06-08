package danielandanthony.dungeonsanddragons;

/**
 * Generates Oriana's position, placeholder class for Mountain terrain in N2D6.
 */
public class Mountain extends Terrain{
    private Oriana oriana = null;
    public void setOriana (Oriana oriana) {
        this.oriana = oriana;
    }
    public Oriana getOriana () {
        return oriana;
    }
}
