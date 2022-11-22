import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String menu = "1.Show\n" +
                "2.Add new\n" +
                "3.Delete By ID\n" +
                "4.Edit By ID\n" +
                "5. Find By name\n" +
                "6.Top 3 salary\n" +
                "7.Output birthday in current month\n" +
                "8.Exit\n" +
                "Input your choice here";

        QuanLyNhanVien quanLyNhanVien = new QuanLyNhanVien();
        while (true) {
            int choice = 0;
            System.out.println(menu);
            do {
                try {
                    choice = Integer.parseInt(scanner.nextLine());
                    break;
                } catch (InputMismatchException | NumberFormatException e) {
                    System.out.println("Phải nhập số > 0");
                }
            }while (true);

            switch (choice) {
                case 1:
                    quanLyNhanVien.show();
                    break;
                case 2:
                    quanLyNhanVien.add();
                    break;
                case 3:
                    quanLyNhanVien.deleteById();
                    break;
                case 4:
                    quanLyNhanVien.edit();
                    break;
                case 5:
                    System.out.println(quanLyNhanVien.findByName("tu"));
                    break;
                case 6:
                    quanLyNhanVien.top3Salary();
                    break;
                case 7:
                    quanLyNhanVien.birthdayInCurrentMonth(LocalDate.now().getMonthValue());
                    break;
                case 8:
                    System.exit(0);
                    break;
            }
        }
    }
}
