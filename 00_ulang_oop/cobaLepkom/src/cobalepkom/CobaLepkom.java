/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cobalepkom;

/**
 *
 * @author ferdi
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Proses extends Thread {
	private JLabel tampilan;
	private boolean selesai;
	private boolean aktif;
	private int jam,menit,detik,perSeratusDetik;

	public Proses (JLabel tampilan) {
		super();
		this.tampilan = tampilan;
		this.selesai = false;
		this.aktif = false;
		this.jam = 0;
		this.menit = 0;
		this.detik = 0;
		this.perSeratusDetik = 0;
	}
	public void run() {
		String tampil = "";
		while(!selesai) {
			if(aktif) {
				tampil = Integer.toString(jam)+":";
				tampil += Integer.toString(menit)+":";
				tampil += Integer.toString(detik)+":";
				tampil += Integer.toString(perSeratusDetik);

				tampilan.setText(tampil);

				perSeratusDetik++;
				if(perSeratusDetik==100){
					perSeratusDetik = 0;

					detik++;

				if(detik==60){
					detik = 0;

					menit++;

				if(menit==60){
					menit = 0;

					jam++;

				if(jam==24){
					jam = 0;
				}
				}
				}	
				}
			}
		try{
			sleep(20);
		} catch(Exception e){

		}	
		}
	}

	public void aktifkan(){
		aktif = true;
	}

	public void mati(){
		selesai = true;
	}

}

public class CobaLepkom extends JFrame implements ActionListener{
	private JLabel penghitung = new JLabel("0:0:0:0");
	private Proses proses = new Proses(penghitung);
	private Button keluar = new Button("Keluar");
	private Button mulai = new Button("Mulai");
	private JPanel panel = new JPanel();

	public CobaLepkom(){
		super("Stopwatch");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(200,150);
		setLocation(200,100);
		setResizable(false);

		penghitung.setFont(new Font ("verdana",Font.BOLD,25));
		penghitung.setForeground(Color.red);
		penghitung.setHorizontalAlignment(JLabel.CENTER);

		mulai.setFont(new Font ("verdana",Font.PLAIN,20));
		mulai.setForeground(Color.blue);

		keluar.setFont(new Font ("verdana",Font.PLAIN,20));
		keluar.setForeground(Color.blue);

		mulai.addActionListener(this);
		keluar.addActionListener(this);

		panel.setLayout(new GridLayout (1,2));
		panel.add(mulai);
		panel.add(keluar);

		getContentPane().setLayout (new BorderLayout());
		getContentPane().add(penghitung,BorderLayout.CENTER);
		getContentPane().add(panel,BorderLayout.SOUTH);

		show();

		proses.start();

	}
	public void actionPerformed(ActionEvent e){
		Object obyek = e.getSource();

		if(obyek == mulai){
			if(mulai.getLabel().equals("Mulai")){
				mulai.setLabel("Berhenti");
				proses.aktifkan();
			} else {
				mulai.setLabel("Mulai");

				proses.mati();
			}
		} else {
			if(obyek == keluar){
					System.exit(0);
			}
		}
	}
	public static void main(String[]args){
		new CobaLepkom();
	}

}