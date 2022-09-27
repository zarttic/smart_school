/**
 * @Description
 * @author liyajun
 * @create 2022-09-27 22:21
 */

package com.wis.school.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TokenBody {
    Long userId;
    String userName;
    Integer userType;
}
