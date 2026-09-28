import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class DrawShapesAtClick extends JFrame {
    private ArrayList<Shape> shapes;
    private String shapeChoice;

    public DrawShapesAtClick() {
        setTitle("Draw Shapes at Mouse Clicks");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        shapes = new ArrayList<>();
        shapeChoice = "C";
        JPanel drawingPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                shapes.forEach(shape -> shape.draw(g));
            }
        };
        drawingPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();
                switch (shapeChoice) {
                    case "S":
                        shapes.add(new Square(x, y, 40));
                        break;
                    case "E":
                        shapes.add(new Ellipse(x, y, 50, 30));
                        break;
                    case "R":
                        shapes.add(new Rectangle(x, y, 70, 40));
                        break;
                    default:
                        shapes.add(new Circle(x, y, 30));
                }
                drawingPanel.repaint();
            }

        });
        drawingPanel.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char keyChar = Character.toLowerCase(e.getKeyChar());
                if ("cser".indexOf(keyChar) != -1) {
                    shapeChoice = Character.toString(keyChar).toUpperCase();
                }
            }
        });
        drawingPanel.setFocusable(true);
        drawingPanel.requestFocusInWindow();
        add(drawingPanel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            DrawShapesAtClick frame = new DrawShapesAtClick();
            frame.setVisible(true);
        });
    }

    private interface Shape {
        void draw(Graphics g);
    }

    private static class Circle implements Shape {
        private int x, y, radius;

        public Circle(int x, int y, int radius) {
            this.x = x;
            this.y = y;
            this.radius = radius;
        }

        @Override
        public void draw(Graphics g) {
            g.setColor(Color.RED);
            g.drawOval(x - radius, y - radius, radius * 2, radius * 2);
        }
    }

    private static class Square implements Shape {
        private int x, y, side;

        public Square(int x, int y, int side) {
            this.x = x;
            this.y = y;
            this.side = side;
        }

        @Override
        public void draw(Graphics g) {
            g.setColor(Color.BLUE);
            g.drawRect(x - side / 2, y - side / 2, side, side);
        }
    }

    private static class Ellipse implements Shape {
        private int x, y, width, height;

        public Ellipse(int x, int y, int width, int height) {
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
        }

        @Override
        public void draw(Graphics g) {
            g.setColor(Color.GREEN);
            g.drawOval(x - width / 2, y - height / 2, width, height);
        }
    }

    private static class Rectangle implements Shape {
        private int x, y, width, height;

        public Rectangle(int x, int y, int width, int height) {
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
        }

        @Override
        public void draw(Graphics g) {
            g.setColor(Color.ORANGE);
            g.drawRect(x - width / 2, y - height / 2, width, height);
        }
    }
}