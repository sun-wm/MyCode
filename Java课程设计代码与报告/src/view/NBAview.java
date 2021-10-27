package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JLayeredPane;
import javax.swing.JLabel;
import javax.swing.JButton;

public class NBAview extends JFrame {

	private JPanel contentPane;
	private JTabbedPane tabbedPane;
	private Del p2;
	private Insert p1;
	private Modify p3;
	private Query p4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NBAview frame = new NBAview();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public NBAview() {
		setTitle("湖人队球员信息表");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 602, 465);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		p1 = new Insert();
		tabbedPane.addTab("增加球员信息", null, p1, null);
		
		p2 = new Del();
		tabbedPane.addTab("删除球员信息", null, p2, null);
		
		p3 = new Modify();
		tabbedPane.addTab("修改球员信息", null, p3, null);
		
		p4 = new Query();
		tabbedPane.addTab("查看所有球员信息", null, p4, null);
	}
}
