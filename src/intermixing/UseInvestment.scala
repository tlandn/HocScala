import intermixing._

object UseInvestment {
  def main(args: Array[String]) {
    val investment = new Investment("XYZ Corporation" , InvestmentType.STOCK)
    println(investment.getClass())
    
    
  }
}
