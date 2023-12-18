
import java.awt.Color;
import java.awt.Graphics;

public class Zelle {
	private int breite;
	private int hoehe;
	private int x = 0;
	private int y = 0;
	private final Color farbeTot = Color.BLACK;
	private final Color farbeLebendig = Color.GREEN;
	private boolean isLebendig;
	private Color farbeRand;
	
	public Zelle() {
		this(0, 0, 0, 0, true, null);
	}
	public Zelle(int _x, int _y, boolean _lebendig) {
		this(_x, _y, 0, 0, _lebendig, Color.ORANGE);
	}
	public Zelle(int _x, int _y, int _hoehe, int _breite, boolean _lebendig) {
		this(_x, _y, _breite, _hoehe, _lebendig, Color.ORANGE);
	}
	public Zelle(int _x, int _y, int _hoehe, int _breite, boolean _lebendig, Color _farbe) {
		this.x = _x;
		this.y = _y;
		this.hoehe = _hoehe;
		this.breite = _breite;
		this.isLebendig = _lebendig;
		this.farbeRand = _farbe;
		
	}
	
	public void paint(Graphics g) {
		if(isLebendig) {
			g.setColor(farbeLebendig);
			g.fillRect(this.x, this.y, this.hoehe, this.breite);
		} else {
			g.setColor(farbeTot);
			g.fillRect(this.x, this.y, this.breite, this.hoehe);
		}
		
		// farbe fuer Rand festlegen
		g.setColor(this.farbeRand);
		g.drawRect(this.x, this.y, this.breite, this.hoehe);
	}
	// Setter Farbe
	public void setFarbe(Color _farbe) {
		this.farbeRand = _farbe;
	}
	// SetterGetter isLebendig
	public boolean istLebendig() {
		return isLebendig;
	}
	public void setLebendig(boolean lebendig) {
		this.isLebendig = lebendig;
	}
	// Getter isClicked
	public void isClicked(int x, int y) {
		if(x >= this.x && x < this.x + breite && y>= this.y && y < this.y + hoehe) {
			setLebendig(!isLebendig);
		}
	}
	//SetterGetter X
	public int getX() {
		return this.x;
	}
	public void setX(int _x) {
		this.x = _x;
	}
	//SetterGetter Y
	public int getY() {
		return this.y;
	}
	public void setY(int _y) {
		this.y = _y;
	}
	//Setter Getter Breite
	public int getBreite() {
		return this.breite;
	}
//	public void setBreit(int breite) {
//		this.breite = breite;
//	}
	//SetterGetter Hoehe
	public int getHoehe() {
		return this.hoehe;
	}
//	public void setHoehe(int hoehe) {
//		this.hoehe = hoehe;
//	}
	
	
	
		
		
	
}
