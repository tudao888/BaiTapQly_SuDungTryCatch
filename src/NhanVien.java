import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class NhanVien implements Comparable<NhanVien> {
    static int genID = 1;
    private int id;
    private String name;
    private double salary;
    private String gender;
    private LocalDate birthday;

    public NhanVien() {
    }

    public NhanVien(int id, String name, double salary, String gender, LocalDate birthday) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.gender = gender;
        this.birthday = birthday;
    }

    public void inputInfor() {
        Scanner scanner = new Scanner(System.in);
        if (id <= 0) {
            this.id = NhanVien.genID;
            NhanVien.genID++;
        }

        System.out.println("Input name");
        this.name = scanner.nextLine();

        do {
            try {
                System.out.println("Input luong");
                this.salary = Double.parseDouble(scanner.nextLine());
                if (salary >= 0) {
                    break;
                } else {
                    System.out.println("Nhập lại bằng số > 0");
                }
            } catch (NumberFormatException e) {
                System.out.println("Nhập lại bằng số!");
            }
        } while (true);

        do {
            System.out.println("Input gender");
            this.gender = scanner.nextLine();
            if (gender.equals("nam") | gender.equals("nu")) {
                break;
            } else {
                System.out.println("Chỉ nhập (nam) hoặc (nu)!");
            }
        } while (true);


        int day, month, year;

        do {
            System.out.println("Input date of birth");
            day = Integer.parseInt(scanner.nextLine());
            if (day >= 1 && day <= 31) {
                break;
            } else {
                System.out.println("Nhập lại ngày sinh! (Ngày sinh > 1 và < 31)");
            }
        } while (true);

        do {
            System.out.println("Input month of birth");
            month = Integer.parseInt(scanner.nextLine());
            if (month >= 1 && month <= 12) {
                break;
            } else {
                System.out.println("Nhập vào tháng từ 1 tới 12");
            }
        } while (true);

        do {
            System.out.println("Input year of birth");
            year = Integer.parseInt(scanner.nextLine());
            if (year > 1990 && year < 2099) {
                break;
            } else {
                System.out.println("Nhập vào năm sinh từ 1990 tới 2099");
            }
        } while (true);
        this.birthday = LocalDate.of(year, month, day);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "NhanVien{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", gender='" + gender + '\'' +
                ", birthday=" + birthday +
                '}';
    }

    @Override
    public int compareTo(NhanVien nhanVien) {
        if (this.salary > nhanVien.getSalary()) {
            return 1;
        } else if (this.salary < nhanVien.getSalary()) {
            return -1;
        } else {
            return 0;
        }
    }
}