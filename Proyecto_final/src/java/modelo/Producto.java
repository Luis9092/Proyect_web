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
 *
 * @author Luis Fernando Paxel
 */
public class Producto {

    private String producto, descripcion, imagen, fecha_ingreso;
    private int idmarca, existencia, id;
    private double precio_costo, precio_venta;

    public Producto() {
    }
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int respuesta = 0;

    public Producto(int id, String producto, int idmarca, String descripcion, String imagen, double precio_costo, double precio_venta, int existencia, String fecha_ingreso) {
        this.producto = producto;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.fecha_ingreso = fecha_ingreso;
        this.idmarca = idmarca;
        this.existencia = existencia;
        this.id = id;
        this.precio_costo = precio_costo;
        this.precio_venta = precio_venta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getFecha_ingreso() {
        return fecha_ingreso;
    }

    public void setFecha_ingreso(String fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }

    public int getIdmarca() {
        return idmarca;
    }

    public void setIdmarca(int idmarca) {
        this.idmarca = idmarca;
    }

    public int getExistencia() {
        return existencia;
    }

    public void setExistencia(int existencia) {
        this.existencia = existencia;
    }

    public double getPrecio_costo() {
        return precio_costo;
    }

    public void setPrecio_costo(double precio_costo) {
        this.precio_costo = precio_costo;
    }

    public double getPrecio_venta() {
        return precio_venta;
    }

    public void setPrecio_venta(double precio_venta) {
        this.precio_venta = precio_venta;
    }

    public DefaultTableModel leer() {
        DefaultTableModel tabla = new DefaultTableModel();
        try {
            cn = new Conexion();
            String query = "Select p.idproducto as id, p.producto, p.descripcion, p.imagen, p.precio_costo, p.precio_venta, p.existencia, p.fecha_ingreso, m.marca, p.idmarca,p.imagen from productos as p INNER JOIN marcas as m on p.idmarca=m.idmarca ORDER BY idproducto;";
            cn.abrirCon();
            ResultSet consulta = cn.conexiondb.createStatement().executeQuery(query);
            String encabezado[] = {"id", "producto", "descripcion", "Imagen", "precio_costo", "precio_venta", "Existencias", "Fecha ingreso", "marca", "id_marca", "img"};
            tabla.setColumnIdentifiers(encabezado);
            String datos[] = new String[11];
            while (consulta.next()) {
                datos[0] = consulta.getString("id");
                datos[1] = consulta.getString("producto");
                datos[2] = consulta.getString("descripcion");
                datos[3] = consulta.getString("imagen");
                datos[4] = consulta.getString("precio_costo");
                datos[5] = consulta.getString("precio_venta");
                datos[6] = consulta.getString("existencia");
                datos[7] = consulta.getString("fecha_ingreso");
                datos[8] = consulta.getString("marca");
                datos[9] = consulta.getString("idmarca");
                datos[10] = consulta.getString("imagen");

                tabla.addRow(datos);
            }
            cn.cerrarCon();
        } catch (SQLException ex) {
            System.out.println("Error:" + ex.getMessage());
        }
        return tabla;
    }

    public int modificar() {
        int devolver;
        {
            try {
                String fecha = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
                PreparedStatement parametro;
                String codigo_sql = "update productos set Producto=?,idMarca=?,Descripcion=?,Precio_costo=?,Precio_venta=?,Existencia=?, Fecha_ingreso=?  where idProducto=?;";
                cn = new Conexion();
                cn.abrirCon();
                parametro = (PreparedStatement) cn.conexiondb.prepareStatement(codigo_sql);
                parametro.setString(1, this.getProducto());
                parametro.setInt(2, this.getIdmarca());
                parametro.setString(3, this.getDescripcion());
                parametro.setDouble(4, this.getPrecio_costo());
                parametro.setDouble(5, this.getPrecio_venta());
                parametro.setInt(6, this.getExistencia());
                parametro.setString(7, fecha);
                parametro.setInt(8, this.getId());

                devolver = parametro.executeUpdate();
                cn.cerrarCon();
            } catch (HeadlessException | SQLException ex) {
                System.out.println("error........" + ex.getMessage());
                devolver = 0;
            }

            return devolver;
        }
    }

    public int eliminar() {
        int retorno;

        {
            try {
                PreparedStatement parametro;
                String query = "delete from productos where idProducto=?;";
                cn = new Conexion();
                cn.abrirCon();
                parametro = (PreparedStatement) cn.conexiondb.prepareStatement(query);
                parametro.setInt(1, this.getId());
                retorno = parametro.executeUpdate();
                cn.cerrarCon();
            } catch (HeadlessException | SQLException ex) {
                System.out.println("Error!!" + ex.getMessage());
                retorno = 0;

            }
            return retorno;
        }
    }

    public DefaultTableModel leer2() {
        DefaultTableModel tabla = new DefaultTableModel();
        try {
            cn = new Conexion();
            String query = "Select p.idproducto as id, p.producto, p.descripcion, p.precio_costo, p.existencia, m.marca, p.idmarca from productos as p INNER JOIN marcas as m on p.idmarca=m.idmarca ORDER BY idproducto;";
            cn.abrirCon();
            ResultSet consulta = cn.conexiondb.createStatement().executeQuery(query);
            String encabezado[] = {"id", "producto", "descripcion", "precio_venta", "Existencias", "marca", "id_marca"};
            tabla.setColumnIdentifiers(encabezado);
            String datos[] = new String[8];
            while (consulta.next()) {
                datos[0] = consulta.getString("id");
                datos[1] = consulta.getString("producto");
                datos[2] = consulta.getString("descripcion");
                datos[3] = consulta.getString("precio_costo");
                datos[4] = consulta.getString("existencia");
                datos[5] = consulta.getString("marca");
                datos[6] = consulta.getString("idmarca");

                tabla.addRow(datos);
            }
            cn.cerrarCon();
        } catch (SQLException ex) {
            System.out.println("Error:" + ex.getMessage());
        }
        return tabla;
    }

    public Producto Listaid(int id) {
        Producto pro = new Producto();
        String sql = "select * from productos where idProducto=" + id;
        try {
            cn.abrirCon();
            con = cn.conexiondb;
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                pro.setId(rs.getInt(1));
                pro.setProducto(rs.getString(2));
                pro.setPrecio_costo(rs.getDouble(6));
                pro.setExistencia(rs.getInt(8));

            }
        } catch (SQLException ex) {
        }
        return pro;
    }

    public int modificar_existencia(int id, int exis) {
        String sql = "update productos set Existencia=? where idProducto=?";

        try {
            cn.abrirCon();
            con = cn.conexiondb;
            ps = con.prepareStatement(sql);
            ps.setInt(1, exis);
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
        }
        return respuesta;
    }

    public int modificar_pVenta(int id, double nuevo_precio) {
        String sql = "update productos set Precio_venta=? where idProducto=?;";

        try {
            cn.abrirCon();
            con = cn.conexiondb;
            ps = con.prepareStatement(sql);
            ps.setDouble(1, nuevo_precio);
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
        }
        return respuesta;
    }

    public Producto buscar(int id) {
        Producto pr = new Producto();
        String sql = "select * from productos where idProducto=" + id;
        try {
            cn.abrirCon();
            con = cn.conexiondb;
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                pr.setId(rs.getInt(1));
                pr.setProducto(rs.getString(2));
                pr.setPrecio_costo(rs.getDouble(6));
                pr.setExistencia(rs.getInt(8));
            }

        } catch (Exception ex) {

        }
        return pr;
    }

    public HashMap sele_prod() {
        HashMap<String, String> drop = new HashMap();
        try {
            cn = new Conexion();
            String query = ("select idProducto as id, Producto,Precio_venta  from productos;");
            cn.abrirCon();
            ResultSet consulta = cn.conexiondb.createStatement().executeQuery(query);
            while (consulta.next()) {
                drop.put(consulta.getString("id"), consulta.getString("Producto") + " |    Precio:" + consulta.getString("Precio_venta"));
            }
            cn.cerrarCon();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return drop;
    }

}
