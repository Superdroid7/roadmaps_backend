package co.com.ias.roadmap.repository;



import co.com.ias.roadmap.config.DatabaseConnection;
import co.com.ias.roadmap.model.NodeCourse;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NodeCourseRepository {
    public List<NodeCourse> getAllNodeCourses() {
        List<NodeCourse> listNodeCourses = new ArrayList<>();
        String sql = "SELECT * FROM node_course";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedstatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedstatement.executeQuery()) {

            while (resultSet.next()) {
                NodeCourse nodeCourse = new NodeCourse();

                nodeCourse.setIdNode(resultSet.getInt("id_node"));
                nodeCourse.setIdCourse(resultSet.getInt("id_course"));

                listNodeCourses.add(nodeCourse);
            }
        } catch (SQLException e) {
            System.out.println("error al cargar la lista. " + e.getMessage());
        }
        return listNodeCourses;
    }

    public NodeCourse saveNodeCourse(NodeCourse nodeCourse) {
        String sql = "INSERT INTO node_course (id_node, id_course) VALUES (?, ?)";

        try(Connection connection = DatabaseConnection.getConnection();
            PreparedStatement preparedstatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){

            preparedstatement.setInt(1, nodeCourse.getIdNode());
            preparedstatement.setInt(2, nodeCourse.getIdCourse());

            preparedstatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return nodeCourse;
    }
}
