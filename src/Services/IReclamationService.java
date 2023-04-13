/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import java.util.List;

/**
 *
 * @author Hedi
 */
public interface IReclamationService<R> {
    public void ajoutReclamation(R r);
    public void modifierReclamation(R r, int id);
    public void supprimerReclamation(int id);
    public List<R> afficherReclamations();
}
