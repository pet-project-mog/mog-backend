package br.com.caelum.mog.services;

import br.com.caelum.mog.adapters.Downloadable;
import br.com.caelum.mog.domains.models.*;
import br.com.caelum.mog.domains.models.Responsible;
import br.com.caelum.mog.enums.CaelumDistrict;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class DownloadsServiceTest {



    @Autowired
    private DownloadsService service;

    @Test
    void shouldGetADownloadableThroughTheOffer(){
        Customer customer = new Customer("Caelum Treinamentos");

        CourseSummaryItem defaultSummary = new CourseSummaryItem("Introduction", "Chapter 1", "Chapter 2");

        List<Course> courses = List.of(
                new Course("Course One", "one", 10, defaultSummary),
                new Course("Course Two", "two", 20, defaultSummary)
        );

        Responsible responsible = new Responsible("Bianca Cavalcante");

        CaelumDistrict caelumDistrict = CaelumDistrict.SP;
        CaelumInfo caelumInfo = new CaelumInfo(caelumDistrict);

        Offer offer = new Offer(customer, courses, LocalDate.of(2018, Month.MARCH, 25), responsible, caelumInfo);

        Downloadable downloadable = service.getDowloadableOffer(offer);

        assertAll(
                () -> assertThat(downloadable.getBody().length, greaterThan(10000)),
                () -> assertThat(downloadable.getHeaders(), hasKey(HttpHeaders.CONTENT_DISPOSITION)),
                () -> assertThat(downloadable.getHeaders().getContentDisposition().getType(), equalTo("attachment")),
                () -> assertThat(downloadable.getHeaders().getContentDisposition().getFilename(), containsString("Caelum Treinamento"))
        );


    }

}