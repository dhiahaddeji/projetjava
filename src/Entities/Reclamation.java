/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author Hedi
 */
public class Reclamation {
    
    private int id;
    private String description;
    private String date;
    private String type;
    private String etat;

    public Reclamation() {
    }

    public Reclamation(int id, String description, String date, String type, String etat) {
        this.id = id;
        this.description = description;
        this.date = date;
        this.type = type;
        this.etat = etat;
    }

    public Reclamation(String description, String date, String type, String etat) {
        this.description = description;
        this.date = date;
        this.type = type;
        this.etat = etat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    @Override
    public String toString() {
        return "Reclamation{" + "id=" + id + ", description=" + description + ", date=" + date + ", type=" + type + ", etat=" + etat + '}';
    }
    
}
