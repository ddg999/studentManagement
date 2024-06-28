package ver1;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainTest1 {

	private static final Logger LOGGER = Logger.getLogger(MainTest1.class.getName());

	public static void main(String[] args) {

		StudentImpl studentImpl = new StudentImpl();
		try {
			while (true) {
				try {
					System.out.println("========= 학생 정보 시스템 =========");
					System.out.println("1.추가 2.조회 3.수정 4.삭제 0.종료");
					Scanner sc = new Scanner(System.in);
					int choice = sc.nextInt();
					if (choice == 0) {
						System.out.println("프로그램을 종료합니다");
						break;
					} else if (choice == 1) {
						System.out.print("이름을 입력하세요 : ");
						String name = sc.next();
						System.out.print("나이를 입력하세요 : ");
						int age = sc.nextInt();
						System.out.print("이메일을 입력하세요 : ");
						String email = sc.next();
						studentImpl.addStudent(name, age, email);
					} else if (choice == 2) {
						System.out.println("1.전체조회 2.학번으로조회 3.이름으로조회");
						int choice2 = sc.nextInt();
						if (choice2 == 1) {
							studentImpl.infoStudent();
						} else if (choice2 == 2) {
							System.out.print("조회할 학번을 입력하세요 : ");
							int id = sc.nextInt();
							studentImpl.infoStudent(id);
						} else if (choice2 == 3) {
							System.out.print("조회할 이름을 입력하세요 : ");
							String name = sc.next();
							studentImpl.infoStudent(name);
						}
					} else if (choice == 3) {
						System.out.println("1.학번으로 수정 2.이름으로 수정");
						int choice3 = sc.nextInt();
						if (choice3 == 1) {
							System.out.print("수정할 학생의 학번을 입력하세요 : ");
							int id = sc.nextInt();
							if (!studentImpl.infoStudent(id)) {
								System.out.println("====================================");
								System.out.println("수정할 학번의 학생이 없습니다");
								continue;
							}
							System.out.print("새로운 이름을 입력하세요 : ");
							String name = sc.next();
							System.out.print("새로운 나이를 입력하세요 : ");
							int age = sc.nextInt();
							System.out.print("새로운 이메일을 입력하세요 : ");
							String email = sc.next();
							studentImpl.modifyStudent(id, name, age, email);
						} else if (choice3 == 2) {
							System.out.print("수정할 학생의 이름을 입력하세요 : ");
							String beforeName = sc.next();
							if (!studentImpl.infoStudent(beforeName)) {
								System.out.println("====================================");
								System.out.println("수정할 이름의 학생이 없습니다");
								continue;
							}
							System.out.print("새로운 이름을 입력하세요 : ");
							String name = sc.next();
							System.out.print("새로운 나이를 입력하세요 : ");
							int age = sc.nextInt();
							System.out.print("새로운 이메일을 입력하세요 : ");
							String email = sc.next();
							studentImpl.modifyStudent(beforeName, name, age, email);
						}
					} else if (choice == 4) {
						System.out.println("1.전체삭제 2.학번으로삭제 3.이름으로삭제");
						int choice4 = sc.nextInt();
						if (choice4 == 1) {
							System.out.print("전체 학생정보가 삭제됩니다. 정말 삭제하시겠습니까?(Y/N)");
							String yn = sc.next();
							if (yn.equalsIgnoreCase("Y")) {
								studentImpl.deleteStudent();
							} else {
								System.out.println("삭제가 취소되었습니다.");
								continue;
							}
						} else if (choice4 == 2) {
							System.out.print("삭제할 학생의 학번을 입력하세요 : ");
							int id = sc.nextInt();
							if (!studentImpl.infoStudent(id)) {
								System.out.println("====================================");
								System.out.println("삭제할 학번의 학생이 없습니다");
								continue;
							}
							System.out.println(id + " 학번의 정보를 정말 삭제하시겠습까?(Y/N)");
							String yn = sc.next();
							if (yn.equalsIgnoreCase("Y")) {
								studentImpl.deleteStudent(id);
							} else {
								System.out.println("삭제가 취소되었습니다.");
								continue;
							}
						} else if (choice4 == 3) {
							System.out.print("삭제할 학생의 이름을 입력하세요 : ");
							String name = sc.next();
							if (!studentImpl.infoStudent(name)) {
								System.out.println("====================================");
								System.out.println("삭제할 이름의 학생이 없습니다");
								continue;
							}
							System.out.println(name + " 학생의 정보를 정말 삭제하시겠습까?(Y/N)");
							String yn = sc.next();
							if (yn.equalsIgnoreCase("Y")) {
								studentImpl.deleteStudent(name);
							} else {
								System.out.println("삭제가 취소되었습니다.");
								continue;
							}
						}
					} else {
						System.out.println("잘못된 입력입니다");
					}
				} catch (InputMismatchException e) {
					System.out.println("올바른 숫자를 입력하세요");
				}
			}
		} catch (SQLException e) {
			LOGGER.log(Level.INFO, "MySQL 연결 오류");
			e.printStackTrace();
		}
	}
}
