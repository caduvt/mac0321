package src.mvc;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TableView extends View implements ActionListener {

    private JTable table;
    private DefaultTableModel tableModel;

    public TableView(Controller theController, LeagueStatsModel theModel) {
        super(theController, theModel);
        populateTable();
    }

    @Override
    public void createView() {

        frame = new JFrame("Tabela do Brasileirão");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLayout(new BorderLayout());

        tableModel = new DefaultTableModel(
                new Object[][] {},
                new String[] { "Time", "Pontos", "Partidas", "Vitórias", "Empates", "Derrotas", "Gols a Favor",
                        "Gols Sofridos", "Saldo" });
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        frame.add(scrollPane, BorderLayout.CENTER);

        JPanel btnPanel = new JPanel(new GridLayout(1, 1));
        frame.add(btnPanel, BorderLayout.SOUTH);

        JButton updateButton = new JButton("Atualizar tabela");
        updateButton.addActionListener(this);
        btnPanel.add(updateButton);
    }

    public void populateTable() {
        tableModel.setRowCount(0);

        for (TeamStats team : model.getSortedResults()) {
            tableModel.addRow(new Object[] {
                    team.getName(),
                    team.getScore(),
                    team.getNumberOfMatches(),
                    team.getNumberOfWins(),
                    team.getNumberOfDraws(),
                    team.getNumberOfLosses(),
                    team.getGoalsFor(),
                    team.getGoalsAgainst(),
                    team.getGoalsDifference()
            });
        }

        table.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        populateTable();
    }
}
