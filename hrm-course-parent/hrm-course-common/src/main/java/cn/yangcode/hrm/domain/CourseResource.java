package cn.yangcode.hrm.domain;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author wenyang
 * @since 2019-09-29
 */
@TableName("t_course_resource")
public class CourseResource extends Model<CourseResource> {

    private static final long serialVersionUID = 1L;

    /**
     * 课程id
     */
    @TableField("course_id")
    private Long courseId;
    /**
     * 图片id
     */
    private String resources;
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;


    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public String getResources() {
        return resources;
    }

    public void setResources(String resources) {
        this.resources = resources;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "CourseResource{" +
        ", courseId=" + courseId +
        ", resources=" + resources +
        ", id=" + id +
        "}";
    }
}
