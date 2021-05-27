package pl.dixu.sa.server.view;

public interface Viewable {
   default CardAttributes toAttributes(){
       return new CardAttributes();
   }
}
