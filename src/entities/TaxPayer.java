package entities;

public class TaxPayer {

	private Double salaryIncome; // salario anual
	private Double servicesIncome; // prestação de serviço anual
	private Double capitalIncome; // ganho de capital anual
	private Double healthSpending; // gastos medicos
	private Double educationSpending; // gastos educacionais

	public void TaxPayer() {
	}

	public TaxPayer(Double salaryIncome, Double servicesIncome, Double capitalIncome, Double healthSpending,
			Double educationSpending) {
		this.salaryIncome = salaryIncome;
		this.servicesIncome = servicesIncome;
		this.capitalIncome = capitalIncome;
		this.healthSpending = healthSpending;
		this.educationSpending = educationSpending;
	}

	public Double getSalaryIncome() {
		return salaryIncome;
	}

	public void setSalaryIncome(Double salaryIncome) {
		this.salaryIncome = salaryIncome;
	}

	public Double getServicesIncome() {
		return servicesIncome;
	}

	public void setServicesIncome(Double servicesIncome) {
		this.servicesIncome = servicesIncome;
	}

	public Double getCapitalIncome() {
		return capitalIncome;
	}

	public void setCapitalIncome(Double capitalIncome) {
		this.capitalIncome = capitalIncome;
	}

	public Double getHealthSpending() {
		return healthSpending;
	}

	public void setHealthSpending(Double healthSpending) {
		this.healthSpending = healthSpending;
	}

	public Double getEducationSpending() {
		return educationSpending;
	}

	public void setEducationSpending(Double educationSpending) {
		this.educationSpending = educationSpending;
	}

	// Calculo Renda

	public double salaryTax() {

		double salaryTax = salaryIncome / 12;

		if (salaryTax >= 5000.00) {

			return salaryIncome * 0.20;

		} else if (salaryTax > 3000.00) {

			return salaryIncome * 0.10;

		} else {

			return 0.0;
		}
	}

	public double servicesTax() {

		if (servicesIncome > 0) {

			return servicesIncome * 0.15;

		} else {

			return 0.0;
		}
	}

	public double capitalTax() {

		if (capitalIncome > 0) {

			return capitalIncome * 0.20;

		} else {

			return 0.0;
		}
	}

	// Calculo Dedução

	public double grossTax() {
		return capitalTax() + servicesTax() + salaryTax();
	}

	// CALCULOS FINAIS

	public double taxRebate() {

		double deductibleExpense = healthSpending + educationSpending;

		double maximumDeductible = grossTax() * 0.30;

		if (deductibleExpense >= maximumDeductible) {

			return maximumDeductible;

		} else {

			return deductibleExpense;
		}
	}

	public double netTax() {

		return grossTax() - taxRebate();
	}
}