package PostazioneRDA;

import Coordinata.Coordinata;
import java.util.Random;

public class PostazioneRDA {
    private Random random = new Random();
    private Coordinata posizione;
    private int difesa = 100, ubRimanente;

    public PostazioneRDA(Coordinata posizione){
        this.posizione = posizione;
        difesa = 100;
        ubRimanente = 10;
    }

    public Coordinata getPosizione() {
        return posizione;
    }
    public int getDifesa() {
        return difesa;
    }
    public int getUbRimanente() {
        return ubRimanente;
    }

    public void riassegnamento(int caso){
        if(caso == 1){ // caso in cui la postazione viene distrutta
            posizione.setLat(random.nextInt(181) - 90);
            posizione.setLang(random.nextInt(361) - 180);
            difesa = 100;
            ubRimanente = 10;
        }else{ // nel caso in cui la postazione finisce di minari il unobtanium
            posizione.setLat(random.nextInt(181) - 90);
            posizione.setLang(random.nextInt(361) - 180);
            ubRimanente = 10;
        }

    }

    public void difendi (int danno) {
        try{
            if (difesa < danno){
                riassegnamento(1);
                throw new DifesaInsufficienteException();
            }
        }
        catch (DifesaInsufficienteException e){
            System.out.println("Problema: " + e.getMessage());
        }
        ubRimanente --;
        try {
            if (ubRimanente < 1) {
                System.out.println("Unobtarium esaurito, passare alla prossima posizione di scavo");
                riassegnamento(2);
                throw new UnobtaniumEsauritoException();
            }
        }
        catch(UnobtaniumEsauritoException e){
            System.out.println("Problema: " + e.getMessage());
        }
    }
}
