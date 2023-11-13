package com.example.weatherfx;

import com.google.gson.Gson;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import io.github.cdimascio.dotenv.Dotenv;

public class App extends Application {

    static Dotenv dotenv = Dotenv.load();
    private static final String API_KEY = dotenv.get("API_KEY");

    final int WIDTH = 500;
    final int LENGTH = 500;

    Label output;
    Button button;
    TextField input;
    Group group;

    static LocationData locData = new LocationData();

    public static void main(String[] args) throws IOException, InterruptedException {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {


        stage.setTitle("Weather App");

        input = new TextField();
        output = new Label();
        button = new Button();

        input.setPrefSize(200, 20);
        input.setLayoutX(150);
        input.setLayoutY(100);
        input.setStyle("-fx-text-fill: white; -fx-background-color: #4d4c4c");

        button.setText("Enter");
        button.setPrefSize(75, 20);
        button.setLayoutX(212.5);
        button.setLayoutY(150);
        button.setStyle("-fx-background-color: #00c3ff");

        output.setLayoutX(155);
        output.setLayoutY(200);
        output.setMaxWidth(190);
        output.setWrapText(true);
        output.setFont(new Font(20));
        output.setTextFill(Color.web("#00c3ff"));

        button.setOnAction(e -> {
            try {
                locData.setInputData(input.getText());
                output.setText(HttpCall());
            } catch (IOException | InterruptedException ex) {
                throw new RuntimeException(ex);
            }
        });

        group = new Group();
        group.getChildren().add(input);
        group.getChildren().add(button);
        group.getChildren().add(output);

        Scene scene = new Scene(group, WIDTH, LENGTH, Color.GRAY);

        stage.setScene(scene);
        stage.show();
    }

    public static String HttpCall() throws IOException, InterruptedException {
        String BASE_URL = "http://api.weatherstack.com/current?access_key=" + API_KEY + "&query=" + locData.getInputData() + "&units=f";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .header("Accept", "application/json")
                .uri(URI.create(BASE_URL))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        Wrapper wrapper = new Gson().fromJson(response.body(), Wrapper.class);

        return wrapper.toString();
    }
}