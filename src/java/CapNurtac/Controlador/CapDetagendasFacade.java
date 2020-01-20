/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapNurtac.Controlador;

import CapNurtac.Entidades.CapDetagendas;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author User
 */
@Stateless
public class CapDetagendasFacade extends AbstractFacade<CapDetagendas> {

    @PersistenceContext(unitName = "CapNurtacPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CapDetagendasFacade() {
        super(CapDetagendas.class);
    }
    
}
