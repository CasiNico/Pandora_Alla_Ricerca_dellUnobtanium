package Avatar;

import java.util.Random;

public class Avatar {
    private Random random = new Random();
    private String nome, arma;
    private int forzaAttacco;
    private boolean possibilitaAttacco;
    
    public Avatar(String nome, String arma) {
        this.nome = nome;
        this.arma = arma;
        forzaAttacco = 3;
    }

    public int getForzaAttacco() {
        return forzaAttacco;
    }
    public String getArma() {
        return arma;
    }
    public String getNome() {
        return nome;
    }

    public int attacca(PostazioneRDA.PostazioneRDA p){
        try{
            possibilitaAttacco = random.nextBoolean(); // 1/2 di possibilità di riuscire ad attacccare
            if (!possibilitaAttacco)
                throw new ArmaMalfunzionanteException();
        }
        catch (ArmaMalfunzionanteException e) {
            System.out.println("Problema: " + e.getMessage());
        }
        return forzaAttacco;
    }
}
