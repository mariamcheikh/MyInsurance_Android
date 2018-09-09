package esprit.tn.assuranceapp.Models;

/**
 * Created by Mariam on 21/12/2017.
 */

public class Contrat {
    private int id;
    private String serial_num;
    private String marque;
    private String modele;
    private String energie;
    private int	cv_fiscaux;
    private String immat;
    private String date_circul;


    public Contrat(int id, String serial_num, String marque, String modele, String energie, int cv_fiscaux, String immat, String date_circul) {
        this.id = id;
        this.serial_num = serial_num;
        this.marque = marque;
        this.modele = modele;
        this.energie = energie;
        this.cv_fiscaux = cv_fiscaux;
        this.immat = immat;
        this.date_circul = date_circul;
    }


    public Contrat() {
    }

    public Contrat(String serial_num, String marque, String modele, String energie, int cv_fiscaux, String immat, String date_circul) {
        this.serial_num = serial_num;
        this.marque = marque;
        this.modele = modele;
        this.energie = energie;
        this.cv_fiscaux = cv_fiscaux;
        this.immat = immat;
        this.date_circul = date_circul;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSerial_num() {
        return serial_num;
    }

    public void setSerial_num(String serial_num) {
        this.serial_num = serial_num;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public String getEnergie() {
        return energie;
    }

    public void setEnergie(String energie) {
        this.energie = energie;
    }

    public int getCv_fiscaux() {
        return cv_fiscaux;
    }

    public void setCv_fiscaux(int cv_fiscaux) {
        this.cv_fiscaux = cv_fiscaux;
    }

    public String getImmat() {
        return immat;
    }

    public void setImmat(String immat) {
        this.immat = immat;
    }

    public String getDate_circul() {
        return date_circul;
    }

    public void setDate_circul(String date_circul) {
        this.date_circul = date_circul;
    }
}
