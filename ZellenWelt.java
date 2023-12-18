

import java.awt.Graphics;
import java.awt.event.MouseEvent;


/**
 * Die Zellenwelt dient dazu Zellen als Matrix zuzeichnen und beim Klicken einer
 * Zelle, diese wieder zuzeichnen.
 * 
 * @author schmidt
 *
 */
// Zeilenkommentare dienen der Programmerklärung zu Lehrzwecken und sind keine typischen Entwicklerkommentare
public class ZellenWelt extends ZellenWeltBasis {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final int BREITE = 40;
	private final int HOEHE = 40;
	private final int ANZ_ZEILEN_ZELLEN = 6;
	private final int ANZ_SPALTEN_ZELLEN = 6;

	private Zelle zellen[][]; // Referenzvariable für die Zellen als Matrix

	// Die init-Methode dient der allgemeine Initialisierung,
	// um z. B. die Groesse des Fensters festzulegen.
	//
	/**
	 * Konstruktor 
	 * dient der Initialisierung der Zellen und legt die Groesse des Fensters.
	 */
	public ZellenWelt() {
		super(); // bitte nicht ändern
		int xpos = 0; // Startposition 0 ist links
		int ypos = 0; // Startposition 0 ist oben

		// Speicher für die Zellen reservieren
		zellen = new Zelle[ANZ_ZEILEN_ZELLEN][ANZ_SPALTEN_ZELLEN];

		// Zellen als Schachbrett positionieren
		for (int i = 0; i < zellen.length; i++) { // Position in y-Richtung durchlaufen
			for (int j = 0; j < zellen[i].length; j++) { // Position in x-Richtung durchlaufen
				zellen[i][j] = new Zelle(xpos, ypos, BREITE, HOEHE, true); // Objekterzeugung durch Konstruktoraufruf
				xpos = xpos + BREITE; // nächste Position in x-Richtung berechnen
			}
			ypos = ypos + HOEHE; // nächste Position in y-Richtung berechnen
			xpos = 0; // Position in x-Richtung beginnt wieder von links
		}
	}

	/**
	 * ruft private Methode mouseClicked (siehe unten) mit aktuellen x,y-Koordinaten
	 * der Curserposition auf, wenn geklickt wurde.
	 */
	public void mouseClicked(MouseEvent e) {
		int x, y;

		x = e.getX();
		y = e.getY();

		mouseClicked(x, y); // Methodenaufruf
	}

	// Private Methode zum Reagieren auf einen Klick.
	// Geht jede Zelle durch und ruft ihre Reaktion auf das Klicken auf
	// Danach werde die Zellen neu gezeichnet
	private void mouseClicked(int x, int y) {
		for (int i = 0; i < zellen.length; i++) {
			for (int j = 0; j < zellen[i].length; j++) {
				zellen[i][j].isClicked(x, y);
			}
		}
		repaint(); // Methodenaufruf zum neu Zeichnen
		// Die repaint-Methode ruft die paint-Methode auf.
		// Es wird nie die paint-Methode direkt aufgerufen!
	}

	/**
	 * Zeichnet die Zellen.
	 * 
	 * @param g Grafikkontext auf dem die Zellen gezeichnet werden.
	 */
	@Override
	protected void paintComponent(final Graphics g) {
		super.paintComponent(g); // bitte nicht ändern

		for (int i = 0; i < zellen.length; i++) {
			for (int j = 0; j < zellen[i].length; j++) {
				zellen[i][j].paint(g);
			}
		}
	}
}