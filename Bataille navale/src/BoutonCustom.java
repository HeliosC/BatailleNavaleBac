import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.JButton;

public class BoutonCustom extends JButton{
	
	private int id;
	private Image img = ImageEtat.VIDE.getImage();
	
	public BoutonCustom(int id){
		super();
		this.id = id;
	}
	public String getId(){
		return String.valueOf(id);
	}
	public void changetTexte(String str){
		this.setText(str);
	}
	public void changeImage(Image i){
		img=i;
	}
	public void paintComponent(Graphics g){
		  Graphics2D g2d = (Graphics2D)g;
		  g2d.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
		 }
}
