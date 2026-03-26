package co.com.ias.roadmap.repository;



import co.com.ias.roadmap.config.DatabaseConnection;
import co.com.ias.roadmap.model.Route;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RouteRepository {

    public List<Route> getAllRoutes() {
        List<Route> listRoutes = new ArrayList<>();
        String sql = "SELECT * FROM route";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                Route route = new Route();
                route.setIdRoute(resultSet.getInt("id_route"));
                route.setName(resultSet.getString("name"));
                route.setDescription(resultSet.getString("description"));
                listRoutes.add(route);
            }
        } catch (SQLException e) {
            System.out.println("Error al buscar las rutas: " + e.getMessage());
        }
        return listRoutes;
    }

    public Route saveRoute(Route route) {
        String sqlQuery = "INSERT INTO route (name, description) VALUES (?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setString(1, route.getName());
            preparedStatement.setString(2, route.getDescription());

            preparedStatement.executeUpdate();

            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    route.setIdRoute(generatedKeys.getInt(1));
                }
            }
        } catch (SQLException e) {
            System.out.println("Error saving route: " + e.getMessage());
        }
        return route;
    }
}