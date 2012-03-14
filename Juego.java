import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Juego extends JFrame implements ActionListener, KeyListener,Runnable{

	//DECLARACIONES
JButton btnreiniciar,btnaceptar,btnlimpiar,btnsalir;//DECLARACION DE BOTONES
JLabel lbltitulo,lblpuntaje,lblnum1,lblnum2,lblnum3,lblnum4,lblpunto1,lblpunto2,//DECLARACION DE ETIQUETAS
lblfama,lblfama2,lblresultado,lblnumresultado,lblinstruccion,lbltiempo;
JTextField txtnum1,txtnum2,txtnum3,txtnum4,txt;//DECLARACION DE CAMPOS DE TEXTO
JMenuBar barra;//DECLARACION DE BARRA DE MENU
JMenu archivo,ayuda,opciones; // DECLARACION DE MENU'S
JMenuItem salir,acercade,nuevo,restaurar,vertabla,ayu;// DECLARACION DE SUBMENU'S


Container x=this.getContentPane();

//VARIABLES PARA EL CRONOMETRO
int minutos=0, segundos=0, horas=0;
Thread crono;
String nombre;


int a,b,c,d,e,f,g,h,intento=0,fama,punto,cfs=4,Vh[],Vm[];
  //CONSTRUCTOR
	public Juego() {
		super("Punto y Fama");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//PARA DESCARGAR DE LA MEMORIA AL CERRAR LA APLICACION
		this.setSize(400,430);//TAMAÑO DE VENTANA		
		this.setLocationRelativeTo(null);//PARA QUE LA APLICACION APAREZCA MEDIANANMENTE CETRADA
		this.setResizable(false);
		this.setLayout(null);		
		x.setBackground(new Color(255,255,200));//COLOR
		
		//VECTORES
		Vh = new int [cfs];
		Vm = new int [cfs];		
		
		//BARRA DE MENU 
		barra = new JMenuBar(); 
		archivo = new JMenu("Archivo");
		ayuda = new JMenu("Ayuda");
		opciones = new JMenu("Opciones");
		restaurar = new JMenuItem ("Borrar Puntuación"); 
		restaurar.setIcon(new ImageIcon(getClass().getResource("Imagenes//Delete.png")));		
		salir = new JMenuItem ("Salir"); 
		salir.setIcon(new ImageIcon(getClass().getResource("Imagenes//Close.png")));		
		acercade = new JMenuItem ("Acerca de...");
		acercade.setIcon(new ImageIcon(getClass().getResource("Imagenes//Info.png")));
		nuevo = new JMenuItem ("Nuevo");
		nuevo.setIcon(new ImageIcon(getClass().getResource("Imagenes//Clock.png")));
		vertabla = new JMenuItem ("Ver Puntación");
		vertabla.setIcon(new ImageIcon(getClass().getResource("Imagenes//Load.png")));
		ayu = new JMenuItem ("Cómo Jugar");
		ayu.setIcon(new ImageIcon(getClass().getResource("Imagenes//Help.png")));
		
		barra.add(archivo);	
		barra.add(opciones);
		barra.add(ayuda);		
		opciones.add(vertabla);
		opciones.add(restaurar);		
		archivo.add(nuevo);
		archivo.add(salir);
		ayuda.add(ayu);
		ayuda.add(acercade);		
		
		
		
		//COMPONENTES
		lbltiempo = new JLabel();		
		crono = new Thread(this);
		
		btnreiniciar = new JButton("Empezar");
		btnaceptar = new JButton("Aceptar");
		btnlimpiar = new JButton("Limpiar");
		btnsalir =	new JButton("Salir");
				
		lbltitulo = new JLabel("Punto y Fama");
		lbltitulo.setFont(new Font("Times-Roman", Font.BOLD + Font.ITALIC, 16));
		
		lbltiempo = new JLabel ("Tiempo");
		lbltiempo.setFont(new Font("Times-Roman", Font.BOLD + Font.ITALIC, 30));
		lblpuntaje = new JLabel("Puntaje");
		lblnum1 = new JLabel("");
		lblnum2 = new JLabel("");
		lblnum3 = new JLabel("");
		lblnum4 = new JLabel("");
		lblpunto1 = new JLabel("");
		lblpunto2 = new JLabel("PUNTOS:");
		lblfama = new JLabel("");
		lblfama2 = new JLabel("FAMAS:");
		lblresultado = new JLabel("Intento:");
		lblnumresultado = new JLabel("");
		lblinstruccion = new JLabel("Digite 4 Cifras que no se Repitan Entre sí");	
		
		txtnum1	= new JTextField ();		
		txtnum2 = new JTextField ();
		txtnum3 = new JTextField ();
		txtnum4 = new JTextField ();	
		txtnum1.setFont(new Font("Times-Roman", Font.BOLD + Font.ITALIC, 30));
		txtnum2.setFont(new Font("Times-Roman", Font.BOLD + Font.ITALIC, 30));
		txtnum3.setFont(new Font("Times-Roman", Font.BOLD + Font.ITALIC, 30));
		txtnum4.setFont(new Font("Times-Roman", Font.BOLD + Font.ITALIC, 30));
		txtnum1.setForeground(Color.BLUE);
		txtnum2.setForeground(Color.BLUE);
		txtnum3.setForeground(Color.BLUE);
		txtnum4.setForeground(Color.BLUE);
		txtnum1.setEnabled(false);
		txtnum2.setEnabled(false);
		txtnum3.setEnabled(false);
		txtnum4.setEnabled(false);
		btnaceptar.setEnabled(false);
		
		add(lbltiempo);
		add(lbltitulo);
		add(btnreiniciar);
		add(lblpuntaje);
		add(lblnum1);
		add(lblnum2);
		add(lblnum3);
		add(lblnum4);
		add(lblpunto2);
		add(lblfama2);
		add(lblpunto1);
		add(lblfama);
		add(lblinstruccion);
		add(lblresultado);
		add(lblnumresultado);
		add(txtnum1);
		add(txtnum2);
		add(txtnum3);
		add(txtnum4);
		add(btnaceptar);
		add(btnsalir);
		add(btnlimpiar);
		
		lbltiempo.reshape(140, 140,110, 40);
		lbltitulo.reshape(140, 10,110, 20);
		btnreiniciar.reshape(10, 50,84, 25);
		lblpuntaje.reshape(220, 50,50, 15);
		lblnum1.reshape(220, 80,7, 10);
		lblnum2.reshape(227, 80,7, 10);
		lblnum3.reshape(234, 80,7, 10);
		lblnum4.reshape(241, 80,7, 10);
		lblpunto2.reshape(290, 70,51, 10);
		lblfama2.reshape(290, 90,50, 10);
		lblpunto1.reshape(350, 70,7, 10);
		lblfama.reshape(350, 90,7, 10);
		lblinstruccion.reshape(80, 200,250, 15);
		lblresultado.reshape(150, 220,50, 15);
		lblnumresultado.reshape(200, 220,30, 15);
		txtnum1.reshape(110, 240,30, 30);
		txtnum2.reshape(145, 240,30, 30);
		txtnum3.reshape(180, 240,30, 30);
		txtnum4.reshape(215, 240,30, 30);
		btnaceptar.reshape(90, 280,80, 30);
		btnlimpiar.reshape(185, 280,80, 30);
		btnsalir.reshape(135, 320,80, 30);
		
		txtnum1.addKeyListener(this);
		txtnum2.addKeyListener(this);
		txtnum3.addKeyListener(this);
		txtnum4.addKeyListener(this);
		
		
		btnreiniciar.addActionListener(this);
		btnaceptar.addActionListener(this);
		btnsalir.addActionListener(this);
		
		this.setJMenuBar(barra);
		nuevo.addActionListener(this);
		btnlimpiar.addActionListener(this);
		ayuda.addActionListener(this);
		salir.addActionListener(this);
		acercade.addActionListener(this);
		restaurar.addActionListener(this);
		vertabla.addActionListener(this);
		ayu.addActionListener(this);
		this.setVisible(true);
	}		
	public void actionPerformed(ActionEvent e) {
	String sonido="Sonidos//001.wav";
		
		if(e.getSource()==btnsalir ){
			System.exit(0);			
		}
		if(e.getSource()==ayu ){
			Ayuda ayus = new Ayuda();		
		}
		if(e.getSource()==restaurar ){
			int confirmado = JOptionPane.showConfirmDialog(null,"¿Está Seguro que Desea Borrar la Tabla de Puntaje?");
				if (JOptionPane.OK_OPTION == confirmado){
					Record rec2 = new Record();			
					rec2.Crear();
					}								
		}
		if(e.getSource()==salir ){			
			int confirmado = JOptionPane.showConfirmDialog(null,"¿Está Seguro que Desea Salir?");
			if (JOptionPane.OK_OPTION == confirmado){
				System.exit(0);
			}						
		}
		if(e.getSource()==nuevo ){			
			String sonidonom="Sonidos//Nombre.wav";
			Sonidos sonnom = new Sonidos(sonidonom);
			nombre=JOptionPane.showInputDialog("¡Bienvenido! Digite su Nombre");			

					
			if(minutos==0 && segundos==0 && horas==0){
				
				crono.start();
				
			}else{
				crono.interrupt();
				segundos=-1;
				minutos=0;				
				horas=0;
				crono = new Thread(this);
				crono.start();
			}
			
					
			String sonido4="Sonidos//004.wav";
			Sonidos son = new Sonidos(sonido4);
			txtnum1.setEnabled(true);
			txtnum1.requestFocus();
			txtnum1.setText("");
			txtnum2.setText("");
			txtnum3.setText("");
			txtnum4.setText("");
			lblnum1.setText("");
			lblnum2.setText("");
			lblnum3.setText("");
			lblnum4.setText("");
			lblpunto1.setText("");
			lblfama.setText("");
			lblnumresultado.setText("");
			numeropc();				
		}
		if(e.getSource()==acercade){
			new Sonidos("Sonidos//Acercade.wav");
			Acercadenosotros acer = new Acercadenosotros();
			acer.setVisible(true);
		}
		if(e.getSource()==vertabla){
			Record rec3 = new Record();
			int registro = rec3.Buscar(1);
			for(int j=0;j<registro;j++){
				rec3.Mostrar((j+1));
			}
			rec3.setVisible(true);
		}
		if(e.getSource()==btnreiniciar){			
			
			String sonidonom="Sonidos//Nombre.wav";
			Sonidos sonnom = new Sonidos(sonidonom);
			nombre=JOptionPane.showInputDialog("¡Bienvenido! Digite su Nombre");			

					
			if(minutos==0 && segundos==0 && horas==0){
				
				crono.start();
				
			}else{
				crono.interrupt();
				segundos=-1;
				minutos=0;				
				horas=0;
				crono = new Thread(this);
				crono.start();
			}
			
					
			String sonido4="Sonidos//004.wav";
			Sonidos son = new Sonidos(sonido4);
			txtnum1.setEnabled(true);
			txtnum1.requestFocus();
			txtnum1.setText("");
			txtnum2.setText("");
			txtnum3.setText("");
			txtnum4.setText("");
			lblnum1.setText("");
			lblnum2.setText("");
			lblnum3.setText("");
			lblnum4.setText("");
			lblpunto1.setText("");
			lblfama.setText("");
			lblnumresultado.setText("");
			numeropc();
			System.out.println(Vm[0]);
			System.out.println(Vm[1]);
			System.out.println(Vm[2]);
			System.out.println(Vm[3]);
		}
		if(e.getSource()==btnaceptar){			
			String sonido5="Sonidos//005.wav";
			Sonidos son5 = new Sonidos(sonido5);
			String numh =(""+txtnum1.getText()+txtnum1.getText()+txtnum1.getText()+txtnum1.getText());			
			int numhu = Integer.parseInt(numh);
			if (a!=b && a!=c && a!=d && b!=c && b!=d && c!=d && numhu<10000){
				Vh[0] = a;
				Vh[1] =	b;
				Vh[2] = c;
				Vh[3] = d;
				
				lblnum1.setText(txtnum1.getText());
				lblnum2.setText(txtnum2.getText());	
				lblnum3.setText(txtnum3.getText());	
				lblnum4.setText(txtnum4.getText());	
				txtnum1.setText("");
				txtnum2.setText("");
				txtnum3.setText("");
				txtnum4.setText("");				
				btnaceptar.setEnabled(false);
				txtnum2.setEnabled(false);
				txtnum3.setEnabled(false);
				txtnum4.setEnabled(false);				
				compara();
				lblpunto1.setText(""+punto);
				lblfama.setText(""+fama);				
			    intento=intento+1;
				lblnumresultado.setText(""+intento);
				txtnum1.requestFocus();	
				if(fama==4){
					crono.interrupt();
					
					String sonido3="Sonidos//003.wav";
					Sonidos son = new Sonidos(sonido3);
					
					JOptionPane.showMessageDialog(null, "¡Ganaste! Intentos "+intento+" Tiempo:  Horas: "+horas+" Minutoss: "+minutos+" Segundos: "+segundos);
					
					txtnum1.setEnabled(false);
					txtnum2.setEnabled(false);
					txtnum3.setEnabled(false);
					txtnum4.setEnabled(false);
					btnaceptar.setEnabled(false);		
					
					Record rec = new Record();					
					int puesto = rec.Buscar(1);
					rec.Ingresar(puesto, nombre, horas, minutos, segundos,intento);	
					int confirma = JOptionPane.showConfirmDialog(null,"¿Desea Ver la Tabla de Puntajes?");
					if (JOptionPane.OK_OPTION == confirma){
						for(int j=0;j<puesto;j++){
							rec.Mostrar((j+1));
						}
						rec.setVisible(true);						
					}					
					intento=0;
				}
				fama=0;
				punto=0;
				
			}else{
				String sonido1="Sonidos//002.wav";
				Sonidos son = new Sonidos(sonido1);	
				JOptionPane.showMessageDialog(null," ¡Pésima Digitación Corrige Pronto! ");
				txtnum1.setText("");
				txtnum2.setEnabled(false);
				txtnum3.setEnabled(false);
				txtnum4.setEnabled(false);
				txtnum1.requestFocus();
			}			
		}		
		if(e.getSource()==btnlimpiar){
			txtnum1.setText("");
			txtnum2.setText("");
			txtnum3.setText("");
			txtnum4.setText("");
			txtnum2.setEnabled(false);
			txtnum3.setEnabled(false);
			txtnum4.setEnabled(false);
			txtnum1.requestFocus();			
		}
	}	
	public void keyPressed(KeyEvent e) {					
		switch(e.getKeyCode()){
		case KeyEvent.VK_ENTER:
			String sonido5="Sonidos//005.wav";
			Sonidos son5 = new Sonidos(sonido5);
			String numh =(""+txtnum1.getText()+txtnum1.getText()+txtnum1.getText()+txtnum1.getText());			
			int numhu = Integer.parseInt(numh);
			if (a!=b && a!=c && a!=d && b!=c && b!=d && c!=d && numhu<10000){
				Vh[0] = a;
				Vh[1] =	b;
				Vh[2] = c;
				Vh[3] = d;
				
				lblnum1.setText(txtnum1.getText());
				lblnum2.setText(txtnum2.getText());	
				lblnum3.setText(txtnum3.getText());	
				lblnum4.setText(txtnum4.getText());	
				txtnum1.setText("");
				txtnum2.setText("");
				txtnum3.setText("");
				txtnum4.setText("");				
				btnaceptar.setEnabled(false);
				txtnum2.setEnabled(false);
				txtnum3.setEnabled(false);
				txtnum4.setEnabled(false);				
				compara();
				lblpunto1.setText(""+punto);
				lblfama.setText(""+fama);				
			    intento=intento+1;
				lblnumresultado.setText(""+intento);
				txtnum1.requestFocus();	
				if(fama==4){
					crono.interrupt();
					
					String sonido3="Sonidos//003.wav";
					Sonidos son = new Sonidos(sonido3);
					
					JOptionPane.showMessageDialog(null, "¡Ganaste! Intentos "+intento+" Tiempo:  Horas: "+horas+" Minutoss: "+minutos+" Segundos: "+segundos);
					
					txtnum1.setEnabled(false);
					txtnum2.setEnabled(false);
					txtnum3.setEnabled(false);
					txtnum4.setEnabled(false);
					btnaceptar.setEnabled(false);		
					
					Record rec = new Record();					
					int puesto = rec.Buscar(1);
					rec.Ingresar(puesto, nombre, horas, minutos, segundos,intento);	
					int confirma = JOptionPane.showConfirmDialog(null,"¿Desea Ver la Tabla de Puntajes?");
					if (JOptionPane.OK_OPTION == confirma){
						for(int j=0;j<puesto;j++){
							rec.Mostrar((j+1));
						}
						rec.setVisible(true);						
					}					
					intento=0;
				}
				fama=0;
				punto=0;
				
			}else{
				String sonido1="Sonidos//002.wav";
				Sonidos son = new Sonidos(sonido1);	
				JOptionPane.showMessageDialog(null," ¡Pésima Digitación Corrige Pronto! ");
				txtnum1.setText("");
				txtnum2.setEnabled(false);
				txtnum3.setEnabled(false);
				txtnum4.setEnabled(false);
				txtnum1.requestFocus();
			}			
		}		
	}	
	public void keyReleased(KeyEvent e) {
	String sonido="Sonidos//001.wav";
		if(e.getSource()==txtnum1){			
			Sonidos son = new Sonidos(sonido);
			txtnum2.setEnabled(true);
			txtnum2.requestFocus();
			txtnum2.setText("");
			a=Integer.parseInt(txtnum1.getText());			
		}
		
		if(e.getSource()==txtnum2){
			Sonidos son = new Sonidos(sonido);
			txtnum3.setEnabled(true);
			txtnum3.requestFocus();
			txtnum3.setText("");
			b=Integer.parseInt(txtnum2.getText());
		}
		if(e.getSource()==txtnum3){
			Sonidos son = new Sonidos(sonido);
			txtnum4.setEnabled(true);
			txtnum4.requestFocus();
			txtnum4.setText("");
			c=Integer.parseInt(txtnum3.getText());
		}
		if(e.getSource()==txtnum4){
			Sonidos son = new Sonidos(sonido);
			btnaceptar.setEnabled(true);			
			d=Integer.parseInt(txtnum4.getText());
		}
	}	
	public void keyTyped(KeyEvent e) {
		char caracter = e.getKeyChar();

	      // Verificar si la tecla pulsada no es un digito
	      if(((caracter < '0') ||
	         (caracter > '9')) &&
	         (caracter != KeyEvent.VK_BACK_SPACE))
	      {
	         e.consume();  // ignorar el evento de teclado
	      }	      
	}
	//METODO PARA ESCOGER NUMERO DE MAQUINA
	public void numeropc(){
		f=0;e=0;g=0;h=0;
		while(e==f || e==g || e==h || f==g || f==h || g==h){			
			e =(int)(Math.random()*9);
			f =(int)(Math.random()*9);
			g =(int)(Math.random()*9);
			h =(int)(Math.random()*9);
			Vm[0] = e;
			Vm[1] = f;
			Vm[2] = g;
			Vm[3] = h;
		}
	}
	//METODO PARA COMPARAR VECTORES HUMANO CON MAQUINA
	public void compara(){
		for(int i=0;i<cfs;i++){
			for(int j=0;j<cfs;j++){
				if(Vh[j]==Vm[i]){					
					if(i==j){
						fama=fama+1;
					}else{
						punto=punto+1;
					}					
				}
			}
		}
	}	
	public void run() {
	 try{
			for(;;) {
				if(segundos==59) { segundos=0; minutos++; }
				if(minutos==59) { minutos=0; horas++; }
				segundos++;
				lbltiempo.setText(horas+":"+minutos+":"+segundos);
				crono.sleep(1000); }		
	 }
	 	catch (InterruptedException e) {
	 		System.out.println(e.getMessage());
	 	}		
	}
}

