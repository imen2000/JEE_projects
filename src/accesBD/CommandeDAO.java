package accesBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import beans.Commande;
import beans.Pizza;

public class CommandeDAO {
	
	public boolean ajouter(Commande c) throws SQLException {
		String req="insert into cmd(nom, prenom, adresse, total) values(?,?,?,?)";
		String req2="insert into pizza_cmd(id, nom) values(?,?)";
		
		Connection connect= Connexion.getInstance();
		int nouv=0;
		PreparedStatement stm= connect.prepareStatement(req,PreparedStatement.RETURN_GENERATED_KEYS);
		stm.setString(1, c.getNom());
		stm.setString(2, c.getPrénom());
		stm.setString(3, c.getAdresse());
		stm.setDouble(4, c.getPrixTotal());
		int n= stm.executeUpdate();
		ResultSet rs = stm.getGeneratedKeys();
        if (rs.next()) {
             // on récupère l'id généré
              nouv = rs.getInt(1);}
		
		if( n>0) {
			PreparedStatement stm2= connect.prepareStatement(req2);
			
			for(Pizza z:c.getListePizza()) {
				stm2.setInt(1, nouv);
				stm2.setString(2, z.getNom());
				n=stm2.executeUpdate();
				if(n==0)
					return false;
			}
			return true;
		};
		return false;
	}
	
	

}
