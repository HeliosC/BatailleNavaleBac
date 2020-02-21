import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public enum ImageEtat{
	BATEAU("bateau.png"),
	TOUCHE("touche.png"),
	RATE("eau.png",-1),
	VIDE("vide.png",0),
	EXT1("ext1.png",1),
	EXT2("ext2.png",2),
	EXT3("ext3.png",3),
	EXT4("ext4.png",4),
	MILIMP("milimp.png",5),
	MILPAIR("milpair.png",6),
	EXT1T("ext1touche.png",10),
	EXT2T("ext2touche.png",20),
	EXT3T("ext3touche.png",30),
	EXT4T("ext4touche.png",40),
	MILIMPT("milimptouche.png",50),
	MILPAIRT("milpairtouche.png",60);

	Image image;
	int valeur=-12345;
	public int getValeur(){  
		return this.valeur;
	}
	private ImageEtat(String str){
		try {
			image = ImageIO.read(new File(str));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private ImageEtat(String str, int v){
		try {
			image = ImageIO.read(new File(str));
		this.valeur=v;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Image getImage(){
		return image;
	}
}
