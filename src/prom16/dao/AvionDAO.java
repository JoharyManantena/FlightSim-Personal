package prom16.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import prom16.model.Avion;

public class AvionDAO {
    private Connection connection;

    public AvionDAO(Connection connection) {
        this.connection = connection;
    }

    public void create(Avion avion) throws SQLException {
        String sql = "INSERT INTO Avion (modele, siegeBusiness, siegeEco, dateFabrication) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, avion.getModele());
            stmt.setInt(2, avion.getSiegeBusiness());
            stmt.setInt(3, avion.getSiegeEco());
            stmt.setDate(4, Date.valueOf(avion.getDateFabrication()));
            stmt.executeUpdate();
        }
    }

    public Avion read(int id) throws SQLException {
        String sql = "SELECT * FROM Avion WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Avion avion = new Avion();
                avion.setId(rs.getInt("id"));
                avion.setModele(rs.getString("modele"));
                avion.setSiegeBusiness(rs.getInt("siegeBusiness"));
                avion.setSiegeEco(rs.getInt("siegeEco"));
                avion.setDateFabrication(rs.getDate("dateFabrication").toLocalDate());
                return avion;
            }
        }
        return null;
    }

    public void update(Avion avion) throws SQLException {
        String sql = "UPDATE Avion SET modele = ?, siegeBusiness = ?, siegeEco = ?, dateFabrication = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, avion.getModele());
            stmt.setInt(2, avion.getSiegeBusiness());
            stmt.setInt(3, avion.getSiegeEco());
            stmt.setDate(4, Date.valueOf(avion.getDateFabrication()));
            stmt.setInt(5, avion.getId());
            stmt.executeUpdate();
        }
    }

    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM Avion WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    public List<Avion> findAll() throws SQLException {
        List<Avion> avions = new ArrayList<>();
        String sql = "SELECT * FROM Avion";
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Avion avion = new Avion();
                avion.setId(rs.getInt("id"));
                avion.setModele(rs.getString("modele"));
                avion.setSiegeBusiness(rs.getInt("siegeBusiness"));
                avion.setSiegeEco(rs.getInt("siegeEco"));
                avion.setDateFabrication(rs.getDate("dateFabrication").toLocalDate());
                avions.add(avion);
            }
        }
        return avions;
    }
}
