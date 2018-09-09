package esprit.tn.assuranceapp.Models;

/**
 * Created by Mariam on 18/12/2017.
 */

public class Constat {

    private int id;
    private String date;
    private String lieu;
    private String nomConducteur;
    private String prenomConducteur;
    private String marquevoiture;
    private String immatriculation;
    private String nomConducteurA;
    private String prenomConducteurA;
    private String marquevoitureA;
    private String immatriculationA;


    public Constat() {
    }

    public Constat(String date, String lieu, String nomConducteur, String prenomConducteur, String marquevoiture, String immatriculation, String nomConducteurA, String prenomConducteurA, String marquevoitureA, String immatriculationA) {
        this.date = date;
        this.lieu = lieu;
        this.nomConducteur = nomConducteur;
        this.prenomConducteur = prenomConducteur;
        this.marquevoiture = marquevoiture;
        this.immatriculation = immatriculation;
        this.nomConducteurA = nomConducteurA;
        this.prenomConducteurA = prenomConducteurA;
        this.marquevoitureA = marquevoitureA;
        this.immatriculationA = immatriculationA;
    }

    public Constat(int id, String date, String lieu, String nomConducteur, String prenomConducteur, String marquevoiture, String immatriculation, String nomConducteurA, String prenomConducteurA, String marquevoitureA, String immatriculationA) {
        this.id = id;
        this.date = date;
        this.lieu = lieu;
        this.nomConducteur = nomConducteur;
        this.prenomConducteur = prenomConducteur;
        this.marquevoiture = marquevoiture;
        this.immatriculation = immatriculation;
        this.nomConducteurA = nomConducteurA;
        this.prenomConducteurA = prenomConducteurA;
        this.marquevoitureA = marquevoitureA;
        this.immatriculationA = immatriculationA;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public String getNomConducteur() {
        return nomConducteur;
    }

    public void setNomConducteur(String nomConducteur) {
        this.nomConducteur = nomConducteur;
    }

    public String getPrenomConducteur() {
        return prenomConducteur;
    }

    public void setPrenomConducteur(String prenomConducteur) {
        this.prenomConducteur = prenomConducteur;
    }

    public String getMarquevoiture() {
        return marquevoiture;
    }

    public void setMarquevoiture(String marquevoiture) {
        this.marquevoiture = marquevoiture;
    }

    public String getImmatriculation() {
        return immatriculation;
    }

    public void setImmatriculation(String immatriculation) {
        this.immatriculation = immatriculation;
    }

    public String getNomConducteurA() {
        return nomConducteurA;
    }

    public void setNomConducteurA(String nomConducteurA) {
        this.nomConducteurA = nomConducteurA;
    }

    public String getPrenomConducteurA() {
        return prenomConducteurA;
    }

    public void setPrenomConducteurA(String prenomConducteurA) {
        this.prenomConducteurA = prenomConducteurA;
    }

    public String getMarquevoitureA() {
        return marquevoitureA;
    }

    public void setMarquevoitureA(String marquevoitureA) {
        this.marquevoitureA = marquevoitureA;
    }

    public String getImmatriculationA() {
        return immatriculationA;
    }

    public void setImmatriculationA(String immatriculationA) {
        this.immatriculationA = immatriculationA;
    }
}
