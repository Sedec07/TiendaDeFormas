
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

abstract class Forma {
    public abstract double area();
}

class Circulo extends Forma {
    private final double radio;

    public Circulo(double radio) {
        this.radio = radio;
    }

    @Override
    public double area() {
        return Math.PI * radio * radio;
    }
}

class Rectangulo extends Forma {
    private final double ancho;
    private final double alto;

    public Rectangulo(double ancho, double alto) {
        this.ancho = ancho;
        this.alto = alto;
    }

    @Override
    public double area() {
        return ancho * alto;
    }
}

public class TiendaDeFormas extends JFrame {
    private ArrayList<Forma> formas;
    private JTextArea textArea;

    public TiendaDeFormas() {
        formas = new ArrayList<>();
        setTitle("Tienda de Formas Geométricas");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JButton agregarCirculoButton = new JButton("Agregar Círculo");
        JButton agregarRectanguloButton = new JButton("Agregar Rectángulo");
        JButton calcularAreaButton = new JButton("Calcular Áreas");

        textArea = new JTextArea();
        textArea.setEditable(false);
        
        agregarCirculoButton.addActionListener((ActionEvent e) -> {
            String input = JOptionPane.showInputDialog("Ingrese el radio del círculo:");
            if (input != null) {
                double radio = Double.parseDouble(input);
                formas.add(new Circulo(radio));
                textArea.append("Círculo agregado con radio: " + radio + "\n");
            }
        });

        agregarRectanguloButton.addActionListener((ActionEvent e) -> {
            String anchoInput = JOptionPane.showInputDialog("Ingrese el ancho del rectángulo:");
            String altoInput = JOptionPane.showInputDialog("Ingrese la altura del rectángulo:");
            if (anchoInput != null && altoInput != null) {
                double ancho = Double.parseDouble(anchoInput);
                double alto = Double.parseDouble(altoInput);
                formas.add(new Rectangulo(ancho, alto));
                textArea.append("Rectángulo agregado con ancho: " + ancho + " y altura: " + alto + "\n");
            }
        });

        calcularAreaButton.addActionListener((ActionEvent e) -> {
            textArea.append("Áreas:\n");
            for (Forma forma : formas) {
                textArea.append("Área: " + forma.area() + "\n");
            }
        });
        //agregar panel
        JPanel panel = new JPanel();
        panel.add(agregarCirculoButton);
        panel.add(agregarRectanguloButton);
        panel.add(calcularAreaButton);

        add(panel, BorderLayout.NORTH);
        add(new JScrollPane(textArea), BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TiendaDeFormas tienda = new TiendaDeFormas();
            tienda.setVisible(true);
        });
    }
}
