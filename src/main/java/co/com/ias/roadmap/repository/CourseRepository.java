package co.com.ias.roadmap.repository;



import co.com.ias.roadmap.config.DatabaseConnection;
import co.com.ias.roadmap.model.Course;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CourseRepository {

    public List<Course> getAllCourses() {
        List<Course> listCourses = new ArrayList<>();
        String sql = "SELECT * FROM course";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedstatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedstatement.executeQuery()) {

            while (resultSet.next()) {
                Course CourseFound = new Course();

                CourseFound.setIdCourse(resultSet.getInt("id_Course"));
                CourseFound.setTitle(resultSet.getString("title"));
                CourseFound.setDescription(resultSet.getString("description"));
                CourseFound.setDateCreate(resultSet.getTimestamp("date_create"));

                listCourses.add(CourseFound);
            }
        } catch (SQLException e) {
            System.out.println("error al cargar la lista. " + e.getMessage());
        }
        return listCourses;
    }

    public List<Course> getCoursesBytitle(String title) {
        List<Course> listCourses = new ArrayList<>();
        String sql = "SELECT * FROM course WHERE title = ?";

        try(Connection connection = DatabaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)){

            preparedStatement.setString(1, title);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                Course CourseFound = new Course();

                CourseFound.setIdCourse(resultSet.getInt("id_course"));
                CourseFound.setTitle(resultSet.getString("title"));
                CourseFound.setDescription(resultSet.getString("description"));
                CourseFound.setDateCreate(resultSet.getTimestamp("date_create"));

                listCourses.add(CourseFound);
            }

        } catch (SQLException e) {
            System.out.println("Error al crea el curso: " + e.getMessage());
        }
        return listCourses;
    }


    public Course saveCourse(Course course) {
        String sql = "INSERT INTO course (title, description) VALUES (?, ?)";
        try(Connection conn = DatabaseConnection.getConnection();
            PreparedStatement preparedstatement = conn.prepareStatement(sql)){

            preparedstatement.setString(1, course.getTitle());
            preparedstatement.setString(2, course.getDescription());

            preparedstatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error al crea el curso: " + e.getMessage());
        }
        return course;
    }

    public Course updateCourse(int id, Course course) {
        String sql = "UPDATE course SET title = ?, description = ? WHERE id_Course = ?";

        try(Connection connection = DatabaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)){

            preparedStatement.setString(1, course.getTitle());
            preparedStatement.setString(2, course.getDescription());
            preparedStatement.setInt(3, id);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error al actualizar el curso: " + e.getMessage());
        }
        return course;
    }

    public void deleteCourse(int id) {
        String sql = "DELETE FROM course WHERE id_Course = ?";

        try(Connection connection = DatabaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)){

            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error al actualizar el curso: " + e.getMessage());
        }
    }
}
