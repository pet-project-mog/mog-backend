package br.com.caelum.mog.domains.dtos;

import br.com.caelum.mog.domains.models.CompanyInfo;
import br.com.caelum.mog.domains.models.Course;
import br.com.caelum.mog.domains.models.Customer;
import br.com.caelum.mog.domains.models.Offer;
import br.com.caelum.mog.domains.models.Owner;
import br.com.caelum.mog.services.CoursesService;
import org.springframework.util.Assert;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OfferDTO {

    private String commercialName;
    private List<CourseDTO> courses = new ArrayList<>();
    private String ownerName;
    private CompanyInfo companyInfo;

	/**
     * @deprecated frameworks only
     */
    @Deprecated(since = "1.0.0")
    private OfferDTO() { }

    public OfferDTO(String commercialName, String ownerName, CourseDTO... courses) {
        Assert.hasText(commercialName, "Commercial name required");
        Assert.notEmpty(courses, "At least one course must be informed");
        Assert.hasText(ownerName, "Owner name required");

        this.commercialName = commercialName;
        this.courses = List.of(courses);
        this.ownerName = ownerName;
    }

    public String getCommercialName() {
        return commercialName;
    }

    public List<CourseDTO> getCourses() {
        return courses;
    }

    public String getOwnerName() {
		return ownerName;
	}
    
    public CompanyInfo getCompanyInfo() {
		return companyInfo;
	}

    public Offer toOffer(CoursesService service) {

        List<Course> mappedCourses = this.courses.stream().map(dto -> dto.toCourse(service)).collect(Collectors.toList());

        Customer customer = new Customer(commercialName);

        Owner owner = new Owner(ownerName);
        
        new CompanyInfo("unidade", "email");

		return new Offer(customer, mappedCourses, LocalDate.now(), owner);
    }

}
