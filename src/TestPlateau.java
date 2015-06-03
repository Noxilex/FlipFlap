import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JFrame;


public class TestPlateau {

	public static void main(String[] args) {
		Plateau p = new Plateau(100,100,5);
		JFrame f = new JFrame("Test");
		f.addNotify();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = f.getContentPane();
		c.setLayout(new GridLayout(3, 1));
		c.add(p.getBarreCouleur());
		c.add(p);
		f.pack();
		f.setVisible(true);
	}
}