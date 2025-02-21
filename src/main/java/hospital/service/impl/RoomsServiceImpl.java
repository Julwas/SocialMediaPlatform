package hospital.service.impl;

import hospital.dao.IRoomsDAO;
import hospital.model.Rooms;

import hospital.service.RoomsService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class RoomsServiceImpl implements RoomsService<Rooms,Long> {
    private final SqlSessionFactory sqlSessionFactory;

    public RoomsServiceImpl(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @Override
    public Long create(Rooms rooms) {
        try (SqlSession session = sqlSessionFactory.openSession()){
            IRoomsDAO roomsDAO = session.getMapper(IRoomsDAO.class);
            roomsDAO.create(rooms);
            session.commit();
            return rooms.getId();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public Optional<Rooms> read(Long id)  {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            IRoomsDAO roomsDAO = session.getMapper(IRoomsDAO.class);
            return roomsDAO.read(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        }

    @Override
    public void update(Rooms rooms) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            IRoomsDAO roomsDAO = session.getMapper(IRoomsDAO.class);
           roomsDAO.update(rooms);
            session.commit();
        }
    }

    @Override
    public void delete(Long id) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            IRoomsDAO roomsDAO = session.getMapper(IRoomsDAO.class);
            roomsDAO.delete(id);
            session.commit();
        }
    }

    @Override
    public List<Rooms> getAll() {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            IRoomsDAO roomsDAO = session.getMapper(IRoomsDAO.class);
            return roomsDAO.getAll();
        }
    }


}
