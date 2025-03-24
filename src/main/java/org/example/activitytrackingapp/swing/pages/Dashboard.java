package org.example.activitytrackingapp.swing.pages;

import org.example.activitytrackingapp.component.ActivityScheduler;
import org.example.activitytrackingapp.component.SessionManager;
import org.example.activitytrackingapp.entity.Customer;
import org.example.activitytrackingapp.repository.ActivityRepo;
import org.example.activitytrackingapp.services.TrackService;
import org.example.activitytrackingapp.swing.assets.Button;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dashboard extends JFrame {

    private JPanel sidePanel;
    private JPanel contentPanel;
    private Button logoutButton;
    private JLabel profileImageLabel;
    private Button startTrackingButton;
    private Button openWebsiteButton;

    private Customer customer;
    private ActivityScheduler activityScheduler;
    private TrackService trackService;
    private ActivityRepo activityRepo;
    private SessionManager sessionManager;

    public Dashboard() {
        setTitle("Activity Dashboard");
        setSize(1000, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setBackground(Color.white);
        // Main container panel
        setLayout(new BorderLayout());

        trackService = new TrackService(activityRepo);
        activityScheduler = new ActivityScheduler(trackService);
        customer = SessionManager.getCurrentCustomer();

        // Side panel (left) - contains profile image and logout button
        sidePanel = new JPanel();
        sidePanel.setLayout(new BoxLayout(sidePanel, BoxLayout.Y_AXIS));
        sidePanel.setBackground(new Color(44, 62, 80));  // Dark blue background
        sidePanel.setPreferredSize(new Dimension(200, 0));  // Smaller width
        sidePanel.setBorder(new EmptyBorder(20, 20, 20, 20));

        // Decorative header panel
        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new BorderLayout());
        headerPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 120));
        headerPanel.setBackground(new Color(44, 62, 80));

        // App Icon (Optional)
        JLabel iconLabel = new JLabel();
        iconLabel.setIcon(new ImageIcon("src/main/java/org/example/activitytrackingapp/swing/assets/icons/market-research.png"));
        iconLabel.setHorizontalAlignment(SwingConstants.CENTER);
        iconLabel.setPreferredSize(new Dimension(100, 120));
        iconLabel.setBorder(new EmptyBorder(10, 0, 10, 0));

        // App Name Title
        JLabel titleLabel = new JLabel("Activity Tracker");
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setBorder(new EmptyBorder(20, 0, 0, 0));  // Add padding to move the title lower

        // Add icon and title
        headerPanel.add(iconLabel, BorderLayout.NORTH);
        headerPanel.add(titleLabel, BorderLayout.CENTER);

        // Add header panel to the side panel
        sidePanel.add(headerPanel);

        // Padding
        sidePanel.add(Box.createVerticalStrut(30));

        // Add vertical glue to push the logout button to the bottom
        sidePanel.add(Box.createVerticalGlue());

        // Logout button
        logoutButton = new Button();
        logoutButton.setText("Logout");
        logoutButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        logoutButton.setMaximumSize(new Dimension(Integer.MAX_VALUE, 50));  // Full width
        logoutButton.setColor(new Color(52, 73, 94));
        logoutButton.setBackground(new Color(52, 73, 94));  // Matching dark blue
        logoutButton.setColorOver(new Color(41, 57, 74));
        logoutButton.setColorClick(new Color(56, 68, 81));
        logoutButton.setBorderColor(new Color(27, 41, 51));
        logoutButton.setForeground(Color.WHITE);
        logoutButton.setFocusPainted(false);
        logoutButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
        logoutButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Logged out successfully!");
                sessionManager.logout();
                System.exit(0);  // Close application or redirect to login page
            }
        });
        sidePanel.add(logoutButton);

        // Content panel (right) - contains dashboard chart and buttons
        contentPanel = new JPanel();
        contentPanel.setLayout(new BorderLayout());
        contentPanel.setBackground(new Color(255, 255, 255));  // Light grey background

        // Create a simple bar chart
        JFreeChart chart = createChart(createDataset());
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setBackground(new Color(255, 255, 255));
        chartPanel.setPreferredSize(new Dimension(600, 400));
        chartPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        contentPanel.add(chartPanel, BorderLayout.CENTER);

        // Bottom-right corner buttons panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 20, 20));
        buttonPanel.setBackground(new Color(255, 255, 255));

        // Open Website button
        openWebsiteButton = new Button();
        openWebsiteButton.setText("More Details");
        openWebsiteButton.setColor(new Color(52, 73, 94));
        openWebsiteButton.setBackground(new Color(52, 73, 94));  // Matching dark blue
        openWebsiteButton.setColorOver(new Color(41, 57, 74));
        openWebsiteButton.setColorClick(new Color(56, 68, 81));
        openWebsiteButton.setBorderColor(new Color(27, 41, 51));
        openWebsiteButton.setForeground(Color.WHITE);
        openWebsiteButton.setFocusPainted(false);
        openWebsiteButton.setFont(new Font("Segoe UI", Font.BOLD, 12));
        openWebsiteButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        openWebsiteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Opening website...");
                //Todo Open your website or full details view here
            }
        });

        // Start Tracking button
        startTrackingButton = new Button();
        startTrackingButton.setText("Start Tracking");
        startTrackingButton.setColor(new Color(52, 73, 94));
        startTrackingButton.setBackground(new Color(52, 73, 94));  // Matching dark blue
        startTrackingButton.setColorOver(new Color(41, 57, 74));
        startTrackingButton.setColorClick(new Color(56, 68, 81));
        startTrackingButton.setBorderColor(new Color(27, 41, 51));
        startTrackingButton.setForeground(Color.WHITE);
        startTrackingButton.setFocusPainted(false);
        startTrackingButton.setFont(new Font("Segoe UI", Font.BOLD, 12));
        startTrackingButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        startTrackingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!activityScheduler.isTracking()) {
                    activityScheduler.startTracking();
                    startTrackingButton.setText("Tracking...");
                    startTrackingButton.setColor(new Color(107, 120, 136));
                    startTrackingButton.setBackground(new Color(107, 120, 136));  // Matching dark blue
                    startTrackingButton.setColorOver(new Color(67, 73, 90));
                    startTrackingButton.setColorClick(new Color(59, 66, 74));
                    startTrackingButton.setBorderColor(new Color(84, 91, 103));
                    JOptionPane.showMessageDialog(null, "Tracking started!");
                } else {
                    activityScheduler.stopTracking();
                    startTrackingButton.setText("Start Tracking");
                    startTrackingButton.setColor(new Color(52, 73, 94));
                    startTrackingButton.setBackground(new Color(52, 73, 94));  // Matching dark blue
                    startTrackingButton.setColorOver(new Color(41, 57, 74));
                    startTrackingButton.setColorClick(new Color(56, 68, 81));
                    startTrackingButton.setBorderColor(new Color(27, 41, 51));
                    JOptionPane.showMessageDialog(null, "Tracking Stoped!");
                }
            }
        });

        // Add the buttons to the panel
        buttonPanel.add(openWebsiteButton);
        buttonPanel.add(startTrackingButton);

        contentPanel.add(buttonPanel, BorderLayout.SOUTH);

        // Add side panel and content panel to main frame
        add(sidePanel, BorderLayout.WEST);
        add(contentPanel, BorderLayout.CENTER);
    }

    // Method to create dataset for the chart
    private DefaultCategoryDataset createDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        // Sample data for app usage period each day
        dataset.addValue(5, "Usage", "Monday");
        dataset.addValue(7, "Usage", "Tuesday");
        dataset.addValue(6, "Usage", "Wednesday");
        dataset.addValue(8, "Usage", "Thursday");
        dataset.addValue(4, "Usage", "Friday");
        dataset.addValue(9, "Usage", "Saturday");
        dataset.addValue(3, "Usage", "Sunday");

        return dataset;
    }

    // Method to create the chart
    private JFreeChart createChart(DefaultCategoryDataset dataset) {
        JFreeChart chart = ChartFactory.createBarChart(
                "App Usage Period", // Chart title
                "App",
                "App Usage (Hours)",
                dataset, // Dataset
                PlotOrientation.HORIZONTAL, // Chart orientation
                true, // Include legend
                true, // Tooltips
                false // URLs
        );

        // Customize chart appearance
        chart.setBackgroundPaint(new Color(255, 255, 255));
        CategoryPlot plot = chart.getCategoryPlot();
        BarRenderer renderer = (BarRenderer) plot.getRenderer();
        renderer.setSeriesPaint(0, new Color(107, 120, 136)); // Modern Blue

        // Optional: remove gridlines for a cleaner look
        plot.setRangeGridlinePaint(new Color(255, 255, 255));

        return chart;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Dashboard dashboard = new Dashboard();
                dashboard.setVisible(true);
            }
        });
    }
}