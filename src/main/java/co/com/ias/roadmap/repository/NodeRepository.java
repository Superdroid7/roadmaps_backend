package co.com.ias.roadmap.repository;



import co.com.ias.roadmap.config.DatabaseConnection;
import co.com.ias.roadmap.model.Node;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NodeRepository {
    public List<Node> getNodes() {
        List<Node> listNodes = new ArrayList<>();
        String sql = "SELECT * FROM node";

        try(Connection conn = DatabaseConnection.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery()){

            while (resultSet.next()) {
                Node node = new Node();

                node.setIdNode(resultSet.getInt("id_node"));
                node.setIdRoute(resultSet.getInt("id_route"));
                node.setIdNodeType(resultSet.getInt("id_node_type"));
                node.setTitle(resultSet.getString("title"));
                node.setDescription(resultSet.getString("description"));

                listNodes.add(node);
            }
        } catch (SQLException e) {
            System.out.println("Error al crea el nodo: " + e.getMessage());
            return null;
        }
        return listNodes;
    }

    public Node createNode(Node node) {
        String sql = "INSERT INTO node (id_route, id_node_type, title, description) VALUES (?, ?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setInt(1, node.getIdRoute());
            preparedStatement.setInt(2, node.getIdNodeType());
            preparedStatement.setString(3, node.getTitle());
            preparedStatement.setString(4, node.getDescription());

            preparedStatement.executeUpdate();

            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    node.setIdNode(generatedKeys.getInt(1));
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al crear el nodo: " + e.getMessage());
        }
        return node;
    }
}
