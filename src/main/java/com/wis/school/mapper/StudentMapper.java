/**
 * @Description
 * @author liyajun
 * @create 2022-09-27 20:03
 */


package com.wis.school.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wis.school.pojo.Student;
import org.springframework.stereotype.Repository;

/**
 * 学生映射器
 *
 * @author liyaj
 * @date 2022/09/27
 */
@Repository
public interface StudentMapper extends BaseMapper<Student> {

}
