package com.artem;

import com.artem.utils.StringUtils;

import java.util.Optional;

public class Person {

    private String name;
    private Person mother;
    private Person father;

    public Person(String name, Person mother, Person father) {
        this.name = name;
        this.mother = mother;
        this.father = father;
    }

    public void printFamilyNames() {
        StringBuilder sb = new StringBuilder();
        retrieveAncestors(this, sb);
        String ancestors = sb.toString();
        if(StringUtils.isStringNotNullOrNotEmpty(ancestors)){
            ancestors = ancestors.substring(0, ancestors.length() -2);
        }else{
            ancestors = "No data";
        }
        System.out.println("name: " + name);
        System.out.print("Ancestors: " + ancestors);

    }

    public void retrieveAncestors(Person person, StringBuilder sb) {
        if (person == null)
            return;
        if (StringUtils.isStringNotNullOrNotEmpty(Optional.of(person).map(Person::getMother).map(Person::getName).orElse(null)) ||
                StringUtils.isStringNotNullOrNotEmpty(Optional.of(person).map(Person::getFather).map(Person::getName).orElse(null))
        ) {
            sb.append("(");
            sb.append(Optional.of(person).map(Person::getMother).map(Person::getName).orElse("unknown"));
            sb.append(", ");
            sb.append(Optional.of(person).map(Person::getFather).map(Person::getName).orElse("unknown"));
            sb.append("), ");
        }
        retrieveAncestors(Optional.of(person).map(Person::getMother).orElse(null), sb);
        retrieveAncestors(Optional.of(person).map(Person::getFather).orElse(null), sb);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person getMother() {
        return mother;
    }

    public void setMother(Person mother) {
        this.mother = mother;
    }

    public Person getFather() {
        return father;
    }

    public void setFather(Person father) {
        this.father = father;
    }
}
