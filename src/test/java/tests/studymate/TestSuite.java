package tests.studymate;


import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        LoginFunctionalityTest.class,
        CourseCreationTest.class,
        StudentTest.class,
        GroupsTest.class,
        AnnouncementsTest.class,
        ScheduleTest.class,
        LogOutFunctionalityTest.class


})
public class TestSuite {
}
