/***
 * Excerpted from "Programming Scala",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/vsscala for more book information.
***/
//Java code
package intermixing;

public class Investment {                                        
  private String investmentName;
  private InvestmentType investmentType;
             
  public Investment(String name, InvestmentType type) {
    investmentName = name;
    investmentType = type;
  } 
  
  public int yield() { return 0; }
}
