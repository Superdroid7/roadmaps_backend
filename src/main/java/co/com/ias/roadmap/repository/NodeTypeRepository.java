package co.com.ias.roadmap.repository;



import co.com.ias.roadmap.config.DatabaseConnection;
import co.com.ias.roadmap.model.NodeType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NodeTypeRepository {
    public List<NodeType> getAllNodeType() {
        List<NodeType> listNodeTypes = new ArrayList<>();
        String sql = "SELECT * FROM node_type";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                NodeType nodeType = new NodeType();

                nodeType.setIdNodeType(resultSet.getInt("id_node_type"));
                nodeType.setName(resultSet.getString("name"));

                listNodeTypes.add(nodeType);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return listNodeTypes;
    }

}
