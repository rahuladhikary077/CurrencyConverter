import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.EventQueue;


public class CurrencyConverter extends JFrame {
    private static final double[] CONVERSION_RATES = {
            1.31,   // US Dollar
            476.57, // Nigerian Naira
            5.47,   // Brazilian Real
            1.71,   // Canadian Dollar
            132.53, // Kenyan Shilling
            19554.94, // Indonesian Rupiah
            95.21,  // Indian Rupee
            71.17,  // Philippine Pisco
            162.74  // Pakistani Rupee
    };

    private static final String[] CURRENCY_UNITS = {
            "Units",
            "US Dollar",
            "Nigerian Naira",
            "Brazilian Real",
            "Canadian Dollar",
            "Kenyan Shilling",
            "Indonesian Rupiah",
            "Indian Rupee",
            "Philippine Pisco",
            "Pakistani Rupee"
    };

    private JComboBox<String> firstCountry;
    private JComboBox<String> secondCountry;
    private JTextField t1;
    private JTextField t2;

    public CurrencyConverter() {
        initComponents();
    }

    private void initComponents() {
        JPanel jPanel1 = new JPanel();
        JLabel jLabel1 = new JLabel();
        firstCountry = new JComboBox<>(CURRENCY_UNITS);
        secondCountry = new JComboBox<>(CURRENCY_UNITS);
        JLabel jLabel2 = new JLabel();
        JLabel jLabel3 = new JLabel();
        t1 = new JTextField();
        t2 = new JTextField();
        JButton convertButton = new JButton("Convert Currency");
        JButton resetButton = new JButton("Reset");
        JButton exitButton = new JButton("Exit");
        JLabel secondCurrencyUnit = new JLabel();
        JLabel firstCurrencyUnit = new JLabel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 5));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24));
        jLabel1.setText("Currency Converter");

        firstCountry.setFont(new java.awt.Font("Tahoma", 1, 18));
        firstCountry.addItemListener(e -> firstCurrencyUnit.setText(CURRENCY_UNITS[firstCountry.getSelectedIndex()]));

        secondCountry.setFont(new java.awt.Font("Tahoma", 1, 18));
        secondCountry.addItemListener(e -> secondCurrencyUnit.setText(CURRENCY_UNITS[secondCountry.getSelectedIndex()]));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel2.setText("From currency Of");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel3.setText("To currency Of");

        t1.setFont(new java.awt.Font("Tahoma", 1, 18));

        t2.setFont(new java.awt.Font("Tahoma", 1, 18));

        convertButton.setFont(new java.awt.Font("Tahoma", 1, 18));
        convertButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                convertButtonActionPerformed(evt);
            }
        });

        resetButton.setFont(new java.awt.Font("Tahoma", 1, 18));
        resetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                resetButtonActionPerformed(evt);
            }
        });

        exitButton.setFont(new java.awt.Font("Tahoma", 1, 18));
        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });

        secondCurrencyUnit.setFont(new java.awt.Font("Tahoma", 1, 14));
        secondCurrencyUnit.setHorizontalAlignment(SwingConstants.RIGHT);

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel1)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel2)
                                                        .addComponent(jLabel3))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(firstCountry, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(secondCountry, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(convertButton)
                                                        .addComponent(resetButton))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(exitButton))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(t1, GroupLayout.PREFERRED_SIZE, 215, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(t2, GroupLayout.PREFERRED_SIZE, 215, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(firstCurrencyUnit, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(secondCurrencyUnit, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(firstCountry, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(secondCountry, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel3))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(t1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(t2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(firstCurrencyUnit)
                                        .addComponent(secondCurrencyUnit))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(convertButton)
                                        .addComponent(resetButton)
                                        .addComponent(exitButton))
                                .addContainerGap(16, Short.MAX_VALUE))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }

    private void convertButtonActionPerformed(ActionEvent evt) {
        String amountStr = t1.getText();
        if (amountStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter an amount to convert.");
            return;
        }

        double amount = Double.parseDouble(amountStr);
        double rate = CONVERSION_RATES[firstCountry.getSelectedIndex() - 1] / CONVERSION_RATES[secondCountry.getSelectedIndex() - 1];
        double convertedAmount = amount * rate;
        DecimalFormat df = new DecimalFormat("#.##");
        t2.setText(df.format(convertedAmount));
    }

    private void resetButtonActionPerformed(ActionEvent evt) {
        t1.setText("");
        t2.setText("");
        firstCountry.setSelectedIndex(0);
        secondCountry.setSelectedIndex(0);
    }

    private void exitButtonActionPerformed(ActionEvent evt) {
        System.exit(0);
    }

    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CurrencyConverter().setVisible(true);
            }
        });
    }
}
