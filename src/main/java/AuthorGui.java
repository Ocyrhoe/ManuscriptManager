import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AuthorGui extends JFrame {

    private JPanel managementPanel;
    private JPanel entryPanel;
    private JPanel tablePanel;
    private JPanel buttonPanel;

    private ButtonGroup functionOption;
    private JRadioButton addRadioButton;
    private JRadioButton removeEditRadioButton;
    private JTable table1;
    private JButton clearButton;
    private JButton removeButton;
    private JButton submitButton;
    private JButton addAuthorButton;
    private JButton removeAuthorButton;
    private JButton addOrganizationButton;
    private JButton removeOrganizationButton;

    private JLabel titleLabel;
    private JLabel authorLabel;
    private JLabel orgLabel;

    private JTextArea titleText;
    private JComboBox<String> authorCombo;
    private JComboBox<String> orgCombo;




    public JPanel createManagementPanel() {
        JPanel buffer = new JPanel();
        buffer.setLayout(new GridLayout(2 ,2));
        addAuthorButton = new JButton("Add Author");
        buffer.add(addAuthorButton);
        removeAuthorButton = new JButton("Remove Author");
        buffer.add(removeAuthorButton);
        addOrganizationButton = new JButton("Add Organization");
        buffer.add(addOrganizationButton);
        removeOrganizationButton = new JButton("Remove Organization");
        buffer.add(removeOrganizationButton);

        return buffer;
    }

    public JPanel createEntryPanel() {
        JPanel buffer = new JPanel();
        buffer.setLayout(new GridLayout(4,2,1,1));

        titleLabel = new JLabel("Title: ");
        buffer.add(titleLabel);
        titleText = new JTextArea();
        buffer.add(titleText);

        authorLabel = new JLabel("Author: ");
        buffer.add(authorLabel);
        authorCombo = new JComboBox<String>(new String[]{"Author1" ,"Author2", "Author3"});
        buffer.add(authorCombo);

        orgLabel = new JLabel("Organization Name: ");
        buffer.add(orgLabel);

        orgCombo = new JComboBox<String>(new String[]{"Org1", "Org2"});
        buffer.add(orgCombo);

        return buffer;
    }

    public JPanel createTablePanel() {
        JPanel buffer = new JPanel();
        String[] sampleColumns = {"Title", "Author", "Organization", "Email", "Reviews"};

        String[][] data = {
                {"Why I need an extension on this project", "Ban Khuc", "Penn State", "bankhuc@email.co", "2"},
                {"Super Creative Title", "Super Creative Author", "Sum Org", "rando@generic.li", "0"}
        };

        table1 = new JTable(data, sampleColumns);
        table1.setBounds(30, 40, 200, 300);

        JScrollPane sp = new JScrollPane(table1);
        buffer.add(sp);
        return buffer;
    }

    public JPanel createButtonPanel() {
        JPanel buffer = new JPanel();
        buffer.setLayout(new GridLayout(2 ,1));
        clearButton = new JButton("Clear");
        buffer.add(clearButton);
        removeButton = new JButton("Remove");
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(table1.getSelectedRow() >= 0) {
                    table1.remove(table1.getSelectedRow());
                }
            }
        });
        buffer.add(removeButton);

        submitButton = new JButton("Add");
        buffer.add(submitButton);
        return buffer;
    }


    public AuthorGui() {
        super("Author GUI");

        entryPanel = createEntryPanel();
        add(entryPanel);
        tablePanel = createTablePanel();
        add(tablePanel);
        buttonPanel = createButtonPanel();
        add(buttonPanel);
        managementPanel = createManagementPanel();
        add(managementPanel);

        setSize(512, 512);
        setLayout(new GridLayout(4, 1, 1, 1));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }

    public static void main(String[] args) {
        AuthorGui x = new AuthorGui();
    }
}
