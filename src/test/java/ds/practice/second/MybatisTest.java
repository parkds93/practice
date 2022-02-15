package ds.practice.second;

import java.sql.Connection;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations ="file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class MybatisTest {
    
	@Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    @Test
    public void testFactory(){
        System.out.println(sqlSessionTemplate);
    }

    @Test
    public void testSession() throws Exception{
        try{
            Connection connection = sqlSessionTemplate.getConnection();
            System.out.println(connection);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
