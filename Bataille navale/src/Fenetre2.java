import java.awt.GridLayout;

import javax.swing.JFrame;

public class Fenetre2 extends JFrame{

	private BoutonCustom[] tabBouton = new BoutonCustom[100];
	private Control affichage;
	private int i,x,y,xf,yf,d;

	public Fenetre2(Control aff){
		affichage=aff;
		this.setSize(500, 500);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		//	this.setTitle("La bataille c'est trop génial !");
		this.setLayout(new GridLayout(10,10));

		for(int i=0 ; i<100 ; i++){
			tabBouton[i] = new BoutonCustom(i);
			tabBouton[i].addActionListener(affichage);
			this.add(tabBouton[i]);
		}
	//	this.setVisible(true);


	}
	public void updateAffichage1(int[][] grille){
		i=0;
		x=grille[0][i];
		y=grille[1][i];
		xf=grille[2][i];
		yf=grille[3][i];
		d=grille[4][i];
		System.out.println("LALA "+x+" "+y+" "+xf+" "+yf);

		}
}