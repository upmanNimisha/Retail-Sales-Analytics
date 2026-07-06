import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class CSVImporter {

    public static void importCustomers(Connection con, String filePath) {
        String line;

        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));

            // Header skip
            br.readLine();

            String sql = "INSERT INTO customers VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            while ((line = br.readLine()) != null) {
                try {
                    String[] data = line.split(",");

                    ps.setInt(1, Integer.parseInt(data[0]));
                    ps.setInt(2, Integer.parseInt(data[1]));
                    ps.setInt(3, Integer.parseInt(data[2]));
                    ps.setInt(4, Integer.parseInt(data[3]));
                    ps.setDouble(5, Double.parseDouble(data[4]));

                    ps.executeUpdate();   // MUST be inside try

                } catch (Exception e) {
                    System.out.println("Skipped row: " + line);
                }
            }

            br.close();
            System.out.println("Customers imported successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void importOrderDetails(Connection con, String filePath) {
        String line;

        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));

            br.readLine(); // skip header

            String sql = "INSERT INTO order_details VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);

            while ((line = br.readLine()) != null) {
                try {
                    String[] data = line.split(",");

                    ps.setInt(1, Integer.parseInt(data[0]));
                    ps.setInt(2, Integer.parseInt(data[1]));
                    ps.setInt(3, Integer.parseInt(data[2]));
                    ps.setInt(4, Integer.parseInt(data[3]));
                    ps.setDouble(5, Double.parseDouble(data[4]));

                    ps.executeUpdate();   // MUST be inside try

                } catch (Exception e) {
                    System.out.println("Skipped row: " + line);
                }
            }

            br.close();
            System.out.println("Order details imported successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void importProducts(Connection con, String filePath) {
        String line;

        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));

            br.readLine(); // header skip

            String sql = "INSERT INTO products VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                ps.setInt(1, Integer.parseInt(data[0]));
                ps.setString(2, data[1]);
                ps.setString(3, data[2]);
                ps.setString(4, data[3]);
                ps.setString(5, data[4]);
                ps.setDouble(6, Double.parseDouble(data[5]));
                ps.setDouble(7, Double.parseDouble(data[6]));

                ps.executeUpdate();
            }

            br.close();
            System.out.println("Products imported successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void importStores(Connection con, String filePath) {
        String line;

        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));

            br.readLine(); // skip header

            String sql = "INSERT INTO stores VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                ps.setInt(1, Integer.parseInt(data[0]));
                ps.setString(2, data[1]);
                ps.setString(3, data[2]);
                ps.setString(4, data[3]);
                ps.setString(5, data[4]);

                ps.executeUpdate();
            }

            br.close();
            System.out.println("Stores imported successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void importOrders(Connection con, String filePath) {
        String line;

        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));

            br.readLine(); // skip header

            String sql = "INSERT INTO orders VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);

            while ((line = br.readLine()) != null) {
                try {
                    String[] data = line.split(",");

                    // check correct number of columns
                    if (data.length != 5) {
                        System.out.println("Bad row: " + line);
                        continue;
                    }

                    ps.setInt(1, Integer.parseInt(data[0].trim())); // order_id
                    ps.setInt(2, Integer.parseInt(data[1].trim())); // customer_id
                    ps.setInt(3, Integer.parseInt(data[2].trim())); // store_id
                    ps.setDate(4, java.sql.Date.valueOf(data[3].trim())); // order_date
                    ps.setString(5, data[4].trim()); // payment_method

                    ps.executeUpdate();

                } catch (Exception e) {
                    System.out.println("Skipped row: " + line);
                    e.printStackTrace();
                }
            }

            br.close();
            System.out.println("Orders imported successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}