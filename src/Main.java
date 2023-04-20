import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonWriter;

class mahasiswa implements Comparable<mahasiswa>{
    private int nim;
    private String nama;
    private String jurusan;
    private int angkatan;

    mahasiswa(int nim, String nama, String jurusan, int angkatan) {
        this.nim = nim;
        this.nama = nama;
        this.jurusan = jurusan;
        this.angkatan = angkatan;
    }

    public int getnim() {
        return nim;
    }

    public String getnama() {
        return nama;
    }

    public String getjurusan() {
        return jurusan;
    }

    public int getangkatan() {
        return angkatan;
    }

    public String toString() {
        return nim + " " + nama + " " + jurusan + " " + angkatan;
    }

    @Override
    public int compareTo(mahasiswa o) {
        return this.nama.compareTo(o.nama);
    }
}

class Main {
    public static void main(String[] args) {
        List<mahasiswa> M = new ArrayList<mahasiswa>();
        Scanner sc1 = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);
        int menu;

        do {
            System.out.println("=========MENU=========");
            System.out.println("1. Tambah data mahasiswa");
            System.out.println("2. Tampilkan data mahasiswa");
            System.out.println("3. Cari data mahasiswa");
            System.out.println("4. Hapus data mahasiswa");
            System.out.println("5. Edit data mahasiswa");
            System.out.println("6. Sorting data mahasiswa");
            System.out.println("7. Export data mahasiswa");
            System.out.println("0 jika keluar ");
            System.out.print("Pilihan Anda: ");
            menu = sc1.nextInt();

            switch (menu) {
                case 1:
                    System.out.print("Masukkan NIM Mahasiswa: ");
                    int nim = sc1.nextInt();
                    System.out.print("Masukkan Nama Mahasiswa: ");
                    String nama = sc2.nextLine();
                    System.out.print("Masukkan Jurusan Mahasiswa: ");
                    String jurusan = sc2.nextLine();
                    System.out.print("Masukkan Angkatan Mahasiswa: ");
                    int angkatan = sc1.nextInt();

                    M.add(new mahasiswa(nim, nama, jurusan, angkatan));
                    break;
                case 2:
                    System.out.println("----------------------");
                    System.out.println("====Data Mahasiswa====");
                    Iterator<mahasiswa> i = M.iterator();
                    int no = 1;
                    while (i.hasNext()) {
                        mahasiswa e = i.next();
                        System.out.print("No." + no + " ");
                        System.out.println(e);
                        no++;
                    }
                    System.out.println("====Data Mahasiswa====");
                    System.out.println("----------------------");
                    break;
                case 3:
                    Boolean cari = false;
                    System.out.println("1. Cari Berdasarkan NIM");
                    System.out.println("2. Cari Berdasarkan Nama");
                    System.out.println("3. Cari Berdasarkan Jurusan");
                    System.out.println("4. Cari Berdasarkan Angkatan");
                    System.out.print("Pilihan: ");
                    String pilcari = sc2.nextLine();
                    if (pilcari.equals("1")) {
                        System.out.print("Masukkan NIM Mahasiswa: ");
                        int carinim = sc1.nextInt();
                        System.out.println("----------------------");
                        System.out.println("====Data Mahasiswa====");
                        i = M.iterator();
                        while (i.hasNext()) {
                            mahasiswa e = i.next();
                            if (e.getnim() == carinim) {
                                System.out.println(e);
                                cari = true;
                            }
                        }
                        if (!cari) {
                            System.out.println("Data Tidak Ditemukan/Tidak Ada");
                        }
                        System.out.println("====Data Mahasiswa====");
                        System.out.println("----------------------");
                    } else if (pilcari.equals("2")) {
                        System.out.print("Masukkan Nama Mahasiswa: ");
                        String carinama = sc2.nextLine();
                        System.out.println("----------------------");
                        System.out.println("====Data Mahasiswa====");
                        i = M.iterator();
                        while (i.hasNext()) {
                            mahasiswa e = i.next();
                            if (e.getnama() == carinama) {
                                System.out.println(e);
                                cari = true;
                            }
                        }
                        if (!cari) {
                            System.out.println("Data Tidak Ditemukan/Tidak Ada");
                        }
                        System.out.println("====Data Mahasiswa====");
                        System.out.println("----------------------");
                    } else if (pilcari.equals("3")){
                        System.out.print("Masukkan Jurusan Mahasiswa: ");
                        String carijurusan = sc2.nextLine();
                        System.out.println("----------------------");
                        System.out.println("====Data Mahasiswa====");
                        i = M.iterator();
                        while (i.hasNext()) {
                            mahasiswa e = i.next();
                            if (e.getjurusan() == carijurusan) {
                                System.out.println(e);
                                cari = true;
                            }
                        }
                        if (!cari) {
                            System.out.println("Data Tidak Ditemukan/Tidak Ada");
                        }
                        System.out.println("====Data Mahasiswa====");
                        System.out.println("----------------------");
                    } else if(pilcari.equals("4")){
                        System.out.print("Masukkan Angkatan Mahasiswa: ");
                        int cariangkatan = sc1.nextInt();
                        System.out.println("----------------------");
                        System.out.println("====Data Mahasiswa====");
                        i = M.iterator();
                        while (i.hasNext()) {
                            mahasiswa e = i.next();
                            if (e.getangkatan() == cariangkatan) {
                                System.out.println(e);
                                cari = true;
                            }
                        }
                        if (!cari) {
                            System.out.println("Data Tidak Ditemukan/Tidak Ada");
                        }
                        System.out.println("====Data Mahasiswa====");
                        System.out.println("----------------------");
                    }
                    break;
                case 4:
                    cari = false;
                    System.out.print("Hapus Data Mahasiswa Berdasarkan NIM: ");
                    int carinim = sc1.nextInt();
                    System.out.println("----------------------");
                    i = M.iterator();
                    while (i.hasNext()) {
                        mahasiswa e = i.next();
                        if (e.getnim() == carinim) {
                            i.remove();
                            cari = true;
                        }
                    }
                    if (!cari) {
                        System.out.println("Data Tidak Ditemukan/Tidak Ada");
                    } else {
                        System.out.println("Data Berhasil Dihapus");
                    }
                    System.out.println("----------------------");
                    break;
                case 5:
                    cari = false;
                    System.out.print("Edit Data Mahasiswa Berdasarkan NIM: ");
                    carinim = sc1.nextInt();
                    System.out.println("----------------------");
                    ListIterator<mahasiswa> li = M.listIterator();
                    while (li.hasNext()) {
                        mahasiswa e = li.next();
                        if (e.getnim() == carinim) {
                            System.out.print("Masukkan Nama Baru Mahasiswa: ");
                            nama = sc2.nextLine();
                            System.out.print("Masukkan Jurusan Baru Mahasiswa: ");
                            jurusan = sc2.nextLine();
                            System.out.print("Masukkan Angkatan Baru Mahasiswa: ");
                            angkatan = sc1.nextInt();
                            li.set(new mahasiswa(carinim, nama, jurusan, angkatan));
                            cari = true;
                        }
                    }
                    if (!cari) {
                        System.out.println("Data Tidak Ditemukan/Tidak Ada");
                    } else {
                        System.out.println("Data Berhasil Diubah");
                    }
                    System.out.println("----------------------");
                    break;
                    case 6:
                        Collections.sort(M);

                    // tampilkan hasil sorting
                        for (mahasiswa m : M) {
                            System.out.println(m.getnim() + " " + m.getnama() + " " + m.getjurusan() + " " + m.getangkatan());
                        }
                    break;
                    case 7:
                        // build JSON object
                        JsonObjectBuilder builder = Json.createObjectBuilder();
                        JsonArrayBuilder mahasiswaArrayBuilder = Json.createArrayBuilder();
                        for (mahasiswa m : M) {
                            JsonObjectBuilder mahasiswaBuilder = Json.createObjectBuilder();
                            mahasiswaBuilder.add("nim", m.getnim())
                                            .add("nama", m.getnama())
                                            .add("alamat", m.getjurusan())
                                            .add("angkatan", m.getangkatan());
                            mahasiswaArrayBuilder.add(mahasiswaBuilder.build());
                        }
                        builder.add("mahasiswas", mahasiswaArrayBuilder.build());
                        JsonObject mahasiswaJsonObject = builder.build();

                        // write JSON object to file
                        try (JsonWriter jsonWriter = Json.createWriter(new FileWriter("mahasiswas.json"))) {
                            jsonWriter.writeObject(mahasiswaJsonObject);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        break;
                default:
                    System.err.println("Inputan Salah");
                    break;
            }
        } while (menu != 0);
    }

    
}