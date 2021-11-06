/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Luis Fernando Paxel
 */
public class conexion2 {
     Connection con;
    public conexion2(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_punto_venta","root","LuisMatrix999");
        } catch (Exception e) {
        }
    }
    
    public Connection getCon(){
        return con;
    }
}
