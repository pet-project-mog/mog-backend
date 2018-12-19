package br.com.caelum.mog.domains.models;

import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.util.Assert;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Offer {

    private Customer customer;
    private Owner owner;
    private List<Course> courses =  new ArrayList<>();
    private LocalDate date;


    /**
     * @deprecated frameworks only
     */
    @Deprecated(since = "1.0.0")
    private Offer() { }

    public Offer(Customer customer, List<Course> courses, LocalDate date, Owner owner){
        Assert.notNull(customer, "Customer required");
        Assert.notEmpty(courses, "Courses required");
        Assert.notNull(date, "Date required");

        this.customer = customer;
        this.owner = owner;
        this.courses = courses;
        this.date = date;
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
}
