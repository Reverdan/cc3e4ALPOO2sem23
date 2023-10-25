/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import modelo.Smartphone;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
CREATE TABLE `exercicio`.`smartphones` (
  `idsmartphone` INT NOT NULL AUTO_INCREMENT,
  `fabricante` VARCHAR(45) NULL,
  `modelo` VARCHAR(45) NULL,
  `sistemaOperacional` VARCHAR(45) NULL,
  `cor` VARCHAR(45) NULL,
  PRIMARY KEY (`idsmartphone`));
 */

public class SmartphoneDAO
{
    public String mensagem;
    Session session = Conexao.getSessionFactory().openSession();
    
    public void cadastrarSmartphome(Smartphone smartphone)
    {
        this.mensagem = "";
        try
        {
            session.beginTransaction();
            session.save(smartphone);
            session.getTransaction().commit();
            session.close();
            this.mensagem = "Smartphone cadastrado";
        }
        catch (HibernateException e)
        {
            this.mensagem = "Erro de BD";
        }
    }
}
