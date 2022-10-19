import javax.swing.*;
import java.awt.event.ActionListener;

public class Kalkulatron {
    private double poprzednia = 0;

    private enum Stan {
        NULL,
        DODAJ,
        ODEJMIJ,
        MNOZ,
        DZIEL,
    }

    private Stan stan = Stan.NULL;

    public Kalkulatron() {
        ActionListener listener = e -> {
            JButton przechwytywanie = (JButton) e.getSource();
            if ((przechwytywanie.getName().charAt(0) >= '0' && przechwytywanie.getName().charAt(0) <= '9') || (przechwytywanie.getName().charAt(0) == '.')) {
                textField1.setText(textField1.getText() + przechwytywanie.getName());
            } else {
                if (!textField1.getText().equals("")) {
                    switch (przechwytywanie.getName().charAt(0)) {
                        case '+' -> {
                            dzialanie(stan);
                            stan = Stan.DODAJ;
                        }
                        case '-' -> {
                            dzialanie(stan);
                            stan = Stan.ODEJMIJ;
                        }
                        case '*' -> {
                            dzialanie(stan);
                            stan = Stan.MNOZ;
                        }
                        case '/' -> {
                            dzialanie(stan);
                            stan = Stan.DZIEL;
                        }
                        case '=' -> {
                            dzialanie(stan);
                            stan = Stan.NULL;
                            textField1.setText(String.valueOf(poprzednia));
                        }
                        case 'c' -> {
                            textField1.setText("");
                        }
                        case 'd' ->{
                            stan = Stan.NULL;
                            poprzednia = 0;
                            textField1.setText("");
                        }
                        default -> {

                        }
                    }
                }
            }
        };
        przycisk1.setName("1");
        przycisk1.addActionListener(listener);
        przycisk2.setName("2");
        przycisk2.addActionListener(listener);
        przycisk3.setName("3");
        przycisk3.addActionListener(listener);
        przycisk4.setName("4");
        przycisk4.addActionListener(listener);
        przycisk5.setName("5");
        przycisk5.addActionListener(listener);
        przycisk6.setName("6");
        przycisk6.addActionListener(listener);
        przycisk7.setName("7");
        przycisk7.addActionListener(listener);
        przycisk8.setName("8");
        przycisk8.addActionListener(listener);
        przycisk9.setName("9");
        przycisk9.addActionListener(listener);
        przycisk0.setName("0");
        przycisk0.addActionListener(listener);
        przycisk00.setName("00");
        przycisk00.addActionListener(listener);
        przycisk_kropka.setName(".");
        przycisk_kropka.addActionListener(listener);
        przycisk_plus.setName("+");
        przycisk_plus.addActionListener(listener);
        przycisk_minus.setName("-");
        przycisk_minus.addActionListener(listener);
        przycisk_mnozenie.setName("*");
        przycisk_mnozenie.addActionListener(listener);
        przycisk_dziel.setName("/");
        przycisk_dziel.addActionListener(listener);
        przycisk_rownasie.setName("=");
        przycisk_rownasie.addActionListener(listener);
        cPrzycisk.setName("c");
        cPrzycisk.addActionListener(listener);
        cePrzycisk.setName("d");
        cePrzycisk.addActionListener(listener);
    }

    private void dzialanie(Stan calc) {
        switch (calc) {
            case DODAJ -> poprzednia += Double.parseDouble(textField1.getText());
            case ODEJMIJ -> poprzednia -= Double.parseDouble(textField1.getText());
            case MNOZ -> poprzednia *= Double.parseDouble(textField1.getText());
            case DZIEL -> poprzednia /= Double.parseDouble(textField1.getText());
            default -> poprzednia = Double.parseDouble(textField1.getText());
        }
        textField1.setText("");
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Kalkulatron");
        frame.setContentPane(new Kalkulatron().rootPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private JPanel rootPanel;
    private JTextField textField1;
    private JButton przycisk7;
    private JButton przycisk8;
    private JButton przycisk4;
    private JButton przycisk5;
    private JButton przycisk1;
    private JButton przycisk2;
    private JButton przycisk3;
    private JButton przycisk6;
    private JButton przycisk9;
    private JButton przycisk0;
    private JButton przycisk00;
    private JButton przycisk_kropka;
    private JButton przycisk_plus;
    private JButton przycisk_minus;
    private JButton przycisk_mnozenie;
    private JButton przycisk_dziel;
    private JButton przycisk_rownasie;
    private JButton cPrzycisk;
    private JButton cePrzycisk;
}
