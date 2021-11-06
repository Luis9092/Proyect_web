
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
 * @author Luis Fernando Paxel
 */
public class Compras {
private int id,ordenCompra,idProveedor;
private String fecha_orden,fecha_ingreso;
public Compras(){}
  Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int respuesta = 0;


    public Compras(int id, int ordenCompra, int idProveedor, String fecha_orden, String fecha_ingreso) {
        this.id = id;
        this.ordenCompra = ordenCompra;
        this.idProveedor = idProveedor;
        this.fecha_orden = fecha_orden;
        this.fecha_ingreso = fecha_ingreso;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrdenCompra() {
        return ordenCompra;
    }

    public void setOrdenCompra(int ordenCompra) {
        this.ordenCompra = ordenCompra;
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getFecha_orden() {
        return fecha_orden;
    }

    public void setFecha_orden(String fecha_orden) {
        this.fecha_orden = fecha_orden;
    }

    public String getFecha_ingreso() {
        return fecha_ingreso;
    }

    public void setFecha_ingreso(String fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }


  public HashMap max_Orden() {
        HashMap<String, String> drop_orden = new HashMap();
        try {
            cn = new Conexion();
            String query = ("SELECT idCompra, MAX(No_orden_compra) as Norden FROM compras;");
            cn.abrirCon();
            ResultSet consulta = cn.conexiondb.createStatement().executeQuery(query);
            while (consulta.next()) {
                String uno = consulta.getString("Norden");
                int dos = Integer.valueOf(uno);
                int tres = dos + 1;
                String cuatro = String.valueOf(tres);
                drop_orden.put(consulta.getString("idCompra"), cuatro);
            }
            cn.cerrarCon();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return drop_orden;
    }

  public int agregar() {
        int retorno;

        {
            try {

                String fecha = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());

                PreparedStatement parametro;
                String query = "insert into compras(No_orden_compra,idproveedor,Fecha_orden,Fecha_ingreso) values(?,?,?,?);";
                cn = new Conexion();
                cn.abrirCon();
                parametro = (PreparedStatement) cn.conexiondb.prepareStatement(query);
                parametro.setInt(1, this.getOrdenCompra());
                parametro.setInt(2, this.getIdProveedor());
                parametro.setString(3, this.getFecha_orden());
                parametro.setString(4, this.getFecha_ingreso());
                retorno = parametro.executeUpdate();
                cn.cerrarCon();
            } catch (HeadlessException | SQLException ex) {
                System.out.println("Error!!22" + ex.getMessage());
                retorno = 0;

            }
            return retorno;
        }
    }
  
  public String Idcompras() {
        String idcompras = "";
        String sql = "select max(idCompra) from compras;";

        try {
            cn.abrirCon();
            con = cn.conexiondb;
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                idcompras = rs.getString(1);
            }
        } catch (SQLException ex) {

        }
        return idcompras;
    }
    
   public HashMap buscar_prov() {
        HashMap<String, String> drop = new HashMap();
        try {
            cn = new Conexion();
            String query = ("select idProveedore as id, Proveedor from proveedores;");
            cn.abrirCon();
            ResultSet consulta = cn.conexiondb.createStatement().executeQuery(query);
            while (consulta.next()) {
                drop.put(consulta.getString("id"), consulta.getString("Proveedor"));
            }
            cn.cerrarCon();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return drop;
    }
   
    public DefaultTableModel leer_proveedor() {
        DefaultTableModel tabla = new DefaultTableModel();

        try {
            cn = new Conexion();
            cn.abrirCon();
            String query = "Select p.idCompra as id, p.No_orden_compra, m.Proveedor,p.Fecha_orden, p.Fecha_ingreso,  m.idProveedore from compras as p INNER JOIN proveedores as m on p.idproveedor=m.idProveedore ORDER BY idCompra;";
            ResultSet consulta = cn.conexiondb.createStatement().executeQuery(query);
            String encabezado[] = {"Id", "No_orden", "proveedor", "fecha_orden", "fecha_ingreso","idproveedor"};
            tabla.setColumnIdentifiers(encabezado);
            String datos[] = new String[9];
            while (consulta.next()) {

                datos[0] = consulta.getString("id");
                datos[1] = consulta.getString("No_orden_compra");
                datos[2] = consulta.getString("Proveedor");
                datos[3] = consulta.getString("Fecha_orden");
                datos[4] = consulta.getString("Fecha_ingreso");
                datos[5] = consulta.getString("idProveedore");
                tabla.addRow(datos);
            }
            cn.cerrarCon();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return tabla;
    }
 public HashMap compras_prod() {
        HashMap<String, String> drop = new HashMap();
        try {
            cn = new Conexion();
            String query = ("select idProducto as id, Producto,Precio_costo  from productos;");
            cn.abrirCon();
            ResultSet consulta = cn.conexiondb.createStatement().executeQuery(query);
            while (consulta.next()) {
                drop.put(consulta.getString("id"), consulta.getString("Producto") + " |    Precio:" + consulta.getString("Precio_costo"));
            }
            cn.cerrarCon();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return drop;
    }    
    
 public int modificar() {
        int retorno;

        {
            try {
                PreparedStatement parametro;
                String query = "update compras set No_orden_compra=?,idproveedor=?,Fecha_orden=?,Fecha_ingreso=? where idCompra=?;";
                cn = new Conexion();
                cn.abrirCon();
                parametro = (PreparedStatement) cn.conexiondb.prepareStatement(query);
                parametro.setInt(1, this.getOrdenCompra());
                parametro.setInt(2,this.getIdProveedor());
                parametro.setString(3, this.getFecha_orden());
                parametro.setString(4, this.getFecha_ingreso());
                parametro.setInt(5, this.getId());

                retorno = parametro.executeUpdate();
                cn.cerrarCon();
            } catch (HeadlessException | SQLException ex) {
                System.out.println("Error!!" + ex.getMessage());
                retorno = 0;

            }
            return retorno;
        }
    }
  public void eliminar_compra(int id) {
        String query = "delete from compras where idCompra=" + id;
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
            String query = "delete from compras_detalle where idcompra=" + id;
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
