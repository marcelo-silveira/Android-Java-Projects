package marcelo.junior.exradiobuttoncheckboxmanha.model;

import java.util.ArrayList;

public class Person {

    private String name;
    private String gender;
    private ArrayList<String> prefs;

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public ArrayList<String> getPrefs() {
        return prefs;
    }

    public void setPrefs(ArrayList<String> prefs) {
        this.prefs = prefs;
    }

    public String verifyGender(){
        if(gender.equals("Male")){
            return "You're a man!";
        }else if(gender.equals("Female")){
            return "You're a woman!";
        }else{ return ""; }
    }

    public double verifyIMC(){
        if(gender.equals("Male")){
            return 12.12*1234;
        }else if(gender.equals("Female")){
            return 12.12*1234;
        }else{ return 0; }
    }

    @Override
    public String toString() {
        return "\nName = " + name +
                "\nGender = " + gender +
                "\nPrefs = " + prefs +
                "\nVerify gender = " + verifyGender();
    }
}//fecha classe
