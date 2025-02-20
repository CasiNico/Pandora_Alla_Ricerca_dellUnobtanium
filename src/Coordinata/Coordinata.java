package Coordinata;

public class Coordinata {

    private int lat, lang;

    public Coordinata(int lat, int lang){
        try{
            if (lat < -90 || lat > 90) {
                throw new IllegalArgumentException();
            }else{
                this.lat = lat;
            }
            if (lang < -180 || lang > 180){
                throw new IllegalArgumentException();
            }else{
                this.lang = lang;
            }
        }
        catch(IllegalArgumentException e){
            System.out.println("Problema: " + e.getMessage());
        }

    }

    public int getLat() {
        return lat;
    }
    public int getLang() {
        return lang;
    }
    public void setLat(int lat) {
        this.lat = lat;
    }
    public void setLang(int lang) {
        this.lang = lang;
    }
}
