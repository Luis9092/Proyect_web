package modelo;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import javax.swing.table.DefaultTableModel;

/**
 * @author Luis Fernando Paxel Cojolón
 */
public class Ventas {

    private int No_fact, id, id_cliente, id_empleado;
    private String serie, fecha_factura, Fecha_ingreso;

    public Ventas() {
    }

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int respuesta = 0;

    public Ventas(int id, int No_fact, String serie, String fecha_factura, int id_cliente, int id_empleado, String Fecha_ingreso) {
        this.No_fact = No_fact;
        this.id = id;
        this.id_cliente = id_cliente;
        this.id_empleado = id_empleado;
        this.serie = serie;
        this.fecha_factura = fecha_factura;
        this.Fecha_ingreso = Fecha_ingreso;
    }

    public int getNo_fact() {
        return No_fact;
    }

    public void setNo_fact(int No_fact) {
        this.No_fact = No_fact;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getFecha_factura() {
        return fecha_factura;
    }

    public void setFecha_factura(String fecha_factura) {
        this.fecha_factura = fecha_factura;
    }

    public String getFecha_ingreso() {
        return Fecha_ingreso;
    }

    public void setFecha_ingreso(String Fecha_ingreso) {
        this.Fecha_ingreso = Fecha_ingreso;
    }

    public HashMap max_fact() {
        HashMap<String, String> drop3 = new HashMap();
        try {
            cn = new Conexion();
            String query = ("SELECT idVenta, MAX(No_factura) as Factura FROM ventas;;");
            cn.abrirCon();
            ResultSet consulta = cn.conexiondb.createStatement().executeQuery(query);
            while (consulta.next()) {
                String uno = consulta.getString("Factura");
                int dos = Integer.valueOf(uno);
                int tres = dos + 1;
                String cuatro = String.valueOf(tres);
                drop3.put(consulta.getString("idVenta"), cuatro);
            }
            cn.cerrarCon();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return drop3;
    }

    public int agregar() {
        int retorno;

        {
            try {

                String fecha = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());

                PreparedStatement parametro;
                String query = "insert into ventas (No_factura,Serie,Fecha_factura,Idcliente,idempleado,Fecha_ingreso)values(?,?,?,?,?,?);";
                cn = new Conexion();
                cn.abrirCon();
                parametro = (PreparedStatement) cn.conexiondb.prepareStatement(query);
                parametro.setInt(1, this.getNo_fact());
                parametro.setString(2, this.getSerie());
                parametro.setString(3, this.getFecha_factura());
                parametro.setInt(4, this.getId_cliente());
                parametro.setInt(5, this.getId_empleado());
                parametro.setString(6, fecha);
                retorno = parametro.executeUpdate();
                cn.cerrarCon();
            } catch (HeadlessException | SQLException ex) {
                System.out.println("Error!!22" + ex.getMessage());
                retorno = 0;

            }
            return retorno;
        }
    }

    public String Idventas() {
        String idventas = "";
        String sql = "select max(IdVenta) from ventas;";

        try {
            cn.abrirCon();
            con = cn.conexiondb;
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                idventas = rs.getString(1);
            }
        } catch (SQLException ex) {

        }
        return idventas;
    }
    
    public int GuardarDetalle(Ventas2 vi) {
        String sql = "insert into ventas_detalle(idVenta,idProducto,Cantidad,Precio_unitario) values(?,?,?,?);";
        try {
            cn.abrirCon();
            con = cn.conexiondb;
            ps = con.prepareStatement(sql);
            ps.setInt(1, vi.getId());
            ps.setInt(2, vi.getIdproducto());
            ps.setInt(3, vi.getCantidad());
            ps.setDouble(4, vi.getPrecio());
            ps.executeUpdate();
        } catch (SQLException ex) {

        }
        return respuesta;
    }
    
     public DefaultTableModel leer3() {
        DefaultTableModel tabla = new DefaultTableModel();
        try {
            cn = new Conexion();
            cn.abrirCon();
            String query = "select idVenta as id, No_factura,Serie, Fecha_factura,Idcliente,idempleado,Fecha_ingreso from ventas;";
            ResultSet consulta = cn.conexiondb.createStatement().executeQuery(query);
            String encabezado[] = {"Id", "No", "serie", "fechafact", "cliente", "empleado", "fecha"};
            tabla.setColumnIdentifiers(encabezado);
            String datos[] = new String[7];
            while (consulta.next()) {
                datos[0] = consulta.getString("id");
                datos[1] = consulta.getString("No_factura");
                datos[2] = consulta.getString("Serie");
                datos[3] = consulta.getString("Fecha_factura");
                datos[4] = consulta.getString("Idcliente");
                datos[5] = consulta.getString("idempleado");
                datos[6] = consulta.getString("Fecha_ingreso");

                tabla.addRow(datos);
            }
            cn.cerrarCon();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return tabla;
    }

    public int modificar() {
        int retorno;

        {
            try {
                PreparedStatement parametro;
                String query = "update ventas set No_factura=?,Serie=?, Fecha_factura=?,Idcliente=?,idempleado=?,Fecha_ingreso=? where idVenta=?;";
                cn = new Conexion();
                cn.abrirCon();
                parametro = (PreparedStatement) cn.conexiondb.prepareStatement(query);
                parametro.setInt(1, this.getNo_fact());
                parametro.setString(2, this.getSerie());
                parametro.setString(3, this.getFecha_factura());
                parametro.setInt(4, this.getId_cliente());
                parametro.setInt(5, this.getId_empleado());
                parametro.setString(6, this.getFecha_ingreso());
                parametro.setInt(7, this.getId());

                retorno = parametro.executeUpdate();
                cn.cerrarCon();
            } catch (HeadlessException | SQLException ex) {
                System.out.println("Error!!" + ex.getMessage());
                retorno = 0;

            }
            return retorno;
        }
    }

    public void eliminar_venta(int id) {
        String query = "delete from ventas where idVenta=" + id;
        try {
            PreparedStatement parametro;

            cn = new Conexion();
            cn.abrirCon();
            parametro = (PreparedStatement) cn.conexiondb.prepareStatement(query);

            parametro.executeUpdate();
            cn.cerrarCon();
        } catch (HeadlessException | SQLException ex) {
            System.out.println("Error!!" + ex.getMessage());

        }

    }

    public void eliminar_detalles(int id) {
        try {
            PreparedStatement parametro;
            String query = "delete from ventas_detalle where idVenta=" + id;
            cn = new Conexion();
            cn.abrirCon();
            parametro = (PreparedStatement) cn.conexiondb.prepareStatement(query);

            parametro.executeUpdate();
            cn.cerrarCon();
        } catch (HeadlessException | SQLException ex) {
            System.out.println("Error!!" + ex.getMessage());

        }
    }

}
