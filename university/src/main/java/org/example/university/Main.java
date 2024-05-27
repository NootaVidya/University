package org.example.university;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("University Information");


        // Create buttons for navigation
        Button homeButton = new Button("Home");
        Button aboutButton = new Button("About Us");
        Button contactButton = new Button("Contact Us");
        Button coursesButton = new Button("Trending Courses");

        // VBox for buttons
        VBox buttonBox = new VBox(10, homeButton, aboutButton, contactButton, coursesButton);
        buttonBox.setPadding(new Insets(20));
        buttonBox.setStyle("-fx-background-color: rgba(255, 255, 255, 0.7);");

        // StackPane for background images and content
        StackPane mainPane = new StackPane();
        mainPane.getChildren().add(buttonBox);

        // Set the default background image
        setBackgroundImage(mainPane, "university_image.jpg");

        // Scene and stage setup
        Scene scene = new Scene(mainPane, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();

        // Button actions
        homeButton.setOnAction(e -> {
            setBackgroundImage(mainPane, "university_image.jpg");
            addHomePageContent(mainPane);
        });
        aboutButton.setOnAction(e -> {
            setBackgroundImage(mainPane, "university_image.jpg");
            addAboutUsContent(mainPane); // Add the About Us content
        });
        contactButton.setOnAction(e -> {
            setBackgroundImage(mainPane, "contact_us_image.jpg");
            addContactForm(mainPane);
        });
        coursesButton.setOnAction(e -> {
            setBackgroundImage(mainPane, "Trending Couses.png");
            addTrendingCourses(mainPane);
        });
    }

    private void setBackgroundImage(StackPane pane, String imagePath) {
        // Load the new background image
        Image backgroundImage = new Image(getClass().getResource("/" + imagePath).toExternalForm());
        pane.setStyle("-fx-background-image: url('" + backgroundImage.getUrl() + "'); " +
                "-fx-background-size: cover; " +
                "-fx-background-position: center;");
    }

    private void addHomePageContent(StackPane pane) {
        // Clear previous content if any
        pane.getChildren().removeIf(node -> node instanceof VBox);

        // Add welcome message and address
        Text welcomeText = new Text("                            Welcome to University");
        welcomeText.setStyle("-fx-font-weight: bold; -fx-font-size: 30;");

        Text addressText = new Text("Address: 123 University Street\nCity, Country");
        addressText.setStyle("-fx-font-size: 16;");

        Button backButton = new Button("Back");
        backButton.setOnAction(e -> {
            setBackgroundImage(pane, "university_image.jpg");
            removeHomePageContent(pane);
            addNavigationButtons(pane);
        });

        VBox contentBox = new VBox(10, welcomeText, addressText, backButton);
        contentBox.setPadding(new Insets(20));
        contentBox.setStyle("-fx-background-color: rgba(255, 255, 255, 0.7);");
        pane.getChildren().add(contentBox);
    }

    private void removeHomePageContent(StackPane pane) {
        // Remove home page content
        pane.getChildren().removeIf(node -> node instanceof VBox);
    }

    private void addNavigationButtons(StackPane pane) {
        // Create buttons for navigation
        Button homeButton = new Button("Home");
        Button aboutButton = new Button("About Us");
        Button contactButton = new Button("Contact Us");
        Button coursesButton = new Button("Trending Courses");

        // VBox for buttons
        VBox buttonBox = new VBox(10, homeButton, aboutButton, contactButton, coursesButton);
        buttonBox.setPadding(new Insets(20));
        buttonBox.setStyle("-fx-background-color: rgba(255, 255, 255, 0.7);");

        // Button actions
        homeButton.setOnAction(e -> {
            setBackgroundImage(pane, "university_image.jpg");
            addHomePageContent(pane);
        });
        aboutButton.setOnAction(e -> {
            setBackgroundImage(pane, "university_image.jpg");
            addAboutUsContent(pane); // Add the About Us content
        });
        contactButton.setOnAction(e -> {
            setBackgroundImage(pane, "contact_us_image.jpg");
            addContactForm(pane);
        });
        coursesButton.setOnAction(e -> {
            setBackgroundImage(pane, "Trending Couses.png");
            addTrendingCourses(pane);
        });

        // Add button box to the main pane
        pane.getChildren().add(buttonBox);
    }
    private void addAboutUsContent(StackPane pane) {
        // Clear previous content if any
        pane.getChildren().removeIf(node -> node instanceof VBox);

        // Add university information
        Text aboutTitle = new Text("About Us");
        aboutTitle.setStyle("-fx-font-weight: bold; -fx-font-size: 20;");

        Text aboutText = new Text("Our university prioritizes quality education, fosters innovation, and empowers students to lead. ");
        Text sentence1 = new Text("Our university prioritizes quality education, fosters innovation, and empowers students to lead.");
        Text sentence2 = new Text("With top-notch facilities and faculty, our diverse programs ensure holistic success.");

        TextFlow aboutTextFlow = new TextFlow(aboutText, sentence1, sentence2);
        aboutTextFlow.setPrefWidth(600); // Adjust width as needed

        Button backButton = new Button("Back");
        backButton.setOnAction(e -> {
            setBackgroundImage(pane, "university_image.jpg");
            removeAboutUsContent(pane);
            addNavigationButtons(pane);
        });

        VBox aboutBox = new VBox(20, aboutTitle, aboutTextFlow, backButton);
        aboutBox.setPadding(new Insets(20));
        aboutBox.setStyle("-fx-background-color: rgba(255, 255, 255, 0.7);");

        pane.getChildren().add(aboutBox);
    }


    private void removeAboutUsContent(StackPane pane) {
        // Remove about us content
        pane.getChildren().removeIf(node -> node instanceof VBox);
    }

    private void addTrendingCourses(StackPane pane) {
        // Clear previous content if any
        pane.getChildren().removeIf(node -> node instanceof VBox);

        // Create a list of trending courses (you can fetch this data from a database or an external API)
        List<String> trendingCourses = Arrays.asList(
                "Machine Learning",
                "Artificial Intelligence",
                "Blockchain Technology",
                "Cybersecurity",
                "Data Science",
                "Internet of Things (IoT)",
                "Cloud Computing",
                "DevOps",
                "Augmented Reality (AR)",
                "Virtual Reality (VR)"
        );

        // Create labels for trending courses
        List<Label> courseLabels = trendingCourses.stream()
                .map(course -> new Label(course))
                .collect(Collectors.toList());

        Button backButton = new Button("Back");
        backButton.setOnAction(e -> {
            setBackgroundImage(pane, "university_image.jpg");
            removeTrendingCourses(pane);
            addNavigationButtons(pane);
        });

        // VBox to hold the course labels and the back button
        VBox coursesBox = new VBox(10);
        coursesBox.getChildren().addAll(courseLabels);
        coursesBox.getChildren().add(backButton);
        coursesBox.setPadding(new Insets(20));
        coursesBox.setStyle("-fx-background-color: rgba(255, 255, 255, 0.7);");

        // Add the courses box to the main pane
        pane.getChildren().add(coursesBox);
    }

    private void removeTrendingCourses(StackPane pane) {
        // Remove trending courses
        pane.getChildren().removeIf(node -> node instanceof VBox);
    }

    private String generateBotResponse(String message) {
        String response;
        switch (message.toLowerCase()) {
            case "university address":
                response = "Our university is located at 123 University Street, City, Country.";
                break;
            case "technologies":
                response = "Our university focuses on cutting-edge technologies like Machine Learning, Artificial Intelligence, Blockchain, and more.";
                break;
            case "about us":
                response = "Our university is committed to providing quality education, fostering innovation, and empowering students to lead.";
                break;
            default:
                response = "I'm sorry, I didn't understand your question.";
                break;
        }
        return response;
    }


    private void addContactForm(StackPane pane) {

        // Clear previous content if any
        pane.getChildren().removeIf(node -> node instanceof VBox);

        // Create labels and fields for contact form
        Label nameLabel = new Label("Name:");
        TextField nameField = new TextField();

        Label contactNumberLabel = new Label("Contact Number:");
        TextField contactNumberField = new TextField();

        Label emailLabel = new Label("Email:");
        TextField emailField = new TextField();

        Label questionLabel = new Label("Questions/Comments:");
        TextArea questionArea = new TextArea();
        Label successLabel = new Label();

        Button submitButton = new Button("Submit");
        submitButton.setOnAction(e -> {
            if (validateForm(nameField.getText(), contactNumberField.getText(), emailField.getText(), questionArea.getText())) {
                successLabel.setText("Message submitted successfully!");
                successLabel.setStyle("-fx-text-fill: green;");
            } else {
                successLabel.setText("Please fill out all fields.");
                successLabel.setStyle("-fx-text-fill: red;");
            }
        });

        Button backButton = new Button("Back");
        backButton.setOnAction(e -> {
            setBackgroundImage(pane, "university_image.jpg");
            removeContactForm(pane);
            addNavigationButtons(pane);
        });

        // Chatbot interface
        TextArea chatArea = new TextArea();
        chatArea.setEditable(false);
        chatArea.setPrefHeight(200);

        TextField chatInput = new TextField();
        chatInput.setPromptText("Type your message here...");

        Button sendButton = new Button("Send");
        sendButton.setOnAction(e -> {
            String message = chatInput.getText();
            // Process user message here and generate response
            String response = generateBotResponse(message);
            chatArea.appendText("You: " + message + "\n");
            chatArea.appendText("Bot: " + response + "\n");
            chatInput.clear();
        });

        // VBox for contact form elements
        VBox contactFormBox = new VBox(10, nameLabel, nameField, contactNumberLabel, contactNumberField,
                emailLabel, emailField, questionLabel, questionArea, submitButton, backButton,successLabel );
        contactFormBox.setPadding(new Insets(20));
        contactFormBox.setStyle("-fx-background-color: rgba(255, 255, 255, 0.7);");

        VBox chatBox = new VBox(10, new Label("Chat with Bot:"), chatArea, chatInput, sendButton);
        chatBox.setPadding(new Insets(20));
        chatBox.setStyle("-fx-background-color: rgba(255, 255, 255, 0.7);");

        // Parent VBox to contain both contact form and chat interface
        VBox mainBox = new VBox(20, contactFormBox, chatBox);

        pane.getChildren().add(mainBox);
    }


    private boolean validateForm(String name, String contactNumber, String email, String question) {
        return !name.isEmpty() && !contactNumber.isEmpty() && !email.isEmpty() && !question.isEmpty();
    }
    private void removeContactForm(StackPane pane) {
        // Remove contact form
        pane.getChildren().removeIf(node -> node instanceof VBox);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
