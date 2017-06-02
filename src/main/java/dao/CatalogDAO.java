package dao;

import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import vo.CatalogVO;

public class CatalogDAO {
    
    private Connection conexion;

    public CatalogDAO() throws URISyntaxException {
        this.conexion = Conexion.getConnection();
    }
    
    public boolean insertar(CatalogVO catalog) {
        boolean resultado = false;
        try {
            //1.Establecer la consulta
            String consulta = "INSERT INTO Catalogs VALUES(?,?,?)";
            //2. Crear el PreparedStament
            PreparedStatement statement
                    = this.conexion.prepareStatement(consulta);
            //-----------------------------------
            statement.setInt(1, catalog.getsID());
            statement.setInt(2, catalog.getpID());
            statement.setInt(3, catalog.getCost());
            //--------------------------------------
            //3. Hacer la ejecucion
            System.out.println("metió");
            resultado = statement.execute();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return resultado;
    }
    
    public ArrayList totalCost() {
        ArrayList resultado = null;
        int id = 0;
        int costo = 0;
        try {
            //1.Establecer la consulta
            String consulta = "SELECT sID, cost FROM Catalogs group by sID";
            //2. Crear el PreparedStament
            Statement statement = this.conexion.createStatement();
            ResultSet rs = statement.executeQuery(consulta);
            //-----------------------------------
            while (rs.next()) {
                id = rs.getInt("sID");

                
                costo = rs.getInt("cost");
                resultado.add(id);
                resultado.add(costo);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return resultado;
    }
}