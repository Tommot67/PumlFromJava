package Lib;
public class Substantif {
    private String nom;
    private Genre genre;

    public Substantif(String nom , Genre genre){
        this.nom = nom;
        this.genre = genre;
    }
    public String getNom(){return this.nom;}
    public Genre getGenre(){
        return this.genre;
    }
    public boolean voyelleAtStart(){
        return ("aeouiyh").contains(String.valueOf(this.nom.charAt(0)));
    }
    public String getArticleDefini(){
        /*
        String article;
        if(this.voyelleAtStart()){
            article = "l'";
        }
        else if(this.genre == Genre.FEMININ){
            article = "la";
        }
        else {
            article = "le";
        }
        return article;
        */
        return this.voyelleAtStart() == true ? "l'" : this.genre == Genre.FEMININ ? "la" : "le";
    }
    public String avecArticleDefini(){
        return this.getArticleDefini() + " " + this.nom;
    }
    public String getArticleIndefini(){
        /*
        String article;
        if(this.genre == Genre.FEMININ){
            article = "une";
        }
        else {
            article = "un";
        }
        return article;
        */
        return this.genre == Genre.FEMININ ? "une" : "un";
    }
    public String avecArticleIndefini(){
        return this.getArticleIndefini() + " " + this.nom;
    }

    public String getArticlePartitif(){
        /*
        if(this.voyelleAtStart()){
            return "de l'";
        }
        else if (this.genre == Genre.FEMININ) {
            return "de la";
        }
        else{
            return "du";
        }
        */
        return this.voyelleAtStart() == true ? "de l'" : this.genre == Genre.FEMININ ? "de la" : "du";
    }
    public String avecArticlePartitif(){
        return this.getArticlePartitif() + " " + this.nom;
    }
    public String getPréposition(){
        /*
        if(this.voyelleAtStart()){
            return "d' ";
        }
        else{
            return "de ";
        }
        */
         return this.voyelleAtStart() == true ? "d'" : "de";
    }
    public String avecPréposition(){
        return this.getPréposition() + " " + this.nom;
    }
}
