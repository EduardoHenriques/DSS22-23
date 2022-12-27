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

import Carro.C1;
import Carro.C2;
import Carro.C1H;
import Carro.C2H;
import Carro.GT;
import Carro.GTH;
import Carro.SC;
import Carro.Carro;

public class CarroDAO implements Map<String, Carro>{
    private static CarroDAO singleton = null;

    private CarroDAO() {
        try (Connection conn = DriverManager.getConnection(DAOConfig.URL, DAOConfig.USERNAME, DAOConfig.PASSWORD);
            Statement stm = conn.createStatement()) {
            String sql = "CREATE TABLE IF NOT EXISTS Carro ("
                    + "idCarro VARCHAR(255) NOT NULL,"
                    + "marca VARCHAR(255) NOT NULL,"
                    + "modelo VARCHAR(255) NOT NULL,"
                    + "cilindrada INT NOT NULL,"
                    + "potencia INT NOT NULL,"
                    + "fiabilidade FLOAT NOT NULL,"
                    + "pa FLOAT NOT NULL,"
                    + "estado VARCHAR(255) NOT NULL,"
                    + "pneus VARCHAR(255) NOT NULL,"
                    + "categoria VARCHAR(255) NOT NULL,"
                    + "potencia_elec INT,"
                    + "PRIMARY KEY (idCarro))";
            stm.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
            throw new NullPointerException(e.getMessage());
        }
    }

    public static CarroDAO getInstance() {
        if (singleton == null) {
            singleton = new CarroDAO();
        }
        return singleton;
    }

    @Override
    public int size() {
        int i = 0;
        try (Connection conn = DriverManager.getConnection(DAOConfig.URL, DAOConfig.USERNAME, DAOConfig.PASSWORD);
            Statement stm = conn.createStatement()) {
            String sql = "SELECT * FROM Carro";
            try (ResultSet rs = stm.executeQuery(sql)) {
                for (; rs.next(); i++);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean containsKey(Object key) {
        boolean r = false;
        try (Connection conn = DriverManager.getConnection(DAOConfig.URL, DAOConfig.USERNAME, DAOConfig.PASSWORD);
            Statement stm = conn.createStatement()) {
            String sql = "SELECT * FROM Carro WHERE idCarro='" + key + "'";
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
        Carro c = (Carro) value;
        return containsKey(c.getIdCarro());
    }

    @Override
    public Carro get(Object key) {
        Carro c = null;
        try (Connection conn = DriverManager.getConnection(DAOConfig.URL, DAOConfig.USERNAME, DAOConfig.PASSWORD);
            Statement stm = conn.createStatement()) {
            String sql = "SELECT * FROM Carro WHERE idCarro='" + key + "'";
            try (ResultSet rs = stm.executeQuery(sql)) {
                if (rs.next()) {
                    if (rs.getString("categoria").equals("C1")) {
                        c = new C1(rs.getString("idCarro"), rs.getString("marca"), rs.getString("modelo"), rs.getInt("cilindrada"), rs.getInt("potencia"), rs.getFloat("fiabilidade"), rs.getFloat("pa"), rs.getString("estado"), rs.getString("pneus"));
                    }else if (rs.getString("categoria").equals("C2")) {
                        c = new C2(rs.getString("idCarro"), rs.getString("marca"), rs.getString("modelo"), rs.getInt("cilindrada"), rs.getInt("potencia"), rs.getFloat("fiabilidade"), rs.getFloat("pa"), rs.getString("estado"), rs.getString("pneus"));
                    }else if (rs.getString("categoria").equals("C1H")) {
                        c = new C1H(rs.getString("idCarro"), rs.getString("marca"), rs.getString("modelo"), rs.getInt("cilindrada"), rs.getInt("potencia"), rs.getFloat("fiabilidade"), rs.getFloat("pa"), rs.getString("estado"), rs.getString("pneus"), rs.getInt("potencia_elec"));
                    }else if (rs.getString("categoria").equals("C2H")) {
                        c = new C2H(rs.getString("idCarro"), rs.getString("marca"), rs.getString("modelo"), rs.getInt("cilindrada"), rs.getInt("potencia"), rs.getFloat("fiabilidade"), rs.getFloat("pa"), rs.getString("estado"), rs.getString("pneus"), rs.getInt("potencia_elec"));
                    }else if (rs.getString("categoria").equals("GT")) {
                        c = new GT(rs.getString("idCarro"), rs.getString("marca"), rs.getString("modelo"), rs.getInt("cilindrada"), rs.getInt("potencia"), rs.getFloat("fiabilidade"), rs.getFloat("pa"), rs.getString("estado"), rs.getString("pneus"));
                    }else if (rs.getString("categoria").equals("GTH")) {
                        c = new GTH(rs.getString("idCarro"), rs.getString("marca"), rs.getString("modelo"), rs.getInt("cilindrada"), rs.getInt("potencia"), rs.getFloat("fiabilidade"), rs.getFloat("pa"), rs.getString("estado"), rs.getString("pneus"), rs.getInt("potencia_elec"));
                    }else if (rs.getString("categoria").equals("SC")) {
                        c = new SC(rs.getString("idCarro"), rs.getString("marca"), rs.getString("modelo"), rs.getInt("cilindrada"), rs.getInt("potencia"), rs.getFloat("fiabilidade"), rs.getFloat("pa"), rs.getString("estado"), rs.getString("pneus"));
        } catch (Exception e) {
            e.printStackTrace();
            throw new NullPointerException(e.getMessage());
        }
        return c;
    }

    @Override
    public Carro put(String key, Carro value) {
        Carro c = null;
        try (Connection conn = DriverManager.getConnection(DAOConfig.URL, DAOConfig.USERNAME, DAOConfig.PASSWORD);
            Statement stm = conn.createStatement()) {
            String sql = "SELECT * FROM Carro WHERE idCarro='" + key + "'";
            try (ResultSet rs = stm.executeQuery(sql)) {
                if (rs.next()) {
                    c = get(key);
                    sql = "DELETE FROM Carro WHERE idCarro='" + key + "'";
                    stm.executeUpdate(sql);
                }
            }
            if (value instanceof C1) {
                sql = "INSERT INTO Carro VALUES ('"
                        + value.getIdCarro() + "','"
                        + value.getMarca() + "','"
                        + value.getModelo() + "',"
                        + value.getCilindrada() + ","
                        + value.getPotencia() + ","
                        + value.getFiabilidade() + ","
                        + value.getPa() + ",'"
                        + value.getEstado() + "','"
                        + value.getPneus() + "','"
                        + "C1" + "',"
                        + 0 + ")";
            } else if (value instanceof C2) {
                sql = "INSERT INTO Carro VALUES ('"
                        + value.getIdCarro() + "','"
                        + value.getMarca() + "','"
                        + value.getModelo() + "',"
                        + value.getCilindrada() + ","
                        + value.getPotencia() + ","
                        + value.getFiabilidade() + ","
                        + value.getPa() + ",'"
                        + value.getEstado() + "','"
                        + value.getPneus() + "','"
                        + "C2" + "',"
                        + 0 + ")";
            } else if (value instanceof C1H) {
                sql = "INSERT INTO Carro VALUES ('"
                        + value.getIdCarro() + "','"
                        + value.getMarca() + "','"
                        + value.getModelo() + "',"
                        + value.getCilindrada() + ","
                        + value.getPotencia() + ","
                        + value.getFiabilidade() + ","
                        + value.getPa() + ",'"
                        + value.getEstado() + "','"
                        + value.getPneus() + "','"
                        + "C1H" + "',"
                        + ((C1H) value).getMotorEletrico() + ")";
            } else if (value instanceof C2H) {
                sql = "INSERT INTO Carro VALUES ('"
                        + value.getIdCarro() + "','"
                        + value.getMarca() + "','"
                        + value.getModelo() + "',"
                        + value.getCilindrada() + ","
                        + value.getPotencia() + ","
                        + value.getFiabilidade() + ","
                        + value.getPa() + ",'"
                        + value.getEstado() + "','"
                        + value.getPneus() + "','"
                        + "C2H" + "',"
                        + ((C2H) value).getMotorEletrico() + ")";
            } else if (value instanceof GT) {
                sql = "INSERT INTO Carro VALUES ('"
                        + value.getIdCarro() + "','"
                        + value.getMarca() + "','"
                        + value.getModelo() + "',"
                        + value.getCilindrada() + ","
                        + value.getPotencia() + ","
                        + value.getFiabilidade() + ","
                        + value.getPa() + ",'"
                        + value.getEstado() + "','"
                        + value.getPneus() + "','"
                        + "GT" + "',"
                        + 0 +
                        ")";
            } else if (value instanceof GTH) {
                sql = "INSERT INTO Carro VALUES ('"
                        + value.getIdCarro() + "','"
                        + value.getMarca() + "','"
                        + value.getModelo() + "',"
                        + value.getCilindrada() + ","
                        + value.getPotencia() + ","
                        + value.getFiabilidade() + ","
                        + value.getPa() + ",'"
                        + value.getEstado() + "','"
                        + value.getPneus() + "','"
                        + "GTH" + "',"
                        + ((GTH) value).getMotorEletrico() + ")";
            } else if (value instanceof SC) {
                sql = "INSERT INTO Carro VALUES ('"
                        + value.getIdCarro() + "','"
                        + value.getMarca() + "','"
                        + value.getModelo() + "',"
                        + value.getCilindrada() + ","
                        + value.getPotencia() + ","
                        + value.getFiabilidade() + ","
                        + value.getPa() + ",'"
                        + value.getEstado() + "','"
                        + value.getPneus() + "','"
                        + "SC" + "',"
                        + 0 + ")";
            }
            stm.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
            throw new NullPointerException(e.getMessage());
        }
        return c;
    }

    @Override
    public Carro remove(Object key) {
        Carro c = this.get(key);
        try (Connection conn = DriverManager.getConnection(DAOConfig.URL, DAOConfig.USERNAME, DAOConfig.PASSWORD);
            Statement stm = conn.createStatement()) {
            String sql = "DELETE FROM Carro WHERE idCarro='" + key + "'";
            stm.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
            throw new NullPointerException(e.getMessage());
        }
        return c;
    }

    @Override
    public void putAll(Map<? extends String, ? extends Carro> m) {
        for (Carro c : m.values()) {
            this.put(c.getIdCarro(), c);
        }
    }

    @Override
    public void clear() {
        try (Connection conn = DriverManager.getConnection(DAOConfig.URL, DAOConfig.USERNAME, DAOConfig.PASSWORD);
            Statement stm = conn.createStatement()) {
            String sql = "DELETE FROM Carro";
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
            String sql = "SELECT idCarro FROM Carro";
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                set.add(rs.getString("idCarro"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new NullPointerException(e.getMessage());
        }
        return set;
    }

    @Override
    public Collection<Carro> values() {
        Collection<Carro> col = new HashSet<>();
        try (Connection conn = DriverManager.getConnection(DAOConfig.URL, DAOConfig.USERNAME, DAOConfig.PASSWORD);
            Statement stm = conn.createStatement()) {
            String sql = "SELECT * FROM Carro";
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                Carro c = null;
                if (rs.getString("tipo").equals("C1")) {
                    c = new C1(rs.getString("idCarro"), rs.getString("marca"), rs.getString("modelo"), rs.getInt("cilindrada"), rs.getInt("potencia"), rs.getInt("fiabilidade"), rs.getInt("pa"), rs.getString("estado"), rs.getString("pneus"));
                } else if (rs.getString("tipo").equals("C2")) {
                    c = new C2(rs.getString("idCarro"), rs.getString("marca"), rs.getString("modelo"), rs.getInt("cilindrada"), rs.getInt("potencia"), rs.getInt("fiabilidade"), rs.getInt("pa"), rs.getString("estado"), rs.getString("pneus"));
                } else if (rs.getString("tipo").equals("C1H")) {
                    c = new C1H(rs.getString("idCarro"), rs.getString("marca"), rs.getString("modelo"), rs.getInt("cilindrada"), rs.getInt("potencia"), rs.getInt("fiabilidade"), rs.getInt("pa"), rs.getString("estado"), rs.getString("pneus"), rs.getInt("motorEletrico"));
                } else if (rs.getString("tipo").equals("C2H")) {
                    c = new C2H(rs.getString("idCarro"), rs.getString("marca"), rs.getString("modelo"), rs.getInt("cilindrada"), rs.getInt("potencia"), rs.getInt("fiabilidade"), rs.getInt("pa"), rs.getString("estado"), rs.getString("pneus"), rs.getInt("motorEletrico"));
                } else if (rs.getString("tipo").equals("GT")) {
                    c = new GT(rs.getString("idCarro"), rs.getString("marca"), rs.getString("modelo"), rs.getInt("cilindrada"), rs.getInt("potencia"), rs.getInt("fiabilidade"), rs.getInt("pa"), rs.getString("estado"), rs.getString("pneus"));
                } else if (rs.getString("tipo").equals("GTH")) {
                    c = new GTH(rs.getString("idCarro"), rs.getString("marca"), rs.getString("modelo"), rs.getInt("cilindrada"), rs.getInt("potencia"), rs.getInt("fiabilidade"), rs.getInt("pa"), rs.getString("estado"), rs.getString("pneus"), rs.getInt("motorEletrico"));
                } else if (rs.getString("tipo").equals("SC")) {
                    c = new SC(rs.getString("idCarro"), rs.getString("marca"), rs.getString("modelo"), rs.getInt("cilindrada"), rs.getInt("potencia"), rs.getInt("fiabilidade"), rs.getInt("pa"), rs.getString("estado"), rs.getString("pneus"));
                }
                col.add(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new NullPointerException(e.getMessage());
        }
        return col;
    }

    @Override
    public Set<Entry<String, Carro>> entrySet() {
        Set<Entry<String, Carro>> set = new HashSet<>();
        try (Connection conn = DriverManager.getConnection(DAOConfig.URL, DAOConfig.USERNAME, DAOConfig.PASSWORD);
            Statement stm = conn.createStatement()) {
            String sql = "SELECT * FROM Carro";
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                Carro c = null;
                if (rs.getString("tipo").equals("C1")) {
                    c = new C1(rs.getString("idCarro"), rs.getString("marca"), rs.getString("modelo"), rs.getInt("cilindrada"), rs.getInt("potencia"), rs.getInt("fiabilidade"), rs.getInt("pa"), rs.getString("estado"), rs.getString("pneus"));
                } else if (rs.getString("tipo").equals("C2")) {
                    c = new C2(rs.getString("idCarro"), rs.getString("marca"), rs.getString("modelo"), rs.getInt("cilindrada"), rs.getInt("potencia"), rs.getInt("fiabilidade"), rs.getInt("pa"), rs.getString("estado"), rs.getString("pneus"));
                } else if (rs.getString("tipo").equals("C1H")) {
                    c = new C1H(rs.getString("idCarro"), rs.getString("marca"), rs.getString("modelo"), rs.getInt("cilindrada"), rs.getInt("potencia"), rs.getInt("fiabilidade"), rs.getInt("pa"), rs.getString("estado"), rs.getString("pneus"), rs.getInt("motorEletrico"));
                } else if (rs.getString("tipo").equals("C2H")) {
                    c = new C2H(rs.getString("idCarro"), rs.getString("marca"), rs.getString("modelo"), rs.getInt("cilindrada"), rs.getInt("potencia"), rs.getInt("fiabilidade"), rs.getInt("pa"), rs.getString("estado"), rs.getString("pneus"), rs.getInt("motorEletrico"));
                } else if (rs.getString("tipo").equals("GT")) {
                    c = new GT(rs.getString("idCarro"), rs.getString("marca"), rs.getString("modelo"), rs.getInt("cilindrada"), rs.getInt("potencia"), rs.getInt("fiabilidade"), rs.getInt("pa"), rs.getString("estado"), rs.getString("pneus"));
                } else if (rs.getString("tipo").equals("GTH")) {
                    c = new GTH(rs.getString("idCarro"), rs.getString("marca"), rs.getString("modelo"), rs.getInt("cilindrada"), rs.getInt("potencia"), rs.getInt("fiabilidade"), rs.getInt("pa"), rs.getString("estado"), rs.getString("pneus"), rs.getInt("motorEletrico"));
                } else if (rs.getString("tipo").equals("SC")) {
                    c = new SC(rs.getString("idCarro"), rs.getString("marca"), rs.getString("modelo"), rs.getInt("cilindrada"), rs.getInt("potencia"), rs.getInt("fiabilidade"), rs.getInt("pa"), rs.getString("estado"), rs.getString("pneus"));
                }
                set.add(new AbstractMap.SimpleEntry<>(rs.getString("idCarro"), c));
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new NullPointerException(e.getMessage());
        }
        return set;
    }

}
    
