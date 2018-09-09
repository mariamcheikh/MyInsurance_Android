package esprit.tn.assuranceapp;

/**
 * Created by Hamza FAIZA on 07/10/2017.
 */

public class User {

    private String fname;
    private String veh_mark;
    private String lname;
    private String phone;
    private String veh_modele;
    private String veh_number;
    private String ville;

    public User() {
    }

    public User(String fname, String veh_mark, String lname, String phone, String veh_modele, String veh_number, String ville) {
        this.fname = fname;
        this.veh_mark = veh_mark;
        this.lname = lname;
        this.phone = phone;
        this.veh_modele = veh_modele;
        this.veh_number = veh_number;
        this.ville = ville;
    }

    public User(String name, String country) {
        this.fname = name;
        this.veh_mark = country;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getVeh_modele() {
        return veh_modele;
    }

    public void setVeh_modele(String veh_modele) {
        this.veh_modele = veh_modele;
    }

    public String getVeh_number() {
        return veh_number;
    }

    public void setVeh_number(String veh_number) {
        this.veh_number = veh_number;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getVeh_mark() {
        return veh_mark;
    }

    public void setVeh_mark(String veh_mark) {
        this.veh_mark = veh_mark;
    }


}
