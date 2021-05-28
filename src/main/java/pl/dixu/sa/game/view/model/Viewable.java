package pl.dixu.sa.game.view.model;

public interface Viewable {
   default CardAttributes toAttributes(){
       return new CardAttributes();
   }
}
