import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuanLyNhanVien {
    static Scanner scanner = new Scanner(System.in);
    private List<NhanVien> dsNhanVien = new ArrayList<>();

    public void show() {
        System.out.println("Danh sach co " + dsNhanVien.size() + "nhan vien: ");
        for (int i = 0; i < dsNhanVien.size(); i++) {
            System.out.println(dsNhanVien.get(i).toString());
        }
    }

    public void add() {
        NhanVien newNhanVien = new NhanVien();
        newNhanVien.inputInfor();
        dsNhanVien.add(newNhanVien);
    }

    public int findIndexById(int id) {
        for (int i = 0; i < dsNhanVien.size(); i++) {
            if (dsNhanVien.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    public void edit() {
        System.out.println("Nhập id cần sửa: ");
        int id = Integer.parseInt(scanner.nextLine());
        int index = findIndexById(id);
        if (index == -1) {
            System.out.println("Không tìm thấy!");
        } else {
            dsNhanVien.get(index).inputInfor();
        }
    }
     public void deleteById() {
        int id, index;
        do {
            try {
                System.out.println("Nhập id cần xóa: ");
                id = Integer.parseInt(scanner.nextLine());
                index = findIndexById(id);
                if (index == -1) {
                    System.out.println("Không tìm thấy!");
                    break;
                } else {
                    dsNhanVien.remove(index);
                    System.out.println("Xóa thành công!");
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Chỉ nhập số, không nhập chữ!");
            }
        } while (true);
     }

     public ArrayList<NhanVien> findByName(String name) {
         ArrayList<NhanVien> list = new ArrayList<>();
         for (int i = 0; i < dsNhanVien.size(); i++) {
             if (dsNhanVien.get(i).getName().equals(name)) {
                 list.add(dsNhanVien.get(i));
             }
         }
         return list;
     }

     public void sortBySalary() {
         dsNhanVien.sort(NhanVien::compareTo);
     }
     public void top3Salary() {
        if (dsNhanVien.size() < 3) {
            System.out.println("?");
            return;
        }
         sortBySalary();

         System.out.println(dsNhanVien.get(0).toString());
         System.out.println(dsNhanVien.get(1).toString());
         System.out.println(dsNhanVien.get(2).toString());
     }

    public void birthdayInCurrentMonth(int month) {
        for (int i = 0; i < dsNhanVien.size(); i++) {
            if (dsNhanVien.get(i).getBirthday().getMonthValue() == month) {
                System.out.println(dsNhanVien.get(i).toString());
            }
        }
    }
}
