import javax.swing.*;
import javax.swing.table.TableColumn;

public class prototype {
    private JPanel mainPanel;
    private JPanel radioPanel;
    private JPanel buttonPanel;
    private JRadioButton addRadioButton;
    private JRadioButton removeEditRadioButton;
    private JTable table1;
    private JButton clearButton;
    private JButton submitButton;
    private JPanel tablePanel;

    public prototype() {

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("prototype");
        frame.setContentPane(new prototype().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
