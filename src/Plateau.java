import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;


public class Plateau extends JPanel implements MouseMotionListener, KeyListener{
	
	private int mx;
	private int my;
	private int hauteur;
	private int largeur;
	private int taille;
	private int couleurChoisie;
	
	private int[][] plateau;
	
	private JPanel barreCouleur;
	
	public Plateau(int x, int y, int taille){
		hauteur = y;
		largeur = x;
		this.taille = taille;
		couleurChoisie = 0;
		
		setFocusable(true);
		requestFocusInWindow();
		addMouseMotionListener(this);
		addKeyListener(this);
		
		plateau = new int[hauteur][largeur];
		clear();
		barreCouleur = new JPanel();
		barreCouleur();
		setPreferredSize(new Dimension(largeur*taille, hauteur*taille));
		
	}
	
	public int getHauteur() {
		return hauteur;
	}

	public void setHauteur(int hauteur) {
		this.hauteur = hauteur;
	}

	public int getLargeur() {
		return largeur;
	}

	public void setLargeur(int largeur) {
		this.largeur = largeur;
	}

	public int getTaille() {
		return taille;
	}

	public void setTaille(int taille) {
		this.taille = taille;
	}

	public int[][] getPlateau() {
		return plateau;
	}

	public void setPlateau(int[][] plateau) {
		this.plateau = plateau;
	}

	public void paintComponent(Graphics g){
	
		for(int hauteur = 0; hauteur < this.hauteur; hauteur++){
			for(int largeur = 0; largeur < this.largeur; largeur++){
				if(plateau[hauteur][largeur] == 0){
					g.setColor(Color.WHITE);
				}else if(plateau[hauteur][largeur] == 1){
					g.setColor(Color.YELLOW);
				}else if(plateau[hauteur][largeur] == 2){
					g.setColor(Color.RED);
				}else if(plateau[hauteur][largeur] == 3){
					g.setColor(Color.BLUE);
				}else if(plateau[hauteur][largeur] == 4){
					g.setColor(Color.PINK);
				}else if(plateau[hauteur][largeur] == 5){
					g.setColor(Color.ORANGE);
				}else if(plateau[hauteur][largeur] == 6){
					g.setColor(Color.GRAY);
				}else if(plateau[hauteur][largeur] == 7){
					g.setColor(Color.MAGENTA);
				}else if(plateau[hauteur][largeur] == 8){
					g.setColor(Color.GREEN);
				}
				
				g.fillRect(largeur*taille, hauteur*taille, taille, taille);
				//g.setColor(Color.BLACK);
				//g.drawRect(largeur*taille, hauteur*taille, taille, taille);
			}
		}
		g.setColor(Color.WHITE);
		g.fillRect(mx*taille, my*taille, taille, taille);
		g.setColor(Color.BLACK);
		g.drawRect(mx*taille, my*taille, taille, taille);
	}
	
	public void barreCouleur(){
		barreCouleur.setLayout(new GridLayout(1, 9));
		
		JButton b1 = new JButton();
		b1.setBackground(Color.WHITE);
		JButton b2 = new JButton();
		b2.setBackground(Color.YELLOW);
		JButton b3 = new JButton();
		b3.setBackground(Color.RED);
		JButton b4 = new JButton();
		b4.setBackground(Color.BLUE);
		JButton b5 = new JButton();
		b5.setBackground(Color.PINK);
		JButton b6 = new JButton();
		b6.setBackground(Color.ORANGE);
		JButton b7 = new JButton();
		b7.setBackground(Color.GRAY);
		JButton b8 = new JButton();
		b8.setBackground(Color.MAGENTA);
		JButton b9 = new JButton();
		b9.setBackground(Color.GREEN);
		
		b1.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent arg0) {
				couleurChoisie = 0;
				
			}
		});
		b2.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent arg0) {
				couleurChoisie = 1;
				
			}
		});
		b3.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent arg0) {
				couleurChoisie = 2;
				
			}
		});
		b4.addMouseListener(new MouseAdapter() {
	
			public void mouseClicked(MouseEvent arg0) {
				couleurChoisie = 3;
		
			}
		});
		b5.addMouseListener(new MouseAdapter() {
	
			public void mouseClicked(MouseEvent arg0) {
				couleurChoisie = 4;
		
			}
		});
		b6.addMouseListener(new MouseAdapter() {
	
			public void mouseClicked(MouseEvent arg0) {
				couleurChoisie = 5;
		
		}
		});
		b7.addMouseListener(new MouseAdapter() {
	
			public void mouseClicked(MouseEvent arg0) {
				couleurChoisie = 6;
		
			}
		});
		b8.addMouseListener(new MouseAdapter() {
	
			public void mouseClicked(MouseEvent arg0) {
				couleurChoisie = 7;
		
			}
		});
		b9.addMouseListener(new MouseAdapter() {
	
			public void mouseClicked(MouseEvent arg0) {
				couleurChoisie = 8;
		
			}
		});

		
		barreCouleur.add(b1);
		barreCouleur.add(b2);
		barreCouleur.add(b3);
		barreCouleur.add(b4);
		barreCouleur.add(b5);
		barreCouleur.add(b6);
		barreCouleur.add(b7);
		barreCouleur.add(b8);
		barreCouleur.add(b9);		
		
	}
	
	public void changeCouleur(int x, int y, int numCouleur){
		plateau[y][x] = couleurChoisie;
		repaint();
	}
	
	public void clear(){
		for(int hauteur = 0; hauteur < this.hauteur; hauteur++){
			for(int largeur = 0; largeur < this.largeur; largeur++){
				plateau[hauteur][largeur] = 0;
			}
		}
		repaint();
	}

	public int getCouleurChoisie() {
		return couleurChoisie;
	}

	public JPanel getBarreCouleur() {
		return barreCouleur;
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		mx = e.getX()/taille;
		my = e.getY()/taille;
		changeCouleur(mx, my, 2);
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		mx = e.getX()/taille;
		my = e.getY()/taille;
		repaint();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyChar() == 'c'){
			clear();
		}else if(e.getKeyChar() == 'œ'){
			couleurChoisie = 0;
		}else if(e.getKeyChar() == '&'){
			couleurChoisie = 1;
		}else if(e.getKeyChar() == 'é'){
			couleurChoisie = 2;
		}else if(e.getKeyChar() == '\"'){
			couleurChoisie = 3;
		}else if(e.getKeyChar() == '\''){
			couleurChoisie = 4;
		}else if(e.getKeyChar() == '('){
			couleurChoisie = 5;
		}else if(e.getKeyChar() == '-'){
			couleurChoisie = 6;
		}else if(e.getKeyChar() == 'è'){
			couleurChoisie = 7;
		}else if(e.getKeyChar() == '_'){
			couleurChoisie = 8;
		}
		System.out.println(e.getKeyChar());
	}
}
