package mx.gps.medical.schedule.cucumber;

import io.cucumber.spring.CucumberContextConfiguration;
import mx.gps.medical.schedule.JmedicalApp;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;

@CucumberContextConfiguration
@SpringBootTest(classes = JmedicalApp.class)
@WebAppConfiguration
public class CucumberTestContextConfiguration {}
