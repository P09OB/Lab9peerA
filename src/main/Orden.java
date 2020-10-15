package main;

import processing.core.PApplet;
import processing.core.PImage;

public class Orden {
	PApplet app;
	private PImage muffin, smoothie,sandwitch,coffe ;
    int numero;
	String producto,hora;
	int posx , posy;
	private boolean imagen1=false, imagen2 = false, imagen3 = false, imagen4 = false;

	
	
	public Orden(int numero, String producto, String hora, PApplet app ) {
		
		this.numero = numero;
		this.hora = hora;
		this.producto = producto;
		this.app = app;
		
		muffin = app.loadImage("Imag/appstore3.png");
		sandwitch = app.loadImage("Imag/appstore4.png");
		coffe = app.loadImage("Imag/appstore2.png");
		smoothie = app.loadImage("Imag/appstore1.png");
	
		
	}
	
	public void pintar() {
		app.fill(0);
		app.text("Orden"+numero+" "+producto,posx+100,posy+30);
		app.text(hora,posx+100,posy+50);

		
       if(producto.equals("Muffin")) {
			
			imagen1 = true;
			

		}
		
		if(producto.equals("Sandwitch")) {
			
			imagen2 = true;
			
		}
		
        if(producto.equals("Coffe")) {
			
			imagen3 = true;
			
		}
        
        if(producto.equals("Smoothie")) {
        	imagen4 = true;
        }

		
		
		
		if(imagen1 == true) {
			app.image(muffin,posx,posy);

		} if(imagen2 == true) {
			app.image(sandwitch,posx,posy);

		} if(imagen3 == true) {
			app.image(coffe,posx,posy);

		} if(imagen4 == true) {
			app.image(smoothie,posx,posy);

		}
		
	}
	
	

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getPosx() {
		return posx;
	}

	public void setPosx(int posx) {
		this.posx = posx;
	}

	public int getPosy() {
		return posy;
	}

	public void setPosy(int posy) {
		this.posy = posy;
	}
	
	
	
	
}
