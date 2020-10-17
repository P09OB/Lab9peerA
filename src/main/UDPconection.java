package main;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

import com.google.gson.Gson;

import model.Coffe;
import model.Generic;
import model.Muffin;
import model.Sandwitch;
import model.Smoothie;

public class UDPconection extends Thread {
	
	private DatagramSocket socket;	
	private onMessageListener observer;
	
	public void setObserver(onMessageListener obs) {
		this.observer = obs;
		
	}
	
	public void run() {
		
		//ESCUCHAR 
		
		try {
		
			socket = new DatagramSocket(5000);
			
			//ESPERAR MENSAJE 
			
			while(true) {
				
				byte[] buffer = new byte [500];
				DatagramPacket packet = new DatagramPacket(buffer,buffer.length);
				System.out.println("Esperando datagrama....");
				socket.receive(packet);
				//SocketAddress ip = packet.getSocketAddress();
				//System.out.println(ip);

				String mensaje = new String(packet.getData()).trim();
				
				Gson gson = new Gson();
				Generic generic = gson.fromJson(mensaje,Generic.class);
				
				
				System.out.println("Tipo recibido..."+generic.type);
				
				switch(generic.type) {
				
				
				case "Muffin":
					
					Muffin muffin = gson.fromJson(mensaje, Muffin.class);
					observer.messageTypeMuffin(muffin);
					System.out.println("Datos..."+muffin.getProducto());

					
					break;
					
				case "Sandwitch":
					
					Sandwitch sandwitch = gson.fromJson(mensaje, Sandwitch.class);
					observer.messageTypeSandwitch(sandwitch);
					System.out.println("Datos..."+sandwitch.getProducto());
					
					break;
					
				case "Coffe":
					
					Coffe coffe = gson.fromJson(mensaje, Coffe.class);
					observer.messageTypeCoffe(coffe);
					System.out.println("Datos..."+coffe.getProducto());
					
					break;
					
				case "Smoothie":
					
					Smoothie smoothie = gson.fromJson(mensaje, Smoothie.class);
					observer.messageTypeSmoothie(smoothie);
					System.out.println("Datos..."+smoothie.getProducto());
					
					
					break;
			
				
				}

				
				
			}
			
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	
	public void sendMessage(String message) {
		
		new Thread(
				()->{
					
					try {
						InetAddress ip;
						ip = InetAddress.getByName("192.168.0.18");
						DatagramPacket packet = new DatagramPacket(message.getBytes(),message.getBytes().length, ip,6000);
						socket.send(packet);
						System.out.println("enviado");
						

						
					} catch (UnknownHostException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
				}
				
				).start();
		
		
		
		
		
		
		
		
		
		
	}

}
