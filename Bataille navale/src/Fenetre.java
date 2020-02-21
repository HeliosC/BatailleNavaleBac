import java.awt.GridLayout;

import javax.swing.JFrame;


public class Fenetre extends JFrame{

	private BoutonCustom[] tabBouton = new BoutonCustom[100];
	private Control affichage;
	//private int i;
	private static int x,y,xf,yf,d;
	private static int visible=1,j=0;
	private static int taille=500;



	public void updateAffichage2(int[][] grille){
		if(grille[5][0] == -2){
			visible=0;}}
	
	public void decale(int[][] grille){
		if(grille[5][0] == -3){
			j=1;}}

	
	
	public Fenetre(Control aff){
		affichage=aff;
		this.setSize(taille,taille);
		this.setLocation(j*(taille-14)-7, 0);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		//	this.setTitle("La bataille c'est trop génial !");
		this.setLayout(new GridLayout(10,10));

		for(int i=0 ; i<100 ; i++){
			tabBouton[i] = new BoutonCustom(i);
			tabBouton[i].addActionListener(affichage);
			this.add(tabBouton[i]);
		}
		System.out.println("7 "+visible);
		if(visible == 1){
			this.setVisible(true);
			System.out.println("6 "+visible);
		}

	}





	///*
	public void updateAffichage3(int[][] grille){
		int i=0;
		x=grille[0][i];
		y=grille[1][i];
		xf=grille[2][i];
		yf=grille[3][i];
		d=grille[4][i];
		System.out.print("LALA "+x+" "+y+" "+xf+" "+yf);
		System.out.println(" "+d);

	}
	//*/
	public void updateAffichage(int[][] grille){

		for(int y=0;y<10;y++){
			for(int x=0;x<10;x++){
				if(grille[x][y] == -1){
					tabBouton[10*y+x].changeImage(ImageEtat.RATE.getImage());
				}else if(grille[x][y] > 0 && grille[x][y]<=9){
					tabBouton[10*y+x].changeImage(ImageEtat.BATEAU.getImage());
				}else if(grille[x][y] > 9){
					tabBouton[10*y+x].changeImage(ImageEtat.TOUCHE.getImage());
				}
				tabBouton[10*y+x].repaint();
			}
		}	
	}

	public void updateAffichage4(int[][] grille){
		for(int y=0;y<10;y++){
			for(int x=0;x<10;x++){
				d=grille[x][y];
				for(ImageEtat i : ImageEtat.values()){
					if(d == i.getValeur()){
						tabBouton[10*y+x].changeImage(i.getImage());
						tabBouton[10*y+x].repaint();
					}
				}

			}
		}
		/* 	System.out.print("LALALA"+x+" "+y+" "+xf+" "+yf);
	 	System.out.println(" "+d);
		if(d==1){
			tabBouton[10*y+x].changeImage(ImageEtat.EXT(valeur de d).getImage());
			tabBouton[10*y+x].repaint();
			tabBouton[10*yf+xf].changeImage(ImageEtat.EXT3.getImage());
		}
		if(d==2){
			tabBouton[10*y+x].changeImage(ImageEtat.EXT2.getImage());
			tabBouton[10*y+x].repaint();
			tabBouton[10*yf+xf].changeImage(ImageEtat.EXT4.getImage());
		}
		if(d==3){
			tabBouton[10*y+x].changeImage(ImageEtat.EXT3.getImage());
			tabBouton[10*y+x].repaint();
			tabBouton[10*yf+xf].changeImage(ImageEtat.EXT1.getImage());
		}
		if(d==4){
			tabBouton[10*y+x].changeImage(ImageEtat.EXT4.getImage());
			tabBouton[10*y+x].repaint();
			tabBouton[10*yf+xf].changeImage(ImageEtat.EXT2.getImage());
		}


		tabBouton[10*yf+xf].repaint(); */


	}




}
