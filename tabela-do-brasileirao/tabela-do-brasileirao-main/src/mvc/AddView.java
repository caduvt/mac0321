package src.mvc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddView extends View implements ActionListener {

    private JTextField homeTeamField;
    private JTextField visitorTeamField;
    private JTextField homeGoalsField;
    private JTextField visitorGoalsField;

    public AddView(Controller controller, LeagueStatsModel model) {
        super(controller, model);
    }

    @Override
    public void createView() {
        frame = new JFrame("Adicionar Partida");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(4, 2));
        inputPanel.add(new JLabel("Time Casa:"));
        homeTeamField = new JTextField(10);
        inputPanel.add(homeTeamField);

        inputPanel.add(new JLabel("Time Visitante:"));
        visitorTeamField = new JTextField(10);
        inputPanel.add(visitorTeamField);

        inputPanel.add(new JLabel("Gols Time Casa:"));
        homeGoalsField = new JTextField(4);
        inputPanel.add(homeGoalsField);

        inputPanel.add(new JLabel("Gols Time Visitante:"));
        visitorGoalsField = new JTextField(4);
        inputPanel.add(visitorGoalsField);

        frame.add(inputPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new GridLayout(1, 2));
        JButton addButton = new JButton("Adicionar");
        addButton.addActionListener(this);
        buttonPanel.add(addButton);

        JButton cancelButton = new JButton("Cancelar");
        cancelButton.addActionListener(e -> frame.setVisible(false));
        buttonPanel.add(cancelButton);

        frame.add(buttonPanel, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String homeTeam = getHomeTeam();
            String visitorTeam = getVisitorTeam();
            int homeGoals = getHomeGoals();
            int visitorGoals = getVisitorGoals();

            try {
                model.addResult(homeTeam, homeGoals, visitorTeam, visitorGoals);
            } catch (Exception err) {
                showMessage(err.getMessage());
            }

            clearFields();

        } catch (NumberFormatException ex) {
            showMessage("Erro ao adicionar partida. Verifique os valores.");
        }
    }

    public String getHomeTeam() {
        return homeTeamField.getText();
    }

    public String getVisitorTeam() {
        return visitorTeamField.getText();
    }

    public int getHomeGoals() {
        return Integer.parseInt(homeGoalsField.getText());
    }

    public int getVisitorGoals() {
        return Integer.parseInt(visitorGoalsField.getText());
    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(frame, message);
    }

    public void clearFields() {
        homeTeamField.setText("");
        visitorTeamField.setText("");
        homeGoalsField.setText("");
        visitorGoalsField.setText("");
    }
}
