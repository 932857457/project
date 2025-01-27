//存放系统常量。它包括了与JWT（JSON Web Token）相关的错误代码和配置参数
package com.diycomputersystem.constant;


public class SystemConstant {

    /**
     * token
     */
    public static final int JWT_ERRCODE_NULL = 4000;			//Token不存在
    public static final int JWT_ERRCODE_EXPIRE = 4001;			//Token过期
    public static final int JWT_ERRCODE_FAIL = 4002;			//验证不通过

    /**
     * JWT
     */
    public static final String JWT_SECERT = "ac897927ab9c931bb97ba3abfe6f0086";			//密匙
    public static final long JWT_TTL = 24*60 * 60 * 1000;									//token有效时间
}
