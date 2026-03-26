package co.com.ias.roadmap.repository;



import co.com.ias.roadmap.config.DatabaseConnection;
import co.com.ias.roadmap.model.Link;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LinkRepository {
    public List<Link> getAllLinks() {
        List<Link> listLinks = new ArrayList<>();

        String sql = "SELECT * FROM Link";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedstatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedstatement.executeQuery()) {

            while (resultSet.next()) {
                Link LinkFound = new Link();

                LinkFound.setIdLink(resultSet.getInt("id_Link"));
                LinkFound.setTitle(resultSet.getString("title"));
                LinkFound.setUrl(resultSet.getString("url"));
                LinkFound.setDateCreate(resultSet.getTimestamp("date_create"));

                listLinks.add(LinkFound);
            }
        } catch (SQLException e) {
            System.out.println("error al cargar la lista. " + e.getMessage());
        }
        return listLinks;
    }

    public Link saveLink(Link link){
        String sql = "INSERT INTO link (title, url) VALUES (?, ?)";

        try(Connection conn = DatabaseConnection.getConnection();
            PreparedStatement preparedstatement = conn.prepareStatement(sql)){

            preparedstatement.setString(1, link.getTitle());
            preparedstatement.setString(2, link.getUrl());

            preparedstatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error al crea el link: " + e.getMessage());
        }
        return link;
    }
}
