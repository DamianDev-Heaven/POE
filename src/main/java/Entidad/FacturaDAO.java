package Entidad;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

    public class FacturaDAO {
        private Connection conexion;
        
        public FacturaDAO(Connection conexion){
            this.conexion = conexion;
        }
        
    public boolean guardarDetalle(DetalleFactura detalle, int idFactura) {
        String sql = "INSERT INTO detalle_compra (id_factura, id_producto, cantidad, precio_unitario, total_producto) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement pstmt = conexion.prepareStatement(sql)) {
            pstmt.setInt(1, idFactura);
            pstmt.setInt(2, detalle.getProductoId());
            pstmt.setInt(3, detalle.getCantidad());
            pstmt.setDouble(4, detalle.getPrecioUnitario());
            pstmt.setDouble(5, detalle.getSubtotal());

            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}