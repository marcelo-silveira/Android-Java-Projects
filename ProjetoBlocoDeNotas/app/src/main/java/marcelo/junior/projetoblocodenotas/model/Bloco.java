package marcelo.junior.projetoblocodenotas.model;

public class Bloco {

    private String key;
    private String text;
    private String date;


    public Bloco() {

    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return  "\nKey: "+ key +
                "\nText: " + text +
                "\nDate: "+ date;
    }
}