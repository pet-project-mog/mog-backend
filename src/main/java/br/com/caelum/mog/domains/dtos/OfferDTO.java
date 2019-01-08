package br.com.caelum.mog.domains.dtos;

import br.com.caelum.mog.domains.models.CompanyInfo;
import br.com.caelum.mog.domains.models.Course;
import br.com.caelum.mog.domains.models.Customer;
import br.com.caelum.mog.domains.models.Offer;
import br.com.caelum.mog.domains.models.Owner;
import br.com.caelum.mog.enums.CompanyUnit;
import br.com.caelum.mog.services.CoursesService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.util.Assert.hasText;
import static org.springframework.util.Assert.notEmpty;

public class OfferDTO {

    private String commercialName;
    private String ownerName;
    private String companyUnit;
    private List<CourseDTO> courses = new ArrayList<>();

	/**
     * @deprecated frameworks only
     */
    @Deprecated(since = "1.0.0")
    private OfferDTO() { }

    public OfferDTO(String commercialName, String ownerName, String companyUnit, CourseDTO... courses) {
        hasText(commercialName, "Commercial name required");
        notEmpty(courses, "At least one course must be informed");
        hasText(ownerName, "Owner name required");
        hasText(ownerName, "ComapanyUnit required");


        this.commercialName = commercialName;
        this.courses = List.of(courses);
        this.ownerName = ownerName;
        this.companyUnit = companyUnit;
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

    public String getCompanyUnit() {
        return companyUnit;
    }


    public Offer toOffer(CoursesService service) {

        List<Course> mappedCourses = this.courses.stream().map(dto -> dto.toCourse(service)).collect(Collectors.toList());

        Customer customer = new Customer(commercialName);
        Owner owner = new Owner(ownerName);

        CompanyUnit unit = CompanyUnit.valueOf(companyUnit);
        CompanyInfo companyInfo = new CompanyInfo(unit);

		return new Offer(customer, mappedCourses, LocalDate.now(), owner, companyInfo);
    }

}
