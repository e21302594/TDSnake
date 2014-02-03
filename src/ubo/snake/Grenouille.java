package ubo.snake;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.util.Random;

public class Grenouille extends Case {

	private final static Random RND = new Random();

	private int angle;

	// Constructeur de l'objet grenouille avec coordonnées aléatoires
	public Grenouille() {
		super(getRandomX(), getRandomY());
	}

	// Récupérer un nombre aléatoire en abscisse
	private static int getRandomX() {
		return RND.nextInt(NBRE_DE_COLONNES);
	}

	// Récupérer un nombre aléatoire en ordonnée
	private static int getRandomY() {
		return RND.nextInt(NBRE_DE_LIGNES);
	}

	// Placer une nouvelle grenouille avec des coordoonées aléatoires
	public void nouvelleGrenouille() {
		setIndiceX(getRandomX());
		setIndiceY(getRandomY());
		this.angle = 0;
	}

	public void calcul() {
		// incrémentation de l'angle de 4 degrés
		int old_angle=angle;
		this.angle += 4;
		assert old_angle==angle+4 : "Probleme d'incrementation de l'angle";
	}

	public void affichage(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		// objet initial
		AffineTransform tr = g2.getTransform();
		g.setColor(Color.RED);
		// rotation
		g2.setTransform(AffineTransform.getRotateInstance(
				Math.toRadians(this.angle), getX() + (getLargeur() / 2), getY()
						+ (getHauteur() / 2)));
		g.fillRect(getX() + 2, getY() + 2, getLargeur() - 4, getHauteur() - 4);
		// annulation de la rotation
		g2.setTransform(tr);
	}

}
