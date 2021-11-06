package modelo;

import java.awt.HeadlessException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Luis Fernando Paxel
 */
public class Ventas_detalle {

    private int id, idventa, idproducto;
    private String cantidad;
    private double precio_unitario;

    public Ventas_detalle() {
    }
    private Conexion cn;

    public Ventas_detalle(int id, int idventa, int idproducto, String cantidad, double precio_unitario) {
        this.id = id;
        this.idventa = idventa;
        this.idproducto = idproducto;
        this.cantidad = cantidad;
        this.precio_unitario = precio_unitario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdventa() {
        return idventa;
    }

    public void setIdventa(int idventa) {
        this.idventa = idventa;
    }

    public int getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(int idproducto) {
        this.idproducto = idproducto;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio_unitario() {
        return precio_unitario;
    }

    public void setPrecio_unitario(double precio_unitario) {
        this.precio_unitario = precio_unitario;
    }

    public DefaultTableModel Mostrar() {
        DefaultTableModel tabla = new DefaultTableModel();
        try {
            cn = new Conexion();
            cn.abrirCon();
            String query = "select idVentas_detalle as id, m.idVenta,P.producto, m.Cantidad, m.Precio_unitario, P.Idproducto from ventas_detalle as m, productos as P where m.idProducto=P.idProducto order by idVentas_detalle ;";
            ResultSet consulta = cn.conexiondb.createStatement().executeQuery(query);
            String encabezado[] = {"Id", "Venta", "Cantidad", "precio", "producto", "id_producto"};
            tabla.setColumnIdentifiers(encabezado);
            String datos[] = new String[6];
            while (consulta.next()) {
                datos[0] = consulta.getString("id");
                datos[1] = consulta.getString("idVenta");
                datos[2] = consulta.getString("producto");
                datos[3] = consulta.getString("Cantidad");
                datos[4] = consulta.getString("Precio_unitario");
                datos[5] = consulta.getString("Idproducto");

                tabla.addRow(datos);
            }
            cn.cerrarCon();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return tabla;
    }

    public void eliminar_detalle(int id) {
        try {
            PreparedStatement parametro;
            String query = "delete from ventas_detalle where idVentas_detalle=" + id;
            cn = new Conexion();
            cn.abrirCon();
            parametro = (PreparedStatement) cn.conexiondb.prepareStatement(query);

            parametro.executeUpdate();
            cn.cerrarCon();
        } catch (HeadlessException | SQLException ex) {
            System.out.println("Error!!" + ex.getMessage());

        }
    }

    public int modificando_cantidad() {
        int retorno = 0, cantidad_de_ventas = 0, cantidad_reducir = 0, nuevaCantidad = 0, nuevo_idprod = 0, antiguo_idprod = 0, validar_existencias = 0;
        validar_existencias = obtener_cantidad(); //con este obtengo las existencias de la tabla productos
        antiguo_idprod = idprod_de_ventasdetalle();
        nuevo_idprod = getIdproducto();
        cantidad_de_ventas = cantidad_de_ventasdetalle(); //con este obtengo la cantidad de la tabla ventas detalle
        cantidad_reducir = Integer.valueOf( getCantidad()); //con este obtengo la cantidad ingresada en la JSP
        int prue = cantidad_reducir - cantidad_de_ventas;

        if (validar_existencias > prue || (cantidad_de_ventas == cantidad_reducir && antiguo_idprod != nuevo_idprod) || (cantidad_de_ventas == cantidad_reducir && antiguo_idprod == nuevo_idprod)) //aqui está el error   if(validar_existencias>cantidad_de_ventas)    if(validar_existencias>cantidad_reducir || (cantidad_de_ventas==cantidad_reducir && antiguo_idprod!=nuevo_idprod))
        { //if(validar_existencias>cantidad_reducir || (cantidad_de_ventas==cantidad_reducir && antiguo_idprod!=nuevo_idprod) || (cantidad_de_ventas==cantidad_reducir && antiguo_idprod==nuevo_idprod))
            if (antiguo_idprod == nuevo_idprod) {
                if (cantidad_de_ventas > cantidad_reducir) {
                    nuevaCantidad = cantidad_de_ventas - cantidad_reducir;
                    try {
                        cn = new Conexion();
                        String consulta = "update productos set Existencia=Existencia+? where idProducto=?";
                        cn.abrirCon();
                        PreparedStatement parametro = (PreparedStatement) cn.conexiondb.prepareStatement(consulta);
                        parametro.setInt(1, nuevaCantidad);
                        parametro.setInt(2, getIdproducto());

                        retorno = parametro.executeUpdate();
                        cn.cerrarCon();
                    } catch (SQLException ex) {

                    }
                } else if (cantidad_de_ventas < cantidad_reducir) {
                    nuevaCantidad = cantidad_reducir - cantidad_de_ventas;
                    try {
                        cn = new Conexion();
                        String consulta = "update productos set Existencia=Existencia-? where idProducto=?";
                        cn.abrirCon();
                        PreparedStatement parametro = (PreparedStatement) cn.conexiondb.prepareStatement(consulta);
                        parametro.setInt(1, nuevaCantidad);
                        parametro.setInt(2, getIdproducto());

                        retorno = parametro.executeUpdate();
                        cn.cerrarCon();
                    } catch (SQLException ex) {

                    }

                } else {
                    retorno = 1;
                }
            } else {
                int validar_nuevo = getIdproducto();
                int para_nuevo_prod = obtener_cantidad();
                try {
                    if (para_nuevo_prod > cantidad_reducir) {

                        modificacion_antiguoidprod(cantidad_de_ventas);

                        cn = new Conexion();
                        String consulta = "update productos set Existencia=Existencia-? where idProducto=?";
                        cn.abrirCon();
                        PreparedStatement parametro = (PreparedStatement) cn.conexiondb.prepareStatement(consulta);
                        parametro.setInt(1, cantidad_reducir);
                        parametro.setInt(2, nuevo_idprod);
                        retorno = parametro.executeUpdate();
                    }

                    cn.cerrarCon();
                } catch (SQLException ex) {

                }
            }
        } /*else if(cantidad_de_ventas==cantidad_reducir)
        {
            retorno=1;
        }*/ else {
            retorno = 0;
        }
        return retorno;
    }

    public void modificacion_antiguoidprod(int cantidad) {
        int antiguo_idprod = 0, retorno = 0;
        antiguo_idprod = idprod_de_ventasdetalle();
        try {
            cn = new Conexion();
            String consulta = "update productos set Existencia=Existencia+? where idProducto=?";
            cn.abrirCon();
            PreparedStatement parametro = (PreparedStatement) cn.conexiondb.prepareStatement(consulta);
            parametro.setInt(1, cantidad);
            parametro.setInt(2, antiguo_idprod);

            retorno = parametro.executeUpdate();
            cn.cerrarCon();
        } catch (SQLException ex) {

        }
    }

    public int idprod_de_ventasdetalle() {
        int id = 0;
        try {
            cn = new Conexion();
            String consulta = "select idProducto from ventas_detalle where idVentas_detalle=?";
            cn.abrirCon();
            PreparedStatement parametro = (PreparedStatement) cn.conexiondb.prepareStatement(consulta);
            parametro.setInt(1, getIdventa());

            ResultSet peticion = parametro.executeQuery();
            while (peticion.next()) {
                id = peticion.getInt(1);
            }
            cn.cerrarCon();
        } catch (SQLException ex) {

        }
        return id;
    }

    public int cantidad_de_ventasdetalle() {
        int existencias = 0;
        try {
            cn = new Conexion();
            String consulta = "select Cantidad from ventas_detalle where idVentas_detalle=?";
            cn.abrirCon();
            PreparedStatement parametro = (PreparedStatement) cn.conexiondb.prepareStatement(consulta);
            parametro.setInt(1, getIdventa());

            ResultSet peticion = parametro.executeQuery();
            while (peticion.next()) {
                existencias = peticion.getInt(1);
            }
            cn.cerrarCon();
        } catch (SQLException ex) {

        }
        return existencias;
    }

    public int reducir_cantidad() {
        int retorno = 0, existencias = 0, cantidad_reducir = 0;
        existencias = obtener_cantidad();
        cantidad_reducir = Integer.valueOf(this.getCantidad());
        if (existencias > cantidad_reducir) {
            try {
                cn = new Conexion();
                String consulta = "update productos set Existencia=Existencia-? where idProducto=?";
                cn.abrirCon();
                PreparedStatement parametro = (PreparedStatement) cn.conexiondb.prepareStatement(consulta);
                parametro.setInt(1, cantidad_reducir);
                parametro.setInt(2, getIdproducto());

                retorno = parametro.executeUpdate();
                cn.cerrarCon();
            } catch (SQLException ex) {

            }
        } else {
            retorno = 0;
        }

        return retorno;
    }

    public int obtener_cantidad() {
        int existencias = 0;
        try {
            cn = new Conexion();
            String consulta = "select Existencia from productos where idProducto=?;";
            cn.abrirCon();
            PreparedStatement parametro = (PreparedStatement) cn.conexiondb.prepareStatement(consulta);
            parametro.setInt(1, getIdproducto());

            ResultSet peticion = parametro.executeQuery();
            while (peticion.next()) {
                existencias = peticion.getInt(1);
            }
            cn.cerrarCon();
        } catch (SQLException ex) {

        }

        return existencias;
    }

    public double prueba_precio(String id_p) {
        //int id= Integer.valueOf(id_p);
        double precio_producto = 0;
        try {
            cn = new Conexion();
            cn.abrirCon();
            String obtenerprecio_unitario = "select Precio_venta from productos where idproducto=?";
            PreparedStatement parametro = (PreparedStatement) cn.conexiondb.prepareStatement(obtenerprecio_unitario);
            parametro.setString(1, id_p);
            ResultSet consulta = parametro.executeQuery();
            while (consulta.next()) {
                precio_producto = consulta.getDouble(1);
            }
            cn.cerrarCon();
        } catch (SQLException ex) {

        }
        return precio_producto;
    }

    public double precio_unitario(int id) {
        double precio_producto = 0;
        try {
            cn = new Conexion();
            cn.abrirCon();
            String obtenerprecio_unitario = "select Precio_venta from productos where idproducto=?";
            PreparedStatement parametro = (PreparedStatement) cn.conexiondb.prepareStatement(obtenerprecio_unitario);
            parametro.setInt(1, id);
            ResultSet consulta = parametro.executeQuery();
            while (consulta.next()) {
                precio_producto = consulta.getDouble(1);
            }
            cn.cerrarCon();
        } catch (SQLException ex) {

        }
        return precio_producto;
    }

    public int idventamax() {
        int mayor_idv = 0;
        try {
            cn = new Conexion();
            cn.abrirCon();
            String buscar_idv_mayor = "select MAX(idVenta) from ventas";
            ResultSet consulta = cn.conexiondb.createStatement().executeQuery(buscar_idv_mayor);
            while (consulta.next()) {
                mayor_idv = consulta.getInt(1);
            }
            cn.cerrarCon();
        } catch (SQLException ex) {

        }
        return mayor_idv;
    }
  
    public int modificar() {
        int devolver = 0;
        double precio_u = precio_unitario(getIdproducto());
        try {
            PreparedStatement parametro;
            String codigo_sql = "update ventas_detalle set  idProducto=?, Cantidad=?, Precio_unitario=? where idVentas_detalle=?";
            cn = new Conexion();
            cn.abrirCon();
            parametro = (PreparedStatement) cn.conexiondb.prepareStatement(codigo_sql);

            parametro.setInt(1, getIdproducto());
            parametro.setString(2, getCantidad());
            parametro.setDouble(3, precio_u);
            parametro.setInt(4, getIdventa());

            devolver = parametro.executeUpdate();
            cn.cerrarCon();
        } catch (SQLException ex) {
            System.out.println("error........" + ex.getMessage());
        }

        return devolver;
    }

}
