//Matthew Martin
//CS 110
//Final Homework

import java.util.ArrayList;
import java.util.List;

public class CardPile {
	private List<Card> pile = new ArrayList<Card>();
	
	public CardPile(){
		
	}
	

   //Adds card to playing pile
	public void addCard(Card card){
		this.pile.add(0, card);
	}
	

   //return size
	public int size(){
		return this.pile.size();
	}
	
   //Gets top card of playing pile
   //return Card removed
	public Card removeTopCard(){
		return this.pile.remove(0);
	}
	
	public void clear(){
		this.pile.clear();
	}
	

	//Gets list of all cards on pile
	public List<Card> getCards(){
		return this.pile;
	}
}
