package dao;

import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ColmenitaDAO {
    
    public int alimento(){
        int total = 0;
        try {
            String query = "select NUMPALIMENTO from Colmenas where ID = 1";
            Connection connection = null;
            try {
                connection = Conexion.getConnection();
            } catch (URISyntaxException ex) {
                ex.printStackTrace();
            }
            
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()){
                
               total = rs.getInt("NUMPALIMENTO");
               
            }
            
        } catch (SQLException ex) {
            
        } 
         return total;
    }
    
    public ArrayList kilosMiel(){
        ArrayList miel = new ArrayList();
        int id = 0;
        int kilos = 0;
        try {
            String query = "select ID, kilosMiel from Colmenas";
            Connection connection = null;
            try {
                connection = Conexion.getConnection();
            } catch (URISyntaxException ex) {
                ex.printStackTrace();
            }
            
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()){
               id = rs.getInt("ID");
               kilos = rs.getInt("kilosMiel");
               miel.add(id);
               miel.add(kilos);
            }
                
               
        } catch (SQLException ex) {
        } 
        return miel;
    }
}