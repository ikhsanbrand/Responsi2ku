
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package responsi2ku;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

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

    public static void main(String[] args) throws SQLException {
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stat = conn.createStatement();
            String sql;

            ArrayList<ArrayList<String>> arlist = new ArrayList<>();

            PreparedStatement preparedStmt;
            Scanner input = new Scanner(System.in);
            Scanner input1 = new Scanner(System.in);
            Scanner input2 = new Scanner(System.in);
            Scanner input3 = new Scanner(System.in);
            Scanner input4 = new Scanner(System.in);
            int i = 0;
            int j = 0;
            int pilihan = 0;

            String nosal;
            String nama;
            String alamat = null;
            String brand;

            while (pilihan != 6) {
                System.out.println("Menu Pilihan ");
                System.out.println("1.Nambah Sales");
                System.out.println("2.Lihat Sales");
                System.out.println("3.Update Sales");
                System.out.println("4.Hapus Sales");
                System.out.println("5.Cari Sales");
                System.out.println("6.Keluar");
                System.out.print("Masukkan pilihan : ");
                pilihan = input.nextInt();

                switch (pilihan) {
                    case 1:
                        System.out.println("==========================");
                        System.out.println("Nambah Sales");
                        System.out.print("Masukkan Nomor Sales : ");
                        nosal = input1.nextLine();
                        System.out.print("Masukkan Nama : ");
                        nama = input2.nextLine();
                        System.out.print("Masukkan Brand : ");
                        brand = input3.nextLine();
                        System.out.print("Masukkan Alamat : ");
                        alamat = input4.nextLine();

                        sql = "INSERT INTO member(`nosal`,`nama`,`brand`,`alamat`) value(?,?,?,?)";

                        preparedStmt = conn.prepareStatement(sql);
                        preparedStmt.setString(1, nosal);
                        preparedStmt.setString(2, nama);
                        preparedStmt.setString(3, brand);
                        preparedStmt.setString(4, alamat);

                        preparedStmt.execute();

                        System.out.println("Data berhasil di masukan !");
                        System.out.println("==========================");

                        break;

                    case 2:
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
                        break;
                    case 3:
                        System.out.println("==========================");
                        System.out.println("Update");
                        System.out.print("Masukkan Nomor Sales : ");
                        nosal = input1.nextLine();
                        System.out.print("Masukkan Nama : ");
                        nama = input2.nextLine();
                        System.out.print("Masukkan Alamat : ");
                        alamat = input3.nextLine();
                        System.out.print("Masukkan Brandl : ");
                        brand = input4.nextLine();

                        sql = "UPDATE member SET nama = ? , brand = ? , alamat = ? where nosal = ?";

                        preparedStmt = conn.prepareStatement(sql);
                        preparedStmt.setString(4, nosal);
                        preparedStmt.setString(1, nama);
                        preparedStmt.setString(2, brand);
                        preparedStmt.setString(3, alamat);

                        preparedStmt.execute();

                        System.out.println("Data berhasil di update !");
                        System.out.println("==========================");

                        break;

                    case 4:
                        System.out.println("==========================");
                        System.out.println("Hapus Sales");
                        System.out.print("Masukkan Nomor Sales : ");
                        nosal = input1.nextLine();

                        sql = "DELETE FROM member WHERE nosal = ?";

                        preparedStmt = conn.prepareStatement(sql);
                        preparedStmt.setString(1, nosal);
                        preparedStmt.execute();
                        System.out.println("Data berhasil di Hapus !");
                        System.out.println("==========================");
                        break;

                    case 5:
                        System.out.println("Cari Berdasarkan ");
                        System.out.println("1. Nomor Sales");
                        System.out.println("2. Alamat");
                        System.out.println("3. Brand");
                        System.out.print("Masukan Pilihan : ");
                        Scanner input5 = new Scanner(System.in);
                        int pil = input5.nextInt();
                        if (pil == 1) {
                            System.out.println("==========================");
                            System.out.println("Cari Berdasarkan Nomor Sales");
                            System.out.print("Masukkan Nomor Sales : ");
                            nosal = input1.nextLine();

                            sql = "SELECT*FROM  member WHERE nosal = ?";

                            preparedStmt = conn.prepareStatement(sql);
                            preparedStmt.setString(1, nosal);
                            preparedStmt.execute();
                            System.out.println("Data berhasil di Temukan !");
                            System.out.println("Nomor Sales | Nama | Alamat | Brand");
                            arlist.clear();
                            i = 0;
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
                        } else if (pil == 2) {
                            System.out.println("==========================");
                            System.out.println("Cari Berdasarkan Alamat");
                            System.out.print("Masukkan Alamat : ");
                            alamat = input3.nextLine();

                            sql = "SELECT*FROM member WHERE Alamat = ?";

                            preparedStmt = conn.prepareStatement(sql);
                            preparedStmt.setString(1, alamat);
                            preparedStmt.execute();
                            System.out.println("Data berhasil di Temukan !");
                            System.out.println("Nomor Sales | Nama | Alamat | Brand");
                            arlist.clear();
                            i = 0;
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
                        } else if (pil == 3) {
                            System.out.println("==========================");
                            System.out.println("Cari Berdasarkan Brand");
                            System.out.print("Masukkan Brand : ");
                            brand = input4.nextLine();

                            sql = "SELECT*FROM member WHERE Brand = ?";

                            preparedStmt = conn.prepareStatement(sql);
                            preparedStmt.setString(1, brand);
                            preparedStmt.execute();

                            System.out.println("Data berhasil di Temukan !");
                            System.out.println("Nomor Sales | Nama | Alamat | Brand");
                            arlist.clear();
                            i = 0;
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
                        }

                        break;
                    case 6:
                        break;
                }
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
