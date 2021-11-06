package modelo;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.table.DefaultTableModel;

/* * @author Luis Fernando Paxel
 */
public class Detalle_compra {

    private int id,No_orden, item, idproveedor, idproducto;
    private String descripcion;
    private Double precio;
    private int cantidad;
    private Double subtotal;

    public Detalle_compra() {
    }
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int respuesta = 0;

    public Detalle_compra(Integer id, Integer No_orden, Integer item, Integer idproveedor, Integer idproducto, Integer cantidad, Double precio,String descripcion,  Double subtotal) {
        this.id = id;
        this.No_orden = No_orden;
        this.item = item;
        this.idproveedor = idproveedor;
        this.idproducto = idproducto;
        this.descripcion = descripcion;
        this.precio = precio;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
    }

      public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNo_orden() {
        return No_orden;
    }

    public void setNo_orden(Integer No_orden) {
        this.No_orden = No_orden;
    }

    public Integer getItem() {
        return item;
    }

    public void setItem(Integer item) {
        this.item = item;
    }

    public Integer getIdproveedor() {
        return idproveedor;
    }

    public void setIdproveedor(Integer idproveedor) {
        this.idproveedor = idproveedor;
    }

    public Integer getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(Integer idproducto) {
        this.idproducto = idproducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }
    
    
    public int GuardarDetalle(Detalle_compra vi) {
        String sql = "insert into compras_detalle(idcompra,idproducto,Cantidad,Precio_costo_unitario)values(?,?,?,?);";
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

    public DefaultTableModel Mostrar() {
        DefaultTableModel tabla = new DefaultTableModel();
        try {
            cn = new Conexion();
            cn.abrirCon();
            String query = "select idCompra_detalle as id, m.idcompra,P.producto, m.Cantidad, m.Precio_costo_unitario, P.Idproducto from compras_detalle as m, productos as P where m.idproducto=P.idProducto order by idCompra_detalle;";
            ResultSet consulta = cn.conexiondb.createStatement().executeQuery(query);
            String encabezado[] = {"Id", "Venta", "Cantidad", "precio", "producto", "id_producto"};
            tabla.setColumnIdentifiers(encabezado);
            String datos[] = new String[6];
            while (consulta.next()) {
                datos[0] = consulta.getString("id");
                datos[1] = consulta.getString("idcompra");
                datos[2] = consulta.getString("producto");
                datos[3] = consulta.getString("Cantidad");
                datos[4] = consulta.getString("Precio_costo_unitario");
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
            String query = "delete from compras_detalle where idCompra_detalle=" + id;
            cn = new Conexion();
            cn.abrirCon();
            parametro = (PreparedStatement) cn.conexiondb.prepareStatement(query);

            parametro.executeUpdate();
            cn.cerrarCon();
        } catch (HeadlessException | SQLException ex) {
            System.out.println("Error!!" + ex.getMessage());

        }
    }
    
    
    
     
    public int modificando_cantidades()
    {
        int devolver=0;
        int antiguo_idprod, nuevo_idprod, validar_existencias, cantidad_de_registro, cantidad_a_reducir, validar, nueva_cantidad;
        antiguo_idprod=id_prod_de_registro();   //obteniendo el id del registro
        nuevo_idprod=getIdproducto();           //obteniendo el nuevo id
        validar_existencias=obtener_cantidad_de_registro(); //obteniendo la cantidad de existencias de la tabla productos
        cantidad_de_registro=cantidad_de_comprasdetalle();  //obteniendo la cantidad del registro compras_detalle
        cantidad_a_reducir=getCantidad();       //la cantidad que se va a reducir o aumentar
        validar=cantidad_de_registro-cantidad_a_reducir;    //resta para la validacion
        
       
        if(validar_existencias>validar || (cantidad_de_registro==cantidad_a_reducir && antiguo_idprod!=nuevo_idprod) || (cantidad_de_registro==cantidad_a_reducir && antiguo_idprod==nuevo_idprod)) //aqui está el error   if(validar_existencias>cantidad_de_ventas)    if(validar_existencias>cantidad_reducir || (cantidad_de_ventas==cantidad_reducir && antiguo_idprod!=nuevo_idprod))
        {
            if(antiguo_idprod==nuevo_idprod)
            {
                if(cantidad_de_registro>cantidad_a_reducir)
                {
                    nueva_cantidad=cantidad_de_registro-cantidad_a_reducir;
                    try
                    {
                        cn=new Conexion();
                        String consulta="update productos set Existencia=Existencia-? where idProducto=?";
                        cn.abrirCon();
                        PreparedStatement parametro= (PreparedStatement) cn.conexiondb.prepareStatement(consulta);
                        parametro.setInt(1, nueva_cantidad);
                        parametro.setInt(2, nuevo_idprod);

                        devolver=parametro.executeUpdate();
                        cn.cerrarCon();
                    }catch(SQLException ex)
                    {

                    }
                }
                else if(cantidad_de_registro<cantidad_a_reducir)
                {
                    nueva_cantidad=cantidad_a_reducir - cantidad_de_registro;
                    try
                    {
                        cn=new Conexion();
                        String consulta="update productos set Existencia=Existencia+? where idProducto=?";
                        cn.abrirCon();
                        PreparedStatement parametro= (PreparedStatement) cn.conexiondb.prepareStatement(consulta);
                        parametro.setInt(1, nueva_cantidad);
                        parametro.setInt(2, getIdproducto());

                        devolver=parametro.executeUpdate();
                        cn.cerrarCon();
                    }catch(SQLException ex)
                    {

                    }

                }
                else{return 1;}
            }
            else
            {
                int nuevo_prod=obtener_cantidad_de_registro(); //cantidad de la tabla productos
                try
                {
                    if(nuevo_prod>cantidad_de_registro) //cantidad de compras detalle
                    {
                        
                        modificacion_antiguoidprod(cantidad_de_registro); //cantidad de compras_Detalle
                        
                    
                        cn=new Conexion();
                        String consulta="update productos set Existencia=Existencia+? where idProducto=?";
                        cn.abrirCon();
                        PreparedStatement parametro= (PreparedStatement) cn.conexiondb.prepareStatement(consulta);
                        parametro.setInt(1, cantidad_a_reducir);
                        parametro.setInt(2, nuevo_idprod);
                        devolver=parametro.executeUpdate();
                    }
                    
                    cn.cerrarCon();
                }catch(SQLException ex)
                {

                }
            }
            
            
        }
        
        return devolver;
    }
    
    
    public void modificacion_antiguoidprod(int cantidad)
    {
        int antiguo_idprod=0, retorno=0;
        antiguo_idprod=id_prod_de_registro();
        try
        {
            cn=new Conexion();
            String consulta="update productos set Existencia=Existencia-? where idProducto=?";
            cn.abrirCon();
            PreparedStatement parametro= (PreparedStatement) cn.conexiondb.prepareStatement(consulta);
            parametro.setInt(1, cantidad);
            parametro.setInt(2, antiguo_idprod);
            
            retorno=parametro.executeUpdate();
            cn.cerrarCon();
        }catch(Exception ex)
        {
            
        }
    }
    
    public int cantidad_de_comprasdetalle()
    {
        int existencias=0;
        try
        {
            cn=new Conexion();
            String consulta="select Cantidad from compras_detalle where idCompra_detalle=?";
            cn.abrirCon();
            PreparedStatement parametro= (PreparedStatement) cn.conexiondb.prepareStatement(consulta);
            parametro.setInt(1, this.getId());
            
            ResultSet peticion=parametro.executeQuery();
            while(peticion.next())
            {
                existencias=peticion.getInt(1);
            }
            cn.cerrarCon();
        }catch(Exception ex)
        {
            
        }
        return existencias;
    }
    
    public int obtener_cantidad_de_registro()
    {
        int existencias=0;
        try
        {
            cn=new Conexion();
            String consulta="select Existencia from productos where idProducto=?;";
            cn.abrirCon();
            PreparedStatement parametro= (PreparedStatement) cn.conexiondb.prepareStatement(consulta);
            parametro.setInt(1, id_prod_de_registro());
            
            ResultSet peticion=parametro.executeQuery();
            while(peticion.next())
            {
                existencias=peticion.getInt(1);
            }
            cn.cerrarCon();
        }catch(SQLException ex)
        {
            
        }
        
        
        return existencias;
    }
   
    public int id_prod_de_registro()
    {
        int mayor_idp=0;
        try
        {
            cn=new Conexion();
            cn.abrirCon();
            String idprod_de_registro="select idproducto from compras_detalle where idCompra_detalle=?";
            PreparedStatement parametros=(PreparedStatement)cn.conexiondb.prepareStatement(idprod_de_registro);
            parametros.setInt(1,this.getId());
            ResultSet peticion=parametros.executeQuery();
            while(peticion.next())
            {
                mayor_idp=peticion.getInt(1);
            }
            cn.cerrarCon();
        }catch(Exception ex)
        {
                
        }
        return mayor_idp;
    }
    ///////////////////////////////////////////////////////////////////
    
    
    public int idcompra_max()
    {
        int mayor_idc=0;
        try
        {
            cn=new Conexion();
            cn.abrirCon();
            String buscar_idc_mayor="select MAX(idcompra) from compras";
            ResultSet consulta=cn.conexiondb.createStatement().executeQuery(buscar_idc_mayor);
            while(consulta.next())
            {
                mayor_idc=consulta.getInt(1);
            }
            cn.cerrarCon();
        }catch(Exception ex)
        {
                
        }
        return mayor_idc;
    }
    
    public int modificacion_eliminar()
    {
        int antiguo_idprod=0, retorno=0, cantidad_disponible, cantidad_eliminar;
        cantidad_disponible=obtener_cantidad_de_registro();
        cantidad_eliminar=cantidad_de_comprasdetalle();
        antiguo_idprod=id_prod_de_registro();
        if(cantidad_disponible>cantidad_eliminar)
        {
            try
            {
                cn=new Conexion();
                String consulta="update productos set Existencia=Existencia-? where idProducto=?";
                cn.abrirCon();
                PreparedStatement parametro= (PreparedStatement) cn.conexiondb.prepareStatement(consulta);
                parametro.setInt(1, cantidad_eliminar);
                parametro.setInt(2, antiguo_idprod);

                retorno=parametro.executeUpdate();
                cn.cerrarCon();
            }catch(Exception ex)
            {

            }
        }
        return retorno;
    }
    
    
    public int eliminar()
    {
        int devolver=0;
        try
        {
            PreparedStatement parametro;
            String codigo_sql="delete from db_punto_venta.compras_detalle where idCompra_detalle=?";
            cn = new Conexion();
            cn.abrirCon();
            parametro=(PreparedStatement) cn.conexiondb.prepareStatement(codigo_sql);
            parametro.setInt(1,this.getId());
            
            devolver=parametro.executeUpdate();
            cn.cerrarCon();
        }catch(HeadlessException | SQLException ex)
        {
            System.out.println("error........"+ex.getMessage());
        }
        
        return devolver;
    }
    
     public int modificar()
    {
        int devolver=0;
        try
        {
            cn = new Conexion();
            cn.abrirCon();
            PreparedStatement parametros;
            String consulta_sql="update compras_detalle set  idproducto=?, Cantidad=?, Precio_costo_unitario=? where idCompra_detalle=?";
            parametros=(PreparedStatement)cn.conexiondb.prepareStatement(consulta_sql);
            
            parametros.setInt(1, getIdproducto());
            parametros.setInt(2, getCantidad());
            parametros.setDouble(3, this.getPrecio());
            parametros.setInt(4, this.getId());
            
            devolver=parametros.executeUpdate();
            modificar_costo_prod(0);
            cn.cerrarCon();
        }catch(SQLException ex)
        {
            
        }
        
        return devolver;
    }
     
     public int modificar_costo_prod(int cantidad)
    {
        double precio_costo=this.getPrecio();
        double precio_venta=precio_costo*1.25;
        int devolver=0;
        try
        {
            PreparedStatement parametro;
            String codigo_sql="update db_punto_venta.productos set Precio_costo=?, Precio_venta=?, Existencia=Existencia+? where idProducto=?";
            cn = new Conexion();
            cn.abrirCon();
            parametro=(PreparedStatement) cn.conexiondb.prepareStatement(codigo_sql);
            
            parametro.setDouble(1, this.getPrecio());
            parametro.setDouble(2, precio_venta);
            parametro.setDouble(3, cantidad);
            parametro.setInt(4, getIdproducto());
            
            devolver=parametro.executeUpdate();
            cn.cerrarCon();
        }catch(HeadlessException | SQLException ex)
        {
            System.out.println("error........"+ex.getMessage());
        }
        
        return devolver;
    }

  
}
