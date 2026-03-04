package org.example;

import org.example.entity.Employee;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        LinkedList<Employee> employees = new LinkedList<>();
        employees.add(new Employee(1, "Dogancan", "Kinik"));
        employees.add(new Employee(1, "Dogancan", "Kinik"));
        employees.add(new Employee(2, "Seyyit Battal", "Arvas"));
        employees.add(new Employee(2, "Seyyit Battal", "Arvas"));
        employees.add(new Employee(3, "Anil", "Ensari"));
        employees.add(new Employee(4, "Burak", "Cevizli"));

        System.out.println(findDuplicates(employees));
        System.out.println(findUniques(employees));
        System.out.println(removeDuplicates(employees));
    }

    public static List<Employee> findDuplicates(List<Employee> employees) {
        LinkedList<Employee> duplicates = new LinkedList<>();
        HashMap<Integer, Integer> counts = new HashMap<>();
        Set<Integer> addedIds = new HashSet<>();

        for (Employee employee : employees) {
            if (employee == null) {
                continue;
            }
            int id = employee.getId();
            counts.put(id, counts.getOrDefault(id, 0) + 1);
        }

        for (Employee employee : employees) {
            if (employee == null) {
                continue;
            }
            int id = employee.getId();
            if (counts.getOrDefault(id, 0) > 1 && !addedIds.contains(id)) {
                duplicates.add(employee);
                addedIds.add(id);
            }
        }

        return duplicates;
    }

    public static Map<Integer, Employee> findUniques(List<Employee> employees) {
        HashMap<Integer, Employee> uniqueMap = new HashMap<>();

        for (Employee employee : employees) {
            if (employee == null) {
                continue;
            }
            uniqueMap.putIfAbsent(employee.getId(), employee);
        }

        return uniqueMap;
    }

    public static List<Employee> removeDuplicates(List<Employee> employees) {
        LinkedList<Employee> singles = new LinkedList<>();
        HashMap<Integer, Integer> counts = new HashMap<>();

        for (Employee employee : employees) {
            if (employee == null) {
                continue;
            }
            int id = employee.getId();
            counts.put(id, counts.getOrDefault(id, 0) + 1);
        }

        for (Employee employee : employees) {
            if (employee == null) {
                continue;
            }
            if (counts.getOrDefault(employee.getId(), 0) == 1) {
                singles.add(employee);
            }
        }

        return singles;
    }
}