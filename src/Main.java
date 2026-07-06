import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        Connection con = DBConnection.getConnection();


      /*CSVImporter.importProducts(
                con,
                "C:\\Users\\Nimisha Upman\\Desktop\\Projects\\Retail Sales Analytics\\product.csv"
        );
        CSVImporter.importStores(
                con,
                "C:\\Users\\Nimisha Upman\\Desktop\\Projects\\Retail Sales Analytics\\stores.csv"
        );*/
       /* CSVImporter.importOrders(
                con,
                "C:\\Users\\Nimisha Upman\\Desktop\\Projects\\Retail Sales Analytics\\orders.csv"
        );
        CSVImporter.importOrderDetails(
                con,
                "C:\\Users\\Nimisha Upman\\Desktop\\Projects\\Retail Sales Analytics\\order_details.csv"
        );*/
    }
}