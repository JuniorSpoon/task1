package com.artem;

public class Main {

    public static void main(String[] args) {

    	Person grandGrandMother = new Person("Pelageya", null, null);
		Person grandMother = new Person("Victoria", grandGrandMother, null);
		Person grandMother2 = new Person("Aspasia", null, null);
		Person grandad = new Person("Vasily", null, null);
		Person grandad2 = new Person("Arseny", null, null);
    	Person mother = new Person("Ana", grandMother, grandad);
	    Person father = new Person("Alexander", grandMother2, grandad2);
	    Person son = new Person("Gennady", mother, father);
		son.printFamilyNames();
    }
}
