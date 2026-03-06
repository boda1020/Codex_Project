package Controller;

import Model.User;
import DAO.UserDAO;
import DAO.Impl.UserDAOImpl;
import Utils.CurrentUser;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class ProfileStudentController {

    @FXML private Button btnBack;
    @FXML private Button btnChangePhoto;
    @FXML private Button saveButton;
    @FXML private Button cancelButton;

    @FXML private Label studentNameLabel;
    @FXML private Label studentEmailLabel;

    @FXML private TextField fullNameField;
    @FXML private TextField studentIdField;
    @FXML private TextField emailField;
    @FXML private TextField phoneField;

    @FXML private PasswordField oldPassField;
    @FXML private PasswordField newPassField;
    @FXML private PasswordField confirmPassField;

    @FXML private Circle profileCircle;
    @FXML private Text profileInitials;

    private User currentUser;
    private final UserDAO userDAO = new UserDAOImpl();

    @FXML
    private void initialize() {
        currentUser = CurrentUser.getCurrentUser();

        if (currentUser == null) {
            showAlert("Error", "Unable to load profile. Please login again.", Alert.AlertType.ERROR);
            return;
        }

        loadProfileData();
    }

    private void loadProfileData() {
        studentNameLabel.setText(currentUser.getFullName());
        studentEmailLabel.setText(currentUser.getEmail());

        fullNameField.setText(currentUser.getFullName());
        studentIdField.setText(currentUser.getUsername());
        emailField.setText(currentUser.getEmail());
        phoneField.setText(currentUser.getPhone() != null ? currentUser.getPhone() : "");

        // التعامل مع الصورة بشكل آمن
        boolean imageLoaded = false;

        String imagePath = currentUser.getProfileImagePath();
        if (imagePath != null && !imagePath.trim().isEmpty()) {
            File file = new File(imagePath);
            if (file.exists() && file.isFile()) {
                try {
                    Image image = new Image(file.toURI().toString(), false);
                    profileCircle.setFill(new ImagePattern(image));
                    profileInitials.setVisible(false);
                    imageLoaded = true;
                } catch (Exception e) {
                    // أي خطأ أثناء تحميل الصورة هيرجع للصورة الافتراضية
                    imageLoaded = false;
                }
            }
        }

        if (!imageLoaded) {
            // لو الصورة مش موجودة أو حصل خطأ، نعرض اللون الافتراضي مع الأوليات
            setupDefaultCircle();
        }

        // تحديث الأوليات
        updateInitials();
    }

    private void setupDefaultCircle() {
        profileCircle.setFill(javafx.scene.paint.Color.web("#262451"));
        profileCircle.setStroke(javafx.scene.paint.Color.web("#1a1d3d"));
        profileCircle.setStrokeWidth(5);
        profileInitials.setVisible(true);
    }

    private void updateInitials() {
        String name = currentUser.getFullName();
        if (name != null && !name.isEmpty()) {
            String[] parts = name.split("\\s+");
            StringBuilder initials = new StringBuilder();
            if (parts.length > 0) initials.append(Character.toUpperCase(parts[0].charAt(0)));
            if (parts.length > 1) initials.append(Character.toUpperCase(parts[1].charAt(0)));
            profileInitials.setText(initials.toString());
        }
    }

    @FXML
    private void handleChangePhoto() {
        FileChooser chooser = new FileChooser();
        chooser.setTitle("Select Profile Picture");
        chooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg", "*.gif")
        );

        Stage stage = (Stage) btnChangePhoto.getScene().getWindow();
        File file = chooser.showOpenDialog(stage);

        if (file != null) {
            Image image = new Image(file.toURI().toString());
            profileCircle.setFill(new ImagePattern(image));
            profileInitials.setVisible(false);

            currentUser.setProfileImagePath(file.getAbsolutePath());
            userDAO.updateProfileImage(currentUser.getUserId(), file.getAbsolutePath());
        }
    }

    @FXML
    private void handleSaveChanges() {
        // Validation بسيطة (يمكن توسيعها)
        if (fullNameField.getText().trim().isEmpty() || emailField.getText().trim().isEmpty()) {
            showAlert("Error", "Full Name and Email are required!", Alert.AlertType.ERROR);
            return;
        }

        if (!newPassField.getText().isEmpty()) {
            if (!newPassField.getText().equals(confirmPassField.getText())) {
                showAlert("Error", "New password and confirmation do not match!", Alert.AlertType.ERROR);
                return;
            }
            // يمكن إضافة تحقق من الباسورد القديم لو عايز
        }

        currentUser.setFullName(fullNameField.getText().trim());
        currentUser.setEmail(emailField.getText().trim());
        currentUser.setPhone(phoneField.getText().trim());

        if (!newPassField.getText().isEmpty()) {
            currentUser.setPasswordHash(newPassField.getText());  // نص عادي
        }

        boolean success = userDAO.updateUser(currentUser);

        if (success) {
            CurrentUser.setCurrentUser(currentUser);
            loadProfileData();
            clearPasswordFields();
            showAlert("Success", "Profile updated successfully!", Alert.AlertType.INFORMATION);
        } else {
            showAlert("Error", "Failed to update profile.", Alert.AlertType.ERROR);
        }
    }

    @FXML
    private void handleCancel() {
        loadProfileData();
        clearPasswordFields();
    }

    private void clearPasswordFields() {
        oldPassField.clear();
        newPassField.clear();
        confirmPassField.clear();
    }

    @FXML
    private void handleBack() {
        loadScene("/View/Student_dashboard.fxml");
    }

    // الـ hover effects اللي كان ناقص
    @FXML
    private void handleMouseEnter(MouseEvent event) {
        Node node = (Node) event.getSource();
        node.setStyle(node.getStyle() + "-fx-background-color: #1a1d3d; -fx-scale-x: 1.05; -fx-scale-y: 1.05;");
    }

    @FXML
    private void handleMouseExit(MouseEvent event) {
        Node node = (Node) event.getSource();
        // نرجع الـ style الأصلي (يمكن تحسينه بتخزين الـ style القديم)
        if (node instanceof Button) {
            if (node == btnBack || node == saveButton) {
                node.setStyle("-fx-background-color: #262451; -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 25; -fx-padding: 12 30; -fx-scale-x: 1; -fx-scale-y: 1;");
            } else if (node == cancelButton) {
                node.setStyle("-fx-background-color: #64748b; -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 16; -fx-padding: 16 55; -fx-scale-x: 1; -fx-scale-y: 1;");
            } else if (node == btnChangePhoto) {
                node.setStyle("-fx-background-color: transparent; -fx-text-fill: #262451; -fx-font-weight: bold; -fx-border-color: #262451; -fx-border-width: 2; -fx-border-radius: 30; -fx-padding: 12 35; -fx-scale-x: 1; -fx-scale-y: 1;");
            }
        }
    }

    private void loadScene(String fxmlPath) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(fxmlPath));
            Stage stage = (Stage) btnBack.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.centerOnScreen();
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showAlert(String title, String message, Alert.AlertType type) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}