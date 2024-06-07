import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Chess extends JFrame {

    // Создаем кнопки для выбора фигуры
    private final JButton kingButton;
    private final JButton queenButton;
    private final JButton rookButton;
    private final JButton bishopButton;
    private final JButton knightButton;
    private final JButton pawnButton;

    public Chess() {
        super("Обучение ходам");
        setLayout(new FlowLayout());

        // Создаем кнопки для выбора фигуры
        kingButton = new JButton("Король");
        queenButton = new JButton("Королева");
        rookButton = new JButton("Ладья");
        bishopButton = new JButton("Слон");
        knightButton = new JButton("Конь");
        pawnButton = new JButton("Пешка");

        add(kingButton);
        add(queenButton);
        add(rookButton);
        add(bishopButton);
        add(knightButton);
        add(pawnButton);

        // Добавляем слушатели событий для кнопок
        kingButton.addActionListener((ActionEvent e) -> {
            showChessBoard("Король");
        });

        queenButton.addActionListener((ActionEvent e) -> {
            showChessBoard("Королева");
        });

        rookButton.addActionListener((ActionEvent e) -> {
            showChessBoard("Ладья");
        });

        bishopButton.addActionListener((ActionEvent e) -> {
            showChessBoard("Слон");
        });

        knightButton.addActionListener((ActionEvent e) -> {
            showChessBoard("Конь");
        });

        pawnButton.addActionListener((ActionEvent e) -> {
            showChessBoard("Пешка");
        });

        setSize(300, 100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    // Метод для отображения шахматной доски
    private void showChessBoard(String piece) {
        JFrame frame = new JFrame("Шахматная доска - " + piece);
        frame.setLayout(new GridLayout(8, 8));

        for (int i = 0; i < 64; i++) {
            JPanel panel = new JPanel();
            // Добавляем окантовку клеток
            panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            // Окрашиваем клетки в чередующиеся цвета
            panel.setBackground((i + (i / 8)) % 2 == 0 ? Color.WHITE : Color.GRAY);
            frame.add(panel);

            // Добавляем фигуру на доску
            switch (piece) {
                case "Король" -> {
                    if (i == 27) {
                        JLabel label = new JLabel("К");
                        label.setFont(new Font("Arial", Font.BOLD, 24));
                        panel.add(label);
                    } else if (isKingMoveValid(i, 27)) {
                        panel.setBackground(Color.GREEN);
                    }
                }
                case "Королева" -> {
                    if (i == 27) {
                        JLabel label = new JLabel("Кр");
                        label.setFont(new Font("Arial", Font.BOLD, 24));
                        panel.add(label);
                    } else if (isQueenMoveValid(i, 27)) {
                        panel.setBackground(Color.GREEN);
                    }
                }
                case "Ладья" -> {
                    if (i == 27) {
                        JLabel label = new JLabel("Л");
                        label.setFont(new Font("Arial", Font.BOLD, 24));
                        panel.add(label);
                    } else if (isRookMoveValid(i, 27)) {
                        panel.setBackground(Color.GREEN);
                    }
                }
                case "Слон" -> {
                    if (i == 27) {
                        JLabel label = new JLabel("С");
                        label.setFont(new Font("Arial", Font.BOLD, 24));
                        panel.add(label);
                    } else if (isBishopMoveValid(i, 27)) {
                        panel.setBackground(Color.GREEN);
                    }
                }
                case "Конь" -> {
                    if (i == 27) {
                        JLabel label = new JLabel("К");
                        label.setFont(new Font("Arial", Font.BOLD, 24));
                        panel.add(label);
                    } else if (isKnightMoveValid(i, 27)) {
                        panel.setBackground(Color.GREEN);
                    }
                }
                case "Пешка" -> {
                    if (i == 27) {
                        JLabel label = new JLabel("П");
                        label.setFont(new Font("Arial", Font.BOLD, 24));
                        panel.add(label);
                    } else if (isPawnMoveValid(i, 27)) {
                        panel.setBackground(Color.GREEN);
                    }
                }
                default -> {
                }
            }
        }

        frame.setSize(800, 800);
        frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }

    // Метод для проверки хода короля
    private boolean isKingMoveValid(int i, int center) {
        int x = i % 8;
        int y = i / 8;
        int centerX = center % 8;
        int centerY = center / 8;

        return Math.abs(x - centerX) <= 1 && Math.abs(y - centerY) <= 1;
    }

    // Метод для проверки хода королевы
    private boolean isQueenMoveValid(int i, int center) {
        int x = i % 8;
        int y = i / 8;
        int centerX = center % 8;
        int centerY = center / 8;

        return Math.abs(x - centerX) == Math.abs(y - centerY) || x == centerX || y == centerY;
    }

    // Метод для проверки хода ладьи
    private boolean isRookMoveValid(int i, int center) {
        int x = i % 8;
        int y = i / 8;
        int centerX = center % 8;
        int centerY = center / 8;

        return x == centerX || y == centerY;
    }

    // Метод для проверки хода слона
    private boolean isBishopMoveValid(int i, int center) {
        int x = i % 8;
        int y = i / 8;
        int centerX = center % 8;
        int centerY = center / 8;

        return Math.abs(x - centerX) == Math.abs(y - centerY);
    }

    // Метод для проверки хода коня
    private boolean isKnightMoveValid(int i, int center) {
        int x = i % 8;
        int y = i / 8;
        int centerX = center % 8;
        int centerY = center / 8;

        return (Math.abs(x - centerX) == 2 && Math.abs(y - centerY) == 1) || (Math.abs(x - centerX) == 1 && Math.abs(y - centerY) == 2);
    }

    // Метод для проверки хода пешки
    private boolean isPawnMoveValid(int i, int center) {
        int x = i % 8;
        int y = i / 8;
        int centerX = center % 8;
        int centerY = center / 8;

        // Пешка может ходить на одну клетку вперед
        if (x == centerX && Math.abs(y - centerY) == 1) {
            return true;
        }

        // Пешка может ходить на две клетки вперед при первом ходе
        if (centerY == 1 && y == 3 && x == centerX) {
            return true;
        }

        // Пешка может ходить на одну клетку по диагонали, если на этой клетке находится фигура противника
        if (Math.abs(x - centerX) == 1 && Math.abs(y - centerY) == 1) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Chess());
    }
}