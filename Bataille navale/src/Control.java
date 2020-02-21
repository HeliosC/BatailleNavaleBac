import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.JOptionPane;


public class Control implements ActionListener{
	private String clic="-1";
	private Fenetre moi,lui;
	private Fenetre coord;
	//public int test=1;
	private int coord1[][] = new int[10][10];
	private int coord10[][] = new int[10][10];
	private int coord0[][] = new int[6][10]; 
	private int coord10aff[][] = new int[10][10];


	public Control(){

		moi=new Fenetre(this);
		moi.setTitle("MOI");

		coord1[5][0]=-3;
		moi.decale(coord1);

		lui=new Fenetre(this);
		lui.setTitle("LUI");

		init();

	}



	public static void main(String args[]){
		new Control();
	}

	public void init(){

		coord1[5][0]=-2;
		lui.updateAffichage2(coord1);
		coord=new Fenetre(this);


		Scanner sc = new Scanner(System.in);

		int x=0,y=0,s,t,b,d,b0,b1,J;
		//	b0=6;
		//	int coord0[][] = new int[6][10]; 
		int coord1[][] = new int[10][10];
		int coord2[][] = new int[10][10]; 
		int coule[]= new int [10]; // tableau pour vérification bateau coulé


		for(J=1;J<3;J=J+1){

			for(b0=5;b0>0;b0=b0-1){


				do{
					do{
						b=b0;
						if(b0==1)
							b=3;
						x=(int)(Math.random()*10);
						y=(int)(Math.random()*10);
						s=x;
						t=y;
					}while(coord2[x][y]!=0);

					d=(int)(Math.random()*4+1);

					while((coord2[x][y]==0)&&((b>1)&&(d!=0))){
						if((d==1)||(d==3)){
							x=x-d+2;}
						else{
							y=y-d+3;}
						b=b-1;
						if((x<0)||(y<0)||((x>9)||(y>9))){
							x=0;
							y=0;
							d=0;}
					}

				}while((coord2[x][y]!=0)||(d==0));
				coord0[0][-b0+5+5*(J-1)]=s;
				coord0[1][-b0+5+5*(J-1)]=t;
				coord0[2][-b0+5+5*(J-1)]=x;				//remplissage coord0
				coord0[3][-b0+5+5*(J-1)]=y;
				coord0[4][-b0+5+5*(J-1)]=d;

				//	System.out.print(x+" "+y+"/"+s+" "+t+"\n\n");


				//	}
				for(x=0;x<5;x=x+1){
					System.out.print(coord0[0][x]);		//Affichage coord0
					System.out.print(coord0[1][x]);
					System.out.print(coord0[2][x]);
					System.out.print(coord0[3][x]);
					System.out.print(coord0[4][x]+"\n ");
				}
				System.out.print("\n");

				//		for(b0=5;b0>0;b0=b0-1){
				b1=b0;
				if(b0==1)
					b1=3;
				s=coord0[0][-b0+5+5*(J-1)];				//Récup valeur coor0
				t=coord0[1][-b0+5+5*(J-1)];
				d=coord0[4][-b0+5+5*(J-1)];

				if(J==1)
					coord10aff[s][t]=d;

				x=s;
				y=t;
				coord2[x][y]=b0;
				for(b=b1;b>1;b=b-1){

					if((d==1)||(d==3)){				//remplissage grille (coord2)
						x=x-d+2;
						if(J==1)
							coord10aff[x][y]=5;}
					else{
						y=y-d+3;
						if(J==1)
							coord10aff[x][y]=6;}
					coord2[x][y]=b0;
				}

				if(J==1){
					if(d>2)
						d=d-2;
					else	  
						d=d+2;

					coord10aff[x][y]=d;}

			}
			System.out.println("\n");


			//		coord.updateAffichage3(coord0);
			moi.updateAffichage4(coord10aff);	

			for(y=0;y<10;y=y+1){
				for(x=0;x<10;x=x+1)
					System.out.print(coord1[x][y]+" ");			//Affichage des grilles 

				System.out.print("          ");
				for(x=0;x<10;x=x+1)
					System.out.print(coord10aff[x][y]+" ");

				System.out.print("\n");

			} 

			if (J==1){	
				for(y=0;y<10;y=y+1){
					for(x=0;x<10;x=x+1){
						coord1[x][y]=coord2[x][y];				//Transfert coord2 -> coord1
						coord2[x][y]=0;
					}}}
		}



		int coord10[][]=new int [10][10]; // tableau des tirs de J1
		int coord20[][]=new int [10][10]; // tableau des tirs de J2
		int i1=17,i2=17,mode,touche=0,xt=0,yt=0,x0=0,y0=0,change=0,d0=0;
		int i;


		//	System.out.println("1 ou 2 joueurs ?");
		//	mode=getClic();
		mode=1;
		do {
			d=10;
			System.out.println("\n\nTour de J1 :");
			J=1;
			do {
				do{
					//	System.out.println("i:");
					i=getClic();
					//		System.out.println("i="+i);
					y=(int)(i/10);
					x=i-10*y;
				}while(((x*y)<0)||((x>9)||(y>9)));
			}while(coord10[x][y]!=0);

			if (coord2[x][y]>0){
				System.out.print("Touché");
				i1=i1-1;
				b0=coord2[x][y];
				coule[b0-1]=coule[b0-1]+1;
				coord10[x][y]= coord2[x][y];
				coord2[x][y]= coord2[x][y]*10;
				b1=b0;
				if(b0==1)
					b1=3;
				if(coule[b0-1]==b1){
					System.out.println(" et coulé !");
					s=coord0[0][-b0+5+5*(-J+2)];
					t=coord0[1][-b0+5+5*(-J+2)];
					d=coord0[4][-b0+5+5*(-J+2)];
					x=s;
					y=t;
					coord2[x][y]=b0*100;
					coord10[x][y]=b0*100;
					for(b=b1;b>1;b=b-1){

						if((d==1)||(d==3)){
							x=x-d+2;}
						else{
							y=y-d+3;}
						coord2[x][y]=b0*100;
						coord10[x][y]=b0*100;}
				}
				else
					System.out.println(" !");

			}
			else{
				System.out.println("A l'eau !");
				coord10[x][y]=-1;
				coord2[x][y]= -1;}

			//	moi.updateAffichage(coord1);
			lui.updateAffichage(coord10);

			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


			if (i1!=0){
				System.out.println("\n\nTour de J2 :");
				//		+x0+" "+y0+" "+xt+" "+yt+" "+touche+" "+change+" "+d0);

				J=2;
				do {
					//				System.out.println("\nDEBUT"+x0+" "+y0+" "+xt+" "+yt+" "+touche+" "+change+" "+d0);

					d=10;
					if (mode==2){
						x= sc.nextInt();
						y= sc.nextInt();}
					else{
						x=(int)(Math.random()*10);
						y=(int)(Math.random()*10);}

					if(touche==1){
						do{
							do{
								x=x0;
								y=y0;
								d0=(int)(Math.random()*4+1);
								if((d0==1)||(d0==3)){
									x=x-d0+2;}
								else{
									y=y-d0+3;}
								if(! (((x*y)<0)||((x>9)||(y>9)))  ){
								if(coord10aff[x][y]<10)
									coord10aff[x][y]=10*coord10aff[x][y];}
							}while(((x*y)<0)||((x>9)||(y>9)));
						}while((coord20[x][y]<0)||(coord20[x][y]>9));
					}

					if(touche>1){
						x=xt;
						y=yt;
						if((d0==1)||(d0==3)){
							x=xt-d0+2;}
						else{
							y=yt-d0+3;}
						if(((x*y)<0)||((x>9)||(y>9))){
							x=0;
							y=0;
							d=0;
							/*	if(change==1){
							touche=0;
							change=0;}*/
						}
						else{
							if((! ((x*y)<0)||((x>9)||(y>9))) && coord10aff[x][y]<10  )
								coord10aff[x][y]=10*coord10aff[x][y];
						}

						//	if(d!=0){
						if(((coord20[x][y]!=0)||(coord20[xt][yt]==-1))||(d==0)){ // résoudre ici -> CONNERIES
							//		System.out.println("CHANGE");
							if(change==1){
								touche=0;
								change=0;}
							else{
								change=1;}
							xt=x0;
							yt=y0;
							x=xt;
							y=yt;

							if(d0>2)
								d0=d0-2;
							else	  //car si d=2 comment qu'on fait ? 
								d0=d0+2;
							//				System.out.println(x0+" "+y0+" "+xt+" "+yt+" "+touche+" "+change+" "+d0);

						}
						//		}
					}

				}while((coord20[x][y]!=0)||(d==0));}
			System.out.println(x+"  "+y);

			xt=x;
			yt=y;
			if (coord1[x][y]>0){
				touche=touche+1;
				if(touche==1){
					x0=x;
					y0=y;}
				System.out.print("Touché");
				if(coord10aff[x][y]<10)
					coord10aff[x][y]=10*coord10aff[x][y];
				i2=i2-1;
				b0=coord1[x][y];
				coule[b0+4]=coule[b0+4]+1;
				coord20[x][y]= coord1[x][y];
				coord1[x][y]= coord1[x][y]*10;
				b1=b0;
				if(b0==1)
					b1=3;
				if(coule[b0+4]==b1){
					System.out.println(" et coulé !");
					touche=0;
					change=0;
					s=coord0[0][-b0+5+5*(-J+2)];
					t=coord0[1][-b0+5+5*(-J+2)];
					d=coord0[4][-b0+5+5*(-J+2)];
					x=s;
					y=t;
					coord1[x][y]=b0*100;
					coord20[x][y]=b0*100;
					for(b=b1;b>1;b=b-1){

						if((d==1)||(d==3)){
							x=x-d+2;}
						else{
							y=y-d+3;}
						coord1[x][y]=b0*100;
						coord20[x][y]=b0*100;}}
				else
					System.out.println(" !");

			}
			else{
				System.out.println("A l'eau !");
				coord20[x][y]=-1;
				coord1[x][y]= -1;
				coord10aff[x][y]=-1;}





			System.out.println("\n");
			for(y=0;y<10;y=y+1){
				for(x=0;x<10;x=x+1){
					if(coord1[x][y]<100)
						System.out.print(" ");
					System.out.print(coord1[x][y]+" ");
					if((coord1[x][y]<10)&&(coord1[x][y]>-1))
						System.out.print(" ");		
				}

				System.out.print("                                     ");
				for(x=0;x<10;x=x+1)
					System.out.print(coord2[x][y]+" ");

				System.out.println("\n");} 

			System.out.print("\n");
			for(x=0;x<10;x=x+1){
				System.out.print(coule[x]+" ");	}



			System.out.println("\n\n");
			for(y=0;y<10;y=y+1){
				for(x=0;x<10;x=x+1){
					System.out.print(coord10aff[x][y]+" ");

				}

				System.out.print("          ");
				for(x=0;x<10;x=x+1)
					System.out.print(coord20[x][y]+" ");

				System.out.print("\n");} 


			System.out.print("\n");
			for(x=0;x<10;x=x+1){
				System.out.print(coule[x]+" ");	}


			moi.updateAffichage4(coord10aff);
			//	lui.updateAffichage(coord10);


		}while((i1!=0) && (i2!=0));


		if(i1==0){
			System.out.println("\n\nJ1 GAGNE ! ! !");
			JOptionPane.showMessageDialog(moi, "Joueur 1 gagne");}
		if(i2==0){
			System.out.println("\n\nJ2 GAGNE ! ! !");
			JOptionPane.showMessageDialog(moi, "Joueur 2 gagne");}




	}



	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println("actio : " + ((BoutonCustom)e.getSource()).getId());
		clic=((BoutonCustom)e.getSource()).getId();
		System.out.println("clic");
		//clic="13";
	}
	private int getClic(){
		clic = "-1";
		while(clic == "-1"){
			/*	System.out.println(clic);*/
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// on attend
		}
		return Integer.valueOf(clic);
	}

}



/*

if(coord1[x][y]<100)
	System.out.print(" ");
System.out.print(coord1[x][y]+" ");
if(coord1[x][y]<10)
	System.out.print(" ");






System.out.print(coord1[x][y]+" "); */
