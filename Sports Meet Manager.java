import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Sportproject {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Sportproject().createAndShowGUI());
    }

    private void createAndShowGUI() {
        JFrame frame = new JFrame("Annual Sports Meet");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//      frame.setSize(500, 400);
        frame.setLayout(null);
        frame.setBounds(515, 250, 500, 400);

//------------------------------------------------------------------
        JLabel lblTitle = new JLabel("Annual Sports Meet");
        lblTitle.setFont(new Font("Arial", Font.BOLD, 16));
        lblTitle.setBounds(150, 10, 200, 30);

        JLabel lblTeamName = new JLabel("Team Name:");
        lblTeamName.setBounds(30, 50, 100, 25);
        JTextField txtTeamName = new JTextField();
        txtTeamName.setBounds(140, 50, 300, 25);

        JLabel lblPartIn = new JLabel("Participated in:");
        lblPartIn.setBounds(30, 90, 100, 25);

        JCheckBox chkBasketball = new JCheckBox("Basket Ball");
        chkBasketball.setBounds(30, 120, 100, 25);
        JCheckBox chkFootball = new JCheckBox("Foot Ball");
        chkFootball.setBounds(30, 150, 100, 25);
        JCheckBox chkVolleyball = new JCheckBox("Volley Ball");
        chkVolleyball.setBounds(30, 180, 100, 25);
        JCheckBox chkHockey = new JCheckBox("Hockey");
        chkHockey.setBounds(30, 210, 100, 25);
//-----------------------------------------------------------
        JLabel lblRank = new JLabel("Rank:");
        lblRank.setBounds(150, 90, 100, 25);
        
        JTextField txtRnkBasket = new JTextField();
        txtRnkBasket.setBounds(150, 120, 100, 25);
        txtRnkBasket.setEnabled(false);
        
        JTextField txtRnkFoot = new JTextField();
        txtRnkFoot.setBounds(150, 150, 100, 25);
        txtRnkFoot.setEnabled(false);
        
        JTextField txtRnkVolley = new JTextField();
        txtRnkVolley.setBounds(150, 180, 100, 25);
        txtRnkVolley.setEnabled(false);
        
        JTextField txtRnkHockey = new JTextField();
        txtRnkHockey.setBounds(150, 210, 100, 25);
        txtRnkHockey.setEnabled(false);
//--------------------------------------------------------------
        JLabel lblPrize = new JLabel("Prize Amount:");
        lblPrize.setBounds(270, 90, 100, 25);
        
        JTextField txtPrzBasket = new JTextField();
        txtPrzBasket.setBounds(270, 120, 100, 25);
        txtPrzBasket.setEnabled(false);
        
        JTextField txtPrzFoot = new JTextField();
        txtPrzFoot.setBounds(270, 150, 100, 25);
        txtPrzFoot.setEnabled(false);
        
        JTextField txtPrzVolley = new JTextField();
        txtPrzVolley.setBounds(270, 180, 100, 25);
        txtPrzVolley.setEnabled(false);
        
        JTextField txtPrzHockey = new JTextField();
        txtPrzHockey.setBounds(270, 210, 100, 25);
        txtPrzHockey.setEnabled(false);
//------------------------------------------------------------------------
        JButton btnCalc = new JButton("Calculate Prize Amount");
        btnCalc.setBounds(100, 260, 180, 30);
        JButton btnClr = new JButton("Clear");
        btnClr.setBounds(300, 260, 100, 30);

//-------------------------------------------------------------------------
        txtTeamName.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                txtTeamName.setText(txtTeamName.getText().toUpperCase());
            }
        });

        chkBasketball.addActionListener(e -> {
            txtRnkBasket.setEnabled(chkBasketball.isSelected());
            txtPrzBasket.setEnabled(chkBasketball.isSelected());
        });

        chkFootball.addActionListener(e -> {
            txtRnkFoot.setEnabled(chkFootball.isSelected());
            txtPrzFoot.setEnabled(chkFootball.isSelected());
        });

        chkVolleyball.addActionListener(e -> {
            txtRnkVolley.setEnabled(chkVolleyball.isSelected());
            txtPrzVolley.setEnabled(chkVolleyball.isSelected());
        });

        chkHockey.addActionListener(e -> {
            txtRnkHockey.setEnabled(chkHockey.isSelected());
            txtPrzHockey.setEnabled(chkHockey.isSelected());
        });

        btnCalc.addActionListener(e -> {
            try {
                double totalPrize = 0;
                if (chkBasketball.isSelected() && !txtPrzBasket.getText().isEmpty()) {
                    totalPrize += vPrize(txtPrzBasket.getText());
                }
                if (chkFootball.isSelected() && !txtPrzFoot.getText().isEmpty()) {
                    totalPrize += vPrize(txtPrzFoot.getText());
                }
                if (chkVolleyball.isSelected() && !txtPrzVolley.getText().isEmpty()) {
                    totalPrize += vPrize(txtPrzVolley.getText());
                }
                if (chkHockey.isSelected() && !txtPrzHockey.getText().isEmpty()) {
                    totalPrize += vPrize(txtPrzHockey.getText());
                }
               
                JOptionPane.showMessageDialog(frame, "Total Prize Amount: " + totalPrize);
            }
            catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Prize amounts must be non-negative numbers.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        
        chkBasketball.addItemListener(new ItemListener(){
            public void actionPerformed(ActionEvent e){
            if(chkBasketball.isSelected())
            {
                txtRnkBasket.setText("Checkbox Selected");
            } else {
                txtRnkBasket.setText("");
                txtPrzBasket.setText("");
            }
                }    

            @Override
            public void itemStateChanged(ItemEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
                });
        
        btnClr.addActionListener(e -> {
            txtTeamName.setText("");
            chkBasketball.setSelected(false);
            txtRnkBasket.setText("");
            txtRnkBasket.setEnabled(false);
            txtPrzBasket.setText("");
            txtPrzBasket.setEnabled(false);

            chkFootball.setSelected(false);
            txtRnkFoot.setText("");
            txtRnkFoot.setEnabled(false);
            txtPrzFoot.setText("");
            txtPrzFoot.setEnabled(false);

            chkVolleyball.setSelected(false);
            txtRnkVolley.setText("");
            txtRnkVolley.setEnabled(false);
            txtPrzVolley.setText("");
            txtPrzVolley.setEnabled(false);

            chkHockey.setSelected(false);
            txtRnkHockey.setText("");
            txtRnkHockey.setEnabled(false);
            txtPrzHockey.setText("");
            txtPrzHockey.setEnabled(false);
        });

        frame.add(lblTitle);
        frame.add(lblTeamName);
        frame.add(txtTeamName);
        frame.add(lblPartIn);
        frame.add(chkBasketball);
        frame.add(chkFootball);
        frame.add(chkVolleyball);
        frame.add(chkHockey);
        frame.add(lblRank);
        frame.add(txtRnkBasket);
        frame.add(txtRnkFoot);
        frame.add(txtRnkVolley);
        frame.add(txtRnkHockey);
        frame.add(lblPrize);
        frame.add(txtPrzBasket);
        frame.add(txtPrzFoot);
        frame.add(txtPrzVolley);
        frame.add(txtPrzHockey);
        frame.add(btnCalc);
        frame.add(btnClr);

        frame.setVisible(true);
    }
    

    private double vPrize(String prize) throws NumberFormatException {
        double amount = Double.parseDouble(prize);
        if (amount < 0) {
            throw new NumberFormatException("Negative value not allowed");
        }
        return amount;
    }

    
}
