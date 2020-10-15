package main;

import model.Coffe;
import model.Muffin;
import model.Sandwitch;
import model.Smoothie;

public interface onMessageListener {
	
	void messageTypeMuffin(Muffin or);
	void messageTypeSandwitch(Sandwitch san);
	void messageTypeCoffe(Coffe coffe);
	void messageTypeSmoothie(Smoothie smoothie);

	



}
