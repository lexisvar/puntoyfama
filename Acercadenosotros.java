import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
public class Acercadenosotros extends JFrame implements ActionListener{
private JButton btn1;
private JLabel lbl1,lbl2,lbl3,lbl4,lbl5,lbl6,lbl7;
private String[] archivos ={"Imagenes//Alexis.png"};
private Icon[] iconos = {new ImageIcon(getClass().getResource(archivos[0]))};
	
	public Acercadenosotros(){
		super("Acerca de...");
		setLayout(null);		
		this.setSize(305,190);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		
		btn1 = new JButton("Cerrar");
		lbl1 = new JLabel();
		lbl2 = new JLabel("***Punto y Fama AlSixe Versión beta**");
		lbl3 = new JLabel("Autor: Alexis Vargas Arteaga");
		lbl4 = new JLabel("Estudiante de Ing. de Sistemas");
		lbl5 = new JLabel("Corporación Universitaria Rémington");		
		lbl6 = new JLabel("Autor");
		lbl7 = new JLabel("e-mail: alexis25615@hotmail.com");
		lbl1.reshape(210,50,100,100);
		lbl2.reshape(55,0,230,20);
		lbl3.reshape(0,45,200,20);
		lbl4.reshape(0,65,200,20);
		lbl5.reshape(0,85,210,20);
		lbl6.reshape(230,35,200,20);
		lbl7.reshape(0,105,200,20);
		btn1.reshape(80,125,80,25);		
		lbl1.setIcon(iconos[0]);
		add(btn1);
		add(lbl1);
		add(lbl2);
		add(lbl3);
		add(lbl4);
		add(lbl5);
		add(lbl6);
		add(lbl7);
		btn1.addActionListener(this);
		this.setVisible(false);
	}
	public void actionPerformed(ActionEvent e) {
			if(e.getSource()==btn1){
				this.dispose();
			}
	}

}
