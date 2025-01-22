package org.example;


import org.example.entity.Employee;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello World!");

        List<Employee> employees=new ArrayList<>();
        employees.add(new Employee(1, "Ahmet", "Yılmaz"));
        employees.add(new Employee(2, "Ayşe", "Kara"));
        employees.add(new Employee(2, "Ayşe", "Kara"));
        employees.add(new Employee(3, "Mehmet", "Demir"));
        employees.add(new Employee(4, "Fatma", "Şahin"));
        employees.add(new Employee(1, "Ahmet", "Yılmaz"));
    }


    public static  List<Employee> findDuplicates(List<Employee> list){
        Set<Employee> seen=new HashSet<>();
        List<Employee> duplicates=new ArrayList<>();

        for(Employee emp: list) {
            if(!seen.add(emp)){
                if(!duplicates.contains(emp)){
                    duplicates.add(emp);
                }
            }
        }
        return duplicates;
    }

    public static Map<Integer, Employee> findUniques(List<Employee> list) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        Map<Integer, Employee> uniqueMap = new HashMap<>();

        for (Employee emp : list) {
            if (emp == null) { // Null kontrolü
                continue;
            }
            frequencyMap.put(emp.getId(), frequencyMap.getOrDefault(emp.getId(), 0) + 1);
        }

        for (Employee emp : list) {
            if (emp == null) { // Null kontrolü
                continue;
            }
            if (frequencyMap.get(emp.getId()) == 1 || !uniqueMap.containsKey(emp.getId())) {
                uniqueMap.put(emp.getId(), emp);
            }
        }
        return uniqueMap;
    }

    public static List<Employee> removeDuplicates(List<Employee> list) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        List<Employee> result = new ArrayList<>();

        for (Employee emp : list) {
            if (emp == null) { // Null kontrolü
                continue;
            }
            frequencyMap.put(emp.getId(), frequencyMap.getOrDefault(emp.getId(), 0) + 1);
        }

        for (Employee emp : list) {
            if (emp != null && frequencyMap.get(emp.getId()) == 1) {
                result.add(emp);
            }
        }
        return result;
    }


}