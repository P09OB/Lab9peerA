package main;

import java.util.ArrayList;

import com.google.gson.Gson;

import model.Coffe;
import model.Muffin;
import model.Sandwitch;
import model.Smoothie;
import processing.core.PApplet;
import processing.core.PImage;

public class Main extends PApplet implements onMessageListener {
	
	
	private UDPconection udp;
	
	private String product1= " ", product2=" ",product3=" ", product4=" ";
	private boolean imagen1=false, imagen2 = false, imagen3 = false, imagen4 = false;
	private String time;
	private int numero = 1;
	boolean cancelar;
	

	

	int posY =0;
	
	private ArrayList<Orden> orden;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		PApplet.main("main.Main");
		

	}
	
	public void settings() {
		size(500,500);
		
	}
	
	public void setup() {

		udp = new UDPconection();
		udp.setObserver(this);
		udp.start();
		orden = new ArrayList<Orden>();

		
	}
	
	public void draw() {
		
	
		background(255);
		
		
		
        for(int i =0; i<orden.size(); i++) {
		
			Orden orden1 = orden.get(i);
			
			
			if(orden1.getPosy() <= 500) {
			int aumentar = i*100;
			orden1.setPosy(aumentar);
			}	
			if(orden1.getPosy() == 500) {
				orden1.setPosx(300);
				orden1.setPosy(0);
				
			} if(orden1.getPosy()>= 500) {
				
				orden1.setPosx(300);
				int aumentar = i*100;
				aumentar -= 500;
				orden1.setPosy(aumentar);
			}
			
			if(i == 9) {
				cancelar = true;
			}
			orden1.pintar();
			orden1.setNumero(i+1);
			System.out.println(orden1.getPosy());
			
		}
		

       
        fill(0);
		
		 if(cancelar == true) {
	    		text("Limite de pedidos",250,250);
	    	}

		

		
	}
	
	public void mousePressed() {
		
		for(int i =0; i<orden.size(); i++) {
			
			orden.remove(i);
		}
		udp.sendMessage("peer A");
		System.out.println("enviado");
		
		
	}

	@Override
	public void messageTypeMuffin(Muffin or) {
		// TODO Auto-generated method stub
		
		this.product1 = or.getProducto();
		this.time = or.getHora();
		
		if(cancelar == false) {
		orden.add(new Orden(numero,or.getProducto(),or.getHora(),this));
		}
	}

	@Override
	public void messageTypeSandwitch(Sandwitch san) {
		// TODO Auto-generated method stub
		this.product2 = san.getProducto();
		this.time = san.getHora();
		if(cancelar == false) {
		orden.add(new Orden(numero,san.getProducto(),san.getHora(),this));
		}

	}

	@Override
	public void messageTypeCoffe(Coffe coffe) {
		// TODO Auto-generated method stub
		this.product3 = coffe.getProducto();
		this.time = coffe.getHora();
		if(cancelar == false) {
		orden.add(new Orden(numero,coffe.getProducto(),coffe.getHora(),this));
		}

		
	}

	@Override
	public void messageTypeSmoothie(Smoothie smoothie) {
		// TODO Auto-generated method stub
		this.product4 = smoothie.getProducto();
		this.time = smoothie.getHora();
		if(cancelar == false) {
		orden.add(new Orden(numero,smoothie.getProducto(),smoothie.getHora(),this));
		}

		
	}

	

	
}
