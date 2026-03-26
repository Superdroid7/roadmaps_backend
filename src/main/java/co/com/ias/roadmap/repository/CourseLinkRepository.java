package co.com.ias.roadmap.repository;



import co.com.ias.roadmap.config.DatabaseConnection;
import co.com.ias.roadmap.model.CourseLink;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CourseLinkRepository {

    public List<CourseLink> getAllCourseLinks() {
        List<CourseLink> listCourseLinks = new ArrayList<>();

        String sql = "SELECT * FROM node_course";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedstatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedstatement.executeQuery()) {

            while (resultSet.next()) {
                CourseLink CourseLinkFound = new CourseLink();

                CourseLinkFound.setIdCourse(resultSet.getInt("id_course"));
                CourseLinkFound.setIdCourse(resultSet.getInt("id_link"));

                listCourseLinks.add(CourseLinkFound);
            }
        } catch (SQLException e) {
            System.out.println("error al cargar la lista. " + e.getMessage());
        }
        return listCourseLinks;
    }

    public CourseLink saveCourseLink(CourseLink union) {
        String sql = "INSERT INTO course_link (id_course, id_link) VALUES (?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement preparedstatement = conn.prepareStatement(sql)) {

            preparedstatement.setInt(1, union.getIdCourse());
            preparedstatement.setInt(2, union.getIdLink());

            preparedstatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("error al unir el nodo y el curso: " + e.getMessage());
        }
        return union;
    }
}
