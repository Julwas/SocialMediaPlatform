package hospital.dao.mySQL;


import hospital.dao.AbstractDAO;
import hospital.model.Rooms;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RoomsDAOmySQL extends AbstractDAO<Rooms, Long> {

  @Override
    public Long create(Rooms rooms) throws SQLException {

      String sql = "INSERT INTO Rooms (room_number, type, capacity) " +
              "VALUES (?, ?, ?)";
      try (Connection connection = getConnection();
           PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

          ps.setLong(1, rooms.getRoomNumber());
          ps.setString(2, rooms.getType());
          ps.setLong(3, rooms.getCapacity());

          int rowsAffected = ps.executeUpdate();

          if (rowsAffected > 0) {
              try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                  if (generatedKeys.next()) {
                      return generatedKeys.getLong(1);
                  } else {
                      throw new SQLException("Creating room failed, no ID obtained.");
                  }
              }
          } else {
              throw new SQLException("Creating room failed, no rows affected.");
          }
      }
    }
    @Override
    public Optional<Rooms> read(Long id) {
        String sql = "SELECT * FROM Rooms WHERE rooms_id = ?";
        try (Connection connection = getConnection(); PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Rooms rooms = new Rooms(
                        rs.getLong("rooms_id"),
                        rs.getLong("room_number"),
                        rs.getString("type"),
                        rs.getLong("capacity")
                );
                return Optional.of(rooms);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }
    @Override
    public void update(Rooms rooms) {

        String sql = "UPDATE rooms SET room_number = ?, type = ?, capacity = ? WHERE rooms_id = ?";
        try (Connection connection = getConnection(); PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setLong(1, rooms.getRoomNumber());
            ps.setString(2, rooms.getType());
            ps.setLong(3, rooms.getCapacity());
            ps.setLong(4, rooms.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void delete(Long id) {
        String sql = "DELETE FROM Rooms WHERE rooms_id = ?";
        try (Connection connection = getConnection(); PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setLong(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public List<Rooms> getAll() {
        List<Rooms> rooms = new ArrayList<>();
        String sql = "SELECT * FROM Rooms";
        try (Connection connection = getConnection(); PreparedStatement ps = connection.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Rooms room = new Rooms(
                        rs.getLong("rooms_id"),
                        rs.getLong("room_number"),
                        rs.getString("type"),
                        rs.getLong("capacity")
                );
                rooms.add(room);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rooms;
    }
}