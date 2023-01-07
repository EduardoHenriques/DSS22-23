package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.AbstractMap;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import buisness.Racing.*;
import buisness.Carro.*;
import buisness.Utilizador.*;

public class CampeonatoDAO implements Map<String, Campeonato> {
    private static CampeonatoDAO singleton = null;

    private CampeonatoDAO() {
        try (Connection conn = DriverManager.getConnection(DAOConfig.URL, DAOConfig.USERNAME, DAOConfig.PASSWORD);
        Statement stm = conn.createStatement()) {
                String sql = "CREATE TABLE IF NOT EXISTS Campeonato ("
                        + "idCampeonato VARCHAR(255) NOT NULL,"
                        + "nomeCampeonato VARCHAR(255) NOT NULL,"
                        + "PRIMARY KEY (idCampeonato))";
                stm.executeUpdate(sql);
            } catch (Exception e) {
                e.printStackTrace();
                throw new NullPointerException(e.getMessage());   
        }
    
        public static CampeonatoDAO getInstance() {
            if (CampeonatoDAO.singleton == null) {
                CampeonatoDAO.singleton = new CampeonatoDAO();
            }
            return CampeonatoDAO.singleton;
        }
    
        @Override
        public int size() {
            int i = 0;
            try (Connection conn = DriverManager.getConnection(DAOConfig.URL, DAOConfig.USERNAME, DAOConfig.PASSWORD);
                Statement stm = conn.createStatement()) {
                String sql = "SELECT idCampeonato FROM Campeonato";
                try (ResultSet rs = stm.executeQuery(sql)) {
                    for (; rs.next(); i++);
                }
            } catch (Exception e) {
                e.printStackTrace();
                throw new NullPointerException(e.getMessage());
            }
            return i;
        }
    
        @Override
        public boolean isEmpty() {
            return this.size() == 0;
        }
    
        @Override
        public boolean containsKey(Object key) {
            boolean r = false;
            try (Connection conn = DriverManager.getConnection(DAOConfig.URL, DAOConfig.USERNAME, DAOConfig.PASSWORD);
                Statement stm = conn.createStatement()) {
                String sql = "SELECT idCampeonato FROM Campeonato WHERE idCampeonato='" + key + "'";
                try (ResultSet rs = stm.executeQuery(sql)) {
                    r = rs.next();
                }
            } catch (Exception e) {
                e.printStackTrace();
                throw new NullPointerException(e.getMessage());
            }
            return r;
        }
    
        @Override
        public boolean containsValue(Object value) {
            Campeonato c = (Campeonato) value;
            return this.containsKey(c.getProva());
        }
    
        @Override
        public Campeonato get(Object key) {
            Campeonato c = null;
            try (Connection conn = DriverManager.getConnection(DAOConfig.URL, DAOConfig.USERNAME, DAOConfig.PASSWORD);
                Statement stm = conn.createStatement()) {
                String sql = "SELECT * FROM Campeonato WHERE idCampeonato='" + key + "'";
                try (ResultSet rs = stm.executeQuery(sql)) {
                    if (rs.next()) {
                        c = new Campeonato(rs.getString("idCampeonato"), rs.getString("nomeCampeonato"));
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                throw new NullPointerException(e.getMessage());
            }
            return c;
        }
    
        @Override
        public Campeonato put(String key, Campeonato value) {
            Campeonato c = null;
            try (Connection conn = DriverManager.getConnection(DAOConfig.URL, DAOConfig.USERNAME, DAOConfig.PASSWORD);
                Statement stm = conn.createStatement()) {
                String sql = "SELECT * FROM Campeonato WHERE idCampeonato='" + key + "'";
                try (ResultSet rs = stm.executeQuery(sql)) {
                    if (rs.next()) {
                        c = new Campeonato(rs.getString("idCampeonato"), rs.getString("nomeCampeonato"));
                        sql = "UPDATE Campeonato SET nomeCampeonato='" + value.getNomeCampeonato() + "' WHERE idCampeonato='" + key + "'";
                        stm.executeUpdate(sql);
                    } else {
                        sql = "INSERT INTO Campeonato VALUES ('" + key + "','" + value.getNomeCampeonato() + "')";
                        stm.executeUpdate(sql);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                throw new NullPointerException(e.getMessage());
            }
            return c;
        }
    
        @Override
        public Campeonato remove(Object key) {
            Campeonato c = this.get(key);
            try (Connection conn = DriverManager.getConnection(DAOConfig.URL, DAOConfig.USERNAME, DAOConfig.PASSWORD);
                Statement stm = conn.createStatement()) {
                String sql = "DELETE FROM Campeonato WHERE idCampeonato='" + key + "'";
                stm.executeUpdate(sql);
            } catch (Exception e) {
                e.printStackTrace();
                throw new NullPointerException(e.getMessage());
            }
            return c;
        }
    
        @Override
        public void putAll(Map<? extends String, ? extends Campeonato> m) {
            for (Campeonato c : m.values()) {
                this.put(c.getProva(), c);
            }
        }
    
        @Override
        public void clear() {
            try (Connection conn = DriverManager.getConnection(DAOConfig.URL, DAOConfig.USERNAME, DAOConfig.PASSWORD);
                Statement stm = conn.createStatement()) {
                String sql = "DELETE FROM Campeonato";
                stm.executeUpdate(sql);
            } catch (Exception e) {
                e.printStackTrace();
                throw new NullPointerException(e.getMessage());
            }
        }
    
        @Override
        public Set<String> keySet() {
            Set<String> set = new HashSet<>();
            try (Connection conn = DriverManager.getConnection(DAOConfig.URL, DAOConfig.USERNAME, DAOConfig.PASSWORD);
                Statement stm = conn.createStatement()) {
                String sql = "SELECT idCampeonato FROM Campeonato";
                try (ResultSet rs = stm.executeQuery(sql)) {
                    for (; rs.next();) {
                        set.add(rs.getString("idCampeonato"));
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                throw new NullPointerException(e.getMessage());
            }
            return set;
        }
    
        @Override
        public Collection<Campeonato> values() {
            Collection<Campeonato> col = new HashSet<>();
            try (Connection conn = DriverManager.getConnection(DAOConfig.URL, DAOConfig.USERNAME, DAOConfig.PASSWORD);
                Statement stm = conn.createStatement()) {
                String sql = "SELECT * FROM Campeonato";
                try (ResultSet rs = stm.executeQuery(sql)) {
                    for (; rs.next();) {
                        col.add(new Campeonato(rs.getString("idCampeonato"), rs.getString("nomeCampeonato")));
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                throw new NullPointerException(e.getMessage());
            }
            return col;
        }
    
        @Override
        public Set<Entry<String, Campeonato>> entrySet() {
            Set<Entry<String, Campeonato>> set = new HashSet<>();
            try (Connection conn = DriverManager.getConnection(DAOConfig.URL, DAOConfig.USERNAME, DAOConfig.PASSWORD);
                Statement stm = conn.createStatement()) {
                String sql = "SELECT * FROM Campeonato";
                try (ResultSet rs = stm.executeQuery(sql)) {
                    for (; rs.next();) {
                        set.add(new AbstractMap.SimpleEntry<>(rs.getString("idCampeonato"), new Campeonato(rs.getString("idCampeonato"), rs.getString("nomeCampeonato"))));
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                throw new NullPointerException(e.getMessage());
            }
            return set;
        }
}
