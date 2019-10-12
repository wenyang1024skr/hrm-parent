package cn.yangcode.hrm.doc;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * 针对于  Employee 表的文档映射
 * indexName：索引库
 * type：类型(表类型)
 * 注意：文档对象中需要哪些列 ： 1.看前端需要展示哪些列 ， 2.看条件/排序等需要哪些列
 */
@Document(indexName = "hrm" , type = "course")
public class CourseDoc {

    //对应文档的id
    @Id
    private Long id;

    @Field(type =FieldType.Text,analyzer = "ik_max_word",searchAnalyzer = "ik_max_word")    //指定为 不分词
    private String name;
    private String users;
    private String pic;
    private String courseTypeName;
    private String gradeName;
    private String tenantName;
    private String startTime;
    private String endTime;
    private String price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsers() {
        return users;
    }

    public void setUsers(String users) {
        this.users = users;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getCourseTypeName() {
        return courseTypeName;
    }

    public void setCourseTypeName(String courseTypeName) {
        this.courseTypeName = courseTypeName;
    }

    public String getGradeName() {
        return gradeName;
    }

    public void setGradeName(String gradeName) {
        this.gradeName = gradeName;
    }

    public String getTenantName() {
        return tenantName;
    }

    public void setTenantName(String tenantName) {
        this.tenantName = tenantName;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
