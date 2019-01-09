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
    private Responsible responsible;
    private List<Course> courses =  new ArrayList<>();
    private LocalDate date;
    private CaelumInfo caelumInfo;

    /**
     * @deprecated frameworks only
     */
    @Deprecated(since = "1.0.0")
    private Offer() { }

    public Offer(Customer customer, List<Course> courses, LocalDate date, Responsible responsible, CaelumInfo caelumInfo){
        notNull(customer, "Customer required");
        notEmpty(courses, "Courses required");
        notNull(date, "Date required");

        this.customer = customer;
        this.responsible = responsible;
        this.courses = courses;
        this.date = date;
        this.caelumInfo = caelumInfo;
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

	public Responsible getResponsible() {
		return responsible;
	}

    public CaelumInfo getCaelumInfo() {
        return caelumInfo;
    }
}
