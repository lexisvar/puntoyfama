import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
public class Ayuda extends JFrame implements ActionListener{
   private JTextArea txa1;
   private JButton btn1,btn2,btn3,btn4;
	@SuppressWarnings("deprecation")
	public Ayuda(){
		super("Cómo Jugar");		
		setLayout(null);		
		this.setSize(300,190);		
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		
		btn1 = new JButton("Aplicación");
		btn2 = new JButton("Instrucción");
		btn3 = new JButton("Versiones");
		btn4 = new JButton("Cerrar");
		txa1 = new JTextArea("  Punto y Fama AlSixe Versión beta\n\n"+
				"El juego consiste en adivinar el nú-\n"+
                "mero de cuatro cifras distintas\n"+
                "tomadas aleatoriamente por la má-\n"+"" +
                "quina.");
		txa1.setEditable(false);
		btn1.reshape(0,0,100,40);
		btn2.reshape(0,40,100,40);
		btn3.reshape(0,80,100,40);
		btn4.reshape(0,121,100,40);
		txa1.reshape(100,0,195,270);
		add(txa1);	
		add(btn1);
		add(btn2);
		add(btn3);
		add(btn4);
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		btn4.addActionListener(this);
		this.setVisible(true);		
	}	
	public void actionPerformed(ActionEvent e) {
			if(e.getSource()==btn1){
				txa1.setText("  Punto y Fama AlSixe Versión beta\n\n"+
						"El juego consiste en adivinar el nú-\n"+
                        "mero de cuatro cifras distintas\n"+
                        "tomadas aleatoriamente por la má-\n"+"" +
                        "quina.");
			}
			if(e.getSource()==btn2){
				txa1.setText("                Instrucción \n\n"+
                        "Ingrese un número de cuatro cifras \n"+
						"distintas y luego de clic en e acep-\n"+
						"tar.\n"+
						"La pista consiste en lo siguiente:\n"+
						"La máquina te anota fama cuando\n"+
						"uno de los números se encuentra\n"+
						"en posición exacta, y punto cuando\n"+
                        "el número está pero no exacto.\n");
			}
			if(e.getSource()==btn3){
				txa1.setText("                   Versiones \n\n"+
						"Versión beta------>Noviembre, 2010");
			}		
			if(e.getSource()==btn4){				
				this.dispose();
				
			}			
	}

}
