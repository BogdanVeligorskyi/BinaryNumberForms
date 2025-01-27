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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class MainView {

	private JFrame frame;
	private JTextField textFieldNum;
	private JLabel labelSupplementaryValue;
	private JLabel labelDirectValue;
	private JLabel labelReverseValue;
	
	private static final char[] digits = {
		'0', '1', '2', '3', '4', '5',
		'6', '7', '8', '9', '-'
	};

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
		gridBagLayout.columnWidths = new int[]{375, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 30, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		JLabel labelBinaryNumbers = new JLabel("Binary Numbers");
		
		labelBinaryNumbers.setFont(new Font("DejaVu Sans Light", Font.BOLD, 50));
		labelBinaryNumbers.setBackground(new Color(224, 193, 105));
		GridBagConstraints gbc_labelBinaryNumbers = new GridBagConstraints();
		gbc_labelBinaryNumbers.gridwidth = 3;
		gbc_labelBinaryNumbers.insets = new Insets(0, 0, 5, 0);
		gbc_labelBinaryNumbers.gridx = 0;
		gbc_labelBinaryNumbers.gridy = 0;
		frame.getContentPane().add(labelBinaryNumbers, gbc_labelBinaryNumbers);
		
		JLabel labelEnterYourNum = new JLabel("Enter your num:");
		labelEnterYourNum.setHorizontalAlignment(SwingConstants.CENTER);
		labelEnterYourNum.setFont(new Font("DejaVu Sans Light", Font.PLAIN, 40));
		labelEnterYourNum.setBackground(new Color(224, 193, 105));
		GridBagConstraints gbc_labelEnterYourNum = new GridBagConstraints();
		gbc_labelEnterYourNum.insets = new Insets(0, 0, 5, 5);
		gbc_labelEnterYourNum.gridx = 0;
		gbc_labelEnterYourNum.gridy = 1;
		frame.getContentPane().add(labelEnterYourNum, gbc_labelEnterYourNum);
		
		textFieldNum = new JTextField();
		textFieldNum.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				int result = checkIfCharIsValid(textFieldNum.getText().charAt(textFieldNum.getText().length()-1), textFieldNum.getText().length()-1);
				if (result == 1) {
					textFieldNum.setText(textFieldNum.getText().substring(0, textFieldNum.getText().length()-1));
					labelDirectValue.setText("");
					labelReverseValue.setText("");
					labelSupplementaryValue.setText("");
					return;
				}
				
				boolean isNegative = checkIfNumberIsNegative(textFieldNum.getText().charAt(0));
				
				System.out.println(result);
				labelSupplementaryValue.setText("KK");
				
				labelDirectValue.setText(directValue(Integer.valueOf(textFieldNum.getText()), isNegative));
				labelReverseValue.setText(reverseValue(Integer.valueOf(textFieldNum.getText()), isNegative));
				labelSupplementaryValue.setText(supplementaryValue(Integer.valueOf(textFieldNum.getText()), isNegative));
				
			}
		});
		textFieldNum.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldNum.setFont(new Font("Dialog", Font.PLAIN, 40));
		GridBagConstraints gbc_textFieldNum = new GridBagConstraints();
		gbc_textFieldNum.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldNum.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldNum.gridx = 2;
		gbc_textFieldNum.gridy = 1;
		frame.getContentPane().add(textFieldNum, gbc_textFieldNum);
		textFieldNum.setColumns(10);
		
		JLabel labelDirect = new JLabel("Direct");
		labelDirect.setFont(new Font("DejaVu Sans Light", Font.PLAIN, 40));
		labelDirect.setBackground(new Color(224, 193, 105));
		GridBagConstraints gbc_labelDirect = new GridBagConstraints();
		gbc_labelDirect.insets = new Insets(0, 0, 5, 5);
		gbc_labelDirect.gridx = 0;
		gbc_labelDirect.gridy = 2;
		frame.getContentPane().add(labelDirect, gbc_labelDirect);
		
		JPanel panelDirectValue = new JPanel();
		panelDirectValue.setBorder(new LineBorder(Color.LIGHT_GRAY, 3, true));
		panelDirectValue.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_panelDirectValue = new GridBagConstraints();
		gbc_panelDirectValue.fill = GridBagConstraints.BOTH;
		gbc_panelDirectValue.insets = new Insets(0, 0, 5, 0);
		gbc_panelDirectValue.gridx = 2;
		gbc_panelDirectValue.gridy = 2;
		frame.getContentPane().add(panelDirectValue, gbc_panelDirectValue);
		GridBagLayout gbl_panelDirectValue = new GridBagLayout();
		gbl_panelDirectValue.columnWidths = new int[]{0, 0};
		gbl_panelDirectValue.rowHeights = new int[]{0, 0};
		gbl_panelDirectValue.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panelDirectValue.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panelDirectValue.setLayout(gbl_panelDirectValue);
		
		labelDirectValue = new JLabel("");
		labelDirectValue.setFont(new Font("Dialog", Font.PLAIN, 40));
		GridBagConstraints gbc_labelDirectValue = new GridBagConstraints();
		gbc_labelDirectValue.gridx = 0;
		gbc_labelDirectValue.gridy = 0;
		panelDirectValue.add(labelDirectValue, gbc_labelDirectValue);
		labelDirectValue.setBackground(new Color(255, 255, 255));
		
		JLabel labelReverse = new JLabel("Reverse");
		labelReverse.setFont(new Font("DejaVu Sans Light", Font.PLAIN, 40));
		GridBagConstraints gbc_labelReverse = new GridBagConstraints();
		gbc_labelReverse.insets = new Insets(0, 0, 5, 5);
		gbc_labelReverse.gridx = 0;
		gbc_labelReverse.gridy = 3;
		frame.getContentPane().add(labelReverse, gbc_labelReverse);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon("/home/bogdan/projects/digitrans/mcu-and-fpga-remote-lab-frontend/src/img/rise_edge.png"));
		btnNewButton.setSelectedIcon(new ImageIcon("/home/bogdan/projects/digitrans/mcu-and-fpga-remote-lab-frontend/src/img/turn_on.png"));
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 3;
		frame.getContentPane().add(btnNewButton, gbc_btnNewButton);
		
		JPanel panelReverseValue = new JPanel();
		panelReverseValue.setBorder(new LineBorder(Color.LIGHT_GRAY, 3, true));
		panelReverseValue.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_panelReverseValue = new GridBagConstraints();
		gbc_panelReverseValue.fill = GridBagConstraints.BOTH;
		gbc_panelReverseValue.insets = new Insets(0, 0, 5, 0);
		gbc_panelReverseValue.gridx = 2;
		gbc_panelReverseValue.gridy = 3;
		frame.getContentPane().add(panelReverseValue, gbc_panelReverseValue);
		GridBagLayout gbl_panelReverseValue = new GridBagLayout();
		gbl_panelReverseValue.columnWidths = new int[]{0, 0};
		gbl_panelReverseValue.rowHeights = new int[]{0, 0};
		gbl_panelReverseValue.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panelReverseValue.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panelReverseValue.setLayout(gbl_panelReverseValue);
		
		labelReverseValue = new JLabel("");
		labelReverseValue.setFont(new Font("Dialog", Font.PLAIN, 40));
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
		gbc_panelSupplementaryValue.gridx = 2;
		gbc_panelSupplementaryValue.gridy = 4;
		frame.getContentPane().add(panelSupplementaryValue, gbc_panelSupplementaryValue);
		GridBagLayout gbl_panelSupplementaryValue = new GridBagLayout();
		gbl_panelSupplementaryValue.columnWidths = new int[]{0, 0};
		gbl_panelSupplementaryValue.rowHeights = new int[]{0, 0};
		gbl_panelSupplementaryValue.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panelSupplementaryValue.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panelSupplementaryValue.setLayout(gbl_panelSupplementaryValue);
		
		labelSupplementaryValue = new JLabel("");
		labelSupplementaryValue.setFont(new Font("Dialog", Font.PLAIN, 40));
		GridBagConstraints gbc_labelSupplementaryValue = new GridBagConstraints();
		gbc_labelSupplementaryValue.gridx = 0;
		gbc_labelSupplementaryValue.gridy = 0;
		panelSupplementaryValue.add(labelSupplementaryValue, gbc_labelSupplementaryValue);
	}
	
	private int checkIfCharIsValid(char ch, int position) {
		if (ch == '-' && position > 0) {
			return 1;
		}
		
		for (int i = 0; i < digits.length; i++) {
			if (digits[i] == ch) {
				return 0;
			}
		}
		return 1;
		
	}
	
	private boolean checkIfNumberIsNegative(char firstChar) {
		if (firstChar == '-') {
			return true;
		}
		return false;
	}
	
	private String directValue(int decimalNum, boolean isNegative) {
		String s = Integer.toBinaryString(Math.abs(decimalNum));
		if (isNegative) {
			return "1" + s;
		}
		return "0" + s;
	}
	
	private String reverseValue(int decimalNum, boolean isNegative) {
		String s = Integer.toBinaryString(Math.abs(decimalNum));
		String reversedString = "";
		if (isNegative) {
			for (int j = 0; j < s.length(); j++) {
				if (s.charAt(j) == '0') {
					reversedString += '1';
				} else {
					reversedString += '0';
				}
			}
			return '1' + reversedString;
		}
		return '0' + s;
	}
	
	private String supplementaryValue(int decimalNum, boolean isNegative) {
		String supplementaryValueString = reverseValue(decimalNum, isNegative);
		int supplementaryValue = Integer.parseInt(supplementaryValueString, 2);
		int one = Integer.parseInt("1", 2);
		int sum = supplementaryValue + one;
		System.out.println(sum);
		return Integer.toBinaryString(sum);
	}

}
