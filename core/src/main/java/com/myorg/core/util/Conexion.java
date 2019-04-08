package com.myorg.core.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    
    protected static Connection cx; 
            
    public static Connection conectar() {
        if(cx != null) {
            return cx;
        }
        
        try {
            String driver ="com.mysql.jdbc.Driver";
            String url ="jdbc:mysql://localhost:3306/alaorden";
            String user = "root";
            String password ="";
            Class.forName(driver);
            cx = DriverManager.getConnection(url, user, password);
            System.out.println("Se conecto a la base de datos");
        }catch(Exception e) {
            e.printStackTrace();
        }
        return cx;
    }
    
    public static void desconectar(){
        if(cx == null){
            return;
        }
        
        try{
            cx.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
