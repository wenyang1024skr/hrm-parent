package cn.yangcode.hrm.Dto;

import cn.yangcode.hrm.domain.Course;
import cn.yangcode.hrm.domain.CourseDetail;
import cn.yangcode.hrm.domain.CourseMarket;

/**
 * @Auther: Wenyang
 * @Date: 2019/9/29 19:41
 * @Description: 前台封装数据的接收类
 */
public class CourseDto {

    private Course course;
    private CourseDetail courseDetail;
    private CourseMarket courseMarket;

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public CourseDetail getCourseDetail() {
        return courseDetail;
    }

    public void setCourseDetail(CourseDetail courseDetail) {
        this.courseDetail = courseDetail;
    }

    public CourseMarket getCourseMarket() {
        return courseMarket;
    }

    public void setCourseMarket(CourseMarket courseMarket) {
        this.courseMarket = courseMarket;
    }
}
