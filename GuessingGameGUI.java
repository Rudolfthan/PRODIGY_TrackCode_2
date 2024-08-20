import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class GuessingGameGUI {
    private int numberToGuess;
    private int counter;

    public GuessingGameGUI() {
        Random r = new Random();
        numberToGuess = r.nextInt(200);
        counter = 0;

        JFrame frame = new JFrame("Guessing Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);

        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);

        frame.setVisible(true);
    }

    private void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel promptLabel = new JLabel("Enter a number:");
        promptLabel.setBounds(10, 20, 120, 25);
        panel.add(promptLabel);

        JTextField numberInput = new JTextField(20);
        numberInput.setBounds(140, 20, 165, 25);
        panel.add(numberInput);

        JButton guessButton = new JButton("Guess");
        guessButton.setBounds(10, 50, 100, 25);
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
                    } else if (guess < numberToGuess) {
                        feedbackLabel.setText("Too Low");
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
