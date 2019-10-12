package cn.yangcode.hrm.repository;


import cn.yangcode.hrm.doc.CourseDoc;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseElasticsearchRepository extends ElasticsearchRepository<CourseDoc,Long> {
}
