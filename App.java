import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class App {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new RPSGame();
            }
        });
    }

    public static class RPSGame extends JFrame {
        // Define local variables
        private int userWins = 0;
        private int computerWins = 0;
        private int draws = 0;
        private JLabel userWinsLabel;
        private JLabel computerWinsLabel;
        private JLabel drawsLabel;

        public RPSGame() {
            // Create the main panel
            JPanel mainPanel = new JPanel();
            mainPanel.setLayout(new GridLayout(3, 1));

            // Create the buttons for the user to choose rock, paper, or scissors
            JButton rockButton = new JButton("Rock");
            JButton paperButton = new JButton("Paper");
            JButton scissorsButton = new JButton("Scissors");

            // Add action listeners to the buttons
            rockButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    playGame("rock");
                }
            });

            paperButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    playGame("paper");
                }
            });

            scissorsButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    playGame("scissors");
                }
            });

            // Add the buttons to the main panel
            mainPanel.add(rockButton);
            mainPanel.add(paperButton);
            mainPanel.add(scissorsButton);

            // Create the labels to display the number of wins, losses, and draws
            userWinsLabel = new JLabel("User Wins: " + userWins);
            computerWinsLabel = new JLabel("Computer Wins: " + computerWins);
            drawsLabel = new JLabel("Draws: " + draws);

            // Create the panel to display the labels
            JPanel labelPanel = new JPanel();
            labelPanel.add(userWinsLabel);
            labelPanel.add(computerWinsLabel);
            labelPanel.add(drawsLabel);

            // Add the main panel and the label panel to the frame
            getContentPane().add(mainPanel, BorderLayout.CENTER);
            getContentPane().add(labelPanel, BorderLayout.SOUTH);

            // Set the frame properties
            setTitle("Rock, Paper, Scissors");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setSize(500, 400);
            setLocationRelativeTo(null);
            setResizable(false);
            setVisible(true);
        }

        private void playGame(String userChoice) {
            // Generate a random choice for the computer
            String[] choices = {"rock", "paper", "scissors"};
            Random random = new Random();
            String computerChoice = choices[random.nextInt(choices.length)];

            // Determine the winner
            if (userChoice.equals(computerChoice)) {
                // It's a draw
                JOptionPane.showMessageDialog(this, "It's a draw!");
                draws++;
                drawsLabel.setText("Draws: " + draws);
            } else if (
                (userChoice.equals("rock") && computerChoice.equals("scissors"))
                || (userChoice.equals("paper") && computerChoice.equals("rock"))
                || (userChoice.equals("scissors") && computerChoice.equals("paper"))
            ) {
                // The user wins
                JOptionPane.showMessageDialog(this, "The computer chose: " + computerChoice + ". You win!");
                userWins++;
                userWinsLabel.setText("User Wins: " + userWins);
            } else {
              // The computer wins
                JOptionPane.showMessageDialog(this, "The computer chose: " + computerChoice + ". You lose!");
                computerWins++;
                computerWinsLabel.setText("Computer Wins: " + computerWins);
            }
        }
    }
}