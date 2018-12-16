package proyectobd;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ProyectoBD {      
    
    public static void main(String[] args) {        
        Ventana ven=new Ventana();
        ven.setVisible(true);
        ven.setResizable(false);
    }  
    public static Timestamp convert(String str_date) {
    try {
      DateFormat formatter;
      formatter = new SimpleDateFormat("yyyy/MM/dd");     
      Date date = (Date) formatter.parse(str_date);
      java.sql.Timestamp timeStampDate = new Timestamp(date.getTime());
      return timeStampDate;
    } catch (ParseException e) {
      System.out.println("Exception :" + e);
      return null;
    }
  }
    
}
