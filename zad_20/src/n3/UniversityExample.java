package n3;

import java.util.*;
import java.util.stream.Collectors;

public class UniversityExample {

    public static void main(String[] args) {
        Set<String> examPassedNames = new HashSet<>();
        examPassedNames.add("Иванов Иван");
        examPassedNames.add("Практикумова Яна");

        Map<Integer, String> groupNames = new HashMap<>();
        groupNames.put(2020, "2020-ГР1");
        groupNames.put(2021, "2021-ГР0");

        List<String> graduatesClub = new ArrayList<>();
        
        List<Student> students = new ArrayList<>();
        students.add(new Student("Практикумова", "Яна", "yana@yandex.ru", 2021));
        students.add(new Student("Иванов", "Иван", "ivan_ivanov@mail.ru", 2020));
        students.add(new Student("Сергеев", "Дмитрий", "iamdmitry@gmail.com", 2021));
        List<Student> graduatedStudents = students.stream()
                .filter(student -> examPassedNames.contains(student.surname + " " + student.name))
                .map(student -> {
                    student.groupName = groupNames.get(student.entranceYear);
                    return student;
                })
                .peek(student -> graduatesClub.add(student.email))
                .collect(Collectors.toList());
        for (Student student : graduatedStudents) {
            System.out.println(student);
        }

        for (String email: graduatesClub) {
            System.out.println(email);
        }

    }
}

class Student {
    String surname;
    String name;
    String email;
    int entranceYear;
    String groupName;

    public Student(String surname, String name, String email, int entranceYear) {
        this.surname = surname;
        this.name = name;
        this.email = email;
        this.entranceYear = entranceYear;
    }

    @Override
    public String toString() {
        return "Student{" +
                "surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", entranceYear=" + entranceYear +
                ", groupName='" + groupName + '\'' +
                '}';
    }
}
