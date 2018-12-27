package marcelo.junior.ex_cinema.model;

import java.util.ArrayList;

public class Movie {
    private String MovieName;
    private String mType;
    private float ev;



    public Movie() {
    }

    public String getMovieName() {
        return MovieName;
    }

    public void setMovieName(String movieName) {
        MovieName = movieName;
    }

    public String getmType() {
        return mType;
    }

    public void setmType(String mType) {
        this.mType = mType;
    }

    public float getEv() {
        return ev;
    }

    public void setEv(float ev) {
        this.ev = ev;
    }


    public String verifyType(){
        if(mType.equals("Horror")){
            return "Horror";
        }else if (mType.equals("Action")){
            return "Action";
        }else if (mType.equals("Thriller")){
            return "Thriller";
        }else if (mType.equals("Comedy")){
            return "Comedy";
        }else if (mType.equals("Romance")){
            return "Romance";
        }else{ return "";}
    }


    @Override
    public String toString() {
        return
                "\nMovie Name = " + MovieName +
                "\nMovie Type = " + mType +
                "\nRating = " + ev;
    }
}
