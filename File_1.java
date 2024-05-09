import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class File_1 {
// Создание окна
    public static void main(String[] args) {
        JFrame frame = new JFrame("Шифр цезаря");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField inputField = new JTextField(20);
        JTextField outputField = new JTextField(20);
        JTextField shiftField = new JTextField(5);
        JButton encryptButton = new JButton("Шифровать!");

        JPanel panel = new JPanel();
        panel.add(new JLabel("Ведите текст: "));
        panel.add(inputField);
        panel.add(new JLabel("Введите сдвиг: "));
        panel.add(shiftField);
        panel.add(encryptButton);
        panel.add(new JLabel("Зашифрованый текст: "));
        panel.add(outputField);
// Код кнопок и панелек 
        encryptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputText = inputField.getText();
                int shift = Integer.parseInt(shiftField.getText());
                String cipherText = encrypt(inputText, shift);
                outputField.setText(cipherText);
            }
        });

        frame.add(panel);
        frame.setVisible(true);
    }
// Шифрование
    public static String encrypt(String text, int shift) {
        StringBuilder result = new StringBuilder();

        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isLowerCase(c) ? 'a' : 'A';
                c = (char) ((c - base + shift) % 26 + base);
            }
            result.append(c);
        }

        return result.toString();
    }
}