package com.package1;




class Person {
        String firstName;
        String lastName;
        int age;
        String homeState;

        public Person(String firstName, String lastName, int age, String homeState) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.homeState = homeState;         
        }

        public String toString() {
            return "Name: " + firstName + " " + lastName + "\n" + "Age: " + age + " years\n" + "State: " + homeState + "State\n";
        }
    }