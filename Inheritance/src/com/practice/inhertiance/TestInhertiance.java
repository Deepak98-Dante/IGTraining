package com.practice.inhertiance;

public class TestInhertiance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Animal a=new Dog();
		a.eat();
		Dog d=new Dog();
		//Dog d=(Dog)new Animal();
		d.bark();
		d.eat();
		
		BabyDog bd=new BabyDog();
		bd.eat();
		bd.bark();
		bd.weep();
	}

}
