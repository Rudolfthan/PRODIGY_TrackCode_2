import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GuessingGameGUI {
    private int numberToGuess;
    private int counter;

    public GuessingGameGUI() {
        Random r = new Random();
        numberToGuess = r.nextInt(200);
        counter = 0;

        JFrame frame = new JFrame("Guessing Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(340, 180);

        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);

        frame.setVisible(true);
    }

    private void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel promptLabel = new JLabel("Enter a number from 0 to 200:");
        promptLabel.setBounds(10, 20, 200, 25);
        panel.add(promptLabel);

        JTextField numberInput = new JTextField(20);
        numberInput.setBounds(240, 20, 65, 25);
        panel.add(numberInput);

        JButton guessButton = new JButton("Guess");
        guessButton.setBounds(120, 50, 100, 25);
        panel.add(guessButton);

        JLabel feedbackLabel = new JLabel("");
        feedbackLabel.setBounds(10, 80, 300, 25);
        panel.add(feedbackLabel);

        JLabel attemptsLabel = new JLabel("");
        attemptsLabel.setBounds(10, 110, 300, 25);
        panel.add(attemptsLabel);

        guessButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int guess = Integer.parseInt(numberInput.getText());
                    counter++;

                    if (guess > numberToGuess) {
                        feedbackLabel.setText("Too High");
                        attemptsLabel.setText("Attempts: " + counter);
                    } else if (guess < numberToGuess) {
                        feedbackLabel.setText("Too Low");
                        attemptsLabel.setText("Attempts: " + counter);
                    } else {
                        feedbackLabel.setText("Correct number!!!!!!!!!!!!!!!");
                        attemptsLabel.setText("Attempts: " + counter);
                        guessButton.setEnabled(false);
                    }
                } catch (NumberFormatException ex) {
                    feedbackLabel.setText("Please enter a valid number.");
                }
            }
        });
    }

    public static void main(String[] args) {
        new GuessingGameGUI();
    }
}
