import java.awt.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class Record extends JFrame{	
	//JTABLE
	String[] columns = { "Nombre","Horas","Minutos","Segundos","Intentos"}; 
	
	//Object rows =new Object[50][5];
	Object [][]rows = { {  "", "","","",""  }, {  "", "","","",""  }, {  "", "","","",""  }, {  "", "","","",""  }, {  "", "","","","" },
	{  "", "","","",""  }, {  "", "","","",""  }, {  "", "","","",""  }, {  "", "","","",""  }, {  "", "","","",""  },
	{  "", "","","",""  }, {  "", "","","",""  }, {  "", "","","",""  }, {  "", "","","",""  }, {  "", "","","","" },
	{  "", "","","",""  }, {  "", "","","",""  }, {  "", "","","",""  }, {  "", "","","",""  }, {  "", "","","",""  },
	{  "", "","","",""  }, {  "", "","","",""  }, {  "", "","","",""  }, {  "", "","","",""  }, {  "", "","","","" },
	{  "", "","","",""  }, {  "", "","","",""  }, {  "", "","","",""  }, {  "", "","","",""  }, {  "", "","","",""  },
	{  "", "","","",""  }, {  "", "","","",""  }, {  "", "","","",""  }, {  "", "","","",""  }, {  "", "","","","" },
	{  "", "","","",""  }, {  "", "","","",""  }, {  "", "","","",""  }, {  "", "","","",""  }, {  "", "","","",""  },
	{  "", "","","",""  }, {  "", "","","",""  }, {  "", "","","",""  }, {  "", "","","",""  }, {  "", "","","","" },
	{  "", "","","",""  }, {  "", "","","",""  }, {  "", "","","",""  }, {  "", "","","",""  }, {  "", "","","",""  },
	{  "", "","","",""  }, {  "", "","","",""  }, {  "", "","","",""  }, {  "", "","","",""  }, {  "", "","","","" },
	{  "", "","","",""  }, {  "", "","","",""  }, {  "", "","","",""  }, {  "", "","","",""  }, {  "", "","","",""  },
	{  "", "","","",""  }, {  "", "","","",""  }, {  "", "","","",""  }, {  "", "","","",""  }, {  "", "","","","" },
	{  "", "","","",""  }, {  "", "","","",""  }, {  "", "","","",""  }, {  "", "","","",""  }, {  "", "","","",""  },
	{  "", "","","",""  }, {  "", "","","",""  }, {  "", "","","",""  }, {  "", "","","",""  }, {  "", "","","","" },
	{  "", "","","",""  }, {  "", "","","",""  }, {  "", "","","",""  }, {  "", "","","",""  }, {  "", "","","",""  },};
	TableModel model = new DefaultTableModel(rows, columns) {
	      public Class getColumnClass(int column) {
	        Class returnValue;
	        if ((column >= 0) && (column < getColumnCount())) {
	          returnValue = getValueAt(0, column).getClass();
	        } else {
	          returnValue = Object.class;
	        }
	        return returnValue;
	      }
	    };
	  JTable table = new JTable(model);
    public Record(){
    
    	super("Tabla de Puntajes");    	
    	setSize(480,460);    	
    	this.setLocationRelativeTo(null);
    	
    	setLayout(new FlowLayout());
    	//JTABLE 	
    	RowSorter<TableModel> sorter = new TableRowSorter<TableModel>(model);
    	table.setRowSorter(sorter);
    	getContentPane().add(new JScrollPane(table));   	    	
    	
		try{			
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			//txa.setText("Puente listo");
		}
		catch(Exception f)
		{
			System.out.println("Puente malo");
		}		
		this.setVisible(false);		
    }			
   public void Crear()
 	{
 	Connection conexion;
 	Statement instruccion;
 	String mDNS="jdbc:odbc:Mejor";
 	String borratabla="DROP Table Mejores";//NOMBRE DE LA TABLA
 	String creatabla="Create Table Mejores("+//CREAR TABLA
 		"Puesto VARCHAR(2)NOT NULL,"+//NO NULL INDICA QUE ES UN CAMPO REQUERIDO
 			"Nombre VARCHAR(10)NOT NULL,"+
 				"Horas CHAR(2),"+
 					"Minutos CHAR(2),"+
 						"Segundos CHAR(2),"+
 							"Intentos CHAR(4))";
 							
 							try
 							{
 								conexion=DriverManager.getConnection(mDNS);
 								System.out.println("Conexion Realizada"); 								
 								instruccion=conexion.createStatement();
 									try
 									{
 										instruccion.executeUpdate(borratabla);
 										System.out.println("Se borra la tabla de puntaje");
 									}
									catch(SQLException sql)
									{
										JOptionPane.showMessageDialog(null,"Error al Borrar");
									}
 							instruccion.executeUpdate(creatabla);
 							JOptionPane.showMessageDialog(null,"Tabla de Puntaje Vacía");
 							conexion.close();
 							}
 							catch(SQLException sql)
 							{
 								JOptionPane.showMessageDialog(null,"No se Pudo Borrar"); 								
 							}
 	}
	
	//INGRESAR
	public void Ingresar(int puest,String nom,int hor, int min, int seg,int inten)
 	{ 			
		Connection conexion;
 		Statement instruccion;
 		String ingres="INSERT INTO Mejores VALUES('"+
 			puest+"','"+
 				nom+"','"+
 					hor+"','"+
 						min+"','"+
 							seg+"','"+
 								inten+"')";
 		String mDNS="jdbc:odbc:Mejor";
 		
 		try
 		{
 			conexion=DriverManager.getConnection(mDNS);
 			instruccion=conexion.createStatement();
 			instruccion.executeUpdate(ingres);
 			System.out.println("Registro Almacenado");
 			conexion.close();
 		}
 		catch(SQLException sql)
 		{
 			System.out.println("No almacenó el registro"); 			
 		} 
 	}
	//MOSTRAR
	public void Mostrar(int i)
 	{
 		Connection conexion;
 		Statement instruccion;
 		ResultSet resultado;
 		String buscar="SELECT * FROM Mejores WHERE(Puesto='"+i+"')"; 		
 		String mDNS="jdbc:odbc:Mejor";
 		try
 		{
 			conexion=DriverManager.getConnection(mDNS);
 			instruccion=conexion.createStatement();
 			resultado=instruccion.executeQuery(buscar);
 			
 		
 			if(resultado.next())
 			{				
 												
 				table.setValueAt(resultado.getString("Nombre"),(i-1),0);
 				table.setValueAt(resultado.getString("Horas"),(i-1),1);
 				table.setValueAt(resultado.getString("Minutos"),(i-1),2);
 				table.setValueAt(resultado.getString("Segundos"),(i-1),3);
 				table.setValueAt(resultado.getString("Intentos"),(i-1),4);					
 				
 			} 			
 		}
 		catch(SQLException sql)
 		{
 			System.out.println("Registro no encontrado");
 		} 		
 	}	
	public int Buscar(int num2)
 	{
 		Connection conexion;
 		Statement instruccion;
 		ResultSet resultado; 		
 		String buscar="SELECT * FROM Mejores WHERE(Puesto='"+num2+"')";
 		String mDNS="jdbc:odbc:Mejor";
 		try
 		{
 			conexion=DriverManager.getConnection(mDNS);
 			instruccion=conexion.createStatement();
 			resultado=instruccion.executeQuery(buscar);
 			
 			if(resultado.next())
 			{
 				System.out.println("Encontrado");
 				num2=num2+1;
 				int a = num2;
 				num2=Buscar(a);//RECURSIVIDAD
 			}
 		}
 		catch(SQLException sql)
 		{
 			System.out.println("Registro no encontrado");  			
 		}	 		
		return num2;
 	}
	public void Cerrar(){
		this.dispose();		
	}
}
   
    
    