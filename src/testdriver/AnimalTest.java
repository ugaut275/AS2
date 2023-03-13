package testdriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Animals;

class AnimalTest {


private Animals animal;

@BeforeEach
public void setup() {
	animal = new Animals("SN123", "Elephant", "Toy Company", 15.99, 10, 3, "Plastic", "Medium");
}

@Test
public void testGetMaterial() {
	assertEquals("Plastic", animal.getMaterial());
}

@Test
public void testSetMaterial() {
	animal.setMaterial("Rubber");
	assertEquals("Rubber", animal.getMaterial());
}

@Test
public void testGetSize() {
	assertEquals("Medium", animal.getSize());
}

@Test
public void testSetSize() {
	animal.setSize("Large");
	assertEquals("Large", animal.getSize());
}

@Test
public void testToString() {
	assertEquals("Category: Animals S_N: SN123 Name is Elephant Brand is Toy Company Cost: 15.99 Stock: 10 Age restriction 3 doll material Plastic Size Medium", animal.toString());
}

@Test
public void testFormat() {
	assertEquals("SN123;Elephant;Toy Company;15.99;10;3;Plastic;Medium", animal.format());
}
}