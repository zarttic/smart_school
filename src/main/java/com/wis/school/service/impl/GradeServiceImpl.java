/**
 * @Description
 * @author liyajun
 * @create 2022-09-27 20:25
 */

package com.wis.school.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wis.school.mapper.GradeMapper;
import com.wis.school.pojo.Grade;
import com.wis.school.service.GradeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 级服务impl
 *
 * @author liyaj
 * @date 2022/09/27
 */
@Service("/gradeServiceImpl")
@Transactional
public class GradeServiceImpl extends ServiceImpl<GradeMapper, Grade> implements GradeService {

}
