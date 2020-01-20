/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapNurtac.Controlador;

import CapNurtac.Entidades.CapAsigproyectosector;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author User
 */
@Stateless
public class CapAsigproyectosectorFacade extends AbstractFacade<CapAsigproyectosector> {

    @PersistenceContext(unitName = "CapNurtacPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CapAsigproyectosectorFacade() {
        super(CapAsigproyectosector.class);
    }
    
}
