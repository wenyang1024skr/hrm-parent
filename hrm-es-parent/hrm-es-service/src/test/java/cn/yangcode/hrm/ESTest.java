package cn.yangcode.hrm;

import cn.yangcode.hrm.doc.CourseDoc;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = EsServiceApplication.class)
public class ESTest {

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    //初始化
    @Test
    public void testCreateIndex() {
        //创建索引
        elasticsearchTemplate.createIndex(CourseDoc.class);
        //做文档映射
        elasticsearchTemplate.putMapping(CourseDoc.class);
    }

}