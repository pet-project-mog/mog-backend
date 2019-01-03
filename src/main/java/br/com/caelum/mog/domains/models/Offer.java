package br.com.caelum.mog.domains.models;

import org.springframework.context.i18n.LocaleContextHolder;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static org.springframework.util.Assert.notEmpty;
import static org.springframework.util.Assert.notNull;

public class Offer {

    private Customer customer;
    private Owner owner;
    private List<Course> courses =  new ArrayList<>();
    private LocalDate date;
    private CompanyInfo companyInfo;

    /**
     * @deprecated frameworks only
     */
    @Deprecated(since = "1.0.0")
    private Offer() { }

    public Offer(Customer customer, List<Course> courses, LocalDate date, Owner owner, CompanyInfo companyInfo){
        notNull(customer, "Customer required");
        notEmpty(courses, "Courses required");
        notNull(date, "Date required");

        this.customer = customer;
        this.owner = owner;
        this.courses = courses;
        this.date = date;
        this.companyInfo = companyInfo;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getFormattedDate(){
        Locale locale = LocaleContextHolder.getLocale();

        int day = date.getDayOfMonth();
        String month = date.getMonth().getDisplayName(TextStyle.FULL, locale);
        int year = date.getYear();

        return String.format(locale, "%s de %s de %s", day, month, year);
    }

	public Owner getOwner() {
		return owner;
	}

    public CompanyInfo getCompanyInfo() {
        return companyInfo;
    }
}
