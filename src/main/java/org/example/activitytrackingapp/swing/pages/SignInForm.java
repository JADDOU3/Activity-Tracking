package org.example.activitytrackingapp.swing.pages;

import org.example.activitytrackingapp.swing.assets.Button;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class SignInForm extends JFrame {

    private JTextField emailField;
    private JPasswordField passwordField;
    private JCheckBox rememberMeCheckBox;
    private Button signInButton;

    public SignInForm() {
        setTitle("Sign In");
        setSize(400, 530);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setBackground(Color.WHITE);

        // Main container panel
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(Color.WHITE);
        mainPanel.setBorder(new EmptyBorder(40, 40, 40, 40));
        add(mainPanel);

        // Header panel
        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new BoxLayout(headerPanel, BoxLayout.Y_AXIS));
        headerPanel.setBackground(Color.WHITE);
        headerPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // App icon
        JLabel iconLabel = new JLabel();
        iconLabel.setIcon(new ImageIcon("src/main/java/org/example/activitytrackingapp/swing/assets/market-research.png"));
        iconLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        iconLabel.setBorder(new EmptyBorder(0, 0, 20, 0));

        // Title
        JLabel titleLabel = new JLabel("Welcome Back");
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 24));
        titleLabel.setForeground(new Color(44, 62, 80));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        titleLabel.setBorder(new EmptyBorder(0, 0, 30, 0));

        headerPanel.add(iconLabel);
        headerPanel.add(titleLabel);
        mainPanel.add(headerPanel, BorderLayout.NORTH);

        // Form panel
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.Y_AXIS));
        formPanel.setBackground(Color.WHITE);

        // Email field
        JPanel emailPanel = new JPanel(new BorderLayout());
        emailPanel.setBackground(Color.WHITE);
        emailPanel.setBorder(new EmptyBorder(0, 0, 20, 0));

        JLabel emailLabel = new JLabel("Email");
        emailLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        emailLabel.setForeground(new Color(44, 62, 80));
        emailLabel.setBorder(new EmptyBorder(0, 0, 5, 0));

        emailField = new JTextField();
        emailField.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(200, 200, 200)),
                BorderFactory.createEmptyBorder(10, 15, 10, 15)));
        emailField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        emailField.setMaximumSize(new Dimension(Integer.MAX_VALUE, 45));

        emailPanel.add(emailLabel, BorderLayout.NORTH);
        emailPanel.add(emailField, BorderLayout.CENTER);
        formPanel.add(emailPanel);

        // Password field
        JPanel passwordPanel = new JPanel(new BorderLayout());
        passwordPanel.setBackground(Color.WHITE);
        passwordPanel.setBorder(new EmptyBorder(0, 0, 20, 0));

        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        passwordLabel.setForeground(new Color(44, 62, 80));
        passwordLabel.setBorder(new EmptyBorder(0, 0, 5, 0));

        JPanel passwordFieldPanel = new JPanel(new BorderLayout());
        passwordFieldPanel.setBackground(Color.WHITE);

        passwordField = new JPasswordField();
        passwordField.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(200, 200, 200)),
                BorderFactory.createEmptyBorder(10, 15, 10, 40)));
        passwordField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        passwordField.setMaximumSize(new Dimension(Integer.MAX_VALUE, 45));



        passwordFieldPanel.add(passwordField, BorderLayout.CENTER);

        passwordPanel.add(passwordLabel, BorderLayout.NORTH);
        passwordPanel.add(passwordFieldPanel, BorderLayout.CENTER);
        formPanel.add(passwordPanel);

        // Remember me and forgot password
        JPanel optionsPanel = new JPanel(new BorderLayout());
        optionsPanel.setBackground(Color.WHITE);
        optionsPanel.setBorder(new EmptyBorder(0, 0, 30, 0));

        rememberMeCheckBox = new JCheckBox("Remember me");
        rememberMeCheckBox.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        rememberMeCheckBox.setBackground(Color.WHITE);
        rememberMeCheckBox.setForeground(new Color(44, 62, 80));

        JLabel forgotPasswordLabel = new JLabel("Forgot password?");
        forgotPasswordLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        forgotPasswordLabel.setForeground(new Color(52, 152, 219));
        forgotPasswordLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        optionsPanel.add(rememberMeCheckBox, BorderLayout.WEST);
        optionsPanel.add(forgotPasswordLabel, BorderLayout.EAST);
        formPanel.add(optionsPanel);

        // Sign in button
        signInButton = new Button();
        signInButton.setText("Sign In");
        signInButton.setColor(new Color(52, 73, 94));
        signInButton.setColorOver(new Color(41, 57, 74));
        signInButton.setColorClick(new Color(56, 68, 81));
        signInButton.setBorderColor(new Color(27, 41, 51));
        signInButton.setForeground(Color.WHITE);
        signInButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
        signInButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        signInButton.setMaximumSize(new Dimension(Integer.MAX_VALUE, 45));
        signInButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        signInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle sign in logic here
                String email = emailField.getText();
                String password = new String(passwordField.getPassword());

                if (email.isEmpty() || password.isEmpty()) {
                    JOptionPane.showMessageDialog(SignInForm.this,
                            "Please fill in all fields",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                } else {
                    // Successful login - open dashboard
                    new Dashboard().setVisible(true);
                    dispose();
                }
            }
        });

        formPanel.add(signInButton);

        // Sign up link
        JPanel signUpPanel = new JPanel();
        signUpPanel.setBackground(Color.WHITE);
        signUpPanel.setBorder(new EmptyBorder(20, 0, 0, 0));

        JLabel signUpLabel = new JLabel("Don't have an account? ");
        signUpLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        signUpLabel.setForeground(new Color(44, 62, 80));

        JLabel signUpLink = new JLabel("Sign Up");
        signUpLink.setFont(new Font("Segoe UI", Font.BOLD, 12));
        signUpLink.setForeground(new Color(52, 152, 219));
        signUpLink.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        signUpLink.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Open sign up form
                JOptionPane.showMessageDialog(SignInForm.this,
                        "Redirect to sign up form",
                        "Sign Up",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });

        signUpPanel.add(signUpLabel);
        signUpPanel.add(signUpLink);
        formPanel.add(signUpPanel);

        mainPanel.add(formPanel, BorderLayout.CENTER);

        // Set default button for Enter key
        getRootPane().setDefaultButton(signInButton);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                SignInForm signInForm = new SignInForm();
                signInForm.setVisible(true);
            }
        });
    }
}