/***
 * Excerpted from "Programming Scala",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/vsscala for more book information.
***/
//Java code

package javaUseScala;
import automobiles.Car;

public class UseCar {
  public static void main(String[] args) {
    Car car = new Car(2009);
    
    System.out.println(car);
    car.drive(10);
    System.out.println(car);
  }
}
