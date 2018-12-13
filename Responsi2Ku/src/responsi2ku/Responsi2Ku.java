package responsi2ku;

import java.sql.*;
import java.util.*;

/**
 *
 * @author IKHSAN
 */
public class Responsi2Ku {

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/hp";
    static final String USER = "root";
    static final String PASS = "";
    static Connection conn;
    static Statement stat;
    static ResultSet rs;
    static String sql;
    static ArrayList<ArrayList<String>> arlist = new ArrayList<>();
    static PreparedStatement preparedStmt;
    static Scanner input = new Scanner(System.in);
    static Scanner input1 = new Scanner(System.in);
    static Scanner input2 = new Scanner(System.in);
    static Scanner input3 = new Scanner(System.in);
    static Scanner input4 = new Scanner(System.in);
    static Scanner input5 = new Scanner(System.in);
    static int i = 0, j = 0, pilihan = 0;
    static String nosal, nama, alamat, brand;

    public static void main(String[] args) throws SQLException {
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stat = conn.createStatement();
            while (pilihan != 6) {
                menu();
                switch (pilihan) {
                    case 1:
                        menu1();
                        break;
                    case 2:
                        menu2();
                        break;
                    case 3:
                        menu3();
                        break;
                    case 4:
                        menu4();
                        break;
                    case 5:
                        menu5();
                        break;
                    case 6:
                        System.out.println("Bye :)");
                        break;
                }
            }
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
        }
    }

    static void menu() {
        System.out.println("Menu Pilihan ");
        System.out.println("1.Nambah Sales");
        System.out.println("2.Lihat Sales");
        System.out.println("3.Update Sales");
        System.out.println("4.Hapus Sales");
        System.out.println("5.Cari Sales");
        System.out.println("6.Keluar");
        System.out.print("Masukkan pilihan : ");
        pilihan = input.nextInt();
    }

    static void menu1() throws SQLException {
        System.out.println("==========================");
        System.out.println("Nambah");
        System.out.print("Masukkan Nosal : ");
        nosal = input1.nextLine();
        sql = "SELECT*FROM member WHERE nosal = ?";
        preparedStmt = conn.prepareStatement(sql);
        preparedStmt.setString(1, nosal);
        preparedStmt.execute();
        if (preparedStmt.getResultSet().next()) {
            System.out.println("Data Sudah Ada Boss");
        } else {
            alamat = null;
            System.out.print("Masukkan Nama : ");
            nama = input2.next();
            System.out.print("Masukkan Brand : ");
            brand = input3.next();
            System.out.print("Masukkan Alamat : ");
            alamat = input4.next();
            sql = "INSERT INTO member(`nosal`,`nama`,`brand`,`alamat`) value(?,?,?,?)";
            preparedStmt = conn.prepareStatement(sql);
            preparedStmt.setString(1, nosal);
            preparedStmt.setString(2, nama);
            preparedStmt.setString(3, brand);
            preparedStmt.setString(4, alamat);
            preparedStmt.execute();
            System.out.println("Data berhasil di masukan !");
            System.out.println("==========================");
        }
        System.out.println("==========================");
    }

    static void menu2() throws SQLException {
        sql = "SELECT*FROM member";
        rs = stat.executeQuery(sql);
        System.out.println("Nomor Sales | Nama | Alamat | Brand");
        arlist.clear();
        i = 0;
        while (rs.next()) {
            arlist.add(new ArrayList());
            ((ArrayList) arlist.get(i)).add(rs.getString("nosal"));
            ((ArrayList) arlist.get(i)).add(rs.getString("nama"));
            ((ArrayList) arlist.get(i)).add(rs.getString("alamat"));
            ((ArrayList) arlist.get(i)).add(rs.getString("brand"));
            i++;
        }
        for (i = 0; i < arlist.size(); i++) {
            for (j = 0; j < ((ArrayList) arlist.get(i)).size(); j++) {
                System.out.print((String) ((ArrayList) arlist.get(i)).get(j) + " | ");
            }
            System.out.println();
        }
    }

    static void menu3() throws SQLException {
        System.out.println("==========================");
        System.out.println("Update");
        System.out.print("Masukkan Nosal : ");
        nosal = input1.nextLine();
        sql = "SELECT*FROM member WHERE nosal = ?";
        preparedStmt = conn.prepareStatement(sql);
        preparedStmt.setString(1, nosal);
        preparedStmt.execute();
        if (preparedStmt.getResultSet().next()) {
            System.out.println("Data Di Temukan Dapat Di Update");
            System.out.println("==========================");
            System.out.println("Update");
            System.out.print("Masukkan Nomor Sales : ");
            nosal = input1.next();
            System.out.print("Masukkan Nama : ");
            nama = input2.next();
            System.out.print("Masukkan Alamat : ");
            alamat = input3.next();
            System.out.print("Masukkan Brand : ");
            brand = input4.next();
            sql = "UPDATE member SET nama = ? , brand = ? , alamat = ? where nosal = ?";
            preparedStmt = conn.prepareStatement(sql);
            preparedStmt.setString(4, nosal);
            preparedStmt.setString(1, nama);
            preparedStmt.setString(2, brand);
            preparedStmt.setString(3, alamat);
            preparedStmt.execute();
            System.out.println("Data berhasil di update !");
            System.out.println("==========================");
            arlist.clear();
            i = 0;
        } else {
            System.out.println("Data Tidak Ada Boss");
        }
        System.out.println("==========================");

    }

    static void menu4() throws SQLException {
        System.out.println("==========================");
        System.out.println("Hapus Sales");
        System.out.print("Masukkan Nomor Sales : ");
        nosal = input1.next();
        sql = "DELETE FROM member WHERE nosal = ?";
        preparedStmt = conn.prepareStatement(sql);
        preparedStmt.setString(1, nosal);
        preparedStmt.execute();
        System.out.println("Data berhasil di Hapus !");
        System.out.println("==========================");
    }

    static void menu5() throws SQLException {
        System.out.println("Cari Berdasarkan ");
        System.out.println("1. Nomor Sales");
        System.out.println("2. Alamat");
        System.out.println("3. Brand");
        System.out.print("Masukan Pilihan : ");
        int pil = input5.nextInt();
        switch (pil) {
            case 1:
                System.out.println("==========================");
                System.out.println("Cari Berdasarkan Nomor Sales");
                System.out.print("Masukkan Nomor Sales : ");
                nosal = input1.next();
                sql = "SELECT*FROM member WHERE nosal = ?";
                preparedStmt = conn.prepareStatement(sql);
                preparedStmt.setString(1, nosal);
                preparedStmt.execute();
                arlist.clear();
                i = 0;
                System.out.println("Data berhasil di Temukan !" + "\n");
                System.out.println("Nomor Sales | Nama | Alamat | Brand");
                while (preparedStmt.getResultSet().next()) {
                    arlist.add(new ArrayList());
                    ((ArrayList) arlist.get(i)).add(preparedStmt.getResultSet().getString("nosal"));
                    ((ArrayList) arlist.get(i)).add(preparedStmt.getResultSet().getString("nama"));
                    ((ArrayList) arlist.get(i)).add(preparedStmt.getResultSet().getString("alamat"));
                    ((ArrayList) arlist.get(i)).add(preparedStmt.getResultSet().getString("brand"));
                    i++;
                }
                for (i = 0; i < arlist.size(); i++) {
                    for (j = 0; j < ((ArrayList) arlist.get(i)).size(); j++) {
                        System.out.print((String) ((ArrayList) arlist.get(i)).get(j) + " | ");
                    }
                    System.out.println();
                }
                System.out.println("==========================");
                break;
            case 2:
                System.out.println("==========================");
                System.out.println("Cari Berdasarkan Alamat");
                System.out.print("Masukkan Alamat : ");
                alamat = input3.nextLine();
                sql = "SELECT*FROM member WHERE Alamat = ?";
                preparedStmt = conn.prepareStatement(sql);
                preparedStmt.setString(1, alamat);
                preparedStmt.execute();
                arlist.clear();
                i = 0;
                if (preparedStmt.getResultSet().next()) {
                    System.out.println("Data berhasil di Temukan !" + "\n");
                    System.out.println("Nomor Sales | Nama | Alamat | Brand");
                    while (preparedStmt.getResultSet().next()) {
                        arlist.add(new ArrayList());
                        ((ArrayList) arlist.get(i)).add(preparedStmt.getResultSet().getString("nosal"));
                        ((ArrayList) arlist.get(i)).add(preparedStmt.getResultSet().getString("nama"));
                        ((ArrayList) arlist.get(i)).add(preparedStmt.getResultSet().getString("alamat"));
                        ((ArrayList) arlist.get(i)).add(preparedStmt.getResultSet().getString("brand"));
                        i++;
                    }
                    for (i = 0; i < arlist.size(); i++) {
                        for (j = 0; j < ((ArrayList) arlist.get(i)).size(); j++) {
                            System.out.print((String) ((ArrayList) arlist.get(i)).get(j) + " | ");
                        }
                        System.out.println();
                    }
                    System.out.println("==========================");
                } else {
                    System.out.println("\n" + "Data Tidak Ditemukan !!" + "\n");
                }
                System.out.println("==========================");
                break;
            case 3:
                System.out.println("==========================");
                System.out.println("Cari Berdasarkan Brand");
                System.out.print("Masukkan Brand : ");
                brand = input4.next();
                sql = "SELECT*FROM member WHERE Brand = ?";
                preparedStmt = conn.prepareStatement(sql);
                preparedStmt.setString(1, brand);
                preparedStmt.execute();
                arlist.clear();
                i = 0;
                if (preparedStmt.getResultSet().next()) {
                    System.out.println("Data berhasil di Temukan !" + "\n");
                    System.out.println("Nomor Sales | Nama | Alamat | Brand");
                    while (preparedStmt.getResultSet().next()) {
                        arlist.add(new ArrayList());
                        ((ArrayList) arlist.get(i)).add(preparedStmt.getResultSet().getString("nosal"));
                        ((ArrayList) arlist.get(i)).add(preparedStmt.getResultSet().getString("nama"));
                        ((ArrayList) arlist.get(i)).add(preparedStmt.getResultSet().getString("alamat"));
                        ((ArrayList) arlist.get(i)).add(preparedStmt.getResultSet().getString("brand"));
                        i++;
                    }
                    for (i = 0; i < arlist.size(); i++) {
                        for (j = 0; j < ((ArrayList) arlist.get(i)).size(); j++) {
                            System.out.print((String) ((ArrayList) arlist.get(i)).get(j) + " | ");
                        }
                        System.out.println();
                    }
                    System.out.println("==========================");
                } else {
                    System.out.println("\n" + "Data Tidak Ditemukan !!" + "\n");
                }
                System.out.println("==========================");
                break;
            default:
                break;
        }
    }
}
