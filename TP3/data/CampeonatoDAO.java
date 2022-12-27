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

import Racing.Campeonato;

public class CampeonatoDAO implements Map<String, Campeonato> {
    private static CampeonatoDAO singleton = null;

    private CampeonatoDAO() {
        try (Connection conn = DriverManager.getConnection(DAOConfig.URL, DAOConfig.USERNAME, DAOConfig.PASSWORD);
                Statement stm = conn.createStatement()) {
                String sql = "CREATE TABLE IF NOT EXISTS Campeonato ("
                        + "idCampeonato VARCHAR(255) NOT NULL,"
                        + "nomeCampeonato VARCHAR(255) NOT NULL,"
                        + "numCorrida INT,"
                        + "PRIMARY KEY (idCampeonato))";
                stm.executeUpdate(sql);
                String sql2 ="CREATE TABLE IF NOT EXISTS Classificacao ("
                        + "idCampeonato VARCHAR(255) NOT NULL,"
                        + "idJogador VARCHAR(255) NOT NULL,"
                        + "pontos INT NOT NULL,"
                        + "PRIMARY KEY (idCampeonato, idJogador),"
                        + "FOREIGN KEY (idCampeonato) REFERENCES Campeonato(idCampeonato),"
                        + "FOREIGN KEY (idJogador) REFERENCES Participantes(idJogador))";
                stm.executeUpdate(sql2);
                String sql3 = "CREATE TABLE IF NOT EXISTS Participantes ("
                        + "idCampeonato VARCHAR(255) NOT NULL,"
                        + "idJogador VARCHAR(255) NOT NULL,"
                        + "posicao INT NOT NULL,"
                        + "idPiloto VARCHAR(255) NOT NULL,"
                        + "idCarro VARCHAR(255) NOT NULL,"
                        + "idUser VARCHAR(255) NOT NULL,"
                        + "timeDiff INT NOT NULL,"
                        + "PRIMARY KEY (idCampeonato, idJogador, idPiloto, idCarro, idUser),"
                        + "FOREIGN KEY (idPiloto) REFERENCES Piloto(idPiloto),"
                        + "FOREIGN KEY (idCarro) REFERENCES Carro(idCarro),"
                        + "FOREIGN KEY (idUser) REFERENCES User(idUser),"
                        + "FOREIGN KEY (idCampeonato) REFERENCES Campeonato(idCampeonato))";
                stm.executeUpdate(sql3);
                String sql4 = "CREATE TABLE IF NOT EXISTS Corrida ("
                        + "idCampeonato VARCHAR(255) NOT NULL,"
                        + "idCorrida INT NOT NULL,"
                        + "idJogador VARCHAR(255) NOT NULL,"
                        + "pontos INT NOT NULL,"
                        + "PRIMARY KEY (idCampeonato, idCorrida, idJogador),"
                        + "FOREIGN KEY (idCampeonato) REFERENCES Campeonato(idCampeonato),"
                        + "FOREIGN KEY (idJogador) REFERENCES participantes(idJogador))";
                stm.executeUpdate(sql4);
                String slq5 = "CREATE TABLE IF NOT EXISTS circuitos ("
                        + "idCampeonato VARCHAR(255) NOT NULL,"
                        + "idCorrida INT NOT NULL,"
                        + "idCircuito VARCHAR(255) NOT NULL,"
                        + "check BOOLEAN NOT NULL,"
                        + "PRIMARY KEY (idCampeonato, idCorrida, idCircuito),"
                        + "FOREIGN KEY (idCampeonato) REFERENCES Campeonato(idCampeonato))";
                stm.executeUpdate(slq5);
                } catch (Exception e) {
                        e.printStackTrace();
                        throw new NullPointerException(e.getMessage());
                }
        }
}
