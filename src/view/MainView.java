package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.Font;
import javax.swing.border.LineBorder;

public class MainView {

	private JFrame frame;
	private JTextField textFieldNum;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainView window = new MainView();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(224, 193, 105));
		frame.getContentPane().setFont(new Font("Dialog", Font.PLAIN, 25));
		frame.setBackground(new Color(224, 193, 105));
		frame.setBounds(100, 100, 800, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{375, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 30, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		JLabel labelBinaryNumbers = new JLabel("Binary Numbers");
		
		labelBinaryNumbers.setFont(new Font("DejaVu Sans Light", Font.BOLD, 50));
		labelBinaryNumbers.setBackground(new Color(224, 193, 105));
		GridBagConstraints gbc_labelBinaryNumbers = new GridBagConstraints();
		gbc_labelBinaryNumbers.gridwidth = 2;
		gbc_labelBinaryNumbers.insets = new Insets(0, 0, 5, 0);
		gbc_labelBinaryNumbers.gridx = 0;
		gbc_labelBinaryNumbers.gridy = 0;
		frame.getContentPane().add(labelBinaryNumbers, gbc_labelBinaryNumbers);
		
		JLabel labelEnterNum_1 = new JLabel("Enter your num:");
		labelEnterNum_1.setHorizontalAlignment(SwingConstants.CENTER);
		labelEnterNum_1.setFont(new Font("DejaVu Sans Light", Font.PLAIN, 40));
		labelEnterNum_1.setBackground(new Color(224, 193, 105));
		GridBagConstraints gbc_labelEnterNum_1 = new GridBagConstraints();
		gbc_labelEnterNum_1.insets = new Insets(0, 0, 5, 5);
		gbc_labelEnterNum_1.gridx = 0;
		gbc_labelEnterNum_1.gridy = 1;
		frame.getContentPane().add(labelEnterNum_1, gbc_labelEnterNum_1);
		
		textFieldNum = new JTextField();
		textFieldNum.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldNum.setFont(new Font("Dialog", Font.PLAIN, 40));
		GridBagConstraints gbc_textFieldNum = new GridBagConstraints();
		gbc_textFieldNum.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldNum.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldNum.gridx = 1;
		gbc_textFieldNum.gridy = 1;
		frame.getContentPane().add(textFieldNum, gbc_textFieldNum);
		textFieldNum.setColumns(10);
		
		JLabel labelEnterNum = new JLabel("Direct");
		labelEnterNum.setFont(new Font("DejaVu Sans Light", Font.PLAIN, 40));
		labelEnterNum.setBackground(new Color(224, 193, 105));
		GridBagConstraints gbc_labelEnterNum = new GridBagConstraints();
		gbc_labelEnterNum.insets = new Insets(0, 0, 5, 5);
		gbc_labelEnterNum.gridx = 0;
		gbc_labelEnterNum.gridy = 2;
		frame.getContentPane().add(labelEnterNum, gbc_labelEnterNum);
		
		JPanel panelDirectValue = new JPanel();
		panelDirectValue.setBorder(new LineBorder(Color.LIGHT_GRAY, 3, true));
		panelDirectValue.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_panelDirectValue = new GridBagConstraints();
		gbc_panelDirectValue.fill = GridBagConstraints.BOTH;
		gbc_panelDirectValue.insets = new Insets(0, 0, 5, 0);
		gbc_panelDirectValue.gridx = 1;
		gbc_panelDirectValue.gridy = 2;
		frame.getContentPane().add(panelDirectValue, gbc_panelDirectValue);
		GridBagLayout gbl_panelDirectValue = new GridBagLayout();
		gbl_panelDirectValue.columnWidths = new int[]{0, 0};
		gbl_panelDirectValue.rowHeights = new int[]{0, 0};
		gbl_panelDirectValue.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panelDirectValue.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panelDirectValue.setLayout(gbl_panelDirectValue);
		
		JLabel labelDirectValue = new JLabel("");
		GridBagConstraints gbc_labelDirectValue = new GridBagConstraints();
		gbc_labelDirectValue.gridx = 0;
		gbc_labelDirectValue.gridy = 0;
		panelDirectValue.add(labelDirectValue, gbc_labelDirectValue);
		labelDirectValue.setBackground(new Color(255, 255, 255));
		
		JLabel lblNewLabel_2 = new JLabel("Reverse");
		lblNewLabel_2.setFont(new Font("DejaVu Sans Light", Font.PLAIN, 40));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 3;
		frame.getContentPane().add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		JPanel panelReverseValue = new JPanel();
		panelReverseValue.setBorder(new LineBorder(Color.LIGHT_GRAY, 3, true));
		panelReverseValue.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_panelReverseValue = new GridBagConstraints();
		gbc_panelReverseValue.fill = GridBagConstraints.BOTH;
		gbc_panelReverseValue.insets = new Insets(0, 0, 5, 0);
		gbc_panelReverseValue.gridx = 1;
		gbc_panelReverseValue.gridy = 3;
		frame.getContentPane().add(panelReverseValue, gbc_panelReverseValue);
		GridBagLayout gbl_panelReverseValue = new GridBagLayout();
		gbl_panelReverseValue.columnWidths = new int[]{0, 0};
		gbl_panelReverseValue.rowHeights = new int[]{0, 0};
		gbl_panelReverseValue.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panelReverseValue.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panelReverseValue.setLayout(gbl_panelReverseValue);
		
		JLabel labelReverseValue = new JLabel("");
		GridBagConstraints gbc_labelReverseValue = new GridBagConstraints();
		gbc_labelReverseValue.gridx = 0;
		gbc_labelReverseValue.gridy = 0;
		panelReverseValue.add(labelReverseValue, gbc_labelReverseValue);
		
		JLabel labelSupplementary = new JLabel("Supplementary");
		labelSupplementary.setFont(new Font("DejaVu Sans Light", Font.PLAIN, 40));
		GridBagConstraints gbc_labelSupplementary = new GridBagConstraints();
		gbc_labelSupplementary.insets = new Insets(0, 0, 0, 5);
		gbc_labelSupplementary.gridx = 0;
		gbc_labelSupplementary.gridy = 4;
		frame.getContentPane().add(labelSupplementary, gbc_labelSupplementary);
		
		JPanel panelSupplementaryValue = new JPanel();
		panelSupplementaryValue.setBorder(new LineBorder(Color.LIGHT_GRAY, 3, true));
		panelSupplementaryValue.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_panelSupplementaryValue = new GridBagConstraints();
		gbc_panelSupplementaryValue.fill = GridBagConstraints.BOTH;
		gbc_panelSupplementaryValue.gridx = 1;
		gbc_panelSupplementaryValue.gridy = 4;
		frame.getContentPane().add(panelSupplementaryValue, gbc_panelSupplementaryValue);
		GridBagLayout gbl_panelSupplementaryValue = new GridBagLayout();
		gbl_panelSupplementaryValue.columnWidths = new int[]{0, 0};
		gbl_panelSupplementaryValue.rowHeights = new int[]{0, 0};
		gbl_panelSupplementaryValue.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panelSupplementaryValue.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panelSupplementaryValue.setLayout(gbl_panelSupplementaryValue);
		
		JLabel labelSupplementaryValue = new JLabel("");
		GridBagConstraints gbc_labelSupplementaryValue = new GridBagConstraints();
		gbc_labelSupplementaryValue.gridx = 0;
		gbc_labelSupplementaryValue.gridy = 0;
		panelSupplementaryValue.add(labelSupplementaryValue, gbc_labelSupplementaryValue);
	}

}
