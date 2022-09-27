/**
 * @Description
 * @author liyajun
 * @create 2022-09-27 20:24
 */

package com.wis.school.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wis.school.mapper.ClazzMapper;
import com.wis.school.pojo.Clazz;
import com.wis.school.service.ClazzService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * impl clazz服务
 *
 * @author liyaj
 * @date 2022/09/27
 */
@Service("clazzServiceImpl")
@Transactional
public class ClazzServiceImpl extends ServiceImpl<ClazzMapper, Clazz> implements ClazzService {
}
