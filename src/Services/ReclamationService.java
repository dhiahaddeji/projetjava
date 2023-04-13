/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import java.util.List;
import Entities.Reclamation;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.MyDB;

/**
 *
 * @author Hedi
 */
public class ReclamationService implements IReclamationService<Reclamation>{
    
    Connection cnx;

    public ReclamationService() {
        cnx = MyDB.getInstance().getConnection();
    }

    @Override
    public void ajoutReclamation(Reclamation r) {
        try {
            String req = "INSERT INTO reclamation (description, date, type, etat) "
                    + "VALUES (?, ?, ?, ?);";
            PreparedStatement ps = cnx.prepareStatement(req);

            ps.setString(1, r.getDescription());
            ps.setString(2, r.getDate());
            ps.setString(3, r.getType());
            ps.setString(4, r.getEtat());

            int value = ps.executeUpdate();
            if (value > 0) {
                System.out.println("L'insertion du reclamaion:" + r.getDate()+ " a été effectué avec succès !!!");
            }

        } catch (SQLException ex) {
            Logger.getLogger(ReclamationService.class.getName()).log(Level.SEVERE, null, ex);
        }    }

    @Override
    public void modifierReclamation(Reclamation r, int id) {                
        try {
            String req = "UPDATE reclamation SET description=?,date=?,type=?,etat=?"
                    + "WHERE id=" + id;

            PreparedStatement ps = cnx.prepareStatement(req);
            
            ps.setString(1, r.getDescription());
            ps.setString(2, r.getDate());
            ps.setString(3, r.getType());
            ps.setString(4, r.getEtat());

            int value = ps.executeUpdate();
            if (value > 0) {
                System.out.println("La modification de la réclamation nommé:" + r.getDescription()+ " a été effectué avec succès !!!");
            }

        } catch (SQLException ex) {
            Logger.getLogger(ReclamationService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void supprimerReclamation(int id) {
        try {
            String req = "DELETE FROM reclamation WHERE id = ?";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, id);
            int value_supp = ps.executeUpdate();
            if (value_supp > 0) {
                System.out.println("Suppression a été effectuée avec succès");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReclamationService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Reclamation> afficherReclamations() {
        System.out.println("Liste des réclamations: \n");
        List<Reclamation> list = new ArrayList<>();

        try {
            String req = "select * from reclamation";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                Reclamation rec = new Reclamation();
                rec.setId(rs.getInt(1));
                rec.setDescription(rs.getString(2));
                rec.setDate(rs.getString(3));
                rec.setType(rs.getString(4));
                rec.setEtat(rs.getString(5));

                list.add(rec);
                System.out.println(rec);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return list;
    }
    
}
